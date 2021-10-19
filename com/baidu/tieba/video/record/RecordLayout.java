package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class RecordLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public VelocityTracker f57728e;

    /* renamed from: f  reason: collision with root package name */
    public int f57729f;

    /* renamed from: g  reason: collision with root package name */
    public int f57730g;

    /* renamed from: h  reason: collision with root package name */
    public int f57731h;

    /* renamed from: i  reason: collision with root package name */
    public float f57732i;

    /* renamed from: j  reason: collision with root package name */
    public a f57733j;

    /* loaded from: classes7.dex */
    public interface a {
        void onTouchToLeft();

        void onTouchToRight();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f57730g = ViewConfiguration.getMaximumFlingVelocity();
            this.f57729f = ViewConfiguration.getMinimumFlingVelocity();
            this.f57731h = l.g(getContext(), R.dimen.ds150);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            if (this.f57728e == null) {
                this.f57728e = VelocityTracker.obtain();
            }
            this.f57728e.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action != 0) {
                if ((action == 1 || action == 3) && this.f57733j != null) {
                    this.f57728e.computeCurrentVelocity(1000, this.f57730g);
                    float xVelocity = this.f57728e.getXVelocity();
                    int rawX = (int) (motionEvent.getRawX() - this.f57732i);
                    if (Math.abs(xVelocity) <= this.f57729f || Math.abs(rawX) <= this.f57731h) {
                        if (Math.abs(rawX) > l.k(getContext()) * 0.5d) {
                            if (rawX > 0) {
                                this.f57733j.onTouchToRight();
                            } else {
                                this.f57733j.onTouchToRight();
                            }
                        }
                    } else if (rawX > 0) {
                        this.f57733j.onTouchToRight();
                    } else {
                        this.f57733j.onTouchToLeft();
                    }
                    this.f57728e.clear();
                    this.f57728e.recycle();
                    this.f57728e = null;
                }
            } else {
                this.f57732i = motionEvent.getRawX();
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f57733j = aVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordLayout(Context context, AttributeSet attributeSet) {
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
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a();
    }
}
