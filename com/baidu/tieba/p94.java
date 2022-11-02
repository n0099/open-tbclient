package com.baidu.tieba;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.LogoPosition;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.swan.map.location.FlipperFrameLayout;
import com.baidu.swan.map.location.LocationDetailAdapter;
import com.baidu.swan.map.location.LocationItemDecoration;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.n32;
import com.baidu.tieba.t94;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class p94 extends k32 implements OnGetGeoCoderResultListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, View.OnClickListener, q94, t94.b {
    public static /* synthetic */ Interceptable $ic;
    public static final int d1;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView F0;
    public FrameLayout G0;
    public ImageView H0;
    public FrameLayout I0;
    public FrameLayout J0;
    public View K0;
    public View L0;
    public TextView M0;
    public ImageView N0;
    public View O0;
    public GeoCoder P0;
    public BaiduMap Q0;
    public TextureMapView R0;
    public Marker S0;
    public BitmapDescriptor T0;
    public r94 U0;
    public List<r94> V0;
    public t94 W0;
    public LocationDetailAdapter X0;
    public s94 Y0;
    public boolean Z0;
    public boolean a1;
    public b b1;
    public SelectedLocationInfo c1;

    /* loaded from: classes5.dex */
    public interface b {
        void a(SelectedLocationInfo selectedLocationInfo);

        void onCancel();

        void onError();
    }

    @Override // com.baidu.tieba.k32
    public void U1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
        }
    }

    @Override // com.baidu.tieba.k32
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.k32
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.k32, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.k32
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, geoCodeResult) == null) {
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, mapStatus) == null) {
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, mapStatus) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReverseGeoCodeResult a;
        public final /* synthetic */ p94 b;

        public a(p94 p94Var, ReverseGeoCodeResult reverseGeoCodeResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p94Var, reverseGeoCodeResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p94Var;
            this.a = reverseGeoCodeResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.l3(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948016862, "Lcom/baidu/tieba/p94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948016862, "Lcom/baidu/tieba/p94;");
                return;
            }
        }
        d1 = vh3.g(20.0f);
    }

    public p94() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.k32
    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            e3(17);
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Activity activity = this.c0;
            if (activity != null) {
                activity.onBackPressed();
            }
            this.b1 = null;
        }
    }

    public final void d3() {
        Marker marker;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (marker = this.S0) != null) {
            marker.remove();
            this.S0 = null;
        }
    }

    public void i3() {
        n32 V;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (V = rp2.U().V()) != null) {
            n32.b i = V.i("navigateTo");
            i.n(n32.g, n32.i);
            i.j(this);
            i.b();
        }
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            t94 t94Var = new t94(rp2.U().getActivity(), this.Q0);
            this.W0 = t94Var;
            t94Var.n(true);
            this.W0.k(this);
            h3(true);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            X2(this.Q0.getMapStatus().target);
        }
    }

    @Override // com.baidu.tieba.k32, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onPause();
            this.R0.onPause();
            t94 t94Var = this.W0;
            if (t94Var != null) {
                t94Var.n(false);
            }
        }
    }

    @Override // com.baidu.tieba.k32, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onResume();
            this.R0.onResume();
            t94 t94Var = this.W0;
            if (t94Var != null) {
                t94Var.n(true);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.y0();
            if (Build.VERSION.SDK_INT > 19) {
                this.R0.onDestroy();
            }
            this.P0.destroy();
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048608, this, mapStatus, i) == null) {
            boolean z2 = false;
            if (i == 1) {
                z = true;
            } else {
                z = false;
            }
            this.Z0 = z;
            this.a1 = (z || this.a1) ? true : true;
        }
    }

    public static p94 b3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bundle)) == null) {
            p94 p94Var = new p94();
            if (bundle != null) {
                p94Var.j1(bundle);
            }
            return p94Var;
        }
        return (p94) invokeL.objValue;
    }

    public final void X2(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, latLng) == null) {
            this.P0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
        }
    }

    @Override // com.baidu.tieba.t94.b
    public void a(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bDLocation) == null) {
            X2(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
        }
    }

    public final void f3(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && this.H0 != null) {
            if (z) {
                i = R.drawable.obfuscated_res_0x7f08018e;
            } else {
                i = R.drawable.obfuscated_res_0x7f08018d;
            }
            this.H0.setImageResource(i);
        }
    }

    public void g3(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            this.b1 = bVar;
        }
    }

    public final void h3(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (z) {
                this.V0.clear();
                this.X0.setData(this.V0);
            }
            View view2 = this.O0;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }

    public final void k3(r94 r94Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, r94Var) == null) && r94Var != null && r94Var.a != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", r94Var.a.city);
            v94 c3 = v94.c3(bundle);
            c3.l1(this, 1);
            c3.i3();
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, reverseGeoCodeResult) == null) && reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.F0.postDelayed(new a(this, reverseGeoCodeResult), 150L);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, mapStatus) == null) && this.Z0) {
            c3(mapStatus.target, true, true);
            f3(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void J0(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, strArr, iArr) == null) {
            super.J0(i, strArr, iArr);
            if (i == 3001) {
                if (iArr.length > 0 && iArr[0] == -1) {
                    w33.f(rp2.U().getActivity(), R.string.obfuscated_res_0x7f0f019e).G();
                } else if (iArr.length > 0 && iArr[0] == 0) {
                    j3();
                }
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048612, this, layoutInflater, viewGroup, bundle)) == null) {
            l84.a();
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0085, viewGroup, false);
            Y2(inflate);
            Z2();
            if (T1()) {
                inflate = W1(inflate);
                w1(-1);
            }
            return D1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    public final void V2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.N0, Key.TRANSLATION_Y, 0.0f, -d1, 0.0f);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.setDuration(500L);
            ofFloat.start();
        }
    }

    public final void Z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.Q0.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
            this.Q0.getUiSettings().setRotateGesturesEnabled(false);
            this.R0.showZoomControls(false);
            this.R0.setLogoPosition(LogoPosition.logoPostionRightBottom);
            if (a3()) {
                return;
            }
            j3();
        }
    }

    public final void Y2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            SDKInitializer.setCoordType(CoordType.GCJ02);
            this.V0 = new ArrayList(11);
            this.F0 = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091465);
            this.H0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090a09);
            this.G0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a0a);
            this.K0 = view2.findViewById(R.id.obfuscated_res_0x7f0904ad);
            this.L0 = view2.findViewById(R.id.obfuscated_res_0x7f091e20);
            this.M0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0909d9);
            this.N0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0905f7);
            this.I0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091359);
            this.J0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0914da);
            this.O0 = view2.findViewById(R.id.obfuscated_res_0x7f09144e);
            this.R0 = (TextureMapView) view2.findViewById(R.id.obfuscated_res_0x7f09036c);
            this.H0.setOnClickListener(this);
            this.M0.setOnClickListener(this);
            this.L0.setOnClickListener(this);
            this.K0.setOnClickListener(this);
            this.P0 = GeoCoder.newInstance();
            this.Q0 = this.R0.getMap();
            this.P0.setOnGetGeoCodeResultListener(this);
            this.Q0.setOnMapLoadedCallback(this);
            this.Q0.setOnMapStatusChangeListener(this);
            this.F0.setLayoutManager(new LinearLayoutManager(rp2.U().getActivity()));
            LocationDetailAdapter locationDetailAdapter = new LocationDetailAdapter(rp2.U().getActivity(), this.F0, this, false);
            this.X0 = locationDetailAdapter;
            this.F0.setAdapter(locationDetailAdapter);
            this.F0.addItemDecoration(new LocationItemDecoration(rp2.U().getActivity(), true));
            s94 s94Var = new s94(this.I0, this.J0, this.G0);
            this.Y0 = s94Var;
            ((FlipperFrameLayout) this.I0).setViewFlipper(s94Var);
        }
    }

    public final boolean a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                ArrayList arrayList = new ArrayList();
                if (rp2.U().getActivity().checkSelfPermission(com.kuaishou.weapon.p0.h.g) != 0) {
                    arrayList.add(com.kuaishou.weapon.p0.h.g);
                }
                if (arrayList.size() > 0) {
                    requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), 0);
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c3(LatLng latLng, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{latLng, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            h3(true);
            X2(latLng);
            d3();
            if (z) {
                V2();
                if (this.Y0.d()) {
                    this.Y0.e(false);
                }
            }
            if (z2) {
                this.F0.smoothScrollToPosition(0);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void q0(int i, int i2, Intent intent) {
        SelectedLocationInfo selectedLocationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048611, this, i, i2, intent) == null) {
            super.q0(i, i2, intent);
            if (intent == null || i != 1 || (selectedLocationInfo = (SelectedLocationInfo) intent.getParcelableExtra(SelectedLocationInfo.LOCATION_KEY)) == null) {
                return;
            }
            double d = selectedLocationInfo.mLatitude;
            double d2 = selectedLocationInfo.mLongitude;
            if (!Double.isNaN(d) && !Double.isNaN(d2)) {
                this.c1 = selectedLocationInfo;
                LatLng latLng = new LatLng(d, d2);
                this.Q0.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                this.a1 = true;
                c3(latLng, false, true);
                f3(false);
            }
        }
    }

    @Override // com.baidu.tieba.q94
    public void e(r94 r94Var) {
        PoiInfo poiInfo;
        LatLng latLng;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, r94Var) == null) && r94Var != null && (poiInfo = r94Var.a) != null && (latLng = poiInfo.location) != null) {
            this.U0 = r94Var;
            this.Q0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            d3();
            if (this.T0 == null) {
                this.T0 = BitmapDescriptorFactory.fromResource(R.drawable.obfuscated_res_0x7f080198);
            }
            if (!r94Var.c) {
                this.S0 = (Marker) this.Q0.addOverlay(new MarkerOptions().position(r94Var.a.location).zIndex(88).icon(this.T0));
            }
            if (!r94Var.c) {
                f3(false);
            }
        }
    }

    public final void l3(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, reverseGeoCodeResult) == null) {
            PoiInfo poiInfo = new PoiInfo();
            SelectedLocationInfo selectedLocationInfo = this.c1;
            if (selectedLocationInfo != null) {
                poiInfo.name = selectedLocationInfo.mName;
                SelectedLocationInfo selectedLocationInfo2 = this.c1;
                poiInfo.location = new LatLng(selectedLocationInfo2.mLatitude, selectedLocationInfo2.mLongitude);
                poiInfo.address = this.c1.mAddress;
                this.c1 = null;
                z = false;
            } else {
                String address = reverseGeoCodeResult.getAddress();
                String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                if (TextUtils.isEmpty(address)) {
                    address = "[位置]";
                }
                poiInfo.name = address;
                poiInfo.location = reverseGeoCodeResult.getLocation();
                poiInfo.address = sematicDescription;
                ReverseGeoCodeResult.AddressComponent addressDetail = reverseGeoCodeResult.getAddressDetail();
                if (addressDetail != null) {
                    poiInfo.city = addressDetail.city;
                }
                z = true;
            }
            r94 r94Var = new r94(poiInfo, true, z);
            this.V0.clear();
            this.V0.add(r94Var);
            this.V0.addAll(r94.a(reverseGeoCodeResult.getPoiList()));
            this.X0.setData(this.V0);
            this.U0 = r94Var;
            if (this.V0.size() > 0) {
                h3(false);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f090a09) {
                t94 t94Var = this.W0;
                if (t94Var != null && t94Var.i() != null) {
                    BDLocation i = this.W0.i();
                    LatLng latLng = new LatLng(i.getLatitude(), i.getLongitude());
                    this.Q0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                    d3();
                    if (this.a1) {
                        c3(latLng, true, true);
                        this.a1 = false;
                    }
                    f3(true);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0909d9) {
                e3(16);
                W2();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091e20) {
                k3(this.U0);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904ad) {
                e3(17);
                W2();
            }
        }
    }

    public final void e3(int i) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048591, this, i) != null) || (bVar = this.b1) == null) {
            return;
        }
        switch (i) {
            case 16:
                r94 r94Var = this.U0;
                if (r94Var != null) {
                    PoiInfo poiInfo = r94Var.a;
                    if (TextUtils.equals(poiInfo.name, "[位置]")) {
                        poiInfo.name = "";
                    }
                    this.b1.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                    return;
                }
                return;
            case 17:
                bVar.onCancel();
                return;
            case 18:
                bVar.onError();
                return;
            default:
                return;
        }
    }
}
