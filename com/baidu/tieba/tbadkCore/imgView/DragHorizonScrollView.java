package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.Scroller;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.rl8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class DragHorizonScrollView extends ViewGroup implements View.OnLongClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public Runnable D;
    public BaseAdapter a;
    public View b;
    public rl8 c;
    public int d;
    public int e;
    public int f;
    public int g;
    public float h;
    public int i;
    public Scroller j;
    public Scroller k;
    public VelocityTracker l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;
    public int q;
    public int r;
    public int s;
    public boolean t;
    public View u;
    public int v;
    public boolean w;
    public ArrayList<View> x;
    public boolean y;
    public boolean z;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DragHorizonScrollView a;

        public a(DragHorizonScrollView dragHorizonScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dragHorizonScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dragHorizonScrollView;
        }

        @Override // java.lang.Runnable
        public void run() {
            int max;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.d == 0) {
                    this.a.k.forceFinished(true);
                    return;
                }
                Scroller scroller = this.a.k;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i = this.a.v - currX;
                if (i > 0) {
                    max = Math.min(((this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight()) - 1, i);
                } else {
                    max = Math.max(-(((this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight()) - 1), i);
                }
                this.a.q(-max);
                if (computeScrollOffset) {
                    this.a.v = currX;
                    this.a.post(this);
                    return;
                }
                this.a.k.forceFinished(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DragHorizonScrollView a;

        public b(DragHorizonScrollView dragHorizonScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dragHorizonScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dragHorizonScrollView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.y = false;
                int childCount = this.a.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.a.getChildAt(i) != null) {
                        this.a.getChildAt(i).clearAnimation();
                    }
                }
                if (this.a.j()) {
                    if (this.a.getScrollX() > this.a.k()) {
                        DragHorizonScrollView dragHorizonScrollView = this.a;
                        dragHorizonScrollView.scrollTo(dragHorizonScrollView.k(), 0);
                    }
                } else {
                    this.a.scrollTo(0, 0);
                }
                if (this.a.z) {
                    this.a.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragHorizonScrollView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        new Rect();
        this.s = 10;
        this.x = new ArrayList<>();
        this.B = false;
        this.C = true;
        this.D = new a(this);
        l(context);
    }

    @Override // android.view.View
    public void computeScroll() {
        rl8 rl8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.j.computeScrollOffset()) {
                scrollTo(this.j.getCurrX(), 0);
                postInvalidateDelayed(16L);
                if ((this.o || this.p) && (rl8Var = this.c) != null) {
                    rl8Var.d();
                    return;
                }
                return;
            }
            this.o = false;
            this.p = false;
        }
    }

    public int delete(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            this.y = true;
            view2.clearAnimation();
            int indexOfChild = indexOfChild(view2);
            if (indexOfChild == -1) {
                return indexOfChild;
            }
            int measuredWidth = view2.getMeasuredWidth();
            if (this.w) {
                this.g -= measuredWidth;
            } else {
                View view3 = this.u;
                if (view3 != null) {
                    addViewInLayout(view3, -1, view3.getLayoutParams(), true);
                    this.g += this.u.getMeasuredWidth();
                }
                this.g -= measuredWidth;
                this.w = true;
            }
            this.d--;
            removeViewInLayout(view2);
            this.x.add(view2);
            int childCount = getChildCount();
            if (childCount > 1) {
                for (int i = indexOfChild; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    if (childAt != null) {
                        childAt.offsetLeftAndRight(-measuredWidth);
                        TranslateAnimation translateAnimation = new TranslateAnimation(measuredWidth, 0.0f, 0.0f, 0.0f);
                        translateAnimation.setDuration(500L);
                        translateAnimation.setFillAfter(true);
                        childAt.startAnimation(translateAnimation);
                    }
                }
            }
            int scrollX = getScrollX();
            if (!j()) {
                this.j.startScroll(scrollX, 0, 0 - scrollX, 0, 500);
                postInvalidate();
            } else if (scrollX > k()) {
                this.j.startScroll(scrollX, 0, k() - scrollX, 0, 500);
                postInvalidate();
            }
            postDelayed(new b(this), 500L);
            return indexOfChild;
        }
        return invokeL.intValue;
    }

    public BaseAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (BaseAdapter) invokeV.objValue;
    }

    public int getMaxItemNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.s : invokeV.intValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g > getMeasuredWidth() : invokeV.booleanValue;
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (j()) {
                return this.g - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.b = null;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.i = viewConfiguration.getScaledTouchSlop();
            this.m = viewConfiguration.getScaledMinimumFlingVelocity();
            this.n = viewConfiguration.getScaledMaximumFlingVelocity();
            this.j = new Scroller(context, new LinearInterpolator());
            this.k = new Scroller(context);
            this.q = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702ee);
            this.r = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207);
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.y : invokeV.booleanValue;
    }

    public final void n(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, i, i2) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-2, -2);
                view2.setLayoutParams(layoutParams);
            }
            view2.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), layoutParams.height));
        }
    }

    public final int[] o(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048585, this, i, i2, i3, i4)) == null) {
            int[] iArr = new int[2];
            if (this.a == null) {
                iArr[0] = getPaddingLeft() + getPaddingRight();
                iArr[1] = getPaddingTop() + getPaddingBottom();
                return iArr;
            }
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (i2 == -1) {
                i2 = this.d - 1;
            }
            while (i <= i2) {
                View p = p(i);
                if (p.getVisibility() != 8) {
                    n(p, i3, i4);
                    paddingLeft += p.getMeasuredWidth();
                    paddingTop = Math.max(p.getMeasuredHeight(), paddingTop);
                }
                i++;
            }
            iArr[0] = paddingLeft;
            iArr[1] = paddingTop;
            return iArr;
        }
        return (int[]) invokeIIII.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDetachedFromWindow();
            s();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (j()) {
                if (this.l == null) {
                    this.l = VelocityTracker.obtain();
                }
                this.l.addMovement(motionEvent);
                float x = motionEvent.getX();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            int abs = (int) Math.abs(x - this.h);
                            this.h = x;
                            if (abs > this.i) {
                                if (getParent() != null) {
                                    getParent().requestDisallowInterceptTouchEvent(true);
                                }
                                return true;
                            }
                            return false;
                        } else if (action != 3) {
                            return false;
                        }
                    }
                    VelocityTracker velocityTracker = this.l;
                    if (velocityTracker != null) {
                        velocityTracker.recycle();
                        this.l = null;
                        return false;
                    }
                    return false;
                }
                this.h = x;
                if (this.k.isFinished()) {
                    return false;
                }
                removeCallbacks(this.D);
                this.k.forceFinished(true);
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != this.u) {
                    this.x.add(childAt);
                }
            }
            removeAllViewsInLayout();
            int paddingLeft = getPaddingLeft() + this.q;
            if (this.B) {
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207);
                if (this.d > 0) {
                    View p = p(0);
                    n(p, this.e, this.f);
                    paddingLeft = ((getMeasuredWidth() - p.getMeasuredWidth()) + dimensionPixelSize) / 2;
                } else if (this.u != null) {
                    int measuredWidth = ((getMeasuredWidth() - (this.q * 2)) + this.r) / 3;
                    ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                    }
                    layoutParams.width = measuredWidth;
                    layoutParams.height = -1;
                    this.u.setLayoutParams(layoutParams);
                    n(this.u, this.e, this.f);
                    paddingLeft = ((getMeasuredWidth() - this.u.getMeasuredWidth()) + dimensionPixelSize) / 2;
                }
            }
            for (int i6 = 0; i6 < this.d; i6++) {
                View p2 = p(i6);
                if (p2 != null && p2.getVisibility() != 8) {
                    ViewGroup.LayoutParams layoutParams2 = p2.getLayoutParams();
                    if (layoutParams2 == null) {
                        layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                        p2.setLayoutParams(layoutParams2);
                    }
                    addViewInLayout(p2, -1, layoutParams2, true);
                    n(p2, this.e, this.f);
                    int paddingTop = getPaddingTop();
                    int measuredWidth2 = p2.getMeasuredWidth() + paddingLeft;
                    p2.layout(paddingLeft, paddingTop, measuredWidth2, p2.getMeasuredHeight() + paddingTop);
                    p2.setDrawingCacheEnabled(false);
                    paddingLeft = measuredWidth2;
                }
            }
            if (this.u != null) {
                if (this.C) {
                    int measuredWidth3 = ((getMeasuredWidth() - (this.q * 2)) + this.r) / 3;
                    ViewGroup.LayoutParams layoutParams3 = this.u.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
                    }
                    layoutParams3.width = measuredWidth3;
                    layoutParams3.height = -1;
                    this.u.setLayoutParams(layoutParams3);
                }
                n(this.u, this.e, this.f);
                int paddingTop2 = getPaddingTop();
                int measuredWidth4 = this.u.getMeasuredWidth() + paddingLeft;
                this.u.layout(paddingLeft, paddingTop2, measuredWidth4, this.u.getMeasuredHeight() + paddingTop2);
                if (this.d == this.s) {
                    paddingLeft = measuredWidth4 - this.u.getMeasuredWidth();
                    this.w = false;
                } else {
                    View view2 = this.u;
                    addViewInLayout(view2, -1, view2.getLayoutParams(), true);
                    this.w = true;
                    paddingLeft = measuredWidth4;
                }
            }
            this.g = (paddingLeft + this.q) - this.r;
            if (this.t || z) {
                scrollTo(0, 0);
                scrollBy(k(), 0);
                this.t = false;
            }
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, view2)) == null) {
            if (this.A) {
                return true;
            }
            this.A = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i) != null) {
                    getChildAt(i).clearAnimation();
                }
            }
            this.c.c(view2, null);
            this.b = view2;
            indexOfChild(view2);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i, i2) == null) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            BaseAdapter baseAdapter = this.a;
            int count = baseAdapter == null ? 0 : baseAdapter.getCount();
            this.d = count;
            int min = Math.min(this.s, count);
            this.d = min;
            if (min <= 0 || !(mode == 0 || mode2 == 0)) {
                i3 = 0;
                i4 = 0;
            } else {
                View p = p(0);
                n(p, i, i2);
                i4 = p.getMeasuredWidth();
                i3 = p.getMeasuredHeight();
            }
            if (mode == 0) {
                size = getPaddingLeft() + getPaddingRight() + i4;
            }
            if (mode2 == 0) {
                size2 = getPaddingTop() + getPaddingBottom() + i3;
            }
            if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
                int[] o = o(0, -1, i, i2);
                if (mode == Integer.MIN_VALUE) {
                    size = ViewGroup.resolveSize(o[0], i);
                    this.z = true;
                }
                if (mode2 == Integer.MIN_VALUE) {
                    size2 = ViewGroup.resolveSize(o[1], i2);
                }
            }
            setMeasuredDimension(size, size2);
            this.e = i;
            this.f = i2;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, motionEvent)) == null) {
            if ((motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) && j()) {
                if (this.l == null) {
                    this.l = VelocityTracker.obtain();
                }
                this.l.addMovement(motionEvent);
                int action = motionEvent.getAction();
                float x = motionEvent.getX();
                if (action == 0) {
                    if (!this.k.isFinished()) {
                        removeCallbacks(this.D);
                        this.k.forceFinished(true);
                    }
                    this.h = x;
                } else if (action == 1) {
                    VelocityTracker velocityTracker = this.l;
                    velocityTracker.computeCurrentVelocity(1000, this.n);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.m) {
                        removeCallbacks(this.D);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.v = i2;
                        this.k.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.D);
                    }
                    VelocityTracker velocityTracker2 = this.l;
                    if (velocityTracker2 != null) {
                        velocityTracker2.recycle();
                        this.l = null;
                    }
                } else if (action == 2) {
                    this.h = x;
                    q((int) (this.h - x));
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final View p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            View remove = this.x.size() > 0 ? this.x.remove(0) : null;
            View view2 = this.a.getView(i, remove, this);
            if (view2 != remove) {
                this.x.add(remove);
            }
            if (view2 != null) {
                view2.setOnLongClickListener(this);
            }
            return view2;
        }
        return (View) invokeI.objValue;
    }

    public final void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            scrollBy(r(i), 0);
            invalidate();
        }
    }

    public final int r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            if (i == 0) {
                return 0;
            }
            boolean z = i > 0;
            int scrollX = getScrollX();
            int i2 = scrollX + i;
            return z ? i2 > k() ? k() - scrollX : i : i2 < 0 ? -scrollX : i;
        }
        return invokeI.intValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            removeCallbacks(this.D);
            this.j.forceFinished(true);
            this.k.forceFinished(true);
            View view2 = this.b;
            if (view2 != null) {
                view2.setVisibility(0);
                this.b = null;
            }
            this.o = false;
            this.p = false;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i) != null) {
                    getChildAt(i).clearAnimation();
                }
            }
            this.A = false;
        }
    }

    public void setAdapter(BaseAdapter baseAdapter, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048596, this, baseAdapter, z) == null) {
            this.a = baseAdapter;
            this.j.forceFinished(true);
            this.k.forceFinished(true);
            if (!this.t && z) {
                this.t = z;
            }
            requestLayout();
        }
    }

    public void setAddView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view2) == null) {
            this.u = view2;
        }
    }

    public void setCenterStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.B = z;
        }
    }

    public void setDragController(rl8 rl8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, rl8Var) == null) {
            this.c = rl8Var;
        }
    }

    public void setMaxItemNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.s = i;
        }
    }

    public void setNeedRecomputeAddView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.C = z;
        }
    }

    public void setOnSwapDataListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, cVar) == null) {
        }
    }

    public void setPadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.r = i;
        }
    }

    public void setStartEndSpace(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.q = i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
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
        new Rect();
        this.s = 10;
        this.x = new ArrayList<>();
        this.B = false;
        this.C = true;
        this.D = new a(this);
        l(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        new Rect();
        this.s = 10;
        this.x = new ArrayList<>();
        this.B = false;
        this.C = true;
        this.D = new a(this);
        l(context);
    }
}
