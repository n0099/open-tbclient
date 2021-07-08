package com.baidu.tieba.pb.pb.sub;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class SubPbView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BlankView f19663e;

    /* renamed from: f  reason: collision with root package name */
    public View f19664f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f19665g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f19666h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f19667i;
    public float j;
    public float k;
    public boolean l;
    public boolean m;
    public ValueAnimator n;
    public int o;
    public int p;
    public float q;
    public boolean r;

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SubPbView f19668e;

        public a(SubPbView subPbView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subPbView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19668e = subPbView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f19668e.o = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SubPbView subPbView = this.f19668e;
                subPbView.q = 1.0f - (subPbView.o / l.i(this.f19668e.getContext()));
                if (this.f19668e.o == 0) {
                    this.f19668e.q = 1.0f;
                } else if (this.f19668e.o == l.i(this.f19668e.getContext())) {
                    this.f19668e.q = 0.0f;
                    if (this.f19668e.m && (this.f19668e.getContext() instanceof Activity)) {
                        ((Activity) this.f19668e.getContext()).finish();
                    }
                }
                this.f19668e.requestLayout();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SubPbView(Context context) {
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

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
        if (r0 != 3) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00dc  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, motionEvent)) != null) {
            return invokeL.booleanValue;
        }
        if (this.f19663e != null && this.r) {
            if (this.n.isRunning()) {
                this.n.end();
                return true;
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float rawY = motionEvent.getRawY();
                        this.k = rawY;
                        this.q = 1.0f - ((rawY - this.j) / l.i(getContext()));
                    }
                }
                z = this.k > this.j && this.f19664f.getTop() == 0 && this.f19666h.getFirstVisiblePosition() == 0;
                boolean z2 = this.k - this.j > ((float) this.p) && this.f19664f.getTop() == 0 && this.f19666h.getFirstVisiblePosition() == 0;
                this.m = z2;
                if (z2) {
                    this.n.setIntValues((int) (this.k - this.j), l.i(getContext()));
                    this.n.start();
                } else {
                    this.q = 1.0f;
                    this.j = 0.0f;
                    this.k = 0.0f;
                    requestLayout();
                }
                if (this.k <= this.j && this.f19664f.getTop() == 0 && this.f19666h.getFirstVisiblePosition() == 0) {
                    this.l = true;
                    requestLayout();
                    return true;
                } else if (!z) {
                    this.l = true;
                    return true;
                } else {
                    this.l = false;
                    return super.dispatchTouchEvent(motionEvent);
                }
            }
            float rawY2 = motionEvent.getRawY();
            this.j = rawY2;
            this.k = rawY2;
            z = false;
            if (this.k <= this.j) {
            }
            if (!z) {
            }
        } else {
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.n.cancel();
            this.n.removeAllUpdateListeners();
            clearAnimation();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.m = true;
            this.n.setIntValues(0, l.i(getContext()));
            this.n.start();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.q == 0.0f) {
            this.n.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            float f2 = this.q;
            if (f2 >= 0.0f && this.f19663e != null) {
                canvas.drawColor(Color.argb((int) (f2 * 168.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            }
            super.onDraw(canvas);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            if (this.f19663e == null) {
                super.onLayout(z, i2, i3, i4, i5);
                return;
            }
            int i6 = this.o;
            if (i6 == 0) {
                super.onLayout(z, i2, i3, i4, i5);
                float f2 = this.k;
                float f3 = this.j;
                if (f2 > f3) {
                    LinearLayout linearLayout = this.f19665g;
                    linearLayout.layout(i2, (int) (f2 - f3), i4, ((int) (f2 - f3)) + linearLayout.getHeight());
                    this.f19667i.layout(i2, ((int) (this.k - this.j)) + this.f19665g.getHeight(), i4, i5);
                    return;
                }
                return;
            }
            LinearLayout linearLayout2 = this.f19665g;
            linearLayout2.layout(i2, i6, i4, linearLayout2.getMeasuredHeight() + i6);
            this.f19667i.layout(i2, this.o + this.f19665g.getMeasuredHeight(), i4, i5);
        }
    }

    public void setBlankView(BlankView blankView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, blankView) == null) {
            this.f19663e = blankView;
        }
    }

    public void setContentView(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, relativeLayout) == null) {
            this.f19667i = relativeLayout;
        }
    }

    public void setEnableDragExit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.r = z;
        }
    }

    public void setListView(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bdTypeListView) == null) {
            this.f19666h = bdTypeListView;
        }
    }

    public void setNavigationView(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, linearLayout) == null) {
            this.f19665g = linearLayout;
        }
    }

    public void setTopView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            this.f19664f = view;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SubPbView(Context context, AttributeSet attributeSet) {
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
    public SubPbView(Context context, AttributeSet attributeSet, int i2) {
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
        this.q = 0.0f;
        this.p = (l.i(context) / 3) - l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);
        this.o = l.i(context);
        ValueAnimator ofInt = ValueAnimator.ofInt(l.i(context), 0);
        this.n = ofInt;
        ofInt.setDuration(300L);
        this.n.setInterpolator(new LinearInterpolator());
        this.n.addUpdateListener(new a(this));
    }
}
