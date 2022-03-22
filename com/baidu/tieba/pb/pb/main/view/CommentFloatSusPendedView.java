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
import c.a.d.f.p.n;
import c.a.p0.w2.i.v;
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
/* loaded from: classes5.dex */
public class CommentFloatSusPendedView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public TranView f35042b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f35043c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.o0.x0.b f35044d;

    /* renamed from: e  reason: collision with root package name */
    public float f35045e;

    /* renamed from: f  reason: collision with root package name */
    public float f35046f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35047g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f35048h;
    public boolean i;
    public ValueAnimator j;
    public int k;
    public int l;
    public float m;
    public boolean n;
    public BdUniqueId o;
    public CustomMessageListener p;

    /* loaded from: classes5.dex */
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
                commentFloatSusPendedView.r((commentFloatSusPendedView.k * 1.0f) / n.i(this.a.getContext()));
                CommentFloatSusPendedView commentFloatSusPendedView2 = this.a;
                commentFloatSusPendedView2.m = 1.0f - (commentFloatSusPendedView2.k / n.i(this.a.getContext()));
                if (this.a.k == 0) {
                    this.a.m = 1.0f;
                } else if (this.a.k == n.i(this.a.getContext())) {
                    this.a.m = 0.0f;
                    if (this.a.f35048h && (this.a.getContext() instanceof Activity)) {
                        ((Activity) this.a.getContext()).finish();
                    }
                }
                this.a.requestLayout();
            }
        }
    }

    /* loaded from: classes5.dex */
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
            v vVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof v) || (vVar = (v) customResponsedMessage.getData()) == null) {
                return;
            }
            this.a.m = vVar.f19868d;
            this.a.f35045e = vVar.f19866b;
            this.a.f35046f = vVar.a;
            this.a.k = vVar.f19867c;
            this.a.f35048h = vVar.f19869e;
            CommentFloatSusPendedView commentFloatSusPendedView = this.a;
            commentFloatSusPendedView.r((commentFloatSusPendedView.f35046f - this.a.f35045e) / n.i(this.a.getContext()));
            boolean z = this.a.f35046f > this.a.f35045e;
            if (this.a.f35048h) {
                this.a.j.setIntValues((int) (this.a.f35046f - this.a.f35045e), n.i(this.a.getContext()));
                this.a.j.setDuration(0L);
                this.a.j.start();
            }
            if (this.a.f35046f > this.a.f35045e) {
                this.a.f35047g = true;
            } else {
                this.a.f35047g = z;
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
            if (this.f35042b != null && this.n) {
                if (this.j.isRunning()) {
                    this.j.end();
                    return true;
                } else if (this.f35048h) {
                    return true;
                } else {
                    int action = motionEvent.getAction();
                    if (action != 0) {
                        if (action != 1) {
                            if (action == 2) {
                                this.f35046f = motionEvent.getRawY();
                                if (this.f35045e == 0.0f && m()) {
                                    this.f35045e = motionEvent.getRawY();
                                }
                                if (m() && !this.f35048h) {
                                    r((this.f35046f - this.f35045e) / n.i(getContext()));
                                }
                                this.m = 1.0f - ((this.f35046f - this.f35045e) / n.i(getContext()));
                            }
                        }
                        this.f35047g = false;
                        z = this.f35046f > this.f35045e && m();
                        boolean z2 = this.f35046f - this.f35045e > ((float) this.l) && m();
                        this.f35048h = z2;
                        if (z2) {
                            this.j.setIntValues((int) (this.f35046f - this.f35045e), n.i(getContext()));
                            this.j.setDuration(300L);
                            this.j.start();
                        } else {
                            r(0.0f);
                            this.m = 1.0f;
                            this.f35045e = 0.0f;
                            this.f35046f = 0.0f;
                            requestLayout();
                        }
                        if (!this.f35047g || (this.f35046f > this.f35045e && m())) {
                            this.f35047g = true;
                            requestLayout();
                            return true;
                        } else if (z) {
                            this.f35047g = true;
                            return true;
                        } else {
                            this.f35047g = false;
                            return super.dispatchTouchEvent(motionEvent);
                        }
                    }
                    this.f35046f = motionEvent.getRawY();
                    if (m()) {
                        this.f35045e = motionEvent.getRawY();
                    } else {
                        this.f35045e = 0.0f;
                    }
                    z = false;
                    if (this.f35047g) {
                    }
                    this.f35047g = true;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f35048h : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.o0.x0.b bVar = this.f35044d;
            if (bVar == null) {
                return false;
            }
            return bVar.isOnViewTop();
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
                float f2 = this.m;
                if (f2 >= 0.0f && this.f35042b != null) {
                    canvas.drawColor(Color.argb((int) (f2 * 168.0f), 0, 0, 0), PorterDuff.Mode.SRC);
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
                float f2 = this.f35046f;
                float f3 = this.f35045e;
                if (f2 <= f3 || !this.f35047g) {
                    return;
                }
                LinearLayout linearLayout = this.a;
                linearLayout.layout(i, (int) (f2 - f3), i3, ((int) (f2 - f3)) + linearLayout.getHeight());
                this.f35043c.layout(i, ((int) (this.f35046f - this.f35045e)) + this.a.getHeight(), i3, i4);
                return;
            }
            LinearLayout linearLayout2 = this.a;
            linearLayout2.layout(i, i5, i3, linearLayout2.getMeasuredHeight() + i5);
            this.f35043c.layout(i, this.k + this.a.getMeasuredHeight(), i3, i4);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f35048h = true;
            this.j.setIntValues(0, n.i(getContext()));
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

    public final void r(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f2) == null) {
            CustomMessage customMessage = new CustomMessage(2921594);
            customMessage.setTag(this.o);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921594, Float.valueOf(f2));
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
            this.f35043c = viewGroup;
        }
    }

    public void setContentViewTop(c.a.o0.x0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.f35044d = bVar;
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
            this.f35042b = tranView;
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
        this.l = n.i(context) / 10;
        this.k = n.i(context);
        MessageManager.getInstance().registerListener(this.p);
        ValueAnimator ofInt = ValueAnimator.ofInt(n.i(context), 0);
        this.j = ofInt;
        ofInt.setDuration(300L);
        this.j.setInterpolator(new LinearInterpolator());
        this.j.addUpdateListener(new a(this));
    }
}
