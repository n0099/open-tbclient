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
import com.baidu.tieba.lb2;
import com.baidu.tieba.rh4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class nh4 extends ib2 implements OnGetGeoCoderResultListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, View.OnClickListener, oh4, rh4.b {
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
    public ph4 V0;
    public List<ph4> W0;
    public rh4 X0;
    public LocationDetailAdapter Y0;
    public qh4 Z0;
    public boolean a1;
    public boolean b1;
    public b c1;
    public SelectedLocationInfo d1;

    /* loaded from: classes7.dex */
    public interface b {
        void a(SelectedLocationInfo selectedLocationInfo);

        void onCancel();

        void onError();
    }

    @Override // com.baidu.tieba.ib2
    public void W1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
        }
    }

    @Override // com.baidu.tieba.ib2
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ib2
    public boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ib2, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ib2
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

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReverseGeoCodeResult a;
        public final /* synthetic */ nh4 b;

        public a(nh4 nh4Var, ReverseGeoCodeResult reverseGeoCodeResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nh4Var, reverseGeoCodeResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nh4Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948002447, "Lcom/baidu/tieba/nh4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948002447, "Lcom/baidu/tieba/nh4;");
                return;
            }
        }
        e1 = tp3.g(20.0f);
    }

    public nh4() {
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

    @Override // com.baidu.tieba.ib2
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
        lb2 U;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (U = px2.T().U()) != null) {
            lb2.b i = U.i("navigateTo");
            i.n(lb2.g, lb2.i);
            i.j(this);
            i.b();
        }
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            rh4 rh4Var = new rh4(px2.T().getActivity(), this.R0);
            this.X0 = rh4Var;
            rh4Var.n(true);
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

    @Override // com.baidu.tieba.ib2, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onPause();
            this.S0.onPause();
            rh4 rh4Var = this.X0;
            if (rh4Var != null) {
                rh4Var.n(false);
            }
        }
    }

    @Override // com.baidu.tieba.ib2, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onResume();
            this.S0.onResume();
            rh4 rh4Var = this.X0;
            if (rh4Var != null) {
                rh4Var.n(true);
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

    public static nh4 d3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bundle)) == null) {
            nh4 nh4Var = new nh4();
            if (bundle != null) {
                nh4Var.k1(bundle);
            }
            return nh4Var;
        }
        return (nh4) invokeL.objValue;
    }

    public final void Z2(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, latLng) == null) {
            this.Q0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
        }
    }

    @Override // com.baidu.tieba.rh4.b
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

    public final void m3(ph4 ph4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, ph4Var) == null) && ph4Var != null && ph4Var.a != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", ph4Var.a.city);
            th4 e3 = th4.e3(bundle);
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
                    ub3.f(px2.T().getActivity(), R.string.obfuscated_res_0x7f0f01ca).G();
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
            jg4.a();
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0089, viewGroup, false);
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
            this.G0 = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f09162c);
            this.I0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090b33);
            this.H0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090b35);
            this.L0 = view2.findViewById(R.id.obfuscated_res_0x7f09052b);
            this.M0 = view2.findViewById(R.id.obfuscated_res_0x7f092092);
            this.N0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090afa);
            this.O0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090687);
            this.J0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091514);
            this.K0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0916a5);
            this.P0 = view2.findViewById(R.id.obfuscated_res_0x7f091612);
            this.S0 = (TextureMapView) view2.findViewById(R.id.obfuscated_res_0x7f090372);
            this.I0.setOnClickListener(this);
            this.N0.setOnClickListener(this);
            this.M0.setOnClickListener(this);
            this.L0.setOnClickListener(this);
            this.Q0 = GeoCoder.newInstance();
            this.R0 = this.S0.getMap();
            this.Q0.setOnGetGeoCodeResultListener(this);
            this.R0.setOnMapLoadedCallback(this);
            this.R0.setOnMapStatusChangeListener(this);
            this.G0.setLayoutManager(new LinearLayoutManager(px2.T().getActivity()));
            LocationDetailAdapter locationDetailAdapter = new LocationDetailAdapter(px2.T().getActivity(), this.G0, this, false);
            this.Y0 = locationDetailAdapter;
            this.G0.setAdapter(locationDetailAdapter);
            this.G0.addItemDecoration(new LocationItemDecoration(px2.T().getActivity(), true));
            qh4 qh4Var = new qh4(this.J0, this.K0, this.H0);
            this.Z0 = qh4Var;
            ((FlipperFrameLayout) this.J0).setViewFlipper(qh4Var);
        }
    }

    public final boolean c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                ArrayList arrayList = new ArrayList();
                if (px2.T().getActivity().checkSelfPermission(com.kuaishou.weapon.p0.h.g) != 0) {
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

    @Override // com.baidu.tieba.oh4
    public void d(ph4 ph4Var) {
        PoiInfo poiInfo;
        LatLng latLng;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, ph4Var) == null) && ph4Var != null && (poiInfo = ph4Var.a) != null && (latLng = poiInfo.location) != null) {
            this.V0 = ph4Var;
            this.R0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            f3();
            if (this.U0 == null) {
                this.U0 = BitmapDescriptorFactory.fromResource(R.drawable.obfuscated_res_0x7f0801b2);
            }
            if (!ph4Var.c) {
                this.T0 = (Marker) this.R0.addOverlay(new MarkerOptions().position(ph4Var.a.location).zIndex(88).icon(this.U0));
            }
            if (!ph4Var.c) {
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
            ph4 ph4Var = new ph4(poiInfo, true, z);
            this.W0.clear();
            this.W0.add(ph4Var);
            this.W0.addAll(ph4.a(reverseGeoCodeResult.getPoiList()));
            this.Y0.setData(this.W0);
            this.V0 = ph4Var;
            if (this.W0.size() > 0) {
                j3(false);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f090b33) {
                rh4 rh4Var = this.X0;
                if (rh4Var != null && rh4Var.i() != null) {
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
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090afa) {
                g3(16);
                Y2();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092092) {
                m3(this.V0);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09052b) {
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
                ph4 ph4Var = this.V0;
                if (ph4Var != null) {
                    PoiInfo poiInfo = ph4Var.a;
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
