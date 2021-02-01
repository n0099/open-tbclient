package com.bun.miitmdid.supplier.i;

import android.content.Context;
import android.text.TextUtils;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
import com.bun.miitmdid.utils.sysParamters;
/* loaded from: classes15.dex */
public class b implements InnerIdSupplier {

    /* renamed from: a  reason: collision with root package name */
    private Context f5764a;

    public b(Context context) {
        this.f5764a = context;
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
        String c = a.c(this.f5764a);
        return TextUtils.isEmpty(c) ? sysParamters.f() : c;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        String a2 = a.a(this.f5764a);
        return a2 == null ? "" : a2;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        return "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        String b2 = a.b(this.f5764a);
        return b2 == null ? "" : b2;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        return a.a();
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
