package com.baidu.walletsdk.core;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public final class BuildConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BUILD_TYPE = "release";
    public static final boolean DEBUG = false;
    public static final String FLAVOR = "standard";
    public static final boolean IS_BUSINESS_VERSION = false;
    public static final String LIBRARY_PACKAGE_NAME = "com.baidu.walletsdk.core";
    public static final int VERSION_CODE = -1;
    public static final String VERSION_NAME = "9.5.5.109";
    public static final boolean hasSdkAsPlugin = false;
    public static final boolean isImmersive = true;
    public static final String sChannelId = "baiduapp";
    public static final boolean sDebugStatus = false;
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
