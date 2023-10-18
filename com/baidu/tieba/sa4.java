package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.qa4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class sa4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements qa4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x94 a;

        public a(x94 x94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x94Var;
        }

        @Override // com.baidu.tieba.qa4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p22.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.qa4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.q(true);
                p22.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, za4 za4Var, bs2 bs2Var, x94 x94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, za4Var, bs2Var, x94Var) == null) {
            b(context, za4Var, bs2Var, x94Var, false);
        }
    }

    public static void b(Context context, za4 za4Var, bs2 bs2Var, x94 x94Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, za4Var, bs2Var, x94Var, Boolean.valueOf(z)}) == null) {
            if (za4Var != null && bs2Var != null && bs2Var.isValid()) {
                BaiduMap map = za4Var.l.getMap();
                va4 va4Var = new va4(za4Var);
                map.setOnMapClickListener(va4Var);
                map.setOnMarkerClickListener(va4Var);
                map.setOnMapLoadedCallback(va4Var);
                map.setOnMapRenderCallbadk(va4Var);
                map.setOnMapStatusChangeListener(va4Var);
                map.setOnMyLocationClickListener(va4Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(bs2Var.t);
                uiSettings.setRotateGesturesEnabled(bs2Var.u);
                uiSettings.setZoomGesturesEnabled(bs2Var.s);
                za4Var.l.showZoomControls(false);
                za4Var.l.showScaleControl(false);
                map.setBuildingsEnabled(bs2Var.x);
                uiSettings.setOverlookingGesturesEnabled(bs2Var.w);
                is2 is2Var = bs2Var.j;
                if (is2Var != null && is2Var.isValid()) {
                    p22.i("map", "initMapView coordinate is " + bs2Var.j);
                    is2 is2Var2 = bs2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(is2Var2.a, is2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) bs2Var.k));
                p22.i("map", "initMapView scale is " + bs2Var.k);
                boolean z2 = bs2Var.r;
                za4Var.k = z2;
                if (z2) {
                    c(context, x94Var);
                } else {
                    x94Var.q(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(bs2Var.v);
                ta4.e(AppRuntime.getAppContext(), bs2Var, za4Var);
                ta4.d(bs2Var, za4Var, va4Var);
                return;
            }
            p22.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, x94 x94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, x94Var) == null) {
            qa4.b(context, new a(x94Var));
        }
    }
}
