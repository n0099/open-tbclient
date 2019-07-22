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
    private static b hjL;
    private int errorCode;
    private Context mContext;
    private LocationManager mLocationManager;
    private a hjM = null;
    private a.b hjG = null;
    private Address hjN = null;
    private long zT = 0;
    private Handler mHandler = null;
    private boolean hjJ = false;
    private Runnable hjO = null;
    private Runnable hjP = null;
    private final LocationListener hjQ = new LocationListener() { // from class: com.baidu.tieba.location.b.1
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
            b.this.mHandler.removeCallbacks(b.this.hjP);
            b.this.mHandler.removeCallbacks(b.this.hjO);
            if (b.this.hjM == null) {
                b.this.hjM = new a();
                b.this.hjM.setSelfExecute(true);
                b.this.hjM.execute(location);
            }
        }
    };
    private final LocationListener hjR = new LocationListener() { // from class: com.baidu.tieba.location.b.2
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
            b.this.mHandler.removeCallbacks(b.this.hjP);
            b.this.mHandler.removeCallbacks(b.this.hjO);
            if (b.this.hjM == null) {
                b.this.hjM = new a();
                b.this.hjM.setSelfExecute(true);
                b.this.hjM.execute(location);
            }
        }
    };

    public static b bLG() {
        if (hjL == null) {
            synchronized (b.class) {
                if (hjL == null) {
                    hjL = new b();
                }
            }
        }
        return hjL;
    }

    private b() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.hjG = bVar;
        try {
            this.mLocationManager = (LocationManager) this.mContext.getSystemService(Headers.LOCATION);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.hjO = new Runnable() { // from class: com.baidu.tieba.location.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ab.cx(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("network", 10000L, 100.0f, b.this.hjQ);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        };
        this.hjP = new Runnable() { // from class: com.baidu.tieba.location.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ab.cx(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("gps", 10000L, 100.0f, b.this.hjR);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        };
        hZ();
    }

    private void hZ() {
        this.mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.tieba.location.b.5
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        b.this.ic();
                        b.this.hjG.a(b.this.errorCode, "", null, b.this.zT, b.this.hjJ);
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
        if (this.hjG == null) {
            return;
        }
        try {
            if (this.mLocationManager != null) {
                this.mLocationManager.removeUpdates(this.hjQ);
                this.errorCode = 4;
                this.hjJ = z;
                if (!ab.cx(this.mContext) || (!this.mLocationManager.isProviderEnabled("gps") && !this.mLocationManager.isProviderEnabled("network"))) {
                    this.errorCode = 3;
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.hY().ia());
                    return;
                }
                if (ab.cx(this.mContext) && this.mLocationManager.isProviderEnabled("gps")) {
                    this.mHandler.post(this.hjP);
                } else {
                    this.errorCode = 1;
                }
                if (!z) {
                    if (ab.cx(this.mContext) && this.mLocationManager.isProviderEnabled("network")) {
                        this.mHandler.post(this.hjO);
                    } else {
                        this.errorCode = 2;
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            ic();
            this.errorCode = 5;
        } finally {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.hY().ia());
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void destroy() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.hjP);
        this.mHandler.removeCallbacks(this.hjO);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.hjQ);
                this.mLocationManager.removeUpdates(this.hjR);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.hjM != null) {
            this.hjM.cancel();
            this.hjM = null;
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
            b.this.hjM = null;
            if (address != null) {
                b.this.ic();
                b.this.zT = System.currentTimeMillis();
                b.this.hjN = address;
                b.this.hjG.a(0, "", b.this.hjN, b.this.zT, b.this.hjJ);
                com.baidu.tieba.recapp.d.a.cit().yC(String.valueOf(address.getLatitude()));
                com.baidu.tieba.recapp.d.a.cit().yB(String.valueOf(address.getLongitude()));
                com.baidu.tieba.recapp.d.a.cit().et(System.currentTimeMillis());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            b.this.hjM = null;
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void ic() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.hjP);
        this.mHandler.removeCallbacks(this.hjO);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.hjQ);
                this.mLocationManager.removeUpdates(this.hjR);
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
        if (this.hjM != null) {
            this.hjM.cancel();
            this.hjM = null;
        }
    }
}
