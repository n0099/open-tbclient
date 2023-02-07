package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class VideoRecordButton extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public View b;
    public View c;
    public TextView d;
    public ObjectAnimator e;
    public ObjectAnimator f;
    public ObjectAnimator g;
    public ObjectAnimator h;

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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            FrameLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d04e9, this);
            this.a = findViewById(R.id.obfuscated_res_0x7f091c8a);
            this.b = findViewById(R.id.obfuscated_res_0x7f091c8b);
            this.c = findViewById(R.id.obfuscated_res_0x7f091c8c);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f09251e);
            this.c.setScaleX(0.766f);
            this.c.setScaleY(0.766f);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ObjectAnimator objectAnimator = this.h;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.g.cancel();
            }
            if (this.g == null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.b, PropertyValuesHolder.ofFloat(Key.SCALE_X, 1.0f, 0.9f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 1.0f, 0.9f));
                this.g = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setDuration(200L);
            }
            this.g.start();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            ObjectAnimator objectAnimator = this.f;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.f.cancel();
            }
            if (this.e == null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.c, PropertyValuesHolder.ofFloat(Key.SCALE_X, 0.766f, 1.0f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 0.766f, 1.0f));
                this.e = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setRepeatCount(-1);
                this.e.setRepeatMode(2);
                this.e.setDuration(1000L);
            }
            this.c.setVisibility(0);
            if (z) {
                this.a.setVisibility(8);
            } else {
                this.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f081054);
            }
            this.d.setVisibility(8);
            this.e.start();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ObjectAnimator objectAnimator = this.e;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.e.cancel();
            }
            if (this.f == null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.c, PropertyValuesHolder.ofFloat(Key.SCALE_X, this.c.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, this.c.getScaleY(), 0.766f));
                this.f = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setDuration((Math.abs(0.766f - this.c.getScaleX()) * 500.0f) / 0.3f);
            }
            this.a.setVisibility(0);
            this.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f081053);
            this.f.start();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ObjectAnimator objectAnimator = this.g;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.g.cancel();
            }
            if (this.b.getScaleX() == 1.0f) {
                return;
            }
            if (this.h == null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.b, PropertyValuesHolder.ofFloat(Key.SCALE_X, 0.9f, 1.0f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 0.9f, 1.0f));
                this.h = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setDuration(200L);
            }
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
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public TextView getTvTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d;
        }
        return (TextView) invokeV.objValue;
    }
}
