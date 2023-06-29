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
public class vg4 extends og4<ny2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948239814, "Lcom/baidu/tieba/vg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948239814, "Lcom/baidu/tieba/vg4;");
                return;
            }
        }
        boolean z = ms1.a;
    }

    public vg4() {
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

    public static vg4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new vg4();
        }
        return (vg4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.og4
    /* renamed from: d */
    public boolean b(Context context, ny2 ny2Var, ly2 ly2Var, cc3 cc3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ny2Var, ly2Var, cc3Var, jSONObject)) == null) {
            return f(context, ny2Var, ly2Var, cc3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, ny2 ny2Var, ly2 ly2Var, cc3 cc3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, ny2Var, ly2Var, cc3Var)) == null) {
            c92.i("map", "IncludePointsAction start");
            ky1 A = px2.T().A(ny2Var.c);
            if (!(A instanceof iy1)) {
                c92.c("map", "WebViewManager is null");
                return false;
            }
            mh4 d = lg4.b().c((iy1) A).d(ny2Var.b);
            if (d == null) {
                c92.c("map", "can not find map by id " + ny2Var.b);
                return false;
            }
            c92.i("map", "IncludePointsAction end");
            return g(ny2Var, d);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(ny2 ny2Var, mh4 mh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, ny2Var, mh4Var)) == null) {
            if (ny2Var == null || !ny2Var.isValid()) {
                return false;
            }
            BaiduMap map = mh4Var.l.getMap();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator<vy2> it = ny2Var.z.iterator();
            while (it.hasNext()) {
                vy2 next = it.next();
                builder.include(new LatLng(next.a, next.b));
            }
            LatLngBounds build = builder.build();
            int[] iArr = ny2Var.A;
            map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
