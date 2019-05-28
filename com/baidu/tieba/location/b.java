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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
/* loaded from: classes5.dex */
public class b implements com.baidu.adp.lib.d.b {
    private static b hdx;
    private int errorCode;
    private Context mContext;
    private LocationManager mLocationManager;
    private a hdy = null;
    private a.b hds = null;
    private Address hdz = null;
    private long zO = 0;
    private Handler mHandler = null;
    private boolean hdv = false;
    private Runnable hdA = null;
    private Runnable hdB = null;
    private final LocationListener hdC = new LocationListener() { // from class: com.baidu.tieba.location.b.1
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
            b.this.mHandler.removeCallbacks(b.this.hdB);
            b.this.mHandler.removeCallbacks(b.this.hdA);
            if (b.this.hdy == null) {
                b.this.hdy = new a();
                b.this.hdy.setSelfExecute(true);
                b.this.hdy.execute(location);
            }
        }
    };
    private final LocationListener hdD = new LocationListener() { // from class: com.baidu.tieba.location.b.2
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
            b.this.mHandler.removeCallbacks(b.this.hdB);
            b.this.mHandler.removeCallbacks(b.this.hdA);
            if (b.this.hdy == null) {
                b.this.hdy = new a();
                b.this.hdy.setSelfExecute(true);
                b.this.hdy.execute(location);
            }
        }
    };

    public static b bIY() {
        if (hdx == null) {
            synchronized (b.class) {
                if (hdx == null) {
                    hdx = new b();
                }
            }
        }
        return hdx;
    }

    private b() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.hds = bVar;
        try {
            this.mLocationManager = (LocationManager) this.mContext.getSystemService(Headers.LOCATION);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.hdA = new Runnable() { // from class: com.baidu.tieba.location.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ab.cw(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("network", 10000L, 100.0f, b.this.hdC);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        };
        this.hdB = new Runnable() { // from class: com.baidu.tieba.location.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ab.cw(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("gps", 10000L, 100.0f, b.this.hdD);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        };
        hP();
    }

    private void hP() {
        this.mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.tieba.location.b.5
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        b.this.hS();
                        b.this.hds.a(b.this.errorCode, "", null, b.this.zO, b.this.hdv);
                        return false;
                    default:
                        return false;
                }
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [252=4] */
    @Override // com.baidu.adp.lib.d.b
    public void Z(boolean z) {
        if (this.hds == null) {
            return;
        }
        try {
            if (this.mLocationManager != null) {
                this.mLocationManager.removeUpdates(this.hdC);
                this.errorCode = 4;
                this.hdv = z;
                if (!ab.cw(this.mContext) || (!this.mLocationManager.isProviderEnabled("gps") && !this.mLocationManager.isProviderEnabled("network"))) {
                    this.errorCode = 3;
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.hO().hQ());
                    return;
                }
                if (ab.cw(this.mContext) && this.mLocationManager.isProviderEnabled("gps")) {
                    this.mHandler.post(this.hdB);
                } else {
                    this.errorCode = 1;
                }
                if (!z) {
                    if (ab.cw(this.mContext) && this.mLocationManager.isProviderEnabled("network")) {
                        this.mHandler.post(this.hdA);
                    } else {
                        this.errorCode = 2;
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            hS();
            this.errorCode = 5;
        } finally {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.hO().hQ());
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void destroy() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.hdB);
        this.mHandler.removeCallbacks(this.hdA);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.hdC);
                this.mLocationManager.removeUpdates(this.hdD);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.hdy != null) {
            this.hdy.cancel();
            this.hdy = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
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
            b.this.hdy = null;
            if (address != null) {
                b.this.hS();
                b.this.zO = System.currentTimeMillis();
                b.this.hdz = address;
                b.this.hds.a(0, "", b.this.hdz, b.this.zO, b.this.hdv);
                com.baidu.tieba.recapp.d.a.cfB().xQ(String.valueOf(address.getLatitude()));
                com.baidu.tieba.recapp.d.a.cfB().xP(String.valueOf(address.getLongitude()));
                com.baidu.tieba.recapp.d.a.cfB().ej(System.currentTimeMillis());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            b.this.hdy = null;
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void hS() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.hdB);
        this.mHandler.removeCallbacks(this.hdA);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.hdC);
                this.mLocationManager.removeUpdates(this.hdD);
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
        if (this.hdy != null) {
            this.hdy.cancel();
            this.hdy = null;
        }
    }
}
