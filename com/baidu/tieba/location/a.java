package com.baidu.tieba.location;

import android.content.Context;
import android.location.Address;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.c.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
import java.util.Locale;
/* loaded from: classes10.dex */
public class a implements com.baidu.adp.lib.c.b {
    private static a idU = null;
    private LocationClient cvk;
    private C0553a idX;
    private LocationClientOption idY;
    private Address lastAddress;
    private Context mContext;
    private boolean vy = true;
    private String idV = "";
    private a.b idW = null;
    private long lastLocationTime = 0;
    private boolean idZ = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.k.a.Ex() || ab.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.c.a.fK().a(a.cdJ());
                        } else {
                            com.baidu.adp.lib.c.a.fK().b(a.cdJ());
                        }
                    }
                }
            }
        });
    }

    public static a cdJ() {
        if (idU == null) {
            synchronized (a.class) {
                if (idU == null) {
                    idU = new a();
                }
            }
        }
        return idU;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.c.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.idW = bVar;
        this.idV = "baidu";
        if (this.vy) {
            try {
                this.cvk = new LocationClient(this.mContext);
                this.idY = new LocationClientOption();
                this.idY.setOpenGps(true);
                this.idY.setIgnoreKillProcess(true);
                this.idY.setProdName(this.idV);
                this.idY.setAddrType(SchemeCollecter.CLASSIFY_ALL);
                this.idY.setCoorType("bd09ll");
                this.idX = new C0553a();
                this.cvk.registerLocationListener(this.idX);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void startLocation(boolean z) {
        if ((!com.baidu.k.a.Ex() || ab.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.vy && this.cvk != null) {
            try {
                this.idZ = z;
                if (z) {
                    this.idY.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.cvk.setLocOption(this.idY);
                if (!this.cvk.isStarted()) {
                    this.cvk.start();
                }
                this.cvk.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                stopLocation();
                if (this.idW != null) {
                    this.idW.onProviderGetLocation(5, "", this.lastAddress, this.lastLocationTime, this.idZ);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void destroy() {
        stopLocation();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0553a implements BDLocationListener {
        private C0553a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.k.a.Ex() || ab.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.stopLocation();
                a.this.lastAddress = new Address(Locale.getDefault());
                a.this.lastAddress.setLatitude(bDLocation.getLatitude());
                a.this.lastAddress.setLongitude(bDLocation.getLongitude());
                a.this.lastAddress.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                bundle.putDouble("altitude", bDLocation.getAltitude());
                bundle.putFloat("speed", bDLocation.getSpeed());
                bundle.putString("cityCode", bDLocation.getCityCode());
                bundle.putString("street", bDLocation.getStreet());
                bundle.putString("streetNumber", bDLocation.getStreetNumber());
                bundle.putString("province", bDLocation.getProvince());
                a.this.lastAddress.setExtras(bundle);
                a.this.lastLocationTime = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    a.this.lastAddress.setAddressLine(0, stringBuffer.toString());
                }
                if (a.this.idW != null) {
                    a.this.idW.onProviderGetLocation(0, "", a.this.lastAddress, a.this.lastLocationTime, a.this.idZ);
                    com.baidu.tieba.recapp.d.a.cDk().CE(String.valueOf(a.this.lastAddress.getLatitude()));
                    com.baidu.tieba.recapp.d.a.cDk().CD(String.valueOf(a.this.lastAddress.getLongitude()));
                    com.baidu.tieba.recapp.d.a.cDk().ez(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void stopLocation() {
        if (this.cvk != null && this.cvk.isStarted()) {
            try {
                this.cvk.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
