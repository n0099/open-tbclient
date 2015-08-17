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
    private static a bPl = null;
    private C0063a bPo;
    private LocationClient bPp;
    private LocationClientOption bPq;
    private Context mContext;
    private Address uz;
    private boolean zT = true;
    private String bPm = "";
    private a.b bPn = null;
    private long ut = 0;
    private boolean bPr = false;

    static {
        MessageManager.getInstance().registerListener(new b(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH));
    }

    public static a ZK() {
        if (bPl == null) {
            synchronized (a.class) {
                if (bPl == null) {
                    bPl = new a();
                }
            }
        }
        return bPl;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.d.d
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.m411getInst().getContext();
        this.bPn = bVar;
        this.bPm = "baidu";
        if (this.zT) {
            try {
                this.bPp = new LocationClient(this.mContext);
                this.bPq = new LocationClientOption();
                this.bPq.setOpenGps(true);
                this.bPq.setIgnoreKillProcess(true);
                this.bPq.setProdName(this.bPm);
                this.bPq.setAddrType("all");
                this.bPq.setCoorType(BDGeofence.COORD_TYPE_BD09LL);
                this.bPo = new C0063a(this, null);
                this.bPp.registerLocationListener(this.bPo);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.d.d
    public void A(boolean z) {
        if (this.zT && this.bPp != null) {
            try {
                this.bPr = z;
                if (z) {
                    this.bPq.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.bPp.setLocOption(this.bPq);
                if (!this.bPp.isStarted()) {
                    this.bPp.start();
                }
                this.bPp.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                gI();
                if (this.bPn != null) {
                    this.bPn.a(5, "", this.uz, this.ut, this.bPr);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.d
    public void destroy() {
        gI();
    }

    /* renamed from: com.baidu.tieba.locaiton.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0063a implements BDLocationListener {
        private C0063a() {
        }

        /* synthetic */ C0063a(a aVar, C0063a c0063a) {
            this();
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.gI();
                a.this.uz = new Address(Locale.getDefault());
                a.this.uz.setLatitude(bDLocation.getLatitude());
                a.this.uz.setLongitude(bDLocation.getLongitude());
                a.this.uz.setLocality(bDLocation.getCity());
                a.this.ut = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    a.this.uz.setAddressLine(0, stringBuffer.toString());
                }
                if (a.this.bPn != null) {
                    a.this.bPn.a(0, "", a.this.uz, a.this.ut, a.this.bPr);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.d
    public void gI() {
        if (this.bPp != null && this.bPp.isStarted()) {
            try {
                this.bPp.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
