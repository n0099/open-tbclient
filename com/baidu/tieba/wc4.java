package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.uc4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class wc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements uc4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bc4 a;

        public a(bc4 bc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bc4Var;
        }

        @Override // com.baidu.tieba.uc4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                t42.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.uc4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                t42.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, dd4 dd4Var, fu2 fu2Var, bc4 bc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, dd4Var, fu2Var, bc4Var) == null) {
            b(context, dd4Var, fu2Var, bc4Var, false);
        }
    }

    public static void b(Context context, dd4 dd4Var, fu2 fu2Var, bc4 bc4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, dd4Var, fu2Var, bc4Var, Boolean.valueOf(z)}) == null) {
            if (dd4Var != null && fu2Var != null && fu2Var.isValid()) {
                BaiduMap map = dd4Var.l.getMap();
                zc4 zc4Var = new zc4(dd4Var);
                map.setOnMapClickListener(zc4Var);
                map.setOnMarkerClickListener(zc4Var);
                map.setOnMapLoadedCallback(zc4Var);
                map.setOnMapRenderCallbadk(zc4Var);
                map.setOnMapStatusChangeListener(zc4Var);
                map.setOnMyLocationClickListener(zc4Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(fu2Var.t);
                uiSettings.setRotateGesturesEnabled(fu2Var.u);
                uiSettings.setZoomGesturesEnabled(fu2Var.s);
                dd4Var.l.showZoomControls(false);
                dd4Var.l.showScaleControl(false);
                map.setBuildingsEnabled(fu2Var.x);
                uiSettings.setOverlookingGesturesEnabled(fu2Var.w);
                mu2 mu2Var = fu2Var.j;
                if (mu2Var != null && mu2Var.isValid()) {
                    t42.i("map", "initMapView coordinate is " + fu2Var.j);
                    mu2 mu2Var2 = fu2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(mu2Var2.a, mu2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) fu2Var.k));
                t42.i("map", "initMapView scale is " + fu2Var.k);
                boolean z2 = fu2Var.r;
                dd4Var.k = z2;
                if (z2) {
                    c(context, bc4Var);
                } else {
                    bc4Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(fu2Var.v);
                xc4.e(AppRuntime.getAppContext(), fu2Var, dd4Var);
                xc4.d(fu2Var, dd4Var, zc4Var);
                return;
            }
            t42.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, bc4 bc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, bc4Var) == null) {
            uc4.b(context, new a(bc4Var));
        }
    }
}
