package com.baidu.tieba.view.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.z3.m.a;
/* loaded from: classes5.dex */
public class CaptureRecordButton extends FrameLayout implements d.a.s0.z3.m.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f22277e;

    /* renamed from: f  reason: collision with root package name */
    public View f22278f;

    /* renamed from: g  reason: collision with root package name */
    public View f22279g;

    /* renamed from: h  reason: collision with root package name */
    public RecordCircleProgressBar f22280h;

    /* renamed from: i  reason: collision with root package name */
    public ObjectAnimator f22281i;
    public ObjectAnimator j;
    public AnimatorSet k;
    public AnimatorSet l;

    /* loaded from: classes5.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CaptureRecordButton f22282e;

        public a(CaptureRecordButton captureRecordButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {captureRecordButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22282e = captureRecordButton;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.f22282e.f22278f.setAlpha(0.0f);
                this.f22282e.f22280h.setAlpha(1.0f);
                this.f22282e.g();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CaptureRecordButton(Context context) {
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

    @Override // d.a.s0.z3.m.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22280h.a();
        }
    }

    @Override // d.a.s0.z3.m.a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22280h.b() : invokeV.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            FrameLayout.inflate(getContext(), R.layout.layout_capture_record_button, this);
            this.f22277e = findViewById(R.id.record_layer1);
            View findViewById = findViewById(R.id.record_pause);
            this.f22279g = findViewById;
            findViewById.setAlpha(0.0f);
            this.f22278f = findViewById(R.id.record_layer2);
            this.f22280h = (RecordCircleProgressBar) findViewById(R.id.record_progressbar);
            AnimatorSet animatorSet = new AnimatorSet();
            this.k = animatorSet;
            animatorSet.play(ObjectAnimator.ofFloat(this.f22277e, "scaleX", 1.0f, 0.388f)).with(ObjectAnimator.ofFloat(this.f22277e, "scaleY", 1.0f, 0.388f)).with(ObjectAnimator.ofFloat(this.f22278f, "scaleX", 0.8f, 1.0f)).with(ObjectAnimator.ofFloat(this.f22278f, "scaleY", 0.8f, 1.0f)).with(ObjectAnimator.ofFloat(this.f22278f, "alpha", 1.0f, 0.66f));
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.l = animatorSet2;
            animatorSet2.play(ObjectAnimator.ofFloat(this.f22277e, "alpha", 1.0f, 0.0f)).with(ObjectAnimator.ofFloat(this.f22279g, "alpha", 0.0f, 1.0f));
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.l.cancel();
            this.l.setDuration(200L);
            this.l.removeAllListeners();
            this.l.reverse();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.l.cancel();
            this.l.setDuration(200L);
            this.l.removeAllListeners();
            this.l.start();
        }
    }

    public View getLayer1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f22277e : (View) invokeV.objValue;
    }

    public View getLayer2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f22278f : (View) invokeV.objValue;
    }

    public View getLayer3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f22280h : (View) invokeV.objValue;
    }

    @Override // d.a.s0.z3.m.a
    public int getMaxDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f22280h.getMaxDuration() : invokeV.intValue;
    }

    public View getPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f22279g : (View) invokeV.objValue;
    }

    @Override // d.a.s0.z3.m.a
    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f22280h.getProgress() : invokeV.floatValue;
    }

    @Override // d.a.s0.z3.m.a
    public int getSlideNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f22280h.getSlideNum() : invokeV.intValue;
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.k.cancel();
            this.k.setDuration(320L);
            this.k.removeAllListeners();
            this.k.addListener(new a(this));
            this.k.start();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            ObjectAnimator objectAnimator = this.j;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.f22281i.cancel();
            }
            if (this.f22281i == null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f22278f, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
                this.f22281i = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setDuration(200L);
            }
            this.f22281i.start();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f22278f.setAlpha(1.0f);
            if (this.f22277e.getAlpha() == 0.0f) {
                g();
            }
            this.f22280h.setAlpha(0.0f);
            this.k.cancel();
            this.k.setDuration(320L);
            this.k.removeAllListeners();
            this.k.reverse();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ObjectAnimator objectAnimator = this.f22281i;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.f22281i.cancel();
            }
            if (this.f22278f.getScaleX() == 1.0f) {
                return;
            }
            if (this.j == null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f22278f, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.j = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setDuration(200L);
            }
            this.j.start();
        }
    }

    @Override // d.a.s0.z3.m.a
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f22280h.reset();
        }
    }

    @Override // d.a.s0.z3.m.a
    public void setMaxDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f22280h.setMaxDuration(i2);
        }
    }

    @Override // d.a.s0.z3.m.a
    public void setMinDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f22280h.setMinDuration(i2);
        }
    }

    @Override // d.a.s0.z3.m.a
    public void setOnProgressListener(a.InterfaceC1919a interfaceC1919a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, interfaceC1919a) == null) {
            this.f22280h.setOnProgressListener(interfaceC1919a);
        }
    }

    @Override // d.a.s0.z3.m.a
    public void setProgress(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            this.f22280h.setProgress(j);
        }
    }

    @Override // d.a.s0.z3.m.a
    public void setShowDeleteLastTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.f22280h.setShowDeleteLastTip(z);
        }
    }

    @Override // d.a.s0.z3.m.a
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f22280h.start();
        }
    }

    @Override // d.a.s0.z3.m.a
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.f22280h.stop();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CaptureRecordButton(Context context, AttributeSet attributeSet) {
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
    public CaptureRecordButton(Context context, AttributeSet attributeSet, int i2) {
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
        e();
    }
}
