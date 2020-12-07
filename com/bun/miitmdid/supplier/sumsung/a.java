package com.bun.miitmdid.supplier.sumsung;

import android.content.Context;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
/* loaded from: classes18.dex */
public class a implements InnerIdSupplier, com.bun.miitmdid.supplier.c.a {

    /* renamed from: a  reason: collision with root package name */
    public SupplierListener f4000a;
    private SumsungCore oZd;

    public a(Context context, SupplierListener supplierListener) {
        this.f4000a = supplierListener;
        this.oZd = new SumsungCore(context, this);
    }

    @Override // com.bun.miitmdid.supplier.c.a
    public void a() {
        if (this.f4000a != null) {
            this.f4000a.OnSupport(isSupported(), this);
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
    }

    @Override // com.bun.miitmdid.supplier.c.a
    public void a(boolean z) {
        if (this.f4000a != null) {
            this.f4000a.OnSupport(isSupported(), this);
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public boolean b() {
        return false;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getAAID() {
        String aaid;
        return (isSupported() && (aaid = this.oZd.getAAID()) != null) ? aaid : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        String oaid;
        return (isSupported() && (oaid = this.oZd.getOAID()) != null) ? oaid : "";
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        String udid;
        return (isSupported() && (udid = this.oZd.getUDID()) != null) ? udid : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        String vaid;
        return (isSupported() && (vaid = this.oZd.getVAID()) != null) ? vaid : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        if (this.oZd != null) {
            return this.oZd.isSupported();
        }
        return false;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
        if (this.oZd != null) {
            this.oZd.shutdown();
        }
    }
}
