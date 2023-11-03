package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.hb4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements hb4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oa4 a;

        public a(oa4 oa4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oa4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oa4Var;
        }

        @Override // com.baidu.tieba.hb4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g32.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.hb4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.q(true);
                g32.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, qb4 qb4Var, ss2 ss2Var, oa4 oa4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, qb4Var, ss2Var, oa4Var) == null) {
            b(context, qb4Var, ss2Var, oa4Var, false);
        }
    }

    public static void b(Context context, qb4 qb4Var, ss2 ss2Var, oa4 oa4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, qb4Var, ss2Var, oa4Var, Boolean.valueOf(z)}) == null) {
            if (qb4Var != null && ss2Var != null && ss2Var.isValid()) {
                BaiduMap map = qb4Var.l.getMap();
                mb4 mb4Var = new mb4(qb4Var);
                map.setOnMapClickListener(mb4Var);
                map.setOnMarkerClickListener(mb4Var);
                map.setOnMapLoadedCallback(mb4Var);
                map.setOnMapRenderCallbadk(mb4Var);
                map.setOnMapStatusChangeListener(mb4Var);
                map.setOnMyLocationClickListener(mb4Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(ss2Var.t);
                uiSettings.setRotateGesturesEnabled(ss2Var.u);
                uiSettings.setZoomGesturesEnabled(ss2Var.s);
                qb4Var.l.showZoomControls(false);
                qb4Var.l.showScaleControl(false);
                map.setBuildingsEnabled(ss2Var.x);
                uiSettings.setOverlookingGesturesEnabled(ss2Var.w);
                zs2 zs2Var = ss2Var.j;
                if (zs2Var != null && zs2Var.isValid()) {
                    g32.i("map", "initMapView coordinate is " + ss2Var.j);
                    zs2 zs2Var2 = ss2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(zs2Var2.a, zs2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) ss2Var.k));
                g32.i("map", "initMapView scale is " + ss2Var.k);
                boolean z2 = ss2Var.r;
                qb4Var.k = z2;
                if (z2) {
                    c(context, oa4Var);
                } else {
                    oa4Var.q(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(ss2Var.v);
                kb4.e(AppRuntime.getAppContext(), ss2Var, qb4Var);
                kb4.d(ss2Var, qb4Var, mb4Var);
                return;
            }
            g32.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, oa4 oa4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, oa4Var) == null) {
            hb4.b(context, new a(oa4Var));
        }
    }
}
