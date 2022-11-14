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
public class y84 extends r84<qq2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948284020, "Lcom/baidu/tieba/y84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948284020, "Lcom/baidu/tieba/y84;");
                return;
            }
        }
        boolean z = pk1.a;
    }

    public y84() {
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

    public static y84 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new y84();
        }
        return (y84) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.r84
    /* renamed from: d */
    public boolean b(Context context, qq2 qq2Var, oq2 oq2Var, f43 f43Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, qq2Var, oq2Var, f43Var, jSONObject)) == null) {
            return f(context, qq2Var, oq2Var, f43Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, qq2 qq2Var, oq2 oq2Var, f43 f43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, qq2Var, oq2Var, f43Var)) == null) {
            f12.i("map", "IncludePointsAction start");
            nq1 A = sp2.U().A(qq2Var.c);
            if (!(A instanceof lq1)) {
                f12.c("map", "WebViewManager is null");
                return false;
            }
            p94 d = o84.b().c((lq1) A).d(qq2Var.b);
            if (d == null) {
                f12.c("map", "can not find map by id " + qq2Var.b);
                return false;
            }
            f12.i("map", "IncludePointsAction end");
            return g(qq2Var, d);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(qq2 qq2Var, p94 p94Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, qq2Var, p94Var)) == null) {
            if (qq2Var == null || !qq2Var.isValid()) {
                return false;
            }
            BaiduMap map = p94Var.l.getMap();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator<yq2> it = qq2Var.z.iterator();
            while (it.hasNext()) {
                yq2 next = it.next();
                builder.include(new LatLng(next.a, next.b));
            }
            LatLngBounds build = builder.build();
            int[] iArr = qq2Var.A;
            map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
