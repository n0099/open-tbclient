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
import com.baidu.tieba.h22;
import com.baidu.tieba.n84;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class j84 extends e22 implements OnGetGeoCoderResultListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, View.OnClickListener, k84, n84.b {
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
    public l84 U0;
    public List<l84> V0;
    public n84 W0;
    public LocationDetailAdapter X0;
    public m84 Y0;
    public boolean Z0;
    public boolean a1;
    public b b1;
    public SelectedLocationInfo c1;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReverseGeoCodeResult a;
        public final /* synthetic */ j84 b;

        public a(j84 j84Var, ReverseGeoCodeResult reverseGeoCodeResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j84Var, reverseGeoCodeResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j84Var;
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

    /* loaded from: classes4.dex */
    public interface b {
        void a(SelectedLocationInfo selectedLocationInfo);

        void onCancel();

        void onError();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947837155, "Lcom/baidu/tieba/j84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947837155, "Lcom/baidu/tieba/j84;");
                return;
            }
        }
        d1 = pg3.g(20.0f);
    }

    public j84() {
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

    public static j84 b3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bundle)) == null) {
            j84 j84Var = new j84();
            if (bundle != null) {
                j84Var.j1(bundle);
            }
            return j84Var;
        }
        return (j84) invokeL.objValue;
    }

    @Override // com.baidu.tieba.e22
    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            e3(17);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void J0(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, strArr, iArr) == null) {
            super.J0(i, strArr, iArr);
            if (i == 3001) {
                if (iArr.length > 0 && iArr[0] == -1) {
                    q23.f(lo2.U().getActivity(), R.string.obfuscated_res_0x7f0f019e).G();
                } else if (iArr.length <= 0 || iArr[0] != 0) {
                } else {
                    j3();
                }
            }
        }
    }

    @Override // com.baidu.tieba.e22
    public void U1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
        }
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

    public final void X2(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, latLng) == null) {
            this.P0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
        }
    }

    public final void Y2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            SDKInitializer.setCoordType(CoordType.GCJ02);
            this.V0 = new ArrayList(11);
            this.F0 = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091434);
            this.H0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0909ec);
            this.G0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0909ed);
            this.K0 = view2.findViewById(R.id.obfuscated_res_0x7f090497);
            this.L0 = view2.findViewById(R.id.obfuscated_res_0x7f091dd8);
            this.M0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0909bf);
            this.N0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0905e1);
            this.I0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09132c);
            this.J0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0914a9);
            this.O0 = view2.findViewById(R.id.obfuscated_res_0x7f09141d);
            this.R0 = (TextureMapView) view2.findViewById(R.id.obfuscated_res_0x7f09035e);
            this.H0.setOnClickListener(this);
            this.M0.setOnClickListener(this);
            this.L0.setOnClickListener(this);
            this.K0.setOnClickListener(this);
            this.P0 = GeoCoder.newInstance();
            this.Q0 = this.R0.getMap();
            this.P0.setOnGetGeoCodeResultListener(this);
            this.Q0.setOnMapLoadedCallback(this);
            this.Q0.setOnMapStatusChangeListener(this);
            this.F0.setLayoutManager(new LinearLayoutManager(lo2.U().getActivity()));
            LocationDetailAdapter locationDetailAdapter = new LocationDetailAdapter(lo2.U().getActivity(), this.F0, this, false);
            this.X0 = locationDetailAdapter;
            this.F0.setAdapter(locationDetailAdapter);
            this.F0.addItemDecoration(new LocationItemDecoration(lo2.U().getActivity(), true));
            m84 m84Var = new m84(this.I0, this.J0, this.G0);
            this.Y0 = m84Var;
            ((FlipperFrameLayout) this.I0).setViewFlipper(m84Var);
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

    @Override // com.baidu.tieba.n84.b
    public void a(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bDLocation) == null) {
            X2(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
        }
    }

    public final boolean a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                ArrayList arrayList = new ArrayList();
                if (lo2.U().getActivity().checkSelfPermission(com.kuaishou.weapon.p0.h.g) != 0) {
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

    @Override // com.baidu.tieba.e22
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return true;
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

    public final void d3() {
        Marker marker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (marker = this.S0) == null) {
            return;
        }
        marker.remove();
        this.S0 = null;
    }

    @Override // com.baidu.tieba.k84
    public void e(l84 l84Var) {
        PoiInfo poiInfo;
        LatLng latLng;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, l84Var) == null) || l84Var == null || (poiInfo = l84Var.a) == null || (latLng = poiInfo.location) == null) {
            return;
        }
        this.U0 = l84Var;
        this.Q0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
        d3();
        if (this.T0 == null) {
            this.T0 = BitmapDescriptorFactory.fromResource(R.drawable.obfuscated_res_0x7f080198);
        }
        if (!l84Var.c) {
            this.S0 = (Marker) this.Q0.addOverlay(new MarkerOptions().position(l84Var.a.location).zIndex(88).icon(this.T0));
        }
        if (l84Var.c) {
            return;
        }
        f3(false);
    }

    @Override // com.baidu.tieba.e22
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void e3(int i) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i) == null) || (bVar = this.b1) == null) {
            return;
        }
        switch (i) {
            case 16:
                l84 l84Var = this.U0;
                if (l84Var != null) {
                    PoiInfo poiInfo = l84Var.a;
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

    public final void f3(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || this.H0 == null) {
            return;
        }
        this.H0.setImageResource(z ? R.drawable.obfuscated_res_0x7f08018e : R.drawable.obfuscated_res_0x7f08018d);
    }

    public void g3(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            this.b1 = bVar;
        }
    }

    public final void h3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (z) {
                this.V0.clear();
                this.X0.setData(this.V0);
            }
            this.O0.setVisibility(z ? 0 : 8);
        }
    }

    public void i3() {
        h22 V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (V = lo2.U().V()) == null) {
            return;
        }
        h22.b i = V.i("navigateTo");
        i.n(h22.g, h22.i);
        i.j(this);
        i.b();
    }

    @Override // com.baidu.tieba.e22, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.e22
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            n84 n84Var = new n84(lo2.U().getActivity(), this.Q0);
            this.W0 = n84Var;
            n84Var.n(true);
            this.W0.k(this);
            h3(true);
        }
    }

    public final void k3(l84 l84Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, l84Var) == null) || l84Var == null || l84Var.a == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("city", l84Var.a.city);
        p84 c3 = p84.c3(bundle);
        c3.l1(this, 1);
        c3.i3();
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
            l84 l84Var = new l84(poiInfo, true, z);
            this.V0.clear();
            this.V0.add(l84Var);
            this.V0.addAll(l84.a(reverseGeoCodeResult.getPoiList()));
            this.X0.setData(this.V0);
            this.U0 = l84Var;
            if (this.V0.size() > 0) {
                h3(false);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f0909ec) {
                n84 n84Var = this.W0;
                if (n84Var == null || n84Var.i() == null) {
                    return;
                }
                BDLocation i = this.W0.i();
                LatLng latLng = new LatLng(i.getLatitude(), i.getLongitude());
                this.Q0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                d3();
                if (this.a1) {
                    c3(latLng, true, true);
                    this.a1 = false;
                }
                f3(true);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0909bf) {
                e3(16);
                W2();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091dd8) {
                k3(this.U0);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090497) {
                e3(17);
                W2();
            }
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, geoCodeResult) == null) {
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, reverseGeoCodeResult) == null) && reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.F0.postDelayed(new a(this, reverseGeoCodeResult), 150L);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            X2(this.Q0.getMapStatus().target);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, mapStatus) == null) {
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

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, mapStatus) == null) {
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048608, this, mapStatus, i) == null) {
            boolean z = false;
            boolean z2 = i == 1;
            this.Z0 = z2;
            this.a1 = (z2 || this.a1) ? true : true;
        }
    }

    @Override // com.baidu.tieba.e22, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onPause();
            this.R0.onPause();
            n84 n84Var = this.W0;
            if (n84Var != null) {
                n84Var.n(false);
            }
        }
    }

    @Override // com.baidu.tieba.e22, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onResume();
            this.R0.onResume();
            n84 n84Var = this.W0;
            if (n84Var != null) {
                n84Var.n(true);
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
            if (Double.isNaN(d) || Double.isNaN(d2)) {
                return;
            }
            this.c1 = selectedLocationInfo;
            LatLng latLng = new LatLng(d, d2);
            this.Q0.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.a1 = true;
            c3(latLng, false, true);
            f3(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048612, this, layoutInflater, viewGroup, bundle)) == null) {
            f74.a();
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0084, viewGroup, false);
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
}
