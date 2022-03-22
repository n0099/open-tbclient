package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes6.dex */
public class VideoRecordButton extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public View f36556b;

    /* renamed from: c  reason: collision with root package name */
    public View f36557c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f36558d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f36559e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f36560f;

    /* renamed from: g  reason: collision with root package name */
    public ObjectAnimator f36561g;

    /* renamed from: h  reason: collision with root package name */
    public ObjectAnimator f36562h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoRecordButton(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            FrameLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d04b8, this);
            this.a = findViewById(R.id.obfuscated_res_0x7f091a1c);
            this.f36556b = findViewById(R.id.obfuscated_res_0x7f091a1d);
            this.f36557c = findViewById(R.id.obfuscated_res_0x7f091a1e);
            this.f36558d = (TextView) findViewById(R.id.obfuscated_res_0x7f09221c);
            this.f36557c.setScaleX(0.766f);
            this.f36557c.setScaleY(0.766f);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            ObjectAnimator objectAnimator = this.f36560f;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.f36560f.cancel();
            }
            if (this.f36559e == null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f36557c, PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, 0.766f, 1.0f), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, 0.766f, 1.0f));
                this.f36559e = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setRepeatCount(-1);
                this.f36559e.setRepeatMode(2);
                this.f36559e.setDuration(1000L);
            }
            this.f36557c.setVisibility(0);
            if (z) {
                this.a.setVisibility(8);
            } else {
                this.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f080fa8);
            }
            this.f36558d.setVisibility(8);
            this.f36559e.start();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ObjectAnimator objectAnimator = this.f36562h;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.f36561g.cancel();
            }
            if (this.f36561g == null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f36556b, PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, 1.0f, 0.9f), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, 1.0f, 0.9f));
                this.f36561g = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setDuration(200L);
            }
            this.f36561g.start();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ObjectAnimator objectAnimator = this.f36559e;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.f36559e.cancel();
            }
            if (this.f36560f == null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f36557c, PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, this.f36557c.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, this.f36557c.getScaleY(), 0.766f));
                this.f36560f = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setDuration((Math.abs(0.766f - this.f36557c.getScaleX()) * 500.0f) / 0.3f);
            }
            this.a.setVisibility(0);
            this.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f080fa7);
            this.f36560f.start();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ObjectAnimator objectAnimator = this.f36561g;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.f36561g.cancel();
            }
            if (this.f36556b.getScaleX() == 1.0f) {
                return;
            }
            if (this.f36562h == null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f36556b, PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, 0.9f, 1.0f), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, 0.9f, 1.0f));
                this.f36562h = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setDuration(200L);
            }
            this.f36562h.start();
        }
    }

    public View getLayer1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public View getLayer2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f36556b : (View) invokeV.objValue;
    }

    public View getLayer3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f36557c : (View) invokeV.objValue;
    }

    public TextView getTvTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f36558d : (TextView) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoRecordButton(Context context, AttributeSet attributeSet, int i) {
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
        a();
    }
}
