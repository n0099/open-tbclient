package com.baidu.tieba.immessagecenter.chatgroup.utility;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hd8;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class GroupChatKeyboardLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final Rect b;
    public int c;
    public int d;
    public int e;
    public int f;
    public final int g;
    public final int h;
    public boolean i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GroupChatKeyboardLayout(Context context) {
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
    public GroupChatKeyboardLayout(Context context, @Nullable AttributeSet attributeSet) {
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

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            a();
            View findViewById = findViewById(this.g);
            View findViewById2 = findViewById(this.h);
            if (findViewById != null && findViewById2 != null) {
                measureChildren(i, i2);
                int measuredHeight = findViewById.getMeasuredHeight();
                int measuredHeight2 = findViewById2.getMeasuredHeight();
                if (this.i) {
                    i3 = this.e;
                } else {
                    i3 = this.f;
                }
                int i5 = this.b.bottom;
                if (this.i) {
                    i4 = this.c;
                } else {
                    i4 = this.d;
                }
                int i6 = (i5 - i4) - this.b.top;
                int i7 = measuredHeight + measuredHeight2 + i3;
                if (i7 < i6) {
                    i6 = i7;
                }
                measureChild(findViewById, i, View.MeasureSpec.makeMeasureSpec((i6 - measuredHeight2) - i3, 1073741824));
                super.onMeasure(i, i2);
                return;
            }
            super.onMeasure(i, i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupChatKeyboardLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.b = new Rect();
        xi.j(getContext());
        TypedArray typedArray = null;
        try {
            typedArray = context.obtainStyledAttributes(attributeSet, hd8.GroupChatKeyboardLayout, 0, 0);
            this.g = typedArray.getResourceId(1, -1);
            this.h = typedArray.getResourceId(0, -1);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (getContext() instanceof Activity)) {
            Activity activity = (Activity) getContext();
            if (activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
                activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.b);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(this.a);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.a = z;
        }
    }

    public void setIsKeyboardOn(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048582, this, z) != null) || this.i == z) {
            return;
        }
        this.i = z;
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            a();
            View findViewById = findViewById(this.g);
            View findViewById2 = findViewById(this.h);
            if (findViewById != null && findViewById2 != null) {
                int measuredHeight = findViewById.getMeasuredHeight();
                int measuredHeight2 = findViewById2.getMeasuredHeight();
                if (this.i) {
                    i5 = this.e;
                } else {
                    i5 = this.f;
                }
                Rect rect = this.b;
                int i6 = rect.left;
                int i7 = rect.bottom;
                findViewById.layout(i6, ((i7 - measuredHeight2) - i5) - measuredHeight, rect.right, (i7 - measuredHeight2) - i5);
                Rect rect2 = this.b;
                int i8 = rect2.left;
                int i9 = rect2.bottom;
                findViewById2.layout(i8, (i9 - measuredHeight2) - i5, rect2.right, i9 - i5);
            }
        }
    }

    public void setBlank(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i, i2, i3, i4) == null) {
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }
    }
}
