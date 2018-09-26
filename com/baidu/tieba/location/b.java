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
/* loaded from: classes3.dex */
public class b implements com.baidu.adp.lib.d.b {
    private static b fcD;
    private int errorCode;
    private Context mContext;
    private LocationManager mLocationManager;
    private a fcE = null;
    private a.b fcx = null;
    private Address fcF = null;
    private long Bv = 0;
    private Handler mHandler = null;
    private boolean fcB = false;
    private Runnable fcG = null;
    private Runnable fcH = null;
    private final LocationListener fcI = new LocationListener() { // from class: com.baidu.tieba.location.b.1
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
            b.this.mHandler.removeCallbacks(b.this.fcH);
            b.this.mHandler.removeCallbacks(b.this.fcG);
            if (b.this.fcE == null) {
                b.this.fcE = new a();
                b.this.fcE.setSelfExecute(true);
                b.this.fcE.execute(location);
            }
        }
    };
    private final LocationListener fcJ = new LocationListener() { // from class: com.baidu.tieba.location.b.2
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
            b.this.mHandler.removeCallbacks(b.this.fcH);
            b.this.mHandler.removeCallbacks(b.this.fcG);
            if (b.this.fcE == null) {
                b.this.fcE = new a();
                b.this.fcE.setSelfExecute(true);
                b.this.fcE.execute(location);
            }
        }
    };

    public static b aUW() {
        if (fcD == null) {
            synchronized (b.class) {
                if (fcD == null) {
                    fcD = new b();
                }
            }
        }
        return fcD;
    }

    private b() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.fcx = bVar;
        try {
            this.mLocationManager = (LocationManager) this.mContext.getSystemService(Headers.LOCATION);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.fcG = new Runnable() { // from class: com.baidu.tieba.location.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ab.bs(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("network", 10000L, 100.0f, b.this.fcI);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        };
        this.fcH = new Runnable() { // from class: com.baidu.tieba.location.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mLocationManager != null && ab.bs(b.this.mContext)) {
                    try {
                        b.this.mLocationManager.requestLocationUpdates("gps", 10000L, 100.0f, b.this.fcJ);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        };
        iI();
    }

    private void iI() {
        this.mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.tieba.location.b.5
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        b.this.iL();
                        b.this.fcx.a(b.this.errorCode, "", null, b.this.Bv, b.this.fcB);
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
        if (this.fcx == null) {
            return;
        }
        try {
            if (this.mLocationManager != null) {
                this.mLocationManager.removeUpdates(this.fcI);
                this.errorCode = 4;
                this.fcB = z;
                if (!ab.bs(this.mContext) || (!this.mLocationManager.isProviderEnabled("gps") && !this.mLocationManager.isProviderEnabled("network"))) {
                    this.errorCode = 3;
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.iH().iJ());
                    return;
                }
                if (ab.bs(this.mContext) && this.mLocationManager.isProviderEnabled("gps")) {
                    this.mHandler.post(this.fcH);
                } else {
                    this.errorCode = 1;
                }
                if (!z) {
                    if (ab.bs(this.mContext) && this.mLocationManager.isProviderEnabled("network")) {
                        this.mHandler.post(this.fcG);
                    } else {
                        this.errorCode = 2;
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            iL();
            this.errorCode = 5;
        } finally {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.iH().iJ());
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void destroy() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.fcH);
        this.mHandler.removeCallbacks(this.fcG);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.fcI);
                this.mLocationManager.removeUpdates(this.fcJ);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.fcE != null) {
            this.fcE.cancel();
            this.fcE = null;
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
            b.this.fcE = null;
            if (address != null) {
                b.this.iL();
                b.this.Bv = System.currentTimeMillis();
                b.this.fcF = address;
                b.this.fcx.a(0, "", b.this.fcF, b.this.Bv, b.this.fcB);
                com.baidu.tieba.recapp.d.a.bqL().oA(String.valueOf(address.getLatitude()));
                com.baidu.tieba.recapp.d.a.bqL().oz(String.valueOf(address.getLongitude()));
                com.baidu.tieba.recapp.d.a.bqL().cS(System.currentTimeMillis());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            b.this.fcE = null;
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void iL() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.fcH);
        this.mHandler.removeCallbacks(this.fcG);
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.fcI);
                this.mLocationManager.removeUpdates(this.fcJ);
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
        if (this.fcE != null) {
            this.fcE.cancel();
            this.fcE = null;
        }
    }
}
