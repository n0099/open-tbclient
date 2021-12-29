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
import c.a.t0.n4.m.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes12.dex */
public class CaptureRecordButton extends FrameLayout implements c.a.t0.n4.m.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f51315e;

    /* renamed from: f  reason: collision with root package name */
    public View f51316f;

    /* renamed from: g  reason: collision with root package name */
    public View f51317g;

    /* renamed from: h  reason: collision with root package name */
    public RecordCircleProgressBar f51318h;

    /* renamed from: i  reason: collision with root package name */
    public ObjectAnimator f51319i;

    /* renamed from: j  reason: collision with root package name */
    public ObjectAnimator f51320j;

    /* renamed from: k  reason: collision with root package name */
    public AnimatorSet f51321k;
    public AnimatorSet l;

    /* loaded from: classes12.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CaptureRecordButton f51322e;

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
            this.f51322e = captureRecordButton;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.f51322e.f51316f.setAlpha(0.0f);
                this.f51322e.f51318h.setAlpha(1.0f);
                this.f51322e.resumeRecordAnimator();
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

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            FrameLayout.inflate(getContext(), R.layout.layout_capture_record_button, this);
            this.f51315e = findViewById(R.id.record_layer1);
            View findViewById = findViewById(R.id.record_pause);
            this.f51317g = findViewById;
            findViewById.setAlpha(0.0f);
            this.f51316f = findViewById(R.id.record_layer2);
            this.f51318h = (RecordCircleProgressBar) findViewById(R.id.record_progressbar);
            AnimatorSet animatorSet = new AnimatorSet();
            this.f51321k = animatorSet;
            animatorSet.play(ObjectAnimator.ofFloat(this.f51315e, AnimationProperty.SCALE_X, 1.0f, 0.388f)).with(ObjectAnimator.ofFloat(this.f51315e, AnimationProperty.SCALE_Y, 1.0f, 0.388f)).with(ObjectAnimator.ofFloat(this.f51316f, AnimationProperty.SCALE_X, 0.8f, 1.0f)).with(ObjectAnimator.ofFloat(this.f51316f, AnimationProperty.SCALE_Y, 0.8f, 1.0f)).with(ObjectAnimator.ofFloat(this.f51316f, AnimationProperty.OPACITY, 1.0f, 0.66f));
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.l = animatorSet2;
            animatorSet2.play(ObjectAnimator.ofFloat(this.f51315e, AnimationProperty.OPACITY, 1.0f, 0.0f)).with(ObjectAnimator.ofFloat(this.f51317g, AnimationProperty.OPACITY, 0.0f, 1.0f));
        }
    }

    @Override // c.a.t0.n4.m.a
    public void deleteLast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f51318h.deleteLast();
        }
    }

    public View getLayer1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f51315e : (View) invokeV.objValue;
    }

    public View getLayer2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f51316f : (View) invokeV.objValue;
    }

    public View getLayer3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f51318h : (View) invokeV.objValue;
    }

    @Override // c.a.t0.n4.m.a
    public int getMaxDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f51318h.getMaxDuration() : invokeV.intValue;
    }

    public View getPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f51317g : (View) invokeV.objValue;
    }

    @Override // c.a.t0.n4.m.a
    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f51318h.getProgress() : invokeV.floatValue;
    }

    @Override // c.a.t0.n4.m.a
    public int getSlideNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f51318h.getSlideNum() : invokeV.intValue;
    }

    @Override // c.a.t0.n4.m.a
    public boolean isShowingDeleteLastTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f51318h.isShowingDeleteLastTip() : invokeV.booleanValue;
    }

    public void pauseRecordAnimator() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.l.cancel();
            this.l.setDuration(200L);
            this.l.removeAllListeners();
            this.l.reverse();
        }
    }

    @Override // c.a.t0.n4.m.a
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f51318h.reset();
        }
    }

    public void resumeRecordAnimator() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.l.cancel();
            this.l.setDuration(200L);
            this.l.removeAllListeners();
            this.l.start();
        }
    }

    @Override // c.a.t0.n4.m.a
    public void setMaxDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f51318h.setMaxDuration(i2);
        }
    }

    @Override // c.a.t0.n4.m.a
    public void setMinDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f51318h.setMinDuration(i2);
        }
    }

    @Override // c.a.t0.n4.m.a
    public void setOnProgressListener(a.InterfaceC1240a interfaceC1240a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, interfaceC1240a) == null) {
            this.f51318h.setOnProgressListener(interfaceC1240a);
        }
    }

    @Override // c.a.t0.n4.m.a
    public void setProgress(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j2) == null) {
            this.f51318h.setProgress(j2);
        }
    }

    @Override // c.a.t0.n4.m.a
    public void setShowDeleteLastTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f51318h.setShowDeleteLastTip(z);
        }
    }

    @Override // c.a.t0.n4.m.a
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f51318h.start();
        }
    }

    public void startRecordAnimator(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f51321k.cancel();
            this.f51321k.setDuration(320L);
            this.f51321k.removeAllListeners();
            this.f51321k.addListener(new a(this));
            this.f51321k.start();
        }
    }

    public void startTakePhotoAnimator() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ObjectAnimator objectAnimator = this.f51320j;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.f51319i.cancel();
            }
            if (this.f51319i == null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f51316f, PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, 1.0f, 0.9f), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, 1.0f, 0.9f));
                this.f51319i = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setDuration(200L);
            }
            this.f51319i.start();
        }
    }

    @Override // c.a.t0.n4.m.a
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f51318h.stop();
        }
    }

    public void stopRecordAnimator() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f51316f.setAlpha(1.0f);
            if (this.f51315e.getAlpha() == 0.0f) {
                resumeRecordAnimator();
            }
            this.f51318h.setAlpha(0.0f);
            this.f51321k.cancel();
            this.f51321k.setDuration(320L);
            this.f51321k.removeAllListeners();
            this.f51321k.reverse();
        }
    }

    public void stopTakePhotoAnimator() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            ObjectAnimator objectAnimator = this.f51319i;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.f51319i.cancel();
            }
            if (this.f51316f.getScaleX() == 1.0f) {
                return;
            }
            if (this.f51320j == null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f51316f, PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, 0.9f, 1.0f), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, 0.9f, 1.0f));
                this.f51320j = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setDuration(200L);
            }
            this.f51320j.start();
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
        c();
    }
}
