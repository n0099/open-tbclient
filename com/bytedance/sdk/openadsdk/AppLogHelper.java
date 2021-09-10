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
import com.bytedance.sdk.openadsdk.o.a;
import com.bytedance.sdk.openadsdk.q.k;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class AppLogHelper {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile AppLogHelper f65345a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f65346b;

    /* renamed from: c  reason: collision with root package name */
    public String f65347c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f65348d;

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
        this.f65346b = null;
        this.f65347c = null;
        this.f65348d = false;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            String did = AppLog.getDid();
            this.f65346b = did;
            if (TextUtils.isEmpty(did)) {
                return;
            }
            a.b(16, this.f65346b);
            h.a("sdk_app_log_did", this.f65346b);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            String userUniqueID = AppLog.getUserUniqueID();
            this.f65347c = userUniqueID;
            if (TextUtils.isEmpty(userUniqueID)) {
                return;
            }
            h.a("app_log_user_unique_id", this.f65347c);
        }
    }

    public static AppLogHelper getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f65345a == null) {
                synchronized (AppLogHelper.class) {
                    if (f65345a == null) {
                        f65345a = new AppLogHelper();
                    }
                }
            }
            return f65345a;
        }
        return (AppLogHelper) invokeV.objValue;
    }

    public String getAppLogDid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f65346b)) {
                String a2 = h.a("sdk_app_log_did", 2592000000L);
                this.f65346b = a2;
                a.b(16, a2);
                if (TextUtils.isEmpty(this.f65346b)) {
                    if (!this.f65348d) {
                        initAppLog(o.a());
                    }
                    a();
                }
            }
            return this.f65346b;
        }
        return (String) invokeV.objValue;
    }

    public String getAppLogUserUniqueID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(this.f65347c)) {
                String a2 = h.a("app_log_user_unique_id", 2592000000L);
                this.f65347c = a2;
                if (TextUtils.isEmpty(a2)) {
                    if (!this.f65348d) {
                        initAppLog(o.a());
                    }
                    b();
                }
            }
            return this.f65347c;
        }
        return (String) invokeV.objValue;
    }

    public String getSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? !this.f65348d ? "" : (String) AppLog.getHeaderValue(HttpConstants.SDK_VERSION_NAME, "") : (String) invokeV.objValue;
    }

    public synchronized void initAppLog(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            synchronized (this) {
                if (!this.f65348d) {
                    InitConfig initConfig = new InitConfig(String.valueOf(164362), "unionser_slardar_applog");
                    if (l.f66740b != null) {
                        initConfig.setImeiEnable(l.f66740b.isCanUsePhoneState());
                        if (!l.f66740b.isCanUsePhoneState()) {
                            initConfig.setAppImei(l.f66740b.getDevImei());
                        }
                        initConfig.setMacEnable(l.f66740b.isCanUseWifiState());
                    }
                    initConfig.setSensitiveInfoProvider(new ISensitiveInfoProvider(this) { // from class: com.bytedance.sdk.openadsdk.AppLogHelper.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AppLogHelper f65349a;

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
                            this.f65349a = this;
                        }

                        @Override // com.bytedance.embedapplog.ISensitiveInfoProvider
                        public String getImsi() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? com.bytedance.sdk.openadsdk.m.a.a() : (String) invokeV.objValue;
                        }

                        @Override // com.bytedance.embedapplog.ISensitiveInfoProvider
                        public String getMac() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? com.bytedance.sdk.openadsdk.m.a.b() : (String) invokeV.objValue;
                        }
                    });
                    initConfig.setUriConfig(0);
                    AppLog.init(context, initConfig);
                    k.a(context);
                    this.f65348d = true;
                    a();
                    b();
                }
            }
        }
    }

    public void setHeaderInfo(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hashMap) == null) {
            if (!this.f65348d) {
                initAppLog(o.a());
            }
            AppLog.setHeaderInfo(hashMap);
        }
    }
}
