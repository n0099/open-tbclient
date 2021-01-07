package com.bun.miitmdid.supplier.f;

import android.content.Context;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
import com.bun.miitmdid.utils.sysParamters;
/* loaded from: classes5.dex */
public class b implements InnerIdSupplier {

    /* renamed from: a  reason: collision with root package name */
    private Context f6048a;

    public b(Context context) {
        this.f6048a = context;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(final SupplierListener supplierListener) {
        new Thread(new Runnable() { // from class: com.bun.miitmdid.supplier.f.b.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (supplierListener != null) {
                        supplierListener.OnSupport(b.this.isSupported(), b.this);
                    }
                } catch (Exception e) {
                    com.bun.miitmdid.utils.a.a("buniasuplier", "exception", e);
                }
            }
        }).start();
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public boolean b() {
        return false;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getAAID() {
        try {
            return a.a(this.f6048a, sysParamters.g());
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        try {
            return a.b(this.f6048a);
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        return "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        try {
            return a.b(this.f6048a, sysParamters.g());
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        try {
            return a.a(this.f6048a);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
