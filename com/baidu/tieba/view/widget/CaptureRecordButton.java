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
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.p09;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class CaptureRecordButton extends FrameLayout implements p09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public View b;
    public View c;
    public RecordCircleProgressBar d;
    public ObjectAnimator e;
    public ObjectAnimator f;
    public AnimatorSet g;
    public AnimatorSet h;

    /* loaded from: classes6.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CaptureRecordButton a;

        public a(CaptureRecordButton captureRecordButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {captureRecordButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = captureRecordButton;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.a.b.setAlpha(0.0f);
                this.a.d.setAlpha(1.0f);
                this.a.g();
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
    public CaptureRecordButton(Context context, AttributeSet attributeSet) {
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
    public CaptureRecordButton(Context context, AttributeSet attributeSet, int i) {
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
        e();
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.g.cancel();
            this.g.setDuration(320L);
            this.g.removeAllListeners();
            this.g.addListener(new a(this));
            this.g.start();
        }
    }

    @Override // com.baidu.tieba.p09
    public void setMaxDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.d.setMaxDuration(i);
        }
    }

    @Override // com.baidu.tieba.p09
    public void setMinDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.d.setMinDuration(i);
        }
    }

    @Override // com.baidu.tieba.p09
    public void setOnProgressListener(p09.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, aVar) == null) {
            this.d.setOnProgressListener(aVar);
        }
    }

    @Override // com.baidu.tieba.p09
    public void setProgress(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            this.d.setProgress(j);
        }
    }

    @Override // com.baidu.tieba.p09
    public void setShowDeleteLastTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.d.setShowDeleteLastTip(z);
        }
    }

    @Override // com.baidu.tieba.p09
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d.a();
        }
    }

    @Override // com.baidu.tieba.p09
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d.b();
        }
        return invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.h.cancel();
            this.h.setDuration(200L);
            this.h.removeAllListeners();
            this.h.reverse();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.h.cancel();
            this.h.setDuration(200L);
            this.h.removeAllListeners();
            this.h.start();
        }
    }

    public View getLayer1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public View getLayer2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public View getLayer3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.p09
    public int getMaxDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d.getMaxDuration();
        }
        return invokeV.intValue;
    }

    public View getPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.p09
    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.d.getProgress();
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.tieba.p09
    public int getSlideNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.d.getSlideNum();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.p09
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.d.reset();
        }
    }

    @Override // com.baidu.tieba.p09
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.d.start();
        }
    }

    @Override // com.baidu.tieba.p09
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.d.stop();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            FrameLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d048e, this);
            this.a = findViewById(R.id.obfuscated_res_0x7f091bab);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091bae);
            this.c = findViewById;
            findViewById.setAlpha(0.0f);
            this.b = findViewById(R.id.obfuscated_res_0x7f091bac);
            this.d = (RecordCircleProgressBar) findViewById(R.id.obfuscated_res_0x7f091baf);
            AnimatorSet animatorSet = new AnimatorSet();
            this.g = animatorSet;
            animatorSet.play(ObjectAnimator.ofFloat(this.a, Key.SCALE_X, 1.0f, 0.388f)).with(ObjectAnimator.ofFloat(this.a, Key.SCALE_Y, 1.0f, 0.388f)).with(ObjectAnimator.ofFloat(this.b, Key.SCALE_X, 0.8f, 1.0f)).with(ObjectAnimator.ofFloat(this.b, Key.SCALE_Y, 0.8f, 1.0f)).with(ObjectAnimator.ofFloat(this.b, Key.ALPHA, 1.0f, 0.66f));
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.h = animatorSet2;
            animatorSet2.play(ObjectAnimator.ofFloat(this.a, Key.ALPHA, 1.0f, 0.0f)).with(ObjectAnimator.ofFloat(this.c, Key.ALPHA, 0.0f, 1.0f));
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            ObjectAnimator objectAnimator = this.f;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.e.cancel();
            }
            if (this.e == null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.b, PropertyValuesHolder.ofFloat(Key.SCALE_X, 1.0f, 0.9f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 1.0f, 0.9f));
                this.e = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setDuration(200L);
            }
            this.e.start();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.b.setAlpha(1.0f);
            if (this.a.getAlpha() == 0.0f) {
                g();
            }
            this.d.setAlpha(0.0f);
            this.g.cancel();
            this.g.setDuration(320L);
            this.g.removeAllListeners();
            this.g.reverse();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ObjectAnimator objectAnimator = this.e;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.e.cancel();
            }
            if (this.b.getScaleX() == 1.0f) {
                return;
            }
            if (this.f == null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.b, PropertyValuesHolder.ofFloat(Key.SCALE_X, 0.9f, 1.0f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 0.9f, 1.0f));
                this.f = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setDuration(200L);
            }
            this.f.start();
        }
    }
}
