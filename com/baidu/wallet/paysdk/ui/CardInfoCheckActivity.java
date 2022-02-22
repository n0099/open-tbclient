package com.baidu.wallet.paysdk.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.i;
import com.baidu.wallet.paysdk.beans.w;
import com.baidu.wallet.paysdk.contract.a;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.PayLoadingImageViewNew;
import com.baidu.wallet.paysdk.ui.widget.SuccessImageViewNew;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeKeyBoardUtil;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
/* loaded from: classes2.dex */
public class CardInfoCheckActivity extends HalfScreenBaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BEAN_TAG = "CardInfoCheckActivity";
    public static final String CHECK_INFO_STATE = "check_info_state";
    public static final String TAG = "CardInfoCheckActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public a.InterfaceC2028a a;

    /* renamed from: b  reason: collision with root package name */
    public a.b f52462b;

    /* renamed from: c  reason: collision with root package name */
    public int f52463c;

    /* renamed from: d  reason: collision with root package name */
    public SafeKeyBoardEditText f52464d;

    /* renamed from: e  reason: collision with root package name */
    public PayRequest f52465e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f52466f;

    /* renamed from: g  reason: collision with root package name */
    public SafeScrollView f52467g;

    /* renamed from: h  reason: collision with root package name */
    public SafeKeyBoardUtil f52468h;

    /* renamed from: i  reason: collision with root package name */
    public PayLoadingImageViewNew f52469i;

    /* renamed from: j  reason: collision with root package name */
    public View f52470j;
    public SuccessImageViewNew k;
    public boolean l;

    public CardInfoCheckActivity() {
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
        this.f52463c = 0;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            com.baidu.wallet.paysdk.beans.a aVar = (com.baidu.wallet.paysdk.beans.a) PayBeanFactory.getInstance().getBean((Context) this.mAct, 14, "CardInfoCheckActivity");
            aVar.setResponseCallback(this.mAct);
            aVar.execBean();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            w wVar = (w) PayBeanFactory.getInstance().getBean((Context) this.mAct, 13, "CardInfoCheckActivity");
            wVar.setResponseCallback(this.mAct);
            wVar.a(true);
            wVar.execBean();
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.f52466f = (RelativeLayout) findViewById(ResUtils.id(this.mAct, "wallet_cashdesk_card_info_check_content"));
            SafeScrollView safeScrollView = (SafeScrollView) findViewById(ResUtils.id(getActivity(), "scrollview"));
            this.f52467g = safeScrollView;
            safeScrollView.setVisibility(0);
            this.f52467g.addView(this.f52462b.a());
            PayLoadingImageViewNew payLoadingImageViewNew = (PayLoadingImageViewNew) findViewById(ResUtils.id(this, "bd_wallet_cashier_loading_view"));
            this.f52469i = payLoadingImageViewNew;
            payLoadingImageViewNew.setVisibility(8);
            this.k = (SuccessImageViewNew) findViewById(ResUtils.id(this, "bd_wallet_success_logo"));
            View findViewById = findViewById(ResUtils.id(this, "bd_wallet_success_logo"));
            this.f52470j = findViewById;
            findViewById.setVisibility(8);
            setSafeScrollView(this.f52467g);
            ((TextView) this.mHalfScreenContainer.findViewById(ResUtils.id(this.mAct, "bd_wallet_bind_card_title"))).setText(ResUtils.getString(getActivity(), "ebpay_title_risk_control"));
            ViewGroup viewGroup = (ViewGroup) this.mHalfScreenContainer.findViewById(ResUtils.id(this.mAct, "wallet_bind_card_subtitle"));
            CardData.BondCard bondCard = this.f52465e.mBondCard;
            if (bondCard == null) {
                com.baidu.wallet.paysdk.ui.widget.a.a(viewGroup, ResUtils.getString(this.mAct, "ebpay_title_complete_fixmsg"), null, null);
            } else {
                com.baidu.wallet.paysdk.ui.widget.a.a(viewGroup, "请完善", bondCard.getCardDesc(this.mAct, false), "的信息后继续支付");
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity
    public void addContentView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mHalfScreenContainer.removeView(this.mActionBar);
            ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesk_card_info_check_layout"), null);
            this.mContentView = viewGroup;
            this.mHalfScreenContainer.addView(viewGroup);
            this.mActionBar = findViewById(ResUtils.id(getActivity(), "ebpay_halfscreen_action_bar"));
            this.mLeftImg = (ImageView) findViewById(ResUtils.id(getActivity(), "action_bar_left_img"));
            this.mTitle = (TextView) findViewById(ResUtils.id(getActivity(), "action_bar_title"));
            this.mRightTxt = (TextView) findViewById(ResUtils.id(getActivity(), "action_bar_left_txt"));
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void handleErrorContent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b();
            this.l = false;
            this.f52467g.setVisibility(0);
            super.handleErrorContent();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, str) == null) {
            b();
            this.l = false;
            this.f52467g.setVisibility(0);
            if (i2 != 263 && i2 != 13 && i2 != 14) {
                super.handleFailure(i2, i3, str);
            } else if (i3 == 5003) {
                GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "dxm_wallet_base_please_login"));
                AccountManager.getInstance(getActivity()).logout();
                WalletLoginHelper.getInstance().logout(false);
            } else if (i3 == -2) {
                GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "dxm_fp_get_data_fail"));
            } else if (i3 == -3) {
                GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "dxm_fp_get_data_fail"));
            } else if (i3 == -4) {
                GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "dxm_fp_get_data_fail"));
            } else if (i3 == -8) {
                WalletGlobalUtils.safeShowDialog(this, 11, "");
            } else {
                this.mDialogMsg = str;
                if (TextUtils.isEmpty(str)) {
                    this.mDialogMsg = ResUtils.getString(getActivity(), "dxm_fp_get_data_fail");
                }
                if (TextUtils.isEmpty(str)) {
                    str = ResUtils.getString(this, "dxm_fp_get_data_fail");
                }
                this.mDialogMsg = str;
                WalletGlobalUtils.safeShowDialog(this, 12, "");
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, obj, str) == null) {
            super.handleResponse(i2, obj, str);
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.l) {
            return;
        }
        if (PayDataCache.getInstance().isFromPreCashier()) {
            WalletGlobalUtils.safeShowDialog(this, 18, "");
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, obj}) == null) {
            b();
            this.l = false;
            super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, com.dxmpay.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            setIsShowMultiWindowTips(true);
            getActivity().getWindow().setSoftInputMode(2);
            this.f52465e = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
                return;
            }
            this.f52463c = extras.getInt(CHECK_INFO_STATE);
            a.b a = com.baidu.wallet.paysdk.ui.a.b.a().a(this.f52463c, getActivity());
            this.f52462b = a;
            if (a == null) {
                finish();
                return;
            }
            a.InterfaceC2028a a2 = com.baidu.wallet.paysdk.presenter.a.b.a(this.f52463c, a);
            this.a = a2;
            if (a2 == null) {
                finish();
                return;
            }
            g();
            CardData.BondCard bondCard = this.f52465e.mBondCard;
            if (bondCard != null) {
                this.f52462b.a(bondCard.getCardDescShort());
            }
            if (bundle != null) {
                this.l = bundle.getBoolean("isloading");
                this.f52464d.setText((String) bundle.get("saveContent"));
            }
            SafeKeyBoardEditText b2 = this.f52462b.b();
            this.f52464d = b2;
            b2.setCheckFunc(new SafeKeyBoardEditText.CheckFunc(this) { // from class: com.baidu.wallet.paysdk.ui.CardInfoCheckActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CardInfoCheckActivity a;

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
                    this.a = this;
                }

                @Override // com.dxmpay.wallet.base.widget.SafeKeyBoardEditText.CheckFunc
                public boolean check(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) ? this.a.a.b(str) : invokeL.booleanValue;
                }
            });
            this.mLeftImg.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.CardInfoCheckActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CardInfoCheckActivity a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.onBackPressed();
                    }
                }
            });
            this.f52464d.setConfirmListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.CardInfoCheckActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CardInfoCheckActivity a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        a.InterfaceC2028a interfaceC2028a = this.a.a;
                        CardInfoCheckActivity cardInfoCheckActivity = this.a;
                        if (!interfaceC2028a.a(cardInfoCheckActivity.a((CharSequence) cardInfoCheckActivity.f52464d.getEditableText().toString()))) {
                            this.a.f52462b.c();
                            return;
                        }
                        a.InterfaceC2028a interfaceC2028a2 = this.a.a;
                        CardInfoCheckActivity cardInfoCheckActivity2 = this.a;
                        interfaceC2028a2.c(cardInfoCheckActivity2.a((CharSequence) cardInfoCheckActivity2.f52464d.getEditableText().toString()));
                        this.a.c();
                    }
                }
            });
            SafeKeyBoardEditText safeKeyBoardEditText = this.f52464d;
            safeKeyBoardEditText.initSafeKeyBoardParams(this.f52466f, this.f52467g, safeKeyBoardEditText, false);
            SafeKeyBoardUtil safeKeyBoardUtil = new SafeKeyBoardUtil();
            this.f52468h = safeKeyBoardUtil;
            safeKeyBoardUtil.setState(SafeKeyBoardUtil.SafeKeyBoardState.CONFRIM_STATE);
            this.f52467g.setSafeKeyBoardUtil(this.f52468h);
            this.f52467g.setAlwaysShowSoftKeyBoard(true);
            this.f52464d.requestFocus();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            SafeKeyBoardUtil safeKeyBoardUtil = this.f52468h;
            if (safeKeyBoardUtil != null) {
                safeKeyBoardUtil.hideSoftKeyBoard();
            }
            SafeScrollView safeScrollView = this.f52467g;
            if (safeScrollView != null) {
                safeScrollView.clear();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void onNegativeBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (PayDataCache.getInstance().isFromPreCashier()) {
                PayCallBackManager.callBackClientCancel(this, "CardInfoCheckActivityonNegativeBtnClick().1");
            } else {
                finishWithoutAnim();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle != null) {
                bundle.putSerializable("isloading", Boolean.valueOf(this.l));
                bundle.putString("saveContent", this.f52464d.getEditableText().toString());
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), payResultContent, Integer.valueOf(i2)}) == null) {
            b();
            this.mActionBar.setVisibility(4);
            this.f52467g.setVisibility(8);
            this.f52470j.setVisibility(0);
            this.k.startAnimation(new SuccessImageViewNew.a(this, z, payResultContent) { // from class: com.baidu.wallet.paysdk.ui.CardInfoCheckActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PayResultContent f52471b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ CardInfoCheckActivity f52472c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), payResultContent};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f52472c = this;
                    this.a = z;
                    this.f52471b = payResultContent;
                }

                @Override // com.baidu.wallet.paysdk.ui.widget.SuccessImageViewNew.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.a) {
                            this.f52472c.l = false;
                            PayController.getInstance().paySucess(this.f52472c, this.f52471b, 1);
                            return;
                        }
                        this.f52472c.l = false;
                        PayController.getInstance().payPaying(this.f52472c, this.f52471b, 1);
                    }
                }
            });
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.mActionBar.setVisibility(0);
            this.f52469i.stopAnimation();
            this.f52469i.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            a();
            PayRequest.PayPrice.PayType payType = this.f52465e.getPayPrice().payType;
            if (payType == PayRequest.PayPrice.PayType.BANKCARD) {
                f();
            } else if (payType == PayRequest.PayPrice.PayType.BALANCE) {
                e();
            } else if (payType == PayRequest.PayPrice.PayType.CREIDT) {
                d();
            }
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            i iVar = (i) PayBeanFactory.getInstance().getBean((Context) this.mAct, PayBeanFactory.BEAN_ID_CREDIT_PAY, "CardInfoCheckActivity");
            iVar.setResponseCallback(this.mAct);
            iVar.execBean();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mActionBar.setVisibility(4);
            this.l = true;
            this.f52467g.setVisibility(8);
            this.f52467g.dismissKeyBoard(this.f52464d);
            this.f52469i.setVisibility(0);
            this.f52469i.startAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, charSequence)) == null) ? !TextUtils.isEmpty(charSequence) ? charSequence.toString().replace(" ", "").trim() : "" : (String) invokeL.objValue;
    }
}
