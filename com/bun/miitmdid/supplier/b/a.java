package com.bun.miitmdid.supplier.b;

import android.content.Context;
import android.text.TextUtils;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
import com.bun.miitmdid.utils.sysParamters;
import com.huawei.android.hms.pps.AdvertisingIdClient;
/* loaded from: classes11.dex */
public class a implements InnerIdSupplier {
    private Context a;
    private SupplierListener nhE;
    private boolean f = false;
    private String b = "";
    private String c = "";
    private String d = "";
    private String e = "";

    public a(Context context) {
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            this.f = !TextUtils.isEmpty(this.c);
            if (this.f) {
                if (this.nhE != null) {
                    this.nhE.OnSupport(this.f, this);
                }
            } else if (this.nhE != null) {
                this.nhE.OnSupport(this.f, new com.bun.miitmdid.supplier.a());
            }
        } catch (Exception e) {
            com.bun.miitmdid.utils.a.a(getClass().getSimpleName(), "CallBack", e);
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
        this.nhE = supplierListener;
        new Thread(new Runnable() { // from class: com.bun.miitmdid.supplier.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(a.this.a);
                    a.this.c = advertisingIdInfo.getId();
                    advertisingIdInfo.isLimitAdTrackingEnabled();
                } catch (Exception e) {
                    com.bun.miitmdid.utils.a.a(a.class.getSimpleName(), "thread", e);
                }
                a.this.a();
            }
        }).start();
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public boolean b() {
        return false;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getAAID() {
        return TextUtils.isEmpty(this.e) ? sysParamters.f() : this.e;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        return this.c;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        return "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        return this.d;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        return this.f;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
