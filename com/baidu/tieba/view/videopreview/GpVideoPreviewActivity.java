package com.baidu.tieba.view.videopreview;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GpVideoPreviewActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.rv9;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.view.VideoFullscreenButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes8.dex */
public class GpVideoPreviewActivity extends BaseActivity<GpVideoPreviewActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public CustomVideoView b;
    public VideoInfo c;
    public VideoControllerView d;
    public int e;
    public View.OnClickListener f;
    public boolean g;
    public rv9 h;
    public TbImageView i;
    public TBLottieAnimationView j;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GpVideoPreviewActivity a;

        public a(GpVideoPreviewActivity gpVideoPreviewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gpVideoPreviewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gpVideoPreviewActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.getRequestedOrientation() == 0) {
                    if (this.a.h != null) {
                        this.a.h.l();
                    }
                } else if (this.a.b != null) {
                    this.a.b.stopPlayback();
                    this.a.closeActivity();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GpVideoPreviewActivity a;

        public b(GpVideoPreviewActivity gpVideoPreviewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gpVideoPreviewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gpVideoPreviewActivity;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                if (this.a.b != null && this.a.d != null) {
                    this.a.b.start();
                    this.a.d.l(0, this.a.b.getDuration());
                    this.a.d.t();
                }
                if (this.a.i != null) {
                    this.a.i.setVisibility(8);
                }
                this.a.U0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GpVideoPreviewActivity a;

        public c(GpVideoPreviewActivity gpVideoPreviewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gpVideoPreviewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gpVideoPreviewActivity;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) && this.a.b != null && this.a.d != null) {
                this.a.b.start();
                this.a.d.t();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GpVideoPreviewActivity a;

        public d(GpVideoPreviewActivity gpVideoPreviewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gpVideoPreviewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gpVideoPreviewActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.h != null) {
                this.a.h.l();
            }
        }
    }

    public GpVideoPreviewActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void U0() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (tBLottieAnimationView = this.j) != null) {
            if (tBLottieAnimationView.isAnimating()) {
                this.j.cancelAnimation();
            }
            this.j.setVisibility(8);
        }
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f == null) {
            this.f = new a(this);
        }
    }

    public final void Z0() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (tBLottieAnimationView = this.j) != null) {
            tBLottieAnimationView.setVisibility(0);
            if (!this.j.isAnimating()) {
                this.j.setSpeed(1.1f);
                this.j.playAnimation();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            CustomVideoView customVideoView = this.b;
            if (customVideoView != null) {
                customVideoView.stopPlayback();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onPause();
            CustomVideoView customVideoView = this.b;
            if (customVideoView != null) {
                this.e = customVideoView.getCurrentPosition();
                this.b.stopPlayback();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            CustomVideoView customVideoView = this.b;
            if (customVideoView != null) {
                customVideoView.start();
                this.b.seekTo(this.e);
                this.d.t();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d003b);
            initData();
            V0();
            initView();
        }
    }

    public final void initData() {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (intent = getIntent()) == null) {
            return;
        }
        Serializable serializableExtra = intent.getSerializableExtra("videoInfo");
        if (serializableExtra instanceof VideoInfo) {
            this.c = (VideoInfo) serializableExtra;
        }
        this.g = intent.getBooleanExtra(GpVideoPreviewActivityConfig.KEY_IS_SUPPORT_FULLSCREEN, false);
        this.h = new rv9(this);
    }

    public final void initView() {
        VideoInfo videoInfo;
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091d63);
            this.i = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091212);
            ((ImageView) this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.f).findViewById(R.id.widget_navi_back_button)).setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c37));
            this.b = (CustomVideoView) findViewById(R.id.obfuscated_res_0x7f091d65);
            if (!StringUtils.isNull(this.c.getVideoPath())) {
                this.b.setVideoPath(this.c.getVideoPath());
            }
            if (!StringUtils.isNull(this.c.getThumbPath()) && (tbImageView = this.i) != null) {
                tbImageView.setPlaceHolder(2);
                this.i.setLongIconSupport(false);
                this.i.setGifIconSupport(false);
                this.i.startLoad(this.c.getThumbPath(), 10, false);
            }
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f09246d);
            this.j = tBLottieAnimationView;
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.lotti_video_loading);
            Z0();
            this.b.setOnPreparedListener(new b(this));
            this.b.setOnCompletionListener(new c(this));
            VideoControllerView videoControllerView = (VideoControllerView) findViewById(R.id.obfuscated_res_0x7f091d61);
            this.d = videoControllerView;
            videoControllerView.setPlayer(this.b);
            VideoFullscreenButton videoFullscreenButton = (VideoFullscreenButton) findViewById(R.id.obfuscated_res_0x7f0928a6);
            if (this.g && (videoInfo = this.c) != null && videoInfo.getVideoWidth() > this.c.getVideoHeight()) {
                videoFullscreenButton.setVisibility(0);
            } else {
                videoFullscreenButton.setVisibility(8);
            }
            videoFullscreenButton.setOnClickListener(new d(this));
        }
    }
}
