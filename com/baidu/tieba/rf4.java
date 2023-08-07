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
public class rf4 extends kf4<jx2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948119689, "Lcom/baidu/tieba/rf4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948119689, "Lcom/baidu/tieba/rf4;");
                return;
            }
        }
        boolean z = ir1.a;
    }

    public rf4() {
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

    public static rf4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new rf4();
        }
        return (rf4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kf4
    /* renamed from: d */
    public boolean b(Context context, jx2 jx2Var, hx2 hx2Var, ya3 ya3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jx2Var, hx2Var, ya3Var, jSONObject)) == null) {
            return f(context, jx2Var, hx2Var, ya3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, jx2 jx2Var, hx2 hx2Var, ya3 ya3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, jx2Var, hx2Var, ya3Var)) == null) {
            y72.i("map", "IncludePointsAction start");
            gx1 A = lw2.T().A(jx2Var.c);
            if (!(A instanceof ex1)) {
                y72.c("map", "WebViewManager is null");
                return false;
            }
            ig4 d = hf4.b().c((ex1) A).d(jx2Var.b);
            if (d == null) {
                y72.c("map", "can not find map by id " + jx2Var.b);
                return false;
            }
            y72.i("map", "IncludePointsAction end");
            return g(jx2Var, d);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(jx2 jx2Var, ig4 ig4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, jx2Var, ig4Var)) == null) {
            if (jx2Var == null || !jx2Var.isValid()) {
                return false;
            }
            BaiduMap map = ig4Var.l.getMap();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator<rx2> it = jx2Var.z.iterator();
            while (it.hasNext()) {
                rx2 next = it.next();
                builder.include(new LatLng(next.a, next.b));
            }
            LatLngBounds build = builder.build();
            int[] iArr = jx2Var.A;
            map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
