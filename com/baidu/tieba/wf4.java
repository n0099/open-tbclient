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
/* loaded from: classes8.dex */
public class wf4 extends pf4<ox2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948268644, "Lcom/baidu/tieba/wf4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948268644, "Lcom/baidu/tieba/wf4;");
                return;
            }
        }
        boolean z = nr1.a;
    }

    public wf4() {
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

    public static wf4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new wf4();
        }
        return (wf4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pf4
    /* renamed from: d */
    public boolean b(Context context, ox2 ox2Var, mx2 mx2Var, db3 db3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ox2Var, mx2Var, db3Var, jSONObject)) == null) {
            return f(context, ox2Var, mx2Var, db3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, ox2 ox2Var, mx2 mx2Var, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, ox2Var, mx2Var, db3Var)) == null) {
            d82.i("map", "IncludePointsAction start");
            lx1 A = qw2.T().A(ox2Var.c);
            if (!(A instanceof jx1)) {
                d82.c("map", "WebViewManager is null");
                return false;
            }
            ng4 d = mf4.b().c((jx1) A).d(ox2Var.b);
            if (d == null) {
                d82.c("map", "can not find map by id " + ox2Var.b);
                return false;
            }
            d82.i("map", "IncludePointsAction end");
            return g(ox2Var, d);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(ox2 ox2Var, ng4 ng4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, ox2Var, ng4Var)) == null) {
            if (ox2Var == null || !ox2Var.isValid()) {
                return false;
            }
            BaiduMap map = ng4Var.l.getMap();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator<wx2> it = ox2Var.z.iterator();
            while (it.hasNext()) {
                wx2 next = it.next();
                builder.include(new LatLng(next.a, next.b));
            }
            LatLngBounds build = builder.build();
            int[] iArr = ox2Var.A;
            map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
