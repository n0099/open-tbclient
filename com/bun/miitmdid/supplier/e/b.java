package com.bun.miitmdid.supplier.e;

import android.content.Context;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
/* loaded from: classes19.dex */
public class b implements InnerIdSupplier, com.bun.miitmdid.supplier.c.a {
    private a mOR;
    private SupplierListener mOS;

    public b(Context context, SupplierListener supplierListener) {
        this.mOS = supplierListener;
        this.mOR = new a(context, this);
    }

    @Override // com.bun.miitmdid.supplier.c.a
    public void a() {
        if (this.mOS != null) {
            this.mOS.OnSupport(isSupported(), this);
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
    }

    @Override // com.bun.miitmdid.supplier.c.a
    public void a(boolean z) {
        if (this.mOS != null) {
            this.mOS.OnSupport(isSupported(), this);
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public boolean b() {
        return false;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getAAID() {
        String e;
        return (isSupported() && (e = this.mOR.e()) != null) ? e : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        String a;
        return (isSupported() && (a = this.mOR.a()) != null) ? a : "";
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        String b;
        return (isSupported() && (b = this.mOR.b()) != null) ? b : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        String d;
        return (isSupported() && (d = this.mOR.d()) != null) ? d : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        if (this.mOR != null) {
            return this.mOR.c();
        }
        return false;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
        if (this.mOR != null) {
            this.mOR.f();
        }
    }
}
