package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.wg4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class yg4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements wg4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dg4 a;

        public a(dg4 dg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dg4Var;
        }

        @Override // com.baidu.tieba.wg4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                v82.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.wg4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                v82.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, fh4 fh4Var, hy2 hy2Var, dg4 dg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, fh4Var, hy2Var, dg4Var) == null) {
            b(context, fh4Var, hy2Var, dg4Var, false);
        }
    }

    public static void b(Context context, fh4 fh4Var, hy2 hy2Var, dg4 dg4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, fh4Var, hy2Var, dg4Var, Boolean.valueOf(z)}) == null) {
            if (fh4Var != null && hy2Var != null && hy2Var.isValid()) {
                BaiduMap map = fh4Var.l.getMap();
                bh4 bh4Var = new bh4(fh4Var);
                map.setOnMapClickListener(bh4Var);
                map.setOnMarkerClickListener(bh4Var);
                map.setOnMapLoadedCallback(bh4Var);
                map.setOnMapRenderCallbadk(bh4Var);
                map.setOnMapStatusChangeListener(bh4Var);
                map.setOnMyLocationClickListener(bh4Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(hy2Var.t);
                uiSettings.setRotateGesturesEnabled(hy2Var.u);
                uiSettings.setZoomGesturesEnabled(hy2Var.s);
                fh4Var.l.showZoomControls(false);
                fh4Var.l.showScaleControl(false);
                map.setBuildingsEnabled(hy2Var.x);
                uiSettings.setOverlookingGesturesEnabled(hy2Var.w);
                oy2 oy2Var = hy2Var.j;
                if (oy2Var != null && oy2Var.isValid()) {
                    v82.i("map", "initMapView coordinate is " + hy2Var.j);
                    oy2 oy2Var2 = hy2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(oy2Var2.a, oy2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) hy2Var.k));
                v82.i("map", "initMapView scale is " + hy2Var.k);
                boolean z2 = hy2Var.r;
                fh4Var.k = z2;
                if (z2) {
                    c(context, dg4Var);
                } else {
                    dg4Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(hy2Var.v);
                zg4.e(AppRuntime.getAppContext(), hy2Var, fh4Var);
                zg4.d(hy2Var, fh4Var, bh4Var);
                return;
            }
            v82.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, dg4 dg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, dg4Var) == null) {
            wg4.b(context, new a(dg4Var));
        }
    }
}
