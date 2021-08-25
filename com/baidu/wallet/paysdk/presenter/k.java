package com.baidu.wallet.paysdk.presenter;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletApiExtListener;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.core.utils.PassUtil;
import com.dxmpay.wallet.passport.LoginBackListenerProxy;
import com.dxmpay.wallet.passport.ThirdPartyLoginUtil;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes8.dex */
public abstract class k implements IBeanResponseCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f62505a;

    /* renamed from: b  reason: collision with root package name */
    public PayBaseBeanActivity f62506b;

    /* renamed from: c  reason: collision with root package name */
    public LoginBackListenerProxy f62507c;

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
        this.f62506b = payBaseBeanActivity;
    }

    private Handler f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (this.f62505a == null) {
                this.f62505a = new Handler(this.f62506b.getMainLooper());
            }
            return this.f62505a;
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

    @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i2, i3, str) == null) {
            f().post(new Runnable(this, i2, i3, str) { // from class: com.baidu.wallet.paysdk.presenter.k.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f62512a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f62513b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f62514c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ k f62515d;

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
                    this.f62515d = this;
                    this.f62512a = i2;
                    this.f62513b = i3;
                    this.f62514c = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f62515d.a(this.f62512a, this.f62513b, this.f62514c);
                    }
                }
            });
        }
    }

    @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048590, this, i2, obj, str) == null) {
            f().post(new Runnable(this, i2, obj, str) { // from class: com.baidu.wallet.paysdk.presenter.k.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f62508a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Object f62509b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f62510c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ k f62511d;

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
                    this.f62511d = this;
                    this.f62508a = i2;
                    this.f62509b = obj;
                    this.f62510c = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f62511d.a(this.f62508a, this.f62509b, this.f62510c);
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
                    AccountManager.getInstance(this.f62506b).logout();
                    WalletLoginHelper.getInstance().logout(false);
                    StatisticManager.onEventWithValue(PayStatServiceEvent.NOT_LOGIN, StatHelper.getOrderNo());
                    ArrayList arrayList = new ArrayList();
                    if (WalletLoginHelper.getInstance().isInnerPassLogin()) {
                        GlobalUtils.toast(this.f62506b, str);
                        this.f62507c = new LoginBackListenerProxy(this.f62506b, new ILoginBackListener(this, arrayList) { // from class: com.baidu.wallet.paysdk.presenter.k.4
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ ArrayList f62517a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ k f62518b;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, arrayList};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f62518b = this;
                                this.f62517a = arrayList;
                            }

                            @Override // com.baidu.wallet.api.ILoginBackListener
                            public void onFail(int i4, String str2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str2) == null) {
                                    this.f62517a.add(StatHelper.getOrderNo());
                                    ArrayList arrayList2 = this.f62517a;
                                    arrayList2.add(i4 + "");
                                    StatisticManager.onEventWithValues(PayStatServiceEvent.LOGIN_RESULT, this.f62517a);
                                    if (i4 == 603) {
                                        WalletLoginHelper.getInstance().onlyLogin(this.f62518b.f62507c);
                                    }
                                }
                            }

                            @Override // com.baidu.wallet.api.ILoginBackListener
                            public void onSuccess(int i4, String str2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, str2) == null) {
                                    this.f62517a.add(StatHelper.getOrderNo());
                                    this.f62517a.add("0");
                                    StatisticManager.onEventWithValues(PayStatServiceEvent.LOGIN_RESULT, this.f62517a);
                                    this.f62518b.c();
                                }
                            }
                        });
                        WalletLoginHelper.getInstance().login(this.f62507c);
                        return;
                    }
                    WalletLoginHelper.getInstance().handlerWalletError(5003);
                } else if (ThirdPartyLoginUtil.getInstance().checkThirdPartyLogin(this.f62506b.getActivity(), i3, str, new WalletApiExtListener.ThirdPartyLoginListener(this) { // from class: com.baidu.wallet.paysdk.presenter.k.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ k f62519a;

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
                        this.f62519a = this;
                    }

                    @Override // com.baidu.wallet.api.WalletApiExtListener.ThirdPartyLoginListener
                    public void onCallFail(int i4, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str2) == null) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(StatHelper.getOrderNo());
                            arrayList2.add(i4 + "");
                            StatisticManager.onEventWithValues(PayStatServiceEvent.THIRD_PARTY_LOGIN_RESULT, arrayList2);
                            PayCallBackManager.callBackClientCancel(this.f62519a.f62506b.getActivity(), "WelcomeBaseActivity.onPrepareDialog().1");
                            this.f62519a.f62506b.finish();
                        }
                    }

                    @Override // com.baidu.wallet.api.WalletApiExtListener.ThirdPartyLoginListener
                    public void onCallSuccess(int i4, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, str2) == null) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(StatHelper.getOrderNo());
                            arrayList2.add("0");
                            StatisticManager.onEventWithValues(PayStatServiceEvent.THIRD_PARTY_LOGIN_RESULT, arrayList2);
                            this.f62519a.c();
                        }
                    }
                })) {
                    StatisticManager.onEventWithValue(PayStatServiceEvent.THIRD_PARTY_LOGIN, StatHelper.getOrderNo());
                    return;
                }
                GlobalUtils.toast(this.f62506b, str);
                e();
                return;
            }
            int i4 = i3 == 100036 ? 2 : 1;
            StatisticManager.onEventWithValue(PayStatServiceEvent.THIRD_HALF_USER, StatHelper.getOrderNo());
            PassUtil.passNormalized(this.f62506b, str, i4, new PassUtil.PassNormalize(this) { // from class: com.baidu.wallet.paysdk.presenter.k.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ k f62516a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i5 = newInitContext.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62516a = this;
                }

                @Override // com.dxmpay.wallet.core.utils.PassUtil.PassNormalize, com.dxmpay.wallet.core.utils.PassUtil.IPassNormalize
                public boolean onNormalize(Context context, int i5, Map<String, String> map) {
                    InterceptResult invokeLIL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, context, i5, map)) == null) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(StatHelper.getOrderNo());
                        if (map != null) {
                            arrayList2.add(map.get("pass_error_code"));
                        } else {
                            arrayList2.add("-1");
                        }
                        StatisticManager.onEventWithValues(PayStatServiceEvent.THIRD_HALF_USER_RESULT, arrayList2);
                        if (super.onNormalize(context, i5, map)) {
                            this.f62516a.c();
                            return false;
                        }
                        this.f62516a.e();
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
