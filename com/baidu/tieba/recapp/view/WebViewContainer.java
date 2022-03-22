package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class WebViewContainer extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OverScroller a;

    /* renamed from: b  reason: collision with root package name */
    public float f35803b;

    /* renamed from: c  reason: collision with root package name */
    public float f35804c;

    /* renamed from: d  reason: collision with root package name */
    public GestureDetector f35805d;

    /* renamed from: e  reason: collision with root package name */
    public VelocityTracker f35806e;

    /* renamed from: f  reason: collision with root package name */
    public OnScrollChangedCallback f35807f;

    /* renamed from: g  reason: collision with root package name */
    public int f35808g;

    /* renamed from: h  reason: collision with root package name */
    public int f35809h;
    public int i;

    /* loaded from: classes5.dex */
    public interface OnScrollChangedCallback {
        void onScroll(int i, int i2);
    }

    /* loaded from: classes5.dex */
    public static class YScrollDetector extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WebViewContainer a;

        public YScrollDetector(WebViewContainer webViewContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webViewContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = webViewContainer;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.a.f35804c = motionEvent.getRawY();
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            WebViewContainer webViewContainer;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (Math.abs(f3) > Math.abs(f2) && (webViewContainer = this.a) != null) {
                    if (f3 > 0.0f) {
                        return webViewContainer.f35808g > 0;
                    } else if (webViewContainer.f35808g < this.a.f35809h) {
                        return this.a.f35808g > 0 || this.a.i != 1;
                    }
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewContainer(Context context) {
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
        this.f35808g = 0;
        this.f35809h = 0;
        this.i = 1;
        g(context);
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.computeScrollOffset()) {
            int e2 = e(this.a.getCurrY());
            scrollBy(0, e2);
            this.f35804c -= e2;
            invalidate();
        }
    }

    public final int e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            int i2 = this.f35808g;
            int i3 = i2 - i;
            if (i3 < 0) {
                this.f35808g = 0;
                return i2;
            }
            int i4 = this.f35809h;
            if (i3 > i4) {
                int i5 = i2 - i4;
                this.f35808g = i4;
                return i5;
            }
            this.f35808g = i2 - i;
            return i;
        }
        return invokeI.intValue;
    }

    public final void f(int i) {
        OverScroller overScroller;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || (overScroller = this.a) == null) {
            return;
        }
        overScroller.fling(0, (int) this.f35804c, 0, i, 0, 0, -500, 10000);
        invalidate();
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.a = new OverScroller(context);
            this.f35805d = new GestureDetector(context, new YScrollDetector(this));
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (this.i == 2) {
                return false;
            }
            if (this.f35808g <= ((int) motionEvent.getY()) && this.f35805d.onTouchEvent(motionEvent)) {
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i, i2, i3, i4) == null) {
            super.onScrollChanged(i, i2, i3, i4);
            OnScrollChangedCallback onScrollChangedCallback = this.f35807f;
            if (onScrollChangedCallback != null) {
                onScrollChangedCallback.onScroll(i - i3, i2 - i4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (this.i == 2) {
                return false;
            }
            if (this.f35808g > ((int) motionEvent.getY())) {
                return false;
            }
            super.onTouchEvent(motionEvent);
            if (this.f35806e == null) {
                this.f35806e = VelocityTracker.obtain();
            }
            this.f35806e.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    this.f35806e.computeCurrentVelocity(1000);
                    int yVelocity = (int) this.f35806e.getYVelocity();
                    if (Math.abs(yVelocity) > 2000 && ((yVelocity > 0 && this.f35808g < this.f35809h) || (yVelocity < 0 && this.f35808g > 0))) {
                        f(-yVelocity);
                    }
                    this.f35806e.recycle();
                    this.f35806e = null;
                } else if (action == 2) {
                    float rawY = motionEvent.getRawY();
                    this.f35803b = rawY;
                    int e2 = e((int) (this.f35804c - rawY));
                    scrollBy(0, e2);
                    this.f35804c -= e2;
                }
            } else if (!this.a.isFinished()) {
                this.a.abortAnimation();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setOnScrollChangeListener(OnScrollChangedCallback onScrollChangedCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onScrollChangedCallback) == null) {
            this.f35807f = onScrollChangedCallback;
        }
    }

    public void setStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.i = i;
        }
    }

    public void setTopLimit(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.f35809h = i;
        }
    }

    public void setTopMargin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.f35808g = i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewContainer(Context context, AttributeSet attributeSet) {
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
        this.f35808g = 0;
        this.f35809h = 0;
        this.i = 1;
        g(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewContainer(Context context, AttributeSet attributeSet, int i) {
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
        this.f35808g = 0;
        this.f35809h = 0;
        this.i = 1;
        g(context);
    }
}
