package com.bun.miitmdid.supplier.sumsung;

import android.content.Context;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
/* loaded from: classes5.dex */
public class a implements InnerIdSupplier, com.bun.miitmdid.supplier.c.a {

    /* renamed from: a  reason: collision with root package name */
    public SupplierListener f26825a;

    /* renamed from: b  reason: collision with root package name */
    public SumsungCore f26826b;

    public a(Context context, SupplierListener supplierListener) {
        this.f26825a = supplierListener;
        this.f26826b = new SumsungCore(context, this);
    }

    @Override // com.bun.miitmdid.supplier.c.a
    public void a() {
        SupplierListener supplierListener = this.f26825a;
        if (supplierListener != null) {
            supplierListener.OnSupport(isSupported(), this);
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
    }

    @Override // com.bun.miitmdid.supplier.c.a
    public void a(boolean z) {
        SupplierListener supplierListener = this.f26825a;
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
        String aaid;
        return (isSupported() && (aaid = this.f26826b.getAAID()) != null) ? aaid : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        String oaid;
        return (isSupported() && (oaid = this.f26826b.getOAID()) != null) ? oaid : "";
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        String udid;
        return (isSupported() && (udid = this.f26826b.getUDID()) != null) ? udid : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        String vaid;
        return (isSupported() && (vaid = this.f26826b.getVAID()) != null) ? vaid : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        SumsungCore sumsungCore = this.f26826b;
        if (sumsungCore != null) {
            return sumsungCore.isSupported();
        }
        return false;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
        SumsungCore sumsungCore = this.f26826b;
        if (sumsungCore != null) {
            sumsungCore.shutdown();
        }
    }
}
