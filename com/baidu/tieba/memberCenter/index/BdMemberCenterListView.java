package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.Scroller;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ho5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class BdMemberCenterListView extends BdTypeListView {
    public static /* synthetic */ Interceptable $ic = null;
    public static int V = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context J;
    public final Scroller K;
    public View L;
    public float M;
    public float N;
    public b O;
    public boolean P;
    public float Q;
    public float R;
    public final int S;
    public final int T;
    public a U;

    /* loaded from: classes5.dex */
    public interface a {
        void a(float f);

        void b();

        void onRefresh();
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;

        public b(int i, int i2, int i3, int i4) {
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
            return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) ? (int) (this.a + (f / 2.5f)) : invokeF.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-472985160, "Lcom/baidu/tieba/memberCenter/index/BdMemberCenterListView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-472985160, "Lcom/baidu/tieba/memberCenter/index/BdMemberCenterListView;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdMemberCenterListView(Context context, AttributeSet attributeSet) {
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
        this.J = context;
        this.K = new Scroller(this.J);
        this.S = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ho5.ExpandListView);
        this.T = obtainStyledAttributes.getDimensionPixelSize(V, 0);
        obtainStyledAttributes.recycle();
    }

    public final void I(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
            this.U.a(360.0f - ((f * 360.0f) / this.T));
        }
    }

    public void J() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.U) == null) {
            return;
        }
        aVar.onRefresh();
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.O == null) {
            return;
        }
        View view2 = this.L;
        int height = view2 == null ? 0 : view2.getHeight();
        if (height >= this.O.b - (this.T / 2)) {
            J();
        } else {
            this.U.b();
        }
        this.K.startScroll(0, height, 0, this.O.a - height, 200);
        invalidate();
        this.P = false;
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.K.computeScrollOffset() && this.L != null) {
                this.L.setLayoutParams(new AbsListView.LayoutParams(this.L.getWidth(), this.K.getCurrY()));
                return;
            }
            super.computeScroll();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
        if (r0 != 3) goto L14;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (this.K.isFinished()) {
                float y = motionEvent.getY();
                this.N = y;
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float f = this.R;
                            float f2 = f - this.Q;
                            float f3 = y - this.M;
                            this.Q = f;
                            View view2 = this.L;
                            if (view2 != null && view2.getParent() == this && this.O != null && this.L.isShown() && this.L.getTop() >= 0 && Math.abs(f3) >= this.S && Math.abs(f2) < this.S) {
                                int a2 = this.O.a(this.N - this.M);
                                b bVar = this.O;
                                if (a2 > bVar.a && a2 <= bVar.b) {
                                    this.P = true;
                                    this.L.setLayoutParams(new AbsListView.LayoutParams(this.L.getWidth(), a2));
                                    I(a2 - this.O.a);
                                } else {
                                    b bVar2 = this.O;
                                    if (a2 <= bVar2.a) {
                                        this.P = false;
                                    } else if (a2 > bVar2.b) {
                                        this.P = true;
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
                        K();
                    } else {
                        this.U.b();
                    }
                } else {
                    View view3 = this.L;
                    int height = view3 == null ? 0 : view3.getHeight();
                    this.M = this.N;
                    this.Q = this.R;
                    this.O = new b(0, height, 0, this.T + height);
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (this.P) {
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setExpandView(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, view2, i) == null) {
            this.L = view2;
        }
    }

    public void setMemberCenterListRefreshListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.U = aVar;
        }
    }
}
