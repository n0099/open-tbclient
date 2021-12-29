package com.baidu.wallet.core.utils;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class ConsumeTimeUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TimeResult a;

    /* renamed from: b  reason: collision with root package name */
    public String f52988b;

    /* renamed from: c  reason: collision with root package name */
    public String f52989c;

    /* loaded from: classes13.dex */
    public final class TimeResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public long f52990b;

        /* renamed from: c  reason: collision with root package name */
        public long f52991c;

        /* renamed from: d  reason: collision with root package name */
        public int f52992d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConsumeTimeUtils f52993e;

        public TimeResult(ConsumeTimeUtils consumeTimeUtils) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {consumeTimeUtils};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52993e = consumeTimeUtils;
            this.a = 0L;
            this.f52990b = 0L;
            this.f52991c = 0L;
            this.f52992d = 0;
        }

        public String buildLog() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                StringBuilder sb = new StringBuilder();
                if (this.f52993e.f52989c != null) {
                    sb.append(this.f52993e.f52989c + ":");
                }
                sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public long getDurationMesc() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f52990b - this.a : invokeV.longValue;
        }

        public int getDurationSecond() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (int) (getDurationMesc() / 1000) : invokeV.intValue;
        }

        public long getEndTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f52990b : invokeV.longValue;
        }

        public long getStartTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : invokeV.longValue;
        }

        public void logd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                LogUtil.d(this.f52993e.f52988b, buildLog());
            }
        }

        public void loge() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                LogUtil.e(this.f52993e.f52988b, buildLog(), new Throwable());
            }
        }

        public void logi() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                LogUtil.i(this.f52993e.f52988b, buildLog());
            }
        }

        public void logv() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                LogUtil.v(this.f52993e.f52988b, buildLog());
            }
        }

        public void logw() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                LogUtil.w(this.f52993e.f52988b, buildLog());
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                String buildLog = buildLog();
                LogUtil.v(this.f52993e.f52988b, buildLog);
                return buildLog;
            }
            return (String) invokeV.objValue;
        }
    }

    public ConsumeTimeUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52988b = "ConsumeTime";
    }

    public TimeResult finish() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.a.f52990b = SystemClock.uptimeMillis();
            return this.a;
        }
        return (TimeResult) invokeV.objValue;
    }

    public void setPrefix(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f52989c = str;
        }
    }

    public void setTAGString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f52988b = str;
        }
    }

    public ConsumeTimeUtils start() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TimeResult timeResult = new TimeResult(this);
            this.a = timeResult;
            timeResult.a = SystemClock.uptimeMillis();
            return this;
        }
        return (ConsumeTimeUtils) invokeV.objValue;
    }
}
