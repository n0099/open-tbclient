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
/* loaded from: classes5.dex */
public class VideoGestureView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;
    public ImageView b;
    public ProgressBar c;
    public ViewGroup d;
    public ImageView e;
    public TextView f;
    public AudioManager g;
    public int h;
    public int i;
    public float j;
    public int k;
    public int l;
    public int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoGestureView(Context context) {
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
        this.h = 100;
        this.j = 1.0f;
        this.m = 0;
        e();
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
        this.h = 100;
        this.j = 1.0f;
        this.m = 0;
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
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
        this.h = 100;
        this.j = 1.0f;
        this.m = 0;
        e();
    }

    public void a(Context context, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, context, z) == null) {
            if (this.m != 2) {
                this.d.setVisibility(8);
                this.a.setVisibility(0);
                this.c.setMax(255);
                setBackgroundDrawable(null);
                this.l = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
                this.m = 2;
            }
            if (z) {
                this.l += 2;
            } else {
                this.l -= 2;
            }
            int i2 = this.l;
            if (i2 < 1) {
                this.l = 1;
            } else if (i2 > 255) {
                this.l = 255;
            }
            int i3 = this.l;
            if (i3 <= 43) {
                i = R.drawable.ic_icon_pure_video_dark16_svg;
            } else if (i3 <= 128) {
                i = R.drawable.ic_icon_pure_video_weaklight16_svg;
            } else {
                i = R.drawable.ic_icon_pure_video_highlight16_svg;
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.b, i, R.color.CAM_X0622, null);
            Window window = ((Activity) context).getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.screenBrightness = this.l / 255.0f;
            window.setAttributes(attributes);
            this.c.setProgress(this.l);
        }
    }

    public void b(boolean z, String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
            if (this.m != 3) {
                this.d.setVisibility(0);
                this.a.setVisibility(8);
                setBackgroundResource(R.color.CAM_X0605);
                this.m = 3;
            }
            this.f.setText(str);
            SvgManager svgManager = SvgManager.getInstance();
            ImageView imageView = this.e;
            if (z) {
                i = R.drawable.ic_icon_pure_video_rewind44_svg;
            } else {
                i = R.drawable.ic_icon_pure_video_forward44_svg;
            }
            svgManager.setPureDrawableWithDayNightModeAutoChange(imageView, i, R.color.CAM_X0622, null);
        }
    }

    public void c(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, context, z) == null) {
            d(context, z, 1);
        }
    }

    public void d(Context context, boolean z, int i) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (this.m != 1) {
                this.d.setVisibility(8);
                this.a.setVisibility(0);
                this.c.setMax(100);
                setBackgroundDrawable(null);
                this.i = this.g.getStreamVolume(3);
                this.m = 1;
            }
            if (z && (i4 = this.k) < 100) {
                this.k = i4 + i;
            }
            if (!z && (i3 = this.k) > 0) {
                this.k = i3 - i;
            }
            if (this.k > 100) {
                this.k = 100;
            }
            if (this.k < 0) {
                this.k = 0;
            }
            int i5 = this.k;
            this.i = (int) (i5 / this.j);
            if (i5 == 0) {
                i2 = R.drawable.ic_icon_pure_video_silent16_svg;
            } else if (i5 < 50) {
                i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
            } else {
                i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.b, i2, R.color.CAM_X0622, null);
            this.g.setStreamVolume(3, this.i, 0);
            this.c.setProgress(this.k);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            RelativeLayout.inflate(getContext(), R.layout.operable_video_gesture, this);
            this.a = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
            this.b = (ImageView) findViewById(R.id.video_gesture_progress_icon);
            this.c = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
            this.d = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
            this.e = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
            this.f = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
            this.a.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.CAM_X0605)));
            AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
            this.g = audioManager;
            if (audioManager != null) {
                this.h = audioManager.getStreamMaxVolume(3);
                int streamVolume = this.g.getStreamVolume(3);
                this.i = streamVolume;
                int i = this.h;
                this.j = 100 / i;
                this.k = (streamVolume * 100) / i;
            }
        }
    }
}
