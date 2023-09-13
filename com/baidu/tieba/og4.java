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
import com.baidu.tieba.hh4;
import com.baidu.tieba.qa2;
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
/* loaded from: classes7.dex */
public class og4 extends na2 implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextureMapView G0;
    public BaiduMap H0;
    public String I0;
    public Marker J0;
    public String K0;
    public String L0;
    public ImageView M0;
    public TextView N0;
    public TextView O0;
    public GeoCoder P0;
    public PopupWindow Q0;
    public OpenLocationBottomMenu R0;
    public View S0;
    public ImageView T0;
    public hh4 U0;
    public BDLocation V0;
    public boolean W0;
    public ArrayList<String> X0;
    public float Y0;

    @Override // com.baidu.tieba.na2
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.na2
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.na2
    public boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.na2, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og4 a;

        public a(og4 og4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = og4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.w3();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements OnGetGeoCoderResultListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og4 a;

        @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
        public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, geoCodeResult) == null) {
            }
        }

        public b(og4 og4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = og4Var;
        }

        @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
        public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, reverseGeoCodeResult) == null) {
                if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
                    if (this.a.O0 != null && TextUtils.isEmpty(this.a.L0)) {
                        String address = reverseGeoCodeResult.getAddress();
                        og4 og4Var = this.a;
                        if (address == null) {
                            address = og4Var.getResources().getString(R.string.obfuscated_res_0x7f0f17b7);
                        }
                        og4Var.L0 = address;
                        this.a.O0.setText(this.a.L0);
                    }
                    if (this.a.N0 != null && TextUtils.isEmpty(this.a.K0)) {
                        String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                        og4 og4Var2 = this.a;
                        if (sematicDescription == null) {
                            sematicDescription = og4Var2.getResources().getString(R.string.obfuscated_res_0x7f0f17b7);
                        }
                        og4Var2.K0 = sematicDescription;
                        this.a.N0.setText(this.a.K0);
                    }
                    h82.i("map", "mAddress +" + this.a.L0 + " mName" + this.a.K0);
                    return;
                }
                this.a.N0.setText(R.string.obfuscated_res_0x7f0f17b7);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og4 a;

        public c(og4 og4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = og4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j3();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og4 a;

        public d(og4 og4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = og4Var;
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                og4 og4Var = this.a;
                og4Var.i3(og4Var.S0, 1.0f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og4 a;

        public e(og4 og4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = og4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.U0 != null && this.a.U0.i() != null) {
                BDLocation i = this.a.U0.i();
                this.a.H0.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(i.getLatitude(), i.getLongitude())));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements hh4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og4 a;

        public f(og4 og4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = og4Var;
        }

        @Override // com.baidu.tieba.hh4.b
        public void a(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, bDLocation) != null) {
                return;
            }
            this.a.V0 = bDLocation;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948031277, "Lcom/baidu/tieba/og4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948031277, "Lcom/baidu/tieba/og4;");
                return;
            }
        }
        boolean z = rr1.a;
    }

    public og4() {
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
        this.I0 = "";
        this.Y0 = 0.5f;
    }

    @Override // com.baidu.tieba.na2
    public void O2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.I0);
            uw2.T().u(new il2("sharebtn", hashMap));
        }
    }

    public void j3() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (popupWindow = this.Q0) != null && popupWindow.y()) {
            this.Q0.q();
        }
    }

    public BDLocation k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.V0;
        }
        return (BDLocation) invokeV.objValue;
    }

    @Override // com.baidu.tieba.na2
    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            r3();
            this.g0.s(ou2.M().a(), I1());
        }
    }

    public boolean l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.W0;
        }
        return invokeV.booleanValue;
    }

    public List<String> m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.X0;
        }
        return (List) invokeV.objValue;
    }

    public BaiduMap n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.H0;
        }
        return (BaiduMap) invokeV.objValue;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            h82.i("map", "onMapLoaded");
            u3();
        }
    }

    public void x3() {
        qa2 U;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (U = uw2.T().U()) != null) {
            qa2.b i = U.i("navigateTo");
            i.n(qa2.g, qa2.i);
            i.j(this);
            i.b();
        }
    }

    public final void y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            hh4 hh4Var = new hh4(uw2.T().getActivity(), this.H0);
            this.U0 = hh4Var;
            hh4Var.n(true);
            this.U0.k(new f(this));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        TextureMapView textureMapView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.z0();
            GeoCoder geoCoder = this.P0;
            if (geoCoder != null) {
                geoCoder.destroy();
            }
            OpenLocationBottomMenu.l();
            hh4 hh4Var = this.U0;
            if (hh4Var != null) {
                hh4Var.n(false);
            }
            if (Build.VERSION.SDK_INT > 19 && (textureMapView = this.G0) != null) {
                textureMapView.onDestroy();
            }
        }
    }

    public static og4 t3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bundle)) == null) {
            og4 og4Var = new og4();
            if (bundle != null) {
                og4Var.j1(bundle);
            }
            of4.a();
            return og4Var;
        }
        return (og4) invokeL.objValue;
    }

    public final void p3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view2) == null) {
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e58);
            this.T0 = imageView;
            imageView.setOnClickListener(new e(this));
        }
    }

    public final void s3(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, latLng) == null) {
            this.P0 = GeoCoder.newInstance();
            this.P0.setOnGetGeoCodeResultListener(new b(this));
            this.P0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
        }
    }

    public void v3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.W0 = z;
        }
    }

    public final void i3(View view2, float f2) {
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

    public final void o3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            this.S0 = view2;
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091671);
            this.M0 = imageView;
            imageView.setOnClickListener(new a(this));
            this.N0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091677);
            this.O0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091676);
        }
    }

    public final void q3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view2) == null) {
            TextureMapView textureMapView = (TextureMapView) view2.findViewById(R.id.obfuscated_res_0x7f09037d);
            this.G0 = textureMapView;
            BaiduMap map = textureMapView.getMap();
            this.H0 = map;
            map.getUiSettings().setRotateGesturesEnabled(false);
            this.G0.showZoomControls(false);
            this.H0.getUiSettings().setOverlookingGesturesEnabled(false);
            this.H0.setOnMapLoadedCallback(this);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, marker)) == null) {
            if (marker == this.J0 && !TextUtils.isEmpty(this.K0)) {
                LinearLayout linearLayout = new LinearLayout(AppRuntime.getAppContext());
                linearLayout.setOrientation(1);
                TextView textView = new TextView(AppRuntime.getAppContext());
                textView.setText(this.K0);
                textView.setTextSize(18.0f);
                TextView textView2 = new TextView(AppRuntime.getAppContext());
                textView2.setText(this.L0);
                textView2.setTextSize(15.0f);
                linearLayout.addView(textView);
                linearLayout.addView(textView2);
                this.H0.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void r3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.g0 == null) {
            this.g0 = new oh4(getContext(), this.f0, 12, ou2.K(), new qq3());
            new x03(this.g0, this).z();
        }
    }

    public final void u3() {
        Bundle o;
        String str;
        TextView textView;
        TextView textView2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (o = o()) != null && o.size() > 0) {
            this.I0 = o.getString("slaveId");
            double d2 = o.getDouble("latitude");
            double d3 = o.getDouble("longitude");
            double d4 = o.getDouble("scale");
            this.K0 = o.getString("name");
            this.L0 = o.getString("address");
            LatLng latLng = new LatLng(d2, d3);
            if (TextUtils.isEmpty(this.K0)) {
                if (TextUtils.isEmpty(this.L0)) {
                    s3(latLng);
                } else {
                    this.K0 = getResources().getString(R.string.obfuscated_res_0x7f0f17b6);
                }
            }
            this.H0.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.H0.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d4));
            BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(R.drawable.obfuscated_res_0x7f0801a7);
            if (TextUtils.isEmpty(this.K0)) {
                str = "";
            } else {
                str = this.K0;
            }
            this.J0 = (Marker) this.H0.addOverlay(new MarkerOptions().position(latLng).icon(fromResource).title(str).anchor(0.5f, 0.5f));
            h82.i("map", "show marker");
            if (!TextUtils.isEmpty(this.K0) && (textView2 = this.N0) != null) {
                textView2.setText(this.K0);
            }
            if (!TextUtils.isEmpty(this.L0) && (textView = this.O0) != null) {
                textView.setText(this.L0);
            }
            this.X0 = o.getStringArrayList("ignoredApps");
        }
    }

    public final void w3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || (activity = getActivity()) == null) {
            return;
        }
        PopupWindow popupWindow = this.Q0;
        if (popupWindow != null && popupWindow.y()) {
            return;
        }
        View inflate = View.inflate(activity, R.layout.obfuscated_res_0x7f0d00c9, null);
        inflate.setOnClickListener(new c(this));
        OpenLocationBottomMenu openLocationBottomMenu = (OpenLocationBottomMenu) inflate.findViewById(R.id.obfuscated_res_0x7f091a1a);
        this.R0 = openLocationBottomMenu;
        openLocationBottomMenu.setFragment(this);
        PopupWindow popupWindow2 = new PopupWindow(activity);
        this.Q0 = popupWindow2;
        popupWindow2.F(inflate);
        this.Q0.M(-1);
        this.Q0.H(-2);
        this.Q0.G(true);
        this.Q0.K(true);
        this.Q0.C(R.style.obfuscated_res_0x7f100156);
        this.Q0.O(this.S0, 80, 0, 0);
        this.Q0.J(new d(this));
        i3(this.S0, this.Y0);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048599, this, layoutInflater, viewGroup, bundle)) == null) {
            h82.i("map", "start MapLocationFragment");
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0091, viewGroup, false);
            W1(inflate);
            z2(b2());
            L2(false);
            q3(inflate);
            o3(inflate);
            y3();
            p3(inflate);
            x2(AppRuntime.getAppContext().getResources().getString(R.string.obfuscated_res_0x7f0f01cc));
            if (V1()) {
                inflate = Y1(inflate);
            }
            return E1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
