package com.baidu.wallet.paysdk.sms.controller;

import android.app.Dialog;
import android.os.Bundle;
import com.baidu.wallet.paysdk.ui.PayBaseActivity;
/* loaded from: classes12.dex */
public interface ISmsController {
    public static final String BEAN_TAG = "WalletSmsActivity";
    public static final int DIALOG_CANNOT_DISCOUNT = 65315;
    public static final int DIALOG_CARDBALANCE_NOT_ENOUGH = 65317;
    public static final int DIALOG_CARD_INFO_UPDATE_TIP = 65316;
    public static final int DIALOG_MODIFY_PHONE = 65318;
    public static final int DIALOG_PROMPT = 65283;
    public static final int DIALOG_WAIT_S0 = 0;

    boolean doOnBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj);

    Dialog doOnCreateDialog(int i2);

    void doOnDestroy();

    void doOnEvent();

    boolean doOnPrepareDialog(int i2, Dialog dialog);

    void doOnSaveInstanceState(Bundle bundle);

    boolean handleFailure(int i2, int i3, String str);

    boolean handleResponse(int i2, Object obj, String str);

    void initSmsActivityView();

    boolean isBelongPaySDK();

    boolean isSendSmsOnCreate();

    boolean onCreateCheckInvalide(Bundle bundle);

    void onNextBtnClick(String str);

    void sendSms();

    void setActivity(PayBaseActivity payBaseActivity);

    void setSmsUpdateUIInterface(SmsUpdateUiInterface smsUpdateUiInterface);

    void setSmsVerifyHandler(SmsVerifyHandler smsVerifyHandler);
}
