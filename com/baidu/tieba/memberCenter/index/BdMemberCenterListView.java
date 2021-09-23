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
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BdMemberCenterListView extends BdTypeListView {
    public static /* synthetic */ Interceptable $ic = null;
    public static int ExpandListView_expandDistance = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context N;
    public final Scroller O;
    public View P;
    public float Q;
    public float R;
    public b S;
    public boolean T;
    public float U;
    public float V;
    public final int W;
    public final int a0;
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
        public int f54326a;

        /* renamed from: b  reason: collision with root package name */
        public int f54327b;

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
            this.f54326a = i3;
            this.f54327b = i5;
        }

        public int a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? (int) (this.f54326a + (f2 / 2.5f)) : invokeF.intValue;
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
        this.N = context;
        this.O = new Scroller(this.N);
        this.W = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExpandListView);
        this.a0 = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.O.computeScrollOffset() && this.P != null) {
                this.P.setLayoutParams(new AbsListView.LayoutParams(this.P.getWidth(), this.O.getCurrY()));
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
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (this.O.isFinished()) {
                float y = motionEvent.getY();
                this.R = y;
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float f2 = this.V;
                            float f3 = f2 - this.U;
                            float f4 = y - this.Q;
                            this.U = f2;
                            View view = this.P;
                            if (view != null && view.getParent() == this && this.S != null && this.P.isShown() && this.P.getTop() >= 0 && Math.abs(f4) >= this.W && Math.abs(f3) < this.W) {
                                int a2 = this.S.a(this.R - this.Q);
                                b bVar = this.S;
                                if (a2 > bVar.f54326a && a2 <= bVar.f54327b) {
                                    this.T = true;
                                    this.P.setLayoutParams(new AbsListView.LayoutParams(this.P.getWidth(), a2));
                                    y(a2 - this.S.f54326a);
                                } else {
                                    b bVar2 = this.S;
                                    if (a2 <= bVar2.f54326a) {
                                        this.T = false;
                                    } else if (a2 > bVar2.f54327b) {
                                        this.T = true;
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
                        scrollCallback();
                    } else {
                        this.mRefreshListener.b();
                    }
                } else {
                    View view2 = this.P;
                    int height = view2 == null ? 0 : view2.getHeight();
                    this.Q = this.R;
                    this.U = this.V;
                    this.S = new b(0, height, 0, this.a0 + height);
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
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

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (this.T) {
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void scrollCallback() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.S == null) {
            return;
        }
        View view = this.P;
        int height = view == null ? 0 : view.getHeight();
        if (height >= this.S.f54327b - (this.a0 / 2)) {
            doRefresh();
        } else {
            this.mRefreshListener.b();
        }
        this.O.startScroll(0, height, 0, this.S.f54326a - height, 200);
        invalidate();
        this.T = false;
    }

    public void setExpandView(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, view, i2) == null) {
            this.P = view;
        }
    }

    public void setMemberCenterListRefreshListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.mRefreshListener = aVar;
        }
    }

    public final void y(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            this.mRefreshListener.a(360.0f - ((f2 * 360.0f) / this.a0));
        }
    }
}
