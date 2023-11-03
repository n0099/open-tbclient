package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public interface mz0 {
    a a(tz0 tz0Var, kz0... kz0VarArr);

    boolean b(tz0 tz0Var, kz0... kz0VarArr);

    void beginTransaction();

    long c(tz0 tz0Var);

    Cursor d(yz0 yz0Var);

    int e(tz0 tz0Var, kz0... kz0VarArr);

    void endTransaction();

    int f(tz0 tz0Var, kz0... kz0VarArr);

    void setTransactionSuccessful();

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long a;
        public final int b;

        public a(long j, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.b = i;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "Res{rowId=" + this.a + ", updateCount=" + this.b + '}';
            }
            return (String) invokeV.objValue;
        }
    }
}
