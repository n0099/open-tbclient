package com.bytedance.pangle.download;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.PluginProvider;
import java.util.List;
/* loaded from: classes4.dex */
public final class c implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final g b;

    public c(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = gVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00b4 A[Catch: Exception -> 0x00bf, all -> 0x00cd, TryCatch #0 {Exception -> 0x00bf, blocks: (B:23:0x0036, B:25:0x0049, B:27:0x004f, B:28:0x006f, B:30:0x0075, B:49:0x00b4, B:50:0x00b7, B:33:0x007f, B:35:0x0083, B:36:0x008c, B:38:0x0094, B:39:0x0099, B:41:0x009d, B:43:0x00a7, B:44:0x00ac, B:51:0x00ba), top: B:65:0x0036, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00b7 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void run() {
        List<PluginDownloadBean> providePluginConfig;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.a && g.a().d) {
                    return;
                }
                if (System.currentTimeMillis() - this.b.a < 300000) {
                    return;
                }
                if (d.a(Zeus.getAppApplication())) {
                    for (int i = 0; i < 2; i++) {
                        try {
                            ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, "Skip! useInternalNetworkImpl = false!");
                            PluginProvider pluginProvider = com.bytedance.pangle.g.a().b.getPluginProvider();
                            if (pluginProvider != null && (providePluginConfig = pluginProvider.providePluginConfig()) != null) {
                                this.b.a = System.currentTimeMillis();
                                ZeusLogger.i(ZeusLogger.TAG_DOWNLOAD, "handlePlugins, pluginSize = " + providePluginConfig.size());
                                for (int i2 = 0; i2 < providePluginConfig.size(); i2++) {
                                    PluginDownloadBean pluginDownloadBean = providePluginConfig.get(i2);
                                    if (pluginDownloadBean != null) {
                                        if (pluginDownloadBean.isOffline) {
                                            g.a(pluginDownloadBean);
                                            Zeus.markOfflineFlag(pluginDownloadBean.mPackageName);
                                        } else {
                                            if (Zeus.hasOfflineFlag(pluginDownloadBean.mPackageName)) {
                                                Zeus.clearOfflineFlag(pluginDownloadBean.mPackageName);
                                            }
                                            if (pluginDownloadBean.isRevert) {
                                                if (pluginDownloadBean.mVersionCode < Zeus.getInstalledPluginVersion(pluginDownloadBean.mPackageName)) {
                                                    Zeus.unInstallPlugin(pluginDownloadBean.mPackageName);
                                                }
                                                if (pluginDownloadBean.mVersionCode == 0) {
                                                }
                                            }
                                            z = true;
                                            if (z) {
                                                providePluginConfig.remove(pluginDownloadBean);
                                            }
                                        }
                                    }
                                    z = false;
                                    if (z) {
                                    }
                                }
                                g.a(providePluginConfig);
                            }
                            return;
                        } catch (Exception e) {
                            ZeusLogger.e(ZeusLogger.TAG_DOWNLOAD, "Request plugin config failed!!!", e);
                        }
                    }
                }
            }
        }
    }
}
