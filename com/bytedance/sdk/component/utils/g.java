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
/* loaded from: classes5.dex */
public class g extends TouchDelegate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f28991a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f28992b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f28993c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f28994d;

    /* renamed from: e  reason: collision with root package name */
    public int f28995e;

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
        this.f28992b = rect;
        this.f28995e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        Rect rect2 = new Rect(rect);
        this.f28993c = rect2;
        int i4 = this.f28995e;
        rect2.inset(-i4, -i4);
        this.f28991a = view;
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
                    boolean z3 = this.f28994d;
                    if (z3) {
                        z = this.f28993c.contains(x, y);
                        z2 = z3;
                    } else {
                        z2 = z3;
                    }
                } else {
                    if (action == 3) {
                        boolean z4 = this.f28994d;
                        this.f28994d = false;
                        z2 = z4;
                    }
                    z = true;
                    z2 = false;
                }
                z = true;
            } else if (this.f28992b.contains(x, y)) {
                this.f28994d = true;
                z = true;
            } else {
                this.f28994d = false;
                z = true;
                z2 = false;
            }
            if (z2) {
                View view = this.f28991a;
                if (z) {
                    motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
                } else {
                    float f2 = -(this.f28995e * 2);
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
