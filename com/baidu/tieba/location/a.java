package com.baidu.tieba.location;

import android.content.Context;
import android.location.Address;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.e.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.BDGeofence;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.Locale;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.e.d {
    private static a cor = null;
    private C0066a cou;
    private LocationClient cov;
    private LocationClientOption cow;
    private Context mContext;
    private Address uF;
    private boolean Aa = true;
    private String cos = "";
    private a.b cot = null;
    private long uz = 0;
    private boolean cox = false;

    static {
        MessageManager.getInstance().registerListener(new b(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH));
    }

    public static a age() {
        if (cor == null) {
            synchronized (a.class) {
                if (cor == null) {
                    cor = new a();
                }
            }
        }
        return cor;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.e.d
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.m411getInst().getContext();
        this.cot = bVar;
        this.cos = "baidu";
        if (this.Aa) {
            try {
                this.cov = new LocationClient(this.mContext);
                this.cow = new LocationClientOption();
                this.cow.setOpenGps(true);
                this.cow.setIgnoreKillProcess(true);
                this.cow.setProdName(this.cos);
                this.cow.setAddrType("all");
                this.cow.setCoorType(BDGeofence.COORD_TYPE_BD09LL);
                this.cou = new C0066a(this, null);
                this.cov.registerLocationListener(this.cou);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.e.d
    public void A(boolean z) {
        if (this.Aa && this.cov != null) {
            try {
                this.cox = z;
                if (z) {
                    this.cow.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.cov.setLocOption(this.cow);
                if (!this.cov.isStarted()) {
                    this.cov.start();
                }
                this.cov.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                gH();
                if (this.cot != null) {
                    this.cot.a(5, "", this.uF, this.uz, this.cox);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.e.d
    public void destroy() {
        gH();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0066a implements BDLocationListener {
        private C0066a() {
        }

        /* synthetic */ C0066a(a aVar, C0066a c0066a) {
            this();
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.gH();
                a.this.uF = new Address(Locale.getDefault());
                a.this.uF.setLatitude(bDLocation.getLatitude());
                a.this.uF.setLongitude(bDLocation.getLongitude());
                a.this.uF.setLocality(bDLocation.getCity());
                a.this.uz = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    a.this.uF.setAddressLine(0, stringBuffer.toString());
                }
                if (a.this.cot != null) {
                    a.this.cot.a(0, "", a.this.uF, a.this.uz, a.this.cox);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.e.d
    public void gH() {
        if (this.cov != null && this.cov.isStarted()) {
            try {
                this.cov.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
