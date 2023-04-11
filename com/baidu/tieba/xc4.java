package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.vc4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements vc4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cc4 a;

        public a(cc4 cc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cc4Var;
        }

        @Override // com.baidu.tieba.vc4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                u42.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.vc4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                u42.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, ed4 ed4Var, gu2 gu2Var, cc4 cc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, ed4Var, gu2Var, cc4Var) == null) {
            b(context, ed4Var, gu2Var, cc4Var, false);
        }
    }

    public static void b(Context context, ed4 ed4Var, gu2 gu2Var, cc4 cc4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, ed4Var, gu2Var, cc4Var, Boolean.valueOf(z)}) == null) {
            if (ed4Var != null && gu2Var != null && gu2Var.isValid()) {
                BaiduMap map = ed4Var.l.getMap();
                ad4 ad4Var = new ad4(ed4Var);
                map.setOnMapClickListener(ad4Var);
                map.setOnMarkerClickListener(ad4Var);
                map.setOnMapLoadedCallback(ad4Var);
                map.setOnMapRenderCallbadk(ad4Var);
                map.setOnMapStatusChangeListener(ad4Var);
                map.setOnMyLocationClickListener(ad4Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(gu2Var.t);
                uiSettings.setRotateGesturesEnabled(gu2Var.u);
                uiSettings.setZoomGesturesEnabled(gu2Var.s);
                ed4Var.l.showZoomControls(false);
                ed4Var.l.showScaleControl(false);
                map.setBuildingsEnabled(gu2Var.x);
                uiSettings.setOverlookingGesturesEnabled(gu2Var.w);
                nu2 nu2Var = gu2Var.j;
                if (nu2Var != null && nu2Var.isValid()) {
                    u42.i("map", "initMapView coordinate is " + gu2Var.j);
                    nu2 nu2Var2 = gu2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(nu2Var2.a, nu2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) gu2Var.k));
                u42.i("map", "initMapView scale is " + gu2Var.k);
                boolean z2 = gu2Var.r;
                ed4Var.k = z2;
                if (z2) {
                    c(context, cc4Var);
                } else {
                    cc4Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(gu2Var.v);
                yc4.e(AppRuntime.getAppContext(), gu2Var, ed4Var);
                yc4.d(gu2Var, ed4Var, ad4Var);
                return;
            }
            u42.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, cc4 cc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, cc4Var) == null) {
            vc4.b(context, new a(cc4Var));
        }
    }
}
