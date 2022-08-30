package com.bun.miitmdid.interfaces;
/* loaded from: classes7.dex */
public interface IIdProvider extends IdSupplier {
    void doStart();

    void doStartInThreadPool(IIdentifierListener iIdentifierListener);

    void doStartSync(IIdentifierListener iIdentifierListener);

    boolean isSync();

    void shutDown();
}
