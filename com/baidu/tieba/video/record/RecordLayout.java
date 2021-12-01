package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import c.a.d.f.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class RecordLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public VelocityTracker f49776e;

    /* renamed from: f  reason: collision with root package name */
    public int f49777f;

    /* renamed from: g  reason: collision with root package name */
    public int f49778g;

    /* renamed from: h  reason: collision with root package name */
    public int f49779h;

    /* renamed from: i  reason: collision with root package name */
    public float f49780i;

    /* renamed from: j  reason: collision with root package name */
    public a f49781j;

    /* loaded from: classes11.dex */
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
            this.f49778g = ViewConfiguration.getMaximumFlingVelocity();
            this.f49777f = ViewConfiguration.getMinimumFlingVelocity();
            this.f49779h = l.f(getContext(), R.dimen.ds150);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            if (this.f49776e == null) {
                this.f49776e = VelocityTracker.obtain();
            }
            this.f49776e.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action != 0) {
                if ((action == 1 || action == 3) && this.f49781j != null) {
                    this.f49776e.computeCurrentVelocity(1000, this.f49778g);
                    float xVelocity = this.f49776e.getXVelocity();
                    int rawX = (int) (motionEvent.getRawX() - this.f49780i);
                    if (Math.abs(xVelocity) <= this.f49777f || Math.abs(rawX) <= this.f49779h) {
                        if (Math.abs(rawX) > l.k(getContext()) * 0.5d) {
                            if (rawX > 0) {
                                this.f49781j.onTouchToRight();
                            } else {
                                this.f49781j.onTouchToRight();
                            }
                        }
                    } else if (rawX > 0) {
                        this.f49781j.onTouchToRight();
                    } else {
                        this.f49781j.onTouchToLeft();
                    }
                    this.f49776e.clear();
                    this.f49776e.recycle();
                    this.f49776e = null;
                }
            } else {
                this.f49780i = motionEvent.getRawX();
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f49781j = aVar;
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
