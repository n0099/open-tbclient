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
    private d dAf;
    private ImageView exm;
    private ImageView hKn;
    private ScaleVideoView hKo;
    private View hKp;
    private TextView hKq;
    private TextView hKr;
    private com.baidu.tieba.videoEasterEgg.b.a hKs;
    private a hKw;
    private boolean hKx;
    private int mSkinType = 3;
    private int hKt = 0;
    private boolean hKu = false;
    private boolean hKv = false;
    private Runnable bBO = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.hKs != null) {
                VideoEasterEggActivity.this.hKs.YS();
            }
        }
    };
    private MediaPlayer.OnInfoListener hKy = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.oi(false);
                e.jG().removeCallbacks(VideoEasterEggActivity.this.bBO);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.hKs = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new am("c13046"));
    }

    private void initUI() {
        this.dAf = new d(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(e.h.video_easter_egg_layout);
        ayF();
        bLk();
        bLl();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void ayF() {
        this.exm = (ImageView) findViewById(e.g.close);
        this.exm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hKs != null) {
                    VideoEasterEggActivity.this.hKs.onClose();
                }
            }
        });
        this.hKn = (ImageView) findViewById(e.g.share);
        this.hKn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hKs != null) {
                    VideoEasterEggActivity.this.hKs.bLm();
                    VideoEasterEggActivity.this.aCQ();
                    TiebaStatic.log(new am("c13045").x("obj_locate", 1));
                }
            }
        });
    }

    private void bLk() {
        this.hKo = (ScaleVideoView) findViewById(e.g.scale_video_view);
        this.hKo.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.hKs != null) {
                    VideoEasterEggActivity.this.hKs.YS();
                    return true;
                }
                return true;
            }
        });
        this.hKo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.hKx = true;
                if (VideoEasterEggActivity.this.hKs != null) {
                    VideoEasterEggActivity.this.hKs.bLo();
                }
            }
        });
        this.hKo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.hKo.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.hKy);
            }
        });
        this.hKo.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.oi(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.hKx = false;
            }
        });
        oi(true);
    }

    private void bLl() {
        this.hKp = findViewById(e.g.error_container);
        this.hKq = (TextView) findViewById(e.g.load_error_text);
        this.hKq.setText(e.j.loading_error);
        this.hKr = (TextView) findViewById(e.g.play_text);
        this.hKr.setText(e.j.continues_play);
        this.hKr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hKs != null) {
                    VideoEasterEggActivity.this.hKs.bLn();
                }
            }
        });
        this.hKp.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oi(boolean z) {
        if (z) {
            if (this.dAf != null && !this.dAf.isShowing()) {
                this.dAf.bA(true);
            }
            this.hKo.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.cp_cont_i));
            return;
        }
        if (this.dAf != null) {
            this.dAf.bA(false);
        }
        this.hKo.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hKs != null) {
            this.hKs.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        aCQ();
        if (this.hKs != null) {
            this.hKs.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCQ() {
        if (this.hKo != null && this.hKo.isPlaying()) {
            this.hKt = this.hKo.getCurrentPosition();
            this.hKo.pause();
            this.hKu = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hKs != null) {
            this.hKs.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void xc(String str) {
        if (!ao.isEmpty(str) && !this.hKo.isPlaying() && !this.hKx) {
            if (this.hKu) {
                this.hKo.seekTo(this.hKt);
                this.hKu = false;
            } else {
                this.hKo.setVideoURI(Uri.parse(str));
                com.baidu.adp.lib.g.e.jG().postDelayed(this.bBO, 5000L);
            }
            this.hKo.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void xd(String str) {
        this.hKp.setVisibility(8);
        this.hKu = true;
        this.hKt = 0;
        this.hKx = false;
        xc(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void cU(String str, String str2) {
        if (this.hKw == null) {
            this.hKw = cV(str, str2);
        }
        this.hKw.BF();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void showErrorView() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bBO);
        this.hKo.pause();
        this.dAf.bA(false);
        this.hKp.setVisibility(0);
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
            al.h(this.hKq, e.d.cp_cont_i);
            al.h(this.hKr, e.d.cp_cont_i);
            al.i(this.hKr, e.f.continue_play_bg);
            al.c(this.exm, e.f.icon_frs_luhan_close);
            al.c(this.hKn, e.f.icon_frs_luhan_share);
        }
    }

    private a cV(String str, String str2) {
        this.hKw = new a(this);
        this.hKw.xa(str2);
        if (ao.isEmpty(str)) {
            str = getResources().getString(e.j.easter_dialog_default_message);
        }
        this.hKw.eB(str);
        this.hKw.a(e.j.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.hKv = z;
            }
        });
        this.hKw.b(e.j.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.hKs != null) {
                    VideoEasterEggActivity.this.hKs.bLn();
                    TiebaStatic.log(new am("c13044"));
                }
                VideoEasterEggActivity.this.hKw.dismiss();
            }
        });
        this.hKw.a(e.j.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.hKs != null) {
                    VideoEasterEggActivity.this.hKs.bLm();
                    TiebaStatic.log(new am("c13045").x("obj_locate", 2));
                }
                VideoEasterEggActivity.this.hKw.dismiss();
            }
        });
        this.hKw.a(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.hKv) {
                    VideoEasterEggActivity.this.hKs.bLp();
                }
            }
        });
        this.hKw.b(getPageContext());
        return this.hKw;
    }
}
