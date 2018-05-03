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
    private ImageView dFE;
    private com.baidu.tbadk.core.view.a drQ;
    private ImageView gUo;
    private ScaleVideoView gUp;
    private View gUq;
    private TextView gUr;
    private TextView gUs;
    private com.baidu.tieba.videoEasterEgg.b.a gUt;
    private a gUx;
    private boolean gUy;
    private int mSkinType = 3;
    private int gUu = 0;
    private boolean gUv = false;
    private boolean gUw = false;
    private Runnable bdt = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.gUt != null) {
                VideoEasterEggActivity.this.gUt.bzs();
            }
        }
    };
    private MediaPlayer.OnInfoListener gUz = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.nd(false);
                e.fw().removeCallbacks(VideoEasterEggActivity.this.bdt);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.gUt = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new al("c13046"));
    }

    private void initUI() {
        this.drQ = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(d.i.video_easter_egg_layout);
        are();
        bzo();
        bzp();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void are() {
        this.dFE = (ImageView) findViewById(d.g.close);
        this.dFE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (VideoEasterEggActivity.this.gUt != null) {
                    VideoEasterEggActivity.this.gUt.onClose();
                }
            }
        });
        this.gUo = (ImageView) findViewById(d.g.share);
        this.gUo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (VideoEasterEggActivity.this.gUt != null) {
                    VideoEasterEggActivity.this.gUt.bzq();
                    VideoEasterEggActivity.this.aqR();
                    TiebaStatic.log(new al("c13045").r("obj_locate", 1));
                }
            }
        });
    }

    private void bzo() {
        this.gUp = (ScaleVideoView) findViewById(d.g.scale_video_view);
        this.gUp.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.gUt != null) {
                    VideoEasterEggActivity.this.gUt.bzs();
                    return true;
                }
                return true;
            }
        });
        this.gUp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.gUy = true;
                if (VideoEasterEggActivity.this.gUt != null) {
                    VideoEasterEggActivity.this.gUt.bzt();
                }
            }
        });
        this.gUp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.gUp.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.gUz);
            }
        });
        this.gUp.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.nd(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.gUy = false;
            }
        });
        nd(true);
    }

    private void bzp() {
        this.gUq = findViewById(d.g.error_container);
        this.gUr = (TextView) findViewById(d.g.load_error_text);
        this.gUr.setText(d.k.loading_error);
        this.gUs = (TextView) findViewById(d.g.play_text);
        this.gUs.setText(d.k.continues_play);
        this.gUs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (VideoEasterEggActivity.this.gUt != null) {
                    VideoEasterEggActivity.this.gUt.bzr();
                }
            }
        });
        this.gUq.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nd(boolean z) {
        if (z) {
            if (this.drQ != null && !this.drQ.isShowing()) {
                this.drQ.aI(true);
            }
            this.gUp.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0126d.cp_cont_i));
            return;
        }
        if (this.drQ != null) {
            this.drQ.aI(false);
        }
        this.gUp.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0126d.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gUt != null) {
            this.gUt.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        aqR();
        if (this.gUt != null) {
            this.gUt.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqR() {
        if (this.gUp != null && this.gUp.isPlaying()) {
            this.gUu = this.gUp.getCurrentPosition();
            this.gUp.pause();
            this.gUv = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gUt != null) {
            this.gUt.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void uo(String str) {
        if (!an.isEmpty(str) && !this.gUp.isPlaying() && !this.gUy) {
            if (this.gUv) {
                this.gUp.seekTo(this.gUu);
                this.gUv = false;
            } else {
                this.gUp.setVideoURI(Uri.parse(str));
                e.fw().postDelayed(this.bdt, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
            this.gUp.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void up(String str) {
        this.gUq.setVisibility(8);
        this.gUv = true;
        this.gUu = 0;
        this.gUy = false;
        uo(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void cl(String str, String str2) {
        if (this.gUx == null) {
            this.gUx = cm(str, str2);
        }
        this.gUx.tD();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void showErrorView() {
        e.fw().removeCallbacks(this.bdt);
        this.gUp.pause();
        this.drQ.aI(false);
        this.gUq.setVisibility(0);
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
            ak.h(this.gUr, d.C0126d.cp_cont_i);
            ak.h(this.gUs, d.C0126d.cp_cont_i);
            ak.i(this.gUs, d.f.continue_play_bg);
            ak.c(this.dFE, d.f.icon_frs_luhan_close);
            ak.c(this.gUo, d.f.icon_frs_luhan_share);
        }
    }

    private a cm(String str, String str2) {
        this.gUx = new a(this);
        this.gUx.um(str2);
        if (an.isEmpty(str)) {
            str = getResources().getString(d.k.easter_dialog_default_message);
        }
        this.gUx.dc(str);
        this.gUx.a(d.k.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.gUw = z;
            }
        });
        this.gUx.b(d.k.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.gUt != null) {
                    VideoEasterEggActivity.this.gUt.bzr();
                    TiebaStatic.log(new al("c13044"));
                }
                VideoEasterEggActivity.this.gUx.dismiss();
            }
        });
        this.gUx.a(d.k.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.gUt != null) {
                    VideoEasterEggActivity.this.gUt.bzq();
                    TiebaStatic.log(new al("c13045").r("obj_locate", 2));
                }
                VideoEasterEggActivity.this.gUx.dismiss();
            }
        });
        this.gUx.a(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.gUw) {
                    VideoEasterEggActivity.this.gUt.bzu();
                }
            }
        });
        this.gUx.b(getPageContext());
        return this.gUx;
    }
}
