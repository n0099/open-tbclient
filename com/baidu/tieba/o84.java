package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.m84;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class o84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements m84.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t74 a;

        public a(t74 t74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t74Var;
        }

        @Override // com.baidu.tieba.m84.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l02.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.m84.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                l02.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, v84 v84Var, xp2 xp2Var, t74 t74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, v84Var, xp2Var, t74Var) == null) {
            b(context, v84Var, xp2Var, t74Var, false);
        }
    }

    public static void b(Context context, v84 v84Var, xp2 xp2Var, t74 t74Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, v84Var, xp2Var, t74Var, Boolean.valueOf(z)}) == null) {
            if (v84Var != null && xp2Var != null && xp2Var.isValid()) {
                BaiduMap map = v84Var.l.getMap();
                r84 r84Var = new r84(v84Var);
                map.setOnMapClickListener(r84Var);
                map.setOnMarkerClickListener(r84Var);
                map.setOnMapLoadedCallback(r84Var);
                map.setOnMapRenderCallbadk(r84Var);
                map.setOnMapStatusChangeListener(r84Var);
                map.setOnMyLocationClickListener(r84Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(xp2Var.t);
                uiSettings.setRotateGesturesEnabled(xp2Var.u);
                uiSettings.setZoomGesturesEnabled(xp2Var.s);
                v84Var.l.showZoomControls(false);
                v84Var.l.showScaleControl(false);
                map.setBuildingsEnabled(xp2Var.x);
                uiSettings.setOverlookingGesturesEnabled(xp2Var.w);
                eq2 eq2Var = xp2Var.j;
                if (eq2Var != null && eq2Var.isValid()) {
                    l02.i("map", "initMapView coordinate is " + xp2Var.j);
                    eq2 eq2Var2 = xp2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(eq2Var2.a, eq2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) xp2Var.k));
                l02.i("map", "initMapView scale is " + xp2Var.k);
                boolean z2 = xp2Var.r;
                v84Var.k = z2;
                if (z2) {
                    c(context, t74Var);
                } else {
                    t74Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(xp2Var.v);
                p84.e(AppRuntime.getAppContext(), xp2Var, v84Var);
                p84.d(xp2Var, v84Var, r84Var);
                return;
            }
            l02.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, t74 t74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, t74Var) == null) {
            m84.b(context, new a(t74Var));
        }
    }
}
