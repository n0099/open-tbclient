package com.bun.miitmdid.supplier.a;

import android.content.Context;
import android.os.IBinder;
import com.asus.msa.sdid.SupplementaryDIDManager;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
/* loaded from: classes6.dex */
public class a implements com.asus.msa.sdid.a, InnerIdSupplier {

    /* renamed from: a  reason: collision with root package name */
    public SupplierListener f26862a;

    /* renamed from: f  reason: collision with root package name */
    public SupplementaryDIDManager f26867f;

    /* renamed from: b  reason: collision with root package name */
    public String f26863b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f26864c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f26865d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f26866e = "";

    /* renamed from: g  reason: collision with root package name */
    public boolean f26868g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f26869h = false;

    public a(Context context, SupplierListener supplierListener) {
        this.f26862a = supplierListener;
        this.f26867f = new SupplementaryDIDManager(context);
    }

    @Override // com.asus.msa.sdid.a
    public void a() {
        SupplierListener supplierListener = this.f26862a;
        if (supplierListener != null) {
            supplierListener.OnSupport(false, this);
        }
    }

    @Override // com.asus.msa.sdid.a
    public void a(com.asus.msa.a.a aVar) {
        try {
            String b2 = aVar.b();
            this.f26863b = b2;
            if (b2 == null) {
                this.f26863b = "";
            }
        } catch (Exception unused) {
        }
        try {
            String c2 = aVar.c();
            this.f26864c = c2;
            if (c2 == null) {
                this.f26864c = "";
            }
        } catch (Exception unused2) {
        }
        try {
            String d2 = aVar.d();
            this.f26865d = d2;
            if (d2 == null) {
                this.f26865d = "";
            }
        } catch (Exception unused3) {
        }
        try {
            String e2 = aVar.e();
            this.f26866e = e2;
            if (e2 == null) {
                this.f26866e = "";
            }
        } catch (Exception unused4) {
        }
        try {
            this.f26869h = aVar.a();
        } catch (Exception unused5) {
        }
        this.f26868g = true;
        SupplierListener supplierListener = this.f26862a;
        if (supplierListener != null) {
            supplierListener.OnSupport(this.f26869h, this);
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
        this.f26867f.init(this);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public boolean b() {
        return false;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getAAID() {
        return this.f26866e;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        return this.f26864c;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        return this.f26863b;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        return this.f26865d;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        return this.f26869h;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
        SupplementaryDIDManager supplementaryDIDManager;
        if (!this.f26868g || (supplementaryDIDManager = this.f26867f) == null) {
            return;
        }
        supplementaryDIDManager.deInit();
    }
}
