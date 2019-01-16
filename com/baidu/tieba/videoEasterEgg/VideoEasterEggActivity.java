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
    private d dDB;
    private ImageView eAQ;
    private ImageView hOF;
    private ScaleVideoView hOG;
    private View hOH;
    private TextView hOI;
    private TextView hOJ;
    private com.baidu.tieba.videoEasterEgg.b.a hOK;
    private a hOO;
    private boolean hOP;
    private int mSkinType = 3;
    private int hOL = 0;
    private boolean hOM = false;
    private boolean hON = false;
    private Runnable bCE = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.hOK != null) {
                VideoEasterEggActivity.this.hOK.Zr();
            }
        }
    };
    private MediaPlayer.OnInfoListener hOQ = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.om(false);
                e.jG().removeCallbacks(VideoEasterEggActivity.this.bCE);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.hOK = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new am("c13046"));
    }

    private void initUI() {
        this.dDB = new d(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(e.h.video_easter_egg_layout);
        azR();
        bMI();
        bMJ();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void azR() {
        this.eAQ = (ImageView) findViewById(e.g.close);
        this.eAQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hOK != null) {
                    VideoEasterEggActivity.this.hOK.onClose();
                }
            }
        });
        this.hOF = (ImageView) findViewById(e.g.share);
        this.hOF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hOK != null) {
                    VideoEasterEggActivity.this.hOK.bMK();
                    VideoEasterEggActivity.this.aEc();
                    TiebaStatic.log(new am("c13045").y("obj_locate", 1));
                }
            }
        });
    }

    private void bMI() {
        this.hOG = (ScaleVideoView) findViewById(e.g.scale_video_view);
        this.hOG.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.hOK != null) {
                    VideoEasterEggActivity.this.hOK.Zr();
                    return true;
                }
                return true;
            }
        });
        this.hOG.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.hOP = true;
                if (VideoEasterEggActivity.this.hOK != null) {
                    VideoEasterEggActivity.this.hOK.bMM();
                }
            }
        });
        this.hOG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.hOG.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.hOQ);
            }
        });
        this.hOG.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.om(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.hOP = false;
            }
        });
        om(true);
    }

    private void bMJ() {
        this.hOH = findViewById(e.g.error_container);
        this.hOI = (TextView) findViewById(e.g.load_error_text);
        this.hOI.setText(e.j.loading_error);
        this.hOJ = (TextView) findViewById(e.g.play_text);
        this.hOJ.setText(e.j.continues_play);
        this.hOJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hOK != null) {
                    VideoEasterEggActivity.this.hOK.bML();
                }
            }
        });
        this.hOH.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void om(boolean z) {
        if (z) {
            if (this.dDB != null && !this.dDB.isShowing()) {
                this.dDB.bB(true);
            }
            this.hOG.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.cp_cont_i));
            return;
        }
        if (this.dDB != null) {
            this.dDB.bB(false);
        }
        this.hOG.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hOK != null) {
            this.hOK.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        aEc();
        if (this.hOK != null) {
            this.hOK.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEc() {
        if (this.hOG != null && this.hOG.isPlaying()) {
            this.hOL = this.hOG.getCurrentPosition();
            this.hOG.pause();
            this.hOM = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hOK != null) {
            this.hOK.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void xv(String str) {
        if (!ao.isEmpty(str) && !this.hOG.isPlaying() && !this.hOP) {
            if (this.hOM) {
                this.hOG.seekTo(this.hOL);
                this.hOM = false;
            } else {
                this.hOG.setVideoURI(Uri.parse(str));
                com.baidu.adp.lib.g.e.jG().postDelayed(this.bCE, 5000L);
            }
            this.hOG.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void xw(String str) {
        this.hOH.setVisibility(8);
        this.hOM = true;
        this.hOL = 0;
        this.hOP = false;
        xv(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void cW(String str, String str2) {
        if (this.hOO == null) {
            this.hOO = cX(str, str2);
        }
        this.hOO.BS();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void showErrorView() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bCE);
        this.hOG.pause();
        this.dDB.bB(false);
        this.hOH.setVisibility(0);
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
            al.h(this.hOI, e.d.cp_cont_i);
            al.h(this.hOJ, e.d.cp_cont_i);
            al.i(this.hOJ, e.f.continue_play_bg);
            al.c(this.eAQ, e.f.icon_frs_luhan_close);
            al.c(this.hOF, e.f.icon_frs_luhan_share);
        }
    }

    private a cX(String str, String str2) {
        this.hOO = new a(this);
        this.hOO.xt(str2);
        if (ao.isEmpty(str)) {
            str = getResources().getString(e.j.easter_dialog_default_message);
        }
        this.hOO.eK(str);
        this.hOO.a(e.j.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.hON = z;
            }
        });
        this.hOO.b(e.j.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.hOK != null) {
                    VideoEasterEggActivity.this.hOK.bML();
                    TiebaStatic.log(new am("c13044"));
                }
                VideoEasterEggActivity.this.hOO.dismiss();
            }
        });
        this.hOO.a(e.j.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.hOK != null) {
                    VideoEasterEggActivity.this.hOK.bMK();
                    TiebaStatic.log(new am("c13045").y("obj_locate", 2));
                }
                VideoEasterEggActivity.this.hOO.dismiss();
            }
        });
        this.hOO.a(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.hON) {
                    VideoEasterEggActivity.this.hOK.bMN();
                }
            }
        });
        this.hOO.b(getPageContext());
        return this.hOO;
    }
}
