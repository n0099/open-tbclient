package com.baidu.wallet.lightapp.monitor;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.NoProguard;
/* loaded from: classes8.dex */
public class WhiteScreenConfig implements NoProguard {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Policy f62169a;
    public transient /* synthetic */ FieldHolder $fh;
    public Policy finishPolicy;
    public Policy resumePolicy;
    public Policy startPolicy;
    public int wsc_alive_time;
    public int wsc_area_detect;
    public int wsc_core_cache;
    public int wsc_core_task;
    public int wsc_delay_time;
    public boolean wsc_enable;
    public int wsc_general_detect;
    public int wsc_max_task;
    public int wsc_simple_count;
    public boolean wsc_view_enable;
    public int wsc_wait_time;

    /* loaded from: classes8.dex */
    public static class Policy implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public double backoffMultiplier;
        public int initialDelayMs;
        public int maxNumRetries;

        public Policy() {
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

        public Policy(int i2, int i3, double d2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Double.valueOf(d2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.initialDelayMs = i2;
            this.maxNumRetries = i3;
            this.backoffMultiplier = d2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-644401611, "Lcom/baidu/wallet/lightapp/monitor/WhiteScreenConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-644401611, "Lcom/baidu/wallet/lightapp/monitor/WhiteScreenConfig;");
                return;
            }
        }
        f62169a = new Policy(1000, 1, 0.8d);
    }

    public WhiteScreenConfig() {
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
        this.wsc_enable = false;
        this.wsc_view_enable = false;
        this.wsc_delay_time = 3000;
        this.wsc_wait_time = 500;
        this.wsc_core_cache = 2;
        this.wsc_core_task = 2;
        this.wsc_max_task = 5;
        this.wsc_alive_time = 10;
        this.wsc_area_detect = 9;
        this.wsc_general_detect = 1;
        this.wsc_simple_count = 3;
        Policy policy = f62169a;
        this.resumePolicy = policy;
        this.startPolicy = policy;
        this.finishPolicy = policy;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.wsc_delay_time >= 0 && (i2 = this.wsc_core_cache) >= 0 && i2 <= 5 && this.wsc_core_task >= 1 && this.wsc_max_task >= 1 && this.wsc_alive_time > 0 && (i3 = this.wsc_area_detect) > 0 && i3 <= 9 && this.wsc_general_detect >= 0 && (i4 = this.wsc_simple_count) >= 1 && i4 <= 9 : invokeV.booleanValue;
    }
}
