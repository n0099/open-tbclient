package com.baidu.tieba;

import android.app.Application;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.controller.CustomRule;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebContainerActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.switchs.InitWriteWebDelaySwitch;
import com.baidu.tieba.browser.exception.TbWebViewException;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.ki6;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.write.WriteWebViewCacheManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class ug6 {
    public static /* synthetic */ Interceptable $ic;
    public static woc<String, Pair<Boolean, String>> a;
    public static final List<String> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements ji6 {
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

        @Override // com.baidu.tieba.ji6
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                return !TextUtils.isEmpty(str);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomRule {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i) {
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
        @Override // com.baidu.adp.framework.controller.MessageRule
        public CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, customMessage, customMessageTask)) == null) {
                if (!rh6.isOn()) {
                    return customMessage;
                }
                if (customMessage == null) {
                    return null;
                }
                Object data = customMessage.getData();
                if (!(data instanceof TbWebContainerActivityConfig)) {
                    return customMessage;
                }
                Intent intent = ((TbWebContainerActivityConfig) data).getIntent();
                if (intent == null) {
                    return customMessage;
                }
                String stringExtra = intent.getStringExtra(WebViewActivityConfig.TAG_URL);
                if (TextUtils.isEmpty(stringExtra)) {
                    return customMessage;
                }
                if (mh6.a.b(stringExtra)) {
                    TbLog hybridLog = HybridLog.getInstance();
                    hybridLog.e("UrlCountMapHelper", "1s内连续检查到3次相同的url, 发生循环，放弃拦截 url = " + stringExtra);
                    return customMessage;
                }
                TbPageContext<?> currentPageContext = TbadkCoreApplication.getInst().getCurrentPageContext(TbadkCoreApplication.getInst().getCurrentActivity());
                if (currentPageContext == null) {
                    return customMessage;
                }
                if (UrlManager.getInstance().dealOneLinkWithOutJumpWebView(currentPageContext, new String[]{stringExtra}) == 0) {
                    return null;
                }
                mh6.a.c();
                return customMessage;
            }
            return (CustomMessage) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948210085, "Lcom/baidu/tieba/ug6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948210085, "Lcom/baidu/tieba/ug6;");
                return;
            }
        }
        b = new ArrayList();
    }

    public ug6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static List<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b;
        }
        return (List) invokeV.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            ki6.a aVar = new ki6.a();
            aVar.c(new a());
            ni6.b().c(aVar);
        }
    }

    public static /* synthetic */ void f() {
        c();
        hj6.a().execute(new Runnable() { // from class: com.baidu.tieba.tg6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    mj6.a();
                }
            }
        });
        vg6.f().i();
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            MessageManager.getInstance().addMessageRule(new b(2002001));
        }
    }

    public static void b(final Application application, ug6 ug6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, application, ug6Var) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (fj6.b() == null) {
                fj6.c(application);
            }
            if (gj6.a()) {
                ij6.a().f(new Runnable() { // from class: com.baidu.tieba.pg6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            WebView.setWebContentsDebuggingEnabled(true);
                        }
                    }
                });
            }
            ij6.a().c(new Runnable() { // from class: com.baidu.tieba.qg6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ug6.f();
                    }
                }
            });
            ij6.a().f(new Runnable() { // from class: com.baidu.tieba.rg6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        vg6.f().h(application);
                    }
                }
            });
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                pi6.n().r();
                if (!InitWriteWebDelaySwitch.isOn()) {
                    ij6.a().f(new Runnable() { // from class: com.baidu.tieba.sg6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                WriteWebViewCacheManager.g().j();
                            }
                        }
                    });
                }
            }
            i();
            dk6.b("newHybrid", "init WebView Env 耗时：" + (System.currentTimeMillis() - currentTimeMillis) + ms.c);
        }
    }

    public static void d(woc<String, Pair<Boolean, String>> wocVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, wocVar) == null) {
            a = wocVar;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            gj6.b(z);
        }
    }

    public static Pair<Boolean, String> k(String str) throws TbWebViewException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            woc<String, Pair<Boolean, String>> wocVar = a;
            if (wocVar == null) {
                if (!gj6.a()) {
                    return new Pair<>(Boolean.FALSE, null);
                }
                throw new TbWebViewException("TBWebKit need call initUserAgent first !");
            }
            return wocVar.call(str);
        }
        return (Pair) invokeL.objValue;
    }
}
