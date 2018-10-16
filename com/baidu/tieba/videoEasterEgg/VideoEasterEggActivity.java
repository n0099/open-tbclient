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
    private d dsB;
    private ImageView eoY;
    private boolean hBA;
    private ImageView hBq;
    private ScaleVideoView hBr;
    private View hBs;
    private TextView hBt;
    private TextView hBu;
    private com.baidu.tieba.videoEasterEgg.b.a hBv;
    private a hBz;
    private int mSkinType = 3;
    private int hBw = 0;
    private boolean hBx = false;
    private boolean hBy = false;
    private Runnable bxG = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.hBv != null) {
                VideoEasterEggActivity.this.hBv.XE();
            }
        }
    };
    private MediaPlayer.OnInfoListener hBB = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.nS(false);
                e.jI().removeCallbacks(VideoEasterEggActivity.this.bxG);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.hBv = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new am("c13046"));
    }

    private void initUI() {
        this.dsB = new d(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(e.h.video_easter_egg_layout);
        axv();
        bJG();
        bJH();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void axv() {
        this.eoY = (ImageView) findViewById(e.g.close);
        this.eoY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hBv != null) {
                    VideoEasterEggActivity.this.hBv.onClose();
                }
            }
        });
        this.hBq = (ImageView) findViewById(e.g.share);
        this.hBq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hBv != null) {
                    VideoEasterEggActivity.this.hBv.bJI();
                    VideoEasterEggActivity.this.aBI();
                    TiebaStatic.log(new am("c13045").x("obj_locate", 1));
                }
            }
        });
    }

    private void bJG() {
        this.hBr = (ScaleVideoView) findViewById(e.g.scale_video_view);
        this.hBr.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.hBv != null) {
                    VideoEasterEggActivity.this.hBv.XE();
                    return true;
                }
                return true;
            }
        });
        this.hBr.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.hBA = true;
                if (VideoEasterEggActivity.this.hBv != null) {
                    VideoEasterEggActivity.this.hBv.bJK();
                }
            }
        });
        this.hBr.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.hBr.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.hBB);
            }
        });
        this.hBr.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.nS(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.hBA = false;
            }
        });
        nS(true);
    }

    private void bJH() {
        this.hBs = findViewById(e.g.error_container);
        this.hBt = (TextView) findViewById(e.g.load_error_text);
        this.hBt.setText(e.j.loading_error);
        this.hBu = (TextView) findViewById(e.g.play_text);
        this.hBu.setText(e.j.continues_play);
        this.hBu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hBv != null) {
                    VideoEasterEggActivity.this.hBv.bJJ();
                }
            }
        });
        this.hBs.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nS(boolean z) {
        if (z) {
            if (this.dsB != null && !this.dsB.isShowing()) {
                this.dsB.bj(true);
            }
            this.hBr.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.cp_cont_i));
            return;
        }
        if (this.dsB != null) {
            this.dsB.bj(false);
        }
        this.hBr.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hBv != null) {
            this.hBv.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        aBI();
        if (this.hBv != null) {
            this.hBv.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBI() {
        if (this.hBr != null && this.hBr.isPlaying()) {
            this.hBw = this.hBr.getCurrentPosition();
            this.hBr.pause();
            this.hBx = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hBv != null) {
            this.hBv.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void wu(String str) {
        if (!ao.isEmpty(str) && !this.hBr.isPlaying() && !this.hBA) {
            if (this.hBx) {
                this.hBr.seekTo(this.hBw);
                this.hBx = false;
            } else {
                this.hBr.setVideoURI(Uri.parse(str));
                com.baidu.adp.lib.g.e.jI().postDelayed(this.bxG, 5000L);
            }
            this.hBr.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void wv(String str) {
        this.hBs.setVisibility(8);
        this.hBx = true;
        this.hBw = 0;
        this.hBA = false;
        wu(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void cP(String str, String str2) {
        if (this.hBz == null) {
            this.hBz = cQ(str, str2);
        }
        this.hBz.Au();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void showErrorView() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.bxG);
        this.hBr.pause();
        this.dsB.bj(false);
        this.hBs.setVisibility(0);
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
            al.h(this.hBt, e.d.cp_cont_i);
            al.h(this.hBu, e.d.cp_cont_i);
            al.i(this.hBu, e.f.continue_play_bg);
            al.c(this.eoY, e.f.icon_frs_luhan_close);
            al.c(this.hBq, e.f.icon_frs_luhan_share);
        }
    }

    private a cQ(String str, String str2) {
        this.hBz = new a(this);
        this.hBz.ws(str2);
        if (ao.isEmpty(str)) {
            str = getResources().getString(e.j.easter_dialog_default_message);
        }
        this.hBz.ej(str);
        this.hBz.a(e.j.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.hBy = z;
            }
        });
        this.hBz.b(e.j.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.hBv != null) {
                    VideoEasterEggActivity.this.hBv.bJJ();
                    TiebaStatic.log(new am("c13044"));
                }
                VideoEasterEggActivity.this.hBz.dismiss();
            }
        });
        this.hBz.a(e.j.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.hBv != null) {
                    VideoEasterEggActivity.this.hBv.bJI();
                    TiebaStatic.log(new am("c13045").x("obj_locate", 2));
                }
                VideoEasterEggActivity.this.hBz.dismiss();
            }
        });
        this.hBz.a(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.hBy) {
                    VideoEasterEggActivity.this.hBv.bJL();
                }
            }
        });
        this.hBz.b(getPageContext());
        return this.hBz;
    }
}
