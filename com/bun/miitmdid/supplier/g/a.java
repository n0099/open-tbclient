package com.bun.miitmdid.supplier.g;

import android.content.Context;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
/* loaded from: classes5.dex */
public class a implements InnerIdSupplier {

    /* renamed from: a  reason: collision with root package name */
    private Context f6050a;

    public a(Context context) {
        com.heytap.openid.a.a.a(context);
        this.f6050a = context;
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
                } catch (Exception e) {
                    e.printStackTrace();
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
        String str = "";
        try {
            str = com.heytap.openid.a.a.d(this.f6050a);
            return str == null ? "" : str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getOAID() {
        String str = "";
        try {
            str = com.heytap.openid.a.a.b(this.f6050a);
            return str == null ? "" : str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        return "";
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public String getVAID() {
        String str = "";
        try {
            str = com.heytap.openid.a.a.c(this.f6050a);
            return str == null ? "" : str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        return com.heytap.openid.a.a.a();
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
