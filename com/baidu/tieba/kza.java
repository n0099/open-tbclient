package com.baidu.tieba;

import android.content.res.Configuration;
import android.view.ViewGroup;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.splashad.SplashAdView;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class kza {
    public static /* synthetic */ Interceptable $ic;
    public static kza b;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<SplashAdView> a;

    public kza() {
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

    public static kza a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                b = new kza();
            }
            return b;
        }
        return (kza) invokeV.objValue;
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

    public void e(MainTabActivity mainTabActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mainTabActivity) == null) {
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i("SplashAdViewController", "开屏广告：showSplash, activity is: " + mainTabActivity);
            if (mainTabActivity != null) {
                SplashAdView splashAdView = new SplashAdView(mainTabActivity, 2);
                this.a = new WeakReference<>(splashAdView);
                mainTabActivity.getWindow().setFlags(1024, 1024);
                ViewGroup viewGroup = (ViewGroup) mainTabActivity.findViewById(R.id.obfuscated_res_0x7f09235a);
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                    viewGroup.addView(splashAdView);
                }
            }
        }
    }
}
