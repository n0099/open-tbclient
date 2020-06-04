package com.bun.miitmdid.supplier.e;

import android.content.Context;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
/* loaded from: classes6.dex */
public class b implements InnerIdSupplier, com.bun.miitmdid.supplier.c.a {
    private a mkM;
    private SupplierListener mkN;

    public b(Context context, SupplierListener supplierListener) {
        this.mkN = supplierListener;
        this.mkM = new a(context, this);
    }

    @Override // com.bun.miitmdid.supplier.c.a
    public void a() {
        if (this.mkN != null) {
            this.mkN.OnSupport(isSupported(), this);
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
    }

    @Override // com.bun.miitmdid.supplier.c.a
    public void a(boolean z) {
        if (this.mkN != null) {
            this.mkN.OnSupport(isSupported(), this);
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public boolean b() {
        return false;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getAAID() {
        String e;
        return (isSupported() && (e = this.mkM.e()) != null) ? e : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        String a;
        return (isSupported() && (a = this.mkM.a()) != null) ? a : "";
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        String b;
        return (isSupported() && (b = this.mkM.b()) != null) ? b : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        String d;
        return (isSupported() && (d = this.mkM.d()) != null) ? d : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        if (this.mkM != null) {
            return this.mkM.c();
        }
        return false;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
        if (this.mkM != null) {
            this.mkM.f();
        }
    }
}
