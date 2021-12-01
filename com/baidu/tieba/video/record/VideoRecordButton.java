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
/* loaded from: classes11.dex */
public class VideoRecordButton extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f49857e;

    /* renamed from: f  reason: collision with root package name */
    public View f49858f;

    /* renamed from: g  reason: collision with root package name */
    public View f49859g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f49860h;

    /* renamed from: i  reason: collision with root package name */
    public ObjectAnimator f49861i;

    /* renamed from: j  reason: collision with root package name */
    public ObjectAnimator f49862j;

    /* renamed from: k  reason: collision with root package name */
    public ObjectAnimator f49863k;
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
            this.f49857e = findViewById(R.id.record_layer1);
            this.f49858f = findViewById(R.id.record_layer2);
            this.f49859g = findViewById(R.id.record_layer3);
            this.f49860h = (TextView) findViewById(R.id.tv_tip);
            this.f49859g.setScaleX(0.766f);
            this.f49859g.setScaleY(0.766f);
        }
    }

    public View getLayer1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f49857e : (View) invokeV.objValue;
    }

    public View getLayer2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f49858f : (View) invokeV.objValue;
    }

    public View getLayer3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f49859g : (View) invokeV.objValue;
    }

    public TextView getTvTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f49860h : (TextView) invokeV.objValue;
    }

    public void startRecordAnimator(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            ObjectAnimator objectAnimator = this.f49862j;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.f49862j.cancel();
            }
            if (this.f49861i == null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f49859g, PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, 0.766f, 1.0f), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, 0.766f, 1.0f));
                this.f49861i = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setRepeatCount(-1);
                this.f49861i.setRepeatMode(2);
                this.f49861i.setDuration(1000L);
            }
            this.f49859g.setVisibility(0);
            if (z) {
                this.f49857e.setVisibility(8);
            } else {
                this.f49857e.setBackgroundResource(R.drawable.red_square_bg);
            }
            this.f49860h.setVisibility(8);
            this.f49861i.start();
        }
    }

    public void startTakePhotoAnimator() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ObjectAnimator objectAnimator = this.l;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.f49863k.cancel();
            }
            if (this.f49863k == null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f49858f, PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, 1.0f, 0.9f), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, 1.0f, 0.9f));
                this.f49863k = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setDuration(200L);
            }
            this.f49863k.start();
        }
    }

    public void stopRecordAnimator() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ObjectAnimator objectAnimator = this.f49861i;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.f49861i.cancel();
            }
            if (this.f49862j == null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f49859g, PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, this.f49859g.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, this.f49859g.getScaleY(), 0.766f));
                this.f49862j = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setDuration((Math.abs(0.766f - this.f49859g.getScaleX()) * 500.0f) / 0.3f);
            }
            this.f49857e.setVisibility(0);
            this.f49857e.setBackgroundResource(R.drawable.red_circle_bg);
            this.f49862j.start();
        }
    }

    public void stopTakePhotoAnimator() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ObjectAnimator objectAnimator = this.f49863k;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.f49863k.cancel();
            }
            if (this.f49858f.getScaleX() == 1.0f) {
                return;
            }
            if (this.l == null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f49858f, PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, 0.9f, 1.0f), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, 0.9f, 1.0f));
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
