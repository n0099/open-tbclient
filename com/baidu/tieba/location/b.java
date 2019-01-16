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
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
/* loaded from: classes3.dex */
public class b implements com.baidu.adp.lib.d.b {
    private static b fwj;
    private int errorCode;
    private Context mContext;
    private LocationManager mLocationManager;
    private a fwk = null;
    private a.b fwe = null;
    private Address fwl = null;
    private long Cg = 0;
    private Handler mHandler = null;
    private boolean fwh = false;
    private Runnable fwm = null;
    private Runnable fwn = null;
    private final LocationListener fwo = new LocationListener() { // from class: com.baidu.tieba.location.b.1
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
            b.this.mHandler.removeCallbacks(b.this.fwn);
            b.this.mHandler.removeCallbacks(b.this.fwm);
            if (b.this.fwk == null) {
                b.this.fwk = new a();
                b.this.fwk.setSelfExecute(true);
                b.this.fwk.execute(location);
            }
        }
    };
    private final LocationListener fwp = new LocationListener() { // from class: com.baidu.tieba.location.b.2
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
            b.this.mHandler.removeCallbacks(b.this.fwn);
            b.this.mHandler.removeCallbacks(b.this.fwm);
            if (b.this.fwk == null) {
                b.this.fwk = new a();
                b.this.fwk.setSelfExecute(true);
                b.this.fwk.execute(location);
            }
        }
    };

    public static b baL() {
        if (fwj == null) {
            synchronized (b.class) {
                if (fwj == null) {
                    fwj = new b();
                }
            }
        }
        return fwj;
    }

    private b() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.fwe = bVar;
        try {
            this.mLocationManager = (LocationManager) this.mContext.getSystemService(Headers.LOCATION);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.fwm = new Runnable() { // from class: com.baidu.tieba.location.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ab.bC(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("network", ErrDef.Feature.WEIGHT, 100.0f, b.this.fwo);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        };
        this.fwn = new Runnable() { // from class: com.baidu.tieba.location.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ab.bC(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("gps", ErrDef.Feature.WEIGHT, 100.0f, b.this.fwp);
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
                        b.this.fwe.a(b.this.errorCode, "", null, b.this.Cg, b.this.fwh);
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
        if (this.fwe == null) {
            return;
        }
        try {
            if (this.mLocationManager != null) {
                this.mLocationManager.removeUpdates(this.fwo);
                this.errorCode = 4;
                this.fwh = z;
                if (!ab.bC(this.mContext) || (!this.mLocationManager.isProviderEnabled("gps") && !this.mLocationManager.isProviderEnabled("network"))) {
                    this.errorCode = 3;
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.iW().iX());
                    return;
                }
                if (ab.bC(this.mContext) && this.mLocationManager.isProviderEnabled("gps")) {
                    this.mHandler.post(this.fwn);
                } else {
                    this.errorCode = 1;
                }
                if (!z) {
                    if (ab.bC(this.mContext) && this.mLocationManager.isProviderEnabled("network")) {
                        this.mHandler.post(this.fwm);
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
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.iW().iX());
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void destroy() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.fwn);
        this.mHandler.removeCallbacks(this.fwm);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.fwo);
                this.mLocationManager.removeUpdates(this.fwp);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.fwk != null) {
            this.fwk.cancel();
            this.fwk = null;
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
            b.this.fwk = null;
            if (address != null) {
                b.this.stopLocation();
                b.this.Cg = System.currentTimeMillis();
                b.this.fwl = address;
                b.this.fwe.a(0, "", b.this.fwl, b.this.Cg, b.this.fwh);
                com.baidu.tieba.recapp.d.a.bwJ().pY(String.valueOf(address.getLatitude()));
                com.baidu.tieba.recapp.d.a.bwJ().pX(String.valueOf(address.getLongitude()));
                com.baidu.tieba.recapp.d.a.bwJ().dg(System.currentTimeMillis());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            b.this.fwk = null;
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void stopLocation() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.fwn);
        this.mHandler.removeCallbacks(this.fwm);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.fwo);
                this.mLocationManager.removeUpdates(this.fwp);
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
        if (this.fwk != null) {
            this.fwk.cancel();
            this.fwk = null;
        }
    }
}
