package com.bun.miitmdid.supplier.a;

import android.content.Context;
import android.os.IBinder;
import com.asus.msa.sdid.SupplementaryDIDManager;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
/* loaded from: classes6.dex */
public class a implements com.asus.msa.sdid.a, InnerIdSupplier {
    private SupplierListener a;
    private SupplementaryDIDManager f;
    private String b = "";
    private String c = "";
    private String d = "";
    private String e = "";
    private boolean g = false;
    private boolean h = false;

    public a(Context context, SupplierListener supplierListener) {
        this.a = supplierListener;
        this.f = new SupplementaryDIDManager(context);
    }

    @Override // com.asus.msa.sdid.a
    public void a() {
        if (this.a != null) {
            this.a.OnSupport(false, this);
        }
    }

    @Override // com.asus.msa.sdid.a
    public void a(com.asus.msa.a.a aVar) {
        try {
            this.b = aVar.b();
            if (this.b == null) {
                this.b = "";
            }
        } catch (Exception e) {
        }
        try {
            this.c = aVar.c();
            if (this.c == null) {
                this.c = "";
            }
        } catch (Exception e2) {
        }
        try {
            this.d = aVar.d();
            if (this.d == null) {
                this.d = "";
            }
        } catch (Exception e3) {
        }
        try {
            this.e = aVar.e();
            if (this.e == null) {
                this.e = "";
            }
        } catch (Exception e4) {
        }
        try {
            this.h = aVar.a();
        } catch (Exception e5) {
        }
        this.g = true;
        if (this.a != null) {
            this.a.OnSupport(this.h, this);
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
        this.f.init(this);
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
        return this.e;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        return this.c;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        return this.b;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        return this.d;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        return this.h;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
        if (!this.g || this.f == null) {
            return;
        }
        this.f.deInit();
    }
}
