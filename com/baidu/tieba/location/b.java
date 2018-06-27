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
import com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ac;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
/* loaded from: classes3.dex */
public class b implements com.baidu.adp.lib.d.b {
    private static b eRs;
    private int errorCode;
    private Context mContext;
    private LocationManager mLocationManager;
    private a eRt = null;
    private a.b eRm = null;
    private Address eRu = null;
    private long ze = 0;
    private Handler mHandler = null;
    private boolean eRq = false;
    private Runnable eRv = null;
    private Runnable eRw = null;
    private final LocationListener eRx = new LocationListener() { // from class: com.baidu.tieba.location.b.1
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
            b.this.mHandler.removeCallbacks(b.this.eRw);
            b.this.mHandler.removeCallbacks(b.this.eRv);
            if (b.this.eRt == null) {
                b.this.eRt = new a();
                b.this.eRt.setSelfExecute(true);
                b.this.eRt.execute(location);
            }
        }
    };
    private final LocationListener eRy = new LocationListener() { // from class: com.baidu.tieba.location.b.2
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
            b.this.mHandler.removeCallbacks(b.this.eRw);
            b.this.mHandler.removeCallbacks(b.this.eRv);
            if (b.this.eRt == null) {
                b.this.eRt = new a();
                b.this.eRt.setSelfExecute(true);
                b.this.eRt.execute(location);
            }
        }
    };

    public static b aRJ() {
        if (eRs == null) {
            synchronized (b.class) {
                if (eRs == null) {
                    eRs = new b();
                }
            }
        }
        return eRs;
    }

    private b() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.eRm = bVar;
        try {
            this.mLocationManager = (LocationManager) this.mContext.getSystemService(Headers.LOCATION);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.eRv = new Runnable() { // from class: com.baidu.tieba.location.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ac.aM(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates(LivenessRecogActivity.f.J, 10000L, 100.0f, b.this.eRx);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        };
        this.eRw = new Runnable() { // from class: com.baidu.tieba.location.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ac.aM(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("gps", 10000L, 100.0f, b.this.eRy);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        };
        hC();
    }

    private void hC() {
        this.mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.tieba.location.b.5
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        b.this.hF();
                        b.this.eRm.a(b.this.errorCode, "", null, b.this.ze, b.this.eRq);
                        return false;
                    default:
                        return false;
                }
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [252=4] */
    @Override // com.baidu.adp.lib.d.b
    public void K(boolean z) {
        if (this.eRm == null) {
            return;
        }
        try {
            if (this.mLocationManager != null) {
                this.mLocationManager.removeUpdates(this.eRx);
                this.errorCode = 4;
                this.eRq = z;
                if (!ac.aM(this.mContext) || (!this.mLocationManager.isProviderEnabled("gps") && !this.mLocationManager.isProviderEnabled(LivenessRecogActivity.f.J))) {
                    this.errorCode = 3;
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.hB().hD());
                    return;
                }
                if (ac.aM(this.mContext) && this.mLocationManager.isProviderEnabled("gps")) {
                    this.mHandler.post(this.eRw);
                } else {
                    this.errorCode = 1;
                }
                if (!z) {
                    if (ac.aM(this.mContext) && this.mLocationManager.isProviderEnabled(LivenessRecogActivity.f.J)) {
                        this.mHandler.post(this.eRv);
                    } else {
                        this.errorCode = 2;
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            hF();
            this.errorCode = 5;
        } finally {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.hB().hD());
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void destroy() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.eRw);
        this.mHandler.removeCallbacks(this.eRv);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.eRx);
                this.mLocationManager.removeUpdates(this.eRy);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.eRt != null) {
            this.eRt.cancel();
            this.eRt = null;
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
            b.this.eRt = null;
            if (address != null) {
                b.this.hF();
                b.this.ze = System.currentTimeMillis();
                b.this.eRu = address;
                b.this.eRm.a(0, "", b.this.eRu, b.this.ze, b.this.eRq);
                com.baidu.tieba.recapp.d.a.bpy().nP(String.valueOf(address.getLatitude()));
                com.baidu.tieba.recapp.d.a.bpy().nO(String.valueOf(address.getLongitude()));
                com.baidu.tieba.recapp.d.a.bpy().cR(System.currentTimeMillis());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            b.this.eRt = null;
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void hF() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.eRw);
        this.mHandler.removeCallbacks(this.eRv);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.eRx);
                this.mLocationManager.removeUpdates(this.eRy);
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
        if (this.eRt != null) {
            this.eRt.cancel();
            this.eRt = null;
        }
    }
}
