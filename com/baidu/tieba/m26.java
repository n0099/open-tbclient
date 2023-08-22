package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class m26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public int c;
    public float d;
    public float e;
    public float f;
    public int g;
    public VelocityTracker h;
    @NonNull
    public ViewGroup i;
    public boolean j;

    public m26(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = -1;
        this.j = true;
        this.i = viewGroup;
        this.c = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(viewGroup.getContext()));
    }

    public final void b(MotionEvent motionEvent) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) {
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.g) {
                if (actionIndex == 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                this.d = MotionEventCompat.getY(motionEvent, i);
                this.g = MotionEventCompat.getPointerId(motionEvent, i);
                VelocityTracker velocityTracker = this.h;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
            }
        }
    }

    @SuppressLint({"LongLogTag"})
    public boolean a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        float f;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action != 3 && action != 1) {
                if (action != 0) {
                    if (this.a) {
                        return true;
                    }
                    if (this.b) {
                        return false;
                    }
                }
                if (action != 0) {
                    if (action != 2) {
                        if (action == 6) {
                            b(motionEvent);
                        }
                    } else {
                        int i = this.g;
                        if (i != -1) {
                            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
                            if (findPointerIndex >= 0 && findPointerIndex < motionEvent.getPointerCount()) {
                                float y = MotionEventCompat.getY(motionEvent, findPointerIndex) - this.d;
                                float abs = Math.abs(y);
                                float abs2 = Math.abs(MotionEventCompat.getX(motionEvent, findPointerIndex) - this.e);
                                if (this.j) {
                                    f = 0.5f;
                                } else {
                                    f = 3.0f;
                                }
                                if (abs > this.c && abs * f > abs2) {
                                    this.a = true;
                                    c(true);
                                    if (y > 0.0f) {
                                        f2 = this.f + this.c;
                                    } else {
                                        f2 = this.f - this.c;
                                    }
                                    this.d = f2;
                                } else if (abs2 > this.c) {
                                    this.b = true;
                                }
                            } else {
                                this.a = false;
                            }
                        }
                    }
                } else {
                    this.e = motionEvent.getX();
                    float y2 = motionEvent.getY();
                    this.f = y2;
                    this.d = y2;
                    this.g = MotionEventCompat.getPointerId(motionEvent, 0);
                    this.b = false;
                    this.a = false;
                }
                if (this.h == null) {
                    this.h = VelocityTracker.obtain();
                }
                this.h.addMovement(motionEvent);
                return this.a;
            }
            this.a = false;
            this.b = false;
            this.g = -1;
            VelocityTracker velocityTracker = this.h;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.h = null;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void c(boolean z) {
        ViewParent parent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && (parent = this.i.getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.j = z;
        }
    }
}
