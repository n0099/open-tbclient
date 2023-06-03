package com.bun.supplier;

import androidx.annotation.Keep;
@Keep
@Deprecated
/* loaded from: classes9.dex */
public interface IdSupplier {
    @Keep
    String getAAID();

    @Keep
    String getOAID();

    @Keep
    String getVAID();

    @Keep
    boolean isSupported();
}
