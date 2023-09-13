package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.ig4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kg4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements ig4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pf4 a;

        public a(pf4 pf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pf4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pf4Var;
        }

        @Override // com.baidu.tieba.ig4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h82.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.ig4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                h82.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, rg4 rg4Var, tx2 tx2Var, pf4 pf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, rg4Var, tx2Var, pf4Var) == null) {
            b(context, rg4Var, tx2Var, pf4Var, false);
        }
    }

    public static void b(Context context, rg4 rg4Var, tx2 tx2Var, pf4 pf4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, rg4Var, tx2Var, pf4Var, Boolean.valueOf(z)}) == null) {
            if (rg4Var != null && tx2Var != null && tx2Var.isValid()) {
                BaiduMap map = rg4Var.l.getMap();
                ng4 ng4Var = new ng4(rg4Var);
                map.setOnMapClickListener(ng4Var);
                map.setOnMarkerClickListener(ng4Var);
                map.setOnMapLoadedCallback(ng4Var);
                map.setOnMapRenderCallbadk(ng4Var);
                map.setOnMapStatusChangeListener(ng4Var);
                map.setOnMyLocationClickListener(ng4Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(tx2Var.t);
                uiSettings.setRotateGesturesEnabled(tx2Var.u);
                uiSettings.setZoomGesturesEnabled(tx2Var.s);
                rg4Var.l.showZoomControls(false);
                rg4Var.l.showScaleControl(false);
                map.setBuildingsEnabled(tx2Var.x);
                uiSettings.setOverlookingGesturesEnabled(tx2Var.w);
                ay2 ay2Var = tx2Var.j;
                if (ay2Var != null && ay2Var.isValid()) {
                    h82.i("map", "initMapView coordinate is " + tx2Var.j);
                    ay2 ay2Var2 = tx2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(ay2Var2.a, ay2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) tx2Var.k));
                h82.i("map", "initMapView scale is " + tx2Var.k);
                boolean z2 = tx2Var.r;
                rg4Var.k = z2;
                if (z2) {
                    c(context, pf4Var);
                } else {
                    pf4Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(tx2Var.v);
                lg4.e(AppRuntime.getAppContext(), tx2Var, rg4Var);
                lg4.d(tx2Var, rg4Var, ng4Var);
                return;
            }
            h82.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, pf4 pf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, pf4Var) == null) {
            ig4.b(context, new a(pf4Var));
        }
    }
}
