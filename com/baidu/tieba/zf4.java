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
/* loaded from: classes9.dex */
public class zf4 extends sf4<rx2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948358017, "Lcom/baidu/tieba/zf4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948358017, "Lcom/baidu/tieba/zf4;");
                return;
            }
        }
        boolean z = qr1.a;
    }

    public zf4() {
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

    public static zf4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new zf4();
        }
        return (zf4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sf4
    /* renamed from: d */
    public boolean b(Context context, rx2 rx2Var, px2 px2Var, gb3 gb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, rx2Var, px2Var, gb3Var, jSONObject)) == null) {
            return f(context, rx2Var, px2Var, gb3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, rx2 rx2Var, px2 px2Var, gb3 gb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, rx2Var, px2Var, gb3Var)) == null) {
            g82.i("map", "IncludePointsAction start");
            ox1 A = tw2.T().A(rx2Var.c);
            if (!(A instanceof mx1)) {
                g82.c("map", "WebViewManager is null");
                return false;
            }
            qg4 d = pf4.b().c((mx1) A).d(rx2Var.b);
            if (d == null) {
                g82.c("map", "can not find map by id " + rx2Var.b);
                return false;
            }
            g82.i("map", "IncludePointsAction end");
            return g(rx2Var, d);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(rx2 rx2Var, qg4 qg4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, rx2Var, qg4Var)) == null) {
            if (rx2Var == null || !rx2Var.isValid()) {
                return false;
            }
            BaiduMap map = qg4Var.l.getMap();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator<zx2> it = rx2Var.z.iterator();
            while (it.hasNext()) {
                zx2 next = it.next();
                builder.include(new LatLng(next.a, next.b));
            }
            LatLngBounds build = builder.build();
            int[] iArr = rx2Var.A;
            map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
