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
    private com.baidu.tbadk.core.view.b eQD;
    private ImageView fNE;
    private ImageView jeQ;
    private ScaleVideoView jeR;
    private View jeS;
    private TextView jeT;
    private TextView jeU;
    private com.baidu.tieba.videoEasterEgg.b.a jeV;
    private a jeZ;
    private boolean jfa;
    private int mSkinType = 3;
    private int jeW = 0;
    private boolean jeX = false;
    private boolean jeY = false;
    private Runnable cNM = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.jeV != null) {
                VideoEasterEggActivity.this.jeV.azE();
            }
        }
    };
    private MediaPlayer.OnInfoListener jfb = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.qM(false);
                e.jH().removeCallbacks(VideoEasterEggActivity.this.cNM);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.jeV = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new am("c13046"));
    }

    private void initUI() {
        this.eQD = new com.baidu.tbadk.core.view.b(getPageContext());
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
                if (VideoEasterEggActivity.this.jeV != null) {
                    VideoEasterEggActivity.this.jeV.onClose();
                }
            }
        });
        this.jeQ = (ImageView) findViewById(d.g.share);
        this.jeQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jeV != null) {
                    VideoEasterEggActivity.this.jeV.cmj();
                    VideoEasterEggActivity.this.beJ();
                    TiebaStatic.log(new am("c13045").T("obj_locate", 1));
                }
            }
        });
    }

    private void cmh() {
        this.jeR = (ScaleVideoView) findViewById(d.g.scale_video_view);
        this.jeR.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.jeV != null) {
                    VideoEasterEggActivity.this.jeV.azE();
                    return true;
                }
                return true;
            }
        });
        this.jeR.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.jfa = true;
                if (VideoEasterEggActivity.this.jeV != null) {
                    VideoEasterEggActivity.this.jeV.cml();
                }
            }
        });
        this.jeR.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.jeR.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.jfb);
            }
        });
        this.jeR.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.qM(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.jfa = false;
            }
        });
        qM(true);
    }

    private void cmi() {
        this.jeS = findViewById(d.g.error_container);
        this.jeT = (TextView) findViewById(d.g.load_error_text);
        this.jeT.setText(d.j.loading_error);
        this.jeU = (TextView) findViewById(d.g.play_text);
        this.jeU.setText(d.j.continues_play);
        this.jeU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jeV != null) {
                    VideoEasterEggActivity.this.jeV.cmk();
                }
            }
        });
        this.jeS.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qM(boolean z) {
        if (z) {
            if (this.eQD != null && !this.eQD.isShowing()) {
                this.eQD.dJ(true);
            }
            this.jeR.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0277d.cp_btn_a));
            return;
        }
        if (this.eQD != null) {
            this.eQD.dJ(false);
        }
        this.jeR.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0277d.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jeV != null) {
            this.jeV.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        beJ();
        if (this.jeV != null) {
            this.jeV.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beJ() {
        if (this.jeR != null && this.jeR.isPlaying()) {
            this.jeW = this.jeR.getCurrentPosition();
            this.jeR.pause();
            this.jeX = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jeV != null) {
            this.jeV.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void DV(String str) {
        if (!ap.isEmpty(str) && !this.jeR.isPlaying() && !this.jfa) {
            if (this.jeX) {
                this.jeR.seekTo(this.jeW);
                this.jeX = false;
            } else {
                this.jeR.setVideoURI(Uri.parse(str));
                e.jH().postDelayed(this.cNM, 5000L);
            }
            this.jeR.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void DW(String str) {
        this.jeS.setVisibility(8);
        this.jeX = true;
        this.jeW = 0;
        this.jfa = false;
        DV(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void eh(String str, String str2) {
        if (this.jeZ == null) {
            this.jeZ = ei(str, str2);
        }
        this.jeZ.aaW();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void zX() {
        e.jH().removeCallbacks(this.cNM);
        this.jeR.pause();
        this.eQD.dJ(false);
        this.jeS.setVisibility(0);
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
            al.j(this.jeT, d.C0277d.cp_btn_a);
            al.j(this.jeU, d.C0277d.cp_btn_a);
            al.k(this.jeU, d.f.continue_play_bg);
            al.c(this.fNE, d.f.icon_frs_luhan_close);
            al.c(this.jeQ, d.f.icon_frs_luhan_share);
        }
    }

    private a ei(String str, String str2) {
        this.jeZ = new a(this);
        this.jeZ.DT(str2);
        if (ap.isEmpty(str)) {
            str = getResources().getString(d.j.easter_dialog_default_message);
        }
        this.jeZ.lz(str);
        this.jeZ.a(d.j.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.jeY = z;
            }
        });
        this.jeZ.b(d.j.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.jeV != null) {
                    VideoEasterEggActivity.this.jeV.cmk();
                    TiebaStatic.log(new am("c13044"));
                }
                VideoEasterEggActivity.this.jeZ.dismiss();
            }
        });
        this.jeZ.a(d.j.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.jeV != null) {
                    VideoEasterEggActivity.this.jeV.cmj();
                    TiebaStatic.log(new am("c13045").T("obj_locate", 2));
                }
                VideoEasterEggActivity.this.jeZ.dismiss();
            }
        });
        this.jeZ.b(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.jeY) {
                    VideoEasterEggActivity.this.jeV.cmm();
                }
            }
        });
        this.jeZ.b(getPageContext());
        return this.jeZ;
    }
}
