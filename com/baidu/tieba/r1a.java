package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public class r1a implements o1a {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<o1a> a;
    public static final o1a b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948070151, "Lcom/baidu/tieba/r1a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948070151, "Lcom/baidu/tieba/r1a;");
                return;
            }
        }
        a = new AtomicReference<>(null);
        b = new r1a();
    }

    public r1a() {
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

    public static o1a m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            o1a o1aVar = a.get();
            if (o1aVar == null) {
                return b;
            }
            return o1aVar;
        }
        return (o1a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.o1a
    public j1a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (j1a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.o1a
    public e1a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (e1a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.o1a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            BdLog.e("recapp plugin install failed!");
        }
    }

    @Override // com.baidu.tieba.o1a
    public List<AdvertAppInfo> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.o1a
    public l1a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (l1a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.o1a
    public om<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, baseFragmentActivity, bdUniqueId)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (om) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.o1a
    public om<?, ?> e(n1a n1aVar, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, n1aVar, bdUniqueId)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (om) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.o1a
    public IAdBaseAsyncController i(IAdBaseAsyncController.Type type, IAdBaseAsyncController.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, type, aVar)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (IAdBaseAsyncController) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.o1a
    public void l(HashMap<String, String> hashMap, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, hashMap, context) == null) {
            BdLog.e("recapp plugin install failed!");
        }
    }

    @Override // com.baidu.tieba.o1a
    public void c(AdvertAppInfo advertAppInfo, o29<?> o29Var, String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{advertAppInfo, o29Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            BdLog.e("recapp plugin install failed!");
        }
    }

    @Override // com.baidu.tieba.o1a
    public om<?, ?> h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, tbPageContext, bdUniqueId, str)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (om) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.o1a
    public void k(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, advertAppInfo) == null) {
            BdLog.e("recapp plugin install failed!");
        }
    }
}
