package com.baidu.tieba.pb.pb.sub;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.p0.w2.i.v;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SubPbView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BlankView a;

    /* renamed from: b  reason: collision with root package name */
    public View f35127b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f35128c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f35129d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f35130e;

    /* renamed from: f  reason: collision with root package name */
    public float f35131f;

    /* renamed from: g  reason: collision with root package name */
    public float f35132g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f35133h;
    public boolean i;
    public ValueAnimator j;
    public int k;
    public int l;
    public boolean m;
    public boolean n;
    public int o;
    public float p;
    public boolean q;

    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SubPbView a;

        public a(SubPbView subPbView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subPbView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = subPbView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.k = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SubPbView subPbView = this.a;
                subPbView.p = 1.0f - (subPbView.k / n.i(this.a.getContext()));
                if (this.a.k == 0) {
                    this.a.p = 1.0f;
                } else if (this.a.k == n.i(this.a.getContext())) {
                    this.a.p = 0.0f;
                    if (this.a.i && (this.a.getContext() instanceof Activity)) {
                        ((Activity) this.a.getContext()).finish();
                    }
                }
                this.a.requestLayout();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SubPbView(Context context) {
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

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
        if (r0 != 3) goto L19;
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
            if (this.a != null && this.q) {
                if (this.j.isRunning()) {
                    this.j.end();
                    return true;
                }
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float rawY = motionEvent.getRawY();
                            this.f35132g = rawY;
                            this.p = 1.0f - ((rawY - this.f35131f) / n.i(getContext()));
                            if ((this.m || this.n) && this.f35127b.getTop() == 0 && this.f35129d.getFirstVisiblePosition() == 0 && !this.i) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921597, new v(this.f35132g, this.f35131f, this.k, this.p, this.i)));
                            }
                        }
                    }
                    this.f35133h = false;
                    z = this.f35132g > this.f35131f && this.f35127b.getTop() == 0 && this.f35129d.getFirstVisiblePosition() == 0;
                    boolean z2 = this.f35132g - this.f35131f > ((float) this.o) && this.f35127b.getTop() == 0 && this.f35129d.getFirstVisiblePosition() == 0;
                    this.i = z2;
                    if (z2) {
                        if (this.m || this.n) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921597, new v(this.f35132g, this.f35131f, this.k, this.p, this.i)));
                        }
                        this.j.setIntValues((int) (this.f35132g - this.f35131f), n.i(getContext()));
                        this.j.setDuration(300L);
                        this.j.start();
                    } else {
                        this.p = 1.0f;
                        this.f35131f = 0.0f;
                        this.f35132g = 0.0f;
                        if (this.m || this.n) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921597, new v(this.f35132g, this.f35131f, this.k, this.p, this.i)));
                        }
                        requestLayout();
                    }
                    if (!this.f35133h || (this.f35132g > this.f35131f && this.f35127b.getTop() == 0 && this.f35129d.getFirstVisiblePosition() == 0)) {
                        this.f35133h = true;
                        requestLayout();
                        return true;
                    } else if (z) {
                        this.f35133h = true;
                        return true;
                    } else {
                        this.f35133h = false;
                        return super.dispatchTouchEvent(motionEvent);
                    }
                }
                this.f35132g = motionEvent.getRawY();
                if (this.f35127b.getTop() == 0 && this.f35129d.getFirstVisiblePosition() == 0) {
                    this.f35131f = motionEvent.getRawY();
                } else {
                    this.f35131f = this.f35132g;
                }
                z = false;
                if (this.f35133h) {
                }
                this.f35133h = true;
                requestLayout();
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f35133h : invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.j.cancel();
            this.j.removeAllUpdateListeners();
            clearAnimation();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.i = true;
            if (this.m || this.n) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921597, new v(this.f35132g, this.f35131f, this.k, this.p, this.i)));
            }
            this.j.setIntValues(0, n.i(getContext()));
            this.j.setDuration(300L);
            this.j.start();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.p == 0.0f) {
            this.j.setDuration(this.l);
            this.j.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            float f2 = this.p;
            if (f2 >= 0.0f && this.a != null) {
                canvas.drawColor(Color.argb((int) (f2 * 168.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            }
            if (this.m || this.n) {
                canvas.drawColor(Color.argb(0, 255, 255, 255), PorterDuff.Mode.CLEAR);
            }
            super.onDraw(canvas);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (this.a == null) {
                super.onLayout(z, i, i2, i3, i4);
                return;
            }
            int i5 = this.k;
            if (i5 == 0) {
                super.onLayout(z, i, i2, i3, i4);
                float f2 = this.f35132g;
                float f3 = this.f35131f;
                if (f2 <= f3 || !this.f35133h) {
                    return;
                }
                LinearLayout linearLayout = this.f35128c;
                linearLayout.layout(i, (int) (f2 - f3), i3, ((int) (f2 - f3)) + linearLayout.getHeight());
                this.f35130e.layout(i, ((int) (this.f35132g - this.f35131f)) + this.f35128c.getHeight(), i3, i4);
                return;
            }
            LinearLayout linearLayout2 = this.f35128c;
            linearLayout2.layout(i, i5, i3, linearLayout2.getMeasuredHeight() + i5);
            this.f35130e.layout(i, this.k + this.f35128c.getMeasuredHeight(), i3, i4);
        }
    }

    public void setAnimTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.l = i;
            this.j.setDuration(i);
        }
    }

    public void setBlankView(BlankView blankView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, blankView) == null) {
            this.a = blankView;
        }
    }

    public void setContentView(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, relativeLayout) == null) {
            this.f35130e = relativeLayout;
        }
    }

    public void setEnableDragExit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.q = z;
        }
    }

    public void setIsFromFoldComment(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.n = z;
        }
    }

    public void setIsFromVideoTab(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.m = z;
        }
    }

    public void setListView(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bdTypeListView) == null) {
            this.f35129d = bdTypeListView;
        }
    }

    public void setNavigationView(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, linearLayout) == null) {
            this.f35128c = linearLayout;
        }
    }

    public void setSubPbViewData(v vVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, vVar) == null) || vVar == null) {
            return;
        }
        this.p = vVar.f19868d;
        float f2 = vVar.f19866b;
        this.f35131f = f2;
        float f3 = vVar.a;
        this.f35132g = f3;
        this.k = vVar.f19867c;
        this.i = vVar.f19869e;
        boolean z = f3 > f2;
        if (this.i) {
            this.j.setIntValues((int) (this.f35132g - this.f35131f), n.i(getContext()));
            this.j.setDuration(0L);
            this.j.start();
        }
        if (this.f35132g > this.f35131f) {
            this.f35133h = true;
        } else {
            this.f35133h = z;
        }
        requestLayout();
    }

    public void setTopView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view) == null) {
            this.f35127b = view;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SubPbView(Context context, AttributeSet attributeSet) {
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
    public SubPbView(Context context, AttributeSet attributeSet, int i) {
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
        this.l = 300;
        this.m = false;
        this.n = false;
        this.p = 0.0f;
        if (0 != 0) {
            this.o = n.i(context) / 10;
        } else {
            this.o = (n.i(context) / 3) - n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07024b);
        }
        this.k = n.i(context);
        ValueAnimator ofInt = ValueAnimator.ofInt(n.i(context), 0);
        this.j = ofInt;
        ofInt.setDuration(this.l);
        this.j.setInterpolator(new LinearInterpolator());
        this.j.addUpdateListener(new a(this));
    }
}
