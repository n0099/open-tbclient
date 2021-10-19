package com.baidu.tieba.videoEasterEgg;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.s.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements c.a.r0.z3.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isComplite;
    public boolean isContinuePlay;
    public boolean isDontDisplaytAgain;
    public ImageView mClose;
    public c.a.r0.z3.a mDialog;
    public View mErrorContainer;
    public MediaPlayer.OnInfoListener mInfoListener;
    public int mLastPlayPosition;
    public TextView mLoadErrorText;
    public TextView mPlayText;
    public c.a.q0.s.f0.a mProgressDialog;
    public ImageView mShare;
    public int mSkinType;
    public Runnable mTimeoutRunnable;
    public c.a.r0.z3.d.a mVideoEasterEggPresenter;
    public ScaleVideoView mVideoView;

    /* loaded from: classes7.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoEasterEggActivity f57824e;

        public a(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57824e = videoEasterEggActivity;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                this.f57824e.isDontDisplaytAgain = z;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoEasterEggActivity f57825e;

        public b(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57825e = videoEasterEggActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f57825e.mVideoEasterEggPresenter != null) {
                    this.f57825e.mVideoEasterEggPresenter.c();
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                this.f57825e.mDialog.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoEasterEggActivity f57826e;

        public c(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57826e = videoEasterEggActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f57826e.mVideoEasterEggPresenter != null) {
                    this.f57826e.mVideoEasterEggPresenter.e();
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).param("obj_locate", 2));
                }
                this.f57826e.mDialog.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoEasterEggActivity f57827e;

        public d(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57827e = videoEasterEggActivity;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) && this.f57827e.isDontDisplaytAgain) {
                this.f57827e.mVideoEasterEggPresenter.b();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoEasterEggActivity f57828e;

        public e(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57828e = videoEasterEggActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f57828e.mVideoEasterEggPresenter == null) {
                return;
            }
            this.f57828e.mVideoEasterEggPresenter.a();
        }
    }

    /* loaded from: classes7.dex */
    public class f implements MediaPlayer.OnInfoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoEasterEggActivity f57829e;

        public f(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57829e = videoEasterEggActivity;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                if (i2 == 3) {
                    this.f57829e.setVideoMask(false);
                    c.a.e.e.m.e.a().removeCallbacks(this.f57829e.mTimeoutRunnable);
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoEasterEggActivity f57830e;

        public g(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57830e = videoEasterEggActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f57830e.mVideoEasterEggPresenter == null) {
                return;
            }
            this.f57830e.mVideoEasterEggPresenter.onClose();
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoEasterEggActivity f57831e;

        public h(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57831e = videoEasterEggActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f57831e.mVideoEasterEggPresenter == null) {
                return;
            }
            this.f57831e.mVideoEasterEggPresenter.e();
            this.f57831e.pauseVideo();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).param("obj_locate", 1));
        }
    }

    /* loaded from: classes7.dex */
    public class i implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoEasterEggActivity f57832e;

        public i(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57832e = videoEasterEggActivity;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                if (this.f57832e.mVideoEasterEggPresenter != null) {
                    this.f57832e.mVideoEasterEggPresenter.a();
                    return true;
                }
                return true;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class j implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoEasterEggActivity f57833e;

        public j(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57833e = videoEasterEggActivity;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f57833e.isComplite = true;
                if (this.f57833e.mVideoEasterEggPresenter != null) {
                    this.f57833e.mVideoEasterEggPresenter.d();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoEasterEggActivity f57834e;

        public k(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57834e = videoEasterEggActivity;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f57834e.mVideoView.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(this.f57834e.mInfoListener);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements SurfaceHolder.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoEasterEggActivity f57835e;

        public l(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57835e = videoEasterEggActivity;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, surfaceHolder, i2, i3, i4) == null) {
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceHolder) == null) {
                this.f57835e.setVideoMask(true);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, surfaceHolder) == null) {
                this.f57835e.isComplite = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoEasterEggActivity f57836e;

        public m(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57836e = videoEasterEggActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f57836e.mVideoEasterEggPresenter == null) {
                return;
            }
            this.f57836e.mVideoEasterEggPresenter.c();
        }
    }

    public VideoEasterEggActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSkinType = 3;
        this.mLastPlayPosition = 0;
        this.isContinuePlay = false;
        this.isDontDisplaytAgain = false;
        this.mTimeoutRunnable = new e(this);
        this.mInfoListener = new f(this);
    }

    private c.a.r0.z3.a buildDialog(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, str, str2)) == null) {
            c.a.r0.z3.a aVar = new c.a.r0.z3.a(this);
            this.mDialog = aVar;
            aVar.e(str2);
            if (c.a.e.e.p.k.isEmpty(str)) {
                str = getResources().getString(R.string.easter_dialog_default_message);
            }
            this.mDialog.f(str);
            this.mDialog.d(R.string.easter_dialog_checkbox_text_not_again, new a(this));
            this.mDialog.g(R.string.easter_dialog_btn_text_replay, new b(this));
            this.mDialog.h(R.string.easter_dialog_btn_text_share, new c(this));
            this.mDialog.setOnDismissListener(new d(this));
            this.mDialog.create(getPageContext());
            return this.mDialog;
        }
        return (c.a.r0.z3.a) invokeLL.objValue;
    }

    private void initErrorContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.mErrorContainer = findViewById(R.id.error_container);
            TextView textView = (TextView) findViewById(R.id.load_error_text);
            this.mLoadErrorText = textView;
            textView.setText(R.string.loading_error);
            TextView textView2 = (TextView) findViewById(R.id.play_text);
            this.mPlayText = textView2;
            textView2.setText(R.string.continues_play);
            this.mPlayText.setOnClickListener(new m(this));
            this.mErrorContainer.setVisibility(8);
        }
    }

    private void initNavigationBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            ImageView imageView = (ImageView) findViewById(R.id.close);
            this.mClose = imageView;
            imageView.setOnClickListener(new g(this));
            ImageView imageView2 = (ImageView) findViewById(R.id.share);
            this.mShare = imageView2;
            imageView2.setOnClickListener(new h(this));
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.mProgressDialog = new c.a.q0.s.f0.a(getPageContext());
            setSwipeBackEnabled(false);
            setContentView(R.layout.video_easter_egg_layout);
            initNavigationBar();
            initVideoView();
            initErrorContainer();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void initVideoView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            ScaleVideoView scaleVideoView = (ScaleVideoView) findViewById(R.id.scale_video_view);
            this.mVideoView = scaleVideoView;
            scaleVideoView.setOnErrorListener(new i(this));
            this.mVideoView.setOnCompletionListener(new j(this));
            this.mVideoView.setOnPreparedListener(new k(this));
            this.mVideoView.getHolder().addCallback(new l(this));
            setVideoMask(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseVideo() {
        ScaleVideoView scaleVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65552, this) == null) && (scaleVideoView = this.mVideoView) != null && scaleVideoView.isPlaying()) {
            this.mLastPlayPosition = this.mVideoView.getCurrentPosition();
            this.mVideoView.pause();
            this.isContinuePlay = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoMask(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65553, this, z) == null) {
            if (z) {
                c.a.q0.s.f0.a aVar = this.mProgressDialog;
                if (aVar != null && !aVar.c()) {
                    this.mProgressDialog.h(true);
                }
                this.mVideoView.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
                return;
            }
            c.a.q0.s.f0.a aVar2 = this.mProgressDialog;
            if (aVar2 != null) {
                aVar2.h(false);
            }
            this.mVideoView.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // c.a.r0.z3.b
    public void finishActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onBackPressed();
            finishActivity();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || i2 == this.mSkinType) {
            return;
        }
        this.mSkinType = i2;
        SkinManager.setViewTextColor(this.mLoadErrorText, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.mPlayText, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(this.mPlayText, R.drawable.continue_play_bg);
        SkinManager.setImageResource(this.mClose, R.drawable.icon_frs_luhan_close);
        SkinManager.setImageResource(this.mShare, R.drawable.icon_frs_luhan_share);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
            this.mVideoEasterEggPresenter = new c.a.r0.z3.d.b(getPageContext(), this, getIntent());
            initUI();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            c.a.r0.z3.d.a aVar = this.mVideoEasterEggPresenter;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
            pauseVideo();
            c.a.r0.z3.d.a aVar = this.mVideoEasterEggPresenter;
            if (aVar != null) {
                aVar.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            c.a.r0.z3.d.a aVar = this.mVideoEasterEggPresenter;
            if (aVar != null) {
                aVar.onResume();
            }
        }
    }

    @Override // c.a.r0.z3.b
    public void rePlayVideo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mErrorContainer.setVisibility(8);
            this.isContinuePlay = true;
            this.mLastPlayPosition = 0;
            this.isComplite = false;
            startPlayVideo(str);
        }
    }

    @Override // c.a.r0.z3.b
    public void showDialog(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            if (this.mDialog == null) {
                this.mDialog = buildDialog(str, str2);
            }
            this.mDialog.show();
        }
    }

    @Override // c.a.r0.z3.b
    public void showErrorView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.e.e.m.e.a().removeCallbacks(this.mTimeoutRunnable);
            this.mVideoView.pause();
            this.mProgressDialog.h(false);
            this.mErrorContainer.setVisibility(0);
        }
    }

    @Override // c.a.r0.z3.b
    public void startPlayVideo(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || c.a.e.e.p.k.isEmpty(str) || this.mVideoView.isPlaying() || this.isComplite) {
            return;
        }
        if (this.isContinuePlay) {
            this.mVideoView.seekTo(this.mLastPlayPosition);
            this.isContinuePlay = false;
        } else {
            this.mVideoView.setVideoURI(Uri.parse(str));
            c.a.e.e.m.e.a().postDelayed(this.mTimeoutRunnable, 5000L);
        }
        this.mVideoView.start();
    }
}
