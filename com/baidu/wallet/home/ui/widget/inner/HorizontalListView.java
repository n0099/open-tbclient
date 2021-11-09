package com.baidu.wallet.home.ui.widget.inner;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.EdgeEffectCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes10.dex */
public class HorizontalListView extends AdapterView<ListAdapter> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable A;

    /* renamed from: a  reason: collision with root package name */
    public final a f58461a;

    /* renamed from: b  reason: collision with root package name */
    public GestureDetector f58462b;

    /* renamed from: c  reason: collision with root package name */
    public int f58463c;

    /* renamed from: d  reason: collision with root package name */
    public List<Queue<View>> f58464d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58465e;

    /* renamed from: f  reason: collision with root package name */
    public Rect f58466f;

    /* renamed from: g  reason: collision with root package name */
    public View f58467g;

    /* renamed from: h  reason: collision with root package name */
    public int f58468h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f58469i;
    public Integer j;
    public int k;
    public int l;
    public int m;
    public ListAdapter mAdapter;
    public int mCurrentX;
    public Scroller mFlingTracker;
    public int mNextX;
    public int n;
    public d o;
    public int p;
    public boolean q;
    public OnScrollStateChangedListener r;
    public OnScrollStateChangedListener.ScrollState s;
    public EdgeEffectCompat t;
    public EdgeEffectCompat u;
    public int v;
    public boolean w;
    public boolean x;
    public View.OnClickListener y;
    public DataSetObserver z;

    /* loaded from: classes10.dex */
    public interface OnScrollStateChangedListener {

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes10.dex */
        public static final class ScrollState {
            public static final /* synthetic */ ScrollState[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final ScrollState SCROLL_STATE_FLING;
            public static final ScrollState SCROLL_STATE_IDLE;
            public static final ScrollState SCROLL_STATE_TOUCH_SCROLL;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1334833492, "Lcom/baidu/wallet/home/ui/widget/inner/HorizontalListView$OnScrollStateChangedListener$ScrollState;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-1334833492, "Lcom/baidu/wallet/home/ui/widget/inner/HorizontalListView$OnScrollStateChangedListener$ScrollState;");
                        return;
                    }
                }
                SCROLL_STATE_IDLE = new ScrollState("SCROLL_STATE_IDLE", 0);
                SCROLL_STATE_TOUCH_SCROLL = new ScrollState("SCROLL_STATE_TOUCH_SCROLL", 1);
                ScrollState scrollState = new ScrollState("SCROLL_STATE_FLING", 2);
                SCROLL_STATE_FLING = scrollState;
                $VALUES = new ScrollState[]{SCROLL_STATE_IDLE, SCROLL_STATE_TOUCH_SCROLL, scrollState};
            }

            public ScrollState(String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public static ScrollState valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ScrollState) Enum.valueOf(ScrollState.class, str) : (ScrollState) invokeL.objValue;
            }

            public static ScrollState[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ScrollState[]) $VALUES.clone() : (ScrollState[]) invokeV.objValue;
            }
        }

        void a(ScrollState scrollState);
    }

    /* loaded from: classes10.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HorizontalListView f58473a;

        public a(HorizontalListView horizontalListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58473a = horizontalListView;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) ? this.f58473a.onDown(motionEvent) : invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.f58473a.onFling(motionEvent, motionEvent2, f2, f3) : invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent) == null) {
                this.f58473a.f();
                int c2 = this.f58473a.c((int) motionEvent.getX(), (int) motionEvent.getY());
                if (c2 < 0 || this.f58473a.w) {
                    return;
                }
                View childAt = this.f58473a.getChildAt(c2);
                AdapterView.OnItemLongClickListener onItemLongClickListener = this.f58473a.getOnItemLongClickListener();
                if (onItemLongClickListener != null) {
                    int i2 = this.f58473a.l + c2;
                    HorizontalListView horizontalListView = this.f58473a;
                    if (onItemLongClickListener.onItemLongClick(horizontalListView, childAt, i2, horizontalListView.mAdapter.getItemId(i2))) {
                        this.f58473a.performHapticFeedback(0);
                    }
                }
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                this.f58473a.a(Boolean.TRUE);
                this.f58473a.setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_TOUCH_SCROLL);
                this.f58473a.f();
                HorizontalListView horizontalListView = this.f58473a;
                horizontalListView.mNextX += (int) f2;
                horizontalListView.i(Math.round(f2));
                this.f58473a.requestLayout();
                return true;
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
                this.f58473a.f();
                AdapterView.OnItemClickListener onItemClickListener = this.f58473a.getOnItemClickListener();
                int c2 = this.f58473a.c((int) motionEvent.getX(), (int) motionEvent.getY());
                if (c2 >= 0 && !this.f58473a.w) {
                    View childAt = this.f58473a.getChildAt(c2);
                    int i2 = this.f58473a.l + c2;
                    if (onItemClickListener != null) {
                        HorizontalListView horizontalListView = this.f58473a;
                        onItemClickListener.onItemClick(horizontalListView, childAt, i2, horizontalListView.mAdapter.getItemId(i2));
                        return true;
                    }
                }
                if (this.f58473a.y == null || this.f58473a.w) {
                    return false;
                }
                this.f58473a.y.onClick(this.f58473a);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    @TargetApi(11)
    /* loaded from: classes10.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1148322939, "Lcom/baidu/wallet/home/ui/widget/inner/HorizontalListView$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1148322939, "Lcom/baidu/wallet/home/ui/widget/inner/HorizontalListView$b;");
                    return;
                }
            }
            if (Build.VERSION.SDK_INT < 11) {
                throw new RuntimeException("Should not get to HoneycombPlus class unless sdk is >= 11!");
            }
        }

        public static void a(Scroller scroller, float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLF(65537, null, scroller, f2) == null) || scroller == null) {
                return;
            }
            scroller.setFriction(f2);
        }
    }

    @TargetApi(14)
    /* loaded from: classes10.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1148322908, "Lcom/baidu/wallet/home/ui/widget/inner/HorizontalListView$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1148322908, "Lcom/baidu/wallet/home/ui/widget/inner/HorizontalListView$c;");
                    return;
                }
            }
            if (Build.VERSION.SDK_INT < 14) {
                throw new RuntimeException("Should not get to IceCreamSandwichPlus class unless sdk is >= 14!");
            }
        }

        public static float a(Scroller scroller) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, scroller)) == null) ? scroller.getCurrVelocity() : invokeL.floatValue;
        }
    }

    /* loaded from: classes10.dex */
    public interface d {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFlingTracker = new Scroller(getContext());
        this.f58461a = new a();
        this.f58464d = new ArrayList();
        this.f58465e = false;
        this.f58466f = new Rect();
        this.f58467g = null;
        this.f58468h = 0;
        this.f58469i = null;
        this.j = null;
        this.k = Integer.MAX_VALUE;
        this.o = null;
        this.p = 0;
        this.q = false;
        this.r = null;
        this.s = OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE;
        this.w = false;
        this.x = false;
        this.z = new DataSetObserver(this) { // from class: com.baidu.wallet.home.ui.widget.inner.HorizontalListView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ HorizontalListView f58471a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f58471a = this;
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f58471a.f58465e = true;
                    this.f58471a.q = false;
                    this.f58471a.f();
                    this.f58471a.invalidate();
                    this.f58471a.requestLayout();
                }
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f58471a.q = false;
                    this.f58471a.f();
                    this.f58471a.c();
                    this.f58471a.invalidate();
                    this.f58471a.requestLayout();
                }
            }
        };
        this.A = new Runnable(this) { // from class: com.baidu.wallet.home.ui.widget.inner.HorizontalListView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ HorizontalListView f58472a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f58472a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f58472a.requestLayout();
                }
            }
        };
        this.t = new EdgeEffectCompat(context);
        this.u = new EdgeEffectCompat(context);
        this.f58462b = new GestureDetector(context, this.f58461a);
        a();
        b();
        setWillNotDraw(false);
        b.a(this.mFlingTracker, 0.009f);
    }

    private View g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65572, this, i2)) == null) {
            int i3 = this.l;
            if (i2 < i3 || i2 > this.m) {
                return null;
            }
            return getChildAt(i2 - i3);
        }
        return (View) invokeI.objValue;
    }

    private View getLeftmostChild() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65574, this)) == null) ? getChildAt(0) : (View) invokeV.objValue;
    }

    private int getRenderHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, this)) == null) ? (getHeight() - getPaddingTop()) - getPaddingBottom() : invokeV.intValue;
    }

    private int getRenderWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65576, this)) == null) ? (getWidth() - getPaddingLeft()) - getPaddingRight() : invokeV.intValue;
    }

    private View getRightmostChild() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65577, this)) == null) ? getChildAt(getChildCount() - 1) : (View) invokeV.objValue;
    }

    private boolean h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65579, this, i2)) == null) ? i2 == this.mAdapter.getCount() - 1 : invokeI.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65580, this, i2) == null) || this.t == null || this.u == null) {
            return;
        }
        int i3 = this.mCurrentX + i2;
        Scroller scroller = this.mFlingTracker;
        if (scroller == null || scroller.isFinished()) {
            if (i3 < 0) {
                this.t.onPull(Math.abs(i2) / getRenderWidth());
                if (this.u.isFinished()) {
                    return;
                }
                this.u.onRelease();
            } else if (i3 > this.k) {
                this.u.onPull(Math.abs(i2) / getRenderWidth());
                if (this.t.isFinished()) {
                    return;
                }
                this.t.onRelease();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentScrollState(OnScrollStateChangedListener.ScrollState scrollState) {
        OnScrollStateChangedListener onScrollStateChangedListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65582, this, scrollState) == null) {
            if (this.s != scrollState && (onScrollStateChangedListener = this.r) != null) {
                onScrollStateChangedListener.a(scrollState);
            }
            this.s = scrollState;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.dispatchDraw(canvas);
            a(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetPressed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
        }
    }

    @Override // android.widget.AdapterView
    public int getFirstVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.l : invokeV.intValue;
    }

    @Override // android.widget.AdapterView
    public int getLastVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m : invokeV.intValue;
    }

    @Override // android.view.View
    public float getLeftFadingEdgeStrength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
            int i2 = this.mCurrentX;
            if (i2 == 0) {
                return 0.0f;
            }
            if (i2 < horizontalFadingEdgeLength) {
                return i2 / horizontalFadingEdgeLength;
            }
            return 1.0f;
        }
        return invokeV.floatValue;
    }

    @Override // android.view.View
    public float getRightFadingEdgeStrength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
            int i2 = this.mCurrentX;
            int i3 = this.k;
            if (i2 == i3) {
                return 0.0f;
            }
            if (i3 - i2 < horizontalFadingEdgeLength) {
                return (i3 - i2) / horizontalFadingEdgeLength;
            }
            return 1.0f;
        }
        return invokeV.floatValue;
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? g(this.n) : (View) invokeV.objValue;
    }

    public boolean onDown(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            this.w = !this.mFlingTracker.isFinished();
            this.mFlingTracker.forceFinished(true);
            setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
            f();
            if (!this.w && (c2 = c((int) motionEvent.getX(), (int) motionEvent.getY())) >= 0) {
                View childAt = getChildAt(c2);
                this.f58467g = childAt;
                if (childAt != null) {
                    childAt.setPressed(true);
                    refreshDrawableState();
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, canvas) == null) {
            super.onDraw(canvas);
            b(canvas);
        }
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.mFlingTracker.fling(this.mNextX, 0, (int) (-f2), 0, 0, this.k, 0, 0);
            setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_FLING);
            requestLayout();
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    @SuppressLint({"WrongCall"})
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (this.mAdapter == null) {
                return;
            }
            invalidate();
            if (this.f58465e) {
                int i6 = this.mCurrentX;
                b();
                removeAllViewsInLayout();
                this.mNextX = i6;
                this.f58465e = false;
            }
            Integer num = this.j;
            if (num != null) {
                this.mNextX = num.intValue();
                this.j = null;
            }
            if (this.mFlingTracker.computeScrollOffset()) {
                this.mNextX = this.mFlingTracker.getCurrX();
            }
            int i7 = this.mNextX;
            if (i7 < 0) {
                this.mNextX = 0;
                if (this.t.isFinished()) {
                    this.t.onAbsorb((int) d());
                }
                this.mFlingTracker.forceFinished(true);
                setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
            } else {
                int i8 = this.k;
                if (i7 > i8) {
                    this.mNextX = i8;
                    if (this.u.isFinished()) {
                        this.u.onAbsorb((int) d());
                    }
                    this.mFlingTracker.forceFinished(true);
                    setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
                }
            }
            int i9 = this.mCurrentX - this.mNextX;
            e(i9);
            d(i9);
            f(i9);
            this.mCurrentX = this.mNextX;
            if (e()) {
                onLayout(z, i2, i3, i4, i5);
            } else if (this.mFlingTracker.isFinished()) {
                if (this.s == OnScrollStateChangedListener.ScrollState.SCROLL_STATE_FLING) {
                    setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
                }
            } else {
                ViewCompat.postOnAnimation(this, this.A);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            this.v = i3;
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, parcelable) == null) && (parcelable instanceof Bundle)) {
            Bundle bundle = (Bundle) parcelable;
            this.j = Integer.valueOf(bundle.getInt("BUNDLE_ID_CURRENT_X"));
            super.onRestoreInstanceState(bundle.getParcelable("BUNDLE_ID_PARENT_STATE"));
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
            bundle.putInt("BUNDLE_ID_CURRENT_X", this.mCurrentX);
            return bundle;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 1) {
                Scroller scroller = this.mFlingTracker;
                if (scroller == null || scroller.isFinished()) {
                    setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
                }
                a(Boolean.FALSE);
                g();
            } else if (motionEvent.getAction() == 3) {
                f();
                g();
                a(Boolean.FALSE);
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void scrollTo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            Scroller scroller = this.mFlingTracker;
            int i3 = this.mNextX;
            scroller.startScroll(i3, 0, i2 - i3, 0);
            setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_FLING);
            requestLayout();
        }
    }

    public void setDivider(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, drawable) == null) {
            this.f58469i = drawable;
            if (drawable != null) {
                setDividerWidth(drawable.getIntrinsicWidth());
            } else {
                setDividerWidth(0);
            }
        }
    }

    public void setDividerWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.f58468h = i2;
            requestLayout();
            invalidate();
        }
    }

    @Override // android.widget.AdapterView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onClickListener) == null) {
            this.y = onClickListener;
        }
    }

    public void setOnScrollStateChangedListener(OnScrollStateChangedListener onScrollStateChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onScrollStateChangedListener) == null) {
            this.r = onScrollStateChangedListener;
        }
    }

    public void setRunningOutOfDataListener(d dVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048600, this, dVar, i2) == null) {
            this.o = dVar;
            this.p = i2;
        }
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.n = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            b();
            removeAllViewsInLayout();
            requestLayout();
        }
    }

    private float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, this)) == null) {
            if (Build.VERSION.SDK_INT >= 14) {
                return c.a(this.mFlingTracker);
            }
            return 30.0f;
        }
        return invokeV.floatValue;
    }

    private boolean e() {
        InterceptResult invokeV;
        View rightmostChild;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, this)) == null) {
            if (h(this.m) && (rightmostChild = getRightmostChild()) != null) {
                int i2 = this.k;
                int right = (this.mCurrentX + (rightmostChild.getRight() - getPaddingLeft())) - getRenderWidth();
                this.k = right;
                if (right < 0) {
                    this.k = 0;
                }
                if (this.k != i2) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void f(int i2) {
        int childCount;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65571, this, i2) == null) || (childCount = getChildCount()) <= 0) {
            return;
        }
        int i3 = this.f58463c + i2;
        this.f58463c = i3;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            int paddingLeft = getPaddingLeft() + i3;
            int paddingTop = getPaddingTop();
            childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
            i3 += childAt.getMeasuredWidth() + this.f58468h;
        }
    }

    private void h() {
        ListAdapter listAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65578, this) == null) || this.o == null || (listAdapter = this.mAdapter) == null || listAdapter.getCount() - (this.m + 1) >= this.p || this.q) {
            return;
        }
        this.q = true;
        this.o.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAdapter : (ListAdapter) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, listAdapter) == null) {
            ListAdapter listAdapter2 = this.mAdapter;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(this.z);
            }
            if (listAdapter != null) {
                this.q = false;
                this.mAdapter = listAdapter;
                listAdapter.registerDataSetObserver(this.z);
                a(this.mAdapter.getViewTypeCount());
            }
            c();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            this.l = -1;
            this.m = -1;
            this.f58463c = 0;
            this.mCurrentX = 0;
            this.mNextX = 0;
            this.k = Integer.MAX_VALUE;
            setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            EdgeEffectCompat edgeEffectCompat = this.t;
            if (edgeEffectCompat != null) {
                edgeEffectCompat.onRelease();
            }
            EdgeEffectCompat edgeEffectCompat2 = this.u;
            if (edgeEffectCompat2 != null) {
                edgeEffectCompat2.onRelease();
            }
        }
    }

    private void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65564, this, i2) == null) {
            View rightmostChild = getRightmostChild();
            a(rightmostChild != null ? rightmostChild.getRight() : 0, i2);
            View leftmostChild = getLeftmostChild();
            b(leftmostChild != null ? leftmostChild.getLeft() : 0, i2);
        }
    }

    private boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65562, this, i2)) == null) ? i2 < this.f58464d.size() : invokeI.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65559, this, i2, i3)) == null) {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                getChildAt(i4).getHitRect(this.f58466f);
                if (this.f58466f.contains(i2, i3)) {
                    return i4;
                }
            }
            return -1;
        }
        return invokeII.intValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.wallet.home.ui.widget.inner.HorizontalListView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ HorizontalListView f58470a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f58470a = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) ? this.f58470a.f58462b.onTouchEvent(motionEvent) : invokeLL.booleanValue;
                }
            });
        }
    }

    private void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65567, this, i2) == null) {
            View leftmostChild = getLeftmostChild();
            while (leftmostChild != null && leftmostChild.getRight() + i2 <= 0) {
                this.f58463c += h(this.l) ? leftmostChild.getMeasuredWidth() : this.f58468h + leftmostChild.getMeasuredWidth();
                a(this.l, leftmostChild);
                removeViewInLayout(leftmostChild);
                this.l++;
                leftmostChild = getLeftmostChild();
            }
            View rightmostChild = getRightmostChild();
            while (rightmostChild != null && rightmostChild.getLeft() + i2 >= getWidth()) {
                a(this.m, rightmostChild);
                removeViewInLayout(rightmostChild);
                this.m--;
                rightmostChild = getRightmostChild();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Boolean bool) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, this, bool) == null) || this.x == bool.booleanValue()) {
            return;
        }
        for (View view = this; view.getParent() instanceof View; view = (View) view.getParent()) {
            if ((view.getParent() instanceof ListView) || (view.getParent() instanceof ScrollView)) {
                view.getParent().requestDisallowInterceptTouchEvent(bool.booleanValue());
                this.x = bool.booleanValue();
                return;
            }
        }
    }

    private View b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, this, i2)) == null) {
            int itemViewType = this.mAdapter.getItemViewType(i2);
            if (c(itemViewType)) {
                return this.f58464d.get(itemViewType).poll();
            }
            return null;
        }
        return (View) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65570, this) == null) || (view = this.f58467g) == null) {
            return;
        }
        view.setPressed(false);
        refreshDrawableState();
        this.f58467g = null;
    }

    private ViewGroup.LayoutParams b(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, view)) == null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            return layoutParams == null ? new ViewGroup.LayoutParams(-2, -1) : layoutParams;
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
    }

    private boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65581, this)) == null) {
            ListAdapter listAdapter = this.mAdapter;
            return (listAdapter == null || listAdapter.isEmpty() || this.k <= 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) {
            this.f58464d.clear();
            for (int i3 = 0; i3 < i2; i3++) {
                this.f58464d.add(new LinkedList());
            }
        }
    }

    private void b(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65555, this, i2, i3) == null) {
            while ((i2 + i3) - this.f58468h > 0 && (i4 = this.l) >= 1) {
                int i5 = i4 - 1;
                this.l = i5;
                View view = this.mAdapter.getView(i5, b(i5), this);
                a(view, 0);
                i2 -= this.l == 0 ? view.getMeasuredWidth() : this.f58468h + view.getMeasuredWidth();
                this.f58463c -= i2 + i3 == 0 ? view.getMeasuredWidth() : view.getMeasuredWidth() + this.f58468h;
            }
        }
    }

    private void a(int i2, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(AdIconUtil.BAIDU_LOGO_ID, this, i2, view) == null) {
            int itemViewType = this.mAdapter.getItemViewType(i2);
            if (c(itemViewType)) {
                this.f58464d.get(itemViewType).offer(view);
            }
        }
    }

    private void a(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65546, this, view, i2) == null) {
            addViewInLayout(view, i2, b(view), true);
            a(view);
        }
    }

    private void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, canvas) == null) {
            int childCount = getChildCount();
            Rect rect = this.f58466f;
            rect.top = getPaddingTop();
            Rect rect2 = this.f58466f;
            rect2.bottom = rect2.top + getRenderHeight();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != childCount - 1 || !h(this.m)) {
                    View childAt = getChildAt(i2);
                    rect.left = childAt.getRight();
                    rect.right = childAt.getRight() + this.f58468h;
                    if (rect.left < getPaddingLeft()) {
                        rect.left = getPaddingLeft();
                    }
                    if (rect.right > getWidth() - getPaddingRight()) {
                        rect.right = getWidth() - getPaddingRight();
                    }
                    a(canvas, rect);
                    if (i2 == 0 && childAt.getLeft() > getPaddingLeft()) {
                        rect.left = getPaddingLeft();
                        rect.right = childAt.getLeft();
                        a(canvas, rect);
                    }
                }
            }
        }
    }

    private void a(View view) {
        int makeMeasureSpec;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, view) == null) {
            ViewGroup.LayoutParams b2 = b(view);
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.v, getPaddingTop() + getPaddingBottom(), b2.height);
            int i2 = b2.width;
            if (i2 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(makeMeasureSpec, childMeasureSpec);
        }
    }

    private void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(AdIconUtil.AD_TEXT_ID, this, i2, i3) == null) {
            while (i2 + i3 + this.f58468h < getWidth() && this.m + 1 < this.mAdapter.getCount()) {
                int i4 = this.m + 1;
                this.m = i4;
                if (this.l < 0) {
                    this.l = i4;
                }
                ListAdapter listAdapter = this.mAdapter;
                int i5 = this.m;
                View view = listAdapter.getView(i5, b(i5), this);
                a(view, -1);
                i2 += (this.m == 0 ? 0 : this.f58468h) + view.getMeasuredWidth();
                h();
            }
        }
    }

    private void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, canvas) == null) {
            EdgeEffectCompat edgeEffectCompat = this.t;
            if (edgeEffectCompat != null && !edgeEffectCompat.isFinished() && i()) {
                int save = canvas.save();
                int height = getHeight();
                canvas.rotate(-90.0f, 0.0f, 0.0f);
                canvas.translate((-height) + getPaddingBottom(), 0.0f);
                this.t.setSize(getRenderHeight(), getRenderWidth());
                if (this.t.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
                return;
            }
            EdgeEffectCompat edgeEffectCompat2 = this.u;
            if (edgeEffectCompat2 == null || edgeEffectCompat2.isFinished() || !i()) {
                return;
            }
            int save2 = canvas.save();
            int width = getWidth();
            canvas.rotate(90.0f, 0.0f, 0.0f);
            canvas.translate(getPaddingTop(), -width);
            this.u.setSize(getRenderHeight(), getRenderWidth());
            if (this.u.draw(canvas)) {
                invalidate();
            }
            canvas.restoreToCount(save2);
        }
    }

    private void a(Canvas canvas, Rect rect) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, this, canvas, rect) == null) || (drawable = this.f58469i) == null) {
            return;
        }
        drawable.setBounds(rect);
        this.f58469i.draw(canvas);
    }
}
