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
import d.b.i0.r.s.a;
/* loaded from: classes5.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements d.b.j0.r3.b {
    public boolean isComplite;
    public ImageView mClose;
    public d.b.j0.r3.a mDialog;
    public View mErrorContainer;
    public TextView mLoadErrorText;
    public TextView mPlayText;
    public d.b.i0.r.f0.a mProgressDialog;
    public ImageView mShare;
    public d.b.j0.r3.d.a mVideoEasterEggPresenter;
    public ScaleVideoView mVideoView;
    public int mSkinType = 3;
    public int mLastPlayPosition = 0;
    public boolean isContinuePlay = false;
    public boolean isDontDisplaytAgain = false;
    public Runnable mTimeoutRunnable = new e();
    public MediaPlayer.OnInfoListener mInfoListener = new f();

    /* loaded from: classes5.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            VideoEasterEggActivity.this.isDontDisplaytAgain = z;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            if (VideoEasterEggActivity.this.mVideoEasterEggPresenter != null) {
                VideoEasterEggActivity.this.mVideoEasterEggPresenter.b();
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
            }
            VideoEasterEggActivity.this.mDialog.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            if (VideoEasterEggActivity.this.mVideoEasterEggPresenter != null) {
                VideoEasterEggActivity.this.mVideoEasterEggPresenter.d();
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).param("obj_locate", 2));
            }
            VideoEasterEggActivity.this.mDialog.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements DialogInterface.OnDismissListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (VideoEasterEggActivity.this.isDontDisplaytAgain) {
                VideoEasterEggActivity.this.mVideoEasterEggPresenter.e();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.mVideoEasterEggPresenter != null) {
                VideoEasterEggActivity.this.mVideoEasterEggPresenter.a();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements MediaPlayer.OnInfoListener {
        public f() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.setVideoMask(false);
                d.b.c.e.m.e.a().removeCallbacks(VideoEasterEggActivity.this.mTimeoutRunnable);
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoEasterEggActivity.this.mVideoEasterEggPresenter != null) {
                VideoEasterEggActivity.this.mVideoEasterEggPresenter.onClose();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoEasterEggActivity.this.mVideoEasterEggPresenter != null) {
                VideoEasterEggActivity.this.mVideoEasterEggPresenter.d();
                VideoEasterEggActivity.this.pauseVideo();
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).param("obj_locate", 1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements MediaPlayer.OnErrorListener {
        public i() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (VideoEasterEggActivity.this.mVideoEasterEggPresenter != null) {
                VideoEasterEggActivity.this.mVideoEasterEggPresenter.a();
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class j implements MediaPlayer.OnCompletionListener {
        public j() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            VideoEasterEggActivity.this.isComplite = true;
            if (VideoEasterEggActivity.this.mVideoEasterEggPresenter != null) {
                VideoEasterEggActivity.this.mVideoEasterEggPresenter.c();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements MediaPlayer.OnPreparedListener {
        public k() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            VideoEasterEggActivity.this.mVideoView.setMediaPlayer(mediaPlayer);
            mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.mInfoListener);
        }
    }

    /* loaded from: classes5.dex */
    public class l implements SurfaceHolder.Callback {
        public l() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            VideoEasterEggActivity.this.setVideoMask(true);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            VideoEasterEggActivity.this.isComplite = false;
        }
    }

    /* loaded from: classes5.dex */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoEasterEggActivity.this.mVideoEasterEggPresenter != null) {
                VideoEasterEggActivity.this.mVideoEasterEggPresenter.b();
            }
        }
    }

    private d.b.j0.r3.a buildDialog(String str, String str2) {
        d.b.j0.r3.a aVar = new d.b.j0.r3.a(this);
        this.mDialog = aVar;
        aVar.e(str2);
        if (d.b.c.e.p.k.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.mDialog.f(str);
        this.mDialog.d(R.string.easter_dialog_checkbox_text_not_again, new a());
        this.mDialog.g(R.string.easter_dialog_btn_text_replay, new b());
        this.mDialog.h(R.string.easter_dialog_btn_text_share, new c());
        this.mDialog.setOnDismissListener(new d());
        this.mDialog.create(getPageContext());
        return this.mDialog;
    }

    private void initErrorContainer() {
        this.mErrorContainer = findViewById(R.id.error_container);
        TextView textView = (TextView) findViewById(R.id.load_error_text);
        this.mLoadErrorText = textView;
        textView.setText(R.string.loading_error);
        TextView textView2 = (TextView) findViewById(R.id.play_text);
        this.mPlayText = textView2;
        textView2.setText(R.string.continues_play);
        this.mPlayText.setOnClickListener(new m());
        this.mErrorContainer.setVisibility(8);
    }

    private void initNavigationBar() {
        ImageView imageView = (ImageView) findViewById(R.id.close);
        this.mClose = imageView;
        imageView.setOnClickListener(new g());
        ImageView imageView2 = (ImageView) findViewById(R.id.share);
        this.mShare = imageView2;
        imageView2.setOnClickListener(new h());
    }

    private void initUI() {
        this.mProgressDialog = new d.b.i0.r.f0.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        initNavigationBar();
        initVideoView();
        initErrorContainer();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initVideoView() {
        ScaleVideoView scaleVideoView = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.mVideoView = scaleVideoView;
        scaleVideoView.setOnErrorListener(new i());
        this.mVideoView.setOnCompletionListener(new j());
        this.mVideoView.setOnPreparedListener(new k());
        this.mVideoView.getHolder().addCallback(new l());
        setVideoMask(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseVideo() {
        ScaleVideoView scaleVideoView = this.mVideoView;
        if (scaleVideoView == null || !scaleVideoView.isPlaying()) {
            return;
        }
        this.mLastPlayPosition = this.mVideoView.getCurrentPosition();
        this.mVideoView.pause();
        this.isContinuePlay = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoMask(boolean z) {
        if (z) {
            d.b.i0.r.f0.a aVar = this.mProgressDialog;
            if (aVar != null && !aVar.c()) {
                this.mProgressDialog.h(true);
            }
            this.mVideoView.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
            return;
        }
        d.b.i0.r.f0.a aVar2 = this.mProgressDialog;
        if (aVar2 != null) {
            aVar2.h(false);
        }
        this.mVideoView.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // d.b.j0.r3.b
    public void finishActivity() {
        finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finishActivity();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        if (i2 == this.mSkinType) {
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
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.mVideoEasterEggPresenter = new d.b.j0.r3.d.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.b.j0.r3.d.a aVar = this.mVideoEasterEggPresenter;
        if (aVar != null) {
            aVar.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        pauseVideo();
        d.b.j0.r3.d.a aVar = this.mVideoEasterEggPresenter;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        d.b.j0.r3.d.a aVar = this.mVideoEasterEggPresenter;
        if (aVar != null) {
            aVar.onResume();
        }
    }

    @Override // d.b.j0.r3.b
    public void rePlayVideo(String str) {
        this.mErrorContainer.setVisibility(8);
        this.isContinuePlay = true;
        this.mLastPlayPosition = 0;
        this.isComplite = false;
        startPlayVideo(str);
    }

    @Override // d.b.j0.r3.b
    public void showDialog(String str, String str2) {
        if (this.mDialog == null) {
            this.mDialog = buildDialog(str, str2);
        }
        this.mDialog.show();
    }

    @Override // d.b.j0.r3.b
    public void showErrorView() {
        d.b.c.e.m.e.a().removeCallbacks(this.mTimeoutRunnable);
        this.mVideoView.pause();
        this.mProgressDialog.h(false);
        this.mErrorContainer.setVisibility(0);
    }

    @Override // d.b.j0.r3.b
    public void startPlayVideo(String str) {
        if (d.b.c.e.p.k.isEmpty(str) || this.mVideoView.isPlaying() || this.isComplite) {
            return;
        }
        if (this.isContinuePlay) {
            this.mVideoView.seekTo(this.mLastPlayPosition);
            this.isContinuePlay = false;
        } else {
            this.mVideoView.setVideoURI(Uri.parse(str));
            d.b.c.e.m.e.a().postDelayed(this.mTimeoutRunnable, 5000L);
        }
        this.mVideoView.start();
    }
}
