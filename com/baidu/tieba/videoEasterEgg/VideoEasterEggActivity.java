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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private com.baidu.tbadk.core.view.a dCl;
    private ImageView dSa;
    private ImageView hgT;
    private ScaleVideoView hgU;
    private View hgV;
    private TextView hgW;
    private TextView hgX;
    private com.baidu.tieba.videoEasterEgg.b.a hgY;
    private a hhc;
    private boolean hhd;
    private int mSkinType = 3;
    private int hgZ = 0;
    private boolean hha = false;
    private boolean hhb = false;
    private Runnable blE = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.hgY != null) {
                VideoEasterEggActivity.this.hgY.bEw();
            }
        }
    };
    private MediaPlayer.OnInfoListener hhe = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.nk(false);
                e.im().removeCallbacks(VideoEasterEggActivity.this.blE);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.hgY = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new am("c13046"));
    }

    private void initUI() {
        this.dCl = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(d.i.video_easter_egg_layout);
        avi();
        bEs();
        bEt();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void avi() {
        this.dSa = (ImageView) findViewById(d.g.close);
        this.dSa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hgY != null) {
                    VideoEasterEggActivity.this.hgY.onClose();
                }
            }
        });
        this.hgT = (ImageView) findViewById(d.g.share);
        this.hgT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hgY != null) {
                    VideoEasterEggActivity.this.hgY.bEu();
                    VideoEasterEggActivity.this.auV();
                    TiebaStatic.log(new am("c13045").r("obj_locate", 1));
                }
            }
        });
    }

    private void bEs() {
        this.hgU = (ScaleVideoView) findViewById(d.g.scale_video_view);
        this.hgU.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.hgY != null) {
                    VideoEasterEggActivity.this.hgY.bEw();
                    return true;
                }
                return true;
            }
        });
        this.hgU.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.hhd = true;
                if (VideoEasterEggActivity.this.hgY != null) {
                    VideoEasterEggActivity.this.hgY.bEx();
                }
            }
        });
        this.hgU.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.hgU.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.hhe);
            }
        });
        this.hgU.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.nk(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.hhd = false;
            }
        });
        nk(true);
    }

    private void bEt() {
        this.hgV = findViewById(d.g.error_container);
        this.hgW = (TextView) findViewById(d.g.load_error_text);
        this.hgW.setText(d.k.loading_error);
        this.hgX = (TextView) findViewById(d.g.play_text);
        this.hgX.setText(d.k.continues_play);
        this.hgX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hgY != null) {
                    VideoEasterEggActivity.this.hgY.bEv();
                }
            }
        });
        this.hgV.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nk(boolean z) {
        if (z) {
            if (this.dCl != null && !this.dCl.isShowing()) {
                this.dCl.aM(true);
            }
            this.hgU.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0141d.cp_cont_i));
            return;
        }
        if (this.dCl != null) {
            this.dCl.aM(false);
        }
        this.hgU.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0141d.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hgY != null) {
            this.hgY.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        auV();
        if (this.hgY != null) {
            this.hgY.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auV() {
        if (this.hgU != null && this.hgU.isPlaying()) {
            this.hgZ = this.hgU.getCurrentPosition();
            this.hgU.pause();
            this.hha = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hgY != null) {
            this.hgY.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void vl(String str) {
        if (!ao.isEmpty(str) && !this.hgU.isPlaying() && !this.hhd) {
            if (this.hha) {
                this.hgU.seekTo(this.hgZ);
                this.hha = false;
            } else {
                this.hgU.setVideoURI(Uri.parse(str));
                e.im().postDelayed(this.blE, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
            this.hgU.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void vm(String str) {
        this.hgV.setVisibility(8);
        this.hha = true;
        this.hgZ = 0;
        this.hhd = false;
        vl(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void ct(String str, String str2) {
        if (this.hhc == null) {
            this.hhc = cu(str, str2);
        }
        this.hhc.xa();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void showErrorView() {
        e.im().removeCallbacks(this.blE);
        this.hgU.pause();
        this.dCl.aM(false);
        this.hgV.setVisibility(0);
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
            al.h(this.hgW, d.C0141d.cp_cont_i);
            al.h(this.hgX, d.C0141d.cp_cont_i);
            al.i(this.hgX, d.f.continue_play_bg);
            al.c(this.dSa, d.f.icon_frs_luhan_close);
            al.c(this.hgT, d.f.icon_frs_luhan_share);
        }
    }

    private a cu(String str, String str2) {
        this.hhc = new a(this);
        this.hhc.vj(str2);
        if (ao.isEmpty(str)) {
            str = getResources().getString(d.k.easter_dialog_default_message);
        }
        this.hhc.dB(str);
        this.hhc.a(d.k.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.hhb = z;
            }
        });
        this.hhc.b(d.k.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.hgY != null) {
                    VideoEasterEggActivity.this.hgY.bEv();
                    TiebaStatic.log(new am("c13044"));
                }
                VideoEasterEggActivity.this.hhc.dismiss();
            }
        });
        this.hhc.a(d.k.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.hgY != null) {
                    VideoEasterEggActivity.this.hgY.bEu();
                    TiebaStatic.log(new am("c13045").r("obj_locate", 2));
                }
                VideoEasterEggActivity.this.hhc.dismiss();
            }
        });
        this.hhc.a(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.hhb) {
                    VideoEasterEggActivity.this.hgY.bEy();
                }
            }
        });
        this.hhc.b(getPageContext());
        return this.hhc;
    }
}
