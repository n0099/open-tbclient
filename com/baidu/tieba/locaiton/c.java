package com.baidu.tieba.locaiton;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.d.d {
    private static c bPt;
    private LocationManager bPv;
    private int errorCode;
    private Context mContext;
    private a bPu = null;
    private a.b bPn = null;
    private Address bPw = null;
    private long ut = 0;
    private Handler mHandler = null;
    private boolean bPr = false;
    private Runnable bPx = null;
    private Runnable bPy = null;
    private final LocationListener bPz = new d(this);
    private final LocationListener bPA = new e(this);

    public static c ZL() {
        if (bPt == null) {
            synchronized (c.class) {
                if (bPt == null) {
                    bPt = new c();
                }
            }
        }
        return bPt;
    }

    private c() {
    }

    @Override // com.baidu.adp.lib.d.d
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.m411getInst().getContext();
        this.bPn = bVar;
        try {
            this.bPv = (LocationManager) this.mContext.getSystemService("location");
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.bPx = new f(this);
        this.bPy = new g(this);
        gG();
    }

    private void gG() {
        this.mHandler = new Handler(Looper.getMainLooper(), new h(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [248=4] */
    @Override // com.baidu.adp.lib.d.d
    public void A(boolean z) {
        if (this.bPn == null) {
            return;
        }
        try {
            if (this.bPv != null) {
                this.bPv.removeUpdates(this.bPz);
                this.errorCode = 4;
                this.bPr = z;
                if (!this.bPv.isProviderEnabled("gps") && !this.bPv.isProviderEnabled("network")) {
                    this.errorCode = 3;
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.us);
                    return;
                }
                if (this.bPv.isProviderEnabled("gps")) {
                    this.mHandler.post(this.bPy);
                } else {
                    this.errorCode = 1;
                }
                if (!z) {
                    if (this.bPv.isProviderEnabled("network")) {
                        this.mHandler.post(this.bPx);
                    } else {
                        this.errorCode = 2;
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            gI();
            this.errorCode = 5;
        } finally {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.us);
        }
    }

    @Override // com.baidu.adp.lib.d.d
    public void destroy() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.bPy);
        this.mHandler.removeCallbacks(this.bPx);
        if (this.bPv != null) {
            try {
                this.bPv.removeUpdates(this.bPz);
                this.bPv.removeUpdates(this.bPA);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.bPu != null) {
            this.bPu.cancel();
            this.bPu = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Location, Void, Address> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(c cVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Address doInBackground(Location... locationArr) {
            List<Address> list;
            Geocoder geocoder = new Geocoder(c.this.mContext, Locale.getDefault());
            if (locationArr == null || locationArr.length < 1) {
                return null;
            }
            Location location = locationArr[0];
            try {
                list = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            } catch (IOException e) {
                list = null;
            } catch (IllegalArgumentException e2) {
                list = null;
            }
            if (list == null || list.size() <= 0) {
                return null;
            }
            Address address = list.get(0);
            StringBuffer stringBuffer = new StringBuffer();
            if (address.getSubLocality() == null || address.getThoroughfare() == null) {
                stringBuffer.append(address.getLocality());
            }
            stringBuffer.append(address.getSubLocality());
            stringBuffer.append(address.getThoroughfare());
            address.setAddressLine(0, stringBuffer.toString());
            return address;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(Address address) {
            super.onPostExecute(address);
            c.this.bPu = null;
            if (address != null) {
                c.this.gI();
                c.this.ut = System.currentTimeMillis();
                c.this.bPw = address;
                c.this.bPn.a(0, "", c.this.bPw, c.this.ut, c.this.bPr);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            c.this.bPu = null;
        }
    }

    @Override // com.baidu.adp.lib.d.d
    public void gI() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.bPy);
        this.mHandler.removeCallbacks(this.bPx);
        if (this.bPv != null) {
            try {
                this.bPv.removeUpdates(this.bPz);
                this.bPv.removeUpdates(this.bPA);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.bPu != null) {
            this.bPu.cancel();
            this.bPu = null;
        }
    }
}
