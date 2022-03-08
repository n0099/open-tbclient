package com.baidu.tieba.play.operableVideoView;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class VideoGestureView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f45941e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f45942f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f45943g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f45944h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f45945i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f45946j;
    public AudioManager k;
    public int l;
    public int m;
    public float n;
    public int o;
    public int p;
    public int q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoGestureView(Context context) {
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
        this.l = 100;
        this.n = 1.0f;
        this.q = 0;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            RelativeLayout.inflate(getContext(), R.layout.operable_video_gesture, this);
            this.f45941e = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
            this.f45942f = (ImageView) findViewById(R.id.video_gesture_progress_icon);
            this.f45943g = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
            this.f45944h = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
            this.f45945i = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
            this.f45946j = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
            this.f45941e.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.CAM_X0605)));
            AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
            this.k = audioManager;
            if (audioManager != null) {
                this.l = audioManager.getStreamMaxVolume(3);
                int streamVolume = this.k.getStreamVolume(3);
                this.m = streamVolume;
                int i2 = this.l;
                this.n = 100 / i2;
                this.o = (streamVolume * 100) / i2;
            }
        }
    }

    public void changeBright(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, z) == null) {
            if (this.q != 2) {
                this.f45944h.setVisibility(8);
                this.f45941e.setVisibility(0);
                this.f45943g.setMax(255);
                setBackgroundDrawable(null);
                this.p = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
                this.q = 2;
            }
            if (z) {
                this.p += 2;
            } else {
                this.p -= 2;
            }
            int i2 = this.p;
            if (i2 < 1) {
                this.p = 1;
            } else if (i2 > 255) {
                this.p = 255;
            }
            int i3 = this.p;
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f45942f, i3 <= 43 ? R.drawable.ic_icon_pure_video_dark16_svg : i3 <= 128 ? R.drawable.ic_icon_pure_video_weaklight16_svg : R.drawable.ic_icon_pure_video_highlight16_svg, R.color.CAM_X0622, null);
            Window window = ((Activity) context).getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.screenBrightness = this.p / 255.0f;
            window.setAttributes(attributes);
            this.f45943g.setProgress(this.p);
        }
    }

    public void changeFFRew(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, str) == null) {
            if (this.q != 3) {
                this.f45944h.setVisibility(0);
                this.f45941e.setVisibility(8);
                setBackgroundResource(R.color.CAM_X0605);
                this.q = 3;
            }
            this.f45946j.setText(str);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f45945i, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.CAM_X0622, null);
        }
    }

    public void changeVolume(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, context, z) == null) {
            changeVolume(context, z, 1);
        }
    }

    public void changeVolume(Context context, boolean z, int i2) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (this.q != 1) {
                this.f45944h.setVisibility(8);
                this.f45941e.setVisibility(0);
                this.f45943g.setMax(100);
                setBackgroundDrawable(null);
                this.m = this.k.getStreamVolume(3);
                this.q = 1;
            }
            if (z && (i4 = this.o) < 100) {
                this.o = i4 + i2;
            }
            if (!z && (i3 = this.o) > 0) {
                this.o = i3 - i2;
            }
            if (this.o > 100) {
                this.o = 100;
            }
            if (this.o < 0) {
                this.o = 0;
            }
            int i5 = this.o;
            this.m = (int) (i5 / this.n);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f45942f, i5 == 0 ? R.drawable.ic_icon_pure_video_silent16_svg : i5 < 50 ? R.drawable.ic_icon_pure_video_sound_small16_svg : R.drawable.ic_icon_pure_video_sound_big16_svg, R.color.CAM_X0622, null);
            this.k.setStreamVolume(3, this.m, 0);
            this.f45943g.setProgress(this.o);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoGestureView(Context context, AttributeSet attributeSet) {
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
        this.l = 100;
        this.n = 1.0f;
        this.q = 0;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoGestureView(Context context, AttributeSet attributeSet, int i2) {
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
        this.l = 100;
        this.n = 1.0f;
        this.q = 0;
        a();
    }
}
