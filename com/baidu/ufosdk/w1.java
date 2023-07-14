package com.baidu.ufosdk;

import android.os.Process;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class w1 implements Runnable, Comparable<w1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable a;
    public int b;
    public long c;

    public w1(Runnable runnable, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {runnable, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 5;
        this.a = runnable;
        this.b = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(w1 w1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, w1Var)) == null) {
            w1 w1Var2 = w1Var;
            int i = this.b;
            int i2 = w1Var2.b;
            if (i >= i2) {
                if (i <= i2) {
                    int i3 = (this.c > w1Var2.c ? 1 : (this.c == w1Var2.c ? 0 : -1));
                    if (i3 >= 0) {
                        if (i3 <= 0) {
                            return 0;
                        }
                    }
                }
                return 1;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                Process.setThreadPriority(10);
            } catch (Exception unused) {
            }
            this.a.run();
            this.a = null;
        }
    }
}
