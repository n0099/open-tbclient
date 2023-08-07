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
import com.baidu.tieba.ha2;
import com.baidu.tieba.ng4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class jg4 extends ea2 implements OnGetGeoCoderResultListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, View.OnClickListener, kg4, ng4.b {
    public static /* synthetic */ Interceptable $ic;
    public static final int e1;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView G0;
    public FrameLayout H0;
    public ImageView I0;
    public FrameLayout J0;
    public FrameLayout K0;
    public View L0;
    public View M0;
    public TextView N0;
    public ImageView O0;
    public View P0;
    public GeoCoder Q0;
    public BaiduMap R0;
    public TextureMapView S0;
    public Marker T0;
    public BitmapDescriptor U0;
    public lg4 V0;
    public List<lg4> W0;
    public ng4 X0;
    public LocationDetailAdapter Y0;
    public mg4 Z0;
    public boolean a1;
    public boolean b1;
    public b c1;
    public SelectedLocationInfo d1;

    /* loaded from: classes6.dex */
    public interface b {
        void a(SelectedLocationInfo selectedLocationInfo);

        void onCancel();

        void onError();
    }

    @Override // com.baidu.tieba.ea2
    public void W1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
        }
    }

    @Override // com.baidu.tieba.ea2
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ea2
    public boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ea2, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ea2
    public void l2() {
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

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReverseGeoCodeResult a;
        public final /* synthetic */ jg4 b;

        public a(jg4 jg4Var, ReverseGeoCodeResult reverseGeoCodeResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jg4Var, reverseGeoCodeResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jg4Var;
            this.a = reverseGeoCodeResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.n3(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947882322, "Lcom/baidu/tieba/jg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947882322, "Lcom/baidu/tieba/jg4;");
                return;
            }
        }
        e1 = po3.g(20.0f);
    }

    public jg4() {
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

    @Override // com.baidu.tieba.ea2
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            g3(17);
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Activity activity = this.c0;
            if (activity != null) {
                activity.onBackPressed();
            }
            this.c1 = null;
        }
    }

    public final void f3() {
        Marker marker;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (marker = this.T0) != null) {
            marker.remove();
            this.T0 = null;
        }
    }

    public void k3() {
        ha2 U;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (U = lw2.T().U()) != null) {
            ha2.b i = U.i("navigateTo");
            i.n(ha2.g, ha2.i);
            i.j(this);
            i.b();
        }
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            ng4 ng4Var = new ng4(lw2.T().getActivity(), this.R0);
            this.X0 = ng4Var;
            ng4Var.n(true);
            this.X0.k(this);
            j3(true);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            Z2(this.R0.getMapStatus().target);
        }
    }

    @Override // com.baidu.tieba.ea2, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onPause();
            this.S0.onPause();
            ng4 ng4Var = this.X0;
            if (ng4Var != null) {
                ng4Var.n(false);
            }
        }
    }

    @Override // com.baidu.tieba.ea2, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onResume();
            this.S0.onResume();
            ng4 ng4Var = this.X0;
            if (ng4Var != null) {
                ng4Var.n(true);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.z0();
            if (Build.VERSION.SDK_INT > 19) {
                this.S0.onDestroy();
            }
            this.Q0.destroy();
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
            this.a1 = z;
            this.b1 = (z || this.b1) ? true : true;
        }
    }

    public static jg4 d3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bundle)) == null) {
            jg4 jg4Var = new jg4();
            if (bundle != null) {
                jg4Var.k1(bundle);
            }
            return jg4Var;
        }
        return (jg4) invokeL.objValue;
    }

    public final void Z2(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, latLng) == null) {
            this.Q0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
        }
    }

    @Override // com.baidu.tieba.ng4.b
    public void a(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bDLocation) == null) {
            Z2(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
        }
    }

    public final void h3(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && this.I0 != null) {
            if (z) {
                i = R.drawable.obfuscated_res_0x7f0801a8;
            } else {
                i = R.drawable.obfuscated_res_0x7f0801a7;
            }
            this.I0.setImageResource(i);
        }
    }

    public void i3(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            this.c1 = bVar;
        }
    }

    public final void j3(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            if (z) {
                this.W0.clear();
                this.Y0.setData(this.W0);
            }
            View view2 = this.P0;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }

    public final void m3(lg4 lg4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, lg4Var) == null) && lg4Var != null && lg4Var.a != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", lg4Var.a.city);
            pg4 e3 = pg4.e3(bundle);
            e3.m1(this, 1);
            e3.k3();
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, reverseGeoCodeResult) == null) && reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.G0.postDelayed(new a(this, reverseGeoCodeResult), 150L);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, mapStatus) == null) && this.a1) {
            e3(mapStatus.target, true, true);
            h3(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void J0(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, strArr, iArr) == null) {
            super.J0(i, strArr, iArr);
            if (i == 3001) {
                if (iArr.length > 0 && iArr[0] == -1) {
                    qa3.f(lw2.T().getActivity(), R.string.obfuscated_res_0x7f0f01ca).G();
                } else if (iArr.length > 0 && iArr[0] == 0) {
                    l3();
                }
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048612, this, layoutInflater, viewGroup, bundle)) == null) {
            ff4.a();
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0088, viewGroup, false);
            a3(inflate);
            b3();
            if (V1()) {
                inflate = Y1(inflate);
                x1(-1);
            }
            return F1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    public final void X2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.O0, Key.TRANSLATION_Y, 0.0f, -e1, 0.0f);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.setDuration(500L);
            ofFloat.start();
        }
    }

    public final void b3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.R0.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
            this.R0.getUiSettings().setRotateGesturesEnabled(false);
            this.S0.showZoomControls(false);
            this.S0.setLogoPosition(LogoPosition.logoPostionRightBottom);
            if (c3()) {
                return;
            }
            l3();
        }
    }

    public final void a3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            SDKInitializer.setCoordType(CoordType.GCJ02);
            this.W0 = new ArrayList(11);
            this.G0 = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091653);
            this.I0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090b4d);
            this.H0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090b4f);
            this.L0 = view2.findViewById(R.id.obfuscated_res_0x7f090539);
            this.M0 = view2.findViewById(R.id.obfuscated_res_0x7f0920dd);
            this.N0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b14);
            this.O0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090696);
            this.J0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09153b);
            this.K0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0916cd);
            this.P0 = view2.findViewById(R.id.obfuscated_res_0x7f091639);
            this.S0 = (TextureMapView) view2.findViewById(R.id.obfuscated_res_0x7f090373);
            this.I0.setOnClickListener(this);
            this.N0.setOnClickListener(this);
            this.M0.setOnClickListener(this);
            this.L0.setOnClickListener(this);
            this.Q0 = GeoCoder.newInstance();
            this.R0 = this.S0.getMap();
            this.Q0.setOnGetGeoCodeResultListener(this);
            this.R0.setOnMapLoadedCallback(this);
            this.R0.setOnMapStatusChangeListener(this);
            this.G0.setLayoutManager(new LinearLayoutManager(lw2.T().getActivity()));
            LocationDetailAdapter locationDetailAdapter = new LocationDetailAdapter(lw2.T().getActivity(), this.G0, this, false);
            this.Y0 = locationDetailAdapter;
            this.G0.setAdapter(locationDetailAdapter);
            this.G0.addItemDecoration(new LocationItemDecoration(lw2.T().getActivity(), true));
            mg4 mg4Var = new mg4(this.J0, this.K0, this.H0);
            this.Z0 = mg4Var;
            ((FlipperFrameLayout) this.J0).setViewFlipper(mg4Var);
        }
    }

    public final boolean c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                ArrayList arrayList = new ArrayList();
                if (lw2.T().getActivity().checkSelfPermission(com.kuaishou.weapon.p0.h.g) != 0) {
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

    @Override // com.baidu.tieba.kg4
    public void d(lg4 lg4Var) {
        PoiInfo poiInfo;
        LatLng latLng;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, lg4Var) == null) && lg4Var != null && (poiInfo = lg4Var.a) != null && (latLng = poiInfo.location) != null) {
            this.V0 = lg4Var;
            this.R0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            f3();
            if (this.U0 == null) {
                this.U0 = BitmapDescriptorFactory.fromResource(R.drawable.obfuscated_res_0x7f0801b2);
            }
            if (!lg4Var.c) {
                this.T0 = (Marker) this.R0.addOverlay(new MarkerOptions().position(lg4Var.a.location).zIndex(88).icon(this.U0));
            }
            if (!lg4Var.c) {
                h3(false);
            }
        }
    }

    public final void n3(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, reverseGeoCodeResult) == null) {
            PoiInfo poiInfo = new PoiInfo();
            SelectedLocationInfo selectedLocationInfo = this.d1;
            if (selectedLocationInfo != null) {
                poiInfo.name = selectedLocationInfo.mName;
                SelectedLocationInfo selectedLocationInfo2 = this.d1;
                poiInfo.location = new LatLng(selectedLocationInfo2.mLatitude, selectedLocationInfo2.mLongitude);
                poiInfo.address = this.d1.mAddress;
                this.d1 = null;
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
            lg4 lg4Var = new lg4(poiInfo, true, z);
            this.W0.clear();
            this.W0.add(lg4Var);
            this.W0.addAll(lg4.a(reverseGeoCodeResult.getPoiList()));
            this.Y0.setData(this.W0);
            this.V0 = lg4Var;
            if (this.W0.size() > 0) {
                j3(false);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f090b4d) {
                ng4 ng4Var = this.X0;
                if (ng4Var != null && ng4Var.i() != null) {
                    BDLocation i = this.X0.i();
                    LatLng latLng = new LatLng(i.getLatitude(), i.getLongitude());
                    this.R0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                    f3();
                    if (this.b1) {
                        e3(latLng, true, true);
                        this.b1 = false;
                    }
                    h3(true);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090b14) {
                g3(16);
                Y2();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0920dd) {
                m3(this.V0);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090539) {
                g3(17);
                Y2();
            }
        }
    }

    public final void e3(LatLng latLng, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{latLng, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            j3(true);
            Z2(latLng);
            f3();
            if (z) {
                X2();
                if (this.Z0.d()) {
                    this.Z0.e(false);
                }
            }
            if (z2) {
                this.G0.smoothScrollToPosition(0);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void r0(int i, int i2, Intent intent) {
        SelectedLocationInfo selectedLocationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048611, this, i, i2, intent) == null) {
            super.r0(i, i2, intent);
            if (intent == null || i != 1 || (selectedLocationInfo = (SelectedLocationInfo) intent.getParcelableExtra(SelectedLocationInfo.LOCATION_KEY)) == null) {
                return;
            }
            double d = selectedLocationInfo.mLatitude;
            double d2 = selectedLocationInfo.mLongitude;
            if (!Double.isNaN(d) && !Double.isNaN(d2)) {
                this.d1 = selectedLocationInfo;
                LatLng latLng = new LatLng(d, d2);
                this.R0.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                this.b1 = true;
                e3(latLng, false, true);
                h3(false);
            }
        }
    }

    public final void g3(int i) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048591, this, i) != null) || (bVar = this.c1) == null) {
            return;
        }
        switch (i) {
            case 16:
                lg4 lg4Var = this.V0;
                if (lg4Var != null) {
                    PoiInfo poiInfo = lg4Var.a;
                    if (TextUtils.equals(poiInfo.name, "[位置]")) {
                        poiInfo.name = "";
                    }
                    this.c1.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
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
