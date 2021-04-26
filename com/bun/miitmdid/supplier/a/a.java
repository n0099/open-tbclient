package com.bun.miitmdid.supplier.a;

import android.content.Context;
import android.os.IBinder;
import com.asus.msa.sdid.SupplementaryDIDManager;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
/* loaded from: classes5.dex */
public class a implements com.asus.msa.sdid.a, InnerIdSupplier {

    /* renamed from: a  reason: collision with root package name */
    public SupplierListener f27585a;

    /* renamed from: f  reason: collision with root package name */
    public SupplementaryDIDManager f27590f;

    /* renamed from: b  reason: collision with root package name */
    public String f27586b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f27587c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f27588d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f27589e = "";

    /* renamed from: g  reason: collision with root package name */
    public boolean f27591g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27592h = false;

    public a(Context context, SupplierListener supplierListener) {
        this.f27585a = supplierListener;
        this.f27590f = new SupplementaryDIDManager(context);
    }

    @Override // com.asus.msa.sdid.a
    public void a() {
        SupplierListener supplierListener = this.f27585a;
        if (supplierListener != null) {
            supplierListener.OnSupport(false, this);
        }
    }

    @Override // com.asus.msa.sdid.a
    public void a(com.asus.msa.a.a aVar) {
        try {
            String b2 = aVar.b();
            this.f27586b = b2;
            if (b2 == null) {
                this.f27586b = "";
            }
        } catch (Exception unused) {
        }
        try {
            String c2 = aVar.c();
            this.f27587c = c2;
            if (c2 == null) {
                this.f27587c = "";
            }
        } catch (Exception unused2) {
        }
        try {
            String d2 = aVar.d();
            this.f27588d = d2;
            if (d2 == null) {
                this.f27588d = "";
            }
        } catch (Exception unused3) {
        }
        try {
            String e2 = aVar.e();
            this.f27589e = e2;
            if (e2 == null) {
                this.f27589e = "";
            }
        } catch (Exception unused4) {
        }
        try {
            this.f27592h = aVar.a();
        } catch (Exception unused5) {
        }
        this.f27591g = true;
        SupplierListener supplierListener = this.f27585a;
        if (supplierListener != null) {
            supplierListener.OnSupport(this.f27592h, this);
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
        this.f27590f.init(this);
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
        return this.f27589e;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        return this.f27587c;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        return this.f27586b;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        return this.f27588d;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        return this.f27592h;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
        SupplementaryDIDManager supplementaryDIDManager;
        if (!this.f27591g || (supplementaryDIDManager = this.f27590f) == null) {
            return;
        }
        supplementaryDIDManager.deInit();
    }
}
