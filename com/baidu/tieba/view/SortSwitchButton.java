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
import c.a.s0.i;
import c.a.s0.v3.j0.s;
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
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class SortSwitchButton extends View implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RectF A;
    public Path B;
    public RectF C;
    public Path D;
    public i E;
    public float F;
    public float G;
    public boolean H;
    public boolean I;
    public boolean J;
    public List<s> K;
    public List<Float> L;
    public GestureDetector M;
    public f N;
    public ValueAnimator O;
    public float P;
    public float Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public BdUniqueId U;
    public BdUniqueId V;
    public CustomMessageListener W;
    public i.a a0;
    public GestureDetector.SimpleOnGestureListener b0;

    /* renamed from: e  reason: collision with root package name */
    public float f50909e;

    /* renamed from: f  reason: collision with root package name */
    public float f50910f;

    /* renamed from: g  reason: collision with root package name */
    public float f50911g;

    /* renamed from: h  reason: collision with root package name */
    public int f50912h;

    /* renamed from: i  reason: collision with root package name */
    public int f50913i;

    /* renamed from: j  reason: collision with root package name */
    public float f50914j;

    /* renamed from: k  reason: collision with root package name */
    public float f50915k;
    public int l;
    public int m;
    public int n;
    public float o;
    public float p;
    public float q;
    public int r;
    public Paint s;
    public Paint t;
    public Paint u;
    public Paint v;
    public RectF w;
    public Path x;
    public RectF y;
    public Path z;

    /* loaded from: classes12.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SortSwitchButton a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SortSwitchButton sortSwitchButton, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sortSwitchButton, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                if (tag == null || bdUniqueId == null || this.a.U == null) {
                    return;
                }
                Integer num = (Integer) customResponsedMessage.getData();
                if (tag.getId() != this.a.U.getId() || bdUniqueId.getId() == this.a.V.getId() || this.a.E.a() == num.intValue() || ListUtils.isEmpty(this.a.K) || ListUtils.isEmpty(this.a.L) || this.a.L.size() <= num.intValue()) {
                    return;
                }
                this.a.E.d(num.intValue());
                SortSwitchButton sortSwitchButton = this.a;
                sortSwitchButton.F = ((Float) sortSwitchButton.L.get(num.intValue())).floatValue();
                this.a.invalidate();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements i.a {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sortSwitchButton;
        }

        @Override // c.a.s0.i.a
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                ResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2921458, Integer.valueOf(i3));
                CustomMessage customMessage = new CustomMessage(2921458);
                customMessage.setTag(this.a.U);
                customMessage.setData(this.a.V);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SortSwitchButton f50916e;

        public c(SortSwitchButton sortSwitchButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sortSwitchButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50916e = sortSwitchButton;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (!this.f50916e.I && motionEvent.getX() <= this.f50916e.f50909e && motionEvent.getY() <= this.f50916e.f50910f) {
                    if (this.f50916e.getParent() != null) {
                        this.f50916e.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (this.f50916e.H) {
                    this.f50916e.F -= f2;
                    if (this.f50916e.F < 0.0f) {
                        this.f50916e.F = 0.0f;
                    }
                    Float f4 = (Float) ListUtils.getItem(this.f50916e.L, this.f50916e.L.size() - 1);
                    float floatValue = f4 != null ? f4.floatValue() : 0.0f;
                    if (this.f50916e.F > floatValue) {
                        this.f50916e.F = floatValue;
                    }
                    this.f50916e.invalidate();
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
                int a = this.f50916e.E.a();
                this.f50916e.F = motionEvent.getX();
                this.f50916e.E.c(this.f50916e.x());
                this.f50916e.I = true;
                if (this.f50916e.E.a() != a) {
                    this.f50916e.I(a);
                    if (this.f50916e.O != null) {
                        this.f50916e.O.start();
                    }
                    this.f50916e.B(a);
                }
                this.f50916e.I = false;
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SortSwitchButton f50917e;

        public d(SortSwitchButton sortSwitchButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sortSwitchButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50917e = sortSwitchButton;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * this.f50917e.P;
                if (this.f50917e.R) {
                    SortSwitchButton sortSwitchButton = this.f50917e;
                    sortSwitchButton.F = sortSwitchButton.Q - floatValue;
                } else {
                    SortSwitchButton sortSwitchButton2 = this.f50917e;
                    sortSwitchButton2.F = sortSwitchButton2.Q + floatValue;
                }
                this.f50917e.invalidate();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SortSwitchButton f50918e;

        public e(SortSwitchButton sortSwitchButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sortSwitchButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50918e = sortSwitchButton;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                if (this.f50918e.L.size() > this.f50918e.E.a()) {
                    SortSwitchButton sortSwitchButton = this.f50918e;
                    sortSwitchButton.F = ((Float) sortSwitchButton.L.get(this.f50918e.E.a())).floatValue();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface f {
        boolean a(int i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void A(Canvas canvas, String str, float f2, float f3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, str, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)}) == null) {
            if (z) {
                this.v.setColor(this.S ? SkinManager.getColor(this.n) : SkinManager.getColor(0, this.n));
            } else {
                this.v.setColor(this.S ? SkinManager.getColor(this.m) : SkinManager.getColor(0, this.m));
            }
            canvas.drawText(str, f2, f3, this.v);
        }
    }

    public final void B(int i2) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (fVar = this.N) == null || fVar.a(this.E.a())) {
            return;
        }
        ValueAnimator valueAnimator = this.O;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.E.c(i2);
        if (this.L.size() > this.E.a()) {
            this.F = this.L.get(this.E.a()).floatValue();
        }
        invalidate();
    }

    public final void C(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.w = new RectF();
            this.x = new Path();
            this.C = new RectF();
            this.D = new Path();
            Paint paint = new Paint(1);
            this.s = paint;
            paint.setColor(SkinManager.getColor(this.f50912h));
            if (this.f50913i > 0 && this.f50914j > 0.0f) {
                this.y = new RectF();
                this.z = new Path();
                this.A = new RectF();
                this.B = new Path();
                Paint paint2 = new Paint(1);
                this.t = paint2;
                paint2.setStyle(Paint.Style.STROKE);
                this.t.setStrokeWidth(this.f50914j);
                this.t.setColor(c.a.s0.v3.c.a(SkinManager.getColor(this.f50912h), this.f50915k));
            }
            this.u = new Paint(1);
            Paint paint3 = new Paint(1);
            this.v = paint3;
            paint3.setTextSize(this.o);
            this.K = new ArrayList();
            this.L = new ArrayList();
            this.E.d(0);
            this.M = new GestureDetector(context, this.b0);
            D();
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
            this.O = duration;
            duration.addUpdateListener(new d(this));
            this.O.addListener(new e(this));
        }
    }

    public final void E(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SortSwitchButton);
            int resourceId = obtainStyledAttributes.getResourceId(R$styleable.SortSwitchButton_background_color, R.color.CAM_X0107);
            this.f50912h = resourceId;
            this.f50913i = obtainStyledAttributes.getResourceId(R$styleable.SortSwitchButton_background_border_color, resourceId);
            this.f50914j = obtainStyledAttributes.getDimension(R$styleable.SortSwitchButton_background_border_width, 0.0f);
            this.f50915k = obtainStyledAttributes.getFloat(R$styleable.SortSwitchButton_background_border_alpha, 1.0f);
            this.l = obtainStyledAttributes.getResourceId(R$styleable.SortSwitchButton_slide_color, R.color.CAM_X0101);
            this.m = obtainStyledAttributes.getResourceId(R$styleable.SortSwitchButton_un_selected_text_color, R.color.CAM_X0105);
            this.n = obtainStyledAttributes.getResourceId(R$styleable.SortSwitchButton_selected_text_color, R.color.CAM_X0105);
            this.o = obtainStyledAttributes.getDimension(R$styleable.SortSwitchButton_text_size, 5.0f);
            this.p = obtainStyledAttributes.getDimension(R$styleable.SortSwitchButton_text_horizontal_padding, 0.0f);
            this.f50911g = obtainStyledAttributes.getDimension(R$styleable.SortSwitchButton_slide_height, 0.0f);
            this.q = obtainStyledAttributes.getDimension(R$styleable.SortSwitchButton_slide_border_width, 0.0f);
            this.r = obtainStyledAttributes.getResourceId(R$styleable.SortSwitchButton_slide_border_color, R.color.CAM_X0105);
            this.T = obtainStyledAttributes.getBoolean(R$styleable.SortSwitchButton_slide_need_sync, false);
            obtainStyledAttributes.recycle();
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            RectF rectF = this.w;
            float f2 = this.f50914j;
            rectF.set(f2, f2, this.f50909e - f2, this.f50910f - f2);
            this.x.reset();
            Path path = this.x;
            RectF rectF2 = this.w;
            float f3 = this.f50910f;
            path.addRoundRect(rectF2, f3 / 2.0f, f3 / 2.0f, Path.Direction.CW);
            RectF rectF3 = this.y;
            if (rectF3 != null && this.t != null) {
                rectF3.set(0.0f, 0.0f, this.f50909e, this.f50910f);
                float f4 = this.f50914j * 0.5f;
                float f5 = -f4;
                this.A.set(f5, f5, this.f50909e + f4, this.f50910f + f4);
                this.z.reset();
                this.B.reset();
                Path path2 = this.z;
                RectF rectF4 = this.y;
                float f6 = this.f50910f;
                path2.addRoundRect(rectF4, f6 / 2.0f, f6 / 2.0f, Path.Direction.CW);
                Path path3 = this.B;
                RectF rectF5 = this.A;
                float f7 = this.f50910f;
                path3.addRoundRect(rectF5, (f7 + f4) * 0.5f, (f7 + f4) * 0.5f, Path.Direction.CW);
            }
            Float f8 = (Float) ListUtils.getItem(this.L, this.E.a());
            this.F = f8 != null ? f8.floatValue() : 0.0f;
            Paint.FontMetrics fontMetrics = this.v.getFontMetrics();
            this.G = (this.f50910f / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f);
        }
    }

    public final boolean G(List<s> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (!ListUtils.isEmpty(list) && list.size() == this.K.size()) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (!H(list.get(i2), this.K.get(i2))) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean H(s sVar, s sVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, sVar, sVar2)) == null) {
            if (sVar == null && sVar2 == null) {
                return true;
            }
            if (sVar != null && sVar2 != null) {
                if (sVar.a() == sVar2.a() && sVar.b() != null && sVar.b().equals(sVar2.b())) {
                    return true;
                }
                if (sVar.a() == sVar2.a() && sVar.b() == null && sVar2.b() == null) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void I(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            if (this.L.size() > i2) {
                this.Q = this.L.get(i2).floatValue();
            }
            this.P = Math.abs((this.L.size() > this.E.a() ? this.L.get(this.E.a()).floatValue() : 0.0f) - this.Q);
            this.R = this.E.a() < i2;
        }
    }

    public void changeState(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || ListUtils.isEmpty(this.K) || ListUtils.isEmpty(this.L)) {
            return;
        }
        for (int i3 = 0; i3 < this.K.size(); i3++) {
            if (this.K.get(i3).a() == i2) {
                this.E.c(i3);
                if (this.L.size() > i3) {
                    this.F = this.L.get(i3).floatValue();
                }
                invalidate();
                return;
            }
        }
    }

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.E.a() : invokeV.intValue;
    }

    public int getSwitchMenuId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            s sVar = (s) ListUtils.getItem(this.K, i2);
            if (sVar == null) {
                return -1;
            }
            return sVar.a();
        }
        return invokeI.intValue;
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.S) {
            this.s.setColor(SkinManager.getColor(this.f50912h));
            Paint paint = this.t;
            if (paint != null) {
                paint.setColor(c.a.s0.v3.c.a(SkinManager.getColor(this.f50912h), this.f50915k));
            }
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, canvas) == null) {
            Path path = this.B;
            if (path != null) {
                canvas.clipPath(path);
            } else {
                canvas.clipPath(this.x);
            }
            super.onDraw(canvas);
            y(canvas);
            z(canvas);
            int i2 = 0;
            while (i2 < this.K.size() && i2 < this.L.size()) {
                A(canvas, this.K.get(i2).b(), this.L.get(i2).floatValue() + this.p, this.G, this.E.a() == i2);
                i2++;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            float size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            float size2 = View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i3);
            int count = ListUtils.getCount(this.K);
            float f2 = 0.0f;
            if (mode == Integer.MIN_VALUE) {
                this.f50909e = 0.0f;
                for (int i4 = 0; i4 < count; i4++) {
                    s sVar = (s) ListUtils.getItem(this.K, i4);
                    if (sVar != null) {
                        float measureText = this.v.measureText(sVar.b() == null ? "" : sVar.b()) + (this.p * 2.0f);
                        if (this.J) {
                            this.L.add(Float.valueOf(this.f50909e));
                        }
                        this.f50909e += measureText;
                    }
                }
            } else {
                this.f50909e = size;
                if (count > 0) {
                    size /= count;
                }
                for (int i5 = 0; i5 < count; i5++) {
                    if (this.J) {
                        this.L.add(Float.valueOf(f2));
                    }
                    f2 += size;
                }
            }
            if (mode2 == Integer.MIN_VALUE) {
                this.f50910f = this.f50911g;
            } else {
                this.f50910f = size2;
                this.f50911g = size2;
            }
            this.J = false;
            F();
            setMeasuredDimension((int) this.f50909e, (int) this.f50910f);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, view, motionEvent)) == null) {
            if (this.M.onTouchEvent(motionEvent)) {
                return true;
            }
            if (this.H && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
                int a2 = this.E.a();
                int x = x();
                if (Math.abs(x - a2) >= 2 || x > a2) {
                    this.E.d(x);
                } else if (x < a2) {
                    float floatValue = this.L.size() > x ? this.L.get(x).floatValue() : 0.0f;
                    int i2 = x + 1;
                    float floatValue2 = i2 < this.L.size() ? this.L.get(i2).floatValue() : floatValue;
                    float f2 = this.F;
                    if (f2 >= floatValue && f2 <= floatValue + ((floatValue2 - floatValue) / 2.0f)) {
                        this.E.d(x);
                    }
                } else {
                    float floatValue3 = this.L.size() > x ? this.L.get(x).floatValue() : 0.0f;
                    int i3 = x + 1;
                    if (this.F >= floatValue3 + (((i3 < this.L.size() ? this.L.get(i3).floatValue() : floatValue3) - floatValue3) / 2.0f) && i3 < this.L.size()) {
                        this.E.d(i3);
                    }
                }
                this.I = true;
                this.Q = this.F;
                float floatValue4 = this.L.size() > this.E.a() ? this.L.get(this.E.a()).floatValue() : 0.0f;
                this.P = Math.abs(this.Q - floatValue4);
                if (this.E.a() < a2) {
                    this.R = true;
                } else if (this.E.a() > a2) {
                    this.R = false;
                } else {
                    this.R = this.Q > floatValue4;
                }
                ValueAnimator valueAnimator = this.O;
                if (valueAnimator != null) {
                    valueAnimator.start();
                }
                if (this.E.a() != a2) {
                    B(a2);
                }
                this.I = false;
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.E.c(0);
            this.F = 0.0f;
            this.I = false;
            this.K.clear();
            this.L.clear();
            this.J = true;
        }
    }

    public void setCanScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.H = z;
        }
    }

    public void setCommenId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bdUniqueId) == null) {
            this.U = bdUniqueId;
        }
    }

    public void setData(List<s> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, list) == null) && G(list)) {
            if (ListUtils.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.K = list;
            requestLayout();
        }
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, bdUniqueId) == null) && this.T) {
            this.W.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.W);
        }
    }

    public void setNeedDayNight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.S = z;
            if (z) {
                return;
            }
            this.s.setColor(SkinManager.getColor(0, this.f50912h));
            Paint paint = this.t;
            if (paint != null) {
                paint.setColor(c.a.s0.v3.c.a(SkinManager.getColor(0, this.f50913i), this.f50915k));
            }
        }
    }

    public void setOnSwitchChangeListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, fVar) == null) {
            this.N = fVar;
        }
    }

    public final int x() {
        InterceptResult invokeV;
        float floatValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            int a2 = this.E.a();
            int i2 = 0;
            while (i2 < this.L.size()) {
                float floatValue2 = ((Float) ListUtils.getItem(this.L, i2)).floatValue();
                int i3 = i2 + 1;
                if (i3 == this.L.size()) {
                    floatValue = this.f50909e;
                } else {
                    floatValue = ((Float) ListUtils.getItem(this.L, i3)).floatValue();
                }
                float f2 = this.F;
                if (f2 <= floatValue2 || f2 >= floatValue) {
                    float f3 = this.F;
                    if (f3 == floatValue2) {
                        if (a2 - 1 >= 0) {
                            return a2 - 1;
                        }
                    } else if (f3 == floatValue && (i2 = a2 + 1) < ListUtils.getCount(this.L)) {
                    }
                    i2 = i3;
                }
                return i2;
            }
            return a2;
        }
        return invokeV.intValue;
    }

    public final void y(Canvas canvas) {
        Paint paint;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, canvas) == null) {
            canvas.drawPath(this.x, this.s);
            if (this.f50913i <= 0 || this.f50914j <= 0.0f || (paint = this.t) == null) {
                return;
            }
            canvas.drawPath(this.z, paint);
        }
    }

    public final void z(Canvas canvas) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, canvas) == null) {
            if (this.F < 0.0f) {
                this.F = 0.0f;
            }
            float floatValue = !ListUtils.isEmpty(this.L) ? ((Float) ListUtils.getItem(this.L, this.E.a())).floatValue() : 0.0f;
            if (this.E.a() + 1 < this.L.size()) {
                f2 = this.L.get(this.E.a() + 1).floatValue();
            } else {
                f2 = this.E.a() + 1 == this.L.size() ? this.f50909e : 0.0f;
            }
            float f3 = this.F + (f2 - floatValue);
            float f4 = this.f50909e;
            if (f3 > f4) {
                f3 = f4;
            }
            this.C.set(this.F, 0.0f, f3, this.f50910f);
            this.D.reset();
            Path path = this.D;
            RectF rectF = this.C;
            float f5 = this.f50911g;
            path.addRoundRect(rectF, f5 / 2.0f, f5 / 2.0f, Path.Direction.CW);
            this.u.reset();
            this.u.setAntiAlias(true);
            this.u.setColor(this.S ? SkinManager.getColor(this.l) : SkinManager.getColor(0, this.l));
            canvas.drawPath(this.D, this.u);
            this.u.reset();
            this.u.setAntiAlias(true);
            this.u.setColor(this.S ? SkinManager.getColor(this.r) : SkinManager.getColor(0, this.r));
            this.u.setStyle(Paint.Style.STROKE);
            this.u.setStrokeWidth(this.q);
            RectF rectF2 = this.C;
            float f6 = this.F;
            float f7 = this.q;
            rectF2.set(f6 + (f7 / 2.0f), f7 / 2.0f, f3 - (f7 / 2.0f), this.f50911g - (f7 / 2.0f));
            float f8 = (this.f50911g - this.q) / 2.0f;
            canvas.drawRoundRect(this.C, f8, f8, this.u);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.E = new i();
        this.H = false;
        this.I = false;
        this.J = true;
        this.S = true;
        this.T = false;
        this.V = BdUniqueId.gen();
        this.W = new a(this, 2921458);
        this.a0 = new b(this);
        this.b0 = new c(this);
        E(context, attributeSet);
        C(context);
        setOnTouchListener(this);
        if (this.T) {
            this.E.b(this.a0);
        }
    }

    public void setData(List<s> list, int i2) {
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048596, this, list, i2) == null) {
            if (G(list) || (iVar = this.E) == null || iVar.a() != i2) {
                if (ListUtils.isEmpty(list)) {
                    setVisibility(8);
                    return;
                }
                reset();
                setVisibility(0);
                this.E.c(i2);
                this.K = list;
                requestLayout();
            }
        }
    }
}
