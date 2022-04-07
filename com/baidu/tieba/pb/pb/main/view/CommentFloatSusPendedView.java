package com.baidu.tieba.pb.pb.main.view;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.suspended.TranView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.h95;
import com.repackage.oi;
import com.repackage.ps7;
/* loaded from: classes3.dex */
public class CommentFloatSusPendedView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public TranView b;
    public ViewGroup c;
    public h95 d;
    public float e;
    public float f;
    public boolean g;
    public boolean h;
    public boolean i;
    public ValueAnimator j;
    public int k;
    public int l;
    public float m;
    public boolean n;
    public BdUniqueId o;
    public CustomMessageListener p;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommentFloatSusPendedView a;

        public a(CommentFloatSusPendedView commentFloatSusPendedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commentFloatSusPendedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commentFloatSusPendedView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.k = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                CommentFloatSusPendedView commentFloatSusPendedView = this.a;
                commentFloatSusPendedView.r((commentFloatSusPendedView.k * 1.0f) / oi.i(this.a.getContext()));
                CommentFloatSusPendedView commentFloatSusPendedView2 = this.a;
                commentFloatSusPendedView2.m = 1.0f - (commentFloatSusPendedView2.k / oi.i(this.a.getContext()));
                if (this.a.k == 0) {
                    this.a.m = 1.0f;
                } else if (this.a.k == oi.i(this.a.getContext())) {
                    this.a.m = 0.0f;
                    if (this.a.h && (this.a.getContext() instanceof Activity)) {
                        ((Activity) this.a.getContext()).finish();
                    }
                }
                this.a.requestLayout();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommentFloatSusPendedView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CommentFloatSusPendedView commentFloatSusPendedView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commentFloatSusPendedView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commentFloatSusPendedView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ps7 ps7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof ps7) || (ps7Var = (ps7) customResponsedMessage.getData()) == null) {
                return;
            }
            this.a.m = ps7Var.d;
            this.a.e = ps7Var.b;
            this.a.f = ps7Var.a;
            this.a.k = ps7Var.c;
            this.a.h = ps7Var.e;
            CommentFloatSusPendedView commentFloatSusPendedView = this.a;
            commentFloatSusPendedView.r((commentFloatSusPendedView.f - this.a.e) / oi.i(this.a.getContext()));
            boolean z = this.a.f > this.a.e;
            if (this.a.h) {
                this.a.j.setIntValues((int) (this.a.f - this.a.e), oi.i(this.a.getContext()));
                this.a.j.setDuration(0L);
                this.a.j.start();
            }
            if (this.a.f > this.a.e) {
                this.a.g = true;
            } else {
                this.a.g = z;
            }
            this.a.requestLayout();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommentFloatSusPendedView(Context context) {
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

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0032, code lost:
        if (r0 != 3) goto L22;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (this.b != null && this.n) {
                if (this.j.isRunning()) {
                    this.j.end();
                    return true;
                } else if (this.h) {
                    return true;
                } else {
                    int action = motionEvent.getAction();
                    if (action != 0) {
                        if (action != 1) {
                            if (action == 2) {
                                this.f = motionEvent.getRawY();
                                if (this.e == 0.0f && m()) {
                                    this.e = motionEvent.getRawY();
                                }
                                if (m() && !this.h) {
                                    r((this.f - this.e) / oi.i(getContext()));
                                }
                                this.m = 1.0f - ((this.f - this.e) / oi.i(getContext()));
                            }
                        }
                        this.g = false;
                        z = this.f > this.e && m();
                        boolean z2 = this.f - this.e > ((float) this.l) && m();
                        this.h = z2;
                        if (z2) {
                            this.j.setIntValues((int) (this.f - this.e), oi.i(getContext()));
                            this.j.setDuration(300L);
                            this.j.start();
                        } else {
                            r(0.0f);
                            this.m = 1.0f;
                            this.e = 0.0f;
                            this.f = 0.0f;
                            requestLayout();
                        }
                        if (!this.g || (this.f > this.e && m())) {
                            this.g = true;
                            requestLayout();
                            return true;
                        } else if (z) {
                            this.g = true;
                            return true;
                        } else {
                            this.g = false;
                            return super.dispatchTouchEvent(motionEvent);
                        }
                    }
                    this.f = motionEvent.getRawY();
                    if (m()) {
                        this.e = motionEvent.getRawY();
                    } else {
                        this.e = 0.0f;
                    }
                    z = false;
                    if (this.g) {
                    }
                    this.g = true;
                    requestLayout();
                    return true;
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public boolean getIsFinish() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            h95 h95Var = this.d;
            if (h95Var == null) {
                return false;
            }
            return h95Var.isOnViewTop();
        }
        return invokeV.booleanValue;
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.p);
            this.j.cancel();
            this.j.removeAllUpdateListeners();
            clearAnimation();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            if (!this.i) {
                float f = this.m;
                if (f >= 0.0f && this.b != null) {
                    canvas.drawColor(Color.argb((int) (f * 168.0f), 0, 0, 0), PorterDuff.Mode.SRC);
                }
            } else {
                canvas.drawColor(Color.argb(0, 255, 255, 255), PorterDuff.Mode.CLEAR);
            }
            super.onDraw(canvas);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (this.j == null) {
                super.onLayout(z, i, i2, i3, i4);
                return;
            }
            int i5 = this.k;
            if (i5 == 0) {
                super.onLayout(z, i, i2, i3, i4);
                float f = this.f;
                float f2 = this.e;
                if (f <= f2 || !this.g) {
                    return;
                }
                LinearLayout linearLayout = this.a;
                linearLayout.layout(i, (int) (f - f2), i3, ((int) (f - f2)) + linearLayout.getHeight());
                this.c.layout(i, ((int) (this.f - this.e)) + this.a.getHeight(), i3, i4);
                return;
            }
            LinearLayout linearLayout2 = this.a;
            linearLayout2.layout(i, i5, i3, linearLayout2.getMeasuredHeight() + i5);
            this.c.layout(i, this.k + this.a.getMeasuredHeight(), i3, i4);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.h = true;
            this.j.setIntValues(0, oi.i(getContext()));
            this.j.setDuration(300L);
            this.j.start();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.m == 0.0f) {
            this.j.setDuration(300L);
            this.j.start();
        }
    }

    public final void r(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f) == null) {
            CustomMessage customMessage = new CustomMessage(2921594);
            customMessage.setTag(this.o);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921594, Float.valueOf(f));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void setCanDragClose(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.n = z;
        }
    }

    public void setContentView(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, viewGroup) == null) {
            this.c = viewGroup;
        }
    }

    public void setContentViewTop(h95 h95Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, h95Var) == null) {
            this.d = h95Var;
        }
    }

    public void setIsNoBgColor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.i = z;
        }
    }

    public void setNavigationBar(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, linearLayout) == null) {
            this.a = linearLayout;
        }
    }

    public void setTranView(TranView tranView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, tranView) == null) {
            this.b = tranView;
        }
    }

    public void setVideoPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bdUniqueId) == null) {
            this.o = bdUniqueId;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommentFloatSusPendedView(Context context, @Nullable AttributeSet attributeSet) {
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
    public CommentFloatSusPendedView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.m = 0.0f;
        this.n = true;
        this.p = new b(this, 2921597);
        this.l = oi.i(context) / 10;
        this.k = oi.i(context);
        MessageManager.getInstance().registerListener(this.p);
        ValueAnimator ofInt = ValueAnimator.ofInt(oi.i(context), 0);
        this.j = ofInt;
        ofInt.setDuration(300L);
        this.j.setInterpolator(new LinearInterpolator());
        this.j.addUpdateListener(new a(this));
    }
}
