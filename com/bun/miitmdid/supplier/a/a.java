package com.bun.miitmdid.supplier.a;

import android.content.Context;
import android.os.IBinder;
import com.asus.msa.sdid.SupplementaryDIDManager;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
/* loaded from: classes5.dex */
public class a implements com.asus.msa.sdid.a, InnerIdSupplier {

    /* renamed from: a  reason: collision with root package name */
    public SupplierListener f27080a;

    /* renamed from: f  reason: collision with root package name */
    public SupplementaryDIDManager f27085f;

    /* renamed from: b  reason: collision with root package name */
    public String f27081b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f27082c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f27083d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f27084e = "";

    /* renamed from: g  reason: collision with root package name */
    public boolean f27086g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27087h = false;

    public a(Context context, SupplierListener supplierListener) {
        this.f27080a = supplierListener;
        this.f27085f = new SupplementaryDIDManager(context);
    }

    @Override // com.asus.msa.sdid.a
    public void a() {
        SupplierListener supplierListener = this.f27080a;
        if (supplierListener != null) {
            supplierListener.OnSupport(false, this);
        }
    }

    @Override // com.asus.msa.sdid.a
    public void a(com.asus.msa.a.a aVar) {
        try {
            String b2 = aVar.b();
            this.f27081b = b2;
            if (b2 == null) {
                this.f27081b = "";
            }
        } catch (Exception unused) {
        }
        try {
            String c2 = aVar.c();
            this.f27082c = c2;
            if (c2 == null) {
                this.f27082c = "";
            }
        } catch (Exception unused2) {
        }
        try {
            String d2 = aVar.d();
            this.f27083d = d2;
            if (d2 == null) {
                this.f27083d = "";
            }
        } catch (Exception unused3) {
        }
        try {
            String e2 = aVar.e();
            this.f27084e = e2;
            if (e2 == null) {
                this.f27084e = "";
            }
        } catch (Exception unused4) {
        }
        try {
            this.f27087h = aVar.a();
        } catch (Exception unused5) {
        }
        this.f27086g = true;
        SupplierListener supplierListener = this.f27080a;
        if (supplierListener != null) {
            supplierListener.OnSupport(this.f27087h, this);
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
        this.f27085f.init(this);
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
        return this.f27084e;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        return this.f27082c;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        return this.f27081b;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        return this.f27083d;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        return this.f27087h;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
        SupplementaryDIDManager supplementaryDIDManager;
        if (!this.f27086g || (supplementaryDIDManager = this.f27085f) == null) {
            return;
        }
        supplementaryDIDManager.deInit();
    }
}
