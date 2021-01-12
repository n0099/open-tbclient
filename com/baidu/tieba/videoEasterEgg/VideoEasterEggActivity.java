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
    private ImageView nKc;
    private ScaleVideoView nKd;
    private View nKe;
    private TextView nKf;
    private TextView nKg;
    private com.baidu.tieba.videoEasterEgg.b.a nKh;
    private a nKl;
    private boolean nKm;
    private int mSkinType = 3;
    private int nKi = 0;
    private boolean nKj = false;
    private boolean nKk = false;
    private Runnable nKn = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.nKh != null) {
                VideoEasterEggActivity.this.nKh.dxI();
            }
        }
    };
    private MediaPlayer.OnInfoListener nKo = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.yP(false);
                e.mB().removeCallbacks(VideoEasterEggActivity.this.nKn);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.nKh = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
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
                if (VideoEasterEggActivity.this.nKh != null) {
                    VideoEasterEggActivity.this.nKh.onClose();
                }
            }
        });
        this.nKc = (ImageView) findViewById(R.id.share);
        this.nKc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nKh != null) {
                    VideoEasterEggActivity.this.nKh.cYr();
                    VideoEasterEggActivity.this.pauseVideo();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).an("obj_locate", 1));
                }
            }
        });
    }

    private void dSM() {
        this.nKd = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.nKd.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.nKh != null) {
                    VideoEasterEggActivity.this.nKh.dxI();
                    return true;
                }
                return true;
            }
        });
        this.nKd.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.nKm = true;
                if (VideoEasterEggActivity.this.nKh != null) {
                    VideoEasterEggActivity.this.nKh.dSP();
                }
            }
        });
        this.nKd.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.nKd.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.nKo);
            }
        });
        this.nKd.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.yP(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.nKm = false;
            }
        });
        yP(true);
    }

    private void dSN() {
        this.nKe = findViewById(R.id.error_container);
        this.nKf = (TextView) findViewById(R.id.load_error_text);
        this.nKf.setText(R.string.loading_error);
        this.nKg = (TextView) findViewById(R.id.play_text);
        this.nKg.setText(R.string.continues_play);
        this.nKg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nKh != null) {
                    VideoEasterEggActivity.this.nKh.dSO();
                }
            }
        });
        this.nKe.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yP(boolean z) {
        if (z) {
            if (this.jHF != null && !this.jHF.isShowing()) {
                this.jHF.setDialogVisiable(true);
            }
            this.nKd.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
            return;
        }
        if (this.jHF != null) {
            this.jHF.setDialogVisiable(false);
        }
        this.nKd.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nKh != null) {
            this.nKh.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        pauseVideo();
        if (this.nKh != null) {
            this.nKh.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseVideo() {
        if (this.nKd != null && this.nKd.isPlaying()) {
            this.nKi = this.nKd.getCurrentPosition();
            this.nKd.pause();
            this.nKj = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nKh != null) {
            this.nKh.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void TF(String str) {
        if (!at.isEmpty(str) && !this.nKd.isPlaying() && !this.nKm) {
            if (this.nKj) {
                this.nKd.seekTo(this.nKi);
                this.nKj = false;
            } else {
                this.nKd.setVideoURI(Uri.parse(str));
                e.mB().postDelayed(this.nKn, 5000L);
            }
            this.nKd.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void TG(String str) {
        this.nKe.setVisibility(8);
        this.nKj = true;
        this.nKi = 0;
        this.nKm = false;
        TF(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void gD(String str, String str2) {
        if (this.nKl == null) {
            this.nKl = gE(str, str2);
        }
        this.nKl.bqe();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void arA() {
        e.mB().removeCallbacks(this.nKn);
        this.nKd.pause();
        this.jHF.setDialogVisiable(false);
        this.nKe.setVisibility(0);
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
            ao.setViewTextColor(this.nKf, R.color.CAM_X0101);
            ao.setViewTextColor(this.nKg, R.color.CAM_X0101);
            ao.setBackgroundResource(this.nKg, R.drawable.continue_play_bg);
            ao.setImageResource(this.kdU, R.drawable.icon_frs_luhan_close);
            ao.setImageResource(this.nKc, R.drawable.icon_frs_luhan_share);
        }
    }

    private a gE(String str, String str2) {
        this.nKl = new a(this);
        this.nKl.TD(str2);
        if (at.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.nKl.Ad(str);
        this.nKl.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.nKk = z;
            }
        });
        this.nKl.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.nKh != null) {
                    VideoEasterEggActivity.this.nKh.dSO();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.nKl.dismiss();
            }
        });
        this.nKl.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.nKh != null) {
                    VideoEasterEggActivity.this.nKh.cYr();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).an("obj_locate", 2));
                }
                VideoEasterEggActivity.this.nKl.dismiss();
            }
        });
        this.nKl.d(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.nKk) {
                    VideoEasterEggActivity.this.nKh.dSQ();
                }
            }
        });
        this.nKl.b(getPageContext());
        return this.nKl;
    }
}
