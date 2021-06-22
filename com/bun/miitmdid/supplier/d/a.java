package com.bun.miitmdid.supplier.d;

import android.content.Context;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
import d.j.b.a.b;
/* loaded from: classes6.dex */
public class a implements InnerIdSupplier {

    /* renamed from: a  reason: collision with root package name */
    public Context f26969a;

    public a(Context context) {
        this.f26969a = context;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public boolean b() {
        return true;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getAAID() {
        try {
            return b.e(this.f26969a);
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        try {
            return b.c(this.f26969a);
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        try {
            return b.a(this.f26969a);
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        try {
            return b.d(this.f26969a);
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        try {
            return b.b();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
