package com.bytedance.pangle.plugin;

import android.text.TextUtils;
import com.baidu.mobads.container.util.XAdSimpleImageLoader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.helper.PluginDirHelper;
import com.bytedance.pangle.i;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.f;
import com.bytedance.pangle.util.g;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes11.dex */
public final class d implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public File f61460a;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61460a = null;
    }

    private void a(File file) {
        PluginProvider pluginProvider;
        File provideBuiltInPlugin;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, file) == null) {
            ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusScanRunnable listPluginDownloadDir, dir = ".concat(String.valueOf(file)));
            file.listFiles(new FileFilter(this) { // from class: com.bytedance.pangle.plugin.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f61461a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61461a = this;
                }

                @Override // java.io.FileFilter
                public final boolean accept(File file2) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file2)) == null) {
                        if (file2 != null && (file2.getName().endsWith(".apk") || file2.getName().endsWith(".jar"))) {
                            PluginManager.getInstance().asyncInstall(file2);
                            return true;
                        } else if (file2.getAbsolutePath().endsWith(XAdSimpleImageLoader.TEMP_SUFFIX) && System.currentTimeMillis() - file2.lastModified() < 259200000) {
                            ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusScanRunnable installPluginDir find : ".concat(String.valueOf(file2)));
                            return false;
                        } else {
                            f.a(file2);
                            ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusScanRunnable installPluginDir deleted : ".concat(String.valueOf(file2)));
                            return false;
                        }
                    }
                    return invokeL.booleanValue;
                }
            });
            if (file.equals(this.f61460a) || (pluginProvider = i.a().f61439b.getPluginProvider()) == null || (provideBuiltInPlugin = pluginProvider.provideBuiltInPlugin()) == null) {
                return;
            }
            PluginManager.getInstance().asyncInstall(provideBuiltInPlugin);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        String[] list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                String downloadDir = PluginDirHelper.getDownloadDir();
                for (String str : Zeus.getAppApplication().getAssets().list("plugins/")) {
                    if (str.endsWith(".apk")) {
                        String concat = "plugins/".concat(String.valueOf(str));
                        File file = new File(downloadDir, str);
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusScanRunnable releaseCopyFile " + concat + " --> " + file.getAbsolutePath());
                        g.a(Zeus.getAppApplication().getAssets().open(concat), new FileOutputStream(file), 0L);
                    }
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            a(new File(PluginDirHelper.getDownloadDir()));
            String pushDir = PluginDirHelper.getPushDir();
            if (TextUtils.isEmpty(pushDir)) {
                return;
            }
            File file2 = new File(pushDir);
            this.f61460a = file2;
            a(file2);
        }
    }
}
