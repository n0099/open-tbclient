package com.baidu.tieba.wallet;
/* loaded from: classes5.dex */
public interface ITiebaPayCallback {
    public static final int STATE_CODE_CANCEL = 2;
    public static final int STATE_CODE_FAILD = 3;
    public static final int STATE_CODE_PAYING = 1;
    public static final int STATE_CODE_SUCCEED = 0;

    void onPayResult(int i2, String str);
}
