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
import com.baidu.tieba.gc4;
import com.baidu.tieba.p52;
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
public class nb4 extends m52 implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
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
    public gc4 U0;
    public BDLocation V0;
    public boolean W0;
    public ArrayList<String> X0;
    public float Y0;

    @Override // com.baidu.tieba.m52
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.m52
    public boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.m52, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.m52
    public boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nb4 a;

        public a(nb4 nb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nb4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nb4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.B3();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements OnGetGeoCoderResultListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nb4 a;

        @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
        public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, geoCodeResult) == null) {
            }
        }

        public b(nb4 nb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nb4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nb4Var;
        }

        @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
        public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, reverseGeoCodeResult) == null) {
                if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
                    if (this.a.O0 != null && TextUtils.isEmpty(this.a.L0)) {
                        String address = reverseGeoCodeResult.getAddress();
                        nb4 nb4Var = this.a;
                        if (address == null) {
                            address = nb4Var.L().getString(R.string.obfuscated_res_0x7f0f17af);
                        }
                        nb4Var.L0 = address;
                        this.a.O0.setText(this.a.L0);
                    }
                    if (this.a.N0 != null && TextUtils.isEmpty(this.a.K0)) {
                        String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                        nb4 nb4Var2 = this.a;
                        if (sematicDescription == null) {
                            sematicDescription = nb4Var2.L().getString(R.string.obfuscated_res_0x7f0f17af);
                        }
                        nb4Var2.K0 = sematicDescription;
                        this.a.N0.setText(this.a.K0);
                    }
                    g32.i("map", "mAddress +" + this.a.L0 + " mName" + this.a.K0);
                    return;
                }
                this.a.N0.setText(R.string.obfuscated_res_0x7f0f17af);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nb4 a;

        public c(nb4 nb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nb4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nb4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.o3();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nb4 a;

        public d(nb4 nb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nb4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nb4Var;
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nb4 nb4Var = this.a;
                nb4Var.n3(nb4Var.S0, 1.0f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nb4 a;

        public e(nb4 nb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nb4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nb4Var;
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
    public class f implements gc4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nb4 a;

        public f(nb4 nb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nb4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nb4Var;
        }

        @Override // com.baidu.tieba.gc4.b
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947996681, "Lcom/baidu/tieba/nb4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947996681, "Lcom/baidu/tieba/nb4;");
                return;
            }
        }
        boolean z = rm1.a;
    }

    public nb4() {
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

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        TextureMapView textureMapView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.C0();
            GeoCoder geoCoder = this.P0;
            if (geoCoder != null) {
                geoCoder.destroy();
            }
            OpenLocationBottomMenu.l();
            gc4 gc4Var = this.U0;
            if (gc4Var != null) {
                gc4Var.n(false);
            }
            if (Build.VERSION.SDK_INT > 19 && (textureMapView = this.G0) != null) {
                textureMapView.onDestroy();
            }
        }
    }

    public void C3() {
        p52 W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (W = tr2.V().W()) != null) {
            p52.b i = W.i("navigateTo");
            i.n(p52.g, p52.i);
            i.j(this);
            i.b();
        }
    }

    public final void D3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            gc4 gc4Var = new gc4(tr2.V().getActivity(), this.H0);
            this.U0 = gc4Var;
            gc4Var.n(true);
            this.U0.k(new f(this));
        }
    }

    @Override // com.baidu.tieba.m52
    public void T2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.I0);
            tr2.V().v(new hg2("sharebtn", hashMap));
        }
    }

    public void o3() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (popupWindow = this.Q0) != null && popupWindow.z()) {
            this.Q0.r();
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            g32.i("map", "onMapLoaded");
            z3();
        }
    }

    public BDLocation p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.V0;
        }
        return (BDLocation) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m52
    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            w3();
            this.g0.s(np2.M().a(), N1());
        }
    }

    public boolean q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.W0;
        }
        return invokeV.booleanValue;
    }

    public List<String> r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.X0;
        }
        return (List) invokeV.objValue;
    }

    public BaiduMap s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.H0;
        }
        return (BaiduMap) invokeV.objValue;
    }

    public static nb4 y3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bundle)) == null) {
            nb4 nb4Var = new nb4();
            if (bundle != null) {
                nb4Var.m1(bundle);
            }
            na4.a();
            return nb4Var;
        }
        return (nb4) invokeL.objValue;
    }

    public void A3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.W0 = z;
        }
    }

    public final void u3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view2) == null) {
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ea2);
            this.T0 = imageView;
            imageView.setOnClickListener(new e(this));
        }
    }

    public final void x3(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, latLng) == null) {
            this.P0 = GeoCoder.newInstance();
            this.P0.setOnGetGeoCodeResultListener(new b(this));
            this.P0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutInflater, viewGroup, bundle)) == null) {
            g32.i("map", "start MapLocationFragment");
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0090, viewGroup, false);
            a2(inflate);
            E2(f2());
            Q2(false);
            v3(inflate);
            t3(inflate);
            D3();
            u3(inflate);
            C2(AppRuntime.getAppContext().getResources().getString(R.string.obfuscated_res_0x7f0f01ce));
            if (Z1()) {
                inflate = c2(inflate);
            }
            return J1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    public final void B3() {
        FragmentActivity n;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (n = n()) == null) {
            return;
        }
        PopupWindow popupWindow = this.Q0;
        if (popupWindow != null && popupWindow.z()) {
            return;
        }
        View inflate = View.inflate(n, R.layout.obfuscated_res_0x7f0d00c8, null);
        inflate.setOnClickListener(new c(this));
        OpenLocationBottomMenu openLocationBottomMenu = (OpenLocationBottomMenu) inflate.findViewById(R.id.obfuscated_res_0x7f091a76);
        this.R0 = openLocationBottomMenu;
        openLocationBottomMenu.setFragment(this);
        PopupWindow popupWindow2 = new PopupWindow(n);
        this.Q0 = popupWindow2;
        popupWindow2.G(inflate);
        this.Q0.N(-1);
        this.Q0.I(-2);
        this.Q0.H(true);
        this.Q0.L(true);
        this.Q0.D(R.style.obfuscated_res_0x7f100154);
        this.Q0.P(this.S0, 80, 0, 0);
        this.Q0.K(new d(this));
        n3(this.S0, this.Y0);
    }

    public final void n3(View view2, float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLF(1048587, this, view2, f2) != null) || view2 == null) {
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

    public final void t3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view2) == null) {
            this.S0 = view2;
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0916b4);
            this.M0 = imageView;
            imageView.setOnClickListener(new a(this));
            this.N0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0916ba);
            this.O0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0916b9);
        }
    }

    public final void v3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view2) == null) {
            TextureMapView textureMapView = (TextureMapView) view2.findViewById(R.id.obfuscated_res_0x7f090390);
            this.G0 = textureMapView;
            BaiduMap map = textureMapView.getMap();
            this.H0 = map;
            map.getUiSettings().setRotateGesturesEnabled(false);
            this.G0.showZoomControls(false);
            this.H0.getUiSettings().setOverlookingGesturesEnabled(false);
            this.H0.setOnMapLoadedCallback(this);
        }
    }

    public void w3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.g0 == null) {
            this.g0 = new nc4(z(), this.f0, 12, np2.K(), new pl3());
            new wv2(this.g0, this).z();
        }
    }

    public final void z3() {
        Bundle r;
        String str;
        TextView textView;
        TextView textView2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (r = r()) != null && r.size() > 0) {
            this.I0 = r.getString("slaveId");
            double d2 = r.getDouble("latitude");
            double d3 = r.getDouble("longitude");
            double d4 = r.getDouble("scale");
            this.K0 = r.getString("name");
            this.L0 = r.getString("address");
            LatLng latLng = new LatLng(d2, d3);
            if (TextUtils.isEmpty(this.K0)) {
                if (TextUtils.isEmpty(this.L0)) {
                    x3(latLng);
                } else {
                    this.K0 = L().getString(R.string.obfuscated_res_0x7f0f17ae);
                }
            }
            this.H0.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.H0.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d4));
            BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(R.drawable.obfuscated_res_0x7f0801aa);
            if (TextUtils.isEmpty(this.K0)) {
                str = "";
            } else {
                str = this.K0;
            }
            this.J0 = (Marker) this.H0.addOverlay(new MarkerOptions().position(latLng).icon(fromResource).title(str).anchor(0.5f, 0.5f));
            g32.i("map", "show marker");
            if (!TextUtils.isEmpty(this.K0) && (textView2 = this.N0) != null) {
                textView2.setText(this.K0);
            }
            if (!TextUtils.isEmpty(this.L0) && (textView = this.O0) != null) {
                textView.setText(this.L0);
            }
            this.X0 = r.getStringArrayList("ignoredApps");
        }
    }
}
