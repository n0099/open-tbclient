package com.baidu.wallet.paysdk.ui.widget.dragListView;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a extends b implements GestureDetector.OnGestureListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f51165b;

    /* renamed from: c  reason: collision with root package name */
    public int f51166c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51167d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f51168e;

    /* renamed from: f  reason: collision with root package name */
    public GestureDetector f51169f;

    /* renamed from: g  reason: collision with root package name */
    public GestureDetector f51170g;

    /* renamed from: h  reason: collision with root package name */
    public int f51171h;

    /* renamed from: i  reason: collision with root package name */
    public int f51172i;

    /* renamed from: j  reason: collision with root package name */
    public int f51173j;
    public int k;
    public int[] l;
    public int m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public float r;
    public int s;
    public int t;
    public int u;
    public boolean v;
    public DragSortListView w;
    public int x;
    public GestureDetector.OnGestureListener y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(DragSortListView dragSortListView, int i2, int i3, int i4, int i5, int i6) {
        super(dragSortListView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dragSortListView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                super((ListView) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f51165b = true;
        this.f51167d = false;
        this.f51168e = false;
        this.f51172i = -1;
        this.f51173j = -1;
        this.k = -1;
        this.l = new int[2];
        this.q = false;
        this.r = 500.0f;
        this.y = new GestureDetector.SimpleOnGestureListener(this) { // from class: com.baidu.wallet.paysdk.ui.widget.dragListView.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i9 = newInitContext2.flag;
                    if ((i9 & 1) != 0) {
                        int i10 = i9 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                    if (this.a.f51167d && this.a.f51168e) {
                        int width = this.a.w.getWidth() / 5;
                        if (f2 > this.a.r) {
                            if (this.a.x > (-width)) {
                                this.a.w.stopDragWithVelocity(true, f2);
                            }
                        } else if (f2 < (-this.a.r) && this.a.x < width) {
                            this.a.w.stopDragWithVelocity(true, f2);
                        }
                        this.a.f51168e = false;
                    }
                    return false;
                }
                return invokeCommon.booleanValue;
            }
        };
        this.w = dragSortListView;
        this.f51169f = new GestureDetector(dragSortListView.getContext(), this);
        GestureDetector gestureDetector = new GestureDetector(dragSortListView.getContext(), this.y);
        this.f51170g = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.f51171h = ViewConfiguration.get(dragSortListView.getContext()).getScaledTouchSlop();
        this.s = i2;
        this.t = i5;
        this.u = i6;
        b(i4);
        a(i3);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
            if (this.f51167d && this.f51166c == 0) {
                this.k = a(motionEvent, this.t);
            }
            int a = a(motionEvent);
            this.f51172i = a;
            if (a != -1 && this.a == 0) {
                a(a, ((int) motionEvent.getX()) - this.m, ((int) motionEvent.getY()) - this.n);
            }
            this.f51168e = false;
            this.v = true;
            this.x = 0;
            this.f51173j = b(motionEvent);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, motionEvent) == null) || this.f51172i == -1) {
            return;
        }
        this.w.performHapticFeedback(0);
        a(this.f51172i, this.o - this.m, this.p - this.n);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i2 = x2 - this.m;
            int i3 = y2 - this.n;
            if (this.v && !this.q && (this.f51172i != -1 || this.f51173j != -1)) {
                if (this.f51172i != -1) {
                    if (this.a == 1 && Math.abs(y2 - y) > this.f51171h && this.f51165b) {
                        a(this.f51172i, i2, i3);
                    } else if (this.a != 0 && Math.abs(x2 - x) > this.f51171h && this.f51167d) {
                        this.f51168e = true;
                        a(this.f51173j, i2, i3);
                    }
                } else if (this.f51173j != -1) {
                    if (Math.abs(x2 - x) > this.f51171h && this.f51167d) {
                        this.f51168e = true;
                        a(this.f51173j, i2, i3);
                    } else if (Math.abs(y2 - y) > this.f51171h) {
                        this.v = false;
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, motionEvent) == null) {
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) {
            if (this.f51167d && this.f51166c == 0 && (i2 = this.k) != -1) {
                DragSortListView dragSortListView = this.w;
                dragSortListView.removeItem(i2 - dragSortListView.getHeaderViewsCount());
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
        if (r5 != 3) goto L31;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, view, motionEvent)) == null) {
            if (this.w.isDragEnabled() && !this.w.listViewIntercepted()) {
                this.f51169f.onTouchEvent(motionEvent);
                if (this.f51167d && this.q && this.f51166c == 1) {
                    this.f51170g.onTouchEvent(motionEvent);
                }
                int action = motionEvent.getAction() & 255;
                if (action != 0) {
                    if (action == 1) {
                        if (this.f51167d && this.f51168e) {
                            int i2 = this.x;
                            if (i2 < 0) {
                                i2 = -i2;
                            }
                            if (i2 > this.w.getWidth() / 2) {
                                this.w.stopDragWithVelocity(true, 0.0f);
                            }
                        }
                    }
                    this.f51168e = false;
                    this.q = false;
                } else {
                    this.o = (int) motionEvent.getX();
                    this.p = (int) motionEvent.getY();
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f51166c = i2;
        }
    }

    public int c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) ? a(motionEvent, this.s) : invokeL.intValue;
    }

    public int d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) ? a(motionEvent, this.u) : invokeL.intValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.a = i2;
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f51167d = z;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f51165b = z;
        }
    }

    public int b(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (this.f51166c == 1) {
                return d(motionEvent);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public boolean a(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048581, this, i2, i3, i4)) == null) {
            int i5 = (!this.f51165b || this.f51168e) ? 0 : 12;
            if (this.f51167d && this.f51168e) {
                i5 = i5 | 1 | 2;
            }
            DragSortListView dragSortListView = this.w;
            boolean startDrag = dragSortListView.startDrag(i2 - dragSortListView.getHeaderViewsCount(), i5, i3, i4);
            this.q = startDrag;
            return startDrag;
        }
        return invokeIII.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.b, com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public void a(View view, Point point, Point point2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048579, this, view, point, point2) == null) && this.f51167d && this.f51168e) {
            this.x = point.x;
        }
    }

    public int a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) ? c(motionEvent) : invokeL.intValue;
    }

    public int a(MotionEvent motionEvent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent, i2)) == null) {
            int pointToPosition = this.w.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            int headerViewsCount = this.w.getHeaderViewsCount();
            int footerViewsCount = this.w.getFooterViewsCount();
            int count = this.w.getCount();
            if (pointToPosition != -1 && pointToPosition >= headerViewsCount && pointToPosition < count - footerViewsCount) {
                DragSortListView dragSortListView = this.w;
                View childAt = dragSortListView.getChildAt(pointToPosition - dragSortListView.getFirstVisiblePosition());
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                View findViewById = i2 == 0 ? childAt : childAt.findViewById(i2);
                if (findViewById != null) {
                    findViewById.getLocationOnScreen(this.l);
                    int[] iArr = this.l;
                    if (rawX > iArr[0] && rawY > iArr[1] && rawX < iArr[0] + findViewById.getWidth() && rawY < this.l[1] + findViewById.getHeight()) {
                        this.m = childAt.getLeft();
                        this.n = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
            return -1;
        }
        return invokeLI.intValue;
    }
}
