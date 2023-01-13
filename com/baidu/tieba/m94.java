package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.k94;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class m94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements k94.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r84 a;

        public a(r84 r84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r84Var;
        }

        @Override // com.baidu.tieba.k94.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                j12.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.k94.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                j12.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, t94 t94Var, vq2 vq2Var, r84 r84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, t94Var, vq2Var, r84Var) == null) {
            b(context, t94Var, vq2Var, r84Var, false);
        }
    }

    public static void b(Context context, t94 t94Var, vq2 vq2Var, r84 r84Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, t94Var, vq2Var, r84Var, Boolean.valueOf(z)}) == null) {
            if (t94Var != null && vq2Var != null && vq2Var.isValid()) {
                BaiduMap map = t94Var.l.getMap();
                p94 p94Var = new p94(t94Var);
                map.setOnMapClickListener(p94Var);
                map.setOnMarkerClickListener(p94Var);
                map.setOnMapLoadedCallback(p94Var);
                map.setOnMapRenderCallbadk(p94Var);
                map.setOnMapStatusChangeListener(p94Var);
                map.setOnMyLocationClickListener(p94Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(vq2Var.t);
                uiSettings.setRotateGesturesEnabled(vq2Var.u);
                uiSettings.setZoomGesturesEnabled(vq2Var.s);
                t94Var.l.showZoomControls(false);
                t94Var.l.showScaleControl(false);
                map.setBuildingsEnabled(vq2Var.x);
                uiSettings.setOverlookingGesturesEnabled(vq2Var.w);
                cr2 cr2Var = vq2Var.j;
                if (cr2Var != null && cr2Var.isValid()) {
                    j12.i("map", "initMapView coordinate is " + vq2Var.j);
                    cr2 cr2Var2 = vq2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(cr2Var2.a, cr2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) vq2Var.k));
                j12.i("map", "initMapView scale is " + vq2Var.k);
                boolean z2 = vq2Var.r;
                t94Var.k = z2;
                if (z2) {
                    c(context, r84Var);
                } else {
                    r84Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(vq2Var.v);
                n94.e(AppRuntime.getAppContext(), vq2Var, t94Var);
                n94.d(vq2Var, t94Var, p94Var);
                return;
            }
            j12.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, r84 r84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, r84Var) == null) {
            k94.b(context, new a(r84Var));
        }
    }
}
