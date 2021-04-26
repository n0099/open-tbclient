package com.baidu.wallet.api;

import com.baidu.apollon.NoProguard;
/* loaded from: classes5.dex */
public interface ILightappInvokerCallback extends NoProguard {
    public static final int RESULT_FAIL = 1;
    public static final int RESULT_OK = 0;

    void onResult(int i2, String str);
}
