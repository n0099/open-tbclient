package com.baidu.tieba;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class uh4 extends wh4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public static final int f;
    public transient /* synthetic */ FieldHolder $fh;
    public DrivingRouteLine d;

    public abstract int f();

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948210984, "Lcom/baidu/tieba/uh4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948210984, "Lcom/baidu/tieba/uh4;");
                return;
            }
        }
        e = js1.a;
        f = Color.argb(178, 0, 78, 255);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uh4(BaiduMap baiduMap) {
        super(baiduMap);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baiduMap};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BaiduMap) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = null;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public final boolean onMarkerClick(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, marker)) == null) {
            for (Overlay overlay : this.c) {
                if ((overlay instanceof Marker) && overlay.equals(marker) && marker.getExtraInfo() != null) {
                    g(marker.getExtraInfo().getInt("index"));
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnPolylineClickListener
    public boolean onPolylineClick(Polyline polyline) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, polyline)) == null) {
            Iterator<Overlay> it = this.c.iterator();
            while (true) {
                if (it.hasNext()) {
                    Overlay next = it.next();
                    if ((next instanceof Polyline) && next.equals(polyline)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            i(z);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.wh4
    public final List<OverlayOptions> b() {
        InterceptResult invokeV;
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.d == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<DrivingRouteLine.DrivingStep> allStep = this.d.getAllStep();
            if (allStep != null && allStep.size() > 0) {
                for (DrivingRouteLine.DrivingStep drivingStep : allStep) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("index", allStep.indexOf(drivingStep));
                    if (drivingStep.getEntrance() != null) {
                        arrayList.add(new MarkerOptions().position(drivingStep.getEntrance().getLocation()).anchor(0.5f, 0.5f).zIndex(10).rotate(360 - drivingStep.getDirection()).extraInfo(bundle).icon(BitmapDescriptorFactory.fromResource(R.drawable.obfuscated_res_0x7f080191)));
                    }
                    if (allStep.indexOf(drivingStep) == allStep.size() - 1 && drivingStep.getExit() != null) {
                        arrayList.add(new MarkerOptions().position(drivingStep.getExit().getLocation()).anchor(0.5f, 0.5f).zIndex(10).icon(BitmapDescriptorFactory.fromResource(R.drawable.obfuscated_res_0x7f080191)));
                    }
                }
            }
            if (allStep != null && allStep.size() > 0) {
                int size = allStep.size();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                for (int i2 = 0; i2 < size; i2++) {
                    List<LatLng> wayPoints = allStep.get(i2).getWayPoints();
                    if (i2 == size - 1) {
                        arrayList2.addAll(wayPoints);
                    } else {
                        arrayList2.addAll(wayPoints.subList(0, wayPoints.size() - 1));
                    }
                    wayPoints.size();
                    int[] trafficList = allStep.get(i2).getTrafficList();
                    if (trafficList != null && trafficList.length > 0) {
                        for (int i3 : trafficList) {
                            arrayList3.add(Integer.valueOf(i3));
                        }
                    }
                }
                if (arrayList3.size() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                PolylineOptions focus = new PolylineOptions().points(arrayList2).textureIndex(arrayList3).width(14).dottedLine(z).focus(true);
                if (f() != 0) {
                    i = f();
                } else {
                    i = f;
                }
                PolylineOptions zIndex = focus.color(i).zIndex(0);
                if (z) {
                    zIndex.customTextureList(e());
                }
                arrayList.add(zIndex);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public List<BitmapDescriptor> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(BitmapDescriptorFactory.fromAsset("Icon_road_blue_arrow.png"));
            arrayList.add(BitmapDescriptorFactory.fromAsset("Icon_road_green_arrow.png"));
            arrayList.add(BitmapDescriptorFactory.fromAsset("Icon_road_yellow_arrow.png"));
            arrayList.add(BitmapDescriptorFactory.fromAsset("Icon_road_red_arrow.png"));
            arrayList.add(BitmapDescriptorFactory.fromAsset("Icon_road_nofocus.png"));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public boolean g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (this.d.getAllStep() != null && this.d.getAllStep().get(i) != null && e) {
                Log.i("baidumapsdk", "DrivingRouteOverlay onRouteNodeClick");
                return false;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void h(DrivingRouteLine drivingRouteLine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, drivingRouteLine) == null) {
            this.d = drivingRouteLine;
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            for (Overlay overlay : this.c) {
                if (overlay instanceof Polyline) {
                    ((Polyline) overlay).setFocus(z);
                    return;
                }
            }
        }
    }
}
