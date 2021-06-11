package com.bun.miitmdid.supplier.h;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bun.miitmdid.supplier.IdSupplier;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.supplier.h.a.d;
import com.bun.miitmdid.utils.SupplierListener;
import com.bun.miitmdid.utils.sysParamters;
/* loaded from: classes6.dex */
public class a implements InnerIdSupplier {

    /* renamed from: a  reason: collision with root package name */
    public String f26904a = "";

    /* renamed from: b  reason: collision with root package name */
    public Context f26905b;

    public a(Context context) {
        this.f26905b = context;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(final SupplierListener supplierListener) {
        new Thread(new Runnable() { // from class: com.bun.miitmdid.supplier.h.a.1
            @Override // java.lang.Runnable
            public void run() {
                SupplierListener supplierListener2;
                boolean isSupported;
                IdSupplier idSupplier;
                try {
                    if (supplierListener != null) {
                        if (Build.VERSION.SDK_INT < 28) {
                            supplierListener2 = supplierListener;
                            isSupported = false;
                            idSupplier = new com.bun.miitmdid.supplier.a();
                        } else {
                            supplierListener2 = supplierListener;
                            isSupported = a.this.isSupported();
                            idSupplier = a.this;
                        }
                        supplierListener2.OnSupport(isSupported, idSupplier);
                    }
                } catch (Exception e2) {
                    com.bun.miitmdid.utils.a.a("vivosuplier", "exception", e2);
                }
            }
        }).start();
    }

    public void a(String str) {
        this.f26904a = str;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public boolean b() {
        return false;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getAAID() {
        String b2 = d.b(this.f26905b, this.f26904a);
        return TextUtils.isEmpty(b2) ? sysParamters.f() : b2;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        String b2 = d.b(this.f26905b);
        return b2 == null ? "" : b2;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        return "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        String a2 = d.a(this.f26905b, this.f26904a);
        return a2 == null ? "" : a2;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        return d.a(this.f26905b);
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
