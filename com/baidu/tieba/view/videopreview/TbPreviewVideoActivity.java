package com.baidu.tieba.view.videopreview;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.TbPreviewVideoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes9.dex */
public class TbPreviewVideoActivity extends BaseActivity<TbPreviewVideoActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener backBtnListener;
    public int currentPlayPosition;
    public NavigationBar navigationBar;
    public VideoInfo videoInfo;
    public CustomVideoView videoView;
    public VideoControllerView videoViewController;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPreviewVideoActivity f55538e;

        public a(TbPreviewVideoActivity tbPreviewVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPreviewVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55538e = tbPreviewVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f55538e.videoView == null) {
                return;
            }
            this.f55538e.videoView.stopPlayback();
            this.f55538e.closeActivity();
        }
    }

    /* loaded from: classes9.dex */
    public class b implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPreviewVideoActivity f55539e;

        public b(TbPreviewVideoActivity tbPreviewVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPreviewVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55539e = tbPreviewVideoActivity;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f55539e.videoView.start();
                this.f55539e.videoViewController.initCurTimeAndDuration(0, this.f55539e.videoView.getDuration());
                this.f55539e.videoViewController.showProgress();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPreviewVideoActivity f55540e;

        public c(TbPreviewVideoActivity tbPreviewVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPreviewVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55540e = tbPreviewVideoActivity;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f55540e.videoView.start();
                this.f55540e.videoViewController.showProgress();
            }
        }
    }

    public TbPreviewVideoActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void initDataFromIntent() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (intent = getIntent()) == null) {
            return;
        }
        Serializable serializableExtra = intent.getSerializableExtra(TbPreviewVideoActivityConfig.KEY_VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.videoInfo = (VideoInfo) serializableExtra;
        }
    }

    private void initListener() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) && this.backBtnListener == null) {
            this.backBtnListener = new a(this);
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.preview_video_navigation_bar);
            this.navigationBar = navigationBar;
            ((ImageView) navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.backBtnListener).findViewById(R.id.widget_navi_back_button)).setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_topbar_return44));
            this.videoView = (CustomVideoView) findViewById(R.id.preview_video_view);
            if (!StringUtils.isNull(this.videoInfo.getVideoPath())) {
                this.videoView.setVideoPath(this.videoInfo.getVideoPath());
            }
            this.videoView.setOnPreparedListener(new b(this));
            this.videoView.setOnCompletionListener(new c(this));
            VideoControllerView videoControllerView = (VideoControllerView) findViewById(R.id.preview_video_controller);
            this.videoViewController = videoControllerView;
            videoControllerView.setPlayer(this.videoView);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.activity_preview_video);
            initDataFromIntent();
            initListener();
            initView();
            TiebaStatic.log("c14312");
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            CustomVideoView customVideoView = this.videoView;
            if (customVideoView != null) {
                customVideoView.stopPlayback();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onPause();
            CustomVideoView customVideoView = this.videoView;
            if (customVideoView != null) {
                this.currentPlayPosition = customVideoView.getCurrentPosition();
                this.videoView.stopPlayback();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            CustomVideoView customVideoView = this.videoView;
            if (customVideoView != null) {
                customVideoView.start();
                this.videoView.seekTo(this.currentPlayPosition);
                this.videoViewController.showProgress();
            }
        }
    }
}
