package com.baidu.tieba.location;

import android.content.Context;
import android.location.Address;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.c.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.BuildConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
import java.util.Locale;
/* loaded from: classes7.dex */
public class a implements com.baidu.adp.lib.c.b {
    private static a hYn = null;
    private LocationClient cqV;
    private C0542a hYq;
    private LocationClientOption hYr;
    private Address lastAddress;
    private Context mContext;
    private boolean vd = true;
    private String hYo = "";
    private a.b hYp = null;
    private long lastLocationTime = 0;
    private boolean hYs = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.k.a.BD() || ab.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.c.a.fK().a(a.caU());
                        } else {
                            com.baidu.adp.lib.c.a.fK().b(a.caU());
                        }
                    }
                }
            }
        });
    }

    public static a caU() {
        if (hYn == null) {
            synchronized (a.class) {
                if (hYn == null) {
                    hYn = new a();
                }
            }
        }
        return hYn;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.c.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.hYp = bVar;
        this.hYo = BuildConfig.FLAVOR;
        if (this.vd) {
            try {
                this.cqV = new LocationClient(this.mContext);
                this.hYr = new LocationClientOption();
                this.hYr.setOpenGps(true);
                this.hYr.setIgnoreKillProcess(true);
                this.hYr.setProdName(this.hYo);
                this.hYr.setAddrType(SchemeCollecter.CLASSIFY_ALL);
                this.hYr.setCoorType("bd09ll");
                this.hYq = new C0542a();
                this.cqV.registerLocationListener(this.hYq);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void startLocation(boolean z) {
        if ((!com.baidu.k.a.BD() || ab.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.vd && this.cqV != null) {
            try {
                this.hYs = z;
                if (z) {
                    this.hYr.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.cqV.setLocOption(this.hYr);
                if (!this.cqV.isStarted()) {
                    this.cqV.start();
                }
                this.cqV.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                stopLocation();
                if (this.hYp != null) {
                    this.hYp.onProviderGetLocation(5, "", this.lastAddress, this.lastLocationTime, this.hYs);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void destroy() {
        stopLocation();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class C0542a implements BDLocationListener {
        private C0542a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.k.a.BD() || ab.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
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
                if (a.this.hYp != null) {
                    a.this.hYp.onProviderGetLocation(0, "", a.this.lastAddress, a.this.lastLocationTime, a.this.hYs);
                    com.baidu.tieba.recapp.d.a.cAE().Ce(String.valueOf(a.this.lastAddress.getLatitude()));
                    com.baidu.tieba.recapp.d.a.cAE().Cd(String.valueOf(a.this.lastAddress.getLongitude()));
                    com.baidu.tieba.recapp.d.a.cAE().ex(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void stopLocation() {
        if (this.cqV != null && this.cqV.isStarted()) {
            try {
                this.cqV.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
