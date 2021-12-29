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
import c.a.d.f.p.n;
import c.a.t0.s2.g;
import c.a.t0.s2.r.u;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class SubPbView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BlankView f48600e;

    /* renamed from: f  reason: collision with root package name */
    public View f48601f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f48602g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f48603h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f48604i;

    /* renamed from: j  reason: collision with root package name */
    public float f48605j;

    /* renamed from: k  reason: collision with root package name */
    public float f48606k;
    public boolean l;
    public boolean m;
    public ValueAnimator n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public int s;
    public float t;
    public boolean u;

    /* loaded from: classes12.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SubPbView f48607e;

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
            this.f48607e = subPbView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f48607e.o = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SubPbView subPbView = this.f48607e;
                subPbView.t = 1.0f - (subPbView.o / n.i(this.f48607e.getContext()));
                if (this.f48607e.o == 0) {
                    this.f48607e.t = 1.0f;
                } else if (this.f48607e.o == n.i(this.f48607e.getContext())) {
                    this.f48607e.t = 0.0f;
                    if (this.f48607e.m && (this.f48607e.getContext() instanceof Activity)) {
                        ((Activity) this.f48607e.getContext()).finish();
                    }
                }
                this.f48607e.requestLayout();
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

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
        if (r0 != 3) goto L19;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (this.f48600e != null && this.u) {
                if (this.n.isRunning()) {
                    this.n.end();
                    return true;
                }
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float rawY = motionEvent.getRawY();
                            this.f48606k = rawY;
                            this.t = 1.0f - ((rawY - this.f48605j) / n.i(getContext()));
                            if ((this.q || this.r) && this.f48601f.getTop() == 0 && this.f48603h.getFirstVisiblePosition() == 0 && !this.m) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921597, new u(this.f48606k, this.f48605j, this.o, this.t, this.m)));
                            }
                        }
                    }
                    this.l = false;
                    z = this.f48606k > this.f48605j && this.f48601f.getTop() == 0 && this.f48603h.getFirstVisiblePosition() == 0;
                    boolean z2 = this.f48606k - this.f48605j > ((float) this.s) && this.f48601f.getTop() == 0 && this.f48603h.getFirstVisiblePosition() == 0;
                    this.m = z2;
                    if (z2) {
                        if (this.q || this.r) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921597, new u(this.f48606k, this.f48605j, this.o, this.t, this.m)));
                        }
                        this.n.setIntValues((int) (this.f48606k - this.f48605j), n.i(getContext()));
                        this.n.setDuration(300L);
                        this.n.start();
                    } else {
                        this.t = 1.0f;
                        this.f48605j = 0.0f;
                        this.f48606k = 0.0f;
                        if (this.q || this.r) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921597, new u(this.f48606k, this.f48605j, this.o, this.t, this.m)));
                        }
                        requestLayout();
                    }
                    if (!this.l || (this.f48606k > this.f48605j && this.f48601f.getTop() == 0 && this.f48603h.getFirstVisiblePosition() == 0)) {
                        this.l = true;
                        requestLayout();
                        return true;
                    } else if (z) {
                        this.l = true;
                        return true;
                    } else {
                        this.l = false;
                        return super.dispatchTouchEvent(motionEvent);
                    }
                }
                this.f48606k = motionEvent.getRawY();
                if (this.f48601f.getTop() == 0 && this.f48603h.getFirstVisiblePosition() == 0) {
                    this.f48605j = motionEvent.getRawY();
                } else {
                    this.f48605j = this.f48606k;
                }
                z = false;
                if (this.l) {
                }
                this.l = true;
                requestLayout();
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public boolean isDrag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.n.cancel();
            this.n.removeAllUpdateListeners();
            clearAnimation();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            float f2 = this.t;
            if (f2 >= 0.0f && this.f48600e != null) {
                canvas.drawColor(Color.argb((int) (f2 * 168.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            }
            if (this.q || this.r) {
                canvas.drawColor(Color.argb(0, 255, 255, 255), PorterDuff.Mode.CLEAR);
            }
            super.onDraw(canvas);
        }
    }

    public void onFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.m = true;
            if (this.q || this.r) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921597, new u(this.f48606k, this.f48605j, this.o, this.t, this.m)));
            }
            this.n.setIntValues(0, n.i(getContext()));
            this.n.setDuration(300L);
            this.n.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            if (this.f48600e == null) {
                super.onLayout(z, i2, i3, i4, i5);
                return;
            }
            int i6 = this.o;
            if (i6 == 0) {
                super.onLayout(z, i2, i3, i4, i5);
                float f2 = this.f48606k;
                float f3 = this.f48605j;
                if (f2 <= f3 || !this.l) {
                    return;
                }
                LinearLayout linearLayout = this.f48602g;
                linearLayout.layout(i2, (int) (f2 - f3), i4, ((int) (f2 - f3)) + linearLayout.getHeight());
                this.f48604i.layout(i2, ((int) (this.f48606k - this.f48605j)) + this.f48602g.getHeight(), i4, i5);
                return;
            }
            LinearLayout linearLayout2 = this.f48602g;
            linearLayout2.layout(i2, i6, i4, linearLayout2.getMeasuredHeight() + i6);
            this.f48604i.layout(i2, this.o + this.f48602g.getMeasuredHeight(), i4, i5);
        }
    }

    public void setAnimTime(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.p = i2;
            this.n.setDuration(i2);
        }
    }

    public void setBlankView(BlankView blankView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, blankView) == null) {
            this.f48600e = blankView;
        }
    }

    public void setContentView(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, relativeLayout) == null) {
            this.f48604i = relativeLayout;
        }
    }

    public void setEnableDragExit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.u = z;
        }
    }

    public void setIsFromFoldComment(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.r = z;
        }
    }

    public void setIsFromVideoTab(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.q = z;
        }
    }

    public void setListView(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bdTypeListView) == null) {
            this.f48603h = bdTypeListView;
        }
    }

    public void setNavigationView(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, linearLayout) == null) {
            this.f48602g = linearLayout;
        }
    }

    public void setSubPbViewData(u uVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, uVar) == null) || uVar == null) {
            return;
        }
        this.t = uVar.f23098d;
        float f2 = uVar.f23096b;
        this.f48605j = f2;
        float f3 = uVar.a;
        this.f48606k = f3;
        this.o = uVar.f23097c;
        this.m = uVar.f23099e;
        boolean z = f3 > f2;
        if (this.m) {
            this.n.setIntValues((int) (this.f48606k - this.f48605j), n.i(getContext()));
            this.n.setDuration(0L);
            this.n.start();
        }
        if (this.f48606k > this.f48605j) {
            this.l = true;
        } else {
            this.l = z;
        }
        requestLayout();
    }

    public void setTopView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            this.f48601f = view;
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.t == 0.0f) {
            this.n.setDuration(this.p);
            this.n.start();
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
        this.p = 300;
        this.q = false;
        this.r = false;
        this.t = 0.0f;
        if (0 != 0) {
            this.s = n.i(context) / 10;
        } else {
            this.s = (n.i(context) / 3) - n.f(TbadkCoreApplication.getInst(), g.ds160);
        }
        this.o = n.i(context);
        ValueAnimator ofInt = ValueAnimator.ofInt(n.i(context), 0);
        this.n = ofInt;
        ofInt.setDuration(this.p);
        this.n.setInterpolator(new LinearInterpolator());
        this.n.addUpdateListener(new a(this));
    }
}
