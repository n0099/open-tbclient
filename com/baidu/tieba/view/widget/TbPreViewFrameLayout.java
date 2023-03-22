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
import com.baidu.tieba.hi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class TbPreViewFrameLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public c f;
    public a g;
    public boolean h;
    public boolean i;
    public float j;
    public float k;
    public float l;
    public float m;

    /* loaded from: classes6.dex */
    public interface a {
        int[] a();
    }

    /* loaded from: classes6.dex */
    public interface b {
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(MotionEvent motionEvent);

        void b(MotionEvent motionEvent);

        void c(MotionEvent motionEvent);

        void d(MotionEvent motionEvent);
    }

    public void setOnViewChangedListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbPreViewFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = 0.7f;
        this.b = 300.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.h = true;
        this.i = true;
        this.e = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public float getContainerBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.m;
        }
        return invokeV.floatValue;
    }

    public float getContainerHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.m - this.l;
        }
        return invokeV.floatValue;
    }

    public float getContainerLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.j;
        }
        return invokeV.floatValue;
    }

    public float getContainerRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return invokeV.floatValue;
    }

    public float getContainerTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.l;
        }
        return invokeV.floatValue;
    }

    public float getContainerWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return Math.round(this.k - this.j);
        }
        return invokeV.floatValue;
    }

    public float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a;
        }
        return invokeV.floatValue;
    }

    public float getTranslate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return invokeV.floatValue;
    }

    public int[] getFullRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int l = hi.l(getContext());
            int j = hi.j(getContext());
            a aVar = this.g;
            int[] a2 = aVar != null ? aVar.a() : new int[]{hi.l(getContext()), hi.j(getContext())};
            a2[0] = Math.min(l, a2[0]);
            a2[1] = Math.min(j, a2[1]);
            return a2;
        }
        return (int[]) invokeV.objValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        c cVar;
        c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            if (!this.h) {
                return super.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    if (Math.abs(this.c - motionEvent.getX()) > this.e && (this.c - motionEvent.getX()) - 50.0f > Math.abs(this.d - motionEvent.getY()) && this.i) {
                        c cVar3 = this.f;
                        if (cVar3 != null) {
                            cVar3.b(motionEvent);
                        }
                    } else if (Math.abs(this.c - motionEvent.getX()) > this.e && (motionEvent.getX() - this.c) - 50.0f > Math.abs(this.d - motionEvent.getY()) && this.i && (cVar = this.f) != null) {
                        cVar.a(motionEvent);
                    }
                    if (Math.abs(this.c - motionEvent.getX()) < 30.0f && Math.abs(this.d - motionEvent.getY()) < 30.0f && motionEvent.getY() <= hi.j(getContext()) * 0.6d && (cVar2 = this.f) != null) {
                        cVar2.c(motionEvent);
                    }
                }
            } else {
                this.c = motionEvent.getX();
                this.d = motionEvent.getY();
                c cVar4 = this.f;
                if (cVar4 != null) {
                    cVar4.d(motionEvent);
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setCanDrag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.i = z;
        }
    }

    public void setCanTouch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.h = z;
        }
    }

    public void setOnVideoViewRectCallback(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.g = aVar;
        }
    }

    public void setOnViewDragListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.f = cVar;
        }
    }

    public void setScale(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048591, this, f) == null) {
            this.a = f;
        }
    }

    public void setTranslate(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f) == null) {
            this.b = f;
        }
    }
}
