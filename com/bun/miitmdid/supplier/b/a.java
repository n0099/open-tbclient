package com.bun.miitmdid.supplier.b;

import android.content.Context;
import android.text.TextUtils;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
import com.bun.miitmdid.utils.sysParamters;
import com.huawei.android.hms.pps.AdvertisingIdClient;
/* loaded from: classes5.dex */
public class a implements InnerIdSupplier {

    /* renamed from: a  reason: collision with root package name */
    public Context f26773a;

    /* renamed from: g  reason: collision with root package name */
    public SupplierListener f26779g;

    /* renamed from: f  reason: collision with root package name */
    public boolean f26778f = false;

    /* renamed from: b  reason: collision with root package name */
    public String f26774b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f26775c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f26776d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f26777e = "";

    public a(Context context) {
        this.f26773a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            boolean z = !TextUtils.isEmpty(this.f26775c);
            this.f26778f = z;
            if (z) {
                if (this.f26779g != null) {
                    this.f26779g.OnSupport(z, this);
                }
            } else if (this.f26779g != null) {
                this.f26779g.OnSupport(z, new com.bun.miitmdid.supplier.a());
            }
        } catch (Exception e2) {
            com.bun.miitmdid.utils.a.a(a.class.getSimpleName(), "CallBack", e2);
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
        this.f26779g = supplierListener;
        new Thread(new Runnable() { // from class: com.bun.miitmdid.supplier.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(a.this.f26773a);
                    a.this.f26775c = advertisingIdInfo.getId();
                    advertisingIdInfo.isLimitAdTrackingEnabled();
                } catch (Exception e2) {
                    com.bun.miitmdid.utils.a.a(a.class.getSimpleName(), "thread", e2);
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
        return TextUtils.isEmpty(this.f26777e) ? sysParamters.f() : this.f26777e;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        return this.f26775c;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        return "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        return this.f26776d;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        return this.f26778f;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
