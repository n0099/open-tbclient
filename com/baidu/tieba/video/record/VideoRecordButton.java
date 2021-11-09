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
/* loaded from: classes9.dex */
public class VideoRecordButton extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f54849e;

    /* renamed from: f  reason: collision with root package name */
    public View f54850f;

    /* renamed from: g  reason: collision with root package name */
    public View f54851g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f54852h;

    /* renamed from: i  reason: collision with root package name */
    public ObjectAnimator f54853i;
    public ObjectAnimator j;
    public ObjectAnimator k;
    public ObjectAnimator l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoRecordButton(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            FrameLayout.inflate(getContext(), R.layout.layout_record_button, this);
            this.f54849e = findViewById(R.id.record_layer1);
            this.f54850f = findViewById(R.id.record_layer2);
            this.f54851g = findViewById(R.id.record_layer3);
            this.f54852h = (TextView) findViewById(R.id.tv_tip);
            this.f54851g.setScaleX(0.766f);
            this.f54851g.setScaleY(0.766f);
        }
    }

    public View getLayer1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54849e : (View) invokeV.objValue;
    }

    public View getLayer2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f54850f : (View) invokeV.objValue;
    }

    public View getLayer3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f54851g : (View) invokeV.objValue;
    }

    public TextView getTvTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f54852h : (TextView) invokeV.objValue;
    }

    public void startRecordAnimator(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            ObjectAnimator objectAnimator = this.j;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.j.cancel();
            }
            if (this.f54853i == null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f54851g, PropertyValuesHolder.ofFloat(Key.SCALE_X, 0.766f, 1.0f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 0.766f, 1.0f));
                this.f54853i = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setRepeatCount(-1);
                this.f54853i.setRepeatMode(2);
                this.f54853i.setDuration(1000L);
            }
            this.f54851g.setVisibility(0);
            if (z) {
                this.f54849e.setVisibility(8);
            } else {
                this.f54849e.setBackgroundResource(R.drawable.red_square_bg);
            }
            this.f54852h.setVisibility(8);
            this.f54853i.start();
        }
    }

    public void startTakePhotoAnimator() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ObjectAnimator objectAnimator = this.l;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.k.cancel();
            }
            if (this.k == null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f54850f, PropertyValuesHolder.ofFloat(Key.SCALE_X, 1.0f, 0.9f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 1.0f, 0.9f));
                this.k = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setDuration(200L);
            }
            this.k.start();
        }
    }

    public void stopRecordAnimator() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ObjectAnimator objectAnimator = this.f54853i;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.f54853i.cancel();
            }
            if (this.j == null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f54851g, PropertyValuesHolder.ofFloat(Key.SCALE_X, this.f54851g.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, this.f54851g.getScaleY(), 0.766f));
                this.j = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setDuration((Math.abs(0.766f - this.f54851g.getScaleX()) * 500.0f) / 0.3f);
            }
            this.f54849e.setVisibility(0);
            this.f54849e.setBackgroundResource(R.drawable.red_circle_bg);
            this.j.start();
        }
    }

    public void stopTakePhotoAnimator() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ObjectAnimator objectAnimator = this.k;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.k.cancel();
            }
            if (this.f54850f.getScaleX() == 1.0f) {
                return;
            }
            if (this.l == null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f54850f, PropertyValuesHolder.ofFloat(Key.SCALE_X, 0.9f, 1.0f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 0.9f, 1.0f));
                this.l = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setDuration(200L);
            }
            this.l.start();
        }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    public VideoRecordButton(Context context, AttributeSet attributeSet, int i2) {
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
        a();
    }
}
