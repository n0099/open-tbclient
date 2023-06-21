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
/* loaded from: classes7.dex */
public class sg4 extends lg4<ky2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948150441, "Lcom/baidu/tieba/sg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948150441, "Lcom/baidu/tieba/sg4;");
                return;
            }
        }
        boolean z = js1.a;
    }

    public sg4() {
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

    public static sg4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new sg4();
        }
        return (sg4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lg4
    /* renamed from: d */
    public boolean b(Context context, ky2 ky2Var, iy2 iy2Var, zb3 zb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ky2Var, iy2Var, zb3Var, jSONObject)) == null) {
            return f(context, ky2Var, iy2Var, zb3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, ky2 ky2Var, iy2 iy2Var, zb3 zb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, ky2Var, iy2Var, zb3Var)) == null) {
            z82.i("map", "IncludePointsAction start");
            hy1 A = mx2.T().A(ky2Var.c);
            if (!(A instanceof fy1)) {
                z82.c("map", "WebViewManager is null");
                return false;
            }
            jh4 d = ig4.b().c((fy1) A).d(ky2Var.b);
            if (d == null) {
                z82.c("map", "can not find map by id " + ky2Var.b);
                return false;
            }
            z82.i("map", "IncludePointsAction end");
            return g(ky2Var, d);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(ky2 ky2Var, jh4 jh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, ky2Var, jh4Var)) == null) {
            if (ky2Var == null || !ky2Var.isValid()) {
                return false;
            }
            BaiduMap map = jh4Var.l.getMap();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator<sy2> it = ky2Var.z.iterator();
            while (it.hasNext()) {
                sy2 next = it.next();
                builder.include(new LatLng(next.a, next.b));
            }
            LatLngBounds build = builder.build();
            int[] iArr = ky2Var.A;
            map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
