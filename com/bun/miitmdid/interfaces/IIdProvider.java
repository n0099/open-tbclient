package com.bun.miitmdid.interfaces;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes7.dex */
public interface IIdProvider extends IdSupplier {
    @Keep
    void doStart();

    @Keep
    void doStartInThreadPool(IIdentifierListener iIdentifierListener);

    @Keep
    void doStartSync(IIdentifierListener iIdentifierListener);

    @Keep
    boolean isSync();

    @Keep
    void setGetIdFlag(boolean z, boolean z2, boolean z3);

    @Keep
    void shutDown();
}
