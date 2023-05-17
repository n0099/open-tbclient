package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.he4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class je4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements he4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ od4 a;

        public a(od4 od4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = od4Var;
        }

        @Override // com.baidu.tieba.he4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g62.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.he4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                g62.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, qe4 qe4Var, sv2 sv2Var, od4 od4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, qe4Var, sv2Var, od4Var) == null) {
            b(context, qe4Var, sv2Var, od4Var, false);
        }
    }

    public static void b(Context context, qe4 qe4Var, sv2 sv2Var, od4 od4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, qe4Var, sv2Var, od4Var, Boolean.valueOf(z)}) == null) {
            if (qe4Var != null && sv2Var != null && sv2Var.isValid()) {
                BaiduMap map = qe4Var.l.getMap();
                me4 me4Var = new me4(qe4Var);
                map.setOnMapClickListener(me4Var);
                map.setOnMarkerClickListener(me4Var);
                map.setOnMapLoadedCallback(me4Var);
                map.setOnMapRenderCallbadk(me4Var);
                map.setOnMapStatusChangeListener(me4Var);
                map.setOnMyLocationClickListener(me4Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(sv2Var.t);
                uiSettings.setRotateGesturesEnabled(sv2Var.u);
                uiSettings.setZoomGesturesEnabled(sv2Var.s);
                qe4Var.l.showZoomControls(false);
                qe4Var.l.showScaleControl(false);
                map.setBuildingsEnabled(sv2Var.x);
                uiSettings.setOverlookingGesturesEnabled(sv2Var.w);
                zv2 zv2Var = sv2Var.j;
                if (zv2Var != null && zv2Var.isValid()) {
                    g62.i("map", "initMapView coordinate is " + sv2Var.j);
                    zv2 zv2Var2 = sv2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(zv2Var2.a, zv2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) sv2Var.k));
                g62.i("map", "initMapView scale is " + sv2Var.k);
                boolean z2 = sv2Var.r;
                qe4Var.k = z2;
                if (z2) {
                    c(context, od4Var);
                } else {
                    od4Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(sv2Var.v);
                ke4.e(AppRuntime.getAppContext(), sv2Var, qe4Var);
                ke4.d(sv2Var, qe4Var, me4Var);
                return;
            }
            g62.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, od4 od4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, od4Var) == null) {
            he4.b(context, new a(od4Var));
        }
    }
}
