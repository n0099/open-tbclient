package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public class nl1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static nl1 b = null;
    public static int c = Integer.MAX_VALUE;
    public static long d = 120;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadPoolExecutor a;

    /* loaded from: classes7.dex */
    public class a implements FileFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(nl1 nl1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
                if (Pattern.matches("cpu[0-9]", file.getName())) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    public nl1() {
        int i;
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
        int a2 = (a() / 2) + 2;
        if (a2 > 3) {
            i = 3;
        } else {
            i = a2;
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, c, d, TimeUnit.SECONDS, new PriorityBlockingQueue());
        this.a = threadPoolExecutor;
        threadPoolExecutor.setThreadFactory(new ml1());
        this.a.allowCoreThreadTimeOut(true);
    }

    public static nl1 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (nl1.class) {
                if (b == null) {
                    b = new nl1();
                }
            }
            return b;
        }
        return (nl1) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return new File("/sys/devices/system/cpu/").listFiles(new a(this)).length;
            } catch (Throwable unused) {
                return 2;
            }
        }
        return invokeV.intValue;
    }

    public void b(jl1 jl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jl1Var) == null) {
            try {
                this.a.execute(jl1Var);
            } catch (Throwable th) {
                ql1.d(th);
            }
        }
    }
}
