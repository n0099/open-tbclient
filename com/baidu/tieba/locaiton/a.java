package com.baidu.tieba.locaiton;

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
    private static a bPR = null;
    private C0064a bPU;
    private LocationClient bPV;
    private LocationClientOption bPW;
    private Context mContext;
    private Address ux;
    private boolean zR = true;
    private String bPS = "";
    private a.b bPT = null;
    private long ur = 0;
    private boolean bPX = false;

    static {
        MessageManager.getInstance().registerListener(new b(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH));
    }

    public static a ZO() {
        if (bPR == null) {
            synchronized (a.class) {
                if (bPR == null) {
                    bPR = new a();
                }
            }
        }
        return bPR;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.d.d
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.m411getInst().getContext();
        this.bPT = bVar;
        this.bPS = "baidu";
        if (this.zR) {
            try {
                this.bPV = new LocationClient(this.mContext);
                this.bPW = new LocationClientOption();
                this.bPW.setOpenGps(true);
                this.bPW.setIgnoreKillProcess(true);
                this.bPW.setProdName(this.bPS);
                this.bPW.setAddrType("all");
                this.bPW.setCoorType(BDGeofence.COORD_TYPE_BD09LL);
                this.bPU = new C0064a(this, null);
                this.bPV.registerLocationListener(this.bPU);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.d.d
    public void A(boolean z) {
        if (this.zR && this.bPV != null) {
            try {
                this.bPX = z;
                if (z) {
                    this.bPW.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.bPV.setLocOption(this.bPW);
                if (!this.bPV.isStarted()) {
                    this.bPV.start();
                }
                this.bPV.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                gF();
                if (this.bPT != null) {
                    this.bPT.a(5, "", this.ux, this.ur, this.bPX);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.d
    public void destroy() {
        gF();
    }

    /* renamed from: com.baidu.tieba.locaiton.a$a  reason: collision with other inner class name */
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
                if (a.this.bPT != null) {
                    a.this.bPT.a(0, "", a.this.ux, a.this.ur, a.this.bPX);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.d
    public void gF() {
        if (this.bPV != null && this.bPV.isStarted()) {
            try {
                this.bPV.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
