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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.d;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private d dDC;
    private ImageView eAR;
    private ImageView hOG;
    private ScaleVideoView hOH;
    private View hOI;
    private TextView hOJ;
    private TextView hOK;
    private com.baidu.tieba.videoEasterEgg.b.a hOL;
    private a hOP;
    private boolean hOQ;
    private int mSkinType = 3;
    private int hOM = 0;
    private boolean hON = false;
    private boolean hOO = false;
    private Runnable bCF = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.hOL != null) {
                VideoEasterEggActivity.this.hOL.Zr();
            }
        }
    };
    private MediaPlayer.OnInfoListener hOR = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.om(false);
                e.jG().removeCallbacks(VideoEasterEggActivity.this.bCF);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.hOL = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new am("c13046"));
    }

    private void initUI() {
        this.dDC = new d(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(e.h.video_easter_egg_layout);
        azR();
        bMI();
        bMJ();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void azR() {
        this.eAR = (ImageView) findViewById(e.g.close);
        this.eAR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hOL != null) {
                    VideoEasterEggActivity.this.hOL.onClose();
                }
            }
        });
        this.hOG = (ImageView) findViewById(e.g.share);
        this.hOG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hOL != null) {
                    VideoEasterEggActivity.this.hOL.bMK();
                    VideoEasterEggActivity.this.aEc();
                    TiebaStatic.log(new am("c13045").y("obj_locate", 1));
                }
            }
        });
    }

    private void bMI() {
        this.hOH = (ScaleVideoView) findViewById(e.g.scale_video_view);
        this.hOH.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.hOL != null) {
                    VideoEasterEggActivity.this.hOL.Zr();
                    return true;
                }
                return true;
            }
        });
        this.hOH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.hOQ = true;
                if (VideoEasterEggActivity.this.hOL != null) {
                    VideoEasterEggActivity.this.hOL.bMM();
                }
            }
        });
        this.hOH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.hOH.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.hOR);
            }
        });
        this.hOH.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.om(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.hOQ = false;
            }
        });
        om(true);
    }

    private void bMJ() {
        this.hOI = findViewById(e.g.error_container);
        this.hOJ = (TextView) findViewById(e.g.load_error_text);
        this.hOJ.setText(e.j.loading_error);
        this.hOK = (TextView) findViewById(e.g.play_text);
        this.hOK.setText(e.j.continues_play);
        this.hOK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hOL != null) {
                    VideoEasterEggActivity.this.hOL.bML();
                }
            }
        });
        this.hOI.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void om(boolean z) {
        if (z) {
            if (this.dDC != null && !this.dDC.isShowing()) {
                this.dDC.bB(true);
            }
            this.hOH.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.cp_cont_i));
            return;
        }
        if (this.dDC != null) {
            this.dDC.bB(false);
        }
        this.hOH.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hOL != null) {
            this.hOL.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        aEc();
        if (this.hOL != null) {
            this.hOL.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEc() {
        if (this.hOH != null && this.hOH.isPlaying()) {
            this.hOM = this.hOH.getCurrentPosition();
            this.hOH.pause();
            this.hON = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hOL != null) {
            this.hOL.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void xv(String str) {
        if (!ao.isEmpty(str) && !this.hOH.isPlaying() && !this.hOQ) {
            if (this.hON) {
                this.hOH.seekTo(this.hOM);
                this.hON = false;
            } else {
                this.hOH.setVideoURI(Uri.parse(str));
                com.baidu.adp.lib.g.e.jG().postDelayed(this.bCF, 5000L);
            }
            this.hOH.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void xw(String str) {
        this.hOI.setVisibility(8);
        this.hON = true;
        this.hOM = 0;
        this.hOQ = false;
        xv(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void cW(String str, String str2) {
        if (this.hOP == null) {
            this.hOP = cX(str, str2);
        }
        this.hOP.BS();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void showErrorView() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bCF);
        this.hOH.pause();
        this.dDC.bB(false);
        this.hOI.setVisibility(0);
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
            al.h(this.hOJ, e.d.cp_cont_i);
            al.h(this.hOK, e.d.cp_cont_i);
            al.i(this.hOK, e.f.continue_play_bg);
            al.c(this.eAR, e.f.icon_frs_luhan_close);
            al.c(this.hOG, e.f.icon_frs_luhan_share);
        }
    }

    private a cX(String str, String str2) {
        this.hOP = new a(this);
        this.hOP.xt(str2);
        if (ao.isEmpty(str)) {
            str = getResources().getString(e.j.easter_dialog_default_message);
        }
        this.hOP.eK(str);
        this.hOP.a(e.j.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.hOO = z;
            }
        });
        this.hOP.b(e.j.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.hOL != null) {
                    VideoEasterEggActivity.this.hOL.bML();
                    TiebaStatic.log(new am("c13044"));
                }
                VideoEasterEggActivity.this.hOP.dismiss();
            }
        });
        this.hOP.a(e.j.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.hOL != null) {
                    VideoEasterEggActivity.this.hOL.bMK();
                    TiebaStatic.log(new am("c13045").y("obj_locate", 2));
                }
                VideoEasterEggActivity.this.hOP.dismiss();
            }
        });
        this.hOP.a(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.hOO) {
                    VideoEasterEggActivity.this.hOL.bMN();
                }
            }
        });
        this.hOP.b(getPageContext());
        return this.hOP;
    }
}
