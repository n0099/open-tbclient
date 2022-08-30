package com.baidu.tieba.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.ll8;
import com.baidu.tieba.nj8;
import com.baidu.tieba.xk5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class SortSwitchButton extends View implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xk5 A;
    public float B;
    public float C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public List<ll8> H;
    public List<Float> I;
    public GestureDetector J;
    public f K;
    public ValueAnimator L;
    public float M;
    public float N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public BdUniqueId R;
    public BdUniqueId S;
    public CustomMessageListener T;
    public xk5.a U;
    public GestureDetector.SimpleOnGestureListener V;
    public float a;
    public float b;
    public float c;
    public int d;
    public int e;
    public float f;
    public float g;
    public int h;
    public int i;
    public int j;
    public float k;
    public float l;
    public float m;
    public int n;
    public Paint o;
    public Paint p;
    public Paint q;
    public Paint r;
    public RectF s;
    public Path t;
    public RectF u;
    public Path v;
    public RectF w;
    public Path x;
    public RectF y;
    public Path z;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SortSwitchButton a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SortSwitchButton sortSwitchButton, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sortSwitchButton, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sortSwitchButton;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage) && (((CustomMessage) customResponsedMessage.getOrginalMessage()).getData() instanceof BdUniqueId)) {
                BdUniqueId bdUniqueId = (BdUniqueId) ((CustomMessage) customResponsedMessage.getOrginalMessage()).getData();
                BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                if (tag == null || bdUniqueId == null || this.a.R == null) {
                    return;
                }
                Integer num = (Integer) customResponsedMessage.getData();
                if (tag.getId() != this.a.R.getId() || bdUniqueId.getId() == this.a.S.getId() || this.a.A.a() == num.intValue() || ListUtils.isEmpty(this.a.H) || ListUtils.isEmpty(this.a.I) || this.a.I.size() <= num.intValue()) {
                    return;
                }
                this.a.A.d(num.intValue());
                SortSwitchButton sortSwitchButton = this.a;
                sortSwitchButton.B = ((Float) sortSwitchButton.I.get(num.intValue())).floatValue();
                this.a.invalidate();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements xk5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SortSwitchButton a;

        public b(SortSwitchButton sortSwitchButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sortSwitchButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sortSwitchButton;
        }

        @Override // com.baidu.tieba.xk5.a
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                ResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2921458, Integer.valueOf(i2));
                CustomMessage customMessage = new CustomMessage(2921458);
                customMessage.setTag(this.a.R);
                customMessage.setData(this.a.S);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SortSwitchButton a;

        public c(SortSwitchButton sortSwitchButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sortSwitchButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sortSwitchButton;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (!this.a.F && motionEvent.getX() <= this.a.a && motionEvent.getY() <= this.a.b) {
                    if (this.a.getParent() != null) {
                        this.a.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                if (this.a.D && this.a.E) {
                    this.a.B -= f;
                    if (this.a.B < 0.0f) {
                        this.a.B = 0.0f;
                    }
                    Float f3 = (Float) ListUtils.getItem(this.a.I, this.a.I.size() - 1);
                    float floatValue = f3 != null ? f3.floatValue() : 0.0f;
                    if (this.a.B > floatValue) {
                        this.a.B = floatValue;
                    }
                    this.a.invalidate();
                    return true;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                if (this.a.E) {
                    int a = this.a.A.a();
                    this.a.B = motionEvent.getX();
                    this.a.A.c(this.a.v());
                    this.a.F = true;
                    if (this.a.A.a() != a) {
                        this.a.I(a);
                        if (this.a.L != null) {
                            this.a.L.start();
                        }
                        this.a.A(a);
                    }
                    this.a.F = false;
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SortSwitchButton a;

        public d(SortSwitchButton sortSwitchButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sortSwitchButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sortSwitchButton;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * this.a.M;
                if (this.a.O) {
                    SortSwitchButton sortSwitchButton = this.a;
                    sortSwitchButton.B = sortSwitchButton.N - floatValue;
                } else {
                    SortSwitchButton sortSwitchButton2 = this.a;
                    sortSwitchButton2.B = sortSwitchButton2.N + floatValue;
                }
                this.a.invalidate();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SortSwitchButton a;

        public e(SortSwitchButton sortSwitchButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sortSwitchButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sortSwitchButton;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                if (this.a.I.size() > this.a.A.a()) {
                    SortSwitchButton sortSwitchButton = this.a;
                    sortSwitchButton.B = ((Float) sortSwitchButton.I.get(this.a.A.a())).floatValue();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface f {
        boolean a(int i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SortSwitchButton(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void A(int i) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (fVar = this.K) == null || fVar.a(this.A.a())) {
            return;
        }
        ValueAnimator valueAnimator = this.L;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.A.c(i);
        if (this.I.size() > this.A.a()) {
            this.B = this.I.get(this.A.a()).floatValue();
        }
        invalidate();
    }

    public final void B(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.s = new RectF();
            this.t = new Path();
            this.y = new RectF();
            this.z = new Path();
            Paint paint = new Paint(1);
            this.o = paint;
            paint.setColor(SkinManager.getColor(this.d));
            if (this.e > 0 && this.f > 0.0f) {
                this.u = new RectF();
                this.v = new Path();
                this.w = new RectF();
                this.x = new Path();
                Paint paint2 = new Paint(1);
                this.p = paint2;
                paint2.setStyle(Paint.Style.STROKE);
                this.p.setStrokeWidth(this.f);
                this.p.setColor(nj8.a(SkinManager.getColor(this.d), this.g));
            }
            this.q = new Paint(1);
            Paint paint3 = new Paint(1);
            this.r = paint3;
            paint3.setTextSize(this.k);
            this.H = new ArrayList();
            this.I = new ArrayList();
            this.A.d(0);
            this.J = new GestureDetector(context, this.V);
            C();
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
            this.L = duration;
            duration.addUpdateListener(new d(this));
            this.L.addListener(new e(this));
        }
    }

    public final void D(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0400bc, R.attr.obfuscated_res_0x7f0400bd, R.attr.obfuscated_res_0x7f0400be, R.attr.obfuscated_res_0x7f0400bf, R.attr.obfuscated_res_0x7f040609, R.attr.obfuscated_res_0x7f04062d, R.attr.obfuscated_res_0x7f04062e, R.attr.obfuscated_res_0x7f04062f, R.attr.obfuscated_res_0x7f040630, R.attr.obfuscated_res_0x7f040631, R.attr.obfuscated_res_0x7f0406f3, R.attr.obfuscated_res_0x7f0406f5, R.attr.obfuscated_res_0x7f04074a});
            int resourceId = obtainStyledAttributes.getResourceId(3, R.color.CAM_X0107);
            this.d = resourceId;
            this.e = obtainStyledAttributes.getResourceId(1, resourceId);
            this.f = obtainStyledAttributes.getDimension(2, 0.0f);
            this.g = obtainStyledAttributes.getFloat(0, 1.0f);
            this.h = obtainStyledAttributes.getResourceId(7, R.color.CAM_X0101);
            this.i = obtainStyledAttributes.getResourceId(12, R.color.CAM_X0105);
            this.j = obtainStyledAttributes.getResourceId(4, R.color.CAM_X0105);
            this.k = obtainStyledAttributes.getDimension(11, 5.0f);
            this.l = obtainStyledAttributes.getDimension(10, 0.0f);
            this.c = obtainStyledAttributes.getDimension(8, 0.0f);
            this.m = obtainStyledAttributes.getDimension(6, 0.0f);
            this.n = obtainStyledAttributes.getResourceId(5, R.color.CAM_X0105);
            this.Q = obtainStyledAttributes.getBoolean(9, false);
            obtainStyledAttributes.recycle();
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            RectF rectF = this.s;
            float f2 = this.f;
            rectF.set(f2, f2, this.a - f2, this.b - f2);
            this.t.reset();
            Path path = this.t;
            RectF rectF2 = this.s;
            float f3 = this.b;
            path.addRoundRect(rectF2, f3 / 2.0f, f3 / 2.0f, Path.Direction.CW);
            RectF rectF3 = this.u;
            if (rectF3 != null && this.p != null) {
                rectF3.set(0.0f, 0.0f, this.a, this.b);
                float f4 = this.f * 0.5f;
                float f5 = -f4;
                this.w.set(f5, f5, this.a + f4, this.b + f4);
                this.v.reset();
                this.x.reset();
                Path path2 = this.v;
                RectF rectF4 = this.u;
                float f6 = this.b;
                path2.addRoundRect(rectF4, f6 / 2.0f, f6 / 2.0f, Path.Direction.CW);
                Path path3 = this.x;
                RectF rectF5 = this.w;
                float f7 = this.b;
                path3.addRoundRect(rectF5, (f7 + f4) * 0.5f, (f7 + f4) * 0.5f, Path.Direction.CW);
            }
            Float f8 = (Float) ListUtils.getItem(this.I, this.A.a());
            this.B = f8 != null ? f8.floatValue() : 0.0f;
            Paint.FontMetrics fontMetrics = this.r.getFontMetrics();
            this.C = (this.b / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f);
        }
    }

    public final boolean F(List<ll8> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (!ListUtils.isEmpty(list) && list.size() == this.H.size()) {
                for (int i = 0; i < list.size(); i++) {
                    if (!G(list.get(i), this.H.get(i))) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean G(ll8 ll8Var, ll8 ll8Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, ll8Var, ll8Var2)) == null) {
            if (ll8Var == null && ll8Var2 == null) {
                return true;
            }
            if (ll8Var != null && ll8Var2 != null) {
                if (ll8Var.a() == ll8Var2.a() && ll8Var.b() != null && ll8Var.b().equals(ll8Var2.b())) {
                    return true;
                }
                if (ll8Var.a() == ll8Var2.a() && ll8Var.b() == null && ll8Var2.b() == null) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.P) {
            this.o.setColor(SkinManager.getColor(this.d));
            Paint paint = this.p;
            if (paint != null) {
                paint.setColor(nj8.a(SkinManager.getColor(this.d), this.g));
            }
            invalidate();
        }
    }

    public final void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            if (this.I.size() > i) {
                this.N = this.I.get(i).floatValue();
            }
            this.M = Math.abs((this.I.size() > this.A.a() ? this.I.get(this.A.a()).floatValue() : 0.0f) - this.N);
            this.O = this.A.a() < i;
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.A.c(0);
            this.B = 0.0f;
            this.F = false;
            this.H.clear();
            this.I.clear();
            this.G = true;
        }
    }

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.A.a() : invokeV.intValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, canvas) == null) {
            Path path = this.x;
            if (path != null) {
                canvas.clipPath(path);
            } else {
                canvas.clipPath(this.t);
            }
            super.onDraw(canvas);
            x(canvas);
            y(canvas);
            int i = 0;
            while (i < this.H.size() && i < this.I.size()) {
                z(canvas, this.H.get(i).b(), this.I.get(i).floatValue() + this.l, this.C, this.A.a() == i);
                i++;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
            super.onMeasure(i, i2);
            float size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            float size2 = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            int count = ListUtils.getCount(this.H);
            float f2 = 0.0f;
            if (mode == Integer.MIN_VALUE) {
                this.a = 0.0f;
                for (int i3 = 0; i3 < count; i3++) {
                    ll8 ll8Var = (ll8) ListUtils.getItem(this.H, i3);
                    if (ll8Var != null) {
                        float measureText = this.r.measureText(ll8Var.b() == null ? "" : ll8Var.b()) + (this.l * 2.0f);
                        if (this.G) {
                            this.I.add(Float.valueOf(this.a));
                        }
                        this.a += measureText;
                    }
                }
            } else {
                this.a = size;
                if (count > 0) {
                    size /= count;
                }
                for (int i4 = 0; i4 < count; i4++) {
                    if (this.G) {
                        this.I.add(Float.valueOf(f2));
                    }
                    f2 += size;
                }
            }
            if (mode2 == Integer.MIN_VALUE) {
                this.b = this.c;
            } else {
                this.b = size2;
                this.c = size2;
            }
            this.G = false;
            E();
            setMeasuredDimension((int) this.a, (int) this.b);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, view2, motionEvent)) == null) {
            if (this.J.onTouchEvent(motionEvent)) {
                return true;
            }
            if (this.D && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
                int a2 = this.A.a();
                int v = v();
                if (Math.abs(v - a2) >= 2 || v > a2) {
                    this.A.d(v);
                } else if (v < a2) {
                    float floatValue = this.I.size() > v ? this.I.get(v).floatValue() : 0.0f;
                    int i = v + 1;
                    float floatValue2 = i < this.I.size() ? this.I.get(i).floatValue() : floatValue;
                    float f2 = this.B;
                    if (f2 >= floatValue && f2 <= floatValue + ((floatValue2 - floatValue) / 2.0f)) {
                        this.A.d(v);
                    }
                } else {
                    float floatValue3 = this.I.size() > v ? this.I.get(v).floatValue() : 0.0f;
                    int i2 = v + 1;
                    if (this.B >= floatValue3 + (((i2 < this.I.size() ? this.I.get(i2).floatValue() : floatValue3) - floatValue3) / 2.0f) && i2 < this.I.size()) {
                        this.A.d(i2);
                    }
                }
                this.F = true;
                this.N = this.B;
                float floatValue4 = this.I.size() > this.A.a() ? this.I.get(this.A.a()).floatValue() : 0.0f;
                this.M = Math.abs(this.N - floatValue4);
                if (this.A.a() < a2) {
                    this.O = true;
                } else if (this.A.a() > a2) {
                    this.O = false;
                } else {
                    this.O = this.N > floatValue4;
                }
                ValueAnimator valueAnimator = this.L;
                if (valueAnimator != null) {
                    valueAnimator.start();
                }
                if (this.A.a() != a2) {
                    A(a2);
                }
                this.F = false;
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void setCanChange(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.E = z;
        }
    }

    public void setCanScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.D = z;
        }
    }

    public void setCommenId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bdUniqueId) == null) {
            this.R = bdUniqueId;
        }
    }

    public void setData(List<ll8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, list) == null) && F(list)) {
            if (ListUtils.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.H = list;
            requestLayout();
        }
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, bdUniqueId) == null) && this.Q) {
            this.T.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.T);
        }
    }

    public void setNeedDayNight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.P = z;
            if (z) {
                return;
            }
            this.o.setColor(SkinManager.getColor(0, this.d));
            Paint paint = this.p;
            if (paint != null) {
                paint.setColor(nj8.a(SkinManager.getColor(0, this.e), this.g));
            }
        }
    }

    public void setOnSwitchChangeListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, fVar) == null) {
            this.K = fVar;
        }
    }

    public final int v() {
        InterceptResult invokeV;
        float floatValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            int a2 = this.A.a();
            int i = 0;
            while (i < this.I.size()) {
                float floatValue2 = ((Float) ListUtils.getItem(this.I, i)).floatValue();
                int i2 = i + 1;
                if (i2 == this.I.size()) {
                    floatValue = this.a;
                } else {
                    floatValue = ((Float) ListUtils.getItem(this.I, i2)).floatValue();
                }
                float f2 = this.B;
                if (f2 <= floatValue2 || f2 >= floatValue) {
                    float f3 = this.B;
                    if (f3 == floatValue2) {
                        if (a2 - 1 >= 0) {
                            return a2 - 1;
                        }
                    } else if (f3 == floatValue && (i = a2 + 1) < ListUtils.getCount(this.I)) {
                    }
                    i = i2;
                }
                return i;
            }
            return a2;
        }
        return invokeV.intValue;
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i) == null) || ListUtils.isEmpty(this.H) || ListUtils.isEmpty(this.I)) {
            return;
        }
        for (int i2 = 0; i2 < this.H.size(); i2++) {
            if (this.H.get(i2).a() == i) {
                this.A.c(i2);
                if (this.I.size() > i2) {
                    this.B = this.I.get(i2).floatValue();
                }
                invalidate();
                return;
            }
        }
    }

    public final void x(Canvas canvas) {
        Paint paint;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, canvas) == null) {
            canvas.drawPath(this.t, this.o);
            if (this.e <= 0 || this.f <= 0.0f || (paint = this.p) == null) {
                return;
            }
            canvas.drawPath(this.v, paint);
        }
    }

    public final void y(Canvas canvas) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, canvas) == null) {
            if (this.B < 0.0f) {
                this.B = 0.0f;
            }
            float floatValue = !ListUtils.isEmpty(this.I) ? ((Float) ListUtils.getItem(this.I, this.A.a())).floatValue() : 0.0f;
            if (this.A.a() + 1 < this.I.size()) {
                f2 = this.I.get(this.A.a() + 1).floatValue();
            } else {
                f2 = this.A.a() + 1 == this.I.size() ? this.a : 0.0f;
            }
            float f3 = this.B + (f2 - floatValue);
            float f4 = this.a;
            if (f3 > f4) {
                f3 = f4;
            }
            this.y.set(this.B, 0.0f, f3, this.b);
            this.z.reset();
            Path path = this.z;
            RectF rectF = this.y;
            float f5 = this.c;
            path.addRoundRect(rectF, f5 / 2.0f, f5 / 2.0f, Path.Direction.CW);
            this.q.reset();
            this.q.setAntiAlias(true);
            this.q.setColor(this.P ? SkinManager.getColor(this.h) : SkinManager.getColor(0, this.h));
            canvas.drawPath(this.z, this.q);
            this.q.reset();
            this.q.setAntiAlias(true);
            this.q.setColor(this.P ? SkinManager.getColor(this.n) : SkinManager.getColor(0, this.n));
            this.q.setStyle(Paint.Style.STROKE);
            this.q.setStrokeWidth(this.m);
            RectF rectF2 = this.y;
            float f6 = this.B;
            float f7 = this.m;
            rectF2.set(f6 + (f7 / 2.0f), f7 / 2.0f, f3 - (f7 / 2.0f), this.c - (f7 / 2.0f));
            float f8 = (this.c - this.m) / 2.0f;
            canvas.drawRoundRect(this.y, f8, f8, this.q);
        }
    }

    public final void z(Canvas canvas, String str, float f2, float f3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{canvas, str, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)}) == null) {
            if (z) {
                this.r.setColor(this.P ? SkinManager.getColor(this.j) : SkinManager.getColor(0, this.j));
            } else {
                this.r.setColor(this.P ? SkinManager.getColor(this.i) : SkinManager.getColor(0, this.i));
            }
            canvas.drawText(str, f2, f3, this.r);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.A = new xk5();
        this.D = false;
        this.E = true;
        this.F = false;
        this.G = true;
        this.P = true;
        this.Q = false;
        this.S = BdUniqueId.gen();
        this.T = new a(this, 2921458);
        this.U = new b(this);
        this.V = new c(this);
        D(context, attributeSet);
        B(context);
        setOnTouchListener(this);
        if (this.Q) {
            this.A.b(this.U);
        }
    }

    public void setData(List<ll8> list, int i) {
        xk5 xk5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048594, this, list, i) == null) {
            if (F(list) || (xk5Var = this.A) == null || xk5Var.a() != i) {
                if (ListUtils.isEmpty(list)) {
                    setVisibility(8);
                    return;
                }
                J();
                setVisibility(0);
                this.A.c(i);
                this.H = list;
                requestLayout();
            }
        }
    }
}
