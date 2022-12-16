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
/* loaded from: classes6.dex */
public class x84 extends q84<pq2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948254229, "Lcom/baidu/tieba/x84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948254229, "Lcom/baidu/tieba/x84;");
                return;
            }
        }
        boolean z = ok1.a;
    }

    public x84() {
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

    public static x84 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new x84();
        }
        return (x84) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.q84
    /* renamed from: d */
    public boolean b(Context context, pq2 pq2Var, nq2 nq2Var, e43 e43Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, pq2Var, nq2Var, e43Var, jSONObject)) == null) {
            return f(context, pq2Var, nq2Var, e43Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, pq2 pq2Var, nq2 nq2Var, e43 e43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, pq2Var, nq2Var, e43Var)) == null) {
            e12.i("map", "IncludePointsAction start");
            mq1 A = rp2.U().A(pq2Var.c);
            if (!(A instanceof kq1)) {
                e12.c("map", "WebViewManager is null");
                return false;
            }
            o94 d = n84.b().c((kq1) A).d(pq2Var.b);
            if (d == null) {
                e12.c("map", "can not find map by id " + pq2Var.b);
                return false;
            }
            e12.i("map", "IncludePointsAction end");
            return g(pq2Var, d);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(pq2 pq2Var, o94 o94Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, pq2Var, o94Var)) == null) {
            if (pq2Var == null || !pq2Var.isValid()) {
                return false;
            }
            BaiduMap map = o94Var.l.getMap();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator<xq2> it = pq2Var.z.iterator();
            while (it.hasNext()) {
                xq2 next = it.next();
                builder.include(new LatLng(next.a, next.b));
            }
            LatLngBounds build = builder.build();
            int[] iArr = pq2Var.A;
            map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
