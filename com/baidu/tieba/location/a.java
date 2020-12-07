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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ae;
import java.util.Locale;
/* loaded from: classes23.dex */
public class a implements com.baidu.adp.lib.c.b {
    private static a kYE = null;
    private LocationClient ehT;
    private C0802a kYH;
    private LocationClientOption kYI;
    private Address lastAddress;
    private Context mContext;
    private boolean Ru = true;
    private String kYF = "";
    private a.b kYG = null;
    private long lastLocationTime = 0;
    private boolean kYJ = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.n.a.adp() || ae.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.c.a.mk().a(a.dfI());
                        } else {
                            com.baidu.adp.lib.c.a.mk().b(a.dfI());
                        }
                    }
                }
            }
        });
    }

    public static a dfI() {
        if (kYE == null) {
            synchronized (a.class) {
                if (kYE == null) {
                    kYE = new a();
                }
            }
        }
        return kYE;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.c.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.kYG = bVar;
        this.kYF = "baidu";
        if (this.Ru) {
            try {
                this.ehT = new LocationClient(this.mContext);
                this.kYI = new LocationClientOption();
                this.kYI.setOpenGps(true);
                this.kYI.setIgnoreKillProcess(true);
                this.kYI.setProdName(this.kYF);
                this.kYI.setAddrType("all");
                this.kYI.setCoorType("bd09ll");
                this.kYH = new C0802a();
                this.ehT.registerLocationListener(this.kYH);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void startLocation(boolean z) {
        if ((!com.baidu.n.a.adp() || ae.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.Ru && this.ehT != null) {
            try {
                this.kYJ = z;
                if (z) {
                    this.kYI.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.ehT.setLocOption(this.kYI);
                if (!this.ehT.isStarted()) {
                    this.ehT.start();
                }
                this.ehT.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                stopLocation();
                if (this.kYG != null) {
                    this.kYG.onProviderGetLocation(5, "", this.lastAddress, this.lastLocationTime, this.kYJ);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void destroy() {
        stopLocation();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    private class C0802a implements BDLocationListener {
        private C0802a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.n.a.adp() || ae.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.stopLocation();
                a.this.lastAddress = new Address(Locale.getDefault());
                a.this.lastAddress.setLatitude(bDLocation.getLatitude());
                a.this.lastAddress.setLongitude(bDLocation.getLongitude());
                com.baidu.tbadk.core.sharedPref.b.bsO().putString("key_last_receive_location_latitude_and_longitude", bDLocation.getLatitude() + "," + bDLocation.getLongitude());
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
                if (a.this.kYG != null) {
                    a.this.kYG.onProviderGetLocation(0, "", a.this.lastAddress, a.this.lastLocationTime, a.this.kYJ);
                    com.baidu.tieba.recapp.d.a.dFX().MX(String.valueOf(a.this.lastAddress.getLatitude()));
                    com.baidu.tieba.recapp.d.a.dFX().MW(String.valueOf(a.this.lastAddress.getLongitude()));
                    com.baidu.tieba.recapp.d.a.dFX().hB(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void stopLocation() {
        if (this.ehT != null && this.ehT.isStarted()) {
            try {
                this.ehT.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
