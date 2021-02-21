package com.bun.miitmdid.supplier.e;

import android.content.Context;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
/* loaded from: classes15.dex */
public class b implements InnerIdSupplier, com.bun.miitmdid.supplier.c.a {
    private a pmu;
    private SupplierListener pmv;

    public b(Context context, SupplierListener supplierListener) {
        this.pmv = supplierListener;
        this.pmu = new a(context, this);
    }

    @Override // com.bun.miitmdid.supplier.c.a
    public void a() {
        if (this.pmv != null) {
            this.pmv.OnSupport(isSupported(), this);
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
    }

    @Override // com.bun.miitmdid.supplier.c.a
    public void a(boolean z) {
        if (this.pmv != null) {
            this.pmv.OnSupport(isSupported(), this);
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public boolean b() {
        return false;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getAAID() {
        String e;
        return (isSupported() && (e = this.pmu.e()) != null) ? e : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        String a2;
        return (isSupported() && (a2 = this.pmu.a()) != null) ? a2 : "";
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        String b2;
        return (isSupported() && (b2 = this.pmu.b()) != null) ? b2 : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        String d;
        return (isSupported() && (d = this.pmu.d()) != null) ? d : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        if (this.pmu != null) {
            return this.pmu.c();
        }
        return false;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
        if (this.pmu != null) {
            this.pmu.f();
        }
    }
}
