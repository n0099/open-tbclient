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
/* loaded from: classes8.dex */
public class wha implements tha {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<tha> a;
    public static final tha b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948271961, "Lcom/baidu/tieba/wha;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948271961, "Lcom/baidu/tieba/wha;");
                return;
            }
        }
        a = new AtomicReference<>(null);
        b = new wha();
    }

    public wha() {
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

    public static tha m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            tha thaVar = a.get();
            if (thaVar == null) {
                return b;
            }
            return thaVar;
        }
        return (tha) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tha
    public oha b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (oha) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tha
    public jha d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (jha) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tha
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            BdLog.e("recapp plugin install failed!");
        }
    }

    @Override // com.baidu.tieba.tha
    public List<AdvertAppInfo> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tha
    public qha j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (qha) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tha
    public ci<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, baseFragmentActivity, bdUniqueId)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (ci) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.tha
    public ci<?, ?> e(sha shaVar, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, shaVar, bdUniqueId)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (ci) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.tha
    public IAdBaseAsyncController i(IAdBaseAsyncController.Type type, IAdBaseAsyncController.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, type, aVar)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (IAdBaseAsyncController) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.tha
    public void l(HashMap<String, String> hashMap, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, hashMap, context) == null) {
            BdLog.e("recapp plugin install failed!");
        }
    }

    @Override // com.baidu.tieba.tha
    public void c(AdvertAppInfo advertAppInfo, mg9<?> mg9Var, String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{advertAppInfo, mg9Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            BdLog.e("recapp plugin install failed!");
        }
    }

    @Override // com.baidu.tieba.tha
    public ci<?, ?> h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, tbPageContext, bdUniqueId, str)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (ci) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.tha
    public void k(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, advertAppInfo) == null) {
            BdLog.e("recapp plugin install failed!");
        }
    }
}
