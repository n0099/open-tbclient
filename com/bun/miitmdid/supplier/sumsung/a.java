package com.bun.miitmdid.supplier.sumsung;

import android.content.Context;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
/* loaded from: classes19.dex */
public class a implements InnerIdSupplier, com.bun.miitmdid.supplier.c.a {
    public SupplierListener a;
    private SumsungCore mPa;

    public a(Context context, SupplierListener supplierListener) {
        this.a = supplierListener;
        this.mPa = new SumsungCore(context, this);
    }

    @Override // com.bun.miitmdid.supplier.c.a
    public void a() {
        if (this.a != null) {
            this.a.OnSupport(isSupported(), this);
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
    }

    @Override // com.bun.miitmdid.supplier.c.a
    public void a(boolean z) {
        if (this.a != null) {
            this.a.OnSupport(isSupported(), this);
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public boolean b() {
        return false;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getAAID() {
        String aaid;
        return (isSupported() && (aaid = this.mPa.getAAID()) != null) ? aaid : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        String oaid;
        return (isSupported() && (oaid = this.mPa.getOAID()) != null) ? oaid : "";
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        String udid;
        return (isSupported() && (udid = this.mPa.getUDID()) != null) ? udid : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        String vaid;
        return (isSupported() && (vaid = this.mPa.getVAID()) != null) ? vaid : "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        if (this.mPa != null) {
            return this.mPa.isSupported();
        }
        return false;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
        if (this.mPa != null) {
            this.mPa.shutdown();
        }
    }
}
