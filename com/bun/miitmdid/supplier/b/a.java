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
    public Context f27087a;

    /* renamed from: g  reason: collision with root package name */
    public SupplierListener f27093g;

    /* renamed from: f  reason: collision with root package name */
    public boolean f27092f = false;

    /* renamed from: b  reason: collision with root package name */
    public String f27088b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f27089c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f27090d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f27091e = "";

    public a(Context context) {
        this.f27087a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            boolean z = !TextUtils.isEmpty(this.f27089c);
            this.f27092f = z;
            if (z) {
                if (this.f27093g != null) {
                    this.f27093g.OnSupport(z, this);
                }
            } else if (this.f27093g != null) {
                this.f27093g.OnSupport(z, new com.bun.miitmdid.supplier.a());
            }
        } catch (Exception e2) {
            com.bun.miitmdid.utils.a.a(a.class.getSimpleName(), "CallBack", e2);
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
        this.f27093g = supplierListener;
        new Thread(new Runnable() { // from class: com.bun.miitmdid.supplier.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(a.this.f27087a);
                    a.this.f27089c = advertisingIdInfo.getId();
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
        return TextUtils.isEmpty(this.f27091e) ? sysParamters.f() : this.f27091e;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        return this.f27089c;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        return "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        return this.f27090d;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        return this.f27092f;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
