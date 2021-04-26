package com.bun.miitmdid.supplier.g;

import android.content.Context;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
/* loaded from: classes5.dex */
public class a implements InnerIdSupplier {

    /* renamed from: a  reason: collision with root package name */
    public Context f27624a;

    public a(Context context) {
        com.heytap.openid.sdk.a.a(context);
        this.f27624a = context;
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void a(final SupplierListener supplierListener) {
        new Thread(new Runnable() { // from class: com.bun.miitmdid.supplier.g.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(1000L);
                    if (supplierListener != null) {
                        supplierListener.OnSupport(a.this.isSupported(), a.this);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }).start();
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public boolean b() {
        return false;
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getAAID() {
        try {
            String d2 = com.heytap.openid.sdk.a.d(this.f27624a);
            return d2 == null ? "" : d2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        try {
            String b2 = com.heytap.openid.sdk.a.b(this.f27624a);
            return b2 == null ? "" : b2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        return "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        try {
            String c2 = com.heytap.openid.sdk.a.c(this.f27624a);
            return c2 == null ? "" : c2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        return com.heytap.openid.sdk.a.a();
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
