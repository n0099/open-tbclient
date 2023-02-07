package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.xd4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class zd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements xd4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ed4 a;

        public a(ed4 ed4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ed4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ed4Var;
        }

        @Override // com.baidu.tieba.xd4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                w52.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.xd4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                w52.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, ge4 ge4Var, iv2 iv2Var, ed4 ed4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, ge4Var, iv2Var, ed4Var) == null) {
            b(context, ge4Var, iv2Var, ed4Var, false);
        }
    }

    public static void b(Context context, ge4 ge4Var, iv2 iv2Var, ed4 ed4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, ge4Var, iv2Var, ed4Var, Boolean.valueOf(z)}) == null) {
            if (ge4Var != null && iv2Var != null && iv2Var.isValid()) {
                BaiduMap map = ge4Var.l.getMap();
                ce4 ce4Var = new ce4(ge4Var);
                map.setOnMapClickListener(ce4Var);
                map.setOnMarkerClickListener(ce4Var);
                map.setOnMapLoadedCallback(ce4Var);
                map.setOnMapRenderCallbadk(ce4Var);
                map.setOnMapStatusChangeListener(ce4Var);
                map.setOnMyLocationClickListener(ce4Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(iv2Var.t);
                uiSettings.setRotateGesturesEnabled(iv2Var.u);
                uiSettings.setZoomGesturesEnabled(iv2Var.s);
                ge4Var.l.showZoomControls(false);
                ge4Var.l.showScaleControl(false);
                map.setBuildingsEnabled(iv2Var.x);
                uiSettings.setOverlookingGesturesEnabled(iv2Var.w);
                pv2 pv2Var = iv2Var.j;
                if (pv2Var != null && pv2Var.isValid()) {
                    w52.i("map", "initMapView coordinate is " + iv2Var.j);
                    pv2 pv2Var2 = iv2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(pv2Var2.a, pv2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) iv2Var.k));
                w52.i("map", "initMapView scale is " + iv2Var.k);
                boolean z2 = iv2Var.r;
                ge4Var.k = z2;
                if (z2) {
                    c(context, ed4Var);
                } else {
                    ed4Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(iv2Var.v);
                ae4.e(AppRuntime.getAppContext(), iv2Var, ge4Var);
                ae4.d(iv2Var, ge4Var, ce4Var);
                return;
            }
            w52.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, ed4 ed4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, ed4Var) == null) {
            xd4.b(context, new a(ed4Var));
        }
    }
}
