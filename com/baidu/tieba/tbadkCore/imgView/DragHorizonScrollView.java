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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fl8;
import com.repackage.hl8;
import com.repackage.il8;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class DragHorizonScrollView extends ViewGroup implements il8, hl8, View.OnLongClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<View> A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public Runnable G;
    public BaseAdapter a;
    public View b;
    public int c;
    public fl8 d;
    public int e;
    public int f;
    public int g;
    public int h;
    public float i;
    public int j;
    public Scroller k;
    public Scroller l;
    public Rect m;
    public VelocityTracker n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public c s;
    public int t;
    public int u;
    public int v;
    public boolean w;
    public View x;
    public int y;
    public boolean z;

    /* loaded from: classes4.dex */
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
                if (this.a.e == 0) {
                    this.a.l.forceFinished(true);
                    return;
                }
                Scroller scroller = this.a.l;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i = this.a.y - currX;
                if (i > 0) {
                    max = Math.min(((this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight()) - 1, i);
                } else {
                    max = Math.max(-(((this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight()) - 1), i);
                }
                this.a.v(-max);
                if (computeScrollOffset) {
                    this.a.y = currX;
                    this.a.post(this);
                    return;
                }
                this.a.l.forceFinished(true);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.B = false;
                int childCount = this.a.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.a.getChildAt(i) != null) {
                        this.a.getChildAt(i).clearAnimation();
                    }
                }
                if (this.a.o()) {
                    if (this.a.getScrollX() > this.a.p()) {
                        DragHorizonScrollView dragHorizonScrollView = this.a;
                        dragHorizonScrollView.scrollTo(dragHorizonScrollView.p(), 0);
                    }
                } else {
                    this.a.scrollTo(0, 0);
                }
                if (this.a.C) {
                    this.a.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(int i, int i2);
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
        this.m = new Rect();
        this.v = 10;
        this.A = new ArrayList<>();
        this.E = false;
        this.F = true;
        this.G = new a(this);
        q(context);
    }

    @Override // com.repackage.il8
    public void a(Rect rect) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rect) == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (i != this.c && (childAt = getChildAt(i)) != this.x) {
                    childAt.getHitRect(this.m);
                    if (this.m.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                        int i2 = this.c;
                        z(i2, i);
                        y(i2, i);
                        this.c = i;
                        return;
                    }
                }
            }
        }
    }

    @Override // com.repackage.il8
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.q) {
            return;
        }
        this.q = true;
        int scrollX = getScrollX();
        this.k.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
        invalidate();
    }

    @Override // com.repackage.il8
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!this.k.isFinished()) {
                this.k.forceFinished(true);
            }
            this.q = false;
            this.r = false;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        fl8 fl8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.k.computeScrollOffset()) {
                scrollTo(this.k.getCurrX(), 0);
                postInvalidateDelayed(16L);
                if ((this.q || this.r) && (fl8Var = this.d) != null) {
                    fl8Var.i();
                    return;
                }
                return;
            }
            this.q = false;
            this.r = false;
        }
    }

    @Override // com.repackage.il8
    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.r) {
            return;
        }
        this.r = true;
        int p = p();
        int scrollX = getScrollX();
        int scrollX2 = p - getScrollX();
        this.k.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
        invalidate();
    }

    public int delete(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) {
            this.B = true;
            view2.clearAnimation();
            int indexOfChild = indexOfChild(view2);
            if (indexOfChild == -1) {
                return indexOfChild;
            }
            int measuredWidth = view2.getMeasuredWidth();
            if (this.z) {
                this.h -= measuredWidth;
            } else {
                View view3 = this.x;
                if (view3 != null) {
                    addViewInLayout(view3, -1, view3.getLayoutParams(), true);
                    this.h += this.x.getMeasuredWidth();
                }
                this.h -= measuredWidth;
                this.z = true;
            }
            this.e--;
            removeViewInLayout(view2);
            this.A.add(view2);
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
            if (!o()) {
                this.k.startScroll(scrollX, 0, 0 - scrollX, 0, 500);
                postInvalidate();
            } else if (scrollX > p()) {
                this.k.startScroll(scrollX, 0, p() - scrollX, 0, 500);
                postInvalidate();
            }
            postDelayed(new b(this), 500L);
            return indexOfChild;
        }
        return invokeL.intValue;
    }

    @Override // com.repackage.il8
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            x();
        }
    }

    public BaseAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (BaseAdapter) invokeV.objValue;
    }

    public int getMaxItemNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.v : invokeV.intValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.h > getMeasuredWidth() : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDetachedFromWindow();
            x();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (o()) {
                if (this.n == null) {
                    this.n = VelocityTracker.obtain();
                }
                this.n.addMovement(motionEvent);
                float x = motionEvent.getX();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            int abs = (int) Math.abs(x - this.i);
                            this.i = x;
                            if (abs > this.j) {
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
                    VelocityTracker velocityTracker = this.n;
                    if (velocityTracker != null) {
                        velocityTracker.recycle();
                        this.n = null;
                        return false;
                    }
                    return false;
                }
                this.i = x;
                if (this.l.isFinished()) {
                    return false;
                }
                removeCallbacks(this.G);
                this.l.forceFinished(true);
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
                if (childAt != this.x) {
                    this.A.add(childAt);
                }
            }
            removeAllViewsInLayout();
            int paddingLeft = getPaddingLeft() + this.t;
            if (this.E) {
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207);
                if (this.e > 0) {
                    View u = u(0);
                    s(u, this.f, this.g);
                    paddingLeft = ((getMeasuredWidth() - u.getMeasuredWidth()) + dimensionPixelSize) / 2;
                } else if (this.x != null) {
                    int measuredWidth = ((getMeasuredWidth() - (this.t * 2)) + this.u) / 3;
                    ViewGroup.LayoutParams layoutParams = this.x.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                    }
                    layoutParams.width = measuredWidth;
                    layoutParams.height = -1;
                    this.x.setLayoutParams(layoutParams);
                    s(this.x, this.f, this.g);
                    paddingLeft = ((getMeasuredWidth() - this.x.getMeasuredWidth()) + dimensionPixelSize) / 2;
                }
            }
            for (int i6 = 0; i6 < this.e; i6++) {
                View u2 = u(i6);
                if (u2 != null && u2.getVisibility() != 8) {
                    ViewGroup.LayoutParams layoutParams2 = u2.getLayoutParams();
                    if (layoutParams2 == null) {
                        layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                        u2.setLayoutParams(layoutParams2);
                    }
                    addViewInLayout(u2, -1, layoutParams2, true);
                    s(u2, this.f, this.g);
                    int paddingTop = getPaddingTop();
                    int measuredWidth2 = u2.getMeasuredWidth() + paddingLeft;
                    u2.layout(paddingLeft, paddingTop, measuredWidth2, u2.getMeasuredHeight() + paddingTop);
                    u2.setDrawingCacheEnabled(false);
                    paddingLeft = measuredWidth2;
                }
            }
            if (this.x != null) {
                if (this.F) {
                    int measuredWidth3 = ((getMeasuredWidth() - (this.t * 2)) + this.u) / 3;
                    ViewGroup.LayoutParams layoutParams3 = this.x.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
                    }
                    layoutParams3.width = measuredWidth3;
                    layoutParams3.height = -1;
                    this.x.setLayoutParams(layoutParams3);
                }
                s(this.x, this.f, this.g);
                int paddingTop2 = getPaddingTop();
                int measuredWidth4 = this.x.getMeasuredWidth() + paddingLeft;
                this.x.layout(paddingLeft, paddingTop2, measuredWidth4, this.x.getMeasuredHeight() + paddingTop2);
                if (this.e == this.v) {
                    paddingLeft = measuredWidth4 - this.x.getMeasuredWidth();
                    this.z = false;
                } else {
                    View view2 = this.x;
                    addViewInLayout(view2, -1, view2.getLayoutParams(), true);
                    this.z = true;
                    paddingLeft = measuredWidth4;
                }
            }
            this.h = (paddingLeft + this.t) - this.u;
            if (this.w || z) {
                scrollTo(0, 0);
                scrollBy(p(), 0);
                this.w = false;
            }
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, view2)) == null) {
            if (this.D) {
                return true;
            }
            this.D = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i) != null) {
                    getChildAt(i).clearAnimation();
                }
            }
            this.d.h(view2, null);
            this.b = view2;
            this.c = indexOfChild(view2);
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
            this.e = count;
            int min = Math.min(this.v, count);
            this.e = min;
            if (min <= 0 || !(mode == 0 || mode2 == 0)) {
                i3 = 0;
                i4 = 0;
            } else {
                View u = u(0);
                s(u, i, i2);
                i4 = u.getMeasuredWidth();
                i3 = u.getMeasuredHeight();
            }
            if (mode == 0) {
                size = getPaddingLeft() + getPaddingRight() + i4;
            }
            if (mode2 == 0) {
                size2 = getPaddingTop() + getPaddingBottom() + i3;
            }
            if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
                int[] t = t(0, -1, i, i2);
                if (mode == Integer.MIN_VALUE) {
                    size = ViewGroup.resolveSize(t[0], i);
                    this.C = true;
                }
                if (mode2 == Integer.MIN_VALUE) {
                    size2 = ViewGroup.resolveSize(t[1], i2);
                }
            }
            setMeasuredDimension(size, size2);
            this.f = i;
            this.g = i2;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, motionEvent)) == null) {
            if ((motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) && o()) {
                if (this.n == null) {
                    this.n = VelocityTracker.obtain();
                }
                this.n.addMovement(motionEvent);
                int action = motionEvent.getAction();
                float x = motionEvent.getX();
                if (action == 0) {
                    if (!this.l.isFinished()) {
                        removeCallbacks(this.G);
                        this.l.forceFinished(true);
                    }
                    this.i = x;
                } else if (action == 1) {
                    VelocityTracker velocityTracker = this.n;
                    velocityTracker.computeCurrentVelocity(1000, this.p);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.o) {
                        removeCallbacks(this.G);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.y = i2;
                        this.l.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.G);
                    }
                    VelocityTracker velocityTracker2 = this.n;
                    if (velocityTracker2 != null) {
                        velocityTracker2.recycle();
                        this.n = null;
                    }
                } else if (action == 2) {
                    this.i = x;
                    v((int) (this.i - x));
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (o()) {
                return this.h - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, context) == null) {
            this.b = null;
            this.c = -1;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.j = viewConfiguration.getScaledTouchSlop();
            this.o = viewConfiguration.getScaledMinimumFlingVelocity();
            this.p = viewConfiguration.getScaledMaximumFlingVelocity();
            this.k = new Scroller(context, new LinearInterpolator());
            this.l = new Scroller(context);
            this.t = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702f1);
            this.u = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207);
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public final void s(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048595, this, view2, i, i2) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-2, -2);
                view2.setLayoutParams(layoutParams);
            }
            view2.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), layoutParams.height));
        }
    }

    public void setAdapter(BaseAdapter baseAdapter, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048596, this, baseAdapter, z) == null) {
            this.a = baseAdapter;
            this.k.forceFinished(true);
            this.l.forceFinished(true);
            if (!this.w && z) {
                this.w = z;
            }
            requestLayout();
        }
    }

    public void setAddView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view2) == null) {
            this.x = view2;
        }
    }

    public void setCenterStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.E = z;
        }
    }

    @Override // com.repackage.hl8
    public void setDragController(fl8 fl8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, fl8Var) == null) {
            this.d = fl8Var;
        }
    }

    public void setMaxItemNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.v = i;
        }
    }

    public void setNeedRecomputeAddView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.F = z;
        }
    }

    public void setOnSwapDataListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, cVar) == null) {
            this.s = cVar;
        }
    }

    public void setPadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.u = i;
        }
    }

    public void setStartEndSpace(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.t = i;
        }
    }

    public final int[] t(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048605, this, i, i2, i3, i4)) == null) {
            int[] iArr = new int[2];
            if (this.a == null) {
                iArr[0] = getPaddingLeft() + getPaddingRight();
                iArr[1] = getPaddingTop() + getPaddingBottom();
                return iArr;
            }
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (i2 == -1) {
                i2 = this.e - 1;
            }
            while (i <= i2) {
                View u = u(i);
                if (u.getVisibility() != 8) {
                    s(u, i3, i4);
                    paddingLeft += u.getMeasuredWidth();
                    paddingTop = Math.max(u.getMeasuredHeight(), paddingTop);
                }
                i++;
            }
            iArr[0] = paddingLeft;
            iArr[1] = paddingTop;
            return iArr;
        }
        return (int[]) invokeIIII.objValue;
    }

    public final View u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i)) == null) {
            View remove = this.A.size() > 0 ? this.A.remove(0) : null;
            View view2 = this.a.getView(i, remove, this);
            if (view2 != remove) {
                this.A.add(remove);
            }
            if (view2 != null) {
                view2.setOnLongClickListener(this);
            }
            return view2;
        }
        return (View) invokeI.objValue;
    }

    public final void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            scrollBy(w(i), 0);
            invalidate();
        }
    }

    public final int w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i)) == null) {
            if (i == 0) {
                return 0;
            }
            boolean z = i > 0;
            int scrollX = getScrollX();
            int i2 = scrollX + i;
            return z ? i2 > p() ? p() - scrollX : i : i2 < 0 ? -scrollX : i;
        }
        return invokeI.intValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            removeCallbacks(this.G);
            this.k.forceFinished(true);
            this.l.forceFinished(true);
            View view2 = this.b;
            if (view2 != null) {
                view2.setVisibility(0);
                this.b = null;
            }
            this.c = -1;
            this.q = false;
            this.r = false;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i) != null) {
                    getChildAt(i).clearAnimation();
                }
            }
            this.D = false;
        }
    }

    public final void y(int i, int i2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048610, this, i, i2) == null) || (cVar = this.s) == null) {
            return;
        }
        cVar.a(i, i2);
    }

    public final void z(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048611, this, i, i2) == null) || i == i2) {
            return;
        }
        View childAt = getChildAt(i);
        View childAt2 = getChildAt(i2);
        if (childAt == null || childAt2 == null) {
            return;
        }
        if (i < i2) {
            detachViewFromParent(i);
            int i3 = -childAt.getMeasuredWidth();
            int left = childAt2.getLeft() - childAt.getLeft();
            while (i < i2) {
                View childAt3 = getChildAt(i);
                if (childAt3 != null) {
                    childAt3.offsetLeftAndRight(i3);
                    TranslateAnimation translateAnimation = new TranslateAnimation(-i3, 0.0f, 0.0f, 0.0f);
                    translateAnimation.setDuration(300L);
                    translateAnimation.setFillAfter(true);
                    childAt3.startAnimation(translateAnimation);
                }
                i++;
            }
            attachViewToParent(childAt, i2, childAt.getLayoutParams());
            childAt.offsetLeftAndRight(left);
            return;
        }
        detachViewFromParent(i);
        int measuredWidth = childAt.getMeasuredWidth();
        int left2 = childAt2.getLeft() - childAt.getLeft();
        for (int i4 = i2; i4 < i; i4++) {
            View childAt4 = getChildAt(i4);
            if (childAt4 != null) {
                childAt4.offsetLeftAndRight(measuredWidth);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(-measuredWidth, 0.0f, 0.0f, 0.0f);
                translateAnimation2.setDuration(300L);
                translateAnimation2.setFillAfter(true);
                childAt4.startAnimation(translateAnimation2);
            }
        }
        attachViewToParent(childAt, i2, childAt.getLayoutParams());
        childAt.offsetLeftAndRight(left2);
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
        this.m = new Rect();
        this.v = 10;
        this.A = new ArrayList<>();
        this.E = false;
        this.F = true;
        this.G = new a(this);
        q(context);
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
        this.m = new Rect();
        this.v = 10;
        this.A = new ArrayList<>();
        this.E = false;
        this.F = true;
        this.G = new a(this);
        q(context);
    }
}
