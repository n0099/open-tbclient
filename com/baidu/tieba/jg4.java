package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.hg4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jg4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements hg4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ of4 a;

        public a(of4 of4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {of4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = of4Var;
        }

        @Override // com.baidu.tieba.hg4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g82.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.hg4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                g82.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, qg4 qg4Var, sx2 sx2Var, of4 of4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, qg4Var, sx2Var, of4Var) == null) {
            b(context, qg4Var, sx2Var, of4Var, false);
        }
    }

    public static void b(Context context, qg4 qg4Var, sx2 sx2Var, of4 of4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, qg4Var, sx2Var, of4Var, Boolean.valueOf(z)}) == null) {
            if (qg4Var != null && sx2Var != null && sx2Var.isValid()) {
                BaiduMap map = qg4Var.l.getMap();
                mg4 mg4Var = new mg4(qg4Var);
                map.setOnMapClickListener(mg4Var);
                map.setOnMarkerClickListener(mg4Var);
                map.setOnMapLoadedCallback(mg4Var);
                map.setOnMapRenderCallbadk(mg4Var);
                map.setOnMapStatusChangeListener(mg4Var);
                map.setOnMyLocationClickListener(mg4Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(sx2Var.t);
                uiSettings.setRotateGesturesEnabled(sx2Var.u);
                uiSettings.setZoomGesturesEnabled(sx2Var.s);
                qg4Var.l.showZoomControls(false);
                qg4Var.l.showScaleControl(false);
                map.setBuildingsEnabled(sx2Var.x);
                uiSettings.setOverlookingGesturesEnabled(sx2Var.w);
                zx2 zx2Var = sx2Var.j;
                if (zx2Var != null && zx2Var.isValid()) {
                    g82.i("map", "initMapView coordinate is " + sx2Var.j);
                    zx2 zx2Var2 = sx2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(zx2Var2.a, zx2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) sx2Var.k));
                g82.i("map", "initMapView scale is " + sx2Var.k);
                boolean z2 = sx2Var.r;
                qg4Var.k = z2;
                if (z2) {
                    c(context, of4Var);
                } else {
                    of4Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(sx2Var.v);
                kg4.e(AppRuntime.getAppContext(), sx2Var, qg4Var);
                kg4.d(sx2Var, qg4Var, mg4Var);
                return;
            }
            g82.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, of4 of4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, of4Var) == null) {
            hg4.b(context, new a(of4Var));
        }
    }
}
