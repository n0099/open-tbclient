package com.baidu.wallet.paysdk.sms.controller;
/* loaded from: classes6.dex */
public interface SmsUpdateUiInterface {
    void clearSmsEditText();

    void doStartCountDown();

    void doStopCountDown();

    void initSMSActivityView(String str, String str2, String str3, String str4, boolean z);

    void upDateSafeKeyBoradView(String str, String str2);

    void updateButtonTip(String str);

    void updateModifyPhoneUI(boolean z, CharSequence charSequence);
}
