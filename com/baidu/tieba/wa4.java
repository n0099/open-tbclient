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
import com.baidu.tieba.pb4;
import com.baidu.tieba.y42;
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
/* loaded from: classes8.dex */
public class wa4 extends v42 implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
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
    public pb4 U0;
    public BDLocation V0;
    public boolean W0;
    public ArrayList<String> X0;
    public float Y0;

    @Override // com.baidu.tieba.v42
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.v42, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.v42
    public boolean j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.v42
    public boolean l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wa4 a;

        public a(wa4 wa4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wa4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wa4Var;
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

    /* loaded from: classes8.dex */
    public class b implements OnGetGeoCoderResultListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wa4 a;

        @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
        public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, geoCodeResult) == null) {
            }
        }

        public b(wa4 wa4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wa4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wa4Var;
        }

        @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
        public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, reverseGeoCodeResult) == null) {
                if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
                    if (this.a.O0 != null && TextUtils.isEmpty(this.a.L0)) {
                        String address = reverseGeoCodeResult.getAddress();
                        wa4 wa4Var = this.a;
                        if (address == null) {
                            address = wa4Var.J().getString(R.string.obfuscated_res_0x7f0f1797);
                        }
                        wa4Var.L0 = address;
                        this.a.O0.setText(this.a.L0);
                    }
                    if (this.a.N0 != null && TextUtils.isEmpty(this.a.K0)) {
                        String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                        wa4 wa4Var2 = this.a;
                        if (sematicDescription == null) {
                            sematicDescription = wa4Var2.J().getString(R.string.obfuscated_res_0x7f0f1797);
                        }
                        wa4Var2.K0 = sematicDescription;
                        this.a.N0.setText(this.a.K0);
                    }
                    p22.i("map", "mAddress +" + this.a.L0 + " mName" + this.a.K0);
                    return;
                }
                this.a.N0.setText(R.string.obfuscated_res_0x7f0f1797);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wa4 a;

        public c(wa4 wa4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wa4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wa4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.o3();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wa4 a;

        public d(wa4 wa4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wa4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wa4Var;
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wa4 wa4Var = this.a;
                wa4Var.n3(wa4Var.S0, 1.0f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wa4 a;

        public e(wa4 wa4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wa4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wa4Var;
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

    /* loaded from: classes8.dex */
    public class f implements pb4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wa4 a;

        public f(wa4 wa4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wa4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wa4Var;
        }

        @Override // com.baidu.tieba.pb4.b
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948263839, "Lcom/baidu/tieba/wa4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948263839, "Lcom/baidu/tieba/wa4;");
                return;
            }
        }
        boolean z = am1.a;
    }

    public wa4() {
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
            pb4 pb4Var = this.U0;
            if (pb4Var != null) {
                pb4Var.n(false);
            }
            if (Build.VERSION.SDK_INT > 19 && (textureMapView = this.G0) != null) {
                textureMapView.onDestroy();
            }
        }
    }

    public void C3() {
        y42 W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (W = cr2.V().W()) != null) {
            y42.b i = W.i("navigateTo");
            i.n(y42.g, y42.i);
            i.j(this);
            i.b();
        }
    }

    public final void D3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            pb4 pb4Var = new pb4(cr2.V().getActivity(), this.H0);
            this.U0 = pb4Var;
            pb4Var.n(true);
            this.U0.k(new f(this));
        }
    }

    @Override // com.baidu.tieba.v42
    public void T2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.I0);
            cr2.V().v(new qf2("sharebtn", hashMap));
        }
    }

    public void o3() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (popupWindow = this.Q0) != null && popupWindow.y()) {
            this.Q0.q();
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            p22.i("map", "onMapLoaded");
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

    @Override // com.baidu.tieba.v42
    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            w3();
            this.g0.s(wo2.M().a(), N1());
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

    public static wa4 y3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bundle)) == null) {
            wa4 wa4Var = new wa4();
            if (bundle != null) {
                wa4Var.n1(bundle);
            }
            w94.a();
            return wa4Var;
        }
        return (wa4) invokeL.objValue;
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
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e6b);
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
            p22.i("map", "start MapLocationFragment");
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d008e, viewGroup, false);
            b2(inflate);
            E2(g2());
            Q2(false);
            v3(inflate);
            t3(inflate);
            D3();
            u3(inflate);
            C2(AppRuntime.getAppContext().getResources().getString(R.string.obfuscated_res_0x7f0f01ce));
            if (a2()) {
                inflate = d2(inflate);
            }
            return J1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    public final void B3() {
        FragmentActivity m;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (m = m()) == null) {
            return;
        }
        PopupWindow popupWindow = this.Q0;
        if (popupWindow != null && popupWindow.y()) {
            return;
        }
        View inflate = View.inflate(m, R.layout.obfuscated_res_0x7f0d00c6, null);
        inflate.setOnClickListener(new c(this));
        OpenLocationBottomMenu openLocationBottomMenu = (OpenLocationBottomMenu) inflate.findViewById(R.id.obfuscated_res_0x7f091a2f);
        this.R0 = openLocationBottomMenu;
        openLocationBottomMenu.setFragment(this);
        PopupWindow popupWindow2 = new PopupWindow(m);
        this.Q0 = popupWindow2;
        popupWindow2.F(inflate);
        this.Q0.M(-1);
        this.Q0.H(-2);
        this.Q0.G(true);
        this.Q0.K(true);
        this.Q0.C(R.style.obfuscated_res_0x7f100154);
        this.Q0.O(this.S0, 80, 0, 0);
        this.Q0.J(new d(this));
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
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091674);
            this.M0 = imageView;
            imageView.setOnClickListener(new a(this));
            this.N0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09167a);
            this.O0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091679);
        }
    }

    public final void v3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view2) == null) {
            TextureMapView textureMapView = (TextureMapView) view2.findViewById(R.id.obfuscated_res_0x7f090377);
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
            this.g0 = new wb4(s(), this.f0, 12, wo2.K(), new yk3());
            new fv2(this.g0, this).z();
        }
    }

    public final void z3() {
        Bundle p;
        String str;
        TextView textView;
        TextView textView2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (p = p()) != null && p.size() > 0) {
            this.I0 = p.getString("slaveId");
            double d2 = p.getDouble("latitude");
            double d3 = p.getDouble("longitude");
            double d4 = p.getDouble("scale");
            this.K0 = p.getString("name");
            this.L0 = p.getString("address");
            LatLng latLng = new LatLng(d2, d3);
            if (TextUtils.isEmpty(this.K0)) {
                if (TextUtils.isEmpty(this.L0)) {
                    x3(latLng);
                } else {
                    this.K0 = J().getString(R.string.obfuscated_res_0x7f0f1796);
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
            p22.i("map", "show marker");
            if (!TextUtils.isEmpty(this.K0) && (textView2 = this.N0) != null) {
                textView2.setText(this.K0);
            }
            if (!TextUtils.isEmpty(this.L0) && (textView = this.O0) != null) {
                textView.setText(this.L0);
            }
            this.X0 = p.getStringArrayList("ignoredApps");
        }
    }
}
