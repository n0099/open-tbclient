package com.baidu.tieba.location;

import android.content.Context;
import android.location.Address;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
import java.util.Locale;
/* loaded from: classes3.dex */
public class a implements com.baidu.adp.lib.d.b {
    private static a fvi = null;
    private Address Cm;
    private C0265a fvl;
    private LocationClientOption fvm;
    private Context mContext;
    private LocationClient mLocationClient;
    private boolean mIsOpen = true;
    private String fvj = "";
    private a.b fvk = null;
    private long Cg = 0;
    private boolean fvn = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001330) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.e.a.uo() || ab.bB(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.d.a.iW().a(a.bak());
                        } else {
                            com.baidu.adp.lib.d.a.iW().b(a.bak());
                        }
                    }
                }
            }
        });
    }

    public static a bak() {
        if (fvi == null) {
            synchronized (a.class) {
                if (fvi == null) {
                    fvi = new a();
                }
            }
        }
        return fvi;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.fvk = bVar;
        this.fvj = "baidu";
        if (this.mIsOpen) {
            try {
                this.mLocationClient = new LocationClient(this.mContext);
                this.fvm = new LocationClientOption();
                this.fvm.setOpenGps(true);
                this.fvm.setIgnoreKillProcess(true);
                this.fvm.setProdName(this.fvj);
                this.fvm.setAddrType("all");
                this.fvm.setCoorType("bd09ll");
                this.fvl = new C0265a();
                this.mLocationClient.registerLocationListener(this.fvl);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void ah(boolean z) {
        if ((!com.baidu.e.a.uo() || ab.bB(TbadkCoreApplication.getInst())) && this.mIsOpen && this.mLocationClient != null) {
            try {
                this.fvn = z;
                if (z) {
                    this.fvm.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.mLocationClient.setLocOption(this.fvm);
                if (!this.mLocationClient.isStarted()) {
                    this.mLocationClient.start();
                }
                this.mLocationClient.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                stopLocation();
                if (this.fvk != null) {
                    this.fvk.a(5, "", this.Cm, this.Cg, this.fvn);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void destroy() {
        stopLocation();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0265a implements BDLocationListener {
        private C0265a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.e.a.uo() || ab.bB(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.stopLocation();
                a.this.Cm = new Address(Locale.getDefault());
                a.this.Cm.setLatitude(bDLocation.getLatitude());
                a.this.Cm.setLongitude(bDLocation.getLongitude());
                a.this.Cm.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                bundle.putDouble("altitude", bDLocation.getAltitude());
                bundle.putFloat("speed", bDLocation.getSpeed());
                bundle.putString("cityCode", bDLocation.getCityCode());
                bundle.putString("street", bDLocation.getStreet());
                bundle.putString("streetNumber", bDLocation.getStreetNumber());
                bundle.putString("province", bDLocation.getProvince());
                a.this.Cm.setExtras(bundle);
                a.this.Cg = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    a.this.Cm.setAddressLine(0, stringBuffer.toString());
                }
                if (a.this.fvk != null) {
                    a.this.fvk.a(0, "", a.this.Cm, a.this.Cg, a.this.fvn);
                    com.baidu.tieba.recapp.d.a.bwa().pI(String.valueOf(a.this.Cm.getLatitude()));
                    com.baidu.tieba.recapp.d.a.bwa().pH(String.valueOf(a.this.Cm.getLongitude()));
                    com.baidu.tieba.recapp.d.a.bwa().dg(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void stopLocation() {
        if (this.mLocationClient != null && this.mLocationClient.isStarted()) {
            try {
                this.mLocationClient.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
