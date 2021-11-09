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
/* loaded from: classes10.dex */
public abstract class k implements IBeanResponseCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f59884a;

    /* renamed from: b  reason: collision with root package name */
    public PayBaseBeanActivity f59885b;

    /* renamed from: c  reason: collision with root package name */
    public LoginBackListenerProxy f59886c;

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
        this.f59885b = payBaseBeanActivity;
    }

    private Handler f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (this.f59884a == null) {
                this.f59884a = new Handler(this.f59885b.getMainLooper());
            }
            return this.f59884a;
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

    public abstract void d();

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

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
                public final /* synthetic */ int f59891a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f59892b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f59893c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ k f59894d;

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
                    this.f59894d = this;
                    this.f59891a = i2;
                    this.f59892b = i3;
                    this.f59893c = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f59894d.a(this.f59891a, this.f59892b, this.f59893c);
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
                public final /* synthetic */ int f59887a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Object f59888b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f59889c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ k f59890d;

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
                    this.f59890d = this;
                    this.f59887a = i2;
                    this.f59888b = obj;
                    this.f59889c = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f59890d.a(this.f59887a, this.f59888b, this.f59889c);
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
                    AccountManager.getInstance(this.f59885b).logout();
                    WalletLoginHelper.getInstance().logout(false);
                    StatisticManager.onEventWithValue(PayStatServiceEvent.NOT_LOGIN, StatHelper.getOrderNo());
                    ArrayList arrayList = new ArrayList();
                    if (WalletLoginHelper.getInstance().isInnerPassLogin()) {
                        GlobalUtils.toast(this.f59885b, str);
                        this.f59886c = new LoginBackListenerProxy(this.f59885b, new ILoginBackListener(this, arrayList) { // from class: com.baidu.wallet.paysdk.presenter.k.4
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ ArrayList f59896a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ k f59897b;

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
                                this.f59897b = this;
                                this.f59896a = arrayList;
                            }

                            @Override // com.baidu.wallet.api.ILoginBackListener
                            public void onFail(int i4, String str2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str2) == null) {
                                    this.f59896a.add(StatHelper.getOrderNo());
                                    ArrayList arrayList2 = this.f59896a;
                                    arrayList2.add(i4 + "");
                                    StatisticManager.onEventWithValues(PayStatServiceEvent.LOGIN_RESULT, this.f59896a);
                                    if (i4 == 603) {
                                        WalletLoginHelper.getInstance().onlyLogin(this.f59897b.f59886c);
                                    }
                                }
                            }

                            @Override // com.baidu.wallet.api.ILoginBackListener
                            public void onSuccess(int i4, String str2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, str2) == null) {
                                    this.f59896a.add(StatHelper.getOrderNo());
                                    this.f59896a.add("0");
                                    StatisticManager.onEventWithValues(PayStatServiceEvent.LOGIN_RESULT, this.f59896a);
                                    this.f59897b.b();
                                }
                            }
                        });
                        WalletLoginHelper.getInstance().login(this.f59886c);
                        return;
                    }
                    WalletLoginHelper.getInstance().handlerWalletError(5003);
                } else if (ThirdPartyLoginUtil.getInstance().checkThirdPartyLogin(this.f59885b.getActivity(), i3, str, new WalletApiExtListener.ThirdPartyLoginListener(this) { // from class: com.baidu.wallet.paysdk.presenter.k.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ k f59898a;

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
                        this.f59898a = this;
                    }

                    @Override // com.baidu.wallet.api.WalletApiExtListener.ThirdPartyLoginListener
                    public void onCallFail(int i4, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str2) == null) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(StatHelper.getOrderNo());
                            arrayList2.add(i4 + "");
                            StatisticManager.onEventWithValues(PayStatServiceEvent.THIRD_PARTY_LOGIN_RESULT, arrayList2);
                            PayCallBackManager.callBackClientCancel(this.f59898a.f59885b.getActivity(), "WelcomeBaseActivity.onPrepareDialog().1");
                            this.f59898a.f59885b.finish();
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
                            this.f59898a.b();
                        }
                    }
                })) {
                    StatisticManager.onEventWithValue(PayStatServiceEvent.THIRD_PARTY_LOGIN, StatHelper.getOrderNo());
                    return;
                }
                GlobalUtils.toast(this.f59885b, str);
                c();
                return;
            }
            int i4 = i3 == 100036 ? 2 : 1;
            StatisticManager.onEventWithValue(PayStatServiceEvent.THIRD_HALF_USER, StatHelper.getOrderNo());
            PassUtil.passNormalized(this.f59885b, str, i4, new PassUtil.PassNormalize(this) { // from class: com.baidu.wallet.paysdk.presenter.k.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ k f59895a;

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
                    this.f59895a = this;
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
                            this.f59895a.b();
                            return false;
                        }
                        this.f59895a.c();
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
