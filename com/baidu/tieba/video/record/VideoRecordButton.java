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
/* loaded from: classes7.dex */
public class VideoRecordButton extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f57884e;

    /* renamed from: f  reason: collision with root package name */
    public View f57885f;

    /* renamed from: g  reason: collision with root package name */
    public View f57886g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f57887h;

    /* renamed from: i  reason: collision with root package name */
    public ObjectAnimator f57888i;

    /* renamed from: j  reason: collision with root package name */
    public ObjectAnimator f57889j;
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
            this.f57884e = findViewById(R.id.record_layer1);
            this.f57885f = findViewById(R.id.record_layer2);
            this.f57886g = findViewById(R.id.record_layer3);
            this.f57887h = (TextView) findViewById(R.id.tv_tip);
            this.f57886g.setScaleX(0.766f);
            this.f57886g.setScaleY(0.766f);
        }
    }

    public View getLayer1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57884e : (View) invokeV.objValue;
    }

    public View getLayer2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f57885f : (View) invokeV.objValue;
    }

    public View getLayer3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f57886g : (View) invokeV.objValue;
    }

    public TextView getTvTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f57887h : (TextView) invokeV.objValue;
    }

    public void startRecordAnimator(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            ObjectAnimator objectAnimator = this.f57889j;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.f57889j.cancel();
            }
            if (this.f57888i == null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f57886g, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
                this.f57888i = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setRepeatCount(-1);
                this.f57888i.setRepeatMode(2);
                this.f57888i.setDuration(1000L);
            }
            this.f57886g.setVisibility(0);
            if (z) {
                this.f57884e.setVisibility(8);
            } else {
                this.f57884e.setBackgroundResource(R.drawable.red_square_bg);
            }
            this.f57887h.setVisibility(8);
            this.f57888i.start();
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
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f57885f, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
                this.k = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setDuration(200L);
            }
            this.k.start();
        }
    }

    public void stopRecordAnimator() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ObjectAnimator objectAnimator = this.f57888i;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.f57888i.cancel();
            }
            if (this.f57889j == null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f57886g, PropertyValuesHolder.ofFloat("scaleX", this.f57886g.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.f57886g.getScaleY(), 0.766f));
                this.f57889j = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setDuration((Math.abs(0.766f - this.f57886g.getScaleX()) * 500.0f) / 0.3f);
            }
            this.f57884e.setVisibility(0);
            this.f57884e.setBackgroundResource(R.drawable.red_circle_bg);
            this.f57889j.start();
        }
    }

    public void stopTakePhotoAnimator() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ObjectAnimator objectAnimator = this.k;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.k.cancel();
            }
            if (this.f57885f.getScaleX() == 1.0f) {
                return;
            }
            if (this.l == null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f57885f, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
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
