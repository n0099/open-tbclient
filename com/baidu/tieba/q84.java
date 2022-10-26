package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.CircleOptions;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.PolygonOptions;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.Stroke;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.gq2;
import com.baidu.tieba.jg3;
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
public class q84 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public final class a implements jg3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gq2 a;
        public final /* synthetic */ v84 b;
        public final /* synthetic */ List c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ w84 e;
        public final /* synthetic */ List f;
        public final /* synthetic */ List g;
        public final /* synthetic */ AtomicInteger h;
        public final /* synthetic */ int i;

        public a(gq2 gq2Var, v84 v84Var, List list, Context context, w84 w84Var, List list2, List list3, AtomicInteger atomicInteger, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gq2Var, v84Var, list, context, w84Var, list2, list3, atomicInteger, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gq2Var;
            this.b = v84Var;
            this.c = list;
            this.d = context;
            this.e = w84Var;
            this.f = list2;
            this.g = list3;
            this.h = atomicInteger;
            this.i = i;
        }

        @Override // com.baidu.tieba.jg3.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (q84.a) {
                    Log.d("MarkerViewCreateHelper", "url=" + str);
                }
                if (bitmap == null) {
                    bitmap = q84.f();
                }
                Bitmap g = q84.g(bitmap, this.a);
                fq2 fq2Var = this.a.b;
                LatLng latLng = new LatLng(fq2Var.a, fq2Var.b);
                MarkerOptions zIndex = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(g)).alpha((float) this.a.f).title(this.a.c).rotate((float) this.a.e).zIndex(88);
                gq2.a aVar = this.a.k;
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
                if (v84.h.booleanValue()) {
                    gq2.b bVar = this.a.i;
                    if (bVar != null && bVar.isValid() && TextUtils.equals(this.a.i.g, "ALWAYS")) {
                        View a = k84.a(this.e, this.a);
                        linearLayout.addView(a, 0);
                        this.b.d = a;
                    }
                    gq2.c cVar = this.a.j;
                    if (cVar != null && cVar.isValid()) {
                        this.f.add(m84.a(this.e, this.b));
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
                synchronized (o84.a) {
                    this.h.getAndIncrement();
                    this.e.n.add(this.b);
                    int size = this.e.n.size();
                    if (this.i == this.h.get()) {
                        List addOverlays = this.e.l.getMap().addOverlays(this.f);
                        int size2 = addOverlays.size();
                        for (int i = 0; i < size2 && i < size; i++) {
                            ((v84) this.e.n.get(i)).c = (Marker) addOverlays.get(i);
                        }
                        List addOverlays2 = this.e.l.getMap().addOverlays(this.c);
                        int size3 = addOverlays2.size();
                        for (int i2 = 0; i2 < size3 && i2 < size; i2++) {
                            ((v84) this.e.n.get(i2)).b = (Marker) addOverlays2.get(i2);
                        }
                        List addOverlays3 = this.e.l.getMap().addOverlays(this.g);
                        int size4 = addOverlays3.size();
                        for (int i3 = 0; i3 < size4 && i3 < size; i3++) {
                            ((v84) this.e.n.get(i3)).f = (Marker) addOverlays3.get(i3);
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948045692, "Lcom/baidu/tieba/q84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948045692, "Lcom/baidu/tieba/q84;");
                return;
            }
        }
        a = wj1.a;
    }

    public static Bitmap f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), R.drawable.obfuscated_res_0x7f080fc1);
        }
        return (Bitmap) invokeV.objValue;
    }

    public static Bitmap g(Bitmap bitmap, gq2 gq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bitmap, gq2Var)) == null) {
            int i = gq2Var.g;
            if (i == -1) {
                i = bitmap.getWidth();
            }
            int i2 = gq2Var.h;
            if (i2 == -1) {
                i2 = bitmap.getHeight();
            }
            return l94.a(bitmap, i, i2);
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static void d(yp2 yp2Var, w84 w84Var, s84 s84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, yp2Var, w84Var, s84Var) == null) {
            List list = yp2Var.o;
            if (list != null && list.size() > 0) {
                for (eq2 eq2Var : yp2Var.o) {
                    l84.a(w84Var, eq2Var, s84Var);
                    m02.i("map", "initMapView createControl id " + eq2Var.a);
                }
            }
            ArrayList arrayList = new ArrayList();
            List list2 = yp2Var.m;
            if (list2 != null && list2.size() > 0) {
                for (iq2 iq2Var : yp2Var.m) {
                    if (!iq2Var.isValid()) {
                        m02.c("map", "polyline is invalid");
                    } else {
                        ArrayList arrayList2 = new ArrayList(iq2Var.a.size());
                        Iterator it = iq2Var.a.iterator();
                        while (it.hasNext()) {
                            fq2 fq2Var = (fq2) it.next();
                            arrayList2.add(new LatLng(fq2Var.a, fq2Var.b));
                        }
                        if (arrayList2.size() >= 2 && !arrayList2.contains(null)) {
                            arrayList.add(new PolylineOptions().points(arrayList2).color(iq2Var.b).width((int) iq2Var.c).dottedLine(iq2Var.d));
                            m02.i("map", "initMapView createPoly");
                        } else {
                            m02.c("map", "polyline count can't less than 2 or your polyline points contains null");
                        }
                    }
                }
            }
            List list3 = yp2Var.q;
            if (list3 != null && !list3.isEmpty()) {
                for (hq2 hq2Var : yp2Var.q) {
                    if (!hq2Var.isValid()) {
                        m02.c("map", "polygon is invalid");
                    } else {
                        ArrayList arrayList3 = new ArrayList(hq2Var.a.size());
                        Iterator it2 = hq2Var.a.iterator();
                        while (it2.hasNext()) {
                            fq2 fq2Var2 = (fq2) it2.next();
                            arrayList3.add(new LatLng(fq2Var2.a, fq2Var2.b));
                        }
                        if (arrayList3.size() >= 3 && !arrayList3.contains(null)) {
                            arrayList.add(new PolygonOptions().points(arrayList3).stroke(new Stroke(hq2Var.b, hq2Var.c)).fillColor(hq2Var.d).zIndex(hq2Var.e));
                            m02.i("map", "initMapView createPolygons");
                        } else {
                            m02.c("map", "polygons count can't less than 3 or your polygons points contains null");
                        }
                    }
                }
            }
            List list4 = yp2Var.p;
            if (list4 != null && list4.size() > 0) {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                for (fq2 fq2Var3 : yp2Var.p) {
                    builder.include(new LatLng(fq2Var3.a, fq2Var3.b));
                }
                w84Var.l.getMap().setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
                m02.i("map", "initMapView includePoints");
            }
            List list5 = yp2Var.n;
            if (list5 != null && list5.size() > 0) {
                for (dq2 dq2Var : yp2Var.n) {
                    if (dq2Var.isValid()) {
                        CircleOptions circleOptions = new CircleOptions();
                        fq2 fq2Var4 = dq2Var.a;
                        arrayList.add(circleOptions.center(new LatLng(fq2Var4.a, fq2Var4.b)).stroke(new Stroke((int) dq2Var.e, dq2Var.b)).fillColor(dq2Var.c).radius(dq2Var.d));
                        m02.i("map", "initMapView createCircle");
                    }
                }
            }
            w84Var.l.getMap().addOverlays(arrayList);
        }
    }

    public static void e(Context context, yp2 yp2Var, w84 w84Var) {
        List list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65541, null, context, yp2Var, w84Var) == null) && (list = yp2Var.l) != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int size = list.size();
            AtomicInteger atomicInteger = new AtomicInteger(0);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                gq2 gq2Var = (gq2) it.next();
                v84 v84Var = new v84();
                if (gq2Var.k == null) {
                    gq2Var.k = new gq2.a();
                }
                String str = gq2Var.d;
                if (TextUtils.isEmpty(str)) {
                    str = ImageRequestBuilder.newBuilderWithResourceId(R.drawable.obfuscated_res_0x7f080fc1).build().getSourceUri().toString();
                }
                jg3.e(str, new a(gq2Var, v84Var, arrayList, context, w84Var, arrayList2, arrayList3, atomicInteger, size));
                it = it;
                arrayList = arrayList;
            }
        }
    }
}
