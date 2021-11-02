package com.baidu.wallet.core.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.paysdk.ui.PassNormalizeActivity;
import java.util.Map;
/* loaded from: classes10.dex */
public final class PassUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NORMALIZE_URL = "normalize_url";
    public static final String PASS_ACCOUNT = "pass_account";
    public static final String PASS_ACCOUNT_TYPE = "pass_account_type";
    public static final String PASS_AUTH_SID = "pass_auth_sid";
    public static final String PASS_DISPLAY_NAME = "pass_display_name";
    public static final String PASS_ERROR_CODE = "pass_error_code";
    public static final String PASS_ERROR_MSG = "pass_error_msg";
    public static final String PASS_NEW_REQ = "pass_new_req";
    public static final String PASS_OPEN_BDUSS = "pass_open_bduss";
    public static final String PASS_PASSWORD = "pass_code";
    public static final String PASS_PTOKEN = "pass_ptoken";
    public static final String PASS_SID = "pass_sid";
    public static final String PASS_STOKEN = "pass_stoken";
    public static final String PASS_TYPE = "pass_util_type";
    public static final String PASS_UBI = "pass_ubi";
    public static final String PASS_UID = "pass_uid";
    public static final String PASS_UNION_ID = "pass_union_id";
    public static final String PASS_USER_NAEME = "pass_user_name";
    public static final int TYPE_COMPLETED = 1;
    public static final int TYPE_VERIFY = 2;

    /* renamed from: a  reason: collision with root package name */
    public static IPassNormalize f58049a;

    /* renamed from: b  reason: collision with root package name */
    public static long f58050b;

    /* renamed from: c  reason: collision with root package name */
    public static IPassNormalize f58051c;

    /* renamed from: d  reason: collision with root package name */
    public static final Object f58052d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public interface IPassNormalize {
        boolean onNormalize(Context context, int i2, Map<String, String> map);
    }

    /* loaded from: classes10.dex */
    public static class PassNormalize implements IPassNormalize {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public PassNormalize() {
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

        @Override // com.baidu.wallet.core.utils.PassUtil.IPassNormalize
        public boolean onNormalize(Context context, int i2, Map<String, String> map) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, context, i2, map)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("统一处理正常化 type=");
                sb.append(i2);
                sb.append("#map=");
                sb.append(map == null);
                LogUtil.logd(sb.toString());
                if (i2 == 1 && map != null) {
                    String str = map.get("pass_open_bduss");
                    if ("0".equals(map.get("pass_error_code")) && !TextUtils.isEmpty(str)) {
                        IPassNormalize iPassNormalize = PassUtil.f58049a;
                        if (iPassNormalize != null) {
                            iPassNormalize.onNormalize(context, i2, map);
                        }
                        return true;
                    }
                }
                return i2 == 2 && map != null;
            }
            return invokeLIL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1826742014, "Lcom/baidu/wallet/core/utils/PassUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1826742014, "Lcom/baidu/wallet/core/utils/PassUtil;");
                return;
            }
        }
        f58052d = new Object();
    }

    public PassUtil() {
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

    public static long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis() - f58050b;
            LogUtil.logd("wait =" + currentTimeMillis);
            if (currentTimeMillis < 500 && currentTimeMillis > 0) {
                LogUtil.logd("需要wait =" + currentTimeMillis);
                return currentTimeMillis;
            }
            LogUtil.logd("不需要wait");
            return 0L;
        }
        return invokeV.longValue;
    }

    public static void backNormalized(Context context, int i2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(AdIconUtil.AD_TEXT_ID, null, context, i2, map) == null) {
            if (map != null && !TextUtils.isEmpty(map.get("pass_error_code")) && "0".equals(map.get("pass_error_code"))) {
                SapiAccountManager.getInstance().getAccountService().web2NativeLogin(new Web2NativeLoginCallback(context, i2, map) { // from class: com.baidu.wallet.core.utils.PassUtil.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Context f58053a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f58054b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ Map f58055c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {context, Integer.valueOf(i2), map};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f58053a = context;
                        this.f58054b = i2;
                        this.f58055c = map;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    /* renamed from: a */
                    public void onBdussExpired(Web2NativeLoginResult web2NativeLoginResult) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, web2NativeLoginResult) == null) {
                            if (PassUtil.f58051c != null) {
                                PassUtil.f58051c.onNormalize(this.f58053a, this.f58054b, this.f58055c);
                            }
                            IPassNormalize unused = PassUtil.f58051c = null;
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: b */
                    public void onSuccess(Web2NativeLoginResult web2NativeLoginResult) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, web2NativeLoginResult) == null) {
                            WalletLoginHelper.getInstance().getOpenBduss(true, new ILoginBackListener(this) { // from class: com.baidu.wallet.core.utils.PassUtil.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass1 f58056a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f58056a = this;
                                }

                                @Override // com.baidu.wallet.api.ILoginBackListener
                                public void onFail(int i3, String str) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i3, str) == null) {
                                        if (PassUtil.f58051c != null) {
                                            IPassNormalize iPassNormalize = PassUtil.f58051c;
                                            AnonymousClass1 anonymousClass1 = this.f58056a;
                                            iPassNormalize.onNormalize(anonymousClass1.f58053a, anonymousClass1.f58054b, anonymousClass1.f58055c);
                                        }
                                        IPassNormalize unused = PassUtil.f58051c = null;
                                    }
                                }

                                @Override // com.baidu.wallet.api.ILoginBackListener
                                public void onSuccess(int i3, String str) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, str) == null) {
                                        this.f58056a.f58055c.put("pass_open_bduss", str);
                                        if (PassUtil.f58051c != null) {
                                            IPassNormalize iPassNormalize = PassUtil.f58051c;
                                            AnonymousClass1 anonymousClass1 = this.f58056a;
                                            iPassNormalize.onNormalize(anonymousClass1.f58053a, anonymousClass1.f58054b, anonymousClass1.f58055c);
                                        }
                                        IPassNormalize unused = PassUtil.f58051c = null;
                                    }
                                }
                            }, 0);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(Web2NativeLoginResult web2NativeLoginResult) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, web2NativeLoginResult) == null) {
                            if (PassUtil.f58051c != null) {
                                PassUtil.f58051c.onNormalize(this.f58053a, this.f58054b, this.f58055c);
                            }
                            IPassNormalize unused = PassUtil.f58051c = null;
                        }
                    }

                    @Override // com.baidu.sapi2.callback.Web2NativeLoginCallback
                    public void onBdussEmpty(Web2NativeLoginResult web2NativeLoginResult) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048579, this, web2NativeLoginResult) == null) {
                            if (PassUtil.f58051c != null) {
                                PassUtil.f58051c.onNormalize(this.f58053a, this.f58054b, this.f58055c);
                            }
                            IPassNormalize unused = PassUtil.f58051c = null;
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048583, this) == null) {
                        }
                    }
                }, true);
                return;
            }
            IPassNormalize iPassNormalize = f58051c;
            if (iPassNormalize != null) {
                iPassNormalize.onNormalize(context, i2, map);
            }
            f58051c = null;
        }
    }

    public static void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            f58050b = System.currentTimeMillis();
        }
    }

    public static void passNormalized(Context context, String str, int i2, IPassNormalize iPassNormalize) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLIL(65543, null, context, str, i2, iPassNormalize) == null) || iPassNormalize == null || context == null) {
            return;
        }
        long b2 = b();
        if (b2 > 0) {
            try {
                synchronized (f58052d) {
                    LogUtil.logd("before wait");
                    f58052d.wait(b2);
                    LogUtil.logd("after wait");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        f58051c = iPassNormalize;
        Intent intent = new Intent(context, PassNormalizeActivity.class);
        intent.putExtra("normalize_url", str);
        intent.putExtra("pass_util_type", i2);
        context.startActivity(intent);
    }

    public static void registerPassNormalize(IPassNormalize iPassNormalize) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, iPassNormalize) == null) {
            f58049a = iPassNormalize;
        }
    }
}
