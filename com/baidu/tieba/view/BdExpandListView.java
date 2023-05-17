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
import com.baidu.tieba.zt9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BdExpandListView extends BdTypeListView {
    public static /* synthetic */ Interceptable $ic = null;
    public static int d0 = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context J;
    public final Scroller K;
    public View L;
    public float M;
    public float N;
    public c O;
    public boolean P;
    public final int Q;
    public final int R;
    public b S;
    public long T;
    public long U;
    public Handler V;
    public int W;
    public boolean a0;
    public Runnable b0;
    public int c0;

    /* loaded from: classes7.dex */
    public interface b {
        void a(float f);

        void b();

        void onRefresh();
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

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdExpandListView a;

        public a(BdExpandListView bdExpandListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdExpandListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdExpandListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.W > 0) {
                this.a.L.setLayoutParams(new AbsListView.LayoutParams(this.a.L.getWidth(), this.a.W));
                this.a.invalidate();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;

        public c(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i2;
            this.b = i4;
        }

        public int a(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
                return (int) (this.a + (f / 2.5f));
            }
            return invokeF.intValue;
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
        this.P = false;
        this.T = 0L;
        this.U = 0L;
        this.V = new Handler();
        this.a0 = false;
        this.b0 = new a(this);
        this.c0 = 0;
        this.J = context;
        this.K = new Scroller(this.J);
        this.Q = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, zt9.ExpandListView);
        this.R = obtainStyledAttributes.getDimensionPixelSize(d0, 0);
        obtainStyledAttributes.recycle();
    }

    private void setClickEventEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, this, z) == null) {
            setClickable(z);
            setLongClickable(z);
            setEnabled(z);
        }
    }

    public final void K(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
            float f2 = 360.0f - ((f * 360.0f) / this.R);
            b bVar = this.S;
            if (bVar != null) {
                bVar.a(f2);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (this.P) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            if (this.P) {
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setPersonListRefreshListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.S = bVar;
        }
    }

    public void setStarForum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.a0 = z;
        }
    }

    private int getOriginalHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.W <= 0) {
                this.W = this.L.getHeight();
            }
            return this.W;
        }
        return invokeV.intValue;
    }

    public void L() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bVar = this.S) != null) {
            bVar.onRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a0) {
                super.E();
                return;
            }
            if (getLastVisiblePosition() > 10) {
                setSelection(10);
            }
            smoothScrollToPosition(0);
            if (this.L != null && !this.P) {
                this.P = true;
                Scroller scroller = this.K;
                int originalHeight = getOriginalHeight();
                int i = this.R;
                scroller.startScroll(0, originalHeight + i, 0, -i, 200);
                L();
                invalidate();
                this.V.removeCallbacks(this.b0);
                this.V.postDelayed(this.b0, 200L);
                this.P = false;
            }
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.O == null) {
            return;
        }
        if (this.L.getHeight() >= this.O.b - (this.R / 2)) {
            L();
        } else {
            b bVar = this.S;
            if (bVar != null) {
                bVar.b();
            }
        }
        this.K.startScroll(0, this.L.getHeight(), 0, this.O.a - this.L.getHeight(), 200);
        invalidate();
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.a0) {
                super.computeScroll();
            } else if (this.K.computeScrollOffset()) {
                int currY = this.K.getCurrY();
                if (Math.abs(this.c0 - currY) > this.Q * 2) {
                    this.c0 = currY;
                    this.L.setLayoutParams(new AbsListView.LayoutParams(this.L.getWidth(), currY));
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            if (this.a0) {
                return super.dispatchTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction();
            if (!this.K.isFinished()) {
                return true;
            }
            if (this.L == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            float y = motionEvent.getY();
            this.N = y;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float f = y - this.M;
                        if (this.L.getParent() == this && this.O != null && this.L.isShown() && this.L.getTop() >= 0 && Math.abs(f) >= this.Q && this.T > 400) {
                            int a2 = this.O.a(this.N - this.M);
                            c cVar = this.O;
                            if (a2 > cVar.a && a2 <= cVar.b) {
                                this.P = true;
                                setClickEventEnabled(false);
                                this.L.setLayoutParams(new AbsListView.LayoutParams(this.L.getWidth(), a2));
                                K(a2 - this.O.a);
                            } else {
                                c cVar2 = this.O;
                                if (a2 <= cVar2.a) {
                                    this.P = false;
                                } else if (a2 > cVar2.b) {
                                    this.P = true;
                                    setClickEventEnabled(false);
                                } else {
                                    this.P = false;
                                }
                            }
                        } else {
                            this.P = false;
                        }
                    }
                }
                if (this.P) {
                    setClickEventEnabled(false);
                    M();
                    this.P = false;
                } else {
                    b bVar = this.S;
                    if (bVar != null) {
                        bVar.b();
                    }
                }
                this.V.removeCallbacks(this.b0);
                this.V.postDelayed(this.b0, 200L);
            } else {
                this.T = System.currentTimeMillis() - this.U;
                this.U = System.currentTimeMillis();
                this.P = false;
                setClickEventEnabled(true);
                if (this.W == 0) {
                    this.W = this.L.getHeight();
                }
                int height = this.L.getHeight();
                this.M = this.N;
                this.O = new c(0, height, 0, this.R + height);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setExpandView(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, i) == null) {
            this.L = view2;
        }
    }
}
