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
import com.baidu.tbadk.core.util.ad;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
/* loaded from: classes17.dex */
public class b implements com.baidu.adp.lib.c.b {
    private static b jFx;
    private int errorCode;
    private Context mContext;
    private LocationManager mLocationManager;
    private a jFy = null;
    private a.b jFs = null;
    private Address jFz = null;
    private long lastLocationTime = 0;
    private Handler mHandler = null;
    private boolean jFv = false;
    private Runnable jFA = null;
    private Runnable jFB = null;
    private final LocationListener jFC = new LocationListener() { // from class: com.baidu.tieba.location.b.1
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
            b.this.mHandler.removeCallbacks(b.this.jFB);
            b.this.mHandler.removeCallbacks(b.this.jFA);
            if (b.this.jFy == null) {
                b.this.jFy = new a();
                b.this.jFy.setSelfExecute(true);
                b.this.jFy.execute(location);
            }
        }
    };
    private final LocationListener jFD = new LocationListener() { // from class: com.baidu.tieba.location.b.2
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
            b.this.mHandler.removeCallbacks(b.this.jFB);
            b.this.mHandler.removeCallbacks(b.this.jFA);
            if (b.this.jFy == null) {
                b.this.jFy = new a();
                b.this.jFy.setSelfExecute(true);
                b.this.jFy.execute(location);
            }
        }
    };

    public static b cDj() {
        if (jFx == null) {
            synchronized (b.class) {
                if (jFx == null) {
                    jFx = new b();
                }
            }
        }
        return jFx;
    }

    private b() {
    }

    @Override // com.baidu.adp.lib.c.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.jFs = bVar;
        try {
            this.mLocationManager = (LocationManager) this.mContext.getSystemService("location");
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.jFA = new Runnable() { // from class: com.baidu.tieba.location.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ad.checkLocationForGoogle(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("network", 10000L, 100.0f, b.this.jFC);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        };
        this.jFB = new Runnable() { // from class: com.baidu.tieba.location.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ad.checkLocationForGoogle(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("gps", 10000L, 100.0f, b.this.jFD);
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
                        b.this.jFs.onProviderGetLocation(b.this.errorCode, "", null, b.this.lastLocationTime, b.this.jFv);
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
        if (this.jFs == null) {
            return;
        }
        try {
            if (this.mLocationManager != null) {
                this.mLocationManager.removeUpdates(this.jFC);
                this.errorCode = 4;
                this.jFv = z;
                if (!ad.checkLocationForGoogle(this.mContext) || (!this.mLocationManager.isProviderEnabled("gps") && !this.mLocationManager.isProviderEnabled("network"))) {
                    this.errorCode = 3;
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.c.a.kG().getTimeOut());
                    return;
                }
                if (ad.checkLocationForGoogle(this.mContext) && this.mLocationManager.isProviderEnabled("gps")) {
                    this.mHandler.post(this.jFB);
                } else {
                    this.errorCode = 1;
                }
                if (!z) {
                    if (ad.checkLocationForGoogle(this.mContext) && this.mLocationManager.isProviderEnabled("network")) {
                        this.mHandler.post(this.jFA);
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
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.c.a.kG().getTimeOut());
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void destroy() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.jFB);
        this.mHandler.removeCallbacks(this.jFA);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.jFC);
                this.mLocationManager.removeUpdates(this.jFD);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.jFy != null) {
            this.jFy.cancel();
            this.jFy = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
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
            b.this.jFy = null;
            if (address != null) {
                b.this.stopLocation();
                b.this.lastLocationTime = System.currentTimeMillis();
                b.this.jFz = address;
                b.this.jFs.onProviderGetLocation(0, "", b.this.jFz, b.this.lastLocationTime, b.this.jFv);
                com.baidu.tieba.recapp.d.a.dcN().Hp(String.valueOf(address.getLatitude()));
                com.baidu.tieba.recapp.d.a.dcN().Ho(String.valueOf(address.getLongitude()));
                com.baidu.tieba.recapp.d.a.dcN().fC(System.currentTimeMillis());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            b.this.jFy = null;
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void stopLocation() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.jFB);
        this.mHandler.removeCallbacks(this.jFA);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.jFC);
                this.mLocationManager.removeUpdates(this.jFD);
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
        if (this.jFy != null) {
            this.jFy.cancel();
            this.jFy = null;
        }
    }
}
