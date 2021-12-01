package com.baidu.wallet.paysdk.precashier;
/* loaded from: classes12.dex */
public interface IModifyPayTypeCallback {
    void onPayTypeModified(PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData);

    void onPayTypeModifiedFailed(int i2, String str);

    @Deprecated
    void onPayTypeSetted();
}
