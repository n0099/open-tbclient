package com.baidu.wallet.api;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.bankdetection.BuildConfig;
import com.baidu.crabsdk.lite.CrabLite;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.StatSettings;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.LogUtil;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class CrabHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CRAB_TAG = "crab";

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f24048a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1100053184, "Lcom/baidu/wallet/api/CrabHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1100053184, "Lcom/baidu/wallet/api/CrabHelper;");
        }
    }

    public CrabHelper() {
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

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            f24048a = true;
            long currentTimeMillis = System.currentTimeMillis();
            try {
                Class.forName("com.baidu.crabsdk.lite.CrabLite");
                try {
                    System.currentTimeMillis();
                    c(context);
                    System.currentTimeMillis();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                LogUtil.d(CRAB_TAG, "crab init success with cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            } catch (ClassNotFoundException unused) {
                LogUtil.d(CRAB_TAG, "crab lite sdk not package into wallet sdk (Try this only 1 time)");
            }
        }
    }

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context) == null) {
            String str = BeanConstants.VERSION_NO;
            String str2 = BeanConstants.CHANNEL_ID;
            String str3 = PhoneUtils.getAppVersionCode(context) + "";
            String passUserName = WalletLoginHelper.getInstance().isLogin() ? WalletLoginHelper.getInstance().getPassUserName() : "";
            String str4 = TextUtils.isEmpty(passUserName) ? "" : passUserName;
            List<String> generateSDKPackageConcerned = generateSDKPackageConcerned();
            LogUtil.d(CRAB_TAG, "init crab with pkg size:" + generateSDKPackageConcerned.size());
            int i2 = 0;
            for (String str5 : generateSDKPackageConcerned) {
                long currentTimeMillis = System.currentTimeMillis();
                a(context, "e4ede3580390f467", str, str3, str5, str2, str4);
                StringBuilder sb = new StringBuilder();
                sb.append("init ");
                i2++;
                sb.append(i2);
                sb.append(" cost :");
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                LogUtil.d(CRAB_TAG, sb.toString());
            }
            CrabLite.a("com.baidu.wallet");
        }
    }

    public static List<String> generateSDKPackageConcerned() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add("com.baidu.wallet");
            linkedList.add(BuildConfig.APPLICATION_ID);
            linkedList.add("com.baidu.android.pay");
            linkedList.add("com.baidu.apollon");
            linkedList.add("com.baidu.android.minipay");
            linkedList.add("com.baidu.android.lbspay");
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public static void initCrab(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            if (StatSettings.getInstance(context).isEnableCrashHandler() && !f24048a) {
                new Thread(new Runnable(context) { // from class: com.baidu.wallet.api.CrabHelper.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Context f24049a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f24049a = context;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            LogUtil.d(CrabHelper.CRAB_TAG, "init in child thread");
                            CrabHelper.b(this.f24049a);
                        }
                    }
                }).start();
                return;
            }
            if (f24048a) {
                LogUtil.d(CRAB_TAG, "crab already init :" + f24048a);
            }
            if (StatSettings.getInstance(context).isEnableCrashHandler()) {
                return;
            }
            LogUtil.d(CRAB_TAG, "crab disabled ");
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, str, str2, str3, str4, str5, str6}) == null) {
            CrabLite.b(context, str, str4, str2, str3);
            CrabLite.h(str4, false);
            CrabLite.i(str4, !DebugConfig.getInstance().isOnline());
            CrabLite.j(str4, true);
            CrabLite.k(str4, true);
            CrabLite.n(str4, str6);
            Object[] objArr = new Object[2];
            objArr[0] = str4;
            WalletLoginHelper.getInstance().dynamicCallPass(CrabLite.class, objArr, 26, 1, "setUid", new Class[]{String.class, String.class});
            CrabLite.f(str4, str5);
            CrabLite.m(str4, -1);
            CrabLite.l(str4, -1);
            CrabLite.o(str4, "Environment", DebugConfig.getInstance().getEnvironment());
            CrabLite.o(str4, "Server", DebugConfig.getInstance().getWalletHttpsHost());
            CrabLite.o(str4, "appVersionName", PhoneUtils.getAppVersionName(context));
            CrabLite.o(str4, "appVersionCode", PhoneUtils.getAppVersionCode(context) + "");
        }
    }
}
