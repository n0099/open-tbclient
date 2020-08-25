package com.bun.miitmdid.supplier.i;

import android.content.Context;
import android.text.TextUtils;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
import com.bun.miitmdid.utils.sysParamters;
/* loaded from: classes11.dex */
public class b implements InnerIdSupplier {
    private Context a;

    public b(Context context) {
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
        String c = a.c(this.a);
        return TextUtils.isEmpty(c) ? sysParamters.f() : c;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        String a = a.a(this.a);
        return a == null ? "" : a;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        return "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        String b = a.b(this.a);
        return b == null ? "" : b;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        return a.a();
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
