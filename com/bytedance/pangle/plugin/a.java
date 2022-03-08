package com.bytedance.pangle.plugin;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.download.ZeusPluginListener;
import com.bytedance.pangle.e.a.e;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;
/* loaded from: classes7.dex */
public final class a implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public File a;

    /* renamed from: b  reason: collision with root package name */
    public ZeusPluginListener f51726b;

    public a(File file, ZeusPluginListener zeusPluginListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, zeusPluginListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = file;
        this.f51726b = zeusPluginListener;
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            e a = com.bytedance.pangle.e.a.d.a(this.a);
            boolean z = false;
            if (a != null) {
                Plugin plugin2 = PluginManager.getInstance().getPlugin(a.a);
                if (plugin2 != null) {
                    z = plugin2.install(this.a, a);
                    ZeusPluginListener zeusPluginListener = this.f51726b;
                    if (zeusPluginListener != null) {
                        zeusPluginListener.onEvent(z ? 21 : 22, "install result = ".concat(String.valueOf(z)));
                    }
                } else {
                    ZeusPluginListener zeusPluginListener2 = this.f51726b;
                    if (zeusPluginListener2 != null) {
                        zeusPluginListener2.onEvent(22, "cannot query valid plugin !!! packageName = " + a.a);
                    }
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable cannot query valid plugin !!! packageName = " + a.a);
                }
            } else {
                ZeusPluginListener zeusPluginListener3 = this.f51726b;
                if (zeusPluginListener3 != null) {
                    zeusPluginListener3.onEvent(22, "read local file package info failed !!!" + this.a.getAbsolutePath() + " exists:" + this.a.exists());
                }
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable read local file package info failed !!!" + this.a.getAbsolutePath() + " exists:" + this.a.exists());
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
        }
    }
}
