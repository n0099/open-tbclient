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
    private static a ieg = null;
    private LocationClient cvl;
    private C0553a iej;
    private LocationClientOption iek;
    private Address lastAddress;
    private Context mContext;
    private boolean vy = true;
    private String ieh = "";
    private a.b iei = null;
    private long lastLocationTime = 0;
    private boolean iel = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.k.a.Ex() || ab.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.c.a.fK().a(a.cdK());
                        } else {
                            com.baidu.adp.lib.c.a.fK().b(a.cdK());
                        }
                    }
                }
            }
        });
    }

    public static a cdK() {
        if (ieg == null) {
            synchronized (a.class) {
                if (ieg == null) {
                    ieg = new a();
                }
            }
        }
        return ieg;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.c.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.iei = bVar;
        this.ieh = "baidu";
        if (this.vy) {
            try {
                this.cvl = new LocationClient(this.mContext);
                this.iek = new LocationClientOption();
                this.iek.setOpenGps(true);
                this.iek.setIgnoreKillProcess(true);
                this.iek.setProdName(this.ieh);
                this.iek.setAddrType(SchemeCollecter.CLASSIFY_ALL);
                this.iek.setCoorType("bd09ll");
                this.iej = new C0553a();
                this.cvl.registerLocationListener(this.iej);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void startLocation(boolean z) {
        if ((!com.baidu.k.a.Ex() || ab.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.vy && this.cvl != null) {
            try {
                this.iel = z;
                if (z) {
                    this.iek.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.cvl.setLocOption(this.iek);
                if (!this.cvl.isStarted()) {
                    this.cvl.start();
                }
                this.cvl.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                stopLocation();
                if (this.iei != null) {
                    this.iei.onProviderGetLocation(5, "", this.lastAddress, this.lastLocationTime, this.iel);
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
                if (a.this.iei != null) {
                    a.this.iei.onProviderGetLocation(0, "", a.this.lastAddress, a.this.lastLocationTime, a.this.iel);
                    com.baidu.tieba.recapp.d.a.cDl().CF(String.valueOf(a.this.lastAddress.getLatitude()));
                    com.baidu.tieba.recapp.d.a.cDl().CE(String.valueOf(a.this.lastAddress.getLongitude()));
                    com.baidu.tieba.recapp.d.a.cDl().ez(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void stopLocation() {
        if (this.cvl != null && this.cvl.isStarted()) {
            try {
                this.cvl.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
