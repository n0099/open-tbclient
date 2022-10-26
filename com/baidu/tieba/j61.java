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
/* loaded from: classes4.dex */
public class j61 extends TouchDelegate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map a;

    /* loaded from: classes4.dex */
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

        public a(j61 j61Var, Rect rect, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j61Var, rect, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
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
    public j61(View view2, int i, int i2, int i3, int i4) {
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
            for (Map.Entry entry : this.a.entrySet()) {
                View view2 = (View) entry.getKey();
                int[] iArr = new int[2];
                view2.getLocationOnScreen(iArr);
                int measuredWidth = view2.getMeasuredWidth();
                int measuredHeight = view2.getMeasuredHeight();
                a aVar = (a) entry.getValue();
                Rect rect = aVar.a;
                rect.left = iArr[0] - aVar.b;
                rect.right = iArr[0] + measuredWidth + aVar.c;
                rect.top = iArr[1] - aVar.d;
                rect.bottom = iArr[1] + measuredHeight + aVar.e;
                aVar.f = ViewConfiguration.get(view2.getContext()).getScaledTouchSlop();
                Rect rect2 = new Rect(aVar.a);
                aVar.g = rect2;
                int i = aVar.f;
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
            for (Map.Entry entry : this.a.entrySet()) {
                View view2 = (View) entry.getKey();
                if (view2.getVisibility() != 0) {
                    break;
                }
                a aVar = (a) entry.getValue();
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1 && action != 2) {
                        if (action == 3) {
                            z2 = aVar.h;
                            aVar.h = false;
                        }
                    } else {
                        z2 = aVar.h;
                        if (z2 && !aVar.g.contains(rawX, rawY)) {
                            z3 = false;
                        }
                    }
                } else if (aVar.a.contains(rawX, rawY)) {
                    aVar.h = true;
                    z2 = true;
                } else {
                    aVar.h = false;
                    z2 = false;
                }
                if (z2) {
                    if (z3) {
                        motionEvent.setLocation(view2.getWidth() / 2, view2.getHeight() / 2);
                    } else {
                        float f = -(aVar.f * 2);
                        motionEvent.setLocation(f, f);
                    }
                    z = view2.dispatchTouchEvent(motionEvent);
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
