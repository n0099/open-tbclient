package com.bun.miitmdid.supplier;

import android.support.annotation.Keep;
@Keep
/* loaded from: classes11.dex */
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
