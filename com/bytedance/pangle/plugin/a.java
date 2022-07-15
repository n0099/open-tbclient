package com.bytedance.pangle.plugin;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.e.a.e;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;
/* loaded from: classes4.dex */
public final class a implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final File a;
    public final String b;

    public a(String str, File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = file;
        this.b = str;
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            e a = com.bytedance.pangle.e.a.d.a(this.a);
            if (a == null) {
                String str = this.b;
                ZeusPluginStateListener.postStateChange(str, 7, " read local file package info failed !!! pluginPkg = " + this.b + " mApkFile.exists = " + this.a.exists());
                StringBuilder sb = new StringBuilder("PluginInstallRunnable read local file package info failed !!! pluginPkg = ");
                sb.append(this.b);
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, sb.toString());
                return false;
            }
            Plugin plugin = PluginManager.getInstance().getPlugin(a.a);
            if (plugin == null) {
                String str2 = this.b;
                ZeusPluginStateListener.postStateChange(str2, 7, " plugin == null !!! pluginPkg = " + this.b);
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable cannot query valid plugin !!! packageName = " + a.a);
                return false;
            }
            boolean install = plugin.install(this.a, a);
            if (install) {
                ZeusPluginStateListener.postStateChange(a.a, 6, new Object[0]);
            } else {
                ZeusPluginStateListener.postStateChange(a.a, 7, "Internal error.");
            }
            return install;
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
