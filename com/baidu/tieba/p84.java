package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.n84;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class p84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public final class a implements n84.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u74 a;

        public a(u74 u74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u74Var;
        }

        @Override // com.baidu.tieba.n84.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m02.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.n84.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                m02.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, w84 w84Var, yp2 yp2Var, u74 u74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, w84Var, yp2Var, u74Var) == null) {
            b(context, w84Var, yp2Var, u74Var, false);
        }
    }

    public static void b(Context context, w84 w84Var, yp2 yp2Var, u74 u74Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, w84Var, yp2Var, u74Var, Boolean.valueOf(z)}) == null) {
            if (w84Var != null && yp2Var != null && yp2Var.isValid()) {
                BaiduMap map = w84Var.l.getMap();
                s84 s84Var = new s84(w84Var);
                map.setOnMapClickListener(s84Var);
                map.setOnMarkerClickListener(s84Var);
                map.setOnMapLoadedCallback(s84Var);
                map.setOnMapRenderCallbadk(s84Var);
                map.setOnMapStatusChangeListener(s84Var);
                map.setOnMyLocationClickListener(s84Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(yp2Var.t);
                uiSettings.setRotateGesturesEnabled(yp2Var.u);
                uiSettings.setZoomGesturesEnabled(yp2Var.s);
                w84Var.l.showZoomControls(false);
                w84Var.l.showScaleControl(false);
                map.setBuildingsEnabled(yp2Var.x);
                uiSettings.setOverlookingGesturesEnabled(yp2Var.w);
                fq2 fq2Var = yp2Var.j;
                if (fq2Var != null && fq2Var.isValid()) {
                    m02.i("map", "initMapView coordinate is " + yp2Var.j);
                    fq2 fq2Var2 = yp2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(fq2Var2.a, fq2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) yp2Var.k));
                m02.i("map", "initMapView scale is " + yp2Var.k);
                boolean z2 = yp2Var.r;
                w84Var.k = z2;
                if (z2) {
                    c(context, u74Var);
                } else {
                    u74Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(yp2Var.v);
                q84.e(AppRuntime.getAppContext(), yp2Var, w84Var);
                q84.d(yp2Var, w84Var, s84Var);
                return;
            }
            m02.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, u74 u74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, u74Var) == null) {
            n84.b(context, new a(u74Var));
        }
    }
}
