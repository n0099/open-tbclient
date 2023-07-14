package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.CircleOptions;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.PolygonOptions;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.Stroke;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.py2;
import com.baidu.tieba.so3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class zg4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements so3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ py2 a;
        public final /* synthetic */ eh4 b;
        public final /* synthetic */ List c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ fh4 e;
        public final /* synthetic */ List f;
        public final /* synthetic */ List g;
        public final /* synthetic */ AtomicInteger h;
        public final /* synthetic */ int i;

        public a(py2 py2Var, eh4 eh4Var, List list, Context context, fh4 fh4Var, List list2, List list3, AtomicInteger atomicInteger, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {py2Var, eh4Var, list, context, fh4Var, list2, list3, atomicInteger, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = py2Var;
            this.b = eh4Var;
            this.c = list;
            this.d = context;
            this.e = fh4Var;
            this.f = list2;
            this.g = list3;
            this.h = atomicInteger;
            this.i = i;
        }

        @Override // com.baidu.tieba.so3.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (zg4.a) {
                    Log.d("MarkerViewCreateHelper", "url=" + str);
                }
                if (bitmap == null) {
                    bitmap = zg4.b();
                }
                Bitmap g = zg4.g(bitmap, this.a);
                oy2 oy2Var = this.a.b;
                LatLng latLng = new LatLng(oy2Var.a, oy2Var.b);
                MarkerOptions zIndex = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(g)).alpha((float) this.a.f).title(this.a.c).rotate((float) this.a.e).zIndex(88);
                py2.a aVar = this.a.k;
                MarkerOptions anchor = zIndex.anchor((float) aVar.a, (float) aVar.b);
                this.b.a = this.a;
                this.c.add(anchor);
                LinearLayout linearLayout = new LinearLayout(this.d);
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                linearLayout.setGravity(17);
                View view2 = new View(this.d);
                view2.setLayoutParams(new ViewGroup.LayoutParams(g.getWidth(), g.getHeight()));
                view2.setVisibility(4);
                linearLayout.addView(view2);
                this.b.e = linearLayout;
                if (eh4.h.booleanValue()) {
                    py2.b bVar = this.a.i;
                    if (bVar != null && bVar.isValid() && TextUtils.equals(this.a.i.g, "ALWAYS")) {
                        View a = tg4.a(this.e, this.a);
                        linearLayout.addView(a, 0);
                        this.b.d = a;
                    }
                    py2.c cVar = this.a.j;
                    if (cVar != null && cVar.isValid()) {
                        this.f.add(vg4.a(this.e, this.b));
                    }
                }
                linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                builder.yOffset((int) ((g.getHeight() * (1.0d - this.a.k.b)) + 0.0d));
                this.e.l.addView(linearLayout, builder.build());
                linearLayout.setAlpha(0.0f);
                BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(linearLayout);
                if (fromView == null) {
                    return;
                }
                Bitmap bitmap2 = fromView.getBitmap();
                this.g.add(new MarkerOptions().position(latLng).icon(fromView).anchor(((float) (((bitmap2.getWidth() - g.getWidth()) / 2.0f) + (this.a.k.a * g.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - g.getHeight())) + (this.a.k.b * g.getHeight()))) / bitmap2.getHeight()).zIndex(66));
                synchronized (xg4.a) {
                    this.h.getAndIncrement();
                    this.e.n.add(this.b);
                    int size = this.e.n.size();
                    if (this.i == this.h.get()) {
                        List<Overlay> addOverlays = this.e.l.getMap().addOverlays(this.f);
                        int size2 = addOverlays.size();
                        for (int i = 0; i < size2 && i < size; i++) {
                            this.e.n.get(i).c = (Marker) addOverlays.get(i);
                        }
                        List<Overlay> addOverlays2 = this.e.l.getMap().addOverlays(this.c);
                        int size3 = addOverlays2.size();
                        for (int i2 = 0; i2 < size3 && i2 < size; i2++) {
                            this.e.n.get(i2).b = (Marker) addOverlays2.get(i2);
                        }
                        List<Overlay> addOverlays3 = this.e.l.getMap().addOverlays(this.g);
                        int size4 = addOverlays3.size();
                        for (int i3 = 0; i3 < size4 && i3 < size; i3++) {
                            this.e.n.get(i3).f = (Marker) addOverlays3.get(i3);
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948358978, "Lcom/baidu/tieba/zg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948358978, "Lcom/baidu/tieba/zg4;");
                return;
            }
        }
        a = fs1.a;
    }

    public static /* synthetic */ Bitmap b() {
        return f();
    }

    public static Bitmap f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), R.drawable.obfuscated_res_0x7f081235);
        }
        return (Bitmap) invokeV.objValue;
    }

    @Nullable
    public static Bitmap g(Bitmap bitmap, py2 py2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bitmap, py2Var)) == null) {
            int i = py2Var.g;
            if (i == -1) {
                i = bitmap.getWidth();
            }
            int i2 = py2Var.h;
            if (i2 == -1) {
                i2 = bitmap.getHeight();
            }
            return uh4.a(bitmap, i, i2);
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static void d(@NonNull hy2 hy2Var, @NonNull fh4 fh4Var, bh4 bh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, hy2Var, fh4Var, bh4Var) == null) {
            List<ny2> list = hy2Var.o;
            if (list != null && list.size() > 0) {
                for (ny2 ny2Var : hy2Var.o) {
                    ug4.a(fh4Var, ny2Var, bh4Var);
                    v82.i("map", "initMapView createControl id " + ny2Var.a);
                }
            }
            ArrayList arrayList = new ArrayList();
            List<ry2> list2 = hy2Var.m;
            if (list2 != null && list2.size() > 0) {
                for (ry2 ry2Var : hy2Var.m) {
                    if (!ry2Var.isValid()) {
                        v82.c("map", "polyline is invalid");
                    } else {
                        ArrayList arrayList2 = new ArrayList(ry2Var.a.size());
                        Iterator<oy2> it = ry2Var.a.iterator();
                        while (it.hasNext()) {
                            oy2 next = it.next();
                            arrayList2.add(new LatLng(next.a, next.b));
                        }
                        if (arrayList2.size() >= 2 && !arrayList2.contains(null)) {
                            arrayList.add(new PolylineOptions().points(arrayList2).color(ry2Var.b).width((int) ry2Var.c).dottedLine(ry2Var.d));
                            v82.i("map", "initMapView createPoly");
                        } else {
                            v82.c("map", "polyline count can't less than 2 or your polyline points contains null");
                        }
                    }
                }
            }
            List<qy2> list3 = hy2Var.q;
            if (list3 != null && !list3.isEmpty()) {
                for (qy2 qy2Var : hy2Var.q) {
                    if (!qy2Var.isValid()) {
                        v82.c("map", "polygon is invalid");
                    } else {
                        ArrayList arrayList3 = new ArrayList(qy2Var.a.size());
                        Iterator<oy2> it2 = qy2Var.a.iterator();
                        while (it2.hasNext()) {
                            oy2 next2 = it2.next();
                            arrayList3.add(new LatLng(next2.a, next2.b));
                        }
                        if (arrayList3.size() >= 3 && !arrayList3.contains(null)) {
                            arrayList.add(new PolygonOptions().points(arrayList3).stroke(new Stroke(qy2Var.b, qy2Var.c)).fillColor(qy2Var.d).zIndex(qy2Var.e));
                            v82.i("map", "initMapView createPolygons");
                        } else {
                            v82.c("map", "polygons count can't less than 3 or your polygons points contains null");
                        }
                    }
                }
            }
            List<oy2> list4 = hy2Var.p;
            if (list4 != null && list4.size() > 0) {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                for (oy2 oy2Var : hy2Var.p) {
                    builder.include(new LatLng(oy2Var.a, oy2Var.b));
                }
                fh4Var.l.getMap().setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
                v82.i("map", "initMapView includePoints");
            }
            List<my2> list5 = hy2Var.n;
            if (list5 != null && list5.size() > 0) {
                for (my2 my2Var : hy2Var.n) {
                    if (my2Var.isValid()) {
                        CircleOptions circleOptions = new CircleOptions();
                        oy2 oy2Var2 = my2Var.a;
                        arrayList.add(circleOptions.center(new LatLng(oy2Var2.a, oy2Var2.b)).stroke(new Stroke((int) my2Var.e, my2Var.b)).fillColor(my2Var.c).radius(my2Var.d));
                        v82.i("map", "initMapView createCircle");
                    }
                }
            }
            fh4Var.l.getMap().addOverlays(arrayList);
        }
    }

    public static void e(Context context, @NonNull hy2 hy2Var, @NonNull fh4 fh4Var) {
        List<py2> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65541, null, context, hy2Var, fh4Var) == null) && (list = hy2Var.l) != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int size = list.size();
            AtomicInteger atomicInteger = new AtomicInteger(0);
            Iterator<py2> it = list.iterator();
            while (it.hasNext()) {
                py2 next = it.next();
                eh4 eh4Var = new eh4();
                if (next.k == null) {
                    next.k = new py2.a();
                }
                String str = next.d;
                if (TextUtils.isEmpty(str)) {
                    str = ImageRequestBuilder.newBuilderWithResourceId(R.drawable.obfuscated_res_0x7f081235).build().getSourceUri().toString();
                }
                so3.e(str, new a(next, eh4Var, arrayList, context, fh4Var, arrayList2, arrayList3, atomicInteger, size));
                it = it;
                arrayList = arrayList;
            }
        }
    }
}
