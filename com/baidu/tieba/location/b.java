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
/* loaded from: classes8.dex */
public class b implements com.baidu.adp.lib.c.b {
    private static b les;
    private int errorCode;
    private Context mContext;
    private LocationManager mLocationManager;
    private a let = null;
    private a.b lem = null;
    private Address leu = null;
    private long lastLocationTime = 0;
    private Handler mHandler = null;
    private boolean leq = false;
    private Runnable lev = null;
    private Runnable lew = null;
    private final LocationListener lex = new LocationListener() { // from class: com.baidu.tieba.location.b.1
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
            b.this.mHandler.removeCallbacks(b.this.lew);
            b.this.mHandler.removeCallbacks(b.this.lev);
            if (b.this.let == null) {
                b.this.let = new a();
                b.this.let.setSelfExecute(true);
                b.this.let.execute(location);
            }
        }
    };
    private final LocationListener ley = new LocationListener() { // from class: com.baidu.tieba.location.b.2
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
            b.this.mHandler.removeCallbacks(b.this.lew);
            b.this.mHandler.removeCallbacks(b.this.lev);
            if (b.this.let == null) {
                b.this.let = new a();
                b.this.let.setSelfExecute(true);
                b.this.let.execute(location);
            }
        }
    };

    public static b dfw() {
        if (les == null) {
            synchronized (b.class) {
                if (les == null) {
                    les = new b();
                }
            }
        }
        return les;
    }

    private b() {
    }

    @Override // com.baidu.adp.lib.c.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.lem = bVar;
        try {
            this.mLocationManager = (LocationManager) this.mContext.getSystemService("location");
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.lev = new Runnable() { // from class: com.baidu.tieba.location.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ad.checkLocationForGoogle(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("network", 10000L, 100.0f, b.this.lex);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        };
        this.lew = new Runnable() { // from class: com.baidu.tieba.location.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ad.checkLocationForGoogle(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("gps", 10000L, 100.0f, b.this.ley);
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
                        b.this.lem.onProviderGetLocation(b.this.errorCode, "", null, b.this.lastLocationTime, b.this.leq);
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
        if (this.lem == null) {
            return;
        }
        try {
            if (this.mLocationManager != null) {
                this.mLocationManager.removeUpdates(this.lex);
                this.errorCode = 4;
                this.leq = z;
                if (!ad.checkLocationForGoogle(this.mContext) || (!this.mLocationManager.isProviderEnabled("gps") && !this.mLocationManager.isProviderEnabled("network"))) {
                    this.errorCode = 3;
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.c.a.lI().getTimeOut());
                    return;
                }
                if (ad.checkLocationForGoogle(this.mContext) && this.mLocationManager.isProviderEnabled("gps")) {
                    this.mHandler.post(this.lew);
                } else {
                    this.errorCode = 1;
                }
                if (!z) {
                    if (ad.checkLocationForGoogle(this.mContext) && this.mLocationManager.isProviderEnabled("network")) {
                        this.mHandler.post(this.lev);
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
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.c.a.lI().getTimeOut());
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void destroy() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.lew);
        this.mHandler.removeCallbacks(this.lev);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.lex);
                this.mLocationManager.removeUpdates(this.ley);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.let != null) {
            this.let.cancel();
            this.let = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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
            b.this.let = null;
            if (address != null) {
                b.this.stopLocation();
                b.this.lastLocationTime = System.currentTimeMillis();
                b.this.leu = address;
                b.this.lem.onProviderGetLocation(0, "", b.this.leu, b.this.lastLocationTime, b.this.leq);
                com.baidu.tieba.recapp.c.a.dFN().RR(String.valueOf(address.getLatitude()));
                com.baidu.tieba.recapp.c.a.dFN().RQ(String.valueOf(address.getLongitude()));
                com.baidu.tieba.recapp.c.a.dFN().hw(System.currentTimeMillis());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            b.this.let = null;
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void stopLocation() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.lew);
        this.mHandler.removeCallbacks(this.lev);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.lex);
                this.mLocationManager.removeUpdates(this.ley);
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
        if (this.let != null) {
            this.let.cancel();
            this.let = null;
        }
    }
}
