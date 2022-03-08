package com.baidu.wallet.passport;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.NoProguard;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class LoginBackListenerProxy implements ILoginBackListener, NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ILoginBackListener loginBackListener;
    public WeakReference<Context> mContext;

    public LoginBackListenerProxy(Context context, ILoginBackListener iLoginBackListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, iLoginBackListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = new WeakReference<>(context);
        this.loginBackListener = iLoginBackListener;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WeakReference<Context> weakReference = this.mContext;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }
        return (Context) invokeV.objValue;
    }

    public ILoginBackListener getLoginBackListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.loginBackListener : (ILoginBackListener) invokeV.objValue;
    }

    @Override // com.baidu.wallet.api.ILoginBackListener
    public void onFail(int i2, String str) {
        ILoginBackListener iLoginBackListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) || (iLoginBackListener = this.loginBackListener) == null) {
            return;
        }
        iLoginBackListener.onFail(i2, str);
    }

    @Override // com.baidu.wallet.api.ILoginBackListener
    public void onSuccess(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) || this.loginBackListener == null) {
            return;
        }
        WalletLoginHelper.getInstance().getOpenBduss(true, this, 6);
    }
}
