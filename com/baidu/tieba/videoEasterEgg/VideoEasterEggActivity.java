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
import com.baidu.adp.lib.f.e;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private ImageView jAO;
    private com.baidu.tbadk.core.view.a jfz;
    private ImageView nqi;
    private ScaleVideoView nqj;
    private View nqk;
    private TextView nql;
    private TextView nqm;
    private com.baidu.tieba.videoEasterEgg.b.a nqn;
    private a nqr;
    private boolean nqs;
    private int mSkinType = 3;
    private int nqo = 0;
    private boolean nqp = false;
    private boolean nqq = false;
    private Runnable nqt = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.nqn != null) {
                VideoEasterEggActivity.this.nqn.dup();
            }
        }
    };
    private MediaPlayer.OnInfoListener nqu = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.xY(false);
                e.mY().removeCallbacks(VideoEasterEggActivity.this.nqt);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.nqn = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.jfz = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        bAw();
        dPe();
        dPf();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bAw() {
        this.jAO = (ImageView) findViewById(R.id.close);
        this.jAO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nqn != null) {
                    VideoEasterEggActivity.this.nqn.onClose();
                }
            }
        });
        this.nqi = (ImageView) findViewById(R.id.share);
        this.nqi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nqn != null) {
                    VideoEasterEggActivity.this.nqn.bvn();
                    VideoEasterEggActivity.this.pauseVideo();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).aj("obj_locate", 1));
                }
            }
        });
    }

    private void dPe() {
        this.nqj = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.nqj.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.nqn != null) {
                    VideoEasterEggActivity.this.nqn.dup();
                    return true;
                }
                return true;
            }
        });
        this.nqj.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.nqs = true;
                if (VideoEasterEggActivity.this.nqn != null) {
                    VideoEasterEggActivity.this.nqn.dPh();
                }
            }
        });
        this.nqj.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.nqj.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.nqu);
            }
        });
        this.nqj.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.xY(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.nqs = false;
            }
        });
        xY(true);
    }

    private void dPf() {
        this.nqk = findViewById(R.id.error_container);
        this.nql = (TextView) findViewById(R.id.load_error_text);
        this.nql.setText(R.string.loading_error);
        this.nqm = (TextView) findViewById(R.id.play_text);
        this.nqm.setText(R.string.continues_play);
        this.nqm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nqn != null) {
                    VideoEasterEggActivity.this.nqn.dPg();
                }
            }
        });
        this.nqk.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xY(boolean z) {
        if (z) {
            if (this.jfz != null && !this.jfz.isShowing()) {
                this.jfz.setDialogVisiable(true);
            }
            this.nqj.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_a));
            return;
        }
        if (this.jfz != null) {
            this.jfz.setDialogVisiable(false);
        }
        this.nqj.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nqn != null) {
            this.nqn.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        pauseVideo();
        if (this.nqn != null) {
            this.nqn.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseVideo() {
        if (this.nqj != null && this.nqj.isPlaying()) {
            this.nqo = this.nqj.getCurrentPosition();
            this.nqj.pause();
            this.nqp = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nqn != null) {
            this.nqn.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void TT(String str) {
        if (!at.isEmpty(str) && !this.nqj.isPlaying() && !this.nqs) {
            if (this.nqp) {
                this.nqj.seekTo(this.nqo);
                this.nqp = false;
            } else {
                this.nqj.setVideoURI(Uri.parse(str));
                e.mY().postDelayed(this.nqt, 5000L);
            }
            this.nqj.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void TU(String str) {
        this.nqk.setVisibility(8);
        this.nqp = true;
        this.nqo = 0;
        this.nqs = false;
        TT(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void gC(String str, String str2) {
        if (this.nqr == null) {
            this.nqr = gD(str, str2);
        }
        this.nqr.bmC();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void apc() {
        e.mY().removeCallbacks(this.nqt);
        this.nqj.pause();
        this.jfz.setDialogVisiable(false);
        this.nqk.setVisibility(0);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void finishActivity() {
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finishActivity();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setViewTextColor(this.nql, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.nqm, (int) R.color.cp_cont_a);
            ap.setBackgroundResource(this.nqm, R.drawable.continue_play_bg);
            ap.setImageResource(this.jAO, R.drawable.icon_frs_luhan_close);
            ap.setImageResource(this.nqi, R.drawable.icon_frs_luhan_share);
        }
    }

    private a gD(String str, String str2) {
        this.nqr = new a(this);
        this.nqr.TR(str2);
        if (at.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.nqr.Ba(str);
        this.nqr.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.nqq = z;
            }
        });
        this.nqr.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.nqn != null) {
                    VideoEasterEggActivity.this.nqn.dPg();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.nqr.dismiss();
            }
        });
        this.nqr.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.nqn != null) {
                    VideoEasterEggActivity.this.nqn.bvn();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).aj("obj_locate", 2));
                }
                VideoEasterEggActivity.this.nqr.dismiss();
            }
        });
        this.nqr.d(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.nqq) {
                    VideoEasterEggActivity.this.nqn.dPi();
                }
            }
        });
        this.nqr.b(getPageContext());
        return this.nqr;
    }
}
