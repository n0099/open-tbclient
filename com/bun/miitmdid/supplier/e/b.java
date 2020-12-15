package com.bun.miitmdid.supplier.e;

import android.content.Context;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
/* loaded from: classes18.dex */
public class b implements InnerIdSupplier, com.bun.miitmdid.supplier.c.a {
    private a oYU;
    private SupplierListener oYV;

    public b(Context context, SupplierListener supplierListener) {
        this.oYV = supplierListener;
        this.oYU = new a(context, this);
    }

    @Override // com.bun.miitmdid.supplier.c.a
    public void a() {
        if (this.oYV != null) {
            this.oYV.OnSupport(isSupported(), this);
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
    }

    @Override // com.bun.miitmdid.supplier.c.a
    public void a(boolean z) {
        if (this.oYV != null) {
            this.oYV.OnSupport(isSupported(), this);
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public boolean b() {
        return false;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getAAID() {
        String e;
        return (isSupported() && (e = this.oYU.e()) != null) ? e : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        String a2;
        return (isSupported() && (a2 = this.oYU.a()) != null) ? a2 : "";
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        String b;
        return (isSupported() && (b = this.oYU.b()) != null) ? b : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        String d;
        return (isSupported() && (d = this.oYU.d()) != null) ? d : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        if (this.oYU != null) {
            return this.oYU.c();
        }
        return false;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
        if (this.oYU != null) {
            this.oYU.f();
        }
    }
}
