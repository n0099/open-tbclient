package com.baidu.wallet.paysdk.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.passport.LoginBackListenerProxy;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, BdActionBar bdActionBar, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{context, bdActionBar, str, str2, str3, str4}) == null) || bdActionBar == null || TextUtils.isEmpty(str2)) {
            return;
        }
        bdActionBar.setRightImgZone2Visibility(0);
        bdActionBar.setRightImgZone2Enable(true);
        bdActionBar.setRightImgZone2Src(str2);
        bdActionBar.setRightImgZone2OnClickListener(new View.OnClickListener(str4, context, str, str3) { // from class: com.baidu.wallet.paysdk.ui.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f26715a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f26716b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f26717c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f26718d;

            /* renamed from: e  reason: collision with root package name */
            public LoginBackListenerProxy f26719e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str4, context, str, str3};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26715a = str4;
                this.f26716b = context;
                this.f26717c = str;
                this.f26718d = str3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || CheckUtils.isFastDoubleClick()) {
                    return;
                }
                if (!TextUtils.isEmpty(this.f26715a)) {
                    PayStatisticsUtil.onEvent(this.f26715a);
                }
                this.f26719e = new LoginBackListenerProxy(this.f26716b, new ILoginBackListener(this) { // from class: com.baidu.wallet.paysdk.ui.b.1.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass1 f26720a;

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
                        this.f26720a = this;
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onFail(int i2, String str5) {
                        Interceptable interceptable3 = $ic;
                        if ((interceptable3 == null || interceptable3.invokeIL(1048576, this, i2, str5) == null) && i2 == 603) {
                            WalletLoginHelper.getInstance().onlyLogin(this.f26720a.f26719e);
                        }
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onSuccess(int i2, String str5) {
                        Interceptable interceptable3 = $ic;
                        if (!(interceptable3 == null || interceptable3.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str5) == null) || TextUtils.isEmpty(this.f26720a.f26717c)) {
                            return;
                        }
                        BaiduWalletDelegate baiduWalletDelegate = BaiduWalletDelegate.getInstance();
                        AnonymousClass1 anonymousClass1 = this.f26720a;
                        baiduWalletDelegate.openH5Module(anonymousClass1.f26716b, anonymousClass1.f26717c, anonymousClass1.f26718d, true, false);
                    }
                });
                WalletLoginHelper.getInstance().login(this.f26719e);
            }
        });
    }
}
