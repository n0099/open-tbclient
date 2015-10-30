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
    private static a bTE = null;
    private C0064a bTH;
    private LocationClient bTI;
    private LocationClientOption bTJ;
    private Context mContext;
    private Address ux;
    private boolean zS = true;
    private String bTF = "";
    private a.b bTG = null;
    private long ur = 0;
    private boolean bTK = false;

    static {
        MessageManager.getInstance().registerListener(new b(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH));
    }

    public static a aaU() {
        if (bTE == null) {
            synchronized (a.class) {
                if (bTE == null) {
                    bTE = new a();
                }
            }
        }
        return bTE;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.d.d
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.m411getInst().getContext();
        this.bTG = bVar;
        this.bTF = "baidu";
        if (this.zS) {
            try {
                this.bTI = new LocationClient(this.mContext);
                this.bTJ = new LocationClientOption();
                this.bTJ.setOpenGps(true);
                this.bTJ.setIgnoreKillProcess(true);
                this.bTJ.setProdName(this.bTF);
                this.bTJ.setAddrType("all");
                this.bTJ.setCoorType(BDGeofence.COORD_TYPE_BD09LL);
                this.bTH = new C0064a(this, null);
                this.bTI.registerLocationListener(this.bTH);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.d.d
    public void A(boolean z) {
        if (this.zS && this.bTI != null) {
            try {
                this.bTK = z;
                if (z) {
                    this.bTJ.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.bTI.setLocOption(this.bTJ);
                if (!this.bTI.isStarted()) {
                    this.bTI.start();
                }
                this.bTI.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                gF();
                if (this.bTG != null) {
                    this.bTG.a(5, "", this.ux, this.ur, this.bTK);
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
                if (a.this.bTG != null) {
                    a.this.bTG.a(0, "", a.this.ux, a.this.ur, a.this.bTK);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.d
    public void gF() {
        if (this.bTI != null && this.bTI.isStarted()) {
            try {
                this.bTI.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
