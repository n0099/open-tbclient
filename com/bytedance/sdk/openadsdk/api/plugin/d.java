package com.bytedance.sdk.openadsdk.api.plugin;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.download.PluginDownloadBean;
import java.io.File;
/* loaded from: classes11.dex */
public final class d extends PluginDownloadBean {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f61665a;

    /* renamed from: b  reason: collision with root package name */
    public File f61666b;

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
        this.f61665a = "";
        this.f61666b = null;
        this.mOrder = 0;
        this.isOffline = false;
        this.isWifiOnly = true;
        this.mDownloadType = 1;
        this.mBackupUrlList = null;
    }
}
