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
import com.baidu.adp.lib.e.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.e.d {
    private static c cvi;
    private LocationManager cvk;
    private int errorCode;
    private Context mContext;
    private a cvj = null;
    private a.b cvc = null;
    private Address cvl = null;
    private long uI = 0;
    private Handler mHandler = null;
    private boolean cvg = false;
    private Runnable cvm = null;
    private Runnable cvn = null;
    private final LocationListener cvo = new d(this);
    private final LocationListener cvp = new e(this);

    public static c akh() {
        if (cvi == null) {
            synchronized (c.class) {
                if (cvi == null) {
                    cvi = new c();
                }
            }
        }
        return cvi;
    }

    private c() {
    }

    @Override // com.baidu.adp.lib.e.d
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.m411getInst().getContext();
        this.cvc = bVar;
        try {
            this.cvk = (LocationManager) this.mContext.getSystemService("location");
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.cvm = new f(this);
        this.cvn = new g(this);
        gM();
    }

    private void gM() {
        this.mHandler = new Handler(Looper.getMainLooper(), new h(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [248=4] */
    @Override // com.baidu.adp.lib.e.d
    public void A(boolean z) {
        if (this.cvc == null) {
            return;
        }
        try {
            if (this.cvk != null) {
                this.cvk.removeUpdates(this.cvo);
                this.errorCode = 4;
                this.cvg = z;
                if (!this.cvk.isProviderEnabled("gps") && !this.cvk.isProviderEnabled("network")) {
                    this.errorCode = 3;
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.e.a.gL().gN());
                    return;
                }
                if (this.cvk.isProviderEnabled("gps")) {
                    this.mHandler.post(this.cvn);
                } else {
                    this.errorCode = 1;
                }
                if (!z) {
                    if (this.cvk.isProviderEnabled("network")) {
                        this.mHandler.post(this.cvm);
                    } else {
                        this.errorCode = 2;
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            gP();
            this.errorCode = 5;
        } finally {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), com.baidu.adp.lib.e.a.gL().gN());
        }
    }

    @Override // com.baidu.adp.lib.e.d
    public void destroy() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.cvn);
        this.mHandler.removeCallbacks(this.cvm);
        if (this.cvk != null) {
            try {
                this.cvk.removeUpdates(this.cvo);
                this.cvk.removeUpdates(this.cvp);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.cvj != null) {
            this.cvj.cancel();
            this.cvj = null;
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
            c.this.cvj = null;
            if (address != null) {
                c.this.gP();
                c.this.uI = System.currentTimeMillis();
                c.this.cvl = address;
                c.this.cvc.a(0, "", c.this.cvl, c.this.uI, c.this.cvg);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            c.this.cvj = null;
        }
    }

    @Override // com.baidu.adp.lib.e.d
    public void gP() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.removeCallbacks(this.cvn);
        this.mHandler.removeCallbacks(this.cvm);
        if (this.cvk != null) {
            try {
                this.cvk.removeUpdates(this.cvo);
                this.cvk.removeUpdates(this.cvp);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.cvj != null) {
            this.cvj.cancel();
            this.cvj = null;
        }
    }
}
