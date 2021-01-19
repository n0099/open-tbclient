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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private com.baidu.tbadk.core.view.a jHF;
    private ImageView kdU;
    private ImageView nKd;
    private ScaleVideoView nKe;
    private View nKf;
    private TextView nKg;
    private TextView nKh;
    private com.baidu.tieba.videoEasterEgg.b.a nKi;
    private a nKm;
    private boolean nKn;
    private int mSkinType = 3;
    private int nKj = 0;
    private boolean nKk = false;
    private boolean nKl = false;
    private Runnable nKo = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.nKi != null) {
                VideoEasterEggActivity.this.nKi.dxI();
            }
        }
    };
    private MediaPlayer.OnInfoListener nKp = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.yP(false);
                e.mB().removeCallbacks(VideoEasterEggActivity.this.nKo);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.nKi = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.jHF = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        bEt();
        dSM();
        dSN();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bEt() {
        this.kdU = (ImageView) findViewById(R.id.close);
        this.kdU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nKi != null) {
                    VideoEasterEggActivity.this.nKi.onClose();
                }
            }
        });
        this.nKd = (ImageView) findViewById(R.id.share);
        this.nKd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nKi != null) {
                    VideoEasterEggActivity.this.nKi.cYr();
                    VideoEasterEggActivity.this.pauseVideo();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).an("obj_locate", 1));
                }
            }
        });
    }

    private void dSM() {
        this.nKe = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.nKe.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.nKi != null) {
                    VideoEasterEggActivity.this.nKi.dxI();
                    return true;
                }
                return true;
            }
        });
        this.nKe.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.nKn = true;
                if (VideoEasterEggActivity.this.nKi != null) {
                    VideoEasterEggActivity.this.nKi.dSP();
                }
            }
        });
        this.nKe.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.nKe.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.nKp);
            }
        });
        this.nKe.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.yP(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.nKn = false;
            }
        });
        yP(true);
    }

    private void dSN() {
        this.nKf = findViewById(R.id.error_container);
        this.nKg = (TextView) findViewById(R.id.load_error_text);
        this.nKg.setText(R.string.loading_error);
        this.nKh = (TextView) findViewById(R.id.play_text);
        this.nKh.setText(R.string.continues_play);
        this.nKh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nKi != null) {
                    VideoEasterEggActivity.this.nKi.dSO();
                }
            }
        });
        this.nKf.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yP(boolean z) {
        if (z) {
            if (this.jHF != null && !this.jHF.isShowing()) {
                this.jHF.setDialogVisiable(true);
            }
            this.nKe.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
            return;
        }
        if (this.jHF != null) {
            this.jHF.setDialogVisiable(false);
        }
        this.nKe.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nKi != null) {
            this.nKi.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        pauseVideo();
        if (this.nKi != null) {
            this.nKi.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseVideo() {
        if (this.nKe != null && this.nKe.isPlaying()) {
            this.nKj = this.nKe.getCurrentPosition();
            this.nKe.pause();
            this.nKk = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nKi != null) {
            this.nKi.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void TG(String str) {
        if (!at.isEmpty(str) && !this.nKe.isPlaying() && !this.nKn) {
            if (this.nKk) {
                this.nKe.seekTo(this.nKj);
                this.nKk = false;
            } else {
                this.nKe.setVideoURI(Uri.parse(str));
                e.mB().postDelayed(this.nKo, 5000L);
            }
            this.nKe.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void TH(String str) {
        this.nKf.setVisibility(8);
        this.nKk = true;
        this.nKj = 0;
        this.nKn = false;
        TG(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void gD(String str, String str2) {
        if (this.nKm == null) {
            this.nKm = gE(str, str2);
        }
        this.nKm.bqe();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void arA() {
        e.mB().removeCallbacks(this.nKo);
        this.nKe.pause();
        this.jHF.setDialogVisiable(false);
        this.nKf.setVisibility(0);
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
            ao.setViewTextColor(this.nKg, R.color.CAM_X0101);
            ao.setViewTextColor(this.nKh, R.color.CAM_X0101);
            ao.setBackgroundResource(this.nKh, R.drawable.continue_play_bg);
            ao.setImageResource(this.kdU, R.drawable.icon_frs_luhan_close);
            ao.setImageResource(this.nKd, R.drawable.icon_frs_luhan_share);
        }
    }

    private a gE(String str, String str2) {
        this.nKm = new a(this);
        this.nKm.TE(str2);
        if (at.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.nKm.Ad(str);
        this.nKm.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.nKl = z;
            }
        });
        this.nKm.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.nKi != null) {
                    VideoEasterEggActivity.this.nKi.dSO();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.nKm.dismiss();
            }
        });
        this.nKm.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.nKi != null) {
                    VideoEasterEggActivity.this.nKi.cYr();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).an("obj_locate", 2));
                }
                VideoEasterEggActivity.this.nKm.dismiss();
            }
        });
        this.nKm.d(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.nKl) {
                    VideoEasterEggActivity.this.nKi.dSQ();
                }
            }
        });
        this.nKm.b(getPageContext());
        return this.nKm;
    }
}
