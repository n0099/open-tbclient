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
    private static a bTt = null;
    private C0064a bTw;
    private LocationClient bTx;
    private LocationClientOption bTy;
    private Context mContext;
    private Address ux;
    private boolean zS = true;
    private String bTu = "";
    private a.b bTv = null;
    private long ur = 0;
    private boolean bTz = false;

    static {
        MessageManager.getInstance().registerListener(new b(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH));
    }

    public static a aaY() {
        if (bTt == null) {
            synchronized (a.class) {
                if (bTt == null) {
                    bTt = new a();
                }
            }
        }
        return bTt;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.d.d
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.m411getInst().getContext();
        this.bTv = bVar;
        this.bTu = "baidu";
        if (this.zS) {
            try {
                this.bTx = new LocationClient(this.mContext);
                this.bTy = new LocationClientOption();
                this.bTy.setOpenGps(true);
                this.bTy.setIgnoreKillProcess(true);
                this.bTy.setProdName(this.bTu);
                this.bTy.setAddrType("all");
                this.bTy.setCoorType(BDGeofence.COORD_TYPE_BD09LL);
                this.bTw = new C0064a(this, null);
                this.bTx.registerLocationListener(this.bTw);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.d.d
    public void A(boolean z) {
        if (this.zS && this.bTx != null) {
            try {
                this.bTz = z;
                if (z) {
                    this.bTy.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.bTx.setLocOption(this.bTy);
                if (!this.bTx.isStarted()) {
                    this.bTx.start();
                }
                this.bTx.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                gF();
                if (this.bTv != null) {
                    this.bTv.a(5, "", this.ux, this.ur, this.bTz);
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
                if (a.this.bTv != null) {
                    a.this.bTv.a(0, "", a.this.ux, a.this.ur, a.this.bTz);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.d
    public void gF() {
        if (this.bTx != null && this.bTx.isStarted()) {
            try {
                this.bTx.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
