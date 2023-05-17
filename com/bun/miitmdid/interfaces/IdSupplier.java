package com.bun.miitmdid.interfaces;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes8.dex */
public interface IdSupplier {
    @Keep
    String getAAID();

    @Keep
    String getOAID();

    @Keep
    String getVAID();

    @Keep
    boolean isLimited();

    @Keep
    boolean isSupported();
}
