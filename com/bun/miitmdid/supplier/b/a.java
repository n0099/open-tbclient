package com.bun.miitmdid.supplier.b;

import android.content.Context;
import android.text.TextUtils;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
import com.bun.miitmdid.utils.sysParamters;
import com.huawei.android.hms.pps.AdvertisingIdClient;
/* loaded from: classes6.dex */
public class a implements InnerIdSupplier {

    /* renamed from: a  reason: collision with root package name */
    public Context f26952a;

    /* renamed from: g  reason: collision with root package name */
    public SupplierListener f26958g;

    /* renamed from: f  reason: collision with root package name */
    public boolean f26957f = false;

    /* renamed from: b  reason: collision with root package name */
    public String f26953b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f26954c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f26955d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f26956e = "";

    public a(Context context) {
        this.f26952a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            boolean z = !TextUtils.isEmpty(this.f26954c);
            this.f26957f = z;
            if (z) {
                if (this.f26958g != null) {
                    this.f26958g.OnSupport(z, this);
                }
            } else if (this.f26958g != null) {
                this.f26958g.OnSupport(z, new com.bun.miitmdid.supplier.a());
            }
        } catch (Exception e2) {
            com.bun.miitmdid.utils.a.a(a.class.getSimpleName(), "CallBack", e2);
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
        this.f26958g = supplierListener;
        new Thread(new Runnable() { // from class: com.bun.miitmdid.supplier.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(a.this.f26952a);
                    a.this.f26954c = advertisingIdInfo.getId();
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
        return TextUtils.isEmpty(this.f26956e) ? sysParamters.f() : this.f26956e;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        return this.f26954c;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        return "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        return this.f26955d;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        return this.f26957f;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
