package com.baidu.tieba.pluginCenter;

import c.a.s0.l0.b.a;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class PluginConfigWrapper extends PluginNetConfigInfos.PluginConfig implements a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DOWNLOADED_BUT_FORBIDDEN = 1;
    public static final int DOWNLOADED_NOT_FORBIDDEN = 2;
    public static final int DOWNLOADING = 3;
    public static final int DOWNLOAD_NOT = 0;
    public static final int DOWNLOAD_UPDATE = 4;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int mDownLoadStatus;
    public int mDownloadProgress;

    public PluginConfigWrapper(PluginNetConfigInfos.PluginConfig pluginConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pluginConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (pluginConfig == null) {
            return;
        }
        this.icon = pluginConfig.icon;
        this.display_name = pluginConfig.display_name;
        this.forbidden = pluginConfig.forbidden;
        this.version_code = pluginConfig.version_code;
        this.ext = pluginConfig.ext;
        this.newest = pluginConfig.newest;
        this.package_name = pluginConfig.package_name;
        this.verbose = pluginConfig.verbose;
    }

    public int getDownLoadPercent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDownloadProgress : invokeV.intValue;
    }

    public int getDownLoadStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDownLoadStatus : invokeV.intValue;
    }

    public void setDownLoadPercent(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.mDownloadProgress = i2;
        }
    }

    public void setDownLoadStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.mDownLoadStatus = i2;
        }
    }
}
