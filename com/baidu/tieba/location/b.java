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
import com.baidu.tbadk.core.util.ab;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
/* loaded from: classes8.dex */
public class b implements com.baidu.adp.lib.c.b {
    private static b ibY;
    private int errorCode;
    private Context mContext;
    private LocationManager mLocationManager;
    private a ibZ = null;
    private a.b ibT = null;
    private Address ica = null;
    private long lastLocationTime = 0;
    private Handler mHandler = null;
    private boolean ibW = false;
    private Runnable icb = null;
    private Runnable icc = null;
    private final LocationListener icd = new LocationListener() { // from class: com.baidu.tieba.location.b.1
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
            b.this.mHandler.removeCallbacks(b.this.icc);
            b.this.mHandler.removeCallbacks(b.this.icb);
            if (b.this.ibZ == null) {
                b.this.ibZ = new a();
                b.this.ibZ.setSelfExecute(true);
                b.this.ibZ.execute(location);
            }
        }
    };
    private final LocationListener ice = new LocationListener() { // from class: com.baidu.tieba.location.b.2
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
            b.this.mHandler.removeCallbacks(b.this.icc);
            b.this.mHandler.removeCallbacks(b.this.icb);
            if (b.this.ibZ == null) {
                b.this.ibZ = new a();
                b.this.ibZ.setSelfExecute(true);
                b.this.ibZ.execute(location);
            }
        }
    };

    public static b cce() {
        if (ibY == null) {
            synchronized (b.class) {
                if (ibY == null) {
                    ibY = new b();
                }
            }
        }
        return ibY;
    }

    private b() {
    }

    @Override // com.baidu.adp.lib.c.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.ibT = bVar;
        try {
            this.mLocationManager = (LocationManager) this.mContext.getSystemService("location");
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.icb = new Runnable() { // from class: com.baidu.tieba.location.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ab.checkLocationForGoogle(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("network", 10000L, 100.0f, b.this.icd);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        };
        this.icc = new Runnable() { // from class: com.baidu.tieba.location.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ab.checkLocationForGoogle(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("gps", 10000L, 100.0f, b.this.ice);
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
                        b.this.ibT.onProviderGetLocation(b.this.errorCode, "", null, b.this.lastLocationTime, b.this.ibW);
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
        if (this.ibT == null) {
            return;
        }
        try {
            if (this.mLocationManager != null) {
                this.mLocationManager.removeUpdates(this.icd);
                this.errorCode = 4;
                this.ibW = z;
                if (!ab.checkLocationForGoogle(this.mContext) || (!this.mLocationManager.isProviderEnabled("gps") && !this.mLocationManager.isProviderEnabled("network"))) {
                    this.errorCode = 3;
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.c.a.fK().getTimeOut());
                    return;
                }
                if (ab.checkLocationForGoogle(this.mContext) && this.mLocationManager.isProviderEnabled("gps")) {
                    this.mHandler.post(this.icc);
                } else {
                    this.errorCode = 1;
                }
                if (!z) {
                    if (ab.checkLocationForGoogle(this.mContext) && this.mLocationManager.isProviderEnabled("network")) {
                        this.mHandler.post(this.icb);
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
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.c.a.fK().getTimeOut());
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void destroy() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.icc);
        this.mHandler.removeCallbacks(this.icb);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.icd);
                this.mLocationManager.removeUpdates(this.ice);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.ibZ != null) {
            this.ibZ.cancel();
            this.ibZ = null;
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
            b.this.ibZ = null;
            if (address != null) {
                b.this.stopLocation();
                b.this.lastLocationTime = System.currentTimeMillis();
                b.this.ica = address;
                b.this.ibT.onProviderGetLocation(0, "", b.this.ica, b.this.lastLocationTime, b.this.ibW);
                com.baidu.tieba.recapp.d.a.cBM().Co(String.valueOf(address.getLatitude()));
                com.baidu.tieba.recapp.d.a.cBM().Cn(String.valueOf(address.getLongitude()));
                com.baidu.tieba.recapp.d.a.cBM().eC(System.currentTimeMillis());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            b.this.ibZ = null;
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void stopLocation() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.icc);
        this.mHandler.removeCallbacks(this.icb);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.icd);
                this.mLocationManager.removeUpdates(this.ice);
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
        if (this.ibZ != null) {
            this.ibZ.cancel();
            this.ibZ = null;
        }
    }
}
