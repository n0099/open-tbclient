package com.baidu.tieba.location;

import android.content.Context;
import android.location.Address;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.BuildConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
import java.util.Locale;
/* loaded from: classes5.dex */
public class a implements com.baidu.adp.lib.d.b {
    private static a hkm = null;
    private LocationClient bFP;
    private C0461a hkp;
    private LocationClientOption hkq;
    private Address lastAddress;
    private Context mContext;
    private boolean sk = true;
    private String hkn = "";
    private a.b hko = null;
    private long lastLocationTime = 0;
    private boolean hkr = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.e.a.zC() || ab.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.d.a.fw().a(a.bJH());
                        } else {
                            com.baidu.adp.lib.d.a.fw().b(a.bJH());
                        }
                    }
                }
            }
        });
    }

    public static a bJH() {
        if (hkm == null) {
            synchronized (a.class) {
                if (hkm == null) {
                    hkm = new a();
                }
            }
        }
        return hkm;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.hko = bVar;
        this.hkn = BuildConfig.FLAVOR;
        if (this.sk) {
            try {
                this.bFP = new LocationClient(this.mContext);
                this.hkq = new LocationClientOption();
                this.hkq.setOpenGps(true);
                this.hkq.setIgnoreKillProcess(true);
                this.hkq.setProdName(this.hkn);
                this.hkq.setAddrType("all");
                this.hkq.setCoorType("bd09ll");
                this.hkp = new C0461a();
                this.bFP.registerLocationListener(this.hkp);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void startLocation(boolean z) {
        if ((!com.baidu.e.a.zC() || ab.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.sk && this.bFP != null) {
            try {
                this.hkr = z;
                if (z) {
                    this.hkq.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.bFP.setLocOption(this.hkq);
                if (!this.bFP.isStarted()) {
                    this.bFP.start();
                }
                this.bFP.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                stopLocation();
                if (this.hko != null) {
                    this.hko.onProviderGetLocation(5, "", this.lastAddress, this.lastLocationTime, this.hkr);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void destroy() {
        stopLocation();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0461a implements BDLocationListener {
        private C0461a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.e.a.zC() || ab.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
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
                if (a.this.hko != null) {
                    a.this.hko.onProviderGetLocation(0, "", a.this.lastAddress, a.this.lastLocationTime, a.this.hkr);
                    com.baidu.tieba.recapp.d.a.cgB().xv(String.valueOf(a.this.lastAddress.getLatitude()));
                    com.baidu.tieba.recapp.d.a.cgB().xu(String.valueOf(a.this.lastAddress.getLongitude()));
                    com.baidu.tieba.recapp.d.a.cgB().dQ(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void stopLocation() {
        if (this.bFP != null && this.bFP.isStarted()) {
            try {
                this.bFP.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
