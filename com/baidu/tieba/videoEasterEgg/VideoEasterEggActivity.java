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
import com.repackage.cr4;
import com.repackage.cv8;
import com.repackage.dv8;
import com.repackage.ni;
import com.repackage.pg;
import com.repackage.xt4;
import com.repackage.yu8;
import com.repackage.zu8;
/* loaded from: classes4.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements zu8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isComplite;
    public boolean isContinuePlay;
    public boolean isDontDisplaytAgain;
    public ImageView mClose;
    public yu8 mDialog;
    public View mErrorContainer;
    public MediaPlayer.OnInfoListener mInfoListener;
    public int mLastPlayPosition;
    public TextView mLoadErrorText;
    public TextView mPlayText;
    public xt4 mProgressDialog;
    public ImageView mShare;
    public int mSkinType;
    public Runnable mTimeoutRunnable;
    public cv8 mVideoEasterEggPresenter;
    public ScaleVideoView mVideoView;

    /* loaded from: classes4.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        public a(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                this.a.isDontDisplaytAgain = z;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        public b(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                if (this.a.mVideoEasterEggPresenter != null) {
                    this.a.mVideoEasterEggPresenter.c();
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                this.a.mDialog.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        public c(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                if (this.a.mVideoEasterEggPresenter != null) {
                    this.a.mVideoEasterEggPresenter.e();
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).param("obj_locate", 2));
                }
                this.a.mDialog.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        public d(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) && this.a.isDontDisplaytAgain) {
                this.a.mVideoEasterEggPresenter.b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        public e(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.mVideoEasterEggPresenter == null) {
                return;
            }
            this.a.mVideoEasterEggPresenter.a();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements MediaPlayer.OnInfoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        public f(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i, i2)) == null) {
                if (i == 3) {
                    this.a.setVideoMask(false);
                    pg.a().removeCallbacks(this.a.mTimeoutRunnable);
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        public g(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.mVideoEasterEggPresenter == null) {
                return;
            }
            this.a.mVideoEasterEggPresenter.onClose();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        public h(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.mVideoEasterEggPresenter == null) {
                return;
            }
            this.a.mVideoEasterEggPresenter.e();
            this.a.pauseVideo();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).param("obj_locate", 1));
        }
    }

    /* loaded from: classes4.dex */
    public class i implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        public i(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i, i2)) == null) {
                if (this.a.mVideoEasterEggPresenter != null) {
                    this.a.mVideoEasterEggPresenter.a();
                    return true;
                }
                return true;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class j implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        public j(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.a.isComplite = true;
                if (this.a.mVideoEasterEggPresenter != null) {
                    this.a.mVideoEasterEggPresenter.d();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        public k(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.a.mVideoView.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(this.a.mInfoListener);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements SurfaceHolder.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        public l(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, surfaceHolder, i, i2, i3) == null) {
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceHolder) == null) {
                this.a.setVideoMask(true);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, surfaceHolder) == null) {
                this.a.isComplite = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        public m(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.mVideoEasterEggPresenter == null) {
                return;
            }
            this.a.mVideoEasterEggPresenter.c();
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

    private yu8 buildDialog(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, str, str2)) == null) {
            yu8 yu8Var = new yu8(this);
            this.mDialog = yu8Var;
            yu8Var.e(str2);
            if (ni.isEmpty(str)) {
                str = getResources().getString(R.string.obfuscated_res_0x7f0f0512);
            }
            this.mDialog.f(str);
            this.mDialog.d(R.string.obfuscated_res_0x7f0f0511, new a(this));
            this.mDialog.g(R.string.obfuscated_res_0x7f0f050f, new b(this));
            this.mDialog.h(R.string.obfuscated_res_0x7f0f0510, new c(this));
            this.mDialog.setOnDismissListener(new d(this));
            this.mDialog.create(getPageContext());
            return this.mDialog;
        }
        return (yu8) invokeLL.objValue;
    }

    private void initErrorContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.mErrorContainer = findViewById(R.id.obfuscated_res_0x7f090909);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0912fa);
            this.mLoadErrorText = textView;
            textView.setText(R.string.obfuscated_res_0x7f0f0a2f);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f09185b);
            this.mPlayText = textView2;
            textView2.setText(R.string.obfuscated_res_0x7f0f043b);
            this.mPlayText.setOnClickListener(new m(this));
            this.mErrorContainer.setVisibility(8);
        }
    }

    private void initNavigationBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f09066c);
            this.mClose = imageView;
            imageView.setOnClickListener(new g(this));
            ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f091ca5);
            this.mShare = imageView2;
            imageView2.setOnClickListener(new h(this));
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.mProgressDialog = new xt4(getPageContext());
            setSwipeBackEnabled(false);
            setContentView(R.layout.obfuscated_res_0x7f0d0871);
            initNavigationBar();
            initVideoView();
            initErrorContainer();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void initVideoView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            ScaleVideoView scaleVideoView = (ScaleVideoView) findViewById(R.id.obfuscated_res_0x7f091be5);
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
                xt4 xt4Var = this.mProgressDialog;
                if (xt4Var != null && !xt4Var.c()) {
                    this.mProgressDialog.h(true);
                }
                this.mVideoView.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
                return;
            }
            xt4 xt4Var2 = this.mProgressDialog;
            if (xt4Var2 != null) {
                xt4Var2.h(false);
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

    @Override // com.repackage.zu8
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
        SkinManager.setViewTextColor(this.mLoadErrorText, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.mPlayText, (int) R.color.CAM_X0101);
        SkinManager.setBackgroundResource(this.mPlayText, R.drawable.continue_play_bg);
        SkinManager.setImageResource(this.mClose, R.drawable.obfuscated_res_0x7f08071e);
        SkinManager.setImageResource(this.mShare, R.drawable.obfuscated_res_0x7f080723);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
            this.mVideoEasterEggPresenter = new dv8(getPageContext(), this, getIntent());
            initUI();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            cv8 cv8Var = this.mVideoEasterEggPresenter;
            if (cv8Var != null) {
                cv8Var.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
            pauseVideo();
            cv8 cv8Var = this.mVideoEasterEggPresenter;
            if (cv8Var != null) {
                cv8Var.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            cv8 cv8Var = this.mVideoEasterEggPresenter;
            if (cv8Var != null) {
                cv8Var.onResume();
            }
        }
    }

    @Override // com.repackage.zu8
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

    @Override // com.repackage.zu8
    public void showDialog(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            if (this.mDialog == null) {
                this.mDialog = buildDialog(str, str2);
            }
            this.mDialog.show();
        }
    }

    @Override // com.repackage.zu8
    public void showErrorView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            pg.a().removeCallbacks(this.mTimeoutRunnable);
            this.mVideoView.pause();
            this.mProgressDialog.h(false);
            this.mErrorContainer.setVisibility(0);
        }
    }

    @Override // com.repackage.zu8
    public void startPlayVideo(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || ni.isEmpty(str) || this.mVideoView.isPlaying() || this.isComplite) {
            return;
        }
        if (this.isContinuePlay) {
            this.mVideoView.seekTo(this.mLastPlayPosition);
            this.isContinuePlay = false;
        } else {
            this.mVideoView.setVideoURI(Uri.parse(str));
            pg.a().postDelayed(this.mTimeoutRunnable, 5000L);
        }
        this.mVideoView.start();
    }
}
