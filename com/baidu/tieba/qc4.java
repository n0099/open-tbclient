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
public class qc4 extends jc4<iu2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948087015, "Lcom/baidu/tieba/qc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948087015, "Lcom/baidu/tieba/qc4;");
                return;
            }
        }
        boolean z = ho1.a;
    }

    public qc4() {
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

    public static qc4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new qc4();
        }
        return (qc4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jc4
    /* renamed from: d */
    public boolean b(Context context, iu2 iu2Var, gu2 gu2Var, x73 x73Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, iu2Var, gu2Var, x73Var, jSONObject)) == null) {
            return f(context, iu2Var, gu2Var, x73Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, iu2 iu2Var, gu2 gu2Var, x73 x73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, iu2Var, gu2Var, x73Var)) == null) {
            x42.i("map", "IncludePointsAction start");
            fu1 A = kt2.U().A(iu2Var.c);
            if (!(A instanceof du1)) {
                x42.c("map", "WebViewManager is null");
                return false;
            }
            hd4 d = gc4.b().c((du1) A).d(iu2Var.b);
            if (d == null) {
                x42.c("map", "can not find map by id " + iu2Var.b);
                return false;
            }
            x42.i("map", "IncludePointsAction end");
            return g(iu2Var, d);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(iu2 iu2Var, hd4 hd4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, iu2Var, hd4Var)) == null) {
            if (iu2Var == null || !iu2Var.isValid()) {
                return false;
            }
            BaiduMap map = hd4Var.l.getMap();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator<qu2> it = iu2Var.z.iterator();
            while (it.hasNext()) {
                qu2 next = it.next();
                builder.include(new LatLng(next.a, next.b));
            }
            LatLngBounds build = builder.build();
            int[] iArr = iu2Var.A;
            map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
