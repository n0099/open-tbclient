package com.baidu.tieba.person.listview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Scroller;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cp9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BdPersonListView extends BdTypeListView {
    public static /* synthetic */ Interceptable $ic = null;
    public static int e0 = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context J;
    public final Scroller K;
    public final Scroller L;
    public View M;
    public View N;
    public float O;
    public float P;
    public b Q;
    public b R;
    public boolean S;

    /* renamed from: T  reason: collision with root package name */
    public float f1149T;
    public float U;
    public final int V;
    public final int W;
    public a a0;
    public boolean b0;
    public boolean c0;
    public boolean d0;

    /* loaded from: classes7.dex */
    public interface a {
        void a(float f);

        void b();

        void onRefresh();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1003786177, "Lcom/baidu/tieba/person/listview/BdPersonListView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1003786177, "Lcom/baidu/tieba/person/listview/BdPersonListView;");
        }
    }

    /* loaded from: classes7.dex */
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
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
                return (int) (this.a + (f / 2.5f));
            }
            return invokeF.intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdPersonListView(Context context, AttributeSet attributeSet) {
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
        this.S = false;
        this.b0 = true;
        this.c0 = false;
        this.d0 = false;
        this.J = context;
        this.K = new Scroller(this.J);
        this.L = new Scroller(this.J);
        this.V = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cp9.ExpandListView);
        this.W = obtainStyledAttributes.getDimensionPixelSize(e0, 0);
        obtainStyledAttributes.recycle();
    }

    public final void I(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
            this.a0.a(360.0f - ((f * 360.0f) / this.W));
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (this.S) {
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
            if (this.S && !this.d0) {
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setExpandView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            this.M = view2;
        }
    }

    public void setNeedConsumeTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.d0 = z;
        }
    }

    public void setOuterExpandView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            this.N = view2;
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.a0 = aVar;
        }
    }

    public void J() {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (aVar = this.a0) != null) {
            aVar.onRefresh();
        }
    }

    public View getOuterExpandView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.N;
        }
        return (View) invokeV.objValue;
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.Q == null) {
            return;
        }
        if (this.M.getHeight() >= this.Q.b - (this.W / 2)) {
            J();
        } else {
            this.a0.b();
        }
        this.K.startScroll(0, this.M.getHeight(), 0, this.Q.a - this.M.getHeight(), 200);
        this.L.startScroll(0, this.N.getHeight(), 0, this.R.a - this.N.getHeight(), 200);
        invalidate();
        this.S = false;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.K.computeScrollOffset()) {
                this.M.setLayoutParams(new AbsListView.LayoutParams(this.M.getWidth(), this.K.getCurrY()));
            } else {
                super.computeScroll();
            }
            if (this.L.computeScrollOffset()) {
                int currY = this.L.getCurrY();
                View view2 = this.N;
                if (view2 != null && (layoutParams = view2.getLayoutParams()) != null) {
                    layoutParams.height = currY;
                    this.N.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
        if (r0 != 3) goto L18;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (this.M != null && this.b0) {
                int action = motionEvent.getAction();
                if (!this.K.isFinished()) {
                    return true;
                }
                float y = motionEvent.getY();
                this.P = y;
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float f = this.U;
                            float f2 = f - this.f1149T;
                            float f3 = y - this.O;
                            this.f1149T = f;
                            if (this.M.getParent() == this && this.Q != null && this.M.isShown() && this.M.getTop() >= 0 && Math.abs(f3) >= this.V && Math.abs(f2) < this.V) {
                                int a2 = this.Q.a(this.P - this.O);
                                b bVar = this.Q;
                                if (a2 > bVar.a && a2 <= bVar.b) {
                                    this.S = true;
                                    this.M.setLayoutParams(new AbsListView.LayoutParams(this.M.getWidth(), a2));
                                    if (this.N != null) {
                                        int a3 = this.R.a(this.P - this.O);
                                        ViewGroup.LayoutParams layoutParams = this.N.getLayoutParams();
                                        if (layoutParams != null) {
                                            layoutParams.height = a3;
                                            this.N.setLayoutParams(layoutParams);
                                        }
                                    }
                                    I(a2 - this.Q.a);
                                } else {
                                    b bVar2 = this.Q;
                                    if (a2 <= bVar2.a) {
                                        this.S = false;
                                    } else if (a2 > bVar2.b) {
                                        this.S = true;
                                    } else {
                                        this.S = false;
                                    }
                                }
                            } else {
                                this.S = false;
                            }
                        }
                    }
                    if (this.S) {
                        K();
                        if (this.c0) {
                            return true;
                        }
                    } else {
                        this.a0.b();
                    }
                } else {
                    int height = this.M.getHeight();
                    this.O = this.P;
                    this.f1149T = this.U;
                    this.Q = new b(0, height, 0, this.W + height);
                    int height2 = this.N.getHeight();
                    this.R = new b(0, height2, 0, this.W + height2);
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }
}
