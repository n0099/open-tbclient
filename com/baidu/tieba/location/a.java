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
    private static a cva = null;
    private C0068a cvd;
    private LocationClient cve;
    private LocationClientOption cvf;
    private Context mContext;
    private Address uO;
    private boolean Aj = true;
    private String cvb = "";
    private a.b cvc = null;
    private long uI = 0;
    private boolean cvg = false;

    static {
        MessageManager.getInstance().registerListener(new b(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH));
    }

    public static a akg() {
        if (cva == null) {
            synchronized (a.class) {
                if (cva == null) {
                    cva = new a();
                }
            }
        }
        return cva;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.e.d
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.m411getInst().getContext();
        this.cvc = bVar;
        this.cvb = "baidu";
        if (this.Aj) {
            try {
                this.cve = new LocationClient(this.mContext);
                this.cvf = new LocationClientOption();
                this.cvf.setOpenGps(true);
                this.cvf.setIgnoreKillProcess(true);
                this.cvf.setProdName(this.cvb);
                this.cvf.setAddrType("all");
                this.cvf.setCoorType(BDGeofence.COORD_TYPE_BD09LL);
                this.cvd = new C0068a(this, null);
                this.cve.registerLocationListener(this.cvd);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.e.d
    public void A(boolean z) {
        if (this.Aj && this.cve != null) {
            try {
                this.cvg = z;
                if (z) {
                    this.cvf.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.cve.setLocOption(this.cvf);
                if (!this.cve.isStarted()) {
                    this.cve.start();
                }
                this.cve.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                gP();
                if (this.cvc != null) {
                    this.cvc.a(5, "", this.uO, this.uI, this.cvg);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.e.d
    public void destroy() {
        gP();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0068a implements BDLocationListener {
        private C0068a() {
        }

        /* synthetic */ C0068a(a aVar, C0068a c0068a) {
            this();
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.gP();
                a.this.uO = new Address(Locale.getDefault());
                a.this.uO.setLatitude(bDLocation.getLatitude());
                a.this.uO.setLongitude(bDLocation.getLongitude());
                a.this.uO.setLocality(bDLocation.getCity());
                a.this.uI = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    a.this.uO.setAddressLine(0, stringBuffer.toString());
                }
                if (a.this.cvc != null) {
                    a.this.cvc.a(0, "", a.this.uO, a.this.uI, a.this.cvg);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.e.d
    public void gP() {
        if (this.cve != null && this.cve.isStarted()) {
            try {
                this.cve.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
