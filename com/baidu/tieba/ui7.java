package com.baidu.tieba;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ui7 extends SparseArray<fj7> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;

    public ui7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i = 0; i < size(); i++) {
                fj7 valueAt = valueAt(i);
                if (valueAt != null) {
                    valueAt.S(null);
                    valueAt.t();
                }
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (int i = 0; i < size(); i++) {
                fj7 valueAt = valueAt(i);
                if (valueAt != null) {
                    valueAt.init();
                }
            }
        }
    }

    public void a(int i, fj7 fj7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, fj7Var) == null) {
            if (i > 100) {
                i = 100;
            }
            put(i, fj7Var);
        }
    }

    public fj7 c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i > 100) {
                i = 100;
            }
            return get(i);
        }
        return (fj7) invokeI.objValue;
    }

    public void e(jj7 jj7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jj7Var) == null) {
            for (int i = 0; i < size(); i++) {
                fj7 valueAt = valueAt(i);
                if (valueAt != null) {
                    valueAt.S(jj7Var);
                }
            }
        }
    }
}
