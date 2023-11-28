package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.ib4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class kb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements ib4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pa4 a;

        public a(pa4 pa4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pa4Var;
        }

        @Override // com.baidu.tieba.ib4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h32.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.ib4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.q(true);
                h32.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, rb4 rb4Var, ts2 ts2Var, pa4 pa4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, rb4Var, ts2Var, pa4Var) == null) {
            b(context, rb4Var, ts2Var, pa4Var, false);
        }
    }

    public static void b(Context context, rb4 rb4Var, ts2 ts2Var, pa4 pa4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, rb4Var, ts2Var, pa4Var, Boolean.valueOf(z)}) == null) {
            if (rb4Var != null && ts2Var != null && ts2Var.isValid()) {
                BaiduMap map = rb4Var.l.getMap();
                nb4 nb4Var = new nb4(rb4Var);
                map.setOnMapClickListener(nb4Var);
                map.setOnMarkerClickListener(nb4Var);
                map.setOnMapLoadedCallback(nb4Var);
                map.setOnMapRenderCallbadk(nb4Var);
                map.setOnMapStatusChangeListener(nb4Var);
                map.setOnMyLocationClickListener(nb4Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(ts2Var.t);
                uiSettings.setRotateGesturesEnabled(ts2Var.u);
                uiSettings.setZoomGesturesEnabled(ts2Var.s);
                rb4Var.l.showZoomControls(false);
                rb4Var.l.showScaleControl(false);
                map.setBuildingsEnabled(ts2Var.x);
                uiSettings.setOverlookingGesturesEnabled(ts2Var.w);
                at2 at2Var = ts2Var.j;
                if (at2Var != null && at2Var.isValid()) {
                    h32.i("map", "initMapView coordinate is " + ts2Var.j);
                    at2 at2Var2 = ts2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(at2Var2.a, at2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) ts2Var.k));
                h32.i("map", "initMapView scale is " + ts2Var.k);
                boolean z2 = ts2Var.r;
                rb4Var.k = z2;
                if (z2) {
                    c(context, pa4Var);
                } else {
                    pa4Var.q(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(ts2Var.v);
                lb4.e(AppRuntime.getAppContext(), ts2Var, rb4Var);
                lb4.d(ts2Var, rb4Var, nb4Var);
                return;
            }
            h32.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, pa4 pa4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, pa4Var) == null) {
            ib4.b(context, new a(pa4Var));
        }
    }
}
