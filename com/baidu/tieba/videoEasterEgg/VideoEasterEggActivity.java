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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private ImageView dZM;
    private com.baidu.tbadk.core.view.a deH;
    private ImageView hmo;
    private ScaleVideoView hmp;
    private View hmq;
    private TextView hmr;
    private TextView hms;
    private com.baidu.tieba.videoEasterEgg.b.a hmt;
    private a hmx;
    private boolean hmy;
    private int mSkinType = 3;
    private int hmu = 0;
    private boolean hmv = false;
    private boolean hmw = false;
    private Runnable bnJ = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.hmt != null) {
                VideoEasterEggActivity.this.hmt.bDG();
            }
        }
    };
    private MediaPlayer.OnInfoListener hmz = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.nf(false);
                e.in().removeCallbacks(VideoEasterEggActivity.this.bnJ);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.hmt = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new an("c13046"));
    }

    private void initUI() {
        this.deH = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(d.h.video_easter_egg_layout);
        asl();
        bDC();
        bDD();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void asl() {
        this.dZM = (ImageView) findViewById(d.g.close);
        this.dZM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hmt != null) {
                    VideoEasterEggActivity.this.hmt.onClose();
                }
            }
        });
        this.hmo = (ImageView) findViewById(d.g.share);
        this.hmo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hmt != null) {
                    VideoEasterEggActivity.this.hmt.bDE();
                    VideoEasterEggActivity.this.awe();
                    TiebaStatic.log(new an("c13045").r("obj_locate", 1));
                }
            }
        });
    }

    private void bDC() {
        this.hmp = (ScaleVideoView) findViewById(d.g.scale_video_view);
        this.hmp.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.hmt != null) {
                    VideoEasterEggActivity.this.hmt.bDG();
                    return true;
                }
                return true;
            }
        });
        this.hmp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.hmy = true;
                if (VideoEasterEggActivity.this.hmt != null) {
                    VideoEasterEggActivity.this.hmt.bDH();
                }
            }
        });
        this.hmp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.hmp.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.hmz);
            }
        });
        this.hmp.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.nf(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.hmy = false;
            }
        });
        nf(true);
    }

    private void bDD() {
        this.hmq = findViewById(d.g.error_container);
        this.hmr = (TextView) findViewById(d.g.load_error_text);
        this.hmr.setText(d.j.loading_error);
        this.hms = (TextView) findViewById(d.g.play_text);
        this.hms.setText(d.j.continues_play);
        this.hms.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hmt != null) {
                    VideoEasterEggActivity.this.hmt.bDF();
                }
            }
        });
        this.hmq.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nf(boolean z) {
        if (z) {
            if (this.deH != null && !this.deH.isShowing()) {
                this.deH.aM(true);
            }
            this.hmp.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0140d.cp_cont_i));
            return;
        }
        if (this.deH != null) {
            this.deH.aM(false);
        }
        this.hmp.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0140d.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hmt != null) {
            this.hmt.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        awe();
        if (this.hmt != null) {
            this.hmt.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awe() {
        if (this.hmp != null && this.hmp.isPlaying()) {
            this.hmu = this.hmp.getCurrentPosition();
            this.hmp.pause();
            this.hmv = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hmt != null) {
            this.hmt.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void vg(String str) {
        if (!ap.isEmpty(str) && !this.hmp.isPlaying() && !this.hmy) {
            if (this.hmv) {
                this.hmp.seekTo(this.hmu);
                this.hmv = false;
            } else {
                this.hmp.setVideoURI(Uri.parse(str));
                e.in().postDelayed(this.bnJ, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
            this.hmp.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void vh(String str) {
        this.hmq.setVisibility(8);
        this.hmv = true;
        this.hmu = 0;
        this.hmy = false;
        vg(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void cu(String str, String str2) {
        if (this.hmx == null) {
            this.hmx = cv(str, str2);
        }
        this.hmx.xf();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void akf() {
        e.in().removeCallbacks(this.bnJ);
        this.hmp.pause();
        this.deH.aM(false);
        this.hmq.setVisibility(0);
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
            am.h(this.hmr, d.C0140d.cp_cont_i);
            am.h(this.hms, d.C0140d.cp_cont_i);
            am.i(this.hms, d.f.continue_play_bg);
            am.c(this.dZM, d.f.icon_frs_luhan_close);
            am.c(this.hmo, d.f.icon_frs_luhan_share);
        }
    }

    private a cv(String str, String str2) {
        this.hmx = new a(this);
        this.hmx.ve(str2);
        if (ap.isEmpty(str)) {
            str = getResources().getString(d.j.easter_dialog_default_message);
        }
        this.hmx.dB(str);
        this.hmx.a(d.j.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.hmw = z;
            }
        });
        this.hmx.b(d.j.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.hmt != null) {
                    VideoEasterEggActivity.this.hmt.bDF();
                    TiebaStatic.log(new an("c13044"));
                }
                VideoEasterEggActivity.this.hmx.dismiss();
            }
        });
        this.hmx.a(d.j.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.hmt != null) {
                    VideoEasterEggActivity.this.hmt.bDE();
                    TiebaStatic.log(new an("c13045").r("obj_locate", 2));
                }
                VideoEasterEggActivity.this.hmx.dismiss();
            }
        });
        this.hmx.a(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.hmw) {
                    VideoEasterEggActivity.this.hmt.bDI();
                }
            }
        });
        this.hmx.b(getPageContext());
        return this.hmx;
    }
}
