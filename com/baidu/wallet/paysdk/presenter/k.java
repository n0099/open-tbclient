package com.baidu.wallet.paysdk.presenter;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletApiExtListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.core.utils.PassUtil;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.passport.ThirdPartyLoginUtil;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import java.util.Map;
/* loaded from: classes5.dex */
public abstract class k implements IBeanResponseCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f26405a;

    /* renamed from: b  reason: collision with root package name */
    public PayBaseBeanActivity f26406b;

    /* renamed from: c  reason: collision with root package name */
    public LoginBackListenerProxy f26407c;

    public k(PayBaseBeanActivity payBaseBeanActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {payBaseBeanActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26406b = payBaseBeanActivity;
    }

    private Handler f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (this.f26405a == null) {
                this.f26405a = new Handler(this.f26406b.getMainLooper());
            }
            return this.f26405a;
        }
        return (Handler) invokeV.objValue;
    }

    public abstract void a();

    public abstract void a(int i2, Dialog dialog);

    public abstract void a(int i2, Object obj, String str);

    public abstract void a(PrecashierCreateOrderResponse precashierCreateOrderResponse);

    public abstract void a(String str);

    public abstract boolean a(Bundle bundle);

    public abstract void b();

    public abstract void c();

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public abstract void e();

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i2, i3, str) == null) {
            f().post(new Runnable(this, i2, i3, str) { // from class: com.baidu.wallet.paysdk.presenter.k.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f26412a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f26413b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f26414c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ k f26415d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), Integer.valueOf(i3), str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f26415d = this;
                    this.f26412a = i2;
                    this.f26413b = i3;
                    this.f26414c = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f26415d.a(this.f26412a, this.f26413b, this.f26414c);
                    }
                }
            });
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048590, this, i2, obj, str) == null) {
            f().post(new Runnable(this, i2, obj, str) { // from class: com.baidu.wallet.paysdk.presenter.k.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f26408a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Object f26409b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f26410c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ k f26411d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), obj, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f26411d = this;
                    this.f26408a = i2;
                    this.f26409b = obj;
                    this.f26410c = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f26411d.a(this.f26408a, this.f26409b, this.f26410c);
                    }
                }
            });
        }
    }

    public void a(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
            if (i3 != 100035 && i3 != 100036) {
                if (i3 == 5003) {
                    AccountManager.getInstance(this.f26406b).logout();
                    WalletLoginHelper.getInstance().logout(false);
                    if (WalletLoginHelper.getInstance().isInnerPassLogin()) {
                        GlobalUtils.toast(this.f26406b, str);
                        this.f26407c = new LoginBackListenerProxy(this.f26406b, new ILoginBackListener(this) { // from class: com.baidu.wallet.paysdk.presenter.k.4
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ k f26417a;

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
                                this.f26417a = this;
                            }

                            @Override // com.baidu.wallet.api.ILoginBackListener
                            public void onFail(int i4, String str2) {
                                Interceptable interceptable2 = $ic;
                                if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str2) == null) && i4 == 603) {
                                    WalletLoginHelper.getInstance().onlyLogin(this.f26417a.f26407c);
                                }
                            }

                            @Override // com.baidu.wallet.api.ILoginBackListener
                            public void onSuccess(int i4, String str2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, str2) == null) {
                                    this.f26417a.c();
                                }
                            }
                        });
                        WalletLoginHelper.getInstance().login(this.f26407c);
                        return;
                    }
                    WalletLoginHelper.getInstance().handlerWalletError(5003);
                } else if (ThirdPartyLoginUtil.getInstance().checkThirdPartyLogin(this.f26406b.getActivity(), i3, str, new WalletApiExtListener.ThirdPartyLoginListener(this) { // from class: com.baidu.wallet.paysdk.presenter.k.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ k f26418a;

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
                        this.f26418a = this;
                    }

                    @Override // com.baidu.wallet.api.WalletApiExtListener.ThirdPartyLoginListener
                    public void onCallFail(int i4, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str2) == null) {
                            PayCallBackManager.callBackClientCancel(this.f26418a.f26406b.getActivity(), "WelcomeBaseActivity.onPrepareDialog().1");
                            this.f26418a.f26406b.finish();
                        }
                    }

                    @Override // com.baidu.wallet.api.WalletApiExtListener.ThirdPartyLoginListener
                    public void onCallSuccess(int i4, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, str2) == null) {
                            this.f26418a.c();
                        }
                    }
                })) {
                    return;
                }
                GlobalUtils.toast(this.f26406b, str);
                e();
                return;
            }
            PassUtil.passNormalized(this.f26406b, str, i3 == 100036 ? 2 : 1, new PassUtil.PassNormalize(this) { // from class: com.baidu.wallet.paysdk.presenter.k.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ k f26416a;

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
                    this.f26416a = this;
                }

                @Override // com.baidu.wallet.core.utils.PassUtil.PassNormalize, com.baidu.wallet.core.utils.PassUtil.IPassNormalize
                public boolean onNormalize(Context context, int i4, Map<String, String> map) {
                    InterceptResult invokeLIL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, context, i4, map)) == null) {
                        if (super.onNormalize(context, i4, map)) {
                            this.f26416a.c();
                            return false;
                        }
                        this.f26416a.e();
                        return false;
                    }
                    return invokeLIL.booleanValue;
                }
            });
        }
    }

    public void a(int i2, int i3, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, obj}) == null) {
            a(i2, i3, str);
        }
    }
}
