package com.baidu.wallet.paysdk.ui;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.UserInfoBean;
import com.baidu.wallet.paysdk.datamodel.UserInfoContentResponse;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.dxmpay.apollon.statusbar.StatusBarUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.core.SDKBaseActivity;
import com.dxmpay.wallet.core.beans.BeanActivity;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.PassUtil;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.passport.LoginBackListenerProxy;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class BindCardPreCheckActivity extends PayBaseBeanActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PARAMS_KEY = "PARAMS_KEY";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public UserInfoBean f62538a;

    /* renamed from: b  reason: collision with root package name */
    public UserInfoContentResponse f62539b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62540c;

    /* renamed from: d  reason: collision with root package name */
    public String f62541d;

    /* renamed from: e  reason: collision with root package name */
    public LoginBackListenerProxy f62542e;

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
        this.f62540c = false;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            String str = null;
            try {
                JSONObject jSONObject = new JSONObject(this.f62541d);
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
                public final /* synthetic */ BindCardPreCheckActivity f62546a;

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
                    this.f62546a = this;
                }

                @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                public void onFail(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        this.f62546a.a(2, "");
                    }
                }

                @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                public void onSucceed(String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                        this.f62546a.e();
                    }
                }
            }, str);
            this.f62540c = true;
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
            if (TextUtils.isEmpty(this.f62541d)) {
                str2 = null;
                str3 = null;
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(this.f62541d);
                    str = jSONObject.getString("sp_no");
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
                            public final /* synthetic */ BindCardPreCheckActivity f62547a;

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
                                this.f62547a = this;
                            }

                            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                            public void onChangeFailed(String str5) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, str5) == null) {
                                    this.f62547a.a(2, "");
                                }
                            }

                            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                            public void onChangeSucceed(String str5) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str5) == null) {
                                    this.f62547a.a(0, "");
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
                public final /* synthetic */ BindCardPreCheckActivity f62547a;

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
                    this.f62547a = this;
                }

                @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                public void onChangeFailed(String str5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str5) == null) {
                        this.f62547a.a(2, "");
                    }
                }

                @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                public void onChangeSucceed(String str5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str5) == null) {
                        this.f62547a.a(0, "");
                    }
                }
            }, PayRequestCache.BindCategory.Initiative, 1, str2, str3, null, null, false, null);
        }
    }

    @Override // com.dxmpay.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SDKBaseActivity.BottomBarType.NONE : (SDKBaseActivity.BottomBarType) invokeV.objValue;
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
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
                    public final /* synthetic */ BindCardPreCheckActivity f62544a;

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
                        this.f62544a = this;
                    }

                    @Override // com.dxmpay.wallet.core.utils.PassUtil.PassNormalize, com.dxmpay.wallet.core.utils.PassUtil.IPassNormalize
                    public boolean onNormalize(Context context, int i4, Map<String, String> map) {
                        InterceptResult invokeLIL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, context, i4, map)) == null) {
                            if (super.onNormalize(context, i4, map)) {
                                this.f62544a.b();
                                return false;
                            }
                            this.f62544a.a(2, "");
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
                    public final /* synthetic */ BindCardPreCheckActivity f62545a;

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
                        this.f62545a = this;
                    }

                    @Override // com.baidu.wallet.rnauth.RNAuthCallBack
                    public void onRNAuthResult(int i4, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str2) == null) {
                            if (i4 == 0) {
                                this.f62545a.b();
                            } else {
                                this.f62545a.a(2, "");
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, obj, str) == null) && i2 == 6) {
            WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
            UserInfoContentResponse userInfoContentResponse = (UserInfoContentResponse) obj;
            this.f62539b = userInfoContentResponse;
            userInfoContentResponse.user_info.decrypt();
            this.f62539b.decrypt();
            c();
        }
    }

    @Override // com.dxmpay.wallet.core.SDKBaseActivity
    public boolean isSlidingEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            a();
            if (bundle == null) {
                this.f62541d = getIntent().getStringExtra(PARAMS_KEY);
            } else {
                this.f62541d = bundle.getString(PARAMS_KEY);
            }
            this.f62542e = new LoginBackListenerProxy(getActivity(), new ILoginBackListener(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardPreCheckActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BindCardPreCheckActivity f62543a;

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
                    this.f62543a = this;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        if (i2 == 603) {
                            WalletLoginHelper.getInstance().onlyLogin(this.f62543a.f62542e);
                        } else {
                            this.f62543a.a(2, "");
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        this.f62543a.b();
                    }
                }
            });
            WalletLoginHelper.getInstance().login(this.f62542e);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            if (this.f62538a != null) {
                BeanManager.getInstance().removeBean(this.f62538a);
            }
            if (this.f62540c) {
                PasswordController.getPassWordInstance().clearCheckPwdListener();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString(PARAMS_KEY, this.f62541d);
        }
    }

    public void setImmersiveActivityMargeinTop() {
        BeanActivity beanActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || Build.VERSION.SDK_INT < 19 || (beanActivity = this.mAct) == null) {
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
            if (this.f62538a == null) {
                this.f62538a = (UserInfoBean) PayBeanFactory.getInstance().getBean((Context) this.mAct, 6, "BindCardPreCheckActivity");
            }
            this.f62538a.setResponseCallback(this);
            this.f62538a.execBean();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if ("1".equals(this.f62539b.card_ext_info.can_bind_card_flag)) {
                if (this.f62539b.user_info.has_mobile_password == 1) {
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
            setContentView(ResUtils.layout(getActivity(), "dxm_wallet_base_layout_loading"));
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
