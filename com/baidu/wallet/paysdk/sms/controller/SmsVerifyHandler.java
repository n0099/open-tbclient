package com.baidu.wallet.paysdk.sms.controller;
/* loaded from: classes5.dex */
public interface SmsVerifyHandler extends SmsUpdateUiInterface {
    void onSmsSendFailure(int i, CharSequence charSequence);

    void onSmsSendSuccess();

    void onSmsVerifyFailure(int i, CharSequence charSequence);

    void onSmsVerifySuccess();
}
