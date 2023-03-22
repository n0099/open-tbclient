package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class mc4 extends fc4<eu2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947967851, "Lcom/baidu/tieba/mc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947967851, "Lcom/baidu/tieba/mc4;");
                return;
            }
        }
        boolean z = do1.a;
    }

    public mc4() {
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

    public static mc4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new mc4();
        }
        return (mc4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fc4
    /* renamed from: d */
    public boolean b(Context context, eu2 eu2Var, cu2 cu2Var, t73 t73Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, eu2Var, cu2Var, t73Var, jSONObject)) == null) {
            return f(context, eu2Var, cu2Var, t73Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, eu2 eu2Var, cu2 cu2Var, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, eu2Var, cu2Var, t73Var)) == null) {
            t42.i("map", "IncludePointsAction start");
            bu1 A = gt2.U().A(eu2Var.c);
            if (!(A instanceof zt1)) {
                t42.c("map", "WebViewManager is null");
                return false;
            }
            dd4 d = cc4.b().c((zt1) A).d(eu2Var.b);
            if (d == null) {
                t42.c("map", "can not find map by id " + eu2Var.b);
                return false;
            }
            t42.i("map", "IncludePointsAction end");
            return g(eu2Var, d);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(eu2 eu2Var, dd4 dd4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, eu2Var, dd4Var)) == null) {
            if (eu2Var == null || !eu2Var.isValid()) {
                return false;
            }
            BaiduMap map = dd4Var.l.getMap();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator<mu2> it = eu2Var.z.iterator();
            while (it.hasNext()) {
                mu2 next = it.next();
                builder.include(new LatLng(next.a, next.b));
            }
            LatLngBounds build = builder.build();
            int[] iArr = eu2Var.A;
            map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
