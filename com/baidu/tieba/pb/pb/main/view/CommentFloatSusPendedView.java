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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.suspended.TranView;
import com.baidu.tieba.p58;
import com.baidu.tieba.zg5;
import com.baidu.tieba.zi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class CommentFloatSusPendedView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public TranView b;
    public ViewGroup c;
    public zg5 d;
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
    public final CustomMessageListener p;
    public CustomMessageListener q;

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommentFloatSusPendedView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CommentFloatSusPendedView commentFloatSusPendedView, int i) {
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2010045) {
                Object data = customResponsedMessage.getData();
                if (TbadkCoreApplication.getInst().getCurrentActivity() == this.a.getContext() && (data instanceof Boolean)) {
                    this.a.n = !((Boolean) data).booleanValue();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommentFloatSusPendedView a;

        public b(CommentFloatSusPendedView commentFloatSusPendedView) {
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
                commentFloatSusPendedView.t((commentFloatSusPendedView.k * 1.0f) / zi.j(this.a.getContext()));
                CommentFloatSusPendedView commentFloatSusPendedView2 = this.a;
                commentFloatSusPendedView2.m = 1.0f - (commentFloatSusPendedView2.k / zi.j(this.a.getContext()));
                if (this.a.k != 0) {
                    if (this.a.k == zi.j(this.a.getContext())) {
                        this.a.m = 0.0f;
                        if (this.a.h && (this.a.getContext() instanceof Activity)) {
                            ((Activity) this.a.getContext()).finish();
                        }
                    }
                } else {
                    this.a.m = 1.0f;
                }
                this.a.requestLayout();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommentFloatSusPendedView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CommentFloatSusPendedView commentFloatSusPendedView, int i) {
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
            p58 p58Var;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof p58) || (p58Var = (p58) customResponsedMessage.getData()) == null) {
                return;
            }
            this.a.m = p58Var.d;
            this.a.e = p58Var.b;
            this.a.f = p58Var.a;
            this.a.k = p58Var.c;
            this.a.h = p58Var.e;
            CommentFloatSusPendedView commentFloatSusPendedView = this.a;
            commentFloatSusPendedView.t((commentFloatSusPendedView.f - this.a.e) / zi.j(this.a.getContext()));
            if (this.a.f > this.a.e) {
                z = true;
            } else {
                z = false;
            }
            if (this.a.h) {
                this.a.j.setIntValues((int) (this.a.f - this.a.e), zi.j(this.a.getContext()));
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

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
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
        this.p = new a(this, 2010045);
        this.q = new c(this, 2921597);
        this.l = zi.j(context) / 10;
        this.k = zi.j(context);
        MessageManager.getInstance().registerListener(this.q);
        ValueAnimator ofInt = ValueAnimator.ofInt(zi.j(context), 0);
        this.j = ofInt;
        ofInt.setDuration(300L);
        this.j.setInterpolator(new LinearInterpolator());
        this.j.addUpdateListener(new b(this));
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

    public void setContentViewTop(zg5 zg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, zg5Var) == null) {
            this.d = zg5Var;
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
            n();
        }
    }

    public final void t(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048593, this, f) == null) {
            CustomMessage customMessage = new CustomMessage(2921594);
            customMessage.setTag(this.o);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921594, Float.valueOf(f));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
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
        boolean z2;
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
                                if (this.e == 0.0f && o()) {
                                    this.e = motionEvent.getRawY();
                                }
                                if (o() && !this.h) {
                                    t((this.f - this.e) / zi.j(getContext()));
                                }
                                this.m = 1.0f - ((this.f - this.e) / zi.j(getContext()));
                            }
                        }
                        this.g = false;
                        if (this.f > this.e && o()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (this.f - this.e > this.l && o()) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        this.h = z2;
                        if (z2) {
                            this.j.setIntValues((int) (this.f - this.e), zi.j(getContext()));
                            this.j.setDuration(300L);
                            this.j.start();
                        } else {
                            t(0.0f);
                            this.m = 1.0f;
                            this.e = 0.0f;
                            this.f = 0.0f;
                            requestLayout();
                        }
                        if (this.g && (this.f <= this.e || !o())) {
                            if (z) {
                                this.g = true;
                                return true;
                            }
                            this.g = false;
                            return super.dispatchTouchEvent(motionEvent);
                        }
                        this.g = true;
                        requestLayout();
                        return true;
                    }
                    this.f = motionEvent.getRawY();
                    if (o()) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.p.setTag(this.o);
            MessageManager.getInstance().registerListener(this.p);
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            zg5 zg5Var = this.d;
            if (zg5Var == null) {
                return false;
            }
            return zg5Var.t();
        }
        return invokeV.booleanValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.q);
            this.j.cancel();
            this.j.removeAllUpdateListeners();
            clearAnimation();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.m == 0.0f) {
            this.j.setDuration(300L);
            this.j.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (this.j == null) {
                super.onLayout(z, i, i2, i3, i4);
                return;
            }
            int i5 = this.k;
            if (i5 == 0) {
                super.onLayout(z, i, i2, i3, i4);
                float f = this.f;
                float f2 = this.e;
                if (f > f2 && this.g) {
                    LinearLayout linearLayout = this.a;
                    linearLayout.layout(i, (int) (f - f2), i3, ((int) (f - f2)) + linearLayout.getHeight());
                    this.c.layout(i, ((int) (this.f - this.e)) + this.a.getHeight(), i3, i4);
                    return;
                }
                return;
            }
            LinearLayout linearLayout2 = this.a;
            linearLayout2.layout(i, i5, i3, linearLayout2.getMeasuredHeight() + i5);
            this.c.layout(i, this.k + this.a.getMeasuredHeight(), i3, i4);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.h = true;
            this.j.setIntValues(0, zi.j(getContext()));
            this.j.setDuration(300L);
            this.j.start();
        }
    }
}
