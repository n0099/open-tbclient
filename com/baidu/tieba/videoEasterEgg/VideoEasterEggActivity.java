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
    private com.baidu.tbadk.core.view.b eQQ;
    private ImageView fNQ;
    private ImageView jfb;
    private ScaleVideoView jfc;
    private View jfd;
    private TextView jfe;
    private TextView jff;
    private com.baidu.tieba.videoEasterEgg.b.a jfg;
    private a jfk;
    private boolean jfl;
    private int mSkinType = 3;
    private int jfh = 0;
    private boolean jfi = false;
    private boolean jfj = false;
    private Runnable cNJ = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.jfg != null) {
                VideoEasterEggActivity.this.jfg.azH();
            }
        }
    };
    private MediaPlayer.OnInfoListener jfm = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.qM(false);
                e.jH().removeCallbacks(VideoEasterEggActivity.this.cNJ);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.jfg = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new am("c13046"));
    }

    private void initUI() {
        this.eQQ = new com.baidu.tbadk.core.view.b(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(d.h.video_easter_egg_layout);
        aBB();
        cmj();
        cmk();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aBB() {
        this.fNQ = (ImageView) findViewById(d.g.close);
        this.fNQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jfg != null) {
                    VideoEasterEggActivity.this.jfg.onClose();
                }
            }
        });
        this.jfb = (ImageView) findViewById(d.g.share);
        this.jfb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jfg != null) {
                    VideoEasterEggActivity.this.jfg.cml();
                    VideoEasterEggActivity.this.beL();
                    TiebaStatic.log(new am("c13045").T("obj_locate", 1));
                }
            }
        });
    }

    private void cmj() {
        this.jfc = (ScaleVideoView) findViewById(d.g.scale_video_view);
        this.jfc.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.jfg != null) {
                    VideoEasterEggActivity.this.jfg.azH();
                    return true;
                }
                return true;
            }
        });
        this.jfc.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.jfl = true;
                if (VideoEasterEggActivity.this.jfg != null) {
                    VideoEasterEggActivity.this.jfg.cmn();
                }
            }
        });
        this.jfc.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.jfc.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.jfm);
            }
        });
        this.jfc.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.qM(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.jfl = false;
            }
        });
        qM(true);
    }

    private void cmk() {
        this.jfd = findViewById(d.g.error_container);
        this.jfe = (TextView) findViewById(d.g.load_error_text);
        this.jfe.setText(d.j.loading_error);
        this.jff = (TextView) findViewById(d.g.play_text);
        this.jff.setText(d.j.continues_play);
        this.jff.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jfg != null) {
                    VideoEasterEggActivity.this.jfg.cmm();
                }
            }
        });
        this.jfd.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qM(boolean z) {
        if (z) {
            if (this.eQQ != null && !this.eQQ.isShowing()) {
                this.eQQ.dJ(true);
            }
            this.jfc.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0277d.cp_btn_a));
            return;
        }
        if (this.eQQ != null) {
            this.eQQ.dJ(false);
        }
        this.jfc.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0277d.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jfg != null) {
            this.jfg.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        beL();
        if (this.jfg != null) {
            this.jfg.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beL() {
        if (this.jfc != null && this.jfc.isPlaying()) {
            this.jfh = this.jfc.getCurrentPosition();
            this.jfc.pause();
            this.jfi = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jfg != null) {
            this.jfg.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void DW(String str) {
        if (!ap.isEmpty(str) && !this.jfc.isPlaying() && !this.jfl) {
            if (this.jfi) {
                this.jfc.seekTo(this.jfh);
                this.jfi = false;
            } else {
                this.jfc.setVideoURI(Uri.parse(str));
                e.jH().postDelayed(this.cNJ, 5000L);
            }
            this.jfc.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void DX(String str) {
        this.jfd.setVisibility(8);
        this.jfi = true;
        this.jfh = 0;
        this.jfl = false;
        DW(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void eg(String str, String str2) {
        if (this.jfk == null) {
            this.jfk = eh(str, str2);
        }
        this.jfk.aaZ();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void zY() {
        e.jH().removeCallbacks(this.cNJ);
        this.jfc.pause();
        this.eQQ.dJ(false);
        this.jfd.setVisibility(0);
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
            al.j(this.jfe, d.C0277d.cp_btn_a);
            al.j(this.jff, d.C0277d.cp_btn_a);
            al.k(this.jff, d.f.continue_play_bg);
            al.c(this.fNQ, d.f.icon_frs_luhan_close);
            al.c(this.jfb, d.f.icon_frs_luhan_share);
        }
    }

    private a eh(String str, String str2) {
        this.jfk = new a(this);
        this.jfk.DU(str2);
        if (ap.isEmpty(str)) {
            str = getResources().getString(d.j.easter_dialog_default_message);
        }
        this.jfk.ly(str);
        this.jfk.a(d.j.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.jfj = z;
            }
        });
        this.jfk.b(d.j.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.jfg != null) {
                    VideoEasterEggActivity.this.jfg.cmm();
                    TiebaStatic.log(new am("c13044"));
                }
                VideoEasterEggActivity.this.jfk.dismiss();
            }
        });
        this.jfk.a(d.j.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.jfg != null) {
                    VideoEasterEggActivity.this.jfg.cml();
                    TiebaStatic.log(new am("c13045").T("obj_locate", 2));
                }
                VideoEasterEggActivity.this.jfk.dismiss();
            }
        });
        this.jfk.b(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.jfj) {
                    VideoEasterEggActivity.this.jfg.cmo();
                }
            }
        });
        this.jfk.b(getPageContext());
        return this.jfk;
    }
}
