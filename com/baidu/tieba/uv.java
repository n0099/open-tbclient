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
public class uv extends TouchDelegate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map a;

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Rect a;
        public int b;
        public int c;
        public int d;
        public int e;
        public Rect f;
        public boolean g;

        public a(uv uvVar, Rect rect, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uvVar, rect, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
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
            this.c = i3;
            this.d = i4;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uv(View view2, int i, int i2, int i3, int i4, Rect rect) {
        super(rect, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), rect};
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
        b(view2, i, i2, i3, i4);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (Map.Entry entry : this.a.entrySet()) {
                View view2 = (View) entry.getKey();
                a aVar = (a) entry.getValue();
                view2.getGlobalVisibleRect(aVar.a);
                Rect rect = aVar.a;
                int i = rect.left;
                int i2 = aVar.b;
                rect.left = i - i2;
                rect.right += aVar.c;
                rect.top -= i2;
                rect.bottom += aVar.d;
                aVar.e = ViewConfiguration.get(view2.getContext()).getScaledTouchSlop();
                Rect rect2 = new Rect(aVar.a);
                aVar.f = rect2;
                int i3 = aVar.e;
                rect2.inset(-i3, -i3);
            }
        }
    }

    public void b(View view2, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.a.put(view2, new a(this, new Rect(), i, i2, i3, i4));
        }
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            a();
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
                            z2 = aVar.g;
                            aVar.g = false;
                        }
                    } else {
                        z2 = aVar.g;
                        if (z2 && !aVar.f.contains(rawX, rawY)) {
                            z3 = false;
                        }
                    }
                } else if (aVar.a.contains(rawX, rawY)) {
                    aVar.g = true;
                    z2 = true;
                } else {
                    aVar.g = false;
                    z2 = false;
                }
                if (z2) {
                    if (z3) {
                        motionEvent.setLocation(view2.getWidth() / 2, view2.getHeight() / 2);
                    } else {
                        float f = -(aVar.e * 2);
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
