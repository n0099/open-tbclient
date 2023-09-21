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
import com.baidu.tieba.ay2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pg4 {
    public static /* synthetic */ Interceptable $ic;
    public static final Boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public ay2 a;
    public Marker b;
    public Marker c;
    public View d;
    public ViewGroup e;
    public Marker f;
    public ValueAnimator g;

    /* loaded from: classes7.dex */
    public interface b {
        void onAnimationEnd();
    }

    /* loaded from: classes7.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ qg4 b;
        public final /* synthetic */ b c;
        public final /* synthetic */ pg4 d;

        public a(pg4 pg4Var, qg4 qg4Var, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pg4Var, qg4Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = pg4Var;
            this.b = qg4Var;
            this.c = bVar;
            this.a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                this.d.a(this.b, (LatLng) valueAnimator.getAnimatedValue());
                if (!this.a && animatedFraction > 0.99d) {
                    this.a = true;
                    b bVar = this.c;
                    if (bVar != null) {
                        bVar.onAnimationEnd();
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948061068, "Lcom/baidu/tieba/pg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948061068, "Lcom/baidu/tieba/pg4;");
                return;
            }
        }
        h = Boolean.TRUE;
    }

    public pg4() {
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

    public void a(qg4 qg4Var, LatLng latLng) {
        Marker marker;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, qg4Var, latLng) != null) || (marker = this.b) == null) {
            return;
        }
        marker.setPosition(latLng);
        zx2 zx2Var = this.a.b;
        zx2Var.a = latLng.latitude;
        zx2Var.b = latLng.longitude;
        Marker marker2 = this.f;
        if (marker2 != null) {
            marker2.setPosition(latLng);
        }
        if (!h.booleanValue()) {
            return;
        }
        Marker marker3 = this.c;
        if (marker3 != null) {
            marker3.setPosition(latLng);
        }
        ViewGroup viewGroup = this.e;
        if (viewGroup != null) {
            qg4Var.l.removeView(viewGroup);
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(latLng);
            qg4Var.l.addView(this.e, builder.build());
            this.e.setAlpha(0.0f);
        }
    }

    public void b(qg4 qg4Var) {
        ay2 ay2Var;
        ay2.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qg4Var) == null) && (ay2Var = this.a) != null && (bVar = ay2Var.i) != null && bVar.isValid()) {
            ay2 ay2Var2 = this.a;
            if (ay2Var2.k != null && this.d == null && !TextUtils.equals(ay2Var2.i.g, "ALWAYS")) {
                qg4Var.l.removeView(this.e);
                this.e.removeView(this.d);
                View a2 = eg4.a(qg4Var, this.a);
                this.d = a2;
                this.e.addView(a2, 0);
                this.e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(this.b.getPosition());
                Bitmap bitmap = this.b.getIcon().getBitmap();
                builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.a.k.b)) + 0.0d));
                qg4Var.l.addView(this.e, builder.build());
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
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    float width = ((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.a.k.a * bitmap.getWidth()))) / bitmap2.getWidth();
                    float height = ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.a.k.b * bitmap.getHeight()))) / fromView.getBitmap().getHeight();
                    MarkerOptions markerOptions = new MarkerOptions();
                    zx2 zx2Var = this.a.b;
                    this.f = (Marker) qg4Var.l.getMap().addOverlay(markerOptions.position(new LatLng(zx2Var.a, zx2Var.b)).icon(fromView).zIndex(66).anchor(width, height));
                }
            }
        }
    }

    public void c(qg4 qg4Var, LatLng latLng, vx2 vx2Var, b bVar) {
        Marker marker;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, qg4Var, latLng, vx2Var, bVar) == null) {
            ValueAnimator valueAnimator = this.g;
            if ((valueAnimator != null && valueAnimator.isRunning()) || (marker = this.b) == null) {
                return;
            }
            float f = 360.0f - ((float) vx2Var.B);
            if (f >= 0.0f && f <= 360.0f) {
                marker.setRotate(f);
            }
            int i = vx2Var.C;
            if (i < 0) {
                i = -i;
            }
            ValueAnimator ofObject = ValueAnimator.ofObject(new dg4(), this.b.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.g = ofObject;
            ofObject.setDuration(i);
            this.g.addUpdateListener(new a(this, qg4Var, bVar));
            this.g.start();
        }
    }
}
