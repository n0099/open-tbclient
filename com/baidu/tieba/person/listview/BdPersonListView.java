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
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
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
    public static final int[] ExpandListView;
    public static int ExpandListView_expandDistance = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context N;
    public final Scroller O;
    public final Scroller P;
    public View Q;
    public View R;
    public float S;
    public float T;
    public b U;
    public b V;
    public boolean W;
    public float a0;
    public float b0;
    public final int c0;
    public final int i0;
    public boolean j0;
    public boolean k0;
    public boolean l0;
    public a mRefreshListener;

    /* loaded from: classes7.dex */
    public interface a {
        void a(float f2);

        void b();

        void onRefresh();
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f55636a;

        /* renamed from: b  reason: collision with root package name */
        public int f55637b;

        public b(int i2, int i3, int i4, int i5) {
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
            this.f55636a = i3;
            this.f55637b = i5;
        }

        public int a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? (int) (this.f55636a + (f2 / 2.5f)) : invokeF.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1003786177, "Lcom/baidu/tieba/person/listview/BdPersonListView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1003786177, "Lcom/baidu/tieba/person/listview/BdPersonListView;");
                return;
            }
        }
        ExpandListView = new int[]{R.anim.anim_alpha_1_to_0_duration_300, R.anim.anim_alpha_1_to_0_duration_500_accelerate};
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
        this.W = false;
        this.j0 = true;
        this.k0 = false;
        this.l0 = false;
        this.N = context;
        this.O = new Scroller(this.N);
        this.P = new Scroller(this.N);
        this.c0 = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExpandListView);
        this.i0 = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.O.computeScrollOffset()) {
                this.Q.setLayoutParams(new AbsListView.LayoutParams(this.Q.getWidth(), this.O.getCurrY()));
            } else {
                super.computeScroll();
            }
            if (this.P.computeScrollOffset()) {
                int currY = this.P.getCurrY();
                View view = this.R;
                if (view == null || (layoutParams = view.getLayoutParams()) == null) {
                    return;
                }
                layoutParams.height = currY;
                this.R.setLayoutParams(layoutParams);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            if (this.Q != null && this.j0) {
                int action = motionEvent.getAction();
                if (this.O.isFinished()) {
                    float y = motionEvent.getY();
                    this.T = y;
                    if (action != 0) {
                        if (action != 1) {
                            if (action == 2) {
                                float f2 = this.b0;
                                float f3 = f2 - this.a0;
                                float f4 = y - this.S;
                                this.a0 = f2;
                                if (this.Q.getParent() == this && this.U != null && this.Q.isShown() && this.Q.getTop() >= 0 && Math.abs(f4) >= this.c0 && Math.abs(f3) < this.c0) {
                                    int a2 = this.U.a(this.T - this.S);
                                    b bVar = this.U;
                                    if (a2 > bVar.f55636a && a2 <= bVar.f55637b) {
                                        this.W = true;
                                        this.Q.setLayoutParams(new AbsListView.LayoutParams(this.Q.getWidth(), a2));
                                        if (this.R != null) {
                                            int a3 = this.V.a(this.T - this.S);
                                            ViewGroup.LayoutParams layoutParams = this.R.getLayoutParams();
                                            if (layoutParams != null) {
                                                layoutParams.height = a3;
                                                this.R.setLayoutParams(layoutParams);
                                            }
                                        }
                                        y(a2 - this.U.f55636a);
                                    } else {
                                        b bVar2 = this.U;
                                        if (a2 <= bVar2.f55636a) {
                                            this.W = false;
                                        } else if (a2 > bVar2.f55637b) {
                                            this.W = true;
                                        } else {
                                            this.W = false;
                                        }
                                    }
                                } else {
                                    this.W = false;
                                }
                            }
                        }
                        if (this.W) {
                            scrollCallback();
                            if (this.k0) {
                                return true;
                            }
                        } else {
                            this.mRefreshListener.b();
                        }
                    } else {
                        int height = this.Q.getHeight();
                        this.S = this.T;
                        this.a0 = this.b0;
                        this.U = new b(0, height, 0, this.i0 + height);
                        int height2 = this.R.getHeight();
                        this.V = new b(0, height2, 0, this.i0 + height2);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                }
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void doRefresh() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.mRefreshListener) == null) {
            return;
        }
        aVar.onRefresh();
    }

    public View getOuterExpandView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.R : (View) invokeV.objValue;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (this.W) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            if (!this.W || this.l0) {
                return super.onTouchEvent(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void scrollCallback() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.U == null) {
            return;
        }
        if (this.Q.getHeight() >= this.U.f55637b - (this.i0 / 2)) {
            doRefresh();
        } else {
            this.mRefreshListener.b();
        }
        this.O.startScroll(0, this.Q.getHeight(), 0, this.U.f55636a - this.Q.getHeight(), 200);
        this.P.startScroll(0, this.R.getHeight(), 0, this.V.f55636a - this.R.getHeight(), 200);
        invalidate();
        this.W = false;
    }

    public void setExpandView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            this.Q = view;
        }
    }

    public void setNeedConsumeTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.l0 = z;
        }
    }

    public void setOuterExpandView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            this.R = view;
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.mRefreshListener = aVar;
        }
    }

    public final void y(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f2) == null) {
            this.mRefreshListener.a(360.0f - ((f2 * 360.0f) / this.i0));
        }
    }
}
