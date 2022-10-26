package com.baidu.tieba;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.map.view.OpenLocationBottomMenu;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.m94;
import com.baidu.tieba.v22;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class t84 extends s22 implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextureMapView F0;
    public BaiduMap G0;
    public String H0;
    public Marker I0;
    public String J0;
    public String K0;
    public ImageView L0;
    public TextView M0;
    public TextView N0;
    public GeoCoder O0;
    public PopupWindow P0;
    public OpenLocationBottomMenu Q0;
    public View R0;
    public ImageView S0;
    public m94 T0;
    public BDLocation U0;
    public boolean V0;
    public ArrayList W0;
    public float X0;

    @Override // com.baidu.tieba.s22
    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.s22
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.s22
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.s22, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t84 a;

        public a(t84 t84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t84Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.u3();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements OnGetGeoCoderResultListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t84 a;

        @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
        public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, geoCodeResult) == null) {
            }
        }

        public b(t84 t84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t84Var;
        }

        @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
        public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, reverseGeoCodeResult) == null) {
                if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
                    if (this.a.N0 != null && TextUtils.isEmpty(this.a.K0)) {
                        String address = reverseGeoCodeResult.getAddress();
                        t84 t84Var = this.a;
                        if (address == null) {
                            address = t84Var.getResources().getString(R.string.obfuscated_res_0x7f0f14f7);
                        }
                        t84Var.K0 = address;
                        this.a.N0.setText(this.a.K0);
                    }
                    if (this.a.M0 != null && TextUtils.isEmpty(this.a.J0)) {
                        String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                        t84 t84Var2 = this.a;
                        if (sematicDescription == null) {
                            sematicDescription = t84Var2.getResources().getString(R.string.obfuscated_res_0x7f0f14f7);
                        }
                        t84Var2.J0 = sematicDescription;
                        this.a.M0.setText(this.a.J0);
                    }
                    m02.i("map", "mAddress +" + this.a.K0 + " mName" + this.a.J0);
                    return;
                }
                this.a.M0.setText(R.string.obfuscated_res_0x7f0f14f7);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t84 a;

        public c(t84 t84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t84Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.h3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t84 a;

        public d(t84 t84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t84Var;
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                t84 t84Var = this.a;
                t84Var.g3(t84Var.R0, 1.0f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t84 a;

        public e(t84 t84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t84Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.T0 != null && this.a.T0.i() != null) {
                BDLocation i = this.a.T0.i();
                this.a.G0.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(i.getLatitude(), i.getLongitude())));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements m94.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t84 a;

        public f(t84 t84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t84Var;
        }

        @Override // com.baidu.tieba.m94.b
        public void a(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, bDLocation) != null) {
                return;
            }
            this.a.U0 = bDLocation;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948135065, "Lcom/baidu/tieba/t84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948135065, "Lcom/baidu/tieba/t84;");
                return;
            }
        }
        boolean z = wj1.a;
    }

    public t84() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.H0 = "";
        this.X0 = 0.5f;
    }

    @Override // com.baidu.tieba.s22
    public void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.H0);
            zo2.U().u(new nd2("sharebtn", hashMap));
        }
    }

    public void h3() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (popupWindow = this.P0) != null && popupWindow.x()) {
            this.P0.r();
        }
    }

    public BDLocation i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.U0;
        }
        return (BDLocation) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s22
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            p3();
            this.g0.t(tm2.M().a(), H1());
        }
    }

    public boolean j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.V0;
        }
        return invokeV.booleanValue;
    }

    public List k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.W0;
        }
        return (List) invokeV.objValue;
    }

    public BaiduMap l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.G0;
        }
        return (BaiduMap) invokeV.objValue;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            m02.i("map", "onMapLoaded");
            s3();
        }
    }

    public void v3() {
        v22 V;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (V = zo2.U().V()) != null) {
            v22.b i = V.i("navigateTo");
            i.n(v22.g, v22.i);
            i.j(this);
            i.b();
        }
    }

    public final void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            m94 m94Var = new m94(zo2.U().getActivity(), this.G0);
            this.T0 = m94Var;
            m94Var.n(true);
            this.T0.k(new f(this));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        TextureMapView textureMapView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.y0();
            GeoCoder geoCoder = this.O0;
            if (geoCoder != null) {
                geoCoder.destroy();
            }
            OpenLocationBottomMenu.l();
            m94 m94Var = this.T0;
            if (m94Var != null) {
                m94Var.n(false);
            }
            if (Build.VERSION.SDK_INT > 19 && (textureMapView = this.F0) != null) {
                textureMapView.onDestroy();
            }
        }
    }

    public static t84 r3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bundle)) == null) {
            t84 t84Var = new t84();
            if (bundle != null) {
                t84Var.j1(bundle);
            }
            t74.a();
            return t84Var;
        }
        return (t84) invokeL.objValue;
    }

    public final void n3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090cd4);
            this.S0 = imageView;
            imageView.setOnClickListener(new e(this));
        }
    }

    public final void q3(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, latLng) == null) {
            this.O0 = GeoCoder.newInstance();
            this.O0.setOnGetGeoCodeResultListener(new b(this));
            this.O0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
        }
    }

    public void t3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.V0 = z;
        }
    }

    public final void g3(View view2, float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLF(1048580, this, view2, f2) != null) || view2 == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view2.getRootView();
        ViewGroupOverlay overlay = viewGroup.getOverlay();
        if (Float.valueOf(f2).equals(Float.valueOf(1.0f))) {
            overlay.clear();
            return;
        }
        ColorDrawable colorDrawable = new ColorDrawable(-16777216);
        colorDrawable.setBounds(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
        colorDrawable.setAlpha((int) (f2 * 255.0f));
        overlay.add(colorDrawable);
    }

    public final void m3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            this.R0 = view2;
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091424);
            this.L0 = imageView;
            imageView.setOnClickListener(new a(this));
            this.M0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09142a);
            this.N0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091429);
        }
    }

    public final void o3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            TextureMapView textureMapView = (TextureMapView) view2.findViewById(R.id.obfuscated_res_0x7f09035d);
            this.F0 = textureMapView;
            BaiduMap map = textureMapView.getMap();
            this.G0 = map;
            map.getUiSettings().setRotateGesturesEnabled(false);
            this.F0.showZoomControls(false);
            this.G0.getUiSettings().setOverlookingGesturesEnabled(false);
            this.G0.setOnMapLoadedCallback(this);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, marker)) == null) {
            if (marker == this.I0 && !TextUtils.isEmpty(this.J0)) {
                LinearLayout linearLayout = new LinearLayout(AppRuntime.getAppContext());
                linearLayout.setOrientation(1);
                TextView textView = new TextView(AppRuntime.getAppContext());
                textView.setText(this.J0);
                textView.setTextSize(18.0f);
                TextView textView2 = new TextView(AppRuntime.getAppContext());
                textView2.setText(this.K0);
                textView2.setTextSize(15.0f);
                linearLayout.addView(textView);
                linearLayout.addView(textView2);
                this.G0.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void p3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.g0 == null) {
            this.g0 = new t94(getContext(), this.f0, 12, tm2.K(), new vi3());
            new ct2(this.g0, this).z();
        }
    }

    public final void s3() {
        Bundle p;
        String str;
        TextView textView;
        TextView textView2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (p = p()) != null && p.size() > 0) {
            this.H0 = p.getString("slaveId");
            double d2 = p.getDouble("latitude");
            double d3 = p.getDouble("longitude");
            double d4 = p.getDouble("scale");
            this.J0 = p.getString("name");
            this.K0 = p.getString("address");
            LatLng latLng = new LatLng(d2, d3);
            if (TextUtils.isEmpty(this.J0)) {
                if (TextUtils.isEmpty(this.K0)) {
                    q3(latLng);
                } else {
                    this.J0 = getResources().getString(R.string.obfuscated_res_0x7f0f14f6);
                }
            }
            this.G0.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.G0.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d4));
            BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(R.drawable.obfuscated_res_0x7f08018c);
            if (TextUtils.isEmpty(this.J0)) {
                str = "";
            } else {
                str = this.J0;
            }
            this.I0 = (Marker) this.G0.addOverlay(new MarkerOptions().position(latLng).icon(fromResource).title(str).anchor(0.5f, 0.5f));
            m02.i("map", "show marker");
            if (!TextUtils.isEmpty(this.J0) && (textView2 = this.M0) != null) {
                textView2.setText(this.J0);
            }
            if (!TextUtils.isEmpty(this.K0) && (textView = this.N0) != null) {
                textView.setText(this.K0);
            }
            this.W0 = p.getStringArrayList("ignoredApps");
        }
    }

    public final void u3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || (activity = getActivity()) == null) {
            return;
        }
        PopupWindow popupWindow = this.P0;
        if (popupWindow != null && popupWindow.x()) {
            return;
        }
        View inflate = View.inflate(activity, R.layout.obfuscated_res_0x7f0d00c0, null);
        inflate.setOnClickListener(new c(this));
        OpenLocationBottomMenu openLocationBottomMenu = (OpenLocationBottomMenu) inflate.findViewById(R.id.obfuscated_res_0x7f091737);
        this.Q0 = openLocationBottomMenu;
        openLocationBottomMenu.setFragment(this);
        PopupWindow popupWindow2 = new PopupWindow(activity);
        this.P0 = popupWindow2;
        popupWindow2.E(inflate);
        this.P0.M(-1);
        this.P0.G(-2);
        this.P0.F(true);
        this.P0.K(true);
        this.P0.B(R.style.obfuscated_res_0x7f100140);
        this.P0.O(this.R0, 80, 0, 0);
        this.P0.I(new d(this));
        g3(this.R0, this.X0);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048600, this, layoutInflater, viewGroup, bundle)) == null) {
            m02.i("map", "start MapLocationFragment");
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0088, viewGroup, false);
            U1(inflate);
            x2(Z1());
            J2(false);
            o3(inflate);
            m3(inflate);
            w3();
            n3(inflate);
            v2(AppRuntime.getAppContext().getResources().getString(R.string.obfuscated_res_0x7f0f019f));
            if (T1()) {
                inflate = W1(inflate);
            }
            return D1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
