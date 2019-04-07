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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private com.baidu.tbadk.core.view.b eQC;
    private ImageView fNE;
    private ImageView jeP;
    private ScaleVideoView jeQ;
    private View jeR;
    private TextView jeS;
    private TextView jeT;
    private com.baidu.tieba.videoEasterEgg.b.a jeU;
    private a jeY;
    private boolean jeZ;
    private int mSkinType = 3;
    private int jeV = 0;
    private boolean jeW = false;
    private boolean jeX = false;
    private Runnable cNL = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.jeU != null) {
                VideoEasterEggActivity.this.jeU.azE();
            }
        }
    };
    private MediaPlayer.OnInfoListener jfa = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.qM(false);
                e.jH().removeCallbacks(VideoEasterEggActivity.this.cNL);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.jeU = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new am("c13046"));
    }

    private void initUI() {
        this.eQC = new com.baidu.tbadk.core.view.b(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(d.h.video_easter_egg_layout);
        aBy();
        cmh();
        cmi();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aBy() {
        this.fNE = (ImageView) findViewById(d.g.close);
        this.fNE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jeU != null) {
                    VideoEasterEggActivity.this.jeU.onClose();
                }
            }
        });
        this.jeP = (ImageView) findViewById(d.g.share);
        this.jeP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jeU != null) {
                    VideoEasterEggActivity.this.jeU.cmj();
                    VideoEasterEggActivity.this.beJ();
                    TiebaStatic.log(new am("c13045").T("obj_locate", 1));
                }
            }
        });
    }

    private void cmh() {
        this.jeQ = (ScaleVideoView) findViewById(d.g.scale_video_view);
        this.jeQ.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.jeU != null) {
                    VideoEasterEggActivity.this.jeU.azE();
                    return true;
                }
                return true;
            }
        });
        this.jeQ.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.jeZ = true;
                if (VideoEasterEggActivity.this.jeU != null) {
                    VideoEasterEggActivity.this.jeU.cml();
                }
            }
        });
        this.jeQ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.jeQ.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.jfa);
            }
        });
        this.jeQ.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.qM(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.jeZ = false;
            }
        });
        qM(true);
    }

    private void cmi() {
        this.jeR = findViewById(d.g.error_container);
        this.jeS = (TextView) findViewById(d.g.load_error_text);
        this.jeS.setText(d.j.loading_error);
        this.jeT = (TextView) findViewById(d.g.play_text);
        this.jeT.setText(d.j.continues_play);
        this.jeT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jeU != null) {
                    VideoEasterEggActivity.this.jeU.cmk();
                }
            }
        });
        this.jeR.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qM(boolean z) {
        if (z) {
            if (this.eQC != null && !this.eQC.isShowing()) {
                this.eQC.dJ(true);
            }
            this.jeQ.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0277d.cp_btn_a));
            return;
        }
        if (this.eQC != null) {
            this.eQC.dJ(false);
        }
        this.jeQ.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0277d.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jeU != null) {
            this.jeU.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        beJ();
        if (this.jeU != null) {
            this.jeU.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beJ() {
        if (this.jeQ != null && this.jeQ.isPlaying()) {
            this.jeV = this.jeQ.getCurrentPosition();
            this.jeQ.pause();
            this.jeW = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jeU != null) {
            this.jeU.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void DV(String str) {
        if (!ap.isEmpty(str) && !this.jeQ.isPlaying() && !this.jeZ) {
            if (this.jeW) {
                this.jeQ.seekTo(this.jeV);
                this.jeW = false;
            } else {
                this.jeQ.setVideoURI(Uri.parse(str));
                e.jH().postDelayed(this.cNL, 5000L);
            }
            this.jeQ.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void DW(String str) {
        this.jeR.setVisibility(8);
        this.jeW = true;
        this.jeV = 0;
        this.jeZ = false;
        DV(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void eh(String str, String str2) {
        if (this.jeY == null) {
            this.jeY = ei(str, str2);
        }
        this.jeY.aaW();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void zX() {
        e.jH().removeCallbacks(this.cNL);
        this.jeQ.pause();
        this.eQC.dJ(false);
        this.jeR.setVisibility(0);
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
            al.j(this.jeS, d.C0277d.cp_btn_a);
            al.j(this.jeT, d.C0277d.cp_btn_a);
            al.k(this.jeT, d.f.continue_play_bg);
            al.c(this.fNE, d.f.icon_frs_luhan_close);
            al.c(this.jeP, d.f.icon_frs_luhan_share);
        }
    }

    private a ei(String str, String str2) {
        this.jeY = new a(this);
        this.jeY.DT(str2);
        if (ap.isEmpty(str)) {
            str = getResources().getString(d.j.easter_dialog_default_message);
        }
        this.jeY.lz(str);
        this.jeY.a(d.j.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.jeX = z;
            }
        });
        this.jeY.b(d.j.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.jeU != null) {
                    VideoEasterEggActivity.this.jeU.cmk();
                    TiebaStatic.log(new am("c13044"));
                }
                VideoEasterEggActivity.this.jeY.dismiss();
            }
        });
        this.jeY.a(d.j.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.jeU != null) {
                    VideoEasterEggActivity.this.jeU.cmj();
                    TiebaStatic.log(new am("c13045").T("obj_locate", 2));
                }
                VideoEasterEggActivity.this.jeY.dismiss();
            }
        });
        this.jeY.b(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.jeX) {
                    VideoEasterEggActivity.this.jeU.cmm();
                }
            }
        });
        this.jeY.b(getPageContext());
        return this.jeY;
    }
}
