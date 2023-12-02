package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes8.dex */
public class rn2 implements ZeusPluginFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "inline_video" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                vo2 b = rp2.D().b(null, null);
                b.m0();
                b.T();
                b.C();
                cx1.e().t(b);
                k32.i("【InlineFactory】", "pre-create video cost time ：" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public rn2(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65537, null) != null) || rp2.D() == null) {
            return;
        }
        cx1.e().c();
        ej3.k(new a(), "PreCreateVideo");
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        InterceptResult invokeL;
        vo2 b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, invoker)) == null) {
            if (rp2.D() == null) {
                return null;
            }
            if (cx1.e().f()) {
                k32.i("【InlineFactory】", "handleAppOnLaunch use cache inline video. ");
                b = cx1.e().d();
                cx1.e().s();
                b.N(invoker);
            } else {
                k32.i("【InlineFactory】", "handleAppOnLaunch create cache inline video. ");
                b = rp2.D().b(invoker, this.a);
                b.H();
            }
            k32.i("【InlineFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline video「Hash:" + b.hashCode() + "」");
            return new pn2(b);
        }
        return (ZeusPlugin) invokeL.objValue;
    }
}
