package com.bun.miitmdid.supplier.e;

import android.content.Context;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
/* loaded from: classes5.dex */
public class b implements InnerIdSupplier, com.bun.miitmdid.supplier.c.a {

    /* renamed from: a  reason: collision with root package name */
    public a f26797a;

    /* renamed from: b  reason: collision with root package name */
    public SupplierListener f26798b;

    public b(Context context, SupplierListener supplierListener) {
        this.f26798b = supplierListener;
        this.f26797a = new a(context, this);
    }

    @Override // com.bun.miitmdid.supplier.c.a
    public void a() {
        SupplierListener supplierListener = this.f26798b;
        if (supplierListener != null) {
            supplierListener.OnSupport(isSupported(), this);
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
    }

    @Override // com.bun.miitmdid.supplier.c.a
    public void a(boolean z) {
        SupplierListener supplierListener = this.f26798b;
        if (supplierListener != null) {
            supplierListener.OnSupport(isSupported(), this);
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public boolean b() {
        return false;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getAAID() {
        String e2;
        return (isSupported() && (e2 = this.f26797a.e()) != null) ? e2 : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        String a2;
        return (isSupported() && (a2 = this.f26797a.a()) != null) ? a2 : "";
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        String b2;
        return (isSupported() && (b2 = this.f26797a.b()) != null) ? b2 : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        String d2;
        return (isSupported() && (d2 = this.f26797a.d()) != null) ? d2 : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        a aVar = this.f26797a;
        if (aVar != null) {
            return aVar.c();
        }
        return false;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
        a aVar = this.f26797a;
        if (aVar != null) {
            aVar.f();
        }
    }
}
