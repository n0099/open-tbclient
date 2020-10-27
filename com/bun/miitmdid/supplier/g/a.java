package com.bun.miitmdid.supplier.g;

import android.content.Context;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.utils.SupplierListener;
/* loaded from: classes11.dex */
public class a implements InnerIdSupplier {

    /* renamed from: a  reason: collision with root package name */
    private Context f3986a;

    public a(Context context) {
        com.heytap.openid.a.a.a(context);
        this.f3986a = context;
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

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x0017
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.bun.miitmdid.supplier.IdSupplier
    public java.lang.String getAAID() {
        /*
            r3 = this;
            java.lang.String r1 = ""
            android.content.Context r0 = r3.f3986a     // Catch: java.lang.Exception -> Lf
            java.lang.String r0 = com.heytap.openid.a.a.d(r0)     // Catch: java.lang.Exception -> Lf
            if (r0 != 0) goto Le
            java.lang.String r0 = ""
        Le:
            return r0
        Lf:
            r0 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
        L13:
            r1.printStackTrace()
            goto Le
        L17:
            r1 = move-exception
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bun.miitmdid.supplier.g.a.getAAID():java.lang.String");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x0017
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.bun.miitmdid.supplier.IdSupplier
    public java.lang.String getOAID() {
        /*
            r3 = this;
            java.lang.String r1 = ""
            android.content.Context r0 = r3.f3986a     // Catch: java.lang.Exception -> Lf
            java.lang.String r0 = com.heytap.openid.a.a.b(r0)     // Catch: java.lang.Exception -> Lf
            if (r0 != 0) goto Le
            java.lang.String r0 = ""
        Le:
            return r0
        Lf:
            r0 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
        L13:
            r1.printStackTrace()
            goto Le
        L17:
            r1 = move-exception
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bun.miitmdid.supplier.g.a.getOAID():java.lang.String");
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public String getUDID() {
        return "";
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x0017
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.bun.miitmdid.supplier.IdSupplier
    public java.lang.String getVAID() {
        /*
            r3 = this;
            java.lang.String r1 = ""
            android.content.Context r0 = r3.f3986a     // Catch: java.lang.Exception -> Lf
            java.lang.String r0 = com.heytap.openid.a.a.c(r0)     // Catch: java.lang.Exception -> Lf
            if (r0 != 0) goto Le
            java.lang.String r0 = ""
        Le:
            return r0
        Lf:
            r0 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
        L13:
            r1.printStackTrace()
            goto Le
        L17:
            r1 = move-exception
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bun.miitmdid.supplier.g.a.getVAID():java.lang.String");
    }

    @Override // com.bun.miitmdid.supplier.IdSupplier
    public boolean isSupported() {
        return com.heytap.openid.a.a.a();
    }

    @Override // com.bun.miitmdid.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
