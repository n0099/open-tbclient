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
    private static b gMa;
    private int errorCode;
    private Context mContext;
    private LocationManager mLocationManager;
    private a gMb = null;
    private a.b gLV = null;
    private Address gMc = null;
    private long Cf = 0;
    private Handler mHandler = null;
    private boolean gLY = false;
    private Runnable gMd = null;
    private Runnable gMe = null;
    private final LocationListener gMf = new LocationListener() { // from class: com.baidu.tieba.location.b.1
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
            b.this.mHandler.removeCallbacks(b.this.gMe);
            b.this.mHandler.removeCallbacks(b.this.gMd);
            if (b.this.gMb == null) {
                b.this.gMb = new a();
                b.this.gMb.setSelfExecute(true);
                b.this.gMb.execute(location);
            }
        }
    };
    private final LocationListener gMg = new LocationListener() { // from class: com.baidu.tieba.location.b.2
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
            b.this.mHandler.removeCallbacks(b.this.gMe);
            b.this.mHandler.removeCallbacks(b.this.gMd);
            if (b.this.gMb == null) {
                b.this.gMb = new a();
                b.this.gMb.setSelfExecute(true);
                b.this.gMb.execute(location);
            }
        }
    };

    public static b bBl() {
        if (gMa == null) {
            synchronized (b.class) {
                if (gMa == null) {
                    gMa = new b();
                }
            }
        }
        return gMa;
    }

    private b() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.gLV = bVar;
        try {
            this.mLocationManager = (LocationManager) this.mContext.getSystemService(Headers.LOCATION);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.gMd = new Runnable() { // from class: com.baidu.tieba.location.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ab.cR(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("network", 10000L, 100.0f, b.this.gMf);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        };
        this.gMe = new Runnable() { // from class: com.baidu.tieba.location.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ab.cR(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("gps", 10000L, 100.0f, b.this.gMg);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        };
        iX();
    }

    private void iX() {
        this.mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.tieba.location.b.5
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        b.this.ja();
                        b.this.gLV.a(b.this.errorCode, "", null, b.this.Cf, b.this.gLY);
                        return false;
                    default:
                        return false;
                }
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [252=4] */
    @Override // com.baidu.adp.lib.d.b
    public void ah(boolean z) {
        if (this.gLV == null) {
            return;
        }
        try {
            if (this.mLocationManager != null) {
                this.mLocationManager.removeUpdates(this.gMf);
                this.errorCode = 4;
                this.gLY = z;
                if (!ab.cR(this.mContext) || (!this.mLocationManager.isProviderEnabled("gps") && !this.mLocationManager.isProviderEnabled("network"))) {
                    this.errorCode = 3;
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.iW().iY());
                    return;
                }
                if (ab.cR(this.mContext) && this.mLocationManager.isProviderEnabled("gps")) {
                    this.mHandler.post(this.gMe);
                } else {
                    this.errorCode = 1;
                }
                if (!z) {
                    if (ab.cR(this.mContext) && this.mLocationManager.isProviderEnabled("network")) {
                        this.mHandler.post(this.gMd);
                    } else {
                        this.errorCode = 2;
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            ja();
            this.errorCode = 5;
        } finally {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.iW().iY());
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void destroy() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.gMe);
        this.mHandler.removeCallbacks(this.gMd);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.gMf);
                this.mLocationManager.removeUpdates(this.gMg);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.gMb != null) {
            this.gMb.cancel();
            this.gMb = null;
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
            b.this.gMb = null;
            if (address != null) {
                b.this.ja();
                b.this.Cf = System.currentTimeMillis();
                b.this.gMc = address;
                b.this.gLV.a(0, "", b.this.gMc, b.this.Cf, b.this.gLY);
                com.baidu.tieba.recapp.d.a.bXv().wB(String.valueOf(address.getLatitude()));
                com.baidu.tieba.recapp.d.a.bXv().wA(String.valueOf(address.getLongitude()));
                com.baidu.tieba.recapp.d.a.bXv().dL(System.currentTimeMillis());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            b.this.gMb = null;
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void ja() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.gMe);
        this.mHandler.removeCallbacks(this.gMd);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.gMf);
                this.mLocationManager.removeUpdates(this.gMg);
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
        if (this.gMb != null) {
            this.gMb.cancel();
            this.gMb = null;
        }
    }
}
