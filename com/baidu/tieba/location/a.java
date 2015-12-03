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
    private static a ckn = null;
    private C0072a ckq;
    private LocationClient ckr;
    private LocationClientOption cks;
    private Context mContext;
    private Address uD;
    private boolean zY = true;
    private String cko = "";
    private a.b ckp = null;
    private long ux = 0;
    private boolean ckt = false;

    static {
        MessageManager.getInstance().registerListener(new b(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH));
    }

    public static a aeV() {
        if (ckn == null) {
            synchronized (a.class) {
                if (ckn == null) {
                    ckn = new a();
                }
            }
        }
        return ckn;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.e.d
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.m411getInst().getContext();
        this.ckp = bVar;
        this.cko = "baidu";
        if (this.zY) {
            try {
                this.ckr = new LocationClient(this.mContext);
                this.cks = new LocationClientOption();
                this.cks.setOpenGps(true);
                this.cks.setIgnoreKillProcess(true);
                this.cks.setProdName(this.cko);
                this.cks.setAddrType("all");
                this.cks.setCoorType(BDGeofence.COORD_TYPE_BD09LL);
                this.ckq = new C0072a(this, null);
                this.ckr.registerLocationListener(this.ckq);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.e.d
    public void A(boolean z) {
        if (this.zY && this.ckr != null) {
            try {
                this.ckt = z;
                if (z) {
                    this.cks.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.ckr.setLocOption(this.cks);
                if (!this.ckr.isStarted()) {
                    this.ckr.start();
                }
                this.ckr.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                gH();
                if (this.ckp != null) {
                    this.ckp.a(5, "", this.uD, this.ux, this.ckt);
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
    private class C0072a implements BDLocationListener {
        private C0072a() {
        }

        /* synthetic */ C0072a(a aVar, C0072a c0072a) {
            this();
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.gH();
                a.this.uD = new Address(Locale.getDefault());
                a.this.uD.setLatitude(bDLocation.getLatitude());
                a.this.uD.setLongitude(bDLocation.getLongitude());
                a.this.uD.setLocality(bDLocation.getCity());
                a.this.ux = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    a.this.uD.setAddressLine(0, stringBuffer.toString());
                }
                if (a.this.ckp != null) {
                    a.this.ckp.a(0, "", a.this.uD, a.this.ux, a.this.ckt);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.e.d
    public void gH() {
        if (this.ckr != null && this.ckr.isStarted()) {
            try {
                this.ckr.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
