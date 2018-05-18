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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private ImageView dGK;
    private com.baidu.tbadk.core.view.a dsY;
    private a gVB;
    private boolean gVC;
    private ImageView gVs;
    private ScaleVideoView gVt;
    private View gVu;
    private TextView gVv;
    private TextView gVw;
    private com.baidu.tieba.videoEasterEgg.b.a gVx;
    private int mSkinType = 3;
    private int gVy = 0;
    private boolean gVz = false;
    private boolean gVA = false;
    private Runnable bdu = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.gVx != null) {
                VideoEasterEggActivity.this.gVx.bzq();
            }
        }
    };
    private MediaPlayer.OnInfoListener gVD = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.ne(false);
                e.fw().removeCallbacks(VideoEasterEggActivity.this.bdu);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.gVx = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new al("c13046"));
    }

    private void initUI() {
        this.dsY = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(d.i.video_easter_egg_layout);
        ard();
        bzm();
        bzn();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void ard() {
        this.dGK = (ImageView) findViewById(d.g.close);
        this.dGK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (VideoEasterEggActivity.this.gVx != null) {
                    VideoEasterEggActivity.this.gVx.onClose();
                }
            }
        });
        this.gVs = (ImageView) findViewById(d.g.share);
        this.gVs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (VideoEasterEggActivity.this.gVx != null) {
                    VideoEasterEggActivity.this.gVx.bzo();
                    VideoEasterEggActivity.this.aqQ();
                    TiebaStatic.log(new al("c13045").r("obj_locate", 1));
                }
            }
        });
    }

    private void bzm() {
        this.gVt = (ScaleVideoView) findViewById(d.g.scale_video_view);
        this.gVt.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.gVx != null) {
                    VideoEasterEggActivity.this.gVx.bzq();
                    return true;
                }
                return true;
            }
        });
        this.gVt.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.gVC = true;
                if (VideoEasterEggActivity.this.gVx != null) {
                    VideoEasterEggActivity.this.gVx.bzr();
                }
            }
        });
        this.gVt.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.gVt.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.gVD);
            }
        });
        this.gVt.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.ne(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.gVC = false;
            }
        });
        ne(true);
    }

    private void bzn() {
        this.gVu = findViewById(d.g.error_container);
        this.gVv = (TextView) findViewById(d.g.load_error_text);
        this.gVv.setText(d.k.loading_error);
        this.gVw = (TextView) findViewById(d.g.play_text);
        this.gVw.setText(d.k.continues_play);
        this.gVw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (VideoEasterEggActivity.this.gVx != null) {
                    VideoEasterEggActivity.this.gVx.bzp();
                }
            }
        });
        this.gVu.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ne(boolean z) {
        if (z) {
            if (this.dsY != null && !this.dsY.isShowing()) {
                this.dsY.aI(true);
            }
            this.gVt.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0126d.cp_cont_i));
            return;
        }
        if (this.dsY != null) {
            this.dsY.aI(false);
        }
        this.gVt.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0126d.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gVx != null) {
            this.gVx.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        aqQ();
        if (this.gVx != null) {
            this.gVx.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqQ() {
        if (this.gVt != null && this.gVt.isPlaying()) {
            this.gVy = this.gVt.getCurrentPosition();
            this.gVt.pause();
            this.gVz = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gVx != null) {
            this.gVx.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void ur(String str) {
        if (!an.isEmpty(str) && !this.gVt.isPlaying() && !this.gVC) {
            if (this.gVz) {
                this.gVt.seekTo(this.gVy);
                this.gVz = false;
            } else {
                this.gVt.setVideoURI(Uri.parse(str));
                e.fw().postDelayed(this.bdu, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
            this.gVt.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void us(String str) {
        this.gVu.setVisibility(8);
        this.gVz = true;
        this.gVy = 0;
        this.gVC = false;
        ur(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void cl(String str, String str2) {
        if (this.gVB == null) {
            this.gVB = cm(str, str2);
        }
        this.gVB.tC();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void showErrorView() {
        e.fw().removeCallbacks(this.bdu);
        this.gVt.pause();
        this.dsY.aI(false);
        this.gVu.setVisibility(0);
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
            ak.h(this.gVv, d.C0126d.cp_cont_i);
            ak.h(this.gVw, d.C0126d.cp_cont_i);
            ak.i(this.gVw, d.f.continue_play_bg);
            ak.c(this.dGK, d.f.icon_frs_luhan_close);
            ak.c(this.gVs, d.f.icon_frs_luhan_share);
        }
    }

    private a cm(String str, String str2) {
        this.gVB = new a(this);
        this.gVB.up(str2);
        if (an.isEmpty(str)) {
            str = getResources().getString(d.k.easter_dialog_default_message);
        }
        this.gVB.dc(str);
        this.gVB.a(d.k.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.gVA = z;
            }
        });
        this.gVB.b(d.k.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.gVx != null) {
                    VideoEasterEggActivity.this.gVx.bzp();
                    TiebaStatic.log(new al("c13044"));
                }
                VideoEasterEggActivity.this.gVB.dismiss();
            }
        });
        this.gVB.a(d.k.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.gVx != null) {
                    VideoEasterEggActivity.this.gVx.bzo();
                    TiebaStatic.log(new al("c13045").r("obj_locate", 2));
                }
                VideoEasterEggActivity.this.gVB.dismiss();
            }
        });
        this.gVB.a(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.gVA) {
                    VideoEasterEggActivity.this.gVx.bzs();
                }
            }
        });
        this.gVB.b(getPageContext());
        return this.gVB;
    }
}
