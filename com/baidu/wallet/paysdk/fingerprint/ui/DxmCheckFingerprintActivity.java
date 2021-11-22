package com.baidu.wallet.paysdk.fingerprint.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.v;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.fingerprint.b;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity;
import com.baidu.walletsdk.pay.R;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class DxmCheckFingerprintActivity extends HalfScreenBaseActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f60669a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f60670b;

    /* renamed from: c  reason: collision with root package name */
    public int f60671c;

    /* renamed from: d  reason: collision with root package name */
    public int f60672d;

    /* renamed from: e  reason: collision with root package name */
    public String f60673e;

    public DxmCheckFingerprintActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60672d = 0;
        this.f60673e = "";
    }

    public static /* synthetic */ int a(DxmCheckFingerprintActivity dxmCheckFingerprintActivity) {
        int i2 = dxmCheckFingerprintActivity.f60672d;
        dxmCheckFingerprintActivity.f60672d = i2 + 1;
        return i2;
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity
    public void addContentView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesk_new_check_fingerprint_activity"), null);
            this.mContentView = viewGroup;
            this.mHalfScreenContainer.addView(viewGroup);
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a(-203, "");
        }
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, str) == null) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            if (i2 == 606) {
                com.baidu.wallet.newbindcard.c.a.a(PayStatServiceEvent.NEW_CHECK_PWD_RESULT, com.baidu.wallet.newbindcard.c.a.a(), com.baidu.wallet.newbindcard.c.a.b(), "1", i3 + "", str);
                a(3001, str);
            }
        }
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, obj, str) == null) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            if (i2 == 606) {
                com.baidu.wallet.newbindcard.c.a.a(PayStatServiceEvent.NEW_CHECK_PWD_RESULT, com.baidu.wallet.newbindcard.c.a.a(), com.baidu.wallet.newbindcard.c.a.b(), "1", "0", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                com.baidu.wallet.paysdk.fingerprint.a.a.a().a(0, obj != null ? obj.toString() : "");
                finishWithoutAnim();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            if (view == this.mLeftImg) {
                onBackPressed();
            } else if (view == this.f60669a) {
                a();
            } else if (view == this.mRightTxt) {
                com.baidu.wallet.newbindcard.c.a.a(PayStatServiceEvent.NEW_SWITCH_PWD, com.baidu.wallet.newbindcard.c.a.a(), com.baidu.wallet.newbindcard.c.a.b(), "1");
                a(3002, "");
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, com.dxmpay.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            com.baidu.wallet.newbindcard.c.a.c("1");
            int intExtra = getIntent().getIntExtra("showSwitchPwd", 0);
            int intExtra2 = getIntent().getIntExtra("checkTimes", 3);
            this.f60671c = intExtra2;
            if (intExtra2 < 1) {
                this.f60671c = 3;
            }
            this.f60673e = getIntent().getStringExtra("session_id");
            a(intExtra);
            com.baidu.wallet.newbindcard.c.a.a(PayStatServiceEvent.NEW_ENTER_CHECK_PWD_PAGE, com.baidu.wallet.newbindcard.c.a.a(), com.baidu.wallet.newbindcard.c.a.b(), "1");
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            HashMap hashMap = new HashMap();
            hashMap.put("count", Integer.valueOf(this.f60672d));
            com.baidu.wallet.newbindcard.c.a.a(PayStatServiceEvent.NEW_CHECK_PWD_COUNT, hashMap, com.baidu.wallet.newbindcard.c.a.a(), com.baidu.wallet.newbindcard.c.a.b(), "1");
            this.f60672d = 0;
            BeanManager.getInstance().removeAllBeans("NewCheckFingerprintActivity");
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
            WalletFingerprint.getInstance(this).cancleListening();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            a();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), payResultContent, Integer.valueOf(i2)}) == null) {
        }
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            showLikeLoadingPage(false);
            this.mHalfScreenContainer.setBackgroundResource(R.drawable.wallet_base_half_screen_container_round_bg);
            this.mRightTxt.setText("支付密码验证");
            this.mRightTxt.setTextSize(2, 15.0f);
            this.mRightTxt.setTextColor(ResUtils.getColor(this, "wallet_cashdesk_new_bind_card_7BE6"));
            this.f60669a = (ImageView) findViewById(R.id.iv_fingerprint_icon);
            TextView textView = (TextView) findViewById(R.id.tv_fingerprint_error_tip);
            this.f60670b = textView;
            textView.setVisibility(8);
            if (i2 == 0) {
                this.mRightTxt.setVisibility(8);
            } else {
                this.mRightTxt.setVisibility(0);
            }
            this.mLeftImg.setImageResource(R.drawable.wallet_base_halfscreen_new_bind_card_actionbar_close);
            this.mLeftImg.setOnClickListener(this);
            this.mRightTxt.setTypeface(Typeface.defaultFromStyle(1));
            this.f60669a.setOnClickListener(this);
            this.mRightTxt.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            WalletFingerprint.getInstance(this).startListening(new b(this) { // from class: com.baidu.wallet.paysdk.fingerprint.ui.DxmCheckFingerprintActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ DxmCheckFingerprintActivity f60674a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f60674a = this;
                }

                @Override // com.baidu.wallet.paysdk.fingerprint.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        com.baidu.wallet.newbindcard.c.a.a(PayStatServiceEvent.NEW_CHECK_PWD, com.baidu.wallet.newbindcard.c.a.a(), com.baidu.wallet.newbindcard.c.a.b(), "0");
                        DxmCheckFingerprintActivity.a(this.f60674a);
                        if (i2 == 0) {
                            this.f60674a.a(str);
                            return;
                        }
                        com.baidu.wallet.newbindcard.c.a.a(PayStatServiceEvent.NEW_CHECK_PWD_RESULT, com.baidu.wallet.newbindcard.c.a.a(), com.baidu.wallet.newbindcard.c.a.b(), "1", i2 + "", str);
                        this.f60674a.a(i2, "");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            WalletGlobalUtils.safeShowDialog(this, 0, "");
            v vVar = (v) PayBeanFactory.getInstance().getBean((Context) this, PayBeanFactory.BEAN_ID_NEW_CHECK_PASSWORD, "NewCheckFingerprintActivity");
            vVar.a(false);
            vVar.b(str);
            vVar.a("");
            vVar.c(this.f60673e);
            vVar.setResponseCallback(this);
            vVar.execBean();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, str) == null) {
            if (i2 != 0 && i2 != 3002 && i2 != -203 && i2 != -1 && i2 != -6 && i2 != -2 && i2 != -7) {
                runOnUiThread(new Runnable(this, str, i2) { // from class: com.baidu.wallet.paysdk.fingerprint.ui.DxmCheckFingerprintActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f60675a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f60676b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ DxmCheckFingerprintActivity f60677c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60677c = this;
                        this.f60675a = str;
                        this.f60676b = i2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            String str2 = this.f60675a;
                            if (TextUtils.isEmpty(str2)) {
                                str2 = ResUtils.getString(this.f60677c, "wallet_fp_error_fp");
                            }
                            this.f60677c.f60670b.setVisibility(0);
                            this.f60677c.f60670b.setText(str2);
                            TranslateAnimation translateAnimation = new TranslateAnimation(-50.0f, 50.0f, 0.0f, 0.0f);
                            translateAnimation.setDuration(50L);
                            translateAnimation.setRepeatCount(1);
                            translateAnimation.setRepeatMode(2);
                            this.f60677c.f60670b.startAnimation(translateAnimation);
                            if (this.f60677c.f60672d >= this.f60677c.f60671c) {
                                int i3 = this.f60676b;
                                if (i3 == -5) {
                                    i3 = 3005;
                                } else if (i3 == -3) {
                                    i3 = 3006;
                                } else if (i3 == -4) {
                                    i3 = SpeedStatsStampTable.NEW_LOGO_ACTIVITY_ON_CREATE_END_STAMP_KEY;
                                }
                                com.baidu.wallet.paysdk.fingerprint.a.a.a().a(i3, this.f60675a);
                                this.f60677c.finishWithoutAnim();
                            } else if (this.f60676b == 3001) {
                                this.f60677c.a();
                            }
                        }
                    }
                });
                return;
            }
            if (i2 == -1) {
                i2 = SpeedStatsStampTable.NEW_LOGO_ACTIVITY_START_STAMP_KEY;
            } else if (i2 == -6) {
                i2 = SpeedStatsStampTable.NEW_LOGO_ACTIVITY_ON_CREATE_END_STAMP_KEY;
            } else if (i2 == -2 || i2 == -7) {
                i2 = SpeedStatsStampTable.NEW_LOGO_ACTIVITY_ON_DESTROY_START_STAMP_KEY;
            }
            this.f60670b.setVisibility(8);
            com.baidu.wallet.paysdk.fingerprint.a.a.a().a(i2, str);
            finishWithoutAnim();
        }
    }
}
