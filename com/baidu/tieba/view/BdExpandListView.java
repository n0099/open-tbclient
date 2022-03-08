package com.baidu.tieba.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.Scroller;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class BdExpandListView extends BdTypeListView {
    public static /* synthetic */ Interceptable $ic = null;
    public static int ExpandListView_expandDistance = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context N;
    public final Scroller O;
    public View P;
    public float Q;
    public float R;
    public c S;
    public boolean T;
    public final int U;
    public final int V;
    public long W;
    public long a0;
    public Handler b0;
    public int c0;
    public boolean d0;
    public Runnable e0;
    public int f0;
    public b mRefreshListener;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdExpandListView f47617e;

        public a(BdExpandListView bdExpandListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdExpandListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47617e = bdExpandListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f47617e.c0 <= 0) {
                return;
            }
            this.f47617e.P.setLayoutParams(new AbsListView.LayoutParams(this.f47617e.P.getWidth(), this.f47617e.c0));
            this.f47617e.invalidate();
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(float f2);

        void b();

        void onRefresh();
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f47618b;

        public c(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i3;
            this.f47618b = i5;
        }

        public int a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? (int) (this.a + (f2 / 2.5f)) : invokeF.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1635179616, "Lcom/baidu/tieba/view/BdExpandListView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1635179616, "Lcom/baidu/tieba/view/BdExpandListView;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdExpandListView(Context context, AttributeSet attributeSet) {
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
        this.T = false;
        this.W = 0L;
        this.a0 = 0L;
        this.b0 = new Handler();
        this.d0 = false;
        this.e0 = new a(this);
        this.f0 = 0;
        this.N = context;
        this.O = new Scroller(this.N);
        this.U = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.beforeExpandHeight, R.attr.expandDistance});
        this.V = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    private int getOriginalHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (this.c0 <= 0) {
                this.c0 = this.P.getHeight();
            }
            return this.c0;
        }
        return invokeV.intValue;
    }

    private void setClickEventEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            setClickable(z);
            setLongClickable(z);
            setEnabled(z);
        }
    }

    public final void A(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            float f3 = 360.0f - ((f2 * 360.0f) / this.V);
            b bVar = this.mRefreshListener;
            if (bVar != null) {
                bVar.a(f3);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.d0) {
                super.computeScroll();
            } else if (this.O.computeScrollOffset()) {
                int currY = this.O.getCurrY();
                if (Math.abs(this.f0 - currY) > this.U * 2) {
                    this.f0 = currY;
                    this.P.setLayoutParams(new AbsListView.LayoutParams(this.P.getWidth(), currY));
                }
            } else {
                scrollTo(0, 0);
                super.computeScroll();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0033, code lost:
        if (r0 != 3) goto L22;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (this.d0) {
                return super.dispatchTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction();
            if (this.O.isFinished()) {
                if (this.P == null) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                float y = motionEvent.getY();
                this.R = y;
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float f2 = y - this.Q;
                            if (this.P.getParent() == this && this.S != null && this.P.isShown() && this.P.getTop() >= 0 && Math.abs(f2) >= this.U && this.W > 400) {
                                int a2 = this.S.a(this.R - this.Q);
                                c cVar = this.S;
                                if (a2 > cVar.a && a2 <= cVar.f47618b) {
                                    this.T = true;
                                    setClickEventEnabled(false);
                                    this.P.setLayoutParams(new AbsListView.LayoutParams(this.P.getWidth(), a2));
                                    A(a2 - this.S.a);
                                } else {
                                    c cVar2 = this.S;
                                    if (a2 <= cVar2.a) {
                                        this.T = false;
                                    } else if (a2 > cVar2.f47618b) {
                                        this.T = true;
                                        setClickEventEnabled(false);
                                    } else {
                                        this.T = false;
                                    }
                                }
                            } else {
                                this.T = false;
                            }
                        }
                    }
                    if (this.T) {
                        setClickEventEnabled(false);
                        scrollCallback();
                        this.T = false;
                    } else {
                        b bVar = this.mRefreshListener;
                        if (bVar != null) {
                            bVar.b();
                        }
                    }
                    this.b0.removeCallbacks(this.e0);
                    this.b0.postDelayed(this.e0, 200L);
                } else {
                    this.W = System.currentTimeMillis() - this.a0;
                    this.a0 = System.currentTimeMillis();
                    this.T = false;
                    setClickEventEnabled(true);
                    if (this.c0 == 0) {
                        this.c0 = this.P.getHeight();
                    }
                    int height = this.P.getHeight();
                    this.Q = this.R;
                    this.S = new c(0, height, 0, this.V + height);
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void doRefresh() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = this.mRefreshListener) == null) {
            return;
        }
        bVar.onRefresh();
    }

    public boolean isStarForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.d0 : invokeV.booleanValue;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            if (this.T) {
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (this.T) {
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void scrollCallback() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.S == null) {
            return;
        }
        if (this.P.getHeight() >= this.S.f47618b - (this.V / 2)) {
            doRefresh();
        } else {
            b bVar = this.mRefreshListener;
            if (bVar != null) {
                bVar.b();
            }
        }
        this.O.startScroll(0, this.P.getHeight(), 0, this.S.a - this.P.getHeight(), 200);
        invalidate();
    }

    public void setExpandView(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, i2) == null) {
            this.P = view;
        }
    }

    public void setPersonListRefreshListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.mRefreshListener = bVar;
        }
    }

    public void setStarForum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.d0 = z;
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.d0) {
                super.startPullRefresh();
                return;
            }
            if (getLastVisiblePosition() > 10) {
                setSelection(10);
            }
            smoothScrollToPosition(0);
            if (this.P == null || this.T) {
                return;
            }
            this.T = true;
            Scroller scroller = this.O;
            int originalHeight = getOriginalHeight();
            int i2 = this.V;
            scroller.startScroll(0, originalHeight + i2, 0, -i2, 200);
            doRefresh();
            invalidate();
            this.b0.removeCallbacks(this.e0);
            this.b0.postDelayed(this.e0, 200L);
            this.T = false;
        }
    }
}
