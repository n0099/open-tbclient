package com.baidu.wallet.core.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.ActLifecycleCbs;
import com.baidu.wallet.utils.BdWalletUtils;
/* loaded from: classes8.dex */
public class PollInitUtils implements ActLifecycleCbs.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static int INTERVAL_TIME = 120000;
    public static final String TAG = "PollInitUtils";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Boolean f61167a;

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final PollInitUtils f61168a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1677706242, "Lcom/baidu/wallet/core/utils/PollInitUtils$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1677706242, "Lcom/baidu/wallet/core/utils/PollInitUtils$a;");
                    return;
                }
            }
            f61168a = new PollInitUtils();
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1289872865, "Lcom/baidu/wallet/core/utils/PollInitUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1289872865, "Lcom/baidu/wallet/core/utils/PollInitUtils;");
        }
    }

    public PollInitUtils() {
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
        this.f61167a = Boolean.TRUE;
    }

    public static final PollInitUtils getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f61168a : (PollInitUtils) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.ActLifecycleCbs.a
    public boolean onInvoke(Context context, ActLifecycleCbs.FROM from) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, from)) == null) {
            if (this.f61167a.booleanValue()) {
                LogUtil.d(TAG, "pollinit-触发请求init接口");
                BdWalletUtils.getInitForPoll(context);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActLifecycleCbs.a().a(this, INTERVAL_TIME);
        }
    }

    public void updateIntervalTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            INTERVAL_TIME = Integer.valueOf(str).intValue();
            LogUtil.d(TAG, "pollinit-更新间隔时间:" + str);
            ActLifecycleCbs.a().a(this, Long.valueOf(str).longValue());
        }
    }

    public void updatePollingSwitch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (!TextUtils.isEmpty(str) && "false".equals(str)) {
                this.f61167a = Boolean.FALSE;
            } else {
                this.f61167a = Boolean.TRUE;
            }
        }
    }
}
