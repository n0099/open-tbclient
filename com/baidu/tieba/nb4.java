package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.lb4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class nb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements lb4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sa4 a;

        public a(sa4 sa4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sa4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sa4Var;
        }

        @Override // com.baidu.tieba.lb4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k32.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.lb4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.q(true);
                k32.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, ub4 ub4Var, ws2 ws2Var, sa4 sa4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, ub4Var, ws2Var, sa4Var) == null) {
            b(context, ub4Var, ws2Var, sa4Var, false);
        }
    }

    public static void b(Context context, ub4 ub4Var, ws2 ws2Var, sa4 sa4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, ub4Var, ws2Var, sa4Var, Boolean.valueOf(z)}) == null) {
            if (ub4Var != null && ws2Var != null && ws2Var.isValid()) {
                BaiduMap map = ub4Var.l.getMap();
                qb4 qb4Var = new qb4(ub4Var);
                map.setOnMapClickListener(qb4Var);
                map.setOnMarkerClickListener(qb4Var);
                map.setOnMapLoadedCallback(qb4Var);
                map.setOnMapRenderCallbadk(qb4Var);
                map.setOnMapStatusChangeListener(qb4Var);
                map.setOnMyLocationClickListener(qb4Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(ws2Var.t);
                uiSettings.setRotateGesturesEnabled(ws2Var.u);
                uiSettings.setZoomGesturesEnabled(ws2Var.s);
                ub4Var.l.showZoomControls(false);
                ub4Var.l.showScaleControl(false);
                map.setBuildingsEnabled(ws2Var.x);
                uiSettings.setOverlookingGesturesEnabled(ws2Var.w);
                dt2 dt2Var = ws2Var.j;
                if (dt2Var != null && dt2Var.isValid()) {
                    k32.i("map", "initMapView coordinate is " + ws2Var.j);
                    dt2 dt2Var2 = ws2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(dt2Var2.a, dt2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) ws2Var.k));
                k32.i("map", "initMapView scale is " + ws2Var.k);
                boolean z2 = ws2Var.r;
                ub4Var.k = z2;
                if (z2) {
                    c(context, sa4Var);
                } else {
                    sa4Var.q(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(ws2Var.v);
                ob4.e(AppRuntime.getAppContext(), ws2Var, ub4Var);
                ob4.d(ws2Var, ub4Var, qb4Var);
                return;
            }
            k32.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, sa4 sa4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, sa4Var) == null) {
            lb4.b(context, new a(sa4Var));
        }
    }
}
