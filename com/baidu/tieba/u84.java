package com.baidu.tieba;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.fq2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class u84 {
    public static /* synthetic */ Interceptable $ic;
    public static final Boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public fq2 a;
    public Marker b;
    public Marker c;
    public View d;
    public ViewGroup e;
    public Marker f;
    public ValueAnimator g;

    /* loaded from: classes6.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ v84 b;
        public final /* synthetic */ b c;
        public final /* synthetic */ u84 d;

        public a(u84 u84Var, v84 v84Var, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u84Var, v84Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = u84Var;
            this.b = v84Var;
            this.c = bVar;
            this.a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                this.d.a(this.b, (LatLng) valueAnimator.getAnimatedValue());
                if (this.a || animatedFraction <= 0.99d) {
                    return;
                }
                this.a = true;
                b bVar = this.c;
                if (bVar != null) {
                    bVar.onAnimationEnd();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void onAnimationEnd();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948164856, "Lcom/baidu/tieba/u84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948164856, "Lcom/baidu/tieba/u84;");
                return;
            }
        }
        h = Boolean.TRUE;
    }

    public u84() {
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

    public void a(v84 v84Var, LatLng latLng) {
        Marker marker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, v84Var, latLng) == null) || (marker = this.b) == null) {
            return;
        }
        marker.setPosition(latLng);
        eq2 eq2Var = this.a.b;
        eq2Var.a = latLng.latitude;
        eq2Var.b = latLng.longitude;
        Marker marker2 = this.f;
        if (marker2 != null) {
            marker2.setPosition(latLng);
        }
        if (h.booleanValue()) {
            Marker marker3 = this.c;
            if (marker3 != null) {
                marker3.setPosition(latLng);
            }
            ViewGroup viewGroup = this.e;
            if (viewGroup != null) {
                v84Var.l.removeView(viewGroup);
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                v84Var.l.addView(this.e, builder.build());
                this.e.setAlpha(0.0f);
            }
        }
    }

    public void b(v84 v84Var) {
        fq2 fq2Var;
        fq2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v84Var) == null) || (fq2Var = this.a) == null || (bVar = fq2Var.i) == null || !bVar.isValid()) {
            return;
        }
        fq2 fq2Var2 = this.a;
        if (fq2Var2.k == null || this.d != null || TextUtils.equals(fq2Var2.i.g, "ALWAYS")) {
            return;
        }
        v84Var.l.removeView(this.e);
        this.e.removeView(this.d);
        View a2 = j84.a(v84Var, this.a);
        this.d = a2;
        this.e.addView(a2, 0);
        this.e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
        builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
        builder.position(this.b.getPosition());
        Bitmap bitmap = this.b.getIcon().getBitmap();
        builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.a.k.b)) + 0.0d));
        v84Var.l.addView(this.e, builder.build());
        this.e.setAlpha(0.0f);
        Marker marker = this.f;
        if (marker != null) {
            marker.remove();
        }
        BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.e);
        if (fromView == null) {
            return;
        }
        Bitmap bitmap2 = fromView.getBitmap();
        if (bitmap2.getHeight() <= 0 || bitmap2.getWidth() <= 0) {
            return;
        }
        float width = ((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.a.k.a * bitmap.getWidth()))) / bitmap2.getWidth();
        float height = ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.a.k.b * bitmap.getHeight()))) / fromView.getBitmap().getHeight();
        MarkerOptions markerOptions = new MarkerOptions();
        eq2 eq2Var = this.a.b;
        this.f = (Marker) v84Var.l.getMap().addOverlay(markerOptions.position(new LatLng(eq2Var.a, eq2Var.b)).icon(fromView).zIndex(66).anchor(width, height));
    }

    public void c(v84 v84Var, LatLng latLng, aq2 aq2Var, b bVar) {
        Marker marker;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, v84Var, latLng, aq2Var, bVar) == null) {
            ValueAnimator valueAnimator = this.g;
            if ((valueAnimator == null || !valueAnimator.isRunning()) && (marker = this.b) != null) {
                float f = 360.0f - ((float) aq2Var.B);
                if (f >= 0.0f && f <= 360.0f) {
                    marker.setRotate(f);
                }
                int i = aq2Var.C;
                if (i < 0) {
                    i = -i;
                }
                ValueAnimator ofObject = ValueAnimator.ofObject(new i84(), this.b.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
                this.g = ofObject;
                ofObject.setDuration(i);
                this.g.addUpdateListener(new a(this, v84Var, bVar));
                this.g.start();
            }
        }
    }
}
