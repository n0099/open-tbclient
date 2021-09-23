package com.bytedance.sdk.component.utils;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class g extends TouchDelegate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f65548a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f65549b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f65550c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65551d;

    /* renamed from: e  reason: collision with root package name */
    public int f65552e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Rect rect, View view) {
        super(rect, view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rect, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Rect) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65549b = rect;
        this.f65552e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        Rect rect2 = new Rect(rect);
        this.f65550c = rect2;
        int i4 = this.f65552e;
        rect2.inset(-i4, -i4);
        this.f65548a = view;
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z2 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    boolean z3 = this.f65551d;
                    if (z3) {
                        z = this.f65550c.contains(x, y);
                        z2 = z3;
                    } else {
                        z2 = z3;
                    }
                } else {
                    if (action == 3) {
                        boolean z4 = this.f65551d;
                        this.f65551d = false;
                        z2 = z4;
                    }
                    z = true;
                    z2 = false;
                }
                z = true;
            } else if (this.f65549b.contains(x, y)) {
                this.f65551d = true;
                z = true;
            } else {
                this.f65551d = false;
                z = true;
                z2 = false;
            }
            if (z2) {
                View view = this.f65548a;
                if (z) {
                    motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
                } else {
                    float f2 = -(this.f65552e * 2);
                    motionEvent.setLocation(f2, f2);
                }
                if (view.getVisibility() == 0) {
                    return view.dispatchTouchEvent(motionEvent);
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
