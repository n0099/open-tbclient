package com.baidu.wallet.paysdk.presenter;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.ui.AuthorizeSignActivity;
import com.baidu.wallet.paysdk.ui.widget.AuthorizeInfoView;
/* loaded from: classes13.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(AuthorizeSignActivity authorizeSignActivity) {
        super(authorizeSignActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {authorizeSignActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((AuthorizeSignActivity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52095b = 3;
    }

    @Override // com.baidu.wallet.paysdk.presenter.a, com.baidu.wallet.paysdk.presenter.e
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            super.a(z);
            if (z) {
                this.f52095b = 3;
            } else {
                this.f52095b = 4;
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.a, com.baidu.wallet.paysdk.presenter.e
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            AuthorizeSignActivity authorizeSignActivity = this.a;
            if (authorizeSignActivity == null) {
                return;
            }
            AuthorizeInfoView.b authInfoViewAdapter = authorizeSignActivity.getAuthInfoViewAdapter(1);
            DirectPayContentResponse payResponse = this.a.getPayResponse();
            if (payResponse != null) {
                authInfoViewAdapter.a(payResponse.authorize);
                authInfoViewAdapter.a(payResponse.user);
                Authorize authorize = payResponse.authorize;
                if (authorize != null) {
                    this.a.initActionBarByString(authorize.top_title);
                }
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.a, com.baidu.wallet.paysdk.presenter.e
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.presenter.a, com.baidu.wallet.paysdk.presenter.e
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
