package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.MotionEventCompat;
import androidx.customview.widget.ViewDragHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class EmotionEditLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ViewDragHelper f19922e;

    /* renamed from: f  reason: collision with root package name */
    public float f19923f;

    /* renamed from: g  reason: collision with root package name */
    public float f19924g;

    /* renamed from: h  reason: collision with root package name */
    public float f19925h;

    /* renamed from: i  reason: collision with root package name */
    public long f19926i;

    /* loaded from: classes5.dex */
    public class a extends ViewDragHelper.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionEditText f19927a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EmotionEditLayout f19928b;

        public a(EmotionEditLayout emotionEditLayout, EmotionEditText emotionEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionEditLayout, emotionEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19928b = emotionEditLayout;
            this.f19927a = emotionEditText;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, view, i2, i3)) == null) ? Math.min(Math.max(i2, this.f19928b.getPaddingLeft()), this.f19928b.getWidth() - this.f19927a.getWidth()) : invokeLII.intValue;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2, i3)) == null) ? Math.min(Math.max(i2, this.f19928b.getPaddingTop()), this.f19928b.getHeight() - this.f19927a.getHeight()) : invokeLII.intValue;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view, i2) == null) {
                super.onViewCaptured(view, i2);
                if (view instanceof EmotionEditText) {
                    this.f19928b.f19926i = System.currentTimeMillis();
                    this.f19928b.f19924g = view.getX();
                    this.f19928b.f19925h = view.getY();
                    this.f19927a.m();
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                super.onViewReleased(view, f2, f3);
                if (view instanceof EmotionEditText) {
                    float x = view.getX();
                    float y = view.getY();
                    float abs = Math.abs(x - this.f19928b.f19924g);
                    float abs2 = Math.abs(y - this.f19928b.f19925h);
                    if (abs < this.f19928b.f19923f && abs2 < this.f19928b.f19923f && System.currentTimeMillis() - this.f19928b.f19926i < 300) {
                        this.f19927a.u();
                    }
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(view.getLeft(), view.getTop(), 0, 0);
                    this.f19927a.setLayoutParams(layoutParams);
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, view, i2)) == null) {
                boolean z = view == this.f19927a;
                if (view instanceof ImageView) {
                    this.f19927a.m();
                }
                return z;
            }
            return invokeLI.booleanValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmotionEditLayout(Context context) {
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

    public void h(EmotionEditText emotionEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, emotionEditText) == null) {
            this.f19922e = ViewDragHelper.create(this, 1.0f, new a(this, emotionEditText));
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (actionMasked != 3 && actionMasked != 1) {
                return this.f19922e.shouldInterceptTouchEvent(motionEvent);
            }
            this.f19922e.cancel();
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            this.f19922e.processTouchEvent(motionEvent);
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmotionEditLayout(Context context, AttributeSet attributeSet) {
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
    public EmotionEditLayout(Context context, AttributeSet attributeSet, int i2) {
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
        this.f19923f = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
