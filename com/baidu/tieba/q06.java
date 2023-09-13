package com.baidu.tieba;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.n06;
import com.baidu.tieba.t06;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class q06 implements p06 {
    public static /* synthetic */ Interceptable $ic;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final View b;
    public GestureDetector c;
    public ScaleGestureDetector d;
    public BitmapRegionDecoder e;
    public o06 f;
    public r06 g;
    public float h;
    public float i;
    public float j;
    public float k;
    public Bitmap l;
    public int m;
    public c n;
    public t06 o;
    public final Matrix p;
    public View.OnClickListener q;
    public View.OnLongClickListener r;
    public Bitmap s;
    public p06 t;
    public ValueAnimator u;
    public boolean v;
    public boolean w;
    public boolean x;
    public BdAsyncTask<String, String, String> y;

    /* loaded from: classes7.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ float a;
        public final /* synthetic */ float b;
        public final /* synthetic */ q06 c;

        public a(q06 q06Var, float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q06Var, Float.valueOf(f), Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = q06Var;
            this.a = f;
            this.b = f2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                this.c.L(((Float) valueAnimator.getAnimatedValue()).floatValue() / this.c.i, this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<String, String, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q06 a;

        public b(q06 q06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q06Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            double d;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                if (this.a.f != null && this.a.e != null) {
                    int[] b = this.a.g.b();
                    int i = 1;
                    while (true) {
                        d = i;
                        if (Math.max(b[0] / this.a.f.i(), b[1] / this.a.f.h()) <= Math.pow(2.0d, d)) {
                            break;
                        }
                        i++;
                    }
                    int pow = (int) Math.pow(2.0d, d);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = pow;
                    Rect rect = new Rect(0, 0, b[0], b[1]);
                    try {
                        this.a.s = this.a.e.decodeRegion(rect, options);
                    } catch (Throwable unused) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        System.gc();
                        try {
                            this.a.s = this.a.e.decodeRegion(rect, options);
                        } catch (Throwable unused2) {
                            this.a.s = null;
                        }
                    }
                    TbImageMemoryCache.A().l("long_img_mThumb" + System.currentTimeMillis(), new BdImage(this.a.s, false));
                    q06 q06Var = this.a;
                    q06Var.B(q06Var.s, q06Var.f, pow);
                    this.a.f.t(this.a.s);
                    this.a.C();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                if (this.a.t != null) {
                    this.a.t.onLoadFinished();
                }
                this.a.u();
                this.a.b.invalidate();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends Scroller {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(q06 q06Var, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q06Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0;
            this.b = 0;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.intValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b;
            }
            return invokeV.intValue;
        }

        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.a = i;
            }
        }

        public void d(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                this.b = i;
            }
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
                this.a = 0;
                this.b = 0;
                super.fling(i, i2, i3, i4, i5, i6, i7, i8);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q06 a;

        public d(q06 q06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q06Var;
        }

        public /* synthetic */ d(q06 q06Var, a aVar) {
            this(q06Var);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, motionEvent)) != null) {
                return invokeL.booleanValue;
            }
            this.a.U(this.a.i == this.a.j ? this.a.k : this.a.j, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent) == null) {
                if (!this.a.x && this.a.r != null) {
                    this.a.r.onLongClick(this.a.b);
                } else {
                    this.a.x = false;
                }
                super.onLongPress(motionEvent);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
                if (!this.a.x && this.a.q != null) {
                    this.a.q.onClick(this.a.b);
                } else {
                    this.a.x = false;
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                Rect o = this.a.f.o();
                Rect f3 = this.a.f.f();
                this.a.n.forceFinished(true);
                int i = (int) 0.0f;
                this.a.n.fling(i, i, (int) f, (int) f2, o.right - f3.right, o.left - f3.left, o.bottom - f3.bottom, o.top - f3.top);
                this.a.b.invalidate();
                if (Math.abs(f2) > q06.z) {
                    this.a.x = true;
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                this.a.I((int) f, (int) f2);
                if (Math.abs(f2) > q06.z) {
                    this.a.x = true;
                }
                if (this.a.b != null && this.a.i != this.a.k) {
                    this.a.b.getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q06 a;

        public e(q06 q06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q06Var;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, scaleGestureDetector)) == null) {
                this.a.L(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                return true;
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ e(q06 q06Var, a aVar) {
            this(q06Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948038066, "Lcom/baidu/tieba/q06;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948038066, "Lcom/baidu/tieba/q06;");
                return;
            }
        }
        z = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();
    }

    public final void C() {
        o06 o06Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (o06Var = this.f) != null) {
            o06Var.q(1.0f / this.k);
        }
    }

    public boolean D() {
        InterceptResult invokeV;
        Rect o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            o06 o06Var = this.f;
            if (o06Var == null || (o = o06Var.o()) == null || o.top > 10) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (Math.floor(this.k * 10000.0f) == Math.floor(this.i * 10000.0f)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.w;
        }
        return invokeV.booleanValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.v;
        }
        return invokeV.booleanValue;
    }

    public float N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.k;
        }
        return invokeV.floatValue;
    }

    public final void X() {
        List<n06> d2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (d2 = this.f.d()) != null) {
            for (n06 n06Var : d2) {
                Y(n06Var, this.f);
            }
        }
    }

    @Override // com.baidu.tieba.p06
    public void onLoadFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.b.postInvalidate();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            float f = this.i;
            float f2 = this.k;
            if (f / f2 < 1.0f) {
                U(f2, 0.0f, 0.0f, 400);
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048605, this) != null) || this.m == 1) {
            return;
        }
        w(this.f, true);
    }

    public float y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.k * 2.0f;
        }
        return invokeV.floatValue;
    }

    public float z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            float f = this.k;
            if (f >= 1.0f) {
                return 1.0f;
            }
            return f;
        }
        return invokeV.floatValue;
    }

    public q06(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = 2.0f;
        this.k = 1.0f;
        this.m = 1;
        this.p = new Matrix();
        this.s = null;
        this.v = true;
        this.w = false;
        this.x = false;
        this.y = new b(this);
        this.b = view2;
        this.a = view2.getContext();
        this.c = new GestureDetector(this.a, new d(this, null));
        this.d = new ScaleGestureDetector(this.a, new e(this, null));
        this.n = new c(this, this.a);
        this.m = 0;
    }

    public boolean J(Canvas canvas) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, canvas)) == null) {
            if (this.m == 1 && this.l != null) {
                return false;
            }
            o06 o06Var = this.f;
            if (o06Var != null) {
                o06Var.o();
                if (E()) {
                    canvas.drawBitmap(this.f.n().b(), this.p, null);
                }
                w(this.f, false);
                X();
                canvas.save();
                float k = (this.f.k() * 1.0f) / this.f.l();
                canvas.scale(k, k);
                List<n06> d2 = this.f.d();
                if (d2 != null) {
                    for (n06 n06Var : d2) {
                        canvas.drawBitmap(n06Var.b(), n06Var.f(), n06Var.c(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void R(p06 p06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, p06Var) == null) {
            this.t = p06Var;
        }
    }

    public void S(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.q = onClickListener;
        }
    }

    public void T(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onLongClickListener) == null) {
            this.r = onLongClickListener;
        }
    }

    public final void w(o06 o06Var, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048607, this, o06Var, z2) == null) {
            v(o06Var.m(), o06Var.k(), z2);
        }
    }

    public final float[] A(float f, float f2) {
        InterceptResult invokeCommon;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            float[] fArr = new float[2];
            Rect o = this.f.o();
            int[] b2 = this.g.b();
            if (o.top + f2 < 0.0f) {
                f2 = 0.0f;
            }
            int i = o.bottom;
            boolean z3 = true;
            if (i + f2 > b2[1]) {
                f2 = (b2[1] - i) * this.i;
            }
            if (o.bottom - o.top > b2[1]) {
                f2 = 0.0f;
            }
            fArr[0] = 0.0f;
            fArr[1] = f2;
            if (f2 == 0.0f) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.v = z2;
            if (o.bottom != b2[1]) {
                z3 = false;
            }
            this.w = z3;
            if (z3) {
                this.v = false;
            }
            return fArr;
        }
        return (float[]) invokeCommon.objValue;
    }

    public boolean K(Canvas canvas, Bitmap bitmap) {
        InterceptResult invokeLL;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, canvas, bitmap)) == null) {
            if (bitmap != null && !bitmap.isRecycled() && !E()) {
                Matrix matrix = new Matrix();
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int width2 = (this.b.getWidth() - this.b.getPaddingLeft()) - this.b.getPaddingRight();
                int height2 = (this.b.getHeight() - this.b.getPaddingTop()) - this.b.getPaddingBottom();
                if (width * height2 > width2 * height) {
                    f = height2 / height;
                } else {
                    f = width2 / width;
                }
                matrix.setScale(f, f);
                matrix.postTranslate(0.0f, 0.0f);
                canvas.drawBitmap(bitmap, matrix, null);
                return true;
            }
            return J(canvas);
        }
        return invokeLL.booleanValue;
    }

    public final void B(Bitmap bitmap, o06 o06Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, o06Var, i) == null) {
            float max = Math.max((o06Var.i() * 1.0f) / bitmap.getWidth(), (o06Var.h() * 1.0f) / bitmap.getHeight());
            this.p.postScale(max, max);
            float f = (1.0f / i) * max;
            this.h = f;
            this.k = f;
            this.i = f;
            this.j = f * 2.0f;
            float i2 = (o06Var.i() * 1.0f) / this.e.getWidth();
            if (i2 > 1.0f) {
                this.h /= i2;
            }
            o06Var.s(1.0f / this.i);
        }
    }

    public final void P(n06 n06Var, Rect rect, Rect rect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, n06Var, rect, rect2) == null) {
            int i = rect.left;
            int i2 = rect2.left;
            if (i <= i2) {
                i = i2;
            }
            int i3 = rect.right;
            int i4 = rect2.right;
            if (i3 >= i4) {
                i3 = i4;
            }
            int i5 = rect.top;
            int i6 = rect2.top;
            if (i5 <= i6) {
                i5 = i6;
            }
            int i7 = rect.bottom;
            int i8 = rect2.bottom;
            if (i7 >= i8) {
                i7 = i8;
            }
            int c2 = n06Var.d().c();
            int i9 = rect.left;
            int i10 = rect.top;
            n06Var.k((i - i9) / c2, (i5 - i10) / c2, (i3 - i9) / c2, (i7 - i10) / c2);
            int i11 = rect2.left;
            int i12 = rect2.top;
            n06Var.i((i - i11) / c2, (i5 - i12) / c2, (i3 - i11) / c2, (i7 - i12) / c2);
        }
    }

    public final n06 x(int i, int i2, int i3) {
        InterceptResult invokeIII;
        n06 f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048608, this, i, i2, i3)) == null) {
            n06.a aVar = new n06.a(i, i2, i3);
            if (this.o.e() != null && (f = this.o.e().f(aVar)) != null) {
                if (f.b() != null && !f.b().isRecycled()) {
                    return f;
                }
                this.o.e().i(aVar);
            }
            return null;
        }
        return (n06) invokeIII.objValue;
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            o06 o06Var = this.f;
            if (o06Var != null && o06Var.n() != null && this.f.n().b() != null && !this.f.n().b().isRecycled()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ValueAnimator valueAnimator = this.u;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            BdAsyncTask<String, String, String> bdAsyncTask = this.y;
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
            t06 t06Var = this.o;
            if (t06Var != null) {
                t06Var.g();
            }
            o06 o06Var = this.f;
            if (o06Var != null && o06Var.d() != null) {
                this.f.d().clear();
            }
            Bitmap bitmap = this.s;
            if (bitmap != null) {
                bitmap.recycle();
                this.s = null;
            }
        }
    }

    public void I(float f, float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) && this.f != null) {
            float[] A = A(f, f2);
            float f3 = A[0];
            float f4 = A[1];
            this.p.postTranslate(-f3, -f4);
            o06 o06Var = this.f;
            float f5 = this.i;
            o06Var.p((f3 * 1.0f) / f5, (f4 * 1.0f) / f5);
            u();
            this.b.invalidate();
        }
    }

    public void Q(Bitmap bitmap, byte[] bArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, bitmap, bArr) == null) && bArr != null && bArr.length != 0 && this.g == null) {
            this.l = bitmap;
            r06 r06Var = new r06(this.a);
            this.g = r06Var;
            try {
                this.e = r06Var.a(bArr);
            } catch (Throwable unused) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.e = this.g.a(bArr);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            this.m = 2;
            V();
        }
    }

    public void L(float f, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            float f4 = this.i;
            float f5 = this.h;
            if (f4 * f < f5) {
                f = f5 / f4;
            }
            float f6 = this.i;
            float f7 = this.j;
            if (f6 * f > f7) {
                f = f7 / f6;
            }
            Rect o = this.f.o();
            float f8 = ((o.left + o.right) * 1.0f) / 2.0f;
            float f9 = ((o.top + o.bottom) * 1.0f) / 2.0f;
            o06 o06Var = this.f;
            if (o06Var != null) {
                this.p.postScale(f, f, o06Var.i() / 2, this.f.h() / 2);
                this.f.r(1.0f / f, f8, f9);
                float f10 = this.i * f;
                this.i = f10;
                this.f.s(1.0f / f10);
                float[] s = s();
                this.p.postTranslate(-s[0], -s[1]);
                o06 o06Var2 = this.f;
                float f11 = this.i;
                o06Var2.p((s[0] * 1.0f) / f11, (s[1] * 1.0f) / f11);
                u();
                this.b.invalidate();
            }
        }
    }

    public boolean M(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
            if (this.m != 2 || !E()) {
                return false;
            }
            if (action != 0) {
                if (action == 1 || action == 3) {
                    r();
                }
            } else {
                if (!this.n.isFinished()) {
                    this.x = true;
                } else {
                    this.x = false;
                }
                r();
            }
            this.n.forceFinished(true);
            this.d.onTouchEvent(motionEvent);
            if (!this.d.isInProgress()) {
                this.c.onTouchEvent(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void U(float f, float f2, float f3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i)}) == null) {
            ValueAnimator valueAnimator = this.u;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.i, f);
            this.u = ofFloat;
            ofFloat.setDuration(i);
            this.u.addUpdateListener(new a(this, f2, f3));
            this.u.start();
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && this.m == 2 && this.g != null && this.y.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.f == null && this.b.getMeasuredWidth() > 0 && this.b.getMeasuredHeight() > 0 && this.g.b()[0] > 0 && this.g.b()[1] > 0) {
            this.f = new o06(this.b.getMeasuredWidth(), this.b.getMeasuredHeight(), this.g.b());
            this.y.setPriority(3);
            this.y.execute(new String[0]);
        }
    }

    public final float[] s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            Rect o = this.f.o();
            int[] b2 = this.g.b();
            float[] fArr = {(b2[0] / 2) - (((o.left + o.right) * 1.0f) / 2.0f)};
            int i = o.top;
            if (i < 0) {
                fArr[1] = 0 - i;
            }
            int i2 = o.bottom;
            if (i2 > b2[1]) {
                fArr[1] = b2[1] - i2;
            }
            int i3 = o.bottom;
            int i4 = o.top;
            if (i3 - i4 > b2[1]) {
                fArr[1] = (b2[1] / 2) - (((i4 + i3) * 1.0f) / 2.0f);
            }
            float f = fArr[0];
            float f2 = this.i;
            fArr[0] = f * f2;
            fArr[1] = fArr[1] * f2;
            return fArr;
        }
        return (float[]) invokeV.objValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.m == 1) {
                return false;
            }
            if (this.n.computeScrollOffset()) {
                int currX = this.n.getCurrX();
                int currY = this.n.getCurrY();
                float a2 = (currX - this.n.a()) * 2.0f;
                float b2 = (currY - this.n.b()) * 2.0f;
                int equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
                if (b2 > 0.0f && Math.abs(b2) <= 20.0f && currX < equipmentHeight) {
                    I(0.0f, -20.0f);
                    this.b.invalidate();
                    return true;
                }
                this.n.c(currX);
                this.n.d(currY);
                I(-a2, -b2);
                this.b.invalidate();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void W(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048598, this, i, i2, i3) == null) {
            t06.d dVar = new t06.d(i, i2, i3);
            dVar.d(this);
            this.o.h(dVar);
        }
    }

    public void Y(n06 n06Var, o06 o06Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048600, this, n06Var, o06Var) != null) || n06Var == null) {
            return;
        }
        if (n06Var.d().a() == 0 && n06Var.d().b() == 1) {
            System.currentTimeMillis();
        }
        P(n06Var, o06Var.g(n06Var), o06Var.o());
    }

    public final void v(Point[] pointArr, int i, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{pointArr, Integer.valueOf(i), Boolean.valueOf(z2)}) == null) {
            if (this.o == null) {
                this.o = new t06(this.f, this.e);
            }
            int i2 = pointArr[0].x;
            boolean z3 = true;
            int i3 = pointArr[1].y;
            int i4 = pointArr[1].x;
            List<n06> list = null;
            if (!z2) {
                list = this.f.d();
                list.clear();
            }
            for (int i5 = pointArr[0].y; i5 < i3; i5++) {
                for (int i6 = i2; i6 < i4; i6++) {
                    n06 x = x(i5, i6, i);
                    if (x == null) {
                        if (z2) {
                            W(i5, i6, i);
                        }
                        z3 = false;
                    } else if (list != null && !z2) {
                        list.add(x);
                    }
                }
            }
            if (z3) {
                this.o.d(false);
            }
        }
    }
}
