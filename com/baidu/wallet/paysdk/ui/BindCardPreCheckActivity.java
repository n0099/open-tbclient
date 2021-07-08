package com.baidu.wallet.paysdk.ui;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.statusbar.StatusBarUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.PassUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.UserInfoBean;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class BindCardPreCheckActivity extends PayBaseBeanActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PARAMS_KEY = "PARAMS_KEY";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public UserInfoBean f26478a;

    /* renamed from: b  reason: collision with root package name */
    public DirectPayContentResponse f26479b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26480c;

    /* renamed from: d  reason: collision with root package name */
    public String f26481d;

    /* renamed from: e  reason: collision with root package name */
    public LoginBackListenerProxy f26482e;

    public BindCardPreCheckActivity() {
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
        this.f26480c = false;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            String str = null;
            try {
                JSONObject jSONObject = new JSONObject(this.f26481d);
                if (jSONObject.optString(TableDefine.MessageColumns.COLUME_SERVICE_TYPE) != null) {
                    str = jSONObject.optString(TableDefine.MessageColumns.COLUME_SERVICE_TYPE);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            PasswordController.getPassWordInstance().checkPwd(this.mAct, BeanConstants.FROM_BIND, new PasswordController.IPwdListener(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardPreCheckActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BindCardPreCheckActivity f26486a;

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
                    this.f26486a = this;
                }

                @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                public void onFail(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        this.f26486a.a(2, "");
                    }
                }

                @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                public void onSucceed(String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                        this.f26486a.e();
                    }
                }
            }, str);
            this.f26480c = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            String str4 = null;
            if (TextUtils.isEmpty(this.f26481d)) {
                str2 = null;
                str3 = null;
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(this.f26481d);
                    str = jSONObject.getString(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID);
                    try {
                        str4 = jSONObject.getString(TableDefine.MessageColumns.COLUME_SERVICE_TYPE);
                    } catch (JSONException e2) {
                        e = e2;
                        e.printStackTrace();
                        str2 = str4;
                        str3 = str;
                        BaiduPay.getInstance().bindCard(this.mAct, new BaiduPay.IBindCardCallback(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardPreCheckActivity.5
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ BindCardPreCheckActivity f26487a;

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
                                this.f26487a = this;
                            }

                            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                            public void onChangeFailed(String str5) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, str5) == null) {
                                    this.f26487a.a(2, "");
                                }
                            }

                            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                            public void onChangeSucceed(String str5) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str5) == null) {
                                    this.f26487a.a(0, "");
                                }
                            }
                        }, PayRequestCache.BindCategory.Initiative, 1, str2, str3, null, null, false, null);
                    }
                } catch (JSONException e3) {
                    e = e3;
                    str = null;
                }
                str2 = str4;
                str3 = str;
            }
            BaiduPay.getInstance().bindCard(this.mAct, new BaiduPay.IBindCardCallback(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardPreCheckActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BindCardPreCheckActivity f26487a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = objArr;
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
                    this.f26487a = this;
                }

                @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                public void onChangeFailed(String str5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str5) == null) {
                        this.f26487a.a(2, "");
                    }
                }

                @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                public void onChangeSucceed(String str5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str5) == null) {
                        this.f26487a.a(0, "");
                    }
                }
            }, PayRequestCache.BindCategory.Initiative, 1, str2, str3, null, null, false, null);
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
            if (i2 != 6) {
                super.handleFailure(i2, i3, str);
                a(2, "");
            } else if (i3 == 5003) {
                WalletLoginHelper.getInstance().handlerWalletError(5003);
                AccountManager.getInstance(this.mAct.getApplicationContext()).logout();
                WalletLoginHelper.getInstance().logout(false);
                GlobalUtils.toast(this.mAct, str);
                a(2, "");
            } else if (i3 == 100035 || i3 == 100036) {
                PassUtil.passNormalized(getActivity(), str, i3 != 100036 ? 1 : 2, new PassUtil.PassNormalize(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardPreCheckActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ BindCardPreCheckActivity f26484a;

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
                        this.f26484a = this;
                    }

                    @Override // com.baidu.wallet.core.utils.PassUtil.PassNormalize, com.baidu.wallet.core.utils.PassUtil.IPassNormalize
                    public boolean onNormalize(Context context, int i4, Map<String, String> map) {
                        InterceptResult invokeLIL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, context, i4, map)) == null) {
                            if (super.onNormalize(context, i4, map)) {
                                this.f26484a.b();
                                return false;
                            }
                            this.f26484a.a(2, "");
                            return false;
                        }
                        return invokeLIL.booleanValue;
                    }
                });
            } else if (i3 != 5140 && i3 != 5139) {
                a(2, "");
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("sdk_from", "4");
                hashMap.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, i3 == 5140 ? "9" : "0");
                BaiduPayDelegate.getInstance().doRNAuth(this.mAct, hashMap, new RNAuthCallBack(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardPreCheckActivity.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ BindCardPreCheckActivity f26485a;

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
                        this.f26485a = this;
                    }

                    @Override // com.baidu.wallet.rnauth.RNAuthCallBack
                    public void onRNAuthResult(int i4, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str2) == null) {
                            if (i4 == 0) {
                                this.f26485a.b();
                            } else {
                                this.f26485a.a(2, "");
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) && i2 == 6) {
            WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
            DirectPayContentResponse directPayContentResponse = (DirectPayContentResponse) obj;
            this.f26479b = directPayContentResponse;
            directPayContentResponse.user.decrypt();
            this.f26479b.pay.easypay.decrypt();
            this.f26479b.storeResponse(this.mAct);
            c();
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            a();
            if (bundle == null) {
                this.f26481d = getIntent().getStringExtra(PARAMS_KEY);
            } else {
                this.f26481d = bundle.getString(PARAMS_KEY);
            }
            this.f26482e = new LoginBackListenerProxy(getActivity(), new ILoginBackListener(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardPreCheckActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BindCardPreCheckActivity f26483a;

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
                    this.f26483a = this;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        if (i2 == 603) {
                            WalletLoginHelper.getInstance().onlyLogin(this.f26483a.f26482e);
                        } else {
                            this.f26483a.a(2, "");
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        this.f26483a.b();
                    }
                }
            });
            WalletLoginHelper.getInstance().login(this.f26482e);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            if (this.f26478a != null) {
                BeanManager.getInstance().removeBean(this.f26478a);
            }
            if (this.f26480c) {
                PasswordController.getPassWordInstance().clearCheckPwdListener();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString(PARAMS_KEY, this.f26481d);
        }
    }

    public void setImmersiveActivityMargeinTop() {
        BeanActivity beanActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || Build.VERSION.SDK_INT < 19 || (beanActivity = this.mAct) == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(ResUtils.id(beanActivity, "welcome_page"));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.setMargins(0, StatusBarUtils.getStatusBarHeight(this.mAct), 0, 0);
        linearLayout.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            if (this.f26478a == null) {
                this.f26478a = (UserInfoBean) PayBeanFactory.getInstance().getBean((Context) this.mAct, 6, "BindCardPreCheckActivity");
            }
            this.f26478a.setResponseCallback(this);
            this.f26478a.setCheckPrePassSign(1, "4");
            this.f26478a.execBean();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if ("1".equals(this.f26479b.can_bind_card_flag)) {
                if (this.f26479b.user.has_mobile_password == 1) {
                    d();
                    return;
                } else {
                    e();
                    return;
                }
            }
            BeanActivity beanActivity = this.mAct;
            GlobalUtils.toast(beanActivity, ResUtils.getString(beanActivity, "bd_wallet_bind_card_number_overrun"));
            a(2, "");
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            setContentView(ResUtils.layout(getActivity(), "wallet_base_layout_loading"));
            AnimationDrawable animationDrawable = (AnimationDrawable) ((ImageView) findViewById(ResUtils.id(getActivity(), "img_anim"))).getDrawable();
            animationDrawable.stop();
            animationDrawable.start();
            setImmersiveActivityMargeinTop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, this, i2, str) == null) {
            finishWithoutAnim();
            if (BaiduPay.getInstance().getBindCallbackExt() != null) {
                BaiduPay.getInstance().getBindCallbackExt().onBindResult(i2, str);
                BaiduPay.getInstance().clearBindCallbackExt();
            }
        }
    }
}
