package com.baidu.wallet.newbindcard.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.wallet.newbindcard.c.a;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.b;
import com.baidu.wallet.paysdk.datamodel.BindCardResponse;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.HalfProtocolScreenBaseActivity;
import com.baidu.walletsdk.pay.R;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.base.widget.SixNumberPwdView;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class NewSetPwdActivity extends HalfProtocolScreenBaseActivity implements View.OnClickListener, SixNumberPwdView.OnPwdChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SixNumberPwdView f59391a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59392b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f59393c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f59394d;

    /* renamed from: e  reason: collision with root package name */
    public SafeScrollView f59395e;

    /* renamed from: f  reason: collision with root package name */
    public SafeKeyBoardEditText f59396f;

    /* renamed from: g  reason: collision with root package name */
    public final int f59397g;

    /* renamed from: h  reason: collision with root package name */
    public int f59398h;

    public NewSetPwdActivity() {
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
        this.f59397g = 1;
        this.f59398h = 0;
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfProtocolScreenBaseActivity
    public void addContentView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesk_new_set_pwd_activity"), null);
            this.mContentView = viewGroup;
            this.mHalfScreenContainer.addView(viewGroup);
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a.a(PayStatServiceEvent.NEW_SET_PWD_RESULT, a.a(), a.b(), StatHelper.SENSOR_ERR_2, "NewSetPwdActivity onBackPressed");
            finishWithoutAnim();
        }
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, str) == null) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            if (513 == i2) {
                a.a(PayStatServiceEvent.NEW_SET_PWD_RESULT, a.a(), a.b(), i3 + "", str);
                if (i3 == -8) {
                    if (TextUtils.isEmpty(str)) {
                        str = getString(ResUtils.string(getActivity(), "dxm_ebpay_no_network"));
                    }
                    runOnUiThread(new Runnable(this, str) { // from class: com.baidu.wallet.newbindcard.ui.NewSetPwdActivity.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ String f59402a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ NewSetPwdActivity f59403b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f59403b = this;
                            this.f59402a = str;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                GlobalUtils.toast(this.f59403b, this.f59402a);
                            }
                        }
                    });
                    return;
                }
                a(str, false);
            }
        }
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, obj, str) == null) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            if (513 == i2) {
                a.a(PayStatServiceEvent.NEW_SET_PWD_RESULT, a.a(), a.b(), "0", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                BindCardResponse bindCardResponse = (BindCardResponse) obj;
                runOnUiThread(new Runnable(this, bindCardResponse != null ? bindCardResponse.card_no : "") { // from class: com.baidu.wallet.newbindcard.ui.NewSetPwdActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f59400a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ NewSetPwdActivity f59401b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r7};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f59401b = this;
                        this.f59400a = r7;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            NewBindCardEntry.getInstance().newBindCardCallback("0", this.f59400a, false);
                        }
                    }
                });
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view) == null) && view == this.mLeftImg) {
            onBackPressed();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfProtocolScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            setFlagActiveBindCard();
            a();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 == 1) {
                return new PromptDialog(getActivity());
            }
            return super.onCreateDialog(i2);
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfProtocolScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            HashMap hashMap = new HashMap();
            hashMap.put("count", Integer.valueOf(this.f59398h));
            this.f59398h = 0;
            a.a(PayStatServiceEvent.NEW_SET_PWD_COUNT, hashMap, a.a(), a.b());
            BeanManager.getInstance().removeAllBeans("NewSetPwdActivity");
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, dialog) == null) {
            if (i2 == 1) {
                PromptDialog promptDialog = (PromptDialog) dialog;
                a.a(PayStatServiceEvent.NEW_SHOW_WHAT_PWD_DIALOG, a.a(), a.b(), "0");
                promptDialog.setMessage(ResUtils.getString(this.mAct, "ebpay_pwd_promotion_message"));
                promptDialog.setTitleText(ResUtils.getString(this.mAct, "ebpay_pwd_explain"));
                promptDialog.hideNegativeButton();
                promptDialog.setPositiveBtn(ResUtils.getString(this.mAct, "ebpay_pwd_close_promotion_dialog"), new View.OnClickListener(this, promptDialog) { // from class: com.baidu.wallet.newbindcard.ui.NewSetPwdActivity.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PromptDialog f59408a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ NewSetPwdActivity f59409b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, promptDialog};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f59409b = this;
                        this.f59408a = promptDialog;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            a.a(PayStatServiceEvent.NEW_CLICK_WHAT_PWD_DIALOG, a.a(), a.b(), "0");
                            this.f59408a.dismiss();
                        }
                    }
                });
                return;
            }
            super.onPrepareDialog(i2, dialog);
        }
    }

    @Override // com.dxmpay.wallet.base.widget.SixNumberPwdView.OnPwdChangedListener
    public void onPwdChanged(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i2) == null) && i2 == 6) {
            this.f59398h++;
            a.a(PayStatServiceEvent.NEW_SET_PWD, a.a(), a.b());
            b();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (z) {
                this.f59396f.requestFocus();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), payResultContent, Integer.valueOf(i2)}) == null) {
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mActionBar.setVisibility(0);
            this.f59394d = (RelativeLayout) findViewById(R.id.new_bind_card_set_pwd_layout);
            this.f59391a = (SixNumberPwdView) findViewById(R.id.new_pwd_input_box);
            this.f59392b = (TextView) findViewById(R.id.new_error_tip);
            this.f59395e = (SafeScrollView) findViewById(R.id.new_set_pwd_scrollview);
            this.f59393c = (LinearLayout) findViewById(R.id.lin_set_pwd_tip);
            SafeKeyBoardEditText safeKeyBoardEditText = (SafeKeyBoardEditText) this.f59391a.findViewById(ResUtils.id(getActivity(), "pwd_input"));
            this.f59396f = safeKeyBoardEditText;
            safeKeyBoardEditText.initSafeKeyBoardParams(this.f59394d, this.f59395e, safeKeyBoardEditText, false);
            this.f59396f.setGap(20);
            this.f59396f.setDisablePast(true);
            this.f59391a.addSixNumberPwdChangedListenter(this);
            setSafeScrollView(this.f59395e);
            this.f59396f.requestFocus();
            this.mLeftImg.setOnClickListener(this);
            a(ResUtils.getString(this, "wallet_base_new_bind_card_check_pwd_tip"), true);
            a.a(PayStatServiceEvent.NEW_ENTER_SET_PWD_PAGE, a.a(), a.b());
            this.f59395e.setKeyBoardStatusChangeListener(new SafeScrollView.onKeyBoardStatusChangeListener(this) { // from class: com.baidu.wallet.newbindcard.ui.NewSetPwdActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ NewSetPwdActivity f59399a;

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
                    this.f59399a = this;
                }

                @Override // com.dxmpay.wallet.base.widget.SafeScrollView.onKeyBoardStatusChangeListener
                public void onKeyBoardStatusChange(boolean z, int i2) {
                    DisplayMetrics displayMetrics;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (displayMetrics = this.f59399a.getResources().getDisplayMetrics()) == null) {
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f59399a.f59393c.getLayoutParams();
                    layoutParams.setMargins(0, ((((displayMetrics.heightPixels - i2) - this.f59399a.mHalfScreenContainer.getTop()) - this.f59399a.f59392b.getTop()) - this.f59399a.mActionBar.getHeight()) - this.f59399a.f59393c.getHeight(), 0, 0);
                    this.f59399a.f59393c.setLayoutParams(layoutParams);
                }
            });
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            WalletGlobalUtils.safeShowDialog(this.mAct, 0, "");
            PwdRequest pwdRequest = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
            if (pwdRequest != null) {
                pwdRequest.mPayPass = this.f59391a.getPwd();
                pwdRequest.mConfirmPayPass = this.f59391a.getPwd();
            }
            b bVar = (b) PayBeanFactory.getInstance().getBean((Context) this, 513, "NewSetPwdActivity");
            bVar.a(NewBindCardEntry.getInstance().getBindReq());
            bVar.setResponseCallback(this);
            bVar.execBean();
        }
    }

    private void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, this, str, z) == null) {
            runOnUiThread(new Runnable(this, str, z) { // from class: com.baidu.wallet.newbindcard.ui.NewSetPwdActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f59404a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f59405b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ NewSetPwdActivity f59406c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59406c = this;
                    this.f59404a = str;
                    this.f59405b = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f59406c.f59391a.resetPwd();
                        this.f59406c.f59392b.setText(this.f59404a);
                        if (this.f59405b) {
                            this.f59406c.f59392b.setTextColor(ResUtils.getColor(this.f59406c, "wallet_cashdesk_new_bind_card_7BE6"));
                        } else {
                            this.f59406c.f59392b.setTextColor(ResUtils.getColor(this.f59406c, "dxm_wallet_fp_promtion_text"));
                        }
                        this.f59406c.f59392b.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.newbindcard.ui.NewSetPwdActivity.4.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass4 f59407a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f59407a = this;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, view) == null) {
                                    AnonymousClass4 anonymousClass4 = this.f59407a;
                                    if (anonymousClass4.f59405b) {
                                        WalletGlobalUtils.safeShowDialog(anonymousClass4.f59406c.mAct, 1, "");
                                    }
                                }
                            }
                        });
                    }
                }
            });
        }
    }
}
