package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.vv2;
import com.baidu.tieba.wg4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class pg4 extends hg4<hy2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements wg4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ fh4 b;
        public final /* synthetic */ dg4 c;
        public final /* synthetic */ pg4 d;

        public a(pg4 pg4Var, Context context, fh4 fh4Var, dg4 dg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pg4Var, context, fh4Var, dg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = pg4Var;
            this.a = context;
            this.b = fh4Var;
            this.c = dg4Var;
        }

        @Override // com.baidu.tieba.wg4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                v82.o("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.wg4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                v82.o("map", "location permission success");
                this.d.e(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements vv2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fh4 a;
        public final /* synthetic */ dg4 b;

        public b(pg4 pg4Var, fh4 fh4Var, dg4 dg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pg4Var, fh4Var, dg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fh4Var;
            this.b = dg4Var;
        }

        @Override // com.baidu.tieba.vv2.a
        public void a(ue3 ue3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ue3Var) == null) {
                v82.i("map", "get location " + ue3Var.a().toString());
                BaiduMap map = this.a.l.getMap();
                map.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(ue3Var.c, ue3Var.b)));
                map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                map.setMyLocationEnabled(true);
                map.setMyLocationData(new MyLocationData.Builder().accuracy((float) ue3Var.e).latitude(ue3Var.c).longitude(ue3Var.b).build());
                this.b.p(true);
            }
        }

        @Override // com.baidu.tieba.vv2.a
        public void onFailed(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                v82.i("map", "get location error " + i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948061068, "Lcom/baidu/tieba/pg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948061068, "Lcom/baidu/tieba/pg4;");
                return;
            }
        }
        boolean z = fs1.a;
    }

    public pg4() {
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

    public static pg4 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new pg4();
        }
        return (pg4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hg4
    public boolean b(Context context, hy2 hy2Var, ey2 ey2Var, vb3 vb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, hy2Var, ey2Var, vb3Var, jSONObject)) == null) {
            return g(context, hy2Var, ey2Var, vb3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final void e(Context context, fh4 fh4Var, dg4 dg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, fh4Var, dg4Var) == null) {
            cv2.I().b("gcj02", true, false, new b(this, fh4Var, dg4Var));
        }
    }

    public final boolean g(Context context, hy2 hy2Var, ey2 ey2Var, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, hy2Var, ey2Var, vb3Var)) == null) {
            v82.i("map", "MoveToLocationAction start");
            dy1 A = ix2.T().A(hy2Var.c);
            if (!(A instanceof by1)) {
                v82.c("map", "WebViewManager is null");
                return false;
            }
            dg4 c = eg4.b().c((by1) A);
            fh4 d = c.d(hy2Var.b);
            if (d == null) {
                v82.c("map", "can not find map by id " + hy2Var.b);
                return false;
            } else if (!d.k) {
                v82.o("map", "can not move to location because showLocation is not set");
                return false;
            } else {
                BDLocation e = c.e();
                if (e != null && c.g()) {
                    d.l.getMap().animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(e.getLatitude(), e.getLongitude())));
                    d.l.getMap().setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    d.l.getMap().setMyLocationEnabled(true);
                    d.l.getMap().setMyLocationData(new MyLocationData.Builder().accuracy(e.getRadius()).latitude(e.getLatitude()).longitude(e.getLongitude()).build());
                    v82.i("map", "MoveToLocationAction end");
                    return true;
                }
                wg4.b(context, new a(this, context, d, c));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
