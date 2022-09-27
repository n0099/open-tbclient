package com.baidu.tieba;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class zh6 extends SparseArray<ji6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;

    public zh6() {
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

    public void a(int i, ji6 ji6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, ji6Var) == null) {
            if (i > 100) {
                i = 100;
            }
            put(i, ji6Var);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i = 0; i < size(); i++) {
                ji6 valueAt = valueAt(i);
                if (valueAt != null) {
                    valueAt.w(null);
                    valueAt.j();
                }
            }
        }
    }

    public ji6 c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i > 100) {
                i = 100;
            }
            return get(i);
        }
        return (ji6) invokeI.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (int i = 0; i < size(); i++) {
                ji6 valueAt = valueAt(i);
                if (valueAt != null) {
                    valueAt.init();
                }
            }
        }
    }

    public void e(ni6 ni6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ni6Var) == null) {
            for (int i = 0; i < size(); i++) {
                ji6 valueAt = valueAt(i);
                if (valueAt != null) {
                    valueAt.w(ni6Var);
                }
            }
        }
    }
}
