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
public class og4 extends hg4<gy2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948031277, "Lcom/baidu/tieba/og4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948031277, "Lcom/baidu/tieba/og4;");
                return;
            }
        }
        boolean z = fs1.a;
    }

    public og4() {
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

    public static og4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new og4();
        }
        return (og4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hg4
    /* renamed from: d */
    public boolean b(Context context, gy2 gy2Var, ey2 ey2Var, vb3 vb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, gy2Var, ey2Var, vb3Var, jSONObject)) == null) {
            return f(context, gy2Var, ey2Var, vb3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, gy2 gy2Var, ey2 ey2Var, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, gy2Var, ey2Var, vb3Var)) == null) {
            v82.i("map", "IncludePointsAction start");
            dy1 A = ix2.T().A(gy2Var.c);
            if (!(A instanceof by1)) {
                v82.c("map", "WebViewManager is null");
                return false;
            }
            fh4 d = eg4.b().c((by1) A).d(gy2Var.b);
            if (d == null) {
                v82.c("map", "can not find map by id " + gy2Var.b);
                return false;
            }
            v82.i("map", "IncludePointsAction end");
            return g(gy2Var, d);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(gy2 gy2Var, fh4 fh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, gy2Var, fh4Var)) == null) {
            if (gy2Var == null || !gy2Var.isValid()) {
                return false;
            }
            BaiduMap map = fh4Var.l.getMap();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator<oy2> it = gy2Var.z.iterator();
            while (it.hasNext()) {
                oy2 next = it.next();
                builder.include(new LatLng(next.a, next.b));
            }
            LatLngBounds build = builder.build();
            int[] iArr = gy2Var.A;
            map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
