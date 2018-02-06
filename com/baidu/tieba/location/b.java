package com.baidu.tieba.location;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.http.Headers;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
/* loaded from: classes3.dex */
public class b implements com.baidu.adp.lib.d.b {
    private static b fgv;
    private LocationManager Ec;
    private int errorCode;
    private Context mContext;
    private a fgw = null;
    private a.b fgp = null;
    private Address fgx = null;
    private long aiH = 0;
    private Handler mHandler = null;
    private boolean fgt = false;
    private Runnable fgy = null;
    private Runnable fgz = null;
    private final LocationListener fgA = new LocationListener() { // from class: com.baidu.tieba.location.b.1
        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (b.this.mHandler.hasMessages(0)) {
                b.this.mHandler.removeMessages(0);
            }
            b.this.mHandler.removeCallbacks(b.this.fgz);
            b.this.mHandler.removeCallbacks(b.this.fgy);
            if (b.this.fgw == null) {
                b.this.fgw = new a();
                b.this.fgw.setSelfExecute(true);
                b.this.fgw.execute(location);
            }
        }
    };
    private final LocationListener fgB = new LocationListener() { // from class: com.baidu.tieba.location.b.2
        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (b.this.mHandler.hasMessages(0)) {
                b.this.mHandler.removeMessages(0);
            }
            b.this.mHandler.removeCallbacks(b.this.fgz);
            b.this.mHandler.removeCallbacks(b.this.fgy);
            if (b.this.fgw == null) {
                b.this.fgw = new a();
                b.this.fgw.setSelfExecute(true);
                b.this.fgw.execute(location);
            }
        }
    };

    public static b aRl() {
        if (fgv == null) {
            synchronized (b.class) {
                if (fgv == null) {
                    fgv = new b();
                }
            }
        }
        return fgv;
    }

    private b() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.fgp = bVar;
        try {
            this.Ec = (LocationManager) this.mContext.getSystemService(Headers.LOCATION);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.fgy = new Runnable() { // from class: com.baidu.tieba.location.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.Ec != null && ab.aS(b.this.mContext)) {
                    try {
                        b.this.Ec.requestLocationUpdates(LivenessRecogActivity.f.J, 10000L, 100.0f, b.this.fgA);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        };
        this.fgz = new Runnable() { // from class: com.baidu.tieba.location.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.Ec != null && ab.aS(b.this.mContext)) {
                    try {
                        b.this.Ec.requestLocationUpdates("gps", 10000L, 100.0f, b.this.fgB);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        };
        mH();
    }

    private void mH() {
        this.mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.tieba.location.b.5
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        b.this.mK();
                        b.this.fgp.a(b.this.errorCode, "", null, b.this.aiH, b.this.fgt);
                        return false;
                    default:
                        return false;
                }
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [252=4] */
    @Override // com.baidu.adp.lib.d.b
    public void ap(boolean z) {
        if (this.fgp == null) {
            return;
        }
        try {
            if (this.Ec != null) {
                this.Ec.removeUpdates(this.fgA);
                this.errorCode = 4;
                this.fgt = z;
                if (!ab.aS(this.mContext) || (!this.Ec.isProviderEnabled("gps") && !this.Ec.isProviderEnabled(LivenessRecogActivity.f.J))) {
                    this.errorCode = 3;
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.mG().mI());
                    return;
                }
                if (ab.aS(this.mContext) && this.Ec.isProviderEnabled("gps")) {
                    this.mHandler.post(this.fgz);
                } else {
                    this.errorCode = 1;
                }
                if (!z) {
                    if (ab.aS(this.mContext) && this.Ec.isProviderEnabled(LivenessRecogActivity.f.J)) {
                        this.mHandler.post(this.fgy);
                    } else {
                        this.errorCode = 2;
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            mK();
            this.errorCode = 5;
        } finally {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.mG().mI());
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void destroy() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.fgz);
        this.mHandler.removeCallbacks(this.fgy);
        if (this.Ec != null) {
            try {
                this.Ec.removeUpdates(this.fgA);
                this.Ec.removeUpdates(this.fgB);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.fgw != null) {
            this.fgw.cancel();
            this.fgw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Location, Void, Address> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Address doInBackground(Location... locationArr) {
            List<Address> list;
            Address address = null;
            Geocoder geocoder = new Geocoder(b.this.mContext, Locale.getDefault());
            if (locationArr != null && locationArr.length >= 1) {
                Location location = locationArr[0];
                try {
                    list = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                } catch (IOException e) {
                    list = null;
                } catch (IllegalArgumentException e2) {
                    list = null;
                }
                if (list != null && list.size() > 0) {
                    address = list.get(0);
                    StringBuffer stringBuffer = new StringBuffer();
                    if (address.getSubLocality() == null || address.getThoroughfare() == null) {
                        stringBuffer.append(address.getLocality());
                    }
                    stringBuffer.append(address.getSubLocality());
                    stringBuffer.append(address.getThoroughfare());
                    address.setAddressLine(0, stringBuffer.toString());
                }
            }
            return address;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(Address address) {
            super.onPostExecute(address);
            b.this.fgw = null;
            if (address != null) {
                b.this.mK();
                b.this.aiH = System.currentTimeMillis();
                b.this.fgx = address;
                b.this.fgp.a(0, "", b.this.fgx, b.this.aiH, b.this.fgt);
                com.baidu.tieba.recapp.d.a.boS().mV(String.valueOf(address.getLatitude()));
                com.baidu.tieba.recapp.d.a.boS().mU(String.valueOf(address.getLongitude()));
                com.baidu.tieba.recapp.d.a.boS().cM(System.currentTimeMillis());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            b.this.fgw = null;
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void mK() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.fgz);
        this.mHandler.removeCallbacks(this.fgy);
        if (this.Ec != null) {
            try {
                this.Ec.removeUpdates(this.fgA);
                this.Ec.removeUpdates(this.fgB);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.fgw != null) {
            this.fgw.cancel();
            this.fgw = null;
        }
    }
}
