package com.bun.miitmdid.supplier.e;

import android.content.Context;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
/* loaded from: classes6.dex */
public class b implements InnerIdSupplier, com.bun.miitmdid.supplier.c.a {
    private a pgh;
    private SupplierListener pgi;

    public b(Context context, SupplierListener supplierListener) {
        this.pgi = supplierListener;
        this.pgh = new a(context, this);
    }

    @Override // com.bun.miitmdid.supplier.c.a
    public void a() {
        if (this.pgi != null) {
            this.pgi.OnSupport(isSupported(), this);
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
    }

    @Override // com.bun.miitmdid.supplier.c.a
    public void a(boolean z) {
        if (this.pgi != null) {
            this.pgi.OnSupport(isSupported(), this);
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public boolean b() {
        return false;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getAAID() {
        String e;
        return (isSupported() && (e = this.pgh.e()) != null) ? e : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        String a2;
        return (isSupported() && (a2 = this.pgh.a()) != null) ? a2 : "";
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        String b2;
        return (isSupported() && (b2 = this.pgh.b()) != null) ? b2 : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        String d;
        return (isSupported() && (d = this.pgh.d()) != null) ? d : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        if (this.pgh != null) {
            return this.pgh.c();
        }
        return false;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
        if (this.pgh != null) {
            this.pgh.f();
        }
    }
}
