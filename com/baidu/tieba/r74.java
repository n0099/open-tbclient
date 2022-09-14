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
public class r74 extends k74<jp2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948074522, "Lcom/baidu/tieba/r74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948074522, "Lcom/baidu/tieba/r74;");
                return;
            }
        }
        boolean z = ij1.a;
    }

    public r74() {
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

    public static r74 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new r74() : (r74) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.k74
    /* renamed from: d */
    public boolean b(Context context, jp2 jp2Var, hp2 hp2Var, y23 y23Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jp2Var, hp2Var, y23Var, jSONObject)) == null) ? f(context, jp2Var, hp2Var, y23Var) : invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, jp2 jp2Var, hp2 hp2Var, y23 y23Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, jp2Var, hp2Var, y23Var)) == null) {
            yz1.i("map", "IncludePointsAction start");
            gp1 A = lo2.U().A(jp2Var.c);
            if (!(A instanceof ep1)) {
                yz1.c("map", "WebViewManager is null");
                return false;
            }
            i84 d = h74.b().c((ep1) A).d(jp2Var.b);
            if (d == null) {
                yz1.c("map", "can not find map by id " + jp2Var.b);
                return false;
            }
            yz1.i("map", "IncludePointsAction end");
            return g(jp2Var, d);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(jp2 jp2Var, i84 i84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, jp2Var, i84Var)) == null) {
            if (jp2Var == null || !jp2Var.isValid()) {
                return false;
            }
            BaiduMap map = i84Var.l.getMap();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator<rp2> it = jp2Var.z.iterator();
            while (it.hasNext()) {
                rp2 next = it.next();
                builder.include(new LatLng(next.a, next.b));
            }
            LatLngBounds build = builder.build();
            int[] iArr = jp2Var.A;
            map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
