package com.baidu.tieba;

import android.os.Build;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.browser.core.webview.flyweight.FlyweightWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class k56 extends j56<FlyweightWebView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k56(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.j56
    /* renamed from: d */
    public synchronized FlyweightWebView a() {
        InterceptResult invokeV;
        FlyweightWebView flyweightWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                flyweightWebView = (FlyweightWebView) super.a();
                if (flyweightWebView != null) {
                    flyweightWebView.f();
                }
            }
            return flyweightWebView;
        }
        return (FlyweightWebView) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.j56
    /* renamed from: e */
    public synchronized boolean c(@NonNull FlyweightWebView flyweightWebView) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, flyweightWebView)) == null) {
            synchronized (this) {
                c = super.c(flyweightWebView);
                if (c) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        flyweightWebView.setRendererPriorityPolicy(2, false);
                    }
                    flyweightWebView.e();
                } else {
                    flyweightWebView.destroy();
                }
            }
            return c;
        }
        return invokeL.booleanValue;
    }
}
