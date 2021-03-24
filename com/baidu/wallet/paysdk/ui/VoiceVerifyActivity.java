package com.baidu.wallet.paysdk.ui;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.sms.controller.ISmsController;
import com.baidu.wallet.paysdk.sms.controller.h;
import com.baidu.wallet.paysdk.sms.controller.i;
import com.baidu.wallet.utils.BdWalletUtils;
/* loaded from: classes5.dex */
public class VoiceVerifyActivity extends WalletSmsActivity {
    @Override // com.baidu.wallet.paysdk.ui.WalletSmsActivity
    public ISmsController getController(int i) {
        if (i == 0) {
            return new h();
        }
        return new i();
    }

    @Override // com.baidu.wallet.paysdk.ui.WalletSmsActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String voiceMsg = ((ErrorContentResponse.Verify) getIntent().getSerializableExtra(BeanConstants.EXTRA_VERIFY_VOICE_DATA)).getVoiceMsg();
        if (TextUtils.isEmpty(voiceMsg)) {
            voiceMsg = String.format(ResUtils.getString(this, "ebpay_sms_title_tip_voice_verify"), BdWalletUtils.getKefuPhoneNum(this));
        }
        this.mTopPhoneTip.setText(voiceMsg);
        this.mHelp.setText(ResUtils.getString(this, "ebpay_get_voice_code_error"));
        this.mSendSms.setTextSize(1, 12.0f);
        this.mSendSms.setText(ResUtils.getString(getActivity(), "ebpay_get_voice_code"));
    }

    @Override // com.baidu.wallet.paysdk.ui.WalletSmsActivity
    public void startCountDown() {
        this.mHasVerifyCodeSend = true;
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mTimer = null;
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(60000L, 1000L) { // from class: com.baidu.wallet.paysdk.ui.VoiceVerifyActivity.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                VoiceVerifyActivity voiceVerifyActivity = VoiceVerifyActivity.this;
                voiceVerifyActivity.mSendSms.setText(ResUtils.getString(voiceVerifyActivity.getActivity(), "ebpay_recall"));
                VoiceVerifyActivity.this.mSendSms.setTextSize(1, 16.0f);
                VoiceVerifyActivity.this.mSendSms.setEnabled(true);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                VoiceVerifyActivity.this.mSendSms.setEnabled(false);
                VoiceVerifyActivity.this.mSendSms.setTextSize(1, 12.0f);
                VoiceVerifyActivity voiceVerifyActivity = VoiceVerifyActivity.this;
                voiceVerifyActivity.mSendSms.setText(String.format(ResUtils.getString(voiceVerifyActivity.getActivity(), "ebpay_recall_timer"), Integer.valueOf((int) (j / 1000))));
            }
        };
        this.mTimer = countDownTimer2;
        countDownTimer2.start();
        this.mSendSms.setEnabled(false);
    }
}
