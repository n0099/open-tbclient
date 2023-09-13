package com.baidu.tieba;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class tv4 {
    public static /* synthetic */ Interceptable $ic;
    public static tv4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<vv4> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948194647, "Lcom/baidu/tieba/tv4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948194647, "Lcom/baidu/tieba/tv4;");
        }
    }

    public tv4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new SparseArray<>();
    }

    public static tv4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (tv4.class) {
                    if (b == null) {
                        b = new tv4();
                    }
                }
            }
            return b;
        }
        return (tv4) invokeV.objValue;
    }

    public View a(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, context, i)) == null) {
            if (this.a.get(i) != null) {
                return this.a.get(i).a(context);
            }
            return null;
        }
        return (View) invokeLI.objValue;
    }

    public void c(int i, vv4 vv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, vv4Var) == null) {
            this.a.put(i, vv4Var);
        }
    }
}
