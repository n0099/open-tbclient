package com.bun.miitmdid.supplier.d;

import android.content.Context;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
import com.meizu.flyme.openidsdk.b;
/* loaded from: classes19.dex */
public class a implements InnerIdSupplier {
    private Context a;

    public a(Context context) {
        this.a = context;
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
            return b.d(this.a);
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        try {
            return b.b(this.a);
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        try {
            return b.a(this.a);
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        try {
            return b.c(this.a);
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
