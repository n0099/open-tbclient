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
    private static c bTB;
    private LocationManager bTD;
    private int errorCode;
    private Context mContext;
    private a bTC = null;
    private a.b bTv = null;
    private Address bTE = null;
    private long ur = 0;
    private Handler mHandler = null;
    private boolean bTz = false;
    private Runnable bTF = null;
    private Runnable bTG = null;
    private final LocationListener bTH = new d(this);
    private final LocationListener bTI = new e(this);

    public static c aaZ() {
        if (bTB == null) {
            synchronized (c.class) {
                if (bTB == null) {
                    bTB = new c();
                }
            }
        }
        return bTB;
    }

    private c() {
    }

    @Override // com.baidu.adp.lib.d.d
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.m411getInst().getContext();
        this.bTv = bVar;
        try {
            this.bTD = (LocationManager) this.mContext.getSystemService("location");
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.bTF = new f(this);
        this.bTG = new g(this);
        gD();
    }

    private void gD() {
        this.mHandler = new Handler(Looper.getMainLooper(), new h(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [248=4] */
    @Override // com.baidu.adp.lib.d.d
    public void A(boolean z) {
        if (this.bTv == null) {
            return;
        }
        try {
            if (this.bTD != null) {
                this.bTD.removeUpdates(this.bTH);
                this.errorCode = 4;
                this.bTz = z;
                if (!this.bTD.isProviderEnabled("gps") && !this.bTD.isProviderEnabled("network")) {
                    this.errorCode = 3;
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.uq);
                    return;
                }
                if (this.bTD.isProviderEnabled("gps")) {
                    this.mHandler.post(this.bTG);
                } else {
                    this.errorCode = 1;
                }
                if (!z) {
                    if (this.bTD.isProviderEnabled("network")) {
                        this.mHandler.post(this.bTF);
                    } else {
                        this.errorCode = 2;
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            gF();
            this.errorCode = 5;
        } finally {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.uq);
        }
    }

    @Override // com.baidu.adp.lib.d.d
    public void destroy() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.bTG);
        this.mHandler.removeCallbacks(this.bTF);
        if (this.bTD != null) {
            try {
                this.bTD.removeUpdates(this.bTH);
                this.bTD.removeUpdates(this.bTI);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.bTC != null) {
            this.bTC.cancel();
            this.bTC = null;
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
            c.this.bTC = null;
            if (address != null) {
                c.this.gF();
                c.this.ur = System.currentTimeMillis();
                c.this.bTE = address;
                c.this.bTv.a(0, "", c.this.bTE, c.this.ur, c.this.bTz);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            c.this.bTC = null;
        }
    }

    @Override // com.baidu.adp.lib.d.d
    public void gF() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.bTG);
        this.mHandler.removeCallbacks(this.bTF);
        if (this.bTD != null) {
            try {
                this.bTD.removeUpdates(this.bTH);
                this.bTD.removeUpdates(this.bTI);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.bTC != null) {
            this.bTC.cancel();
            this.bTC = null;
        }
    }
}
