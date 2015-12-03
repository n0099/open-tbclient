package com.baidu.tieba.location;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.e.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.e.d {
    private static c ckv;
    private LocationManager ckx;
    private int errorCode;
    private Context mContext;
    private a ckw = null;
    private a.b ckp = null;
    private Address cky = null;
    private long ux = 0;
    private Handler mHandler = null;
    private boolean ckt = false;
    private Runnable ckz = null;
    private Runnable ckA = null;
    private final LocationListener ckB = new d(this);
    private final LocationListener ckC = new e(this);

    public static c aeW() {
        if (ckv == null) {
            synchronized (c.class) {
                if (ckv == null) {
                    ckv = new c();
                }
            }
        }
        return ckv;
    }

    private c() {
    }

    @Override // com.baidu.adp.lib.e.d
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.m411getInst().getContext();
        this.ckp = bVar;
        try {
            this.ckx = (LocationManager) this.mContext.getSystemService("location");
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.ckz = new f(this);
        this.ckA = new g(this);
        gE();
    }

    private void gE() {
        this.mHandler = new Handler(Looper.getMainLooper(), new h(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [248=4] */
    @Override // com.baidu.adp.lib.e.d
    public void A(boolean z) {
        if (this.ckp == null) {
            return;
        }
        try {
            if (this.ckx != null) {
                this.ckx.removeUpdates(this.ckB);
                this.errorCode = 4;
                this.ckt = z;
                if (!this.ckx.isProviderEnabled("gps") && !this.ckx.isProviderEnabled("network")) {
                    this.errorCode = 3;
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.e.a.gD().gF());
                    return;
                }
                if (this.ckx.isProviderEnabled("gps")) {
                    this.mHandler.post(this.ckA);
                } else {
                    this.errorCode = 1;
                }
                if (!z) {
                    if (this.ckx.isProviderEnabled("network")) {
                        this.mHandler.post(this.ckz);
                    } else {
                        this.errorCode = 2;
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            gH();
            this.errorCode = 5;
        } finally {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.e.a.gD().gF());
        }
    }

    @Override // com.baidu.adp.lib.e.d
    public void destroy() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.ckA);
        this.mHandler.removeCallbacks(this.ckz);
        if (this.ckx != null) {
            try {
                this.ckx.removeUpdates(this.ckB);
                this.ckx.removeUpdates(this.ckC);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.ckw != null) {
            this.ckw.cancel();
            this.ckw = null;
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
            c.this.ckw = null;
            if (address != null) {
                c.this.gH();
                c.this.ux = System.currentTimeMillis();
                c.this.cky = address;
                c.this.ckp.a(0, "", c.this.cky, c.this.ux, c.this.ckt);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            c.this.ckw = null;
        }
    }

    @Override // com.baidu.adp.lib.e.d
    public void gH() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.ckA);
        this.mHandler.removeCallbacks(this.ckz);
        if (this.ckx != null) {
            try {
                this.ckx.removeUpdates(this.ckB);
                this.ckx.removeUpdates(this.ckC);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.ckw != null) {
            this.ckw.cancel();
            this.ckw = null;
        }
    }
}
