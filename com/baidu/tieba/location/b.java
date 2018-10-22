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
    private static b fkn;
    private int errorCode;
    private Context mContext;
    private LocationManager mLocationManager;
    private a fko = null;
    private a.b fkh = null;
    private Address fkp = null;
    private long Cd = 0;
    private Handler mHandler = null;
    private boolean fkl = false;
    private Runnable fkq = null;
    private Runnable fkr = null;
    private final LocationListener fks = new LocationListener() { // from class: com.baidu.tieba.location.b.1
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
            b.this.mHandler.removeCallbacks(b.this.fkr);
            b.this.mHandler.removeCallbacks(b.this.fkq);
            if (b.this.fko == null) {
                b.this.fko = new a();
                b.this.fko.setSelfExecute(true);
                b.this.fko.execute(location);
            }
        }
    };
    private final LocationListener fkt = new LocationListener() { // from class: com.baidu.tieba.location.b.2
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
            b.this.mHandler.removeCallbacks(b.this.fkr);
            b.this.mHandler.removeCallbacks(b.this.fkq);
            if (b.this.fko == null) {
                b.this.fko = new a();
                b.this.fko.setSelfExecute(true);
                b.this.fko.execute(location);
            }
        }
    };

    public static b aYj() {
        if (fkn == null) {
            synchronized (b.class) {
                if (fkn == null) {
                    fkn = new b();
                }
            }
        }
        return fkn;
    }

    private b() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.fkh = bVar;
        try {
            this.mLocationManager = (LocationManager) this.mContext.getSystemService(Headers.LOCATION);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.fkq = new Runnable() { // from class: com.baidu.tieba.location.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ab.bB(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("network", ErrDef.Feature.WEIGHT, 100.0f, b.this.fks);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        };
        this.fkr = new Runnable() { // from class: com.baidu.tieba.location.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ab.bB(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("gps", ErrDef.Feature.WEIGHT, 100.0f, b.this.fkt);
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
                        b.this.ja();
                        b.this.fkh.a(b.this.errorCode, "", null, b.this.Cd, b.this.fkl);
                        return false;
                    default:
                        return false;
                }
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [252=4] */
    @Override // com.baidu.adp.lib.d.b
    public void T(boolean z) {
        if (this.fkh == null) {
            return;
        }
        try {
            if (this.mLocationManager != null) {
                this.mLocationManager.removeUpdates(this.fks);
                this.errorCode = 4;
                this.fkl = z;
                if (!ab.bB(this.mContext) || (!this.mLocationManager.isProviderEnabled("gps") && !this.mLocationManager.isProviderEnabled("network"))) {
                    this.errorCode = 3;
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.iX().iY());
                    return;
                }
                if (ab.bB(this.mContext) && this.mLocationManager.isProviderEnabled("gps")) {
                    this.mHandler.post(this.fkr);
                } else {
                    this.errorCode = 1;
                }
                if (!z) {
                    if (ab.bB(this.mContext) && this.mLocationManager.isProviderEnabled("network")) {
                        this.mHandler.post(this.fkq);
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
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.iX().iY());
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void destroy() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.fkr);
        this.mHandler.removeCallbacks(this.fkq);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.fks);
                this.mLocationManager.removeUpdates(this.fkt);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.fko != null) {
            this.fko.cancel();
            this.fko = null;
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
            b.this.fko = null;
            if (address != null) {
                b.this.ja();
                b.this.Cd = System.currentTimeMillis();
                b.this.fkp = address;
                b.this.fkh.a(0, "", b.this.fkp, b.this.Cd, b.this.fkl);
                com.baidu.tieba.recapp.d.a.bua().pc(String.valueOf(address.getLatitude()));
                com.baidu.tieba.recapp.d.a.bua().pb(String.valueOf(address.getLongitude()));
                com.baidu.tieba.recapp.d.a.bua().cZ(System.currentTimeMillis());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            b.this.fko = null;
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void ja() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.fkr);
        this.mHandler.removeCallbacks(this.fkq);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.fks);
                this.mLocationManager.removeUpdates(this.fkt);
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
        if (this.fko != null) {
            this.fko.cancel();
            this.fko = null;
        }
    }
}
