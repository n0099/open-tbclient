package com.baidu.wallet.paysdk.ui;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.sms.controller.ISmsController;
import com.baidu.wallet.paysdk.sms.controller.g;
import com.baidu.wallet.paysdk.sms.controller.h;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.utils.BdWalletUtils;
/* loaded from: classes8.dex */
public class VoiceVerifyActivity extends WalletSmsActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public VoiceVerifyActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.WalletSmsActivity
    public ISmsController getController(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 == 0) {
                return new g();
            }
            return new h();
        }
        return (ISmsController) invokeI.objValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.WalletSmsActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            ErrorContentResponse.Verify verify = (ErrorContentResponse.Verify) getIntent().getSerializableExtra(BeanConstants.EXTRA_VERIFY_VOICE_DATA);
            String voiceMsg = verify != null ? verify.getVoiceMsg() : "";
            if (TextUtils.isEmpty(voiceMsg)) {
                voiceMsg = String.format(ResUtils.getString(this, "ebpay_sms_title_tip_voice_verify"), BdWalletUtils.getKefuPhoneNum(this));
            }
            this.mTopPhoneTip.setText(voiceMsg);
            this.mHelp.setText(ResUtils.getString(this, "ebpay_get_voice_code_error"));
            this.mSendSms.setTextSize(1, 12.0f);
            this.mSendSms.setText(ResUtils.getString(getActivity(), "ebpay_get_voice_code"));
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.WalletSmsActivity
    public void startCountDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mHasVerifyCodeSend = true;
            CountDownTimer countDownTimer = this.mTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.mTimer = null;
            }
            CountDownTimer countDownTimer2 = new CountDownTimer(this, 60000L, 1000L) { // from class: com.baidu.wallet.paysdk.ui.VoiceVerifyActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ VoiceVerifyActivity f63482a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r11, r13);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(r11), Long.valueOf(r13)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f63482a = this;
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        VoiceVerifyActivity voiceVerifyActivity = this.f63482a;
                        voiceVerifyActivity.mSendSms.setText(ResUtils.getString(voiceVerifyActivity.getActivity(), "ebpay_recall"));
                        this.f63482a.mSendSms.setTextSize(1, 16.0f);
                        this.f63482a.mSendSms.setEnabled(true);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                        this.f63482a.mSendSms.setEnabled(false);
                        this.f63482a.mSendSms.setTextSize(1, 12.0f);
                        VoiceVerifyActivity voiceVerifyActivity = this.f63482a;
                        voiceVerifyActivity.mSendSms.setText(String.format(ResUtils.getString(voiceVerifyActivity.getActivity(), "ebpay_recall_timer"), Integer.valueOf((int) (j2 / 1000))));
                    }
                }
            };
            this.mTimer = countDownTimer2;
            countDownTimer2.start();
            this.mSendSms.setEnabled(false);
        }
    }
}
