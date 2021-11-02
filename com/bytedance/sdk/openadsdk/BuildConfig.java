package com.bytedance.sdk.openadsdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public final class BuildConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BRANCH = "v4000_plugin";
    public static final String BUILD_TYPE = "release";
    public static final String CHANNEL = "plugin";
    public static final String COMMIT_HASH = "1c67eaee1";
    public static final boolean DEBUG = false;
    public static final boolean INCLUDE_LYNX = false;
    public static final boolean IS_PLUGIN = true;
    public static final String LIBRARY_PACKAGE_NAME = "com.bytedance.sdk.openadsdk";
    public static final int VERSION_CODE = 4011;
    public static final String VERSION_NAME = "4.0.1.1";
    public transient /* synthetic */ FieldHolder $fh;

    public BuildConfig() {
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
}
