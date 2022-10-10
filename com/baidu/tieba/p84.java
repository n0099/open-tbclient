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
import com.baidu.tieba.fq2;
import com.baidu.tieba.ig3;
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
/* loaded from: classes5.dex */
public class p84 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements ig3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fq2 a;
        public final /* synthetic */ u84 b;
        public final /* synthetic */ List c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ v84 e;
        public final /* synthetic */ List f;
        public final /* synthetic */ List g;
        public final /* synthetic */ AtomicInteger h;
        public final /* synthetic */ int i;

        public a(fq2 fq2Var, u84 u84Var, List list, Context context, v84 v84Var, List list2, List list3, AtomicInteger atomicInteger, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fq2Var, u84Var, list, context, v84Var, list2, list3, atomicInteger, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fq2Var;
            this.b = u84Var;
            this.c = list;
            this.d = context;
            this.e = v84Var;
            this.f = list2;
            this.g = list3;
            this.h = atomicInteger;
            this.i = i;
        }

        @Override // com.baidu.tieba.ig3.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (p84.a) {
                    Log.d("MarkerViewCreateHelper", "url=" + str);
                }
                if (bitmap == null) {
                    bitmap = p84.f();
                }
                Bitmap g = p84.g(bitmap, this.a);
                eq2 eq2Var = this.a.b;
                LatLng latLng = new LatLng(eq2Var.a, eq2Var.b);
                MarkerOptions zIndex = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(g)).alpha((float) this.a.f).title(this.a.c).rotate((float) this.a.e).zIndex(88);
                fq2.a aVar = this.a.k;
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
                if (u84.h.booleanValue()) {
                    fq2.b bVar = this.a.i;
                    if (bVar != null && bVar.isValid() && TextUtils.equals(this.a.i.g, "ALWAYS")) {
                        View a = j84.a(this.e, this.a);
                        linearLayout.addView(a, 0);
                        this.b.d = a;
                    }
                    fq2.c cVar = this.a.j;
                    if (cVar != null && cVar.isValid()) {
                        this.f.add(l84.a(this.e, this.b));
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
                synchronized (n84.a) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948015901, "Lcom/baidu/tieba/p84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948015901, "Lcom/baidu/tieba/p84;");
                return;
            }
        }
        a = vj1.a;
    }

    public static void d(@NonNull xp2 xp2Var, @NonNull v84 v84Var, r84 r84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, xp2Var, v84Var, r84Var) == null) {
            List<dq2> list = xp2Var.o;
            if (list != null && list.size() > 0) {
                for (dq2 dq2Var : xp2Var.o) {
                    k84.a(v84Var, dq2Var, r84Var);
                    l02.i("map", "initMapView createControl id " + dq2Var.a);
                }
            }
            ArrayList arrayList = new ArrayList();
            List<hq2> list2 = xp2Var.m;
            if (list2 != null && list2.size() > 0) {
                for (hq2 hq2Var : xp2Var.m) {
                    if (!hq2Var.isValid()) {
                        l02.c("map", "polyline is invalid");
                    } else {
                        ArrayList arrayList2 = new ArrayList(hq2Var.a.size());
                        Iterator<eq2> it = hq2Var.a.iterator();
                        while (it.hasNext()) {
                            eq2 next = it.next();
                            arrayList2.add(new LatLng(next.a, next.b));
                        }
                        if (arrayList2.size() >= 2 && !arrayList2.contains(null)) {
                            arrayList.add(new PolylineOptions().points(arrayList2).color(hq2Var.b).width((int) hq2Var.c).dottedLine(hq2Var.d));
                            l02.i("map", "initMapView createPoly");
                        } else {
                            l02.c("map", "polyline count can't less than 2 or your polyline points contains null");
                        }
                    }
                }
            }
            List<gq2> list3 = xp2Var.q;
            if (list3 != null && !list3.isEmpty()) {
                for (gq2 gq2Var : xp2Var.q) {
                    if (!gq2Var.isValid()) {
                        l02.c("map", "polygon is invalid");
                    } else {
                        ArrayList arrayList3 = new ArrayList(gq2Var.a.size());
                        Iterator<eq2> it2 = gq2Var.a.iterator();
                        while (it2.hasNext()) {
                            eq2 next2 = it2.next();
                            arrayList3.add(new LatLng(next2.a, next2.b));
                        }
                        if (arrayList3.size() >= 3 && !arrayList3.contains(null)) {
                            arrayList.add(new PolygonOptions().points(arrayList3).stroke(new Stroke(gq2Var.b, gq2Var.c)).fillColor(gq2Var.d).zIndex(gq2Var.e));
                            l02.i("map", "initMapView createPolygons");
                        } else {
                            l02.c("map", "polygons count can't less than 3 or your polygons points contains null");
                        }
                    }
                }
            }
            List<eq2> list4 = xp2Var.p;
            if (list4 != null && list4.size() > 0) {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                for (eq2 eq2Var : xp2Var.p) {
                    builder.include(new LatLng(eq2Var.a, eq2Var.b));
                }
                v84Var.l.getMap().setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
                l02.i("map", "initMapView includePoints");
            }
            List<cq2> list5 = xp2Var.n;
            if (list5 != null && list5.size() > 0) {
                for (cq2 cq2Var : xp2Var.n) {
                    if (cq2Var.isValid()) {
                        CircleOptions circleOptions = new CircleOptions();
                        eq2 eq2Var2 = cq2Var.a;
                        arrayList.add(circleOptions.center(new LatLng(eq2Var2.a, eq2Var2.b)).stroke(new Stroke((int) cq2Var.e, cq2Var.b)).fillColor(cq2Var.c).radius(cq2Var.d));
                        l02.i("map", "initMapView createCircle");
                    }
                }
            }
            v84Var.l.getMap().addOverlays(arrayList);
        }
    }

    public static void e(Context context, @NonNull xp2 xp2Var, @NonNull v84 v84Var) {
        List<fq2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65541, null, context, xp2Var, v84Var) == null) || (list = xp2Var.l) == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Iterator<fq2> it = list.iterator();
        while (it.hasNext()) {
            fq2 next = it.next();
            u84 u84Var = new u84();
            if (next.k == null) {
                next.k = new fq2.a();
            }
            String str = next.d;
            if (TextUtils.isEmpty(str)) {
                str = ImageRequestBuilder.newBuilderWithResourceId(R.drawable.obfuscated_res_0x7f080fb0).build().getSourceUri().toString();
            }
            ig3.e(str, new a(next, u84Var, arrayList, context, v84Var, arrayList2, arrayList3, atomicInteger, size));
            it = it;
            arrayList = arrayList;
        }
    }

    public static Bitmap f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), R.drawable.obfuscated_res_0x7f080fb0) : (Bitmap) invokeV.objValue;
    }

    @Nullable
    public static Bitmap g(Bitmap bitmap, fq2 fq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bitmap, fq2Var)) == null) {
            int i = fq2Var.g;
            if (i == -1) {
                i = bitmap.getWidth();
            }
            int i2 = fq2Var.h;
            if (i2 == -1) {
                i2 = bitmap.getHeight();
            }
            return k94.a(bitmap, i, i2);
        }
        return (Bitmap) invokeLL.objValue;
    }
}
