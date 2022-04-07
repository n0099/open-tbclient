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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ph5;
import com.repackage.yk8;
import com.repackage.zi8;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class SortSwitchButton extends View implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ph5 A;
    public float B;
    public float C;
    public boolean D;
    public boolean E;
    public boolean F;
    public List<yk8> G;
    public List<Float> H;
    public GestureDetector I;
    public f J;
    public ValueAnimator K;
    public float L;
    public float M;
    public boolean N;
    public boolean O;
    public boolean P;
    public BdUniqueId Q;
    public BdUniqueId R;
    public CustomMessageListener S;
    public ph5.a T;
    public GestureDetector.SimpleOnGestureListener U;
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

    /* loaded from: classes4.dex */
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
                if (tag == null || bdUniqueId == null || this.a.Q == null) {
                    return;
                }
                Integer num = (Integer) customResponsedMessage.getData();
                if (tag.getId() != this.a.Q.getId() || bdUniqueId.getId() == this.a.R.getId() || this.a.A.a() == num.intValue() || ListUtils.isEmpty(this.a.G) || ListUtils.isEmpty(this.a.H) || this.a.H.size() <= num.intValue()) {
                    return;
                }
                this.a.A.d(num.intValue());
                SortSwitchButton sortSwitchButton = this.a;
                sortSwitchButton.B = ((Float) sortSwitchButton.H.get(num.intValue())).floatValue();
                this.a.invalidate();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ph5.a {
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

        @Override // com.repackage.ph5.a
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                ResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2921458, Integer.valueOf(i2));
                CustomMessage customMessage = new CustomMessage(2921458);
                customMessage.setTag(this.a.Q);
                customMessage.setData(this.a.R);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (!this.a.E && motionEvent.getX() <= this.a.a && motionEvent.getY() <= this.a.b) {
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
                if (this.a.D) {
                    this.a.B -= f;
                    if (this.a.B < 0.0f) {
                        this.a.B = 0.0f;
                    }
                    Float f3 = (Float) ListUtils.getItem(this.a.H, this.a.H.size() - 1);
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
                int a = this.a.A.a();
                this.a.B = motionEvent.getX();
                this.a.A.c(this.a.u());
                this.a.E = true;
                if (this.a.A.a() != a) {
                    this.a.I(a);
                    if (this.a.K != null) {
                        this.a.K.start();
                    }
                    this.a.A(a);
                }
                this.a.E = false;
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
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
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * this.a.L;
                if (this.a.N) {
                    SortSwitchButton sortSwitchButton = this.a;
                    sortSwitchButton.B = sortSwitchButton.M - floatValue;
                } else {
                    SortSwitchButton sortSwitchButton2 = this.a;
                    sortSwitchButton2.B = sortSwitchButton2.M + floatValue;
                }
                this.a.invalidate();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (this.a.H.size() > this.a.A.a()) {
                    SortSwitchButton sortSwitchButton = this.a;
                    sortSwitchButton.B = ((Float) sortSwitchButton.H.get(this.a.A.a())).floatValue();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (fVar = this.J) == null || fVar.a(this.A.a())) {
            return;
        }
        ValueAnimator valueAnimator = this.K;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.A.c(i);
        if (this.H.size() > this.A.a()) {
            this.B = this.H.get(this.A.a()).floatValue();
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
                this.p.setColor(zi8.a(SkinManager.getColor(this.d), this.g));
            }
            this.q = new Paint(1);
            Paint paint3 = new Paint(1);
            this.r = paint3;
            paint3.setTextSize(this.k);
            this.G = new ArrayList();
            this.H = new ArrayList();
            this.A.d(0);
            this.I = new GestureDetector(context, this.U);
            C();
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
            this.K = duration;
            duration.addUpdateListener(new d(this));
            this.K.addListener(new e(this));
        }
    }

    public final void D(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0400b0, R.attr.obfuscated_res_0x7f0400b1, R.attr.obfuscated_res_0x7f0400b2, R.attr.obfuscated_res_0x7f0400b3, R.attr.obfuscated_res_0x7f04057e, R.attr.obfuscated_res_0x7f04059f, R.attr.obfuscated_res_0x7f0405a0, R.attr.obfuscated_res_0x7f0405a1, R.attr.obfuscated_res_0x7f0405a2, R.attr.obfuscated_res_0x7f0405a3, R.attr.obfuscated_res_0x7f04065e, R.attr.obfuscated_res_0x7f040660, R.attr.obfuscated_res_0x7f0406ab});
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
            this.P = obtainStyledAttributes.getBoolean(9, false);
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
            Float f8 = (Float) ListUtils.getItem(this.H, this.A.a());
            this.B = f8 != null ? f8.floatValue() : 0.0f;
            Paint.FontMetrics fontMetrics = this.r.getFontMetrics();
            this.C = (this.b / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f);
        }
    }

    public final boolean F(List<yk8> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (!ListUtils.isEmpty(list) && list.size() == this.G.size()) {
                for (int i = 0; i < list.size(); i++) {
                    if (!G(list.get(i), this.G.get(i))) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean G(yk8 yk8Var, yk8 yk8Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, yk8Var, yk8Var2)) == null) {
            if (yk8Var == null && yk8Var2 == null) {
                return true;
            }
            if (yk8Var != null && yk8Var2 != null) {
                if (yk8Var.a() == yk8Var2.a() && yk8Var.b() != null && yk8Var.b().equals(yk8Var2.b())) {
                    return true;
                }
                if (yk8Var.a() == yk8Var2.a() && yk8Var.b() == null && yk8Var2.b() == null) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.O) {
            this.o.setColor(SkinManager.getColor(this.d));
            Paint paint = this.p;
            if (paint != null) {
                paint.setColor(zi8.a(SkinManager.getColor(this.d), this.g));
            }
            invalidate();
        }
    }

    public final void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            if (this.H.size() > i) {
                this.M = this.H.get(i).floatValue();
            }
            this.L = Math.abs((this.H.size() > this.A.a() ? this.H.get(this.A.a()).floatValue() : 0.0f) - this.M);
            this.N = this.A.a() < i;
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.A.c(0);
            this.B = 0.0f;
            this.E = false;
            this.G.clear();
            this.H.clear();
            this.F = true;
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
            w(canvas);
            x(canvas);
            int i = 0;
            while (i < this.G.size() && i < this.H.size()) {
                z(canvas, this.G.get(i).b(), this.H.get(i).floatValue() + this.l, this.C, this.A.a() == i);
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
            int count = ListUtils.getCount(this.G);
            float f2 = 0.0f;
            if (mode == Integer.MIN_VALUE) {
                this.a = 0.0f;
                for (int i3 = 0; i3 < count; i3++) {
                    yk8 yk8Var = (yk8) ListUtils.getItem(this.G, i3);
                    if (yk8Var != null) {
                        float measureText = this.r.measureText(yk8Var.b() == null ? "" : yk8Var.b()) + (this.l * 2.0f);
                        if (this.F) {
                            this.H.add(Float.valueOf(this.a));
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
                    if (this.F) {
                        this.H.add(Float.valueOf(f2));
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
            this.F = false;
            E();
            setMeasuredDimension((int) this.a, (int) this.b);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, view2, motionEvent)) == null) {
            if (this.I.onTouchEvent(motionEvent)) {
                return true;
            }
            if (this.D && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
                int a2 = this.A.a();
                int u = u();
                if (Math.abs(u - a2) >= 2 || u > a2) {
                    this.A.d(u);
                } else if (u < a2) {
                    float floatValue = this.H.size() > u ? this.H.get(u).floatValue() : 0.0f;
                    int i = u + 1;
                    float floatValue2 = i < this.H.size() ? this.H.get(i).floatValue() : floatValue;
                    float f2 = this.B;
                    if (f2 >= floatValue && f2 <= floatValue + ((floatValue2 - floatValue) / 2.0f)) {
                        this.A.d(u);
                    }
                } else {
                    float floatValue3 = this.H.size() > u ? this.H.get(u).floatValue() : 0.0f;
                    int i2 = u + 1;
                    if (this.B >= floatValue3 + (((i2 < this.H.size() ? this.H.get(i2).floatValue() : floatValue3) - floatValue3) / 2.0f) && i2 < this.H.size()) {
                        this.A.d(i2);
                    }
                }
                this.E = true;
                this.M = this.B;
                float floatValue4 = this.H.size() > this.A.a() ? this.H.get(this.A.a()).floatValue() : 0.0f;
                this.L = Math.abs(this.M - floatValue4);
                if (this.A.a() < a2) {
                    this.N = true;
                } else if (this.A.a() > a2) {
                    this.N = false;
                } else {
                    this.N = this.M > floatValue4;
                }
                ValueAnimator valueAnimator = this.K;
                if (valueAnimator != null) {
                    valueAnimator.start();
                }
                if (this.A.a() != a2) {
                    A(a2);
                }
                this.E = false;
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void setCanScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.D = z;
        }
    }

    public void setCommenId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bdUniqueId) == null) {
            this.Q = bdUniqueId;
        }
    }

    public void setData(List<yk8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, list) == null) && F(list)) {
            if (ListUtils.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.G = list;
            requestLayout();
        }
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, bdUniqueId) == null) && this.P) {
            this.S.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.S);
        }
    }

    public void setNeedDayNight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.O = z;
            if (z) {
                return;
            }
            this.o.setColor(SkinManager.getColor(0, this.d));
            Paint paint = this.p;
            if (paint != null) {
                paint.setColor(zi8.a(SkinManager.getColor(0, this.e), this.g));
            }
        }
    }

    public void setOnSwitchChangeListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) {
            this.J = fVar;
        }
    }

    public final int u() {
        InterceptResult invokeV;
        float floatValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            int a2 = this.A.a();
            int i = 0;
            while (i < this.H.size()) {
                float floatValue2 = ((Float) ListUtils.getItem(this.H, i)).floatValue();
                int i2 = i + 1;
                if (i2 == this.H.size()) {
                    floatValue = this.a;
                } else {
                    floatValue = ((Float) ListUtils.getItem(this.H, i2)).floatValue();
                }
                float f2 = this.B;
                if (f2 <= floatValue2 || f2 >= floatValue) {
                    float f3 = this.B;
                    if (f3 == floatValue2) {
                        if (a2 - 1 >= 0) {
                            return a2 - 1;
                        }
                    } else if (f3 == floatValue && (i = a2 + 1) < ListUtils.getCount(this.H)) {
                    }
                    i = i2;
                }
                return i;
            }
            return a2;
        }
        return invokeV.intValue;
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i) == null) || ListUtils.isEmpty(this.G) || ListUtils.isEmpty(this.H)) {
            return;
        }
        for (int i2 = 0; i2 < this.G.size(); i2++) {
            if (this.G.get(i2).a() == i) {
                this.A.c(i2);
                if (this.H.size() > i2) {
                    this.B = this.H.get(i2).floatValue();
                }
                invalidate();
                return;
            }
        }
    }

    public final void w(Canvas canvas) {
        Paint paint;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, canvas) == null) {
            canvas.drawPath(this.t, this.o);
            if (this.e <= 0 || this.f <= 0.0f || (paint = this.p) == null) {
                return;
            }
            canvas.drawPath(this.v, paint);
        }
    }

    public final void x(Canvas canvas) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, canvas) == null) {
            if (this.B < 0.0f) {
                this.B = 0.0f;
            }
            float floatValue = !ListUtils.isEmpty(this.H) ? ((Float) ListUtils.getItem(this.H, this.A.a())).floatValue() : 0.0f;
            if (this.A.a() + 1 < this.H.size()) {
                f2 = this.H.get(this.A.a() + 1).floatValue();
            } else {
                f2 = this.A.a() + 1 == this.H.size() ? this.a : 0.0f;
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
            this.q.setColor(this.O ? SkinManager.getColor(this.h) : SkinManager.getColor(0, this.h));
            canvas.drawPath(this.z, this.q);
            this.q.reset();
            this.q.setAntiAlias(true);
            this.q.setColor(this.O ? SkinManager.getColor(this.n) : SkinManager.getColor(0, this.n));
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
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{canvas, str, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)}) == null) {
            if (z) {
                this.r.setColor(this.O ? SkinManager.getColor(this.j) : SkinManager.getColor(0, this.j));
            } else {
                this.r.setColor(this.O ? SkinManager.getColor(this.i) : SkinManager.getColor(0, this.i));
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
        this.A = new ph5();
        this.D = false;
        this.E = false;
        this.F = true;
        this.O = true;
        this.P = false;
        this.R = BdUniqueId.gen();
        this.S = new a(this, 2921458);
        this.T = new b(this);
        this.U = new c(this);
        D(context, attributeSet);
        B(context);
        setOnTouchListener(this);
        if (this.P) {
            this.A.b(this.T);
        }
    }

    public void setData(List<yk8> list, int i) {
        ph5 ph5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, list, i) == null) {
            if (F(list) || (ph5Var = this.A) == null || ph5Var.a() != i) {
                if (ListUtils.isEmpty(list)) {
                    setVisibility(8);
                    return;
                }
                J();
                setVisibility(0);
                this.A.c(i);
                this.G = list;
                requestLayout();
            }
        }
    }
}
