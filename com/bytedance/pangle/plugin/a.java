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
/* loaded from: classes11.dex */
public final class a implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public File f62355a;

    /* renamed from: b  reason: collision with root package name */
    public ZeusPluginListener f62356b;

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
        this.f62355a = file;
        this.f62356b = zeusPluginListener;
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            e a2 = com.bytedance.pangle.e.a.d.a(this.f62355a);
            boolean z = false;
            if (a2 != null) {
                Plugin plugin2 = PluginManager.getInstance().getPlugin(a2.f62278a);
                if (plugin2 != null) {
                    z = plugin2.install(this.f62355a, a2);
                    ZeusPluginListener zeusPluginListener = this.f62356b;
                    if (zeusPluginListener != null) {
                        zeusPluginListener.onEvent(z ? 21 : 22, "install result = ".concat(String.valueOf(z)));
                    }
                } else {
                    ZeusPluginListener zeusPluginListener2 = this.f62356b;
                    if (zeusPluginListener2 != null) {
                        zeusPluginListener2.onEvent(22, "cannot query valid plugin !!! packageName = " + a2.f62278a);
                    }
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable cannot query valid plugin !!! packageName = " + a2.f62278a);
                }
            } else {
                ZeusPluginListener zeusPluginListener3 = this.f62356b;
                if (zeusPluginListener3 != null) {
                    zeusPluginListener3.onEvent(22, "read local file package info failed !!!" + this.f62355a.getAbsolutePath() + " exists:" + this.f62355a.exists());
                }
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable read local file package info failed !!!" + this.f62355a.getAbsolutePath() + " exists:" + this.f62355a.exists());
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
