package com.baidu.tieba;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class rb1 extends TouchDelegate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<View, a> a;

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Rect a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public Rect g;
        public boolean h;

        public a(rb1 rb1Var, Rect rect, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rb1Var, rect, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i;
            this.a = rect;
            this.d = i2;
            this.c = i3;
            this.e = i4;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rb1(View view2, int i, int i2, int i3, int i4) {
        super(new Rect(), view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Rect) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        a(view2, i, i2, i3, i4);
    }

    public void a(View view2, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.a.put(view2, new a(this, new Rect(), i, i2, i3, i4));
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (Map.Entry<View, a> entry : this.a.entrySet()) {
                View key = entry.getKey();
                int[] iArr = new int[2];
                key.getLocationOnScreen(iArr);
                int measuredWidth = key.getMeasuredWidth();
                int measuredHeight = key.getMeasuredHeight();
                a value = entry.getValue();
                Rect rect = value.a;
                rect.left = iArr[0] - value.b;
                rect.right = iArr[0] + measuredWidth + value.c;
                rect.top = iArr[1] - value.d;
                rect.bottom = iArr[1] + measuredHeight + value.e;
                value.f = ViewConfiguration.get(key.getContext()).getScaledTouchSlop();
                Rect rect2 = new Rect(value.a);
                value.g = rect2;
                int i = value.f;
                rect2.inset(-i, -i);
            }
        }
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            b();
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = true;
            for (Map.Entry<View, a> entry : this.a.entrySet()) {
                View key = entry.getKey();
                if (key.getVisibility() != 0) {
                    break;
                }
                a value = entry.getValue();
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1 && action != 2) {
                        if (action == 3) {
                            z2 = value.h;
                            value.h = false;
                        }
                    } else {
                        z2 = value.h;
                        if (z2 && !value.g.contains(rawX, rawY)) {
                            z3 = false;
                        }
                    }
                } else if (value.a.contains(rawX, rawY)) {
                    value.h = true;
                    z2 = true;
                } else {
                    value.h = false;
                    z2 = false;
                }
                if (z2) {
                    if (z3) {
                        motionEvent.setLocation(key.getWidth() / 2, key.getHeight() / 2);
                    } else {
                        float f = -(value.f * 2);
                        motionEvent.setLocation(f, f);
                    }
                    z = key.dispatchTouchEvent(motionEvent);
                    continue;
                }
                if (z) {
                    break;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
