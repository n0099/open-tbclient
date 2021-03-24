package com.bun.miitmdid.supplier;

import androidx.annotation.Keep;
import com.bun.miitmdid.utils.SupplierListener;
/* loaded from: classes5.dex */
public interface InnerIdSupplier extends IdSupplier {
    void a(SupplierListener supplierListener);

    boolean b();

    @Keep
    String getUDID();

    @Keep
    void shutDown();
}
