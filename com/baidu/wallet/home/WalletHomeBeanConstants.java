package com.baidu.wallet.home;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class WalletHomeBeanConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String API_CHECK_NEW = "/wireless/0/check_new/0/";
    public static final String API_HOME_CFG = "/wireless/0/config";
    public static final String API_HOME_CFG_ABTYPE = "/walletapp/sdk/homepage";
    public static final String API_HOME_CFG_NEW = "/odp/wireless/layout/common";
    public static final String CACHE_USER_DATA = "indexusercache.cfg";
    public static final String CONFIG_CACHE_ASSETS_FOR_FINANCE = "service_finance.cfg";
    public static final String CONFIG_CACHE_ASSETS_FOR_UMONEY = "service_umoney_assets.cfg";
    public static final String CONFIG_CACHE_DIR = "service4.cfg";
    public static final String CONFIG_CACHE_DIR_FOR_FINANCE = "service_finance_1.cfg";
    public static final String CONFIG_CACHE_DIR_FOR_UMONEY = "service_umoney_cache.cfg";
    public static final String CONFIG_CACHE_DIR_NEW = "service_5.cfg";
    public static final String HOME_TAB_URL = "/odp/wireless/tab/info";
    public transient /* synthetic */ FieldHolder $fh;

    public WalletHomeBeanConstants() {
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
