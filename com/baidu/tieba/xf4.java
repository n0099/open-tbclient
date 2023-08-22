package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.dv2;
import com.baidu.tieba.eg4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class xf4 extends pf4<px2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements eg4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ ng4 b;
        public final /* synthetic */ lf4 c;
        public final /* synthetic */ xf4 d;

        public a(xf4 xf4Var, Context context, ng4 ng4Var, lf4 lf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf4Var, context, ng4Var, lf4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = xf4Var;
            this.a = context;
            this.b = ng4Var;
            this.c = lf4Var;
        }

        @Override // com.baidu.tieba.eg4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d82.o("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.eg4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d82.o("map", "location permission success");
                this.d.e(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements dv2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ng4 a;
        public final /* synthetic */ lf4 b;

        public b(xf4 xf4Var, ng4 ng4Var, lf4 lf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf4Var, ng4Var, lf4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ng4Var;
            this.b = lf4Var;
        }

        @Override // com.baidu.tieba.dv2.a
        public void a(ce3 ce3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ce3Var) == null) {
                d82.i("map", "get location " + ce3Var.a().toString());
                BaiduMap map = this.a.l.getMap();
                map.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(ce3Var.c, ce3Var.b)));
                map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                map.setMyLocationEnabled(true);
                map.setMyLocationData(new MyLocationData.Builder().accuracy((float) ce3Var.e).latitude(ce3Var.c).longitude(ce3Var.b).build());
                this.b.p(true);
            }
        }

        @Override // com.baidu.tieba.dv2.a
        public void onFailed(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                d82.i("map", "get location error " + i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948298435, "Lcom/baidu/tieba/xf4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948298435, "Lcom/baidu/tieba/xf4;");
                return;
            }
        }
        boolean z = nr1.a;
    }

    public xf4() {
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

    public static xf4 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new xf4();
        }
        return (xf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pf4
    public boolean b(Context context, px2 px2Var, mx2 mx2Var, db3 db3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, px2Var, mx2Var, db3Var, jSONObject)) == null) {
            return g(context, px2Var, mx2Var, db3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final void e(Context context, ng4 ng4Var, lf4 lf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ng4Var, lf4Var) == null) {
            ku2.I().b("gcj02", true, false, new b(this, ng4Var, lf4Var));
        }
    }

    public final boolean g(Context context, px2 px2Var, mx2 mx2Var, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, px2Var, mx2Var, db3Var)) == null) {
            d82.i("map", "MoveToLocationAction start");
            lx1 A = qw2.T().A(px2Var.c);
            if (!(A instanceof jx1)) {
                d82.c("map", "WebViewManager is null");
                return false;
            }
            lf4 c = mf4.b().c((jx1) A);
            ng4 d = c.d(px2Var.b);
            if (d == null) {
                d82.c("map", "can not find map by id " + px2Var.b);
                return false;
            } else if (!d.k) {
                d82.o("map", "can not move to location because showLocation is not set");
                return false;
            } else {
                BDLocation e = c.e();
                if (e != null && c.g()) {
                    d.l.getMap().animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(e.getLatitude(), e.getLongitude())));
                    d.l.getMap().setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    d.l.getMap().setMyLocationEnabled(true);
                    d.l.getMap().setMyLocationData(new MyLocationData.Builder().accuracy(e.getRadius()).latitude(e.getLatitude()).longitude(e.getLongitude()).build());
                    d82.i("map", "MoveToLocationAction end");
                    return true;
                }
                eg4.b(context, new a(this, context, d, c));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
