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
/* loaded from: classes6.dex */
public class jm9 implements gm9 {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<gm9> a;
    public static final gm9 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947888243, "Lcom/baidu/tieba/jm9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947888243, "Lcom/baidu/tieba/jm9;");
                return;
            }
        }
        a = new AtomicReference<>(null);
        b = new jm9();
    }

    public jm9() {
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

    public static gm9 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            gm9 gm9Var = a.get();
            if (gm9Var == null) {
                return b;
            }
            return gm9Var;
        }
        return (gm9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gm9
    public bm9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (bm9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gm9
    public wl9 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (wl9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gm9
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            BdLog.e("recapp plugin install failed!");
        }
    }

    @Override // com.baidu.tieba.gm9
    public List<AdvertAppInfo> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gm9
    public dm9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (dm9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gm9
    public in<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, baseFragmentActivity, bdUniqueId)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (in) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.gm9
    public in<?, ?> d(fm9 fm9Var, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, fm9Var, bdUniqueId)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (in) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.gm9
    public IAdBaseAsyncController h(IAdBaseAsyncController.Type type, IAdBaseAsyncController.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, type, aVar)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (IAdBaseAsyncController) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.gm9
    public void k(HashMap<String, String> hashMap, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, hashMap, context) == null) {
            BdLog.e("recapp plugin install failed!");
        }
    }

    @Override // com.baidu.tieba.gm9
    public in<?, ?> g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, tbPageContext, bdUniqueId, str)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (in) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.gm9
    public void j(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, advertAppInfo) == null) {
            BdLog.e("recapp plugin install failed!");
        }
    }
}
