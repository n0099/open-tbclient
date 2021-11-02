package com.baidu.wallet.newbindcard.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.wallet.newbindcard.c.a;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.v;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.ui.HalfProtocolScreenBaseActivity;
import com.baidu.walletsdk.pay.R;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.base.widget.SixNumberPwdView;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.beans.BeanErrorContent;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class NewCheckPwdActivity extends HalfProtocolScreenBaseActivity implements View.OnClickListener, SixNumberPwdView.OnPwdChangedListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHECK_FINGERPRINGT_STATUS = "checkFingerprintStatus";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SixNumberPwdView f59353a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59354b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59355c;

    /* renamed from: d  reason: collision with root package name */
    public View f59356d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59357e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f59358f;

    /* renamed from: g  reason: collision with root package name */
    public SafeScrollView f59359g;

    /* renamed from: h  reason: collision with root package name */
    public SafeKeyBoardEditText f59360h;

    /* renamed from: i  reason: collision with root package name */
    public final int f59361i;
    public final int j;
    public String k;
    public int l;

    public NewCheckPwdActivity() {
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
        this.f59357e = false;
        this.f59361i = 1;
        this.j = 2;
        this.l = 0;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            Intent intent = new Intent(this, NewBindCardMainActivity.class);
            intent.putExtra(NewBindCardMainActivity.BIND_CARD_NUMBER, this.k);
            startActivity(intent);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfProtocolScreenBaseActivity
    public void addContentView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesk_new_check_pwd_activity"), null);
            this.mContentView = viewGroup;
            this.mHalfScreenContainer.addView(viewGroup);
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a.a(PayStatServiceEvent.NEW_CHECK_PWD_RESULT, a.a(), a.b(), "0", StatHelper.SENSOR_ERR_2, "NewCheckPwdActivity onBackPressed");
            finishWithoutAnim();
        }
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, str) == null) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            if (606 == i2) {
                a.a(PayStatServiceEvent.NEW_CHECK_PWD_RESULT, a.a(), a.b(), "0", i3 + "", str);
                c();
                if (i3 == 100015) {
                    a(str, false);
                } else if (i3 == 100018) {
                    if (TextUtils.isEmpty(str)) {
                        str = ResUtils.getString(getActivity(), "ebpay_pass_locked_tip");
                    }
                    this.mDialogMsg = str;
                    runOnUiThread(new Runnable(this) { // from class: com.baidu.wallet.newbindcard.ui.NewCheckPwdActivity.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ NewCheckPwdActivity f59362a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f59362a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                WalletGlobalUtils.safeShowDialog(this.f59362a.mAct, 2, "");
                            }
                        }
                    });
                } else {
                    a(str);
                }
            }
        }
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, obj, str) == null) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            if (606 == i2) {
                a.a(PayStatServiceEvent.NEW_CHECK_PWD_RESULT, a.a(), a.b(), "0", "0", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                d();
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
            } else if (view == this.f59356d) {
                a();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfProtocolScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            setFlagActiveBindCard();
            EventBus.getInstance().register(this, BeanConstants.EVT_PAY_PWD_CHANGE, 0, EventBus.ThreadMode.MainThread);
            this.k = getIntent().getStringExtra(NewBindCardMainActivity.BIND_CARD_NUMBER);
            a(getIntent().getIntExtra(CHECK_FINGERPRINGT_STATUS, -1));
            a.c("0");
            a.a(PayStatServiceEvent.NEW_ENTER_CHECK_PWD_PAGE, a.a(), a.b(), "0");
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 != 1 && i2 != 2) {
                return super.onCreateDialog(i2);
            }
            return new PromptDialog(getActivity());
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfProtocolScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            HashMap hashMap = new HashMap();
            hashMap.put("count", Integer.valueOf(this.l));
            this.l = 0;
            a.a(PayStatServiceEvent.NEW_CHECK_PWD_COUNT, hashMap, a.a(), a.b(), "0");
            BeanManager.getInstance().removeAllBeans("NewCheckPwdActivity");
            if (this.f59357e) {
                PasswordController.getPassWordInstance().clearForgetPasswdCallback();
            }
            EventBus.getInstance().unregister(this);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, event) == null) || event == null) {
            return;
        }
        if (BeanConstants.EVT_PAY_PWD_CHANGE.equals(event.mEventKey)) {
            if (event.mEventObj != null) {
                try {
                    JSONObject jSONObject = new JSONObject((String) event.mEventObj);
                    if (jSONObject.has("is_succeed") && 1 == jSONObject.getInt("is_succeed")) {
                        a.a(PayStatServiceEvent.NEW_CHECK_PWD_FIND_PWD_RESULT, a.a(), a.b(), "0", "0", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                        this.f59354b.setVisibility(4);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } else if ("ev_bean_execut_err_content".equals(event.mEventKey)) {
            Object obj = event.mEventObj;
            if (obj instanceof BeanErrorContent) {
                BeanErrorContent beanErrorContent = (BeanErrorContent) obj;
                if (beanErrorContent != null) {
                    a.a(PayStatServiceEvent.NEW_CHECK_PWD_FIND_PWD_RESULT, a.a(), a.b(), "0", beanErrorContent.getRet() + "", beanErrorContent.getMsg());
                    onBeanExecFailureWithErrContent(beanErrorContent.getBeanId(), beanErrorContent.getRet(), beanErrorContent.getMsg(), beanErrorContent.getErrContent());
                }
                EventBus.getInstance().removeStickyEvent("ev_bean_execut_err_content");
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, dialog) == null) {
            if (i2 == 3) {
                PromptDialog promptDialog = (PromptDialog) dialog;
                promptDialog.hideTitle();
                promptDialog.hideNegativeButton();
                promptDialog.setMessage(this.mDialogMsg);
                promptDialog.setPositiveBtn(ResUtils.string(this.mAct, "dxm_ebpay_know"), new View.OnClickListener(this) { // from class: com.baidu.wallet.newbindcard.ui.NewCheckPwdActivity.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ NewCheckPwdActivity f59370a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f59370a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f59370a.mAct, 3);
                        }
                    }
                });
            } else if (i2 == 1) {
                PromptDialog promptDialog2 = (PromptDialog) dialog;
                promptDialog2.setMessage(ResUtils.getString(this.mAct, "ebpay_pwd_check_msg_for_halfscreen_pwd_verify"));
                promptDialog2.setTitleText(ResUtils.getString(this.mAct, "wallet_base_new_bind_card_check_pwd_tip"));
                promptDialog2.hideNegativeButton();
                a.a(PayStatServiceEvent.NEW_SHOW_WHAT_PWD_DIALOG, a.a(), a.b(), "0");
                promptDialog2.setPositiveBtn(ResUtils.getString(this.mAct, "ebpay_pwd_close_promotion_dialog"), new View.OnClickListener(this, promptDialog2) { // from class: com.baidu.wallet.newbindcard.ui.NewCheckPwdActivity.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PromptDialog f59371a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ NewCheckPwdActivity f59372b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, promptDialog2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f59372b = this;
                        this.f59371a = promptDialog2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            a.a(PayStatServiceEvent.NEW_CLICK_WHAT_PWD_DIALOG, a.a(), a.b(), "0");
                            this.f59371a.dismiss();
                        }
                    }
                });
            } else if (i2 == 2) {
                PromptDialog promptDialog3 = (PromptDialog) dialog;
                promptDialog3.setMessage(this.mDialogMsg);
                promptDialog3.setCanceledOnTouchOutside(false);
                promptDialog3.setNegativeBtn(ResUtils.string(getActivity(), "ebpay_find_password"), new View.OnClickListener(this) { // from class: com.baidu.wallet.newbindcard.ui.NewCheckPwdActivity.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ NewCheckPwdActivity f59373a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f59373a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f59373a.a();
                            WalletGlobalUtils.safeDismissDialog(this.f59373a, 2);
                        }
                    }
                });
                promptDialog3.setPositiveBtn(ResUtils.string(getActivity(), "dxm_ebpay_know"), new View.OnClickListener(this) { // from class: com.baidu.wallet.newbindcard.ui.NewCheckPwdActivity.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ NewCheckPwdActivity f59374a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f59374a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f59374a, 2);
                        }
                    }
                });
            } else {
                super.onPrepareDialog(i2, dialog);
            }
        }
    }

    @Override // com.dxmpay.wallet.base.widget.SixNumberPwdView.OnPwdChangedListener
    public void onPwdChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            if (i2 == 6) {
                this.l++;
                a.a(PayStatServiceEvent.NEW_CHECK_PWD, a.a(), a.b(), "0");
                b();
            } else if (i2 == 1) {
                a(ResUtils.getString(this, "wallet_base_new_bind_card_check_pwd_tip"), true);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (z) {
                this.f59360h.requestFocus();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), payResultContent, Integer.valueOf(i2)}) == null) {
        }
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            this.mActionBar.setVisibility(0);
            this.f59358f = (RelativeLayout) findViewById(R.id.new_bind_card_check_pwd_layout);
            this.f59353a = (SixNumberPwdView) findViewById(R.id.new_pwd_input_box);
            this.f59354b = (TextView) findViewById(R.id.new_error_tip);
            this.f59355c = (TextView) findViewById(R.id.tv_check_pwd_tip);
            this.f59356d = findViewById(R.id.new_forget_pwd);
            this.f59359g = (SafeScrollView) findViewById(R.id.new_check_pwd_scrollview);
            SafeKeyBoardEditText safeKeyBoardEditText = (SafeKeyBoardEditText) this.f59353a.findViewById(ResUtils.id(getActivity(), "pwd_input"));
            this.f59360h = safeKeyBoardEditText;
            safeKeyBoardEditText.initSafeKeyBoardParams(this.f59358f, this.f59359g, safeKeyBoardEditText, false);
            this.f59360h.setGap(20);
            this.f59360h.setDisablePast(true);
            this.f59353a.addSixNumberPwdChangedListenter(this);
            setSafeScrollView(this.f59359g);
            this.f59360h.requestFocus();
            this.mLeftImg.setOnClickListener(this);
            a(ResUtils.getString(this, "wallet_base_new_bind_card_check_pwd_tip"), true);
            this.f59356d.setOnClickListener(this);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            WalletGlobalUtils.safeShowDialog(this, 0, "");
            v vVar = (v) PayBeanFactory.getInstance().getBean((Context) this, PayBeanFactory.BEAN_ID_NEW_CHECK_PASSWORD, "NewCheckPwdActivity");
            vVar.a(true);
            vVar.b("");
            vVar.a(this.f59353a.getPwd());
            vVar.setResponseCallback(this);
            vVar.execBean();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            runOnUiThread(new Runnable(this) { // from class: com.baidu.wallet.newbindcard.ui.NewCheckPwdActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ NewCheckPwdActivity f59363a;

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
                    this.f59363a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f59363a.f59353a.resetPwd();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            String findPayPwdUrl = SdkInitResponse.getInstance().getFindPayPwdUrl(getActivity());
            if (TextUtils.isEmpty(findPayPwdUrl)) {
                findPayPwdUrl = BeanConstants.API_FIND_PAY_PWD_URL;
            }
            a.a(PayStatServiceEvent.NEW_CHECK_PWD_FORGET_PWD, a.a(), a.b(), "0");
            BaiduWalletDelegate.getInstance().openH5Module(getActivity(), findPayPwdUrl, false);
            this.f59357e = true;
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            runOnUiThread(new Runnable(this, str) { // from class: com.baidu.wallet.newbindcard.ui.NewCheckPwdActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f59364a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ NewCheckPwdActivity f59365b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59365b = this;
                    this.f59364a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        GlobalUtils.toast(this.f59365b, this.f59364a);
                    }
                }
            });
        }
    }

    private void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, this, str, z) == null) {
            runOnUiThread(new Runnable(this, str, z) { // from class: com.baidu.wallet.newbindcard.ui.NewCheckPwdActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f59366a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f59367b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ NewCheckPwdActivity f59368c;

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
                    this.f59368c = this;
                    this.f59366a = str;
                    this.f59367b = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f59368c.f59354b.setText(this.f59366a);
                        if (this.f59367b) {
                            this.f59368c.f59354b.setTextColor(ResUtils.getColor(this.f59368c, "wallet_cashdesk_new_bind_card_7BE6"));
                        } else {
                            this.f59368c.f59354b.setTextColor(ResUtils.getColor(this.f59368c, "dxm_wallet_fp_promtion_text"));
                        }
                        this.f59368c.f59354b.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.newbindcard.ui.NewCheckPwdActivity.4.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass4 f59369a;

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
                                this.f59369a = this;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, view) == null) {
                                    AnonymousClass4 anonymousClass4 = this.f59369a;
                                    if (anonymousClass4.f59367b) {
                                        WalletGlobalUtils.safeShowDialog(anonymousClass4.f59368c.mAct, 1, "");
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
