package com.bun.miitmdid.supplier.h;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.supplier.h.a.d;
import com.bun.miitmdid.utils.SupplierListener;
import com.bun.miitmdid.utils.sysParamters;
/* loaded from: classes5.dex */
public class a implements InnerIdSupplier {

    /* renamed from: a  reason: collision with root package name */
    private String f5752a = "";

    /* renamed from: b  reason: collision with root package name */
    private Context f5753b;

    public a(Context context) {
        this.f5753b = context;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(final SupplierListener supplierListener) {
        new Thread(new Runnable() { // from class: com.bun.miitmdid.supplier.h.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (supplierListener != null) {
                        if (Build.VERSION.SDK_INT < 28) {
                            supplierListener.OnSupport(false, new com.bun.miitmdid.supplier.a());
                        } else {
                            supplierListener.OnSupport(a.this.isSupported(), a.this);
                        }
                    }
                } catch (Exception e) {
                    com.bun.miitmdid.utils.a.a("vivosuplier", "exception", e);
                }
            }
        }).start();
    }

    public void a(String str) {
        this.f5752a = str;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public boolean b() {
        return false;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getAAID() {
        String b2 = d.b(this.f5753b, this.f5752a);
        return TextUtils.isEmpty(b2) ? sysParamters.f() : b2;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        String b2 = d.b(this.f5753b);
        return b2 == null ? "" : b2;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        return "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        String a2 = d.a(this.f5753b, this.f5752a);
        return a2 == null ? "" : a2;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        return d.a(this.f5753b);
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
