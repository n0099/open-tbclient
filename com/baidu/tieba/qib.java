package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class qib {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public ArrayList<Long> b;
    public long c;
    public int d;
    public boolean e;

    public qib(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList<>();
        this.c = 0L;
        this.d = 0;
        this.e = false;
        this.a = i;
    }

    public synchronized long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.b.isEmpty()) {
                    return 0L;
                }
                long longValue = this.b.remove(0).longValue();
                this.c -= longValue;
                if (!this.b.isEmpty()) {
                    long size = this.c / this.b.size();
                }
                return longValue;
            }
        }
        return invokeV.longValue;
    }

    public synchronized void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            synchronized (this) {
                this.b.add(Long.valueOf(j));
                this.c += j;
                if (this.b.size() > this.a) {
                    this.c -= this.b.remove(0).longValue();
                }
                long size = this.c / this.b.size();
                if (this.d == 0) {
                    return;
                }
                if (this.e && this.b.size() <= this.d) {
                    long size2 = this.c / this.b.size();
                }
            }
        }
    }
}
