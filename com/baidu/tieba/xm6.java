package com.baidu.tieba;

import android.content.res.Configuration;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.splashad.SplashAdView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class xm6 {
    public static /* synthetic */ Interceptable $ic;
    public static xm6 b;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<SplashAdView> a;

    public xm6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static xm6 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                b = new xm6();
            }
            return b;
        }
        return (xm6) invokeV.objValue;
    }

    public void c() {
        WeakReference<SplashAdView> weakReference;
        SplashAdView splashAdView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (weakReference = this.a) != null && (splashAdView = weakReference.get()) != null) {
            splashAdView.a();
        }
    }

    public void d() {
        WeakReference<SplashAdView> weakReference;
        SplashAdView splashAdView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (weakReference = this.a) != null && (splashAdView = weakReference.get()) != null) {
            splashAdView.b();
        }
    }

    public void b(Configuration configuration) {
        WeakReference<SplashAdView> weakReference;
        SplashAdView splashAdView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, configuration) == null) && (weakReference = this.a) != null && (splashAdView = weakReference.get()) != null) {
            splashAdView.onConfigurationChanged(configuration);
        }
    }

    public void e(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, baseFragmentActivity) == null) && baseFragmentActivity != null) {
            try {
                SplashAdView splashAdView = new SplashAdView(baseFragmentActivity, 1);
                this.a = new WeakReference<>(splashAdView);
                ViewGroup viewGroup = (ViewGroup) baseFragmentActivity.findViewById(R.id.layout_root);
                if (viewGroup != null) {
                    viewGroup.addView(splashAdView);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
