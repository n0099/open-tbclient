package com.bun.miitmdid.supplier;

import android.support.annotation.Keep;
import com.bun.miitmdid.utils.SupplierListener;
/* loaded from: classes18.dex */
public interface InnerIdSupplier extends IdSupplier {
    void a(SupplierListener supplierListener);

    boolean b();

    @Keep
    String getUDID();

    @Keep
    void shutDown();
}
