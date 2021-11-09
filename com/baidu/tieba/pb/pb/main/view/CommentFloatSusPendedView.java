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
import b.a.e.e.p.l;
import b.a.r0.k2.r.t;
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
/* loaded from: classes9.dex */
public class CommentFloatSusPendedView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f52523e;

    /* renamed from: f  reason: collision with root package name */
    public TranView f52524f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f52525g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.q0.x0.a f52526h;

    /* renamed from: i  reason: collision with root package name */
    public float f52527i;
    public float j;
    public boolean k;
    public boolean l;
    public boolean m;
    public ValueAnimator n;
    public int o;
    public int p;
    public float q;
    public boolean r;
    public BdUniqueId s;
    public CustomMessageListener t;

    /* loaded from: classes9.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommentFloatSusPendedView f52528e;

        public a(CommentFloatSusPendedView commentFloatSusPendedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commentFloatSusPendedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52528e = commentFloatSusPendedView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f52528e.o = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                CommentFloatSusPendedView commentFloatSusPendedView = this.f52528e;
                commentFloatSusPendedView.m((commentFloatSusPendedView.o * 1.0f) / l.i(this.f52528e.getContext()));
                CommentFloatSusPendedView commentFloatSusPendedView2 = this.f52528e;
                commentFloatSusPendedView2.q = 1.0f - (commentFloatSusPendedView2.o / l.i(this.f52528e.getContext()));
                if (this.f52528e.o == 0) {
                    this.f52528e.q = 1.0f;
                } else if (this.f52528e.o == l.i(this.f52528e.getContext())) {
                    this.f52528e.q = 0.0f;
                    if (this.f52528e.l && (this.f52528e.getContext() instanceof Activity)) {
                        ((Activity) this.f52528e.getContext()).finish();
                    }
                }
                this.f52528e.requestLayout();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommentFloatSusPendedView f52529a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CommentFloatSusPendedView commentFloatSusPendedView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commentFloatSusPendedView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52529a = commentFloatSusPendedView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            t tVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof t) || (tVar = (t) customResponsedMessage.getData()) == null) {
                return;
            }
            this.f52529a.q = tVar.f18817d;
            this.f52529a.f52527i = tVar.f18815b;
            this.f52529a.j = tVar.f18814a;
            this.f52529a.o = tVar.f18816c;
            this.f52529a.l = tVar.f18818e;
            CommentFloatSusPendedView commentFloatSusPendedView = this.f52529a;
            commentFloatSusPendedView.m((commentFloatSusPendedView.j - this.f52529a.f52527i) / l.i(this.f52529a.getContext()));
            boolean z = this.f52529a.j > this.f52529a.f52527i;
            if (this.f52529a.l) {
                this.f52529a.n.setIntValues((int) (this.f52529a.j - this.f52529a.f52527i), l.i(this.f52529a.getContext()));
                this.f52529a.n.setDuration(0L);
                this.f52529a.n.start();
            }
            if (this.f52529a.j > this.f52529a.f52527i) {
                this.f52529a.k = true;
            } else {
                this.f52529a.k = z;
            }
            this.f52529a.requestLayout();
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
            if (this.f52524f != null && this.r) {
                if (this.n.isRunning()) {
                    this.n.end();
                    return true;
                } else if (this.l) {
                    return true;
                } else {
                    int action = motionEvent.getAction();
                    if (action != 0) {
                        if (action != 1) {
                            if (action == 2) {
                                this.j = motionEvent.getRawY();
                                if (this.f52527i == 0.0f && isOnViewTop()) {
                                    this.f52527i = motionEvent.getRawY();
                                }
                                if (isOnViewTop() && !this.l) {
                                    m((this.j - this.f52527i) / l.i(getContext()));
                                }
                                this.q = 1.0f - ((this.j - this.f52527i) / l.i(getContext()));
                            }
                        }
                        this.k = false;
                        z = this.j > this.f52527i && isOnViewTop();
                        boolean z2 = this.j - this.f52527i > ((float) this.p) && isOnViewTop();
                        this.l = z2;
                        if (z2) {
                            this.n.setIntValues((int) (this.j - this.f52527i), l.i(getContext()));
                            this.n.setDuration(300L);
                            this.n.start();
                        } else {
                            m(0.0f);
                            this.q = 1.0f;
                            this.f52527i = 0.0f;
                            this.j = 0.0f;
                            requestLayout();
                        }
                        if (!this.k || (this.j > this.f52527i && isOnViewTop())) {
                            this.k = true;
                            requestLayout();
                            return true;
                        } else if (z) {
                            this.k = true;
                            return true;
                        } else {
                            this.k = false;
                            return super.dispatchTouchEvent(motionEvent);
                        }
                    }
                    this.j = motionEvent.getRawY();
                    if (isOnViewTop()) {
                        this.f52527i = motionEvent.getRawY();
                    } else {
                        this.f52527i = 0.0f;
                    }
                    z = false;
                    if (this.k) {
                    }
                    this.k = true;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.a.q0.x0.a aVar = this.f52526h;
            if (aVar == null) {
                return false;
            }
            return aVar.isOnViewTop();
        }
        return invokeV.booleanValue;
    }

    public final void m(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
            CustomMessage customMessage = new CustomMessage(2921594);
            customMessage.setTag(this.s);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921594, Float.valueOf(f2));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.t);
            this.n.cancel();
            this.n.removeAllUpdateListeners();
            clearAnimation();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            if (!this.m) {
                float f2 = this.q;
                if (f2 >= 0.0f && this.f52524f != null) {
                    canvas.drawColor(Color.argb((int) (f2 * 168.0f), 0, 0, 0), PorterDuff.Mode.SRC);
                }
            } else {
                canvas.drawColor(Color.argb(0, 255, 255, 255), PorterDuff.Mode.CLEAR);
            }
            super.onDraw(canvas);
        }
    }

    public void onFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.l = true;
            this.n.setIntValues(0, l.i(getContext()));
            this.n.setDuration(300L);
            this.n.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            if (this.n == null) {
                super.onLayout(z, i2, i3, i4, i5);
                return;
            }
            int i6 = this.o;
            if (i6 == 0) {
                super.onLayout(z, i2, i3, i4, i5);
                float f2 = this.j;
                float f3 = this.f52527i;
                if (f2 <= f3 || !this.k) {
                    return;
                }
                LinearLayout linearLayout = this.f52523e;
                linearLayout.layout(i2, (int) (f2 - f3), i4, ((int) (f2 - f3)) + linearLayout.getHeight());
                this.f52525g.layout(i2, ((int) (this.j - this.f52527i)) + this.f52523e.getHeight(), i4, i5);
                return;
            }
            LinearLayout linearLayout2 = this.f52523e;
            linearLayout2.layout(i2, i6, i4, linearLayout2.getMeasuredHeight() + i6);
            this.f52525g.layout(i2, this.o + this.f52523e.getMeasuredHeight(), i4, i5);
        }
    }

    public void setCanDragClose(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.r = z;
        }
    }

    public void setContentView(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, viewGroup) == null) {
            this.f52525g = viewGroup;
        }
    }

    public void setContentViewTop(b.a.q0.x0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.f52526h = aVar;
        }
    }

    public void setIsNoBgColor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.m = z;
        }
    }

    public void setNavigationBar(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, linearLayout) == null) {
            this.f52523e = linearLayout;
        }
    }

    public void setTranView(TranView tranView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, tranView) == null) {
            this.f52524f = tranView;
        }
    }

    public void setVideoPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bdUniqueId) == null) {
            this.s = bdUniqueId;
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.q == 0.0f) {
            this.n.setDuration(300L);
            this.n.start();
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
    public CommentFloatSusPendedView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.q = 0.0f;
        this.r = true;
        this.t = new b(this, 2921597);
        this.p = l.i(context) / 10;
        this.o = l.i(context);
        MessageManager.getInstance().registerListener(this.t);
        ValueAnimator ofInt = ValueAnimator.ofInt(l.i(context), 0);
        this.n = ofInt;
        ofInt.setDuration(300L);
        this.n.setInterpolator(new LinearInterpolator());
        this.n.addUpdateListener(new a(this));
    }
}
