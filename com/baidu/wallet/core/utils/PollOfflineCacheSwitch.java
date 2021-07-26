package com.baidu.wallet.core.utils;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.baidu.wallet.core.ActLifecycleCbs;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.utils.BdWalletUtils;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class PollOfflineCacheSwitch implements ActLifecycleCbs.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static int INTERVAL_TIME = 120000;
    public static final String TAG = "WebViewCacheManager";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SdkInitResponse.OfflineCacheConfig f24919a;

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final PollOfflineCacheSwitch f24922a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-560097690, "Lcom/baidu/wallet/core/utils/PollOfflineCacheSwitch$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-560097690, "Lcom/baidu/wallet/core/utils/PollOfflineCacheSwitch$a;");
                    return;
                }
            }
            f24922a = new PollOfflineCacheSwitch();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1326790019, "Lcom/baidu/wallet/core/utils/PollOfflineCacheSwitch;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1326790019, "Lcom/baidu/wallet/core/utils/PollOfflineCacheSwitch;");
        }
    }

    public PollOfflineCacheSwitch() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static final PollOfflineCacheSwitch getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f24922a : (PollOfflineCacheSwitch) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.ActLifecycleCbs.a
    public boolean onInvoke(Context context, ActLifecycleCbs.FROM from) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, from)) == null) {
            boolean[] zArr = new boolean[1];
            StringBuilder sb = new StringBuilder();
            sb.append("pollinit-触发请求init接口，from = ");
            sb.append(from);
            sb.append("; 离线缓存开关");
            SdkInitResponse.OfflineCacheConfig offlineCacheConfig = this.f24919a;
            sb.append(offlineCacheConfig != null ? Boolean.valueOf(offlineCacheConfig.isUseOfflineCache()) : "空");
            LogUtil.d("WebViewCacheManager", sb.toString());
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbridge_openPoll"), new RouterCallback(this, zArr) { // from class: com.baidu.wallet.core.utils.PollOfflineCacheSwitch.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean[] f24920a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PollOfflineCacheSwitch f24921b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, zArr};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f24921b = this;
                    this.f24920a = zArr;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) && i2 == 0 && hashMap != null) {
                        this.f24920a[0] = ((Boolean) hashMap.get("openPoll")).booleanValue();
                    }
                }
            });
            if (from == ActLifecycleCbs.FROM.RESUME) {
                LogUtil.d("WebViewCacheManager", "pollinit-触发请求init接口，来自resume直接发起接口请求");
                BdWalletUtils.getInitForPoll(context);
                return true;
            }
            SdkInitResponse.OfflineCacheConfig offlineCacheConfig2 = this.f24919a;
            if ((offlineCacheConfig2 == null || !offlineCacheConfig2.isUseOfflineCache()) && !zArr[0]) {
                return false;
            }
            LogUtil.d("WebViewCacheManager", "pollinit-触发请求init接口，来自非resume，判断config非空且离线缓存开关打开 || 多webview打开=" + zArr[0]);
            BdWalletUtils.getInitForPoll(context);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActLifecycleCbs.a().a(this, INTERVAL_TIME);
        }
    }

    public void updateCacheConfig(SdkInitResponse.OfflineCacheConfig offlineCacheConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, offlineCacheConfig) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("pollinit-更新缓存配置:");
            sb.append(offlineCacheConfig != null ? Boolean.valueOf(offlineCacheConfig.isUseOfflineCache()) : "配置为空");
            LogUtil.d("WebViewCacheManager", sb.toString());
            this.f24919a = offlineCacheConfig;
        }
    }

    public void updateIntervalTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            INTERVAL_TIME = Integer.valueOf(str).intValue();
            LogUtil.d("WebViewCacheManager", "pollinit-更新间隔时间:" + str);
            ActLifecycleCbs.a().a(this, Long.valueOf(str).longValue());
        }
    }
}
