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
    private static b fsx;
    private int errorCode;
    private Context mContext;
    private LocationManager mLocationManager;
    private a fsy = null;
    private a.b fss = null;
    private Address fsz = null;
    private long Cg = 0;
    private Handler mHandler = null;
    private boolean fsv = false;
    private Runnable fsA = null;
    private Runnable fsB = null;
    private final LocationListener fsC = new LocationListener() { // from class: com.baidu.tieba.location.b.1
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
            b.this.mHandler.removeCallbacks(b.this.fsB);
            b.this.mHandler.removeCallbacks(b.this.fsA);
            if (b.this.fsy == null) {
                b.this.fsy = new a();
                b.this.fsy.setSelfExecute(true);
                b.this.fsy.execute(location);
            }
        }
    };
    private final LocationListener fsD = new LocationListener() { // from class: com.baidu.tieba.location.b.2
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
            b.this.mHandler.removeCallbacks(b.this.fsB);
            b.this.mHandler.removeCallbacks(b.this.fsA);
            if (b.this.fsy == null) {
                b.this.fsy = new a();
                b.this.fsy.setSelfExecute(true);
                b.this.fsy.execute(location);
            }
        }
    };

    public static b aZy() {
        if (fsx == null) {
            synchronized (b.class) {
                if (fsx == null) {
                    fsx = new b();
                }
            }
        }
        return fsx;
    }

    private b() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.fss = bVar;
        try {
            this.mLocationManager = (LocationManager) this.mContext.getSystemService(Headers.LOCATION);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.fsA = new Runnable() { // from class: com.baidu.tieba.location.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ab.bC(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("network", ErrDef.Feature.WEIGHT, 100.0f, b.this.fsC);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        };
        this.fsB = new Runnable() { // from class: com.baidu.tieba.location.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ab.bC(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("gps", ErrDef.Feature.WEIGHT, 100.0f, b.this.fsD);
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
                        b.this.fss.a(b.this.errorCode, "", null, b.this.Cg, b.this.fsv);
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
        if (this.fss == null) {
            return;
        }
        try {
            if (this.mLocationManager != null) {
                this.mLocationManager.removeUpdates(this.fsC);
                this.errorCode = 4;
                this.fsv = z;
                if (!ab.bC(this.mContext) || (!this.mLocationManager.isProviderEnabled("gps") && !this.mLocationManager.isProviderEnabled("network"))) {
                    this.errorCode = 3;
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.iW().iX());
                    return;
                }
                if (ab.bC(this.mContext) && this.mLocationManager.isProviderEnabled("gps")) {
                    this.mHandler.post(this.fsB);
                } else {
                    this.errorCode = 1;
                }
                if (!z) {
                    if (ab.bC(this.mContext) && this.mLocationManager.isProviderEnabled("network")) {
                        this.mHandler.post(this.fsA);
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
        this.mHandler.removeCallbacks(this.fsB);
        this.mHandler.removeCallbacks(this.fsA);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.fsC);
                this.mLocationManager.removeUpdates(this.fsD);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.fsy != null) {
            this.fsy.cancel();
            this.fsy = null;
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
            b.this.fsy = null;
            if (address != null) {
                b.this.stopLocation();
                b.this.Cg = System.currentTimeMillis();
                b.this.fsz = address;
                b.this.fss.a(0, "", b.this.fsz, b.this.Cg, b.this.fsv);
                com.baidu.tieba.recapp.d.a.bvp().pF(String.valueOf(address.getLatitude()));
                com.baidu.tieba.recapp.d.a.bvp().pE(String.valueOf(address.getLongitude()));
                com.baidu.tieba.recapp.d.a.bvp().db(System.currentTimeMillis());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            b.this.fsy = null;
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void stopLocation() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.fsB);
        this.mHandler.removeCallbacks(this.fsA);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.fsC);
                this.mLocationManager.removeUpdates(this.fsD);
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
        if (this.fsy != null) {
            this.fsy.cancel();
            this.fsy = null;
        }
    }
}
