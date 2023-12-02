package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PluginCheck;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.sdkcode.ISdkCodePlugin;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes8.dex */
public final class wma {
    public static /* synthetic */ Interceptable $ic;
    public static final wma a;
    public static volatile ISdkCodePlugin b;
    public static volatile boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948276766, "Lcom/baidu/tieba/wma;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948276766, "Lcom/baidu/tieba/wma;");
                return;
            }
        }
        a = new wma();
    }

    /* loaded from: classes8.dex */
    public static final class a implements IInvokeCallback {
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

        @Override // com.baidu.nps.main.invoke.IInvokeCallback
        public void onResult(int i, String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, obj) == null) {
                TbLog a = qf.a.a();
                a.i("SdkCodePluginManager", "SdkCodePlugin init() 插件安装完成" + i + WebvttCueParser.CHAR_SPACE + str + WebvttCueParser.CHAR_SPACE + obj);
                if (i != 14) {
                    return;
                }
                try {
                    if (wma.b == null) {
                        wma wmaVar = wma.a;
                        if (obj != null) {
                            Object newInstance = ((Class) obj).newInstance();
                            if (newInstance != null) {
                                wma.b = (ISdkCodePlugin) newInstance;
                                ISdkCodePlugin iSdkCodePlugin = wma.b;
                                if (iSdkCodePlugin != null) {
                                    iSdkCodePlugin.init(wma.a.g());
                                }
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.sdkcode.ISdkCodePlugin");
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
                        }
                    }
                    x25.a();
                } catch (Throwable th) {
                    TbLog a2 = qf.a.a();
                    a2.e("SdkCodePluginManager", "SdkCodePlugin init() 插件安装异常" + th);
                    th.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements IInstallCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IInvokeCallback a;

        @Override // com.baidu.nps.main.install.IInstallCallback
        public void onProgress(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            }
        }

        public b(IInvokeCallback iInvokeCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iInvokeCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iInvokeCallback;
        }

        @Override // com.baidu.nps.main.install.IInstallCallback
        public void onResult(int i, String s) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, s) == null) {
                Intrinsics.checkNotNullParameter(s, "s");
                TbLog a = qf.a.a();
                a.i("SdkCodePluginManager", "SdkCodePlugin invokePlugin 下载完成 " + i + WebvttCueParser.CHAR_SPACE + s);
                if (i == 13 && PluginCheck.c("com.baidu.tieba.plugin.sdkcode", this.a, "SdkCodePluginManager", true)) {
                    NPSManager.getInstance().loadClazz("com.baidu.tieba.plugin.sdkcode", "com.baidu.tieba.sdkcode.SdkCodePluginImpl", ISdkCodePlugin.class, this.a);
                }
            }
        }
    }

    public wma() {
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

    public final synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                qf.a.a().i("SdkCodePluginManager", "SdkCodePlugin init() 触发插件安装");
                j(new a());
            }
        }
    }

    public final Context g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            Intrinsics.checkNotNullExpressionValue(inst, "getInst()");
            return inst;
        }
        return (Context) invokeV.objValue;
    }

    public final synchronized ISdkCodePlugin h() {
        InterceptResult invokeV;
        ISdkCodePlugin iSdkCodePlugin;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                try {
                    d();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                iSdkCodePlugin = b;
            }
            return iSdkCodePlugin;
        }
        return (ISdkCodePlugin) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && b == null) {
            if (k()) {
                qf.a.a().i("SdkCodePluginManager", "SdkCodePlugin init() source");
                f();
                return;
            }
            qf.a.a().i("SdkCodePluginManager", "SdkCodePlugin init() plugin");
            e();
        }
    }

    public final synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                Object newInstance = Class.forName("com.baidu.tieba.sdkcode.SdkCodePluginImpl").newInstance();
                if (newInstance != null) {
                    b = (ISdkCodePlugin) newInstance;
                    ISdkCodePlugin iSdkCodePlugin = b;
                    if (iSdkCodePlugin != null) {
                        iSdkCodePlugin.init(g());
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.sdkcode.ISdkCodePlugin");
                }
            }
        }
    }

    public final synchronized boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                String tiebaNpsPluginMode = GlobalBuildConfig.getTiebaNpsPluginMode();
                Intrinsics.checkNotNullExpressionValue(tiebaNpsPluginMode, "getTiebaNpsPluginMode()");
                if (StringsKt__StringsKt.contains$default((CharSequence) tiebaNpsPluginMode, (CharSequence) "Host", false, 2, (Object) null)) {
                    String tiebaNpsPluginMode2 = GlobalBuildConfig.getTiebaNpsPluginMode();
                    Intrinsics.checkNotNullExpressionValue(tiebaNpsPluginMode2, "getTiebaNpsPluginMode()");
                    if (!StringsKt__StringsKt.contains$default((CharSequence) tiebaNpsPluginMode2, (CharSequence) "-SdkCode", false, 2, (Object) null)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final synchronized void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (c) {
                    return;
                }
                try {
                    d();
                    c = true;
                } catch (Exception e) {
                    c = false;
                    TbLog a2 = qf.a.a();
                    a2.i("SdkCodePluginManager", "SdkCodePlugin init() 异常" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public final synchronized void j(IInvokeCallback iInvokeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iInvokeCallback) == null) {
            synchronized (this) {
                if (NPSPackageManager.getInstance().getBundleStatus("com.baidu.tieba.plugin.sdkcode") == 43) {
                    if (PluginCheck.c("com.baidu.tieba.plugin.sdkcode", iInvokeCallback, "SdkCodePluginManager", false)) {
                        qf.a.a().i("SdkCodePluginManager", "SdkCodePlugin invokePlugin：插件可用，直接加载");
                        NPSManager.getInstance().loadClazz("com.baidu.tieba.plugin.sdkcode", "com.baidu.tieba.sdkcode.SdkCodePluginImpl", ISdkCodePlugin.class, iInvokeCallback);
                    }
                } else {
                    qf.a.a().i("SdkCodePluginManager", "SdkCodePlugin invokePlugin：开始下载");
                    NPSPackageManager.getInstance().installBundle("com.baidu.tieba.plugin.sdkcode", new b(iInvokeCallback));
                }
            }
        }
    }
}
