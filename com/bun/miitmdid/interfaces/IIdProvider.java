package com.bun.miitmdid.interfaces;
/* loaded from: classes12.dex */
public interface IIdProvider extends IdSupplier {
    void doStart();

    void doStartInThreadPool(IIdentifierListener iIdentifierListener);

    void doStartSync(IIdentifierListener iIdentifierListener);

    boolean isSync();

    void shutDown();
}
