package com.baidu.tieba.location;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.c.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ae;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
/* loaded from: classes23.dex */
public class b implements com.baidu.adp.lib.c.b {
    private static b kLf;
    private int errorCode;
    private Context mContext;
    private LocationManager mLocationManager;
    private a kLg = null;
    private a.b kLa = null;
    private Address kLh = null;
    private long lastLocationTime = 0;
    private Handler mHandler = null;
    private boolean kLd = false;
    private Runnable kLi = null;
    private Runnable kLj = null;
    private final LocationListener kLk = new LocationListener() { // from class: com.baidu.tieba.location.b.1
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
            b.this.mHandler.removeCallbacks(b.this.kLj);
            b.this.mHandler.removeCallbacks(b.this.kLi);
            if (b.this.kLg == null) {
                b.this.kLg = new a();
                b.this.kLg.setSelfExecute(true);
                b.this.kLg.execute(location);
            }
        }
    };
    private final LocationListener kLl = new LocationListener() { // from class: com.baidu.tieba.location.b.2
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
            b.this.mHandler.removeCallbacks(b.this.kLj);
            b.this.mHandler.removeCallbacks(b.this.kLi);
            if (b.this.kLg == null) {
                b.this.kLg = new a();
                b.this.kLg.setSelfExecute(true);
                b.this.kLg.execute(location);
            }
        }
    };

    public static b dba() {
        if (kLf == null) {
            synchronized (b.class) {
                if (kLf == null) {
                    kLf = new b();
                }
            }
        }
        return kLf;
    }

    private b() {
    }

    @Override // com.baidu.adp.lib.c.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.kLa = bVar;
        try {
            this.mLocationManager = (LocationManager) this.mContext.getSystemService("location");
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.kLi = new Runnable() { // from class: com.baidu.tieba.location.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ae.checkLocationForGoogle(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("network", 10000L, 100.0f, b.this.kLk);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        };
        this.kLj = new Runnable() { // from class: com.baidu.tieba.location.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ae.checkLocationForGoogle(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("gps", 10000L, 100.0f, b.this.kLl);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        };
        initHandler();
    }

    private void initHandler() {
        this.mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.tieba.location.b.5
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        b.this.stopLocation();
                        b.this.kLa.onProviderGetLocation(b.this.errorCode, "", null, b.this.lastLocationTime, b.this.kLd);
                        return false;
                    default:
                        return false;
                }
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [252=4] */
    @Override // com.baidu.adp.lib.c.b
    public void startLocation(boolean z) {
        if (this.kLa == null) {
            return;
        }
        try {
            if (this.mLocationManager != null) {
                this.mLocationManager.removeUpdates(this.kLk);
                this.errorCode = 4;
                this.kLd = z;
                if (!ae.checkLocationForGoogle(this.mContext) || (!this.mLocationManager.isProviderEnabled("gps") && !this.mLocationManager.isProviderEnabled("network"))) {
                    this.errorCode = 3;
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.c.a.mk().getTimeOut());
                    return;
                }
                if (ae.checkLocationForGoogle(this.mContext) && this.mLocationManager.isProviderEnabled("gps")) {
                    this.mHandler.post(this.kLj);
                } else {
                    this.errorCode = 1;
                }
                if (!z) {
                    if (ae.checkLocationForGoogle(this.mContext) && this.mLocationManager.isProviderEnabled("network")) {
                        this.mHandler.post(this.kLi);
                    } else {
                        this.errorCode = 2;
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            stopLocation();
            this.errorCode = 5;
        } finally {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.c.a.mk().getTimeOut());
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void destroy() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.kLj);
        this.mHandler.removeCallbacks(this.kLi);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.kLk);
                this.mLocationManager.removeUpdates(this.kLl);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.kLg != null) {
            this.kLg.cancel();
            this.kLg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
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
        /* renamed from: b */
        public void onPostExecute(Address address) {
            super.onPostExecute(address);
            b.this.kLg = null;
            if (address != null) {
                b.this.stopLocation();
                b.this.lastLocationTime = System.currentTimeMillis();
                b.this.kLh = address;
                b.this.kLa.onProviderGetLocation(0, "", b.this.kLh, b.this.lastLocationTime, b.this.kLd);
                com.baidu.tieba.recapp.d.a.dBc().Mo(String.valueOf(address.getLatitude()));
                com.baidu.tieba.recapp.d.a.dBc().Mn(String.valueOf(address.getLongitude()));
                com.baidu.tieba.recapp.d.a.dBc().gT(System.currentTimeMillis());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            b.this.kLg = null;
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void stopLocation() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.kLj);
        this.mHandler.removeCallbacks(this.kLi);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.kLk);
                this.mLocationManager.removeUpdates(this.kLl);
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
        if (this.kLg != null) {
            this.kLg.cancel();
            this.kLg = null;
        }
    }
}
