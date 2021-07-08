package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.ISensitiveInfoProvider;
import com.bytedance.embedapplog.InitConfig;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.n.a;
import com.bytedance.sdk.openadsdk.r.i;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class AppLogHelper {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile AppLogHelper f28995a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f28996b;

    /* renamed from: c  reason: collision with root package name */
    public String f28997c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f28998d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1509585365, "Lcom/bytedance/sdk/openadsdk/AppLogHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1509585365, "Lcom/bytedance/sdk/openadsdk/AppLogHelper;");
        }
    }

    public AppLogHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28996b = null;
        this.f28997c = null;
        this.f28998d = false;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            String did = AppLog.getDid();
            this.f28996b = did;
            if (TextUtils.isEmpty(did)) {
                return;
            }
            h.a("sdk_app_log_did", this.f28996b);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            String userUniqueID = AppLog.getUserUniqueID();
            this.f28997c = userUniqueID;
            if (TextUtils.isEmpty(userUniqueID)) {
                return;
            }
            h.a("app_log_user_unique_id", this.f28997c);
        }
    }

    public static AppLogHelper getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f28995a == null) {
                synchronized (AppLogHelper.class) {
                    if (f28995a == null) {
                        f28995a = new AppLogHelper();
                    }
                }
            }
            return f28995a;
        }
        return (AppLogHelper) invokeV.objValue;
    }

    public String getAppLogDid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f28996b)) {
                String a2 = h.a("sdk_app_log_did", 2592000000L);
                this.f28996b = a2;
                if (TextUtils.isEmpty(a2)) {
                    if (!this.f28998d) {
                        initAppLog(o.a());
                    }
                    a();
                }
            }
            return this.f28996b;
        }
        return (String) invokeV.objValue;
    }

    public String getAppLogUserUniqueID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(this.f28997c)) {
                String a2 = h.a("app_log_user_unique_id", 2592000000L);
                this.f28997c = a2;
                if (TextUtils.isEmpty(a2)) {
                    if (!this.f28998d) {
                        initAppLog(o.a());
                    }
                    b();
                }
            }
            return this.f28997c;
        }
        return (String) invokeV.objValue;
    }

    public String getSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? !this.f28998d ? "" : (String) AppLog.getHeaderValue(HttpConstants.SDK_VERSION_NAME, "") : (String) invokeV.objValue;
    }

    public synchronized void initAppLog(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            synchronized (this) {
                if (!this.f28998d) {
                    InitConfig initConfig = new InitConfig(String.valueOf(164362), "unionser_slardar_applog");
                    if (l.f30343b != null) {
                        initConfig.setImeiEnable(l.f30343b.isCanUsePhoneState());
                        if (!l.f30343b.isCanUsePhoneState()) {
                            initConfig.setAppImei(l.f30343b.getDevImei());
                        }
                        initConfig.setMacEnable(l.f30343b.isCanUseWifiState());
                    }
                    initConfig.setSensitiveInfoProvider(new ISensitiveInfoProvider(this) { // from class: com.bytedance.sdk.openadsdk.AppLogHelper.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AppLogHelper f28999a;

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
                            this.f28999a = this;
                        }

                        @Override // com.bytedance.embedapplog.ISensitiveInfoProvider
                        public String getImsi() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? a.a() : (String) invokeV.objValue;
                        }

                        @Override // com.bytedance.embedapplog.ISensitiveInfoProvider
                        public String getMac() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a.b() : (String) invokeV.objValue;
                        }
                    });
                    initConfig.setUriConfig(0);
                    AppLog.init(context, initConfig);
                    i.a(context);
                    this.f28998d = true;
                    a();
                    b();
                }
            }
        }
    }

    public void setHeaderInfo(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hashMap) == null) {
            if (!this.f28998d) {
                initAppLog(o.a());
            }
            AppLog.setHeaderInfo(hashMap);
        }
    }
}
