package com.bytedance.sdk.openadsdk.api.plugin;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class PluginConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EVENT_TYPE_PLUGIN_UPDATE = 1;
    public static final String KEY_APP_ID = "app_id";
    public static final String KEY_PLUGIN_VERSION = "plugin_version";
    public static final String KEY_PL_CONFIG_INFO = "_pl_config_info_";
    public static final String KEY_PL_UPDATE_LISTENER = "_pl_update_listener_";
    public static final String KEY_SDK_VERSION = "sdk_version";
    public static final String SIGN = "kByY7qOrcVyOPTdL5vrO2JgRFTAE1ky3JkPrgiTwwdok7qpioJhIPvlI6NeFAyB+QWiskZFqwOcgfeTEmvp+F0NTWiqqpDlxstcGPG7LODd8gmvSaLCiNPEXdhjsE918wPgK32IwhAqh+C/wt6kV4AWG3YbUfxTDP2jf0o880zWsj3Xvf667f6iAKY9YUZCkcad6Z/POk71/GNriz+hP/dOYKUklTcw56Axj/NfnT5v7wsxhGa+cyDyeN0niHRmZyjLO4i+66JcUk4U2CIlSCBx7PjW3Ck91aX2D8CKufkZ4aHNueq8g+vvUWG2sPkUt5lAUAk3UC4zItqP9VvNMcQ==";
    public static final int STATUS_PLUGIN_LOAD_FAILED = 1001;
    public static final int STATUS_PLUGIN_LOAD_SUCCESS = 1000;
    public transient /* synthetic */ FieldHolder $fh;

    public PluginConstants() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static final String getSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? SIGN : (String) invokeV.objValue;
    }
}
