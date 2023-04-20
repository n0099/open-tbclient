package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.wc4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class yc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements wc4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dc4 a;

        public a(dc4 dc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dc4Var;
        }

        @Override // com.baidu.tieba.wc4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                v42.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.wc4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                v42.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, fd4 fd4Var, hu2 hu2Var, dc4 dc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, fd4Var, hu2Var, dc4Var) == null) {
            b(context, fd4Var, hu2Var, dc4Var, false);
        }
    }

    public static void b(Context context, fd4 fd4Var, hu2 hu2Var, dc4 dc4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, fd4Var, hu2Var, dc4Var, Boolean.valueOf(z)}) == null) {
            if (fd4Var != null && hu2Var != null && hu2Var.isValid()) {
                BaiduMap map = fd4Var.l.getMap();
                bd4 bd4Var = new bd4(fd4Var);
                map.setOnMapClickListener(bd4Var);
                map.setOnMarkerClickListener(bd4Var);
                map.setOnMapLoadedCallback(bd4Var);
                map.setOnMapRenderCallbadk(bd4Var);
                map.setOnMapStatusChangeListener(bd4Var);
                map.setOnMyLocationClickListener(bd4Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(hu2Var.t);
                uiSettings.setRotateGesturesEnabled(hu2Var.u);
                uiSettings.setZoomGesturesEnabled(hu2Var.s);
                fd4Var.l.showZoomControls(false);
                fd4Var.l.showScaleControl(false);
                map.setBuildingsEnabled(hu2Var.x);
                uiSettings.setOverlookingGesturesEnabled(hu2Var.w);
                ou2 ou2Var = hu2Var.j;
                if (ou2Var != null && ou2Var.isValid()) {
                    v42.i("map", "initMapView coordinate is " + hu2Var.j);
                    ou2 ou2Var2 = hu2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(ou2Var2.a, ou2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) hu2Var.k));
                v42.i("map", "initMapView scale is " + hu2Var.k);
                boolean z2 = hu2Var.r;
                fd4Var.k = z2;
                if (z2) {
                    c(context, dc4Var);
                } else {
                    dc4Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(hu2Var.v);
                zc4.e(AppRuntime.getAppContext(), hu2Var, fd4Var);
                zc4.d(hu2Var, fd4Var, bd4Var);
                return;
            }
            v42.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, dc4 dc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, dc4Var) == null) {
            wc4.b(context, new a(dc4Var));
        }
    }
}
