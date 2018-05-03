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
import com.baidu.tbadk.core.util.ab;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
/* loaded from: classes3.dex */
public class b implements com.baidu.adp.lib.d.b {
    private static b eAZ;
    private int errorCode;
    private Context mContext;
    private LocationManager mLocationManager;
    private a eBa = null;
    private a.b eAT = null;
    private Address eBb = null;
    private long sX = 0;
    private Handler mHandler = null;
    private boolean eAX = false;
    private Runnable eBc = null;
    private Runnable eBd = null;
    private final LocationListener eBe = new LocationListener() { // from class: com.baidu.tieba.location.b.1
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
            b.this.mHandler.removeCallbacks(b.this.eBd);
            b.this.mHandler.removeCallbacks(b.this.eBc);
            if (b.this.eBa == null) {
                b.this.eBa = new a();
                b.this.eBa.setSelfExecute(true);
                b.this.eBa.execute(location);
            }
        }
    };
    private final LocationListener eBf = new LocationListener() { // from class: com.baidu.tieba.location.b.2
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
            b.this.mHandler.removeCallbacks(b.this.eBd);
            b.this.mHandler.removeCallbacks(b.this.eBc);
            if (b.this.eBa == null) {
                b.this.eBa = new a();
                b.this.eBa.setSelfExecute(true);
                b.this.eBa.execute(location);
            }
        }
    };

    public static b aMh() {
        if (eAZ == null) {
            synchronized (b.class) {
                if (eAZ == null) {
                    eAZ = new b();
                }
            }
        }
        return eAZ;
    }

    private b() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.eAT = bVar;
        try {
            this.mLocationManager = (LocationManager) this.mContext.getSystemService(Headers.LOCATION);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.eBc = new Runnable() { // from class: com.baidu.tieba.location.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ab.aC(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates(LivenessRecogActivity.f.J, 10000L, 100.0f, b.this.eBe);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        };
        this.eBd = new Runnable() { // from class: com.baidu.tieba.location.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ab.aC(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("gps", 10000L, 100.0f, b.this.eBf);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        };
        eL();
    }

    private void eL() {
        this.mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.tieba.location.b.5
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        b.this.eO();
                        b.this.eAT.a(b.this.errorCode, "", null, b.this.sX, b.this.eAX);
                        return false;
                    default:
                        return false;
                }
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [252=4] */
    @Override // com.baidu.adp.lib.d.b
    public void I(boolean z) {
        if (this.eAT == null) {
            return;
        }
        try {
            if (this.mLocationManager != null) {
                this.mLocationManager.removeUpdates(this.eBe);
                this.errorCode = 4;
                this.eAX = z;
                if (!ab.aC(this.mContext) || (!this.mLocationManager.isProviderEnabled("gps") && !this.mLocationManager.isProviderEnabled(LivenessRecogActivity.f.J))) {
                    this.errorCode = 3;
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.eK().eM());
                    return;
                }
                if (ab.aC(this.mContext) && this.mLocationManager.isProviderEnabled("gps")) {
                    this.mHandler.post(this.eBd);
                } else {
                    this.errorCode = 1;
                }
                if (!z) {
                    if (ab.aC(this.mContext) && this.mLocationManager.isProviderEnabled(LivenessRecogActivity.f.J)) {
                        this.mHandler.post(this.eBc);
                    } else {
                        this.errorCode = 2;
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            eO();
            this.errorCode = 5;
        } finally {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.eK().eM());
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void destroy() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.eBd);
        this.mHandler.removeCallbacks(this.eBc);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.eBe);
                this.mLocationManager.removeUpdates(this.eBf);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.eBa != null) {
            this.eBa.cancel();
            this.eBa = null;
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
            b.this.eBa = null;
            if (address != null) {
                b.this.eO();
                b.this.sX = System.currentTimeMillis();
                b.this.eBb = address;
                b.this.eAT.a(0, "", b.this.eBb, b.this.sX, b.this.eAX);
                com.baidu.tieba.recapp.d.a.bjZ().mZ(String.valueOf(address.getLatitude()));
                com.baidu.tieba.recapp.d.a.bjZ().mY(String.valueOf(address.getLongitude()));
                com.baidu.tieba.recapp.d.a.bjZ().cQ(System.currentTimeMillis());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            b.this.eBa = null;
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void eO() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.eBd);
        this.mHandler.removeCallbacks(this.eBc);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.eBe);
                this.mLocationManager.removeUpdates(this.eBf);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.eBa != null) {
            this.eBa.cancel();
            this.eBa = null;
        }
    }
}
