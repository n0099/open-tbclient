package com.bun.miitmdid.supplier.d;

import android.content.Context;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
import com.meizu.flyme.openidsdk.b;
/* loaded from: classes18.dex */
public class a implements InnerIdSupplier {

    /* renamed from: a  reason: collision with root package name */
    private Context f3986a;

    public a(Context context) {
        this.f3986a = context;
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
            return b.d(this.f3986a);
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        try {
            return b.b(this.f3986a);
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        try {
            return b.a(this.f3986a);
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        try {
            return b.c(this.f3986a);
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        try {
            return b.a();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
