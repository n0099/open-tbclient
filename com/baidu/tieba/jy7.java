package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public class jy7 implements ly7 {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<ly7> a;
    public static final ly7 b;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ly7
    public pm<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, baseFragmentActivity, bdUniqueId)) == null) {
            return null;
        }
        return (pm) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ly7
    public pm<?, ?> c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, baseFragmentActivity, bdUniqueId)) == null) {
            return null;
        }
        return (pm) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ly7
    public pm<?, ?> d(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, baseFragmentActivity, bdUniqueId)) == null) {
            return null;
        }
        return (pm) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ly7
    public void e(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
        }
    }

    @Override // com.baidu.tieba.ly7
    public void f(@NonNull View view2, @Nullable rha rhaVar, @NonNull BdUniqueId bdUniqueId, String str, String str2, String str3, String str4, int i, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{view2, rhaVar, bdUniqueId, str, str2, str3, str4, Integer.valueOf(i), onClickListener}) == null) {
        }
    }

    @Override // com.baidu.tieba.ly7
    public pm<?, ?> g(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, baseFragmentActivity, bdUniqueId, str)) == null) {
            return null;
        }
        return (pm) invokeLLL.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947899713, "Lcom/baidu/tieba/jy7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947899713, "Lcom/baidu/tieba/jy7;");
                return;
            }
        }
        a = new AtomicReference<>(null);
        b = new jy7();
    }

    public jy7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ly7 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ly7 ly7Var = a.get();
            if (ly7Var == null) {
                return b;
            }
            return ly7Var;
        }
        return (ly7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ly7
    public View b(@NonNull Context context, @NonNull BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bdUniqueId)) == null) {
            return new View(context);
        }
        return (View) invokeLL.objValue;
    }
}
