package com.baidu.wallet.paysdk.sms.controller;
/* loaded from: classes12.dex */
public interface SmsVerifyHandler extends SmsUpdateUiInterface {
    void onSmsSendFailure(int i2, CharSequence charSequence);

    void onSmsSendSuccess();

    void onSmsVerifyFailure(int i2, CharSequence charSequence);

    void onSmsVerifySuccess();
}
