package com.baidu.tieba;

import android.os.CountDownTimer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class o66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public CountDownTimer b;

    /* loaded from: classes7.dex */
    public interface b {
        void a(long j, long j2);

        void b();
    }

    /* loaded from: classes7.dex */
    public class a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ o66 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(o66 o66Var, long j, long j2, long j3) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o66Var, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o66Var;
            this.a = j3;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a != null) {
                this.b.a.b();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && this.b.a != null) {
                this.b.a.a(this.a, j);
            }
        }
    }

    public o66() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void b() {
        CountDownTimer countDownTimer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (countDownTimer = this.b) != null) {
            countDownTimer.cancel();
        }
    }

    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.a = bVar;
        }
    }

    public String c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            long j2 = j / 1000;
            long j3 = j2 / 3600;
            StringBuilder sb = new StringBuilder();
            if (j3 > 0) {
                if (j3 < 10) {
                    sb.append("0");
                }
                sb.append(j3);
                sb.append(":");
            }
            Long.signum(j3);
            long j4 = j2 - (j3 * 3600);
            long j5 = j4 / 60;
            if (j5 < 10) {
                sb.append("0");
            }
            sb.append(j5);
            sb.append(":");
            long j6 = j4 - (j5 * 60);
            if (j6 < 10) {
                sb.append("0");
            }
            sb.append(j6);
            return sb.toString();
        }
        return (String) invokeJ.objValue;
    }

    public void e(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            b();
            this.b = new a(this, j2, 1000L, j).start();
        }
    }
}
