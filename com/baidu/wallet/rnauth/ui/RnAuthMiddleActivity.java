package com.baidu.wallet.rnauth.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.base.widget.WalletBaseEmptyView;
import com.baidu.wallet.core.BaseActionBarActivity;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.baidu.wallet.rnauth.bean.GetRnAuthQueryBean;
import com.baidu.wallet.rnauth.datamodel.RnAuthQueryBeanResponse;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class RnAuthMiddleActivity extends BaseActionBarActivity {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static RNAuthCallBack f27198f;
    public transient /* synthetic */ FieldHolder $fh;
    public final int AUTH_STATE_PROCESS;
    public final int AUTH_STATE_UNAUTH;
    public final int AUTH_STATE_UPDATE;

    /* renamed from: a  reason: collision with root package name */
    public TextView f27199a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f27200b;

    /* renamed from: c  reason: collision with root package name */
    public final String f27201c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f27202d;

    /* renamed from: e  reason: collision with root package name */
    public int f27203e;

    public RnAuthMiddleActivity() {
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
        this.f27201c = RnAuthMiddleActivity.class.getSimpleName();
        this.AUTH_STATE_PROCESS = 1;
        this.AUTH_STATE_UNAUTH = 2;
        this.AUTH_STATE_UPDATE = 3;
        this.f27203e = 0;
    }

    public static void clearRnAuthCallBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            f27198f = null;
        }
    }

    public static Intent getStartIntent(Context context, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, hashMap)) == null) {
            Intent intent = new Intent(context, RnAuthMiddleActivity.class);
            intent.putExtra("params", hashMap);
            intent.putExtra("with_anim", false);
            return intent;
        }
        return (Intent) invokeLL.objValue;
    }

    public static void setRnAuthCallBack(RNAuthCallBack rNAuthCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, rNAuthCallBack) == null) {
            f27198f = rNAuthCallBack;
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
            closeLoadingDialog();
            if (i3 < 0) {
                getErrorViewDelegate().showLocalNetError(new WalletBaseEmptyView.EmptyBtnClickListener(this) { // from class: com.baidu.wallet.rnauth.ui.RnAuthMiddleActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ RnAuthMiddleActivity f27206a;

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
                        this.f27206a = this;
                    }

                    @Override // com.baidu.wallet.base.widget.WalletBaseEmptyView.EmptyBtnClickListener
                    public void onBtnClick() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f27206a.b();
                        }
                    }
                });
                return;
            }
            getErrorViewDelegate().showServerNetError(str, new WalletBaseEmptyView.EmptyBtnClickListener(this) { // from class: com.baidu.wallet.rnauth.ui.RnAuthMiddleActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ RnAuthMiddleActivity f27207a;

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
                    this.f27207a = this;
                }

                @Override // com.baidu.wallet.base.widget.WalletBaseEmptyView.EmptyBtnClickListener
                public void onBtnClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f27207a.b();
                    }
                }
            });
            super.handleFailure(i2, i3, str);
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
            closeLoadingDialog();
            getErrorViewDelegate().showContentView();
            if (i2 == 48) {
                RnAuthQueryBeanResponse rnAuthQueryBeanResponse = (RnAuthQueryBeanResponse) obj;
                this.f27200b.setText(rnAuthQueryBeanResponse.button_msg);
                this.f27199a.setText(rnAuthQueryBeanResponse.display_msg);
            }
        }
    }

    @Override // com.baidu.wallet.core.BaseActionBarActivity
    public void init(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            TextView textView = (TextView) findViewByIdExt(ResUtils.id(getApplicationContext(), "wallet_rn_auth_text_des"));
            this.f27199a = textView;
            textView.setText("");
            TextView textView2 = (TextView) findViewByIdExt(ResUtils.id(getApplicationContext(), "wallet_rn_auth_text_action"));
            this.f27200b = textView2;
            textView2.setText("");
            c();
            getBdActionBar().setTitle(ResUtils.string(getApplicationContext(), "bd_wallet_pay_security_auth"));
            this.f27202d = (HashMap) getIntent().getSerializableExtra("params");
            b();
            EventBus.getInstance().register(this, BeanConstants.EV_EXIT_MIDDLE_AUTH_PAGE, 0, EventBus.ThreadMode.MainThread);
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onBackPressed();
            RNAuthCallBack rNAuthCallBack = f27198f;
            if (rNAuthCallBack != null) {
                rNAuthCallBack.onRNAuthResult(2, "实名认证取消");
                f27198f = null;
            }
        }
    }

    @Override // com.baidu.wallet.core.BaseActionBarActivity
    public int onBindLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ResUtils.layout(getApplicationContext(), "wallet_rn_auth_mid_activity") : invokeV.intValue;
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            LogUtil.e(this.f27201c, MissionEvent.MESSAGE_DESTROY, null);
            BeanManager.getInstance().removeAllBeans(this.f27201c);
            EventBus.getInstance().unregister(this);
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, event) == null) && event != null && TextUtils.equals(event.mEventKey, BeanConstants.EV_EXIT_MIDDLE_AUTH_PAGE)) {
            finishWithoutAnim();
            LogUtil.e(this.f27201c, "onModuleEvent finishWithoutAnim", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            showLoadingDialog();
            GetRnAuthQueryBean getRnAuthQueryBean = (GetRnAuthQueryBean) PayBeanFactory.getInstance().getBean((Context) this, 48, this.f27201c);
            getRnAuthQueryBean.setResponseCallback(this);
            getRnAuthQueryBean.setParams(1);
            getRnAuthQueryBean.execBean();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.f27200b.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.rnauth.ui.RnAuthMiddleActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ RnAuthMiddleActivity f27204a;

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
                    this.f27204a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        BaiduPayDelegate.getInstance().doRNAuth(this.f27204a.getActivity(), this.f27204a.f27202d, new RNAuthCallBack(this) { // from class: com.baidu.wallet.rnauth.ui.RnAuthMiddleActivity.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f27205a;

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
                                this.f27205a = this;
                            }

                            @Override // com.baidu.wallet.rnauth.RNAuthCallBack
                            public void onRNAuthResult(int i2, String str) {
                                Interceptable interceptable3 = $ic;
                                if (!(interceptable3 == null || interceptable3.invokeIL(1048576, this, i2, str) == null) || RnAuthMiddleActivity.f27198f == null) {
                                    return;
                                }
                                RnAuthMiddleActivity.f27198f.onRNAuthResult(i2, str);
                                RNAuthCallBack unused = RnAuthMiddleActivity.f27198f = null;
                                this.f27205a.f27204a.finishWithoutAnim();
                                LogUtil.e(this.f27205a.f27204a.f27201c, "onRNAuthResult finishWithoutAnim", null);
                            }
                        });
                    }
                }
            });
        }
    }
}
