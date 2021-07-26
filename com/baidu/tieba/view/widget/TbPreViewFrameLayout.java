package com.baidu.tieba.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
/* loaded from: classes4.dex */
public class TbPreViewFrameLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f22546e;

    /* renamed from: f  reason: collision with root package name */
    public float f22547f;

    /* renamed from: g  reason: collision with root package name */
    public float f22548g;

    /* renamed from: h  reason: collision with root package name */
    public float f22549h;

    /* renamed from: i  reason: collision with root package name */
    public float f22550i;
    public c j;
    public a k;
    public boolean l;
    public boolean m;
    public float n;
    public float o;
    public float p;
    public float q;

    /* loaded from: classes4.dex */
    public interface a {
        int[] a();
    }

    /* loaded from: classes4.dex */
    public interface b {
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(MotionEvent motionEvent);

        void b(MotionEvent motionEvent);

        void c(MotionEvent motionEvent);

        void d(MotionEvent motionEvent);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbPreViewFrameLayout(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public float getContainerBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.q : invokeV.floatValue;
    }

    public float getContainerHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.q - this.p : invokeV.floatValue;
    }

    public float getContainerLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.n : invokeV.floatValue;
    }

    public float getContainerRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.o : invokeV.floatValue;
    }

    public float getContainerTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.p : invokeV.floatValue;
    }

    public float getContainerWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Math.round(this.o - this.n) : invokeV.floatValue;
    }

    public int[] getFullRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int k = l.k(getContext());
            int i2 = l.i(getContext());
            a aVar = this.k;
            int[] a2 = aVar != null ? aVar.a() : new int[]{l.k(getContext()), l.i(getContext())};
            a2[0] = Math.min(k, a2[0]);
            a2[1] = Math.min(i2, a2[1]);
            return a2;
        }
        return (int[]) invokeV.objValue;
    }

    public float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f22546e : invokeV.floatValue;
    }

    public float getTranslate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f22547f : invokeV.floatValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        c cVar;
        c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            if (!this.l) {
                return super.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f22548g = motionEvent.getX();
                this.f22549h = motionEvent.getY();
                c cVar3 = this.j;
                if (cVar3 != null) {
                    cVar3.d(motionEvent);
                }
            } else if (action == 1 || action == 3) {
                if (Math.abs(this.f22548g - motionEvent.getX()) > this.f22550i && (this.f22548g - motionEvent.getX()) - 50.0f > Math.abs(this.f22549h - motionEvent.getY()) && this.m) {
                    c cVar4 = this.j;
                    if (cVar4 != null) {
                        cVar4.b(motionEvent);
                    }
                } else if (Math.abs(this.f22548g - motionEvent.getX()) > this.f22550i && (motionEvent.getX() - this.f22548g) - 50.0f > Math.abs(this.f22549h - motionEvent.getY()) && this.m && (cVar = this.j) != null) {
                    cVar.a(motionEvent);
                }
                if (Math.abs(this.f22548g - motionEvent.getX()) < 30.0f && Math.abs(this.f22549h - motionEvent.getY()) < 30.0f && motionEvent.getY() <= l.i(getContext()) * 0.6d && (cVar2 = this.j) != null) {
                    cVar2.c(motionEvent);
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setCanDrag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.m = z;
        }
    }

    public void setCanTouch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.l = z;
        }
    }

    public void setOnVideoViewRectCallback(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.k = aVar;
        }
    }

    public void setOnViewChangedListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
        }
    }

    public void setOnViewDragListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.j = cVar;
        }
    }

    public void setScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048591, this, f2) == null) {
            this.f22546e = f2;
        }
    }

    public void setTranslate(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.f22547f = f2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbPreViewFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbPreViewFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f22546e = 0.7f;
        this.f22547f = 300.0f;
        this.f22548g = 0.0f;
        this.f22549h = 0.0f;
        this.l = true;
        this.m = true;
        this.f22550i = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
