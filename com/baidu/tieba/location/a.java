package com.baidu.tieba.location;

import android.content.Context;
import android.location.Address;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.d.a;
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
public class a implements com.baidu.adp.lib.d.d {
    private static a bTZ = null;
    private C0064a bUc;
    private LocationClient bUd;
    private LocationClientOption bUe;
    private Context mContext;
    private Address ux;
    private boolean zS = true;
    private String bUa = "";
    private a.b bUb = null;
    private long ur = 0;
    private boolean bUf = false;

    static {
        MessageManager.getInstance().registerListener(new b(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH));
    }

    public static a abp() {
        if (bTZ == null) {
            synchronized (a.class) {
                if (bTZ == null) {
                    bTZ = new a();
                }
            }
        }
        return bTZ;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.d.d
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.m411getInst().getContext();
        this.bUb = bVar;
        this.bUa = "baidu";
        if (this.zS) {
            try {
                this.bUd = new LocationClient(this.mContext);
                this.bUe = new LocationClientOption();
                this.bUe.setOpenGps(true);
                this.bUe.setIgnoreKillProcess(true);
                this.bUe.setProdName(this.bUa);
                this.bUe.setAddrType("all");
                this.bUe.setCoorType(BDGeofence.COORD_TYPE_BD09LL);
                this.bUc = new C0064a(this, null);
                this.bUd.registerLocationListener(this.bUc);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.d.d
    public void A(boolean z) {
        if (this.zS && this.bUd != null) {
            try {
                this.bUf = z;
                if (z) {
                    this.bUe.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.bUd.setLocOption(this.bUe);
                if (!this.bUd.isStarted()) {
                    this.bUd.start();
                }
                this.bUd.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                gF();
                if (this.bUb != null) {
                    this.bUb.a(5, "", this.ux, this.ur, this.bUf);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.d
    public void destroy() {
        gF();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0064a implements BDLocationListener {
        private C0064a() {
        }

        /* synthetic */ C0064a(a aVar, C0064a c0064a) {
            this();
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.gF();
                a.this.ux = new Address(Locale.getDefault());
                a.this.ux.setLatitude(bDLocation.getLatitude());
                a.this.ux.setLongitude(bDLocation.getLongitude());
                a.this.ux.setLocality(bDLocation.getCity());
                a.this.ur = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    a.this.ux.setAddressLine(0, stringBuffer.toString());
                }
                if (a.this.bUb != null) {
                    a.this.bUb.a(0, "", a.this.ux, a.this.ur, a.this.bUf);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.d
    public void gF() {
        if (this.bUd != null && this.bUd.isStarted()) {
            try {
                this.bUd.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
