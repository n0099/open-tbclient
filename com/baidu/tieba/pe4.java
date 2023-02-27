package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.ne4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class pe4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements ne4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ud4 a;

        public a(ud4 ud4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ud4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ud4Var;
        }

        @Override // com.baidu.tieba.ne4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m62.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.ne4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                m62.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, we4 we4Var, yv2 yv2Var, ud4 ud4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, we4Var, yv2Var, ud4Var) == null) {
            b(context, we4Var, yv2Var, ud4Var, false);
        }
    }

    public static void b(Context context, we4 we4Var, yv2 yv2Var, ud4 ud4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, we4Var, yv2Var, ud4Var, Boolean.valueOf(z)}) == null) {
            if (we4Var != null && yv2Var != null && yv2Var.isValid()) {
                BaiduMap map = we4Var.l.getMap();
                se4 se4Var = new se4(we4Var);
                map.setOnMapClickListener(se4Var);
                map.setOnMarkerClickListener(se4Var);
                map.setOnMapLoadedCallback(se4Var);
                map.setOnMapRenderCallbadk(se4Var);
                map.setOnMapStatusChangeListener(se4Var);
                map.setOnMyLocationClickListener(se4Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(yv2Var.t);
                uiSettings.setRotateGesturesEnabled(yv2Var.u);
                uiSettings.setZoomGesturesEnabled(yv2Var.s);
                we4Var.l.showZoomControls(false);
                we4Var.l.showScaleControl(false);
                map.setBuildingsEnabled(yv2Var.x);
                uiSettings.setOverlookingGesturesEnabled(yv2Var.w);
                fw2 fw2Var = yv2Var.j;
                if (fw2Var != null && fw2Var.isValid()) {
                    m62.i("map", "initMapView coordinate is " + yv2Var.j);
                    fw2 fw2Var2 = yv2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(fw2Var2.a, fw2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) yv2Var.k));
                m62.i("map", "initMapView scale is " + yv2Var.k);
                boolean z2 = yv2Var.r;
                we4Var.k = z2;
                if (z2) {
                    c(context, ud4Var);
                } else {
                    ud4Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(yv2Var.v);
                qe4.e(AppRuntime.getAppContext(), yv2Var, we4Var);
                qe4.d(yv2Var, we4Var, se4Var);
                return;
            }
            m62.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, ud4 ud4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, ud4Var) == null) {
            ne4.b(context, new a(ud4Var));
        }
    }
}
