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
import c.a.r0.j3.l0.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class DragHorizonScrollView extends ViewGroup implements d, c.a.r0.j3.l0.c, View.OnLongClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public View B;
    public int C;
    public boolean D;
    public ArrayList<View> E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public Runnable K;

    /* renamed from: e  reason: collision with root package name */
    public BaseAdapter f57206e;

    /* renamed from: f  reason: collision with root package name */
    public View f57207f;

    /* renamed from: g  reason: collision with root package name */
    public int f57208g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.j3.l0.a f57209h;

    /* renamed from: i  reason: collision with root package name */
    public int f57210i;

    /* renamed from: j  reason: collision with root package name */
    public int f57211j;
    public int k;
    public int l;
    public float m;
    public int n;
    public Scroller o;
    public Scroller p;
    public Rect q;
    public VelocityTracker r;
    public int s;
    public int t;
    public boolean u;
    public boolean v;
    public c w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DragHorizonScrollView f57212e;

        public a(DragHorizonScrollView dragHorizonScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dragHorizonScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57212e = dragHorizonScrollView;
        }

        @Override // java.lang.Runnable
        public void run() {
            int max;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f57212e.f57210i == 0) {
                    this.f57212e.p.forceFinished(true);
                    return;
                }
                Scroller scroller = this.f57212e.p;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = this.f57212e.C - currX;
                if (i2 > 0) {
                    max = Math.min(((this.f57212e.getWidth() - this.f57212e.getPaddingLeft()) - this.f57212e.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((this.f57212e.getWidth() - this.f57212e.getPaddingLeft()) - this.f57212e.getPaddingRight()) - 1), i2);
                }
                this.f57212e.p(-max);
                if (computeScrollOffset) {
                    this.f57212e.C = currX;
                    this.f57212e.post(this);
                    return;
                }
                this.f57212e.p.forceFinished(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DragHorizonScrollView f57213e;

        public b(DragHorizonScrollView dragHorizonScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dragHorizonScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57213e = dragHorizonScrollView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57213e.F = false;
                int childCount = this.f57213e.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (this.f57213e.getChildAt(i2) != null) {
                        this.f57213e.getChildAt(i2).clearAnimation();
                    }
                }
                if (this.f57213e.j()) {
                    if (this.f57213e.getScrollX() > this.f57213e.k()) {
                        DragHorizonScrollView dragHorizonScrollView = this.f57213e;
                        dragHorizonScrollView.scrollTo(dragHorizonScrollView.k(), 0);
                    }
                } else {
                    this.f57213e.scrollTo(0, 0);
                }
                if (this.f57213e.G) {
                    this.f57213e.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void onSwapData(int i2, int i3);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = new Rect();
        this.z = 10;
        this.E = new ArrayList<>();
        this.I = false;
        this.J = true;
        this.K = new a(this);
        l(context);
    }

    @Override // android.view.View
    public void computeScroll() {
        c.a.r0.j3.l0.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.o.computeScrollOffset()) {
                scrollTo(this.o.getCurrX(), 0);
                postInvalidateDelayed(16L);
                if ((this.u || this.v) && (aVar = this.f57209h) != null) {
                    aVar.i();
                    return;
                }
                return;
            }
            this.u = false;
            this.v = false;
        }
    }

    public int delete(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
            this.F = true;
            view.clearAnimation();
            int indexOfChild = indexOfChild(view);
            if (indexOfChild == -1) {
                return indexOfChild;
            }
            int measuredWidth = view.getMeasuredWidth();
            if (this.D) {
                this.l -= measuredWidth;
            } else {
                View view2 = this.B;
                if (view2 != null) {
                    addViewInLayout(view2, -1, view2.getLayoutParams(), true);
                    this.l += this.B.getMeasuredWidth();
                }
                this.l -= measuredWidth;
                this.D = true;
            }
            this.f57210i--;
            removeViewInLayout(view);
            this.E.add(view);
            int childCount = getChildCount();
            if (childCount > 1) {
                for (int i2 = indexOfChild; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
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
                this.o.startScroll(scrollX, 0, 0 - scrollX, 0, 500);
                postInvalidate();
            } else if (scrollX > k()) {
                this.o.startScroll(scrollX, 0, k() - scrollX, 0, 500);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f57206e : (BaseAdapter) invokeV.objValue;
    }

    public int getMaxItemNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.z : invokeV.intValue;
    }

    public boolean isCenterStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.I : invokeV.booleanValue;
    }

    public boolean isInDelete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.F : invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l > getMeasuredWidth() : invokeV.booleanValue;
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (j()) {
                return this.l - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            this.f57207f = null;
            this.f57208g = -1;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.n = viewConfiguration.getScaledTouchSlop();
            this.s = viewConfiguration.getScaledMinimumFlingVelocity();
            this.t = viewConfiguration.getScaledMaximumFlingVelocity();
            this.o = new Scroller(context, new LinearInterpolator());
            this.p = new Scroller(context);
            this.x = getResources().getDimensionPixelSize(R.dimen.ds66);
            this.y = getResources().getDimensionPixelSize(R.dimen.ds32);
        }
    }

    public final void m(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, view, i2, i3) == null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-2, -2);
                view.setLayoutParams(layoutParams);
            }
            view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), layoutParams.height));
        }
    }

    @Override // c.a.r0.j3.l0.d
    public void moveLeft() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.u) {
            return;
        }
        this.u = true;
        int scrollX = getScrollX();
        this.o.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
        invalidate();
    }

    @Override // c.a.r0.j3.l0.d
    public void moveRight() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.v) {
            return;
        }
        this.v = true;
        int k = k();
        int scrollX = getScrollX();
        int scrollX2 = k - getScrollX();
        this.o.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
        invalidate();
    }

    public final int[] n(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048588, this, i2, i3, i4, i5)) == null) {
            int[] iArr = new int[2];
            if (this.f57206e == null) {
                iArr[0] = getPaddingLeft() + getPaddingRight();
                iArr[1] = getPaddingTop() + getPaddingBottom();
                return iArr;
            }
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (i3 == -1) {
                i3 = this.f57210i - 1;
            }
            while (i2 <= i3) {
                View o = o(i2);
                if (o.getVisibility() != 8) {
                    m(o, i4, i5);
                    paddingLeft += o.getMeasuredWidth();
                    paddingTop = Math.max(o.getMeasuredHeight(), paddingTop);
                }
                i2++;
            }
            iArr[0] = paddingLeft;
            iArr[1] = paddingTop;
            return iArr;
        }
        return (int[]) invokeIIII.objValue;
    }

    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.o.forceFinished(true);
            this.p.forceFinished(true);
            requestLayout();
        }
    }

    public final View o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            View remove = this.E.size() > 0 ? this.E.remove(0) : null;
            View view = this.f57206e.getView(i2, remove, this);
            if (view != remove) {
                this.E.add(remove);
            }
            if (view != null) {
                view.setOnLongClickListener(this);
            }
            return view;
        }
        return (View) invokeI.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDetachedFromWindow();
            r();
        }
    }

    @Override // c.a.r0.j3.l0.d
    public void onDrop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            r();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (j()) {
                if (this.r == null) {
                    this.r = VelocityTracker.obtain();
                }
                this.r.addMovement(motionEvent);
                float x = motionEvent.getX();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            int abs = (int) Math.abs(x - this.m);
                            this.m = x;
                            if (abs > this.n) {
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
                    VelocityTracker velocityTracker = this.r;
                    if (velocityTracker != null) {
                        velocityTracker.recycle();
                        this.r = null;
                        return false;
                    }
                    return false;
                }
                this.m = x;
                if (this.p.isFinished()) {
                    return false;
                }
                removeCallbacks(this.K);
                this.p.forceFinished(true);
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt != this.B) {
                    this.E.add(childAt);
                }
            }
            removeAllViewsInLayout();
            int paddingLeft = getPaddingLeft() + this.x;
            if (this.I) {
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds32);
                if (this.f57210i > 0) {
                    View o = o(0);
                    m(o, this.f57211j, this.k);
                    paddingLeft = ((getMeasuredWidth() - o.getMeasuredWidth()) + dimensionPixelSize) / 2;
                } else if (this.B != null) {
                    int measuredWidth = ((getMeasuredWidth() - (this.x * 2)) + this.y) / 3;
                    ViewGroup.LayoutParams layoutParams = this.B.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                    }
                    layoutParams.width = measuredWidth;
                    layoutParams.height = -1;
                    this.B.setLayoutParams(layoutParams);
                    m(this.B, this.f57211j, this.k);
                    paddingLeft = ((getMeasuredWidth() - this.B.getMeasuredWidth()) + dimensionPixelSize) / 2;
                }
            }
            for (int i7 = 0; i7 < this.f57210i; i7++) {
                View o2 = o(i7);
                if (o2 != null && o2.getVisibility() != 8) {
                    ViewGroup.LayoutParams layoutParams2 = o2.getLayoutParams();
                    if (layoutParams2 == null) {
                        layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                        o2.setLayoutParams(layoutParams2);
                    }
                    addViewInLayout(o2, -1, layoutParams2, true);
                    m(o2, this.f57211j, this.k);
                    int paddingTop = getPaddingTop();
                    int measuredWidth2 = o2.getMeasuredWidth() + paddingLeft;
                    o2.layout(paddingLeft, paddingTop, measuredWidth2, o2.getMeasuredHeight() + paddingTop);
                    o2.setDrawingCacheEnabled(false);
                    paddingLeft = measuredWidth2;
                }
            }
            if (this.B != null) {
                if (this.J) {
                    int measuredWidth3 = ((getMeasuredWidth() - (this.x * 2)) + this.y) / 3;
                    ViewGroup.LayoutParams layoutParams3 = this.B.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
                    }
                    layoutParams3.width = measuredWidth3;
                    layoutParams3.height = -1;
                    this.B.setLayoutParams(layoutParams3);
                }
                m(this.B, this.f57211j, this.k);
                int paddingTop2 = getPaddingTop();
                int measuredWidth4 = this.B.getMeasuredWidth() + paddingLeft;
                this.B.layout(paddingLeft, paddingTop2, measuredWidth4, this.B.getMeasuredHeight() + paddingTop2);
                if (this.f57210i == this.z) {
                    paddingLeft = measuredWidth4 - this.B.getMeasuredWidth();
                    this.D = false;
                } else {
                    View view = this.B;
                    addViewInLayout(view, -1, view.getLayoutParams(), true);
                    this.D = true;
                    paddingLeft = measuredWidth4;
                }
            }
            this.l = (paddingLeft + this.x) - this.y;
            if (this.A || z) {
                scrollTo(0, 0);
                scrollBy(k(), 0);
                this.A = false;
            }
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, view)) == null) {
            if (this.H) {
                return true;
            }
            this.H = true;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (getChildAt(i2) != null) {
                    getChildAt(i2).clearAnimation();
                }
            }
            this.f57209h.h(view, null);
            this.f57207f = view;
            this.f57208g = indexOfChild(view);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i2, i3) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            BaseAdapter baseAdapter = this.f57206e;
            int count = baseAdapter == null ? 0 : baseAdapter.getCount();
            this.f57210i = count;
            int min = Math.min(this.z, count);
            this.f57210i = min;
            if (min <= 0 || !(mode == 0 || mode2 == 0)) {
                i4 = 0;
                i5 = 0;
            } else {
                View o = o(0);
                m(o, i2, i3);
                i5 = o.getMeasuredWidth();
                i4 = o.getMeasuredHeight();
            }
            if (mode == 0) {
                size = getPaddingLeft() + getPaddingRight() + i5;
            }
            if (mode2 == 0) {
                size2 = getPaddingTop() + getPaddingBottom() + i4;
            }
            if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
                int[] n = n(0, -1, i2, i3);
                if (mode == Integer.MIN_VALUE) {
                    size = ViewGroup.resolveSize(n[0], i2);
                    this.G = true;
                }
                if (mode2 == Integer.MIN_VALUE) {
                    size2 = ViewGroup.resolveSize(n[1], i3);
                }
            }
            setMeasuredDimension(size, size2);
            this.f57211j = i2;
            this.k = i3;
        }
    }

    @Override // c.a.r0.j3.l0.d
    public void onSwap(Rect rect) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, rect) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != this.f57208g && (childAt = getChildAt(i2)) != this.B) {
                    childAt.getHitRect(this.q);
                    if (this.q.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                        int i3 = this.f57208g;
                        t(i3, i2);
                        s(i3, i2);
                        this.f57208g = i2;
                        return;
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, motionEvent)) == null) {
            if ((motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) && j()) {
                if (this.r == null) {
                    this.r = VelocityTracker.obtain();
                }
                this.r.addMovement(motionEvent);
                int action = motionEvent.getAction();
                float x = motionEvent.getX();
                if (action == 0) {
                    if (!this.p.isFinished()) {
                        removeCallbacks(this.K);
                        this.p.forceFinished(true);
                    }
                    this.m = x;
                } else if (action == 1) {
                    VelocityTracker velocityTracker = this.r;
                    velocityTracker.computeCurrentVelocity(1000, this.t);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.s) {
                        removeCallbacks(this.K);
                        int i2 = -xVelocity;
                        int i3 = i2 < 0 ? Integer.MAX_VALUE : 0;
                        this.C = i3;
                        this.p.fling(i3, 0, i2, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.K);
                    }
                    VelocityTracker velocityTracker2 = this.r;
                    if (velocityTracker2 != null) {
                        velocityTracker2.recycle();
                        this.r = null;
                    }
                } else if (action == 2) {
                    this.m = x;
                    p((int) (this.m - x));
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            scrollBy(q(i2), 0);
            invalidate();
        }
    }

    public final int q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            if (i2 == 0) {
                return 0;
            }
            boolean z = i2 > 0;
            int scrollX = getScrollX();
            int i3 = scrollX + i2;
            return z ? i3 > k() ? k() - scrollX : i2 : i3 < 0 ? -scrollX : i2;
        }
        return invokeI.intValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            removeCallbacks(this.K);
            this.o.forceFinished(true);
            this.p.forceFinished(true);
            View view = this.f57207f;
            if (view != null) {
                view.setVisibility(0);
                this.f57207f = null;
            }
            this.f57208g = -1;
            this.u = false;
            this.v = false;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (getChildAt(i2) != null) {
                    getChildAt(i2).clearAnimation();
                }
            }
            this.H = false;
        }
    }

    public final void s(int i2, int i3) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048602, this, i2, i3) == null) || (cVar = this.w) == null) {
            return;
        }
        cVar.onSwapData(i2, i3);
    }

    public void setAdapter(BaseAdapter baseAdapter, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048603, this, baseAdapter, z) == null) {
            this.f57206e = baseAdapter;
            this.o.forceFinished(true);
            this.p.forceFinished(true);
            if (!this.A && z) {
                this.A = z;
            }
            requestLayout();
        }
    }

    public void setAddView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, view) == null) {
            this.B = view;
        }
    }

    public void setCenterStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.I = z;
        }
    }

    @Override // c.a.r0.j3.l0.c
    public void setDragController(c.a.r0.j3.l0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, aVar) == null) {
            this.f57209h = aVar;
        }
    }

    public void setMaxItemNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.z = i2;
        }
    }

    public void setNeedRecomputeAddView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.J = z;
        }
    }

    public void setOnSwapDataListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, cVar) == null) {
            this.w = cVar;
        }
    }

    public void setPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.y = i2;
        }
    }

    public void setStartEndSpace(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.x = i2;
        }
    }

    @Override // c.a.r0.j3.l0.d
    public void stopMove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            if (!this.o.isFinished()) {
                this.o.forceFinished(true);
            }
            this.u = false;
            this.v = false;
        }
    }

    public final void t(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048613, this, i2, i3) == null) || i2 == i3) {
            return;
        }
        View childAt = getChildAt(i2);
        View childAt2 = getChildAt(i3);
        if (childAt == null || childAt2 == null) {
            return;
        }
        if (i2 < i3) {
            detachViewFromParent(i2);
            int i4 = -childAt.getMeasuredWidth();
            int left = childAt2.getLeft() - childAt.getLeft();
            while (i2 < i3) {
                View childAt3 = getChildAt(i2);
                if (childAt3 != null) {
                    childAt3.offsetLeftAndRight(i4);
                    TranslateAnimation translateAnimation = new TranslateAnimation(-i4, 0.0f, 0.0f, 0.0f);
                    translateAnimation.setDuration(300L);
                    translateAnimation.setFillAfter(true);
                    childAt3.startAnimation(translateAnimation);
                }
                i2++;
            }
            attachViewToParent(childAt, i3, childAt.getLayoutParams());
            childAt.offsetLeftAndRight(left);
            return;
        }
        detachViewFromParent(i2);
        int measuredWidth = childAt.getMeasuredWidth();
        int left2 = childAt2.getLeft() - childAt.getLeft();
        for (int i5 = i3; i5 < i2; i5++) {
            View childAt4 = getChildAt(i5);
            if (childAt4 != null) {
                childAt4.offsetLeftAndRight(measuredWidth);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(-measuredWidth, 0.0f, 0.0f, 0.0f);
                translateAnimation2.setDuration(300L);
                translateAnimation2.setFillAfter(true);
                childAt4.startAnimation(translateAnimation2);
            }
        }
        attachViewToParent(childAt, i3, childAt.getLayoutParams());
        childAt.offsetLeftAndRight(left2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i2) {
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
        this.q = new Rect();
        this.z = 10;
        this.E = new ArrayList<>();
        this.I = false;
        this.J = true;
        this.K = new a(this);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = new Rect();
        this.z = 10;
        this.E = new ArrayList<>();
        this.I = false;
        this.J = true;
        this.K = new a(this);
        l(context);
    }
}
