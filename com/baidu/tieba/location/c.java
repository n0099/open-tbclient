package com.baidu.tieba.location;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.d.d {
    private static c bUh;
    private LocationManager bUj;
    private int errorCode;
    private Context mContext;
    private a bUi = null;
    private a.b bUb = null;
    private Address bUk = null;
    private long ur = 0;
    private Handler mHandler = null;
    private boolean bUf = false;
    private Runnable bUl = null;
    private Runnable bUm = null;
    private final LocationListener bUn = new d(this);
    private final LocationListener bUo = new e(this);

    public static c abq() {
        if (bUh == null) {
            synchronized (c.class) {
                if (bUh == null) {
                    bUh = new c();
                }
            }
        }
        return bUh;
    }

    private c() {
    }

    @Override // com.baidu.adp.lib.d.d
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.m411getInst().getContext();
        this.bUb = bVar;
        try {
            this.bUj = (LocationManager) this.mContext.getSystemService("location");
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.bUl = new f(this);
        this.bUm = new g(this);
        gD();
    }

    private void gD() {
        this.mHandler = new Handler(Looper.getMainLooper(), new h(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [248=4] */
    @Override // com.baidu.adp.lib.d.d
    public void A(boolean z) {
        if (this.bUb == null) {
            return;
        }
        try {
            if (this.bUj != null) {
                this.bUj.removeUpdates(this.bUn);
                this.errorCode = 4;
                this.bUf = z;
                if (!this.bUj.isProviderEnabled("gps") && !this.bUj.isProviderEnabled("network")) {
                    this.errorCode = 3;
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.uq);
                    return;
                }
                if (this.bUj.isProviderEnabled("gps")) {
                    this.mHandler.post(this.bUm);
                } else {
                    this.errorCode = 1;
                }
                if (!z) {
                    if (this.bUj.isProviderEnabled("network")) {
                        this.mHandler.post(this.bUl);
                    } else {
                        this.errorCode = 2;
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            gF();
            this.errorCode = 5;
        } finally {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.d.a.uq);
        }
    }

    @Override // com.baidu.adp.lib.d.d
    public void destroy() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.bUm);
        this.mHandler.removeCallbacks(this.bUl);
        if (this.bUj != null) {
            try {
                this.bUj.removeUpdates(this.bUn);
                this.bUj.removeUpdates(this.bUo);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.bUi != null) {
            this.bUi.cancel();
            this.bUi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Location, Void, Address> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(c cVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Address doInBackground(Location... locationArr) {
            List<Address> list;
            Geocoder geocoder = new Geocoder(c.this.mContext, Locale.getDefault());
            if (locationArr == null || locationArr.length < 1) {
                return null;
            }
            Location location = locationArr[0];
            try {
                list = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            } catch (IOException e) {
                list = null;
            } catch (IllegalArgumentException e2) {
                list = null;
            }
            if (list == null || list.size() <= 0) {
                return null;
            }
            Address address = list.get(0);
            StringBuffer stringBuffer = new StringBuffer();
            if (address.getSubLocality() == null || address.getThoroughfare() == null) {
                stringBuffer.append(address.getLocality());
            }
            stringBuffer.append(address.getSubLocality());
            stringBuffer.append(address.getThoroughfare());
            address.setAddressLine(0, stringBuffer.toString());
            return address;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(Address address) {
            super.onPostExecute(address);
            c.this.bUi = null;
            if (address != null) {
                c.this.gF();
                c.this.ur = System.currentTimeMillis();
                c.this.bUk = address;
                c.this.bUb.a(0, "", c.this.bUk, c.this.ur, c.this.bUf);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            c.this.bUi = null;
        }
    }

    @Override // com.baidu.adp.lib.d.d
    public void gF() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.bUm);
        this.mHandler.removeCallbacks(this.bUl);
        if (this.bUj != null) {
            try {
                this.bUj.removeUpdates(this.bUn);
                this.bUj.removeUpdates(this.bUo);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.bUi != null) {
            this.bUi.cancel();
            this.bUi = null;
        }
    }
}
