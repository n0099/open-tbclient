package com.bun.miitmdid.supplier.h;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.supplier.h.a.d;
import com.bun.miitmdid.utils.SupplierListener;
import com.bun.miitmdid.utils.sysParamters;
/* loaded from: classes6.dex */
public class a implements InnerIdSupplier {
    private String a = "";
    private Context b;

    public a(Context context) {
        this.b = context;
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
        this.a = str;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public boolean b() {
        return false;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getAAID() {
        String b = d.b(this.b, this.a);
        return TextUtils.isEmpty(b) ? sysParamters.f() : b;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        String b = d.b(this.b);
        return b == null ? "" : b;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        return "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        String a = d.a(this.b, this.a);
        return a == null ? "" : a;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        return d.a(this.b);
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
