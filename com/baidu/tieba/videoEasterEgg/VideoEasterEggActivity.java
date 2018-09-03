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
import com.baidu.adp.lib.g.e;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private ImageView dZJ;
    private com.baidu.tbadk.core.view.a deF;
    private ImageView hmp;
    private ScaleVideoView hmq;
    private View hmr;
    private TextView hms;
    private TextView hmt;
    private com.baidu.tieba.videoEasterEgg.b.a hmu;
    private a hmy;
    private boolean hmz;
    private int mSkinType = 3;
    private int hmv = 0;
    private boolean hmw = false;
    private boolean hmx = false;
    private Runnable bnM = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.hmu != null) {
                VideoEasterEggActivity.this.hmu.bDI();
            }
        }
    };
    private MediaPlayer.OnInfoListener hmA = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.nf(false);
                e.in().removeCallbacks(VideoEasterEggActivity.this.bnM);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.hmu = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new an("c13046"));
    }

    private void initUI() {
        this.deF = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(f.h.video_easter_egg_layout);
        asl();
        bDE();
        bDF();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void asl() {
        this.dZJ = (ImageView) findViewById(f.g.close);
        this.dZJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hmu != null) {
                    VideoEasterEggActivity.this.hmu.onClose();
                }
            }
        });
        this.hmp = (ImageView) findViewById(f.g.share);
        this.hmp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hmu != null) {
                    VideoEasterEggActivity.this.hmu.bDG();
                    VideoEasterEggActivity.this.awd();
                    TiebaStatic.log(new an("c13045").r("obj_locate", 1));
                }
            }
        });
    }

    private void bDE() {
        this.hmq = (ScaleVideoView) findViewById(f.g.scale_video_view);
        this.hmq.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.hmu != null) {
                    VideoEasterEggActivity.this.hmu.bDI();
                    return true;
                }
                return true;
            }
        });
        this.hmq.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.hmz = true;
                if (VideoEasterEggActivity.this.hmu != null) {
                    VideoEasterEggActivity.this.hmu.bDJ();
                }
            }
        });
        this.hmq.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.hmq.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.hmA);
            }
        });
        this.hmq.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.nf(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.hmz = false;
            }
        });
        nf(true);
    }

    private void bDF() {
        this.hmr = findViewById(f.g.error_container);
        this.hms = (TextView) findViewById(f.g.load_error_text);
        this.hms.setText(f.j.loading_error);
        this.hmt = (TextView) findViewById(f.g.play_text);
        this.hmt.setText(f.j.continues_play);
        this.hmt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hmu != null) {
                    VideoEasterEggActivity.this.hmu.bDH();
                }
            }
        });
        this.hmr.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nf(boolean z) {
        if (z) {
            if (this.deF != null && !this.deF.isShowing()) {
                this.deF.aN(true);
            }
            this.hmq.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(f.d.cp_cont_i));
            return;
        }
        if (this.deF != null) {
            this.deF.aN(false);
        }
        this.hmq.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(f.d.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hmu != null) {
            this.hmu.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        awd();
        if (this.hmu != null) {
            this.hmu.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awd() {
        if (this.hmq != null && this.hmq.isPlaying()) {
            this.hmv = this.hmq.getCurrentPosition();
            this.hmq.pause();
            this.hmw = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hmu != null) {
            this.hmu.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void vk(String str) {
        if (!ap.isEmpty(str) && !this.hmq.isPlaying() && !this.hmz) {
            if (this.hmw) {
                this.hmq.seekTo(this.hmv);
                this.hmw = false;
            } else {
                this.hmq.setVideoURI(Uri.parse(str));
                e.in().postDelayed(this.bnM, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
            this.hmq.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void vl(String str) {
        this.hmr.setVisibility(8);
        this.hmw = true;
        this.hmv = 0;
        this.hmz = false;
        vk(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void cu(String str, String str2) {
        if (this.hmy == null) {
            this.hmy = cv(str, str2);
        }
        this.hmy.xe();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void akh() {
        e.in().removeCallbacks(this.bnM);
        this.hmq.pause();
        this.deF.aN(false);
        this.hmr.setVisibility(0);
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
            am.h(this.hms, f.d.cp_cont_i);
            am.h(this.hmt, f.d.cp_cont_i);
            am.i(this.hmt, f.C0146f.continue_play_bg);
            am.c(this.dZJ, f.C0146f.icon_frs_luhan_close);
            am.c(this.hmp, f.C0146f.icon_frs_luhan_share);
        }
    }

    private a cv(String str, String str2) {
        this.hmy = new a(this);
        this.hmy.vi(str2);
        if (ap.isEmpty(str)) {
            str = getResources().getString(f.j.easter_dialog_default_message);
        }
        this.hmy.dB(str);
        this.hmy.a(f.j.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.hmx = z;
            }
        });
        this.hmy.b(f.j.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.hmu != null) {
                    VideoEasterEggActivity.this.hmu.bDH();
                    TiebaStatic.log(new an("c13044"));
                }
                VideoEasterEggActivity.this.hmy.dismiss();
            }
        });
        this.hmy.a(f.j.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.hmu != null) {
                    VideoEasterEggActivity.this.hmu.bDG();
                    TiebaStatic.log(new an("c13045").r("obj_locate", 2));
                }
                VideoEasterEggActivity.this.hmy.dismiss();
            }
        });
        this.hmy.a(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.hmx) {
                    VideoEasterEggActivity.this.hmu.bDK();
                }
            }
        });
        this.hmy.b(getPageContext());
        return this.hmy;
    }
}
