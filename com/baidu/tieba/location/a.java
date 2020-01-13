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
/* loaded from: classes8.dex */
public class a implements com.baidu.adp.lib.c.b {
    private static a ibR = null;
    private LocationClient crh;
    private C0547a ibU;
    private LocationClientOption ibV;
    private Address lastAddress;
    private Context mContext;
    private boolean vg = true;
    private String ibS = "";
    private a.b ibT = null;
    private long lastLocationTime = 0;
    private boolean ibW = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.k.a.BZ() || ab.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.c.a.fK().a(a.ccd());
                        } else {
                            com.baidu.adp.lib.c.a.fK().b(a.ccd());
                        }
                    }
                }
            }
        });
    }

    public static a ccd() {
        if (ibR == null) {
            synchronized (a.class) {
                if (ibR == null) {
                    ibR = new a();
                }
            }
        }
        return ibR;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.c.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.ibT = bVar;
        this.ibS = BuildConfig.FLAVOR;
        if (this.vg) {
            try {
                this.crh = new LocationClient(this.mContext);
                this.ibV = new LocationClientOption();
                this.ibV.setOpenGps(true);
                this.ibV.setIgnoreKillProcess(true);
                this.ibV.setProdName(this.ibS);
                this.ibV.setAddrType(SchemeCollecter.CLASSIFY_ALL);
                this.ibV.setCoorType("bd09ll");
                this.ibU = new C0547a();
                this.crh.registerLocationListener(this.ibU);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void startLocation(boolean z) {
        if ((!com.baidu.k.a.BZ() || ab.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.vg && this.crh != null) {
            try {
                this.ibW = z;
                if (z) {
                    this.ibV.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.crh.setLocOption(this.ibV);
                if (!this.crh.isStarted()) {
                    this.crh.start();
                }
                this.crh.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                stopLocation();
                if (this.ibT != null) {
                    this.ibT.onProviderGetLocation(5, "", this.lastAddress, this.lastLocationTime, this.ibW);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void destroy() {
        stopLocation();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0547a implements BDLocationListener {
        private C0547a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.k.a.BZ() || ab.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
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
                if (a.this.ibT != null) {
                    a.this.ibT.onProviderGetLocation(0, "", a.this.lastAddress, a.this.lastLocationTime, a.this.ibW);
                    com.baidu.tieba.recapp.d.a.cBK().Co(String.valueOf(a.this.lastAddress.getLatitude()));
                    com.baidu.tieba.recapp.d.a.cBK().Cn(String.valueOf(a.this.lastAddress.getLongitude()));
                    com.baidu.tieba.recapp.d.a.cBK().eC(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void stopLocation() {
        if (this.crh != null && this.crh.isStarted()) {
            try {
                this.crh.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
