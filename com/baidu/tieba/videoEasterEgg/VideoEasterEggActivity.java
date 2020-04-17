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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private ImageView fOY;
    private com.baidu.tbadk.core.view.a hzL;
    private ImageView lrh;
    private ScaleVideoView lri;
    private View lrj;
    private TextView lrk;
    private TextView lrl;
    private com.baidu.tieba.videoEasterEgg.b.a lrm;
    private a lrq;
    private boolean lrr;
    private int mSkinType = 3;
    private int lrn = 0;
    private boolean lro = false;
    private boolean lrp = false;
    private Runnable lrs = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.lrm != null) {
                VideoEasterEggActivity.this.lrm.cJt();
            }
        }
    };
    private MediaPlayer.OnInfoListener lrt = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.uG(false);
                e.lb().removeCallbacks(VideoEasterEggActivity.this.lrs);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.lrm = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.hzL = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        blF();
        ddL();
        ddM();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void blF() {
        this.fOY = (ImageView) findViewById(R.id.close);
        this.fOY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.lrm != null) {
                    VideoEasterEggActivity.this.lrm.onClose();
                }
            }
        });
        this.lrh = (ImageView) findViewById(R.id.share);
        this.lrh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.lrm != null) {
                    VideoEasterEggActivity.this.lrm.ddN();
                    VideoEasterEggActivity.this.bQX();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).af("obj_locate", 1));
                }
            }
        });
    }

    private void ddL() {
        this.lri = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.lri.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.lrm != null) {
                    VideoEasterEggActivity.this.lrm.cJt();
                    return true;
                }
                return true;
            }
        });
        this.lri.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.lrr = true;
                if (VideoEasterEggActivity.this.lrm != null) {
                    VideoEasterEggActivity.this.lrm.ddP();
                }
            }
        });
        this.lri.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.lri.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.lrt);
            }
        });
        this.lri.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.uG(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.lrr = false;
            }
        });
        uG(true);
    }

    private void ddM() {
        this.lrj = findViewById(R.id.error_container);
        this.lrk = (TextView) findViewById(R.id.load_error_text);
        this.lrk.setText(R.string.loading_error);
        this.lrl = (TextView) findViewById(R.id.play_text);
        this.lrl.setText(R.string.continues_play);
        this.lrl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.lrm != null) {
                    VideoEasterEggActivity.this.lrm.ddO();
                }
            }
        });
        this.lrj.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uG(boolean z) {
        if (z) {
            if (this.hzL != null && !this.hzL.isShowing()) {
                this.hzL.setDialogVisiable(true);
            }
            this.lri.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_a));
            return;
        }
        if (this.hzL != null) {
            this.hzL.setDialogVisiable(false);
        }
        this.lri.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lrm != null) {
            this.lrm.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        bQX();
        if (this.lrm != null) {
            this.lrm.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQX() {
        if (this.lri != null && this.lri.isPlaying()) {
            this.lrn = this.lri.getCurrentPosition();
            this.lri.pause();
            this.lro = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lrm != null) {
            this.lrm.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Mg(String str) {
        if (!aq.isEmpty(str) && !this.lri.isPlaying() && !this.lrr) {
            if (this.lro) {
                this.lri.seekTo(this.lrn);
                this.lro = false;
            } else {
                this.lri.setVideoURI(Uri.parse(str));
                e.lb().postDelayed(this.lrs, 5000L);
            }
            this.lri.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Mh(String str) {
        this.lrj.setVisibility(8);
        this.lro = true;
        this.lrn = 0;
        this.lrr = false;
        Mg(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void eZ(String str, String str2) {
        if (this.lrq == null) {
            this.lrq = fa(str, str2);
        }
        this.lrq.aMU();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Ym() {
        e.lb().removeCallbacks(this.lrs);
        this.lri.pause();
        this.hzL.setDialogVisiable(false);
        this.lrj.setVisibility(0);
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
            am.setViewTextColor(this.lrk, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.lrl, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.lrl, R.drawable.continue_play_bg);
            am.setImageResource(this.fOY, R.drawable.icon_frs_luhan_close);
            am.setImageResource(this.lrh, R.drawable.icon_frs_luhan_share);
        }
    }

    private a fa(String str, String str2) {
        this.lrq = new a(this);
        this.lrq.Me(str2);
        if (aq.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.lrq.uf(str);
        this.lrq.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.lrp = z;
            }
        });
        this.lrq.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.lrm != null) {
                    VideoEasterEggActivity.this.lrm.ddO();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.lrq.dismiss();
            }
        });
        this.lrq.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.lrm != null) {
                    VideoEasterEggActivity.this.lrm.ddN();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).af("obj_locate", 2));
                }
                VideoEasterEggActivity.this.lrq.dismiss();
            }
        });
        this.lrq.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.lrp) {
                    VideoEasterEggActivity.this.lrm.ddQ();
                }
            }
        });
        this.lrq.b(getPageContext());
        return this.lrq;
    }
}
