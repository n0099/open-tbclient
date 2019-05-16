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
    private static b hdu;
    private int errorCode;
    private Context mContext;
    private LocationManager mLocationManager;
    private a hdv = null;
    private a.b hdp = null;
    private Address hdw = null;
    private long zO = 0;
    private Handler mHandler = null;
    private boolean hds = false;
    private Runnable hdx = null;
    private Runnable hdy = null;
    private final LocationListener hdz = new LocationListener() { // from class: com.baidu.tieba.location.b.1
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
            b.this.mHandler.removeCallbacks(b.this.hdy);
            b.this.mHandler.removeCallbacks(b.this.hdx);
            if (b.this.hdv == null) {
                b.this.hdv = new a();
                b.this.hdv.setSelfExecute(true);
                b.this.hdv.execute(location);
            }
        }
    };
    private final LocationListener hdA = new LocationListener() { // from class: com.baidu.tieba.location.b.2
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
            b.this.mHandler.removeCallbacks(b.this.hdy);
            b.this.mHandler.removeCallbacks(b.this.hdx);
            if (b.this.hdv == null) {
                b.this.hdv = new a();
                b.this.hdv.setSelfExecute(true);
                b.this.hdv.execute(location);
            }
        }
    };

    public static b bIV() {
        if (hdu == null) {
            synchronized (b.class) {
                if (hdu == null) {
                    hdu = new b();
                }
            }
        }
        return hdu;
    }

    private b() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.hdp = bVar;
        try {
            this.mLocationManager = (LocationManager) this.mContext.getSystemService(Headers.LOCATION);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.hdx = new Runnable() { // from class: com.baidu.tieba.location.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ab.cw(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("network", 10000L, 100.0f, b.this.hdz);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        };
        this.hdy = new Runnable() { // from class: com.baidu.tieba.location.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ab.cw(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("gps", 10000L, 100.0f, b.this.hdA);
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
                        b.this.hdp.a(b.this.errorCode, "", null, b.this.zO, b.this.hds);
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
        if (this.hdp == null) {
            return;
        }
        try {
            if (this.mLocationManager != null) {
                this.mLocationManager.removeUpdates(this.hdz);
                this.errorCode = 4;
                this.hds = z;
                if (!ab.cw(this.mContext) || (!this.mLocationManager.isProviderEnabled("gps") && !this.mLocationManager.isProviderEnabled("network"))) {
                    this.errorCode = 3;
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.hO().hQ());
                    return;
                }
                if (ab.cw(this.mContext) && this.mLocationManager.isProviderEnabled("gps")) {
                    this.mHandler.post(this.hdy);
                } else {
                    this.errorCode = 1;
                }
                if (!z) {
                    if (ab.cw(this.mContext) && this.mLocationManager.isProviderEnabled("network")) {
                        this.mHandler.post(this.hdx);
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
        this.mHandler.removeCallbacks(this.hdy);
        this.mHandler.removeCallbacks(this.hdx);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.hdz);
                this.mLocationManager.removeUpdates(this.hdA);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.hdv != null) {
            this.hdv.cancel();
            this.hdv = null;
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
            b.this.hdv = null;
            if (address != null) {
                b.this.hS();
                b.this.zO = System.currentTimeMillis();
                b.this.hdw = address;
                b.this.hdp.a(0, "", b.this.hdw, b.this.zO, b.this.hds);
                com.baidu.tieba.recapp.d.a.cfz().xQ(String.valueOf(address.getLatitude()));
                com.baidu.tieba.recapp.d.a.cfz().xP(String.valueOf(address.getLongitude()));
                com.baidu.tieba.recapp.d.a.cfz().ej(System.currentTimeMillis());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            b.this.hdv = null;
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void hS() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.hdy);
        this.mHandler.removeCallbacks(this.hdx);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.hdz);
                this.mLocationManager.removeUpdates(this.hdA);
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
        if (this.hdv != null) {
            this.hdv.cancel();
            this.hdv = null;
        }
    }
}
