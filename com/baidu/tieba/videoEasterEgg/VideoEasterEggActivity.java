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
    private ImageView dFH;
    private com.baidu.tbadk.core.view.a drT;
    private a gUA;
    private boolean gUB;
    private ImageView gUr;
    private ScaleVideoView gUs;
    private View gUt;
    private TextView gUu;
    private TextView gUv;
    private com.baidu.tieba.videoEasterEgg.b.a gUw;
    private int mSkinType = 3;
    private int gUx = 0;
    private boolean gUy = false;
    private boolean gUz = false;
    private Runnable bdt = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.gUw != null) {
                VideoEasterEggActivity.this.gUw.bzs();
            }
        }
    };
    private MediaPlayer.OnInfoListener gUC = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
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
        this.gUw = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new al("c13046"));
    }

    private void initUI() {
        this.drT = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(d.i.video_easter_egg_layout);
        are();
        bzo();
        bzp();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void are() {
        this.dFH = (ImageView) findViewById(d.g.close);
        this.dFH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (VideoEasterEggActivity.this.gUw != null) {
                    VideoEasterEggActivity.this.gUw.onClose();
                }
            }
        });
        this.gUr = (ImageView) findViewById(d.g.share);
        this.gUr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (VideoEasterEggActivity.this.gUw != null) {
                    VideoEasterEggActivity.this.gUw.bzq();
                    VideoEasterEggActivity.this.aqR();
                    TiebaStatic.log(new al("c13045").r("obj_locate", 1));
                }
            }
        });
    }

    private void bzo() {
        this.gUs = (ScaleVideoView) findViewById(d.g.scale_video_view);
        this.gUs.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.gUw != null) {
                    VideoEasterEggActivity.this.gUw.bzs();
                    return true;
                }
                return true;
            }
        });
        this.gUs.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.gUB = true;
                if (VideoEasterEggActivity.this.gUw != null) {
                    VideoEasterEggActivity.this.gUw.bzt();
                }
            }
        });
        this.gUs.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.gUs.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.gUC);
            }
        });
        this.gUs.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.nd(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.gUB = false;
            }
        });
        nd(true);
    }

    private void bzp() {
        this.gUt = findViewById(d.g.error_container);
        this.gUu = (TextView) findViewById(d.g.load_error_text);
        this.gUu.setText(d.k.loading_error);
        this.gUv = (TextView) findViewById(d.g.play_text);
        this.gUv.setText(d.k.continues_play);
        this.gUv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (VideoEasterEggActivity.this.gUw != null) {
                    VideoEasterEggActivity.this.gUw.bzr();
                }
            }
        });
        this.gUt.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nd(boolean z) {
        if (z) {
            if (this.drT != null && !this.drT.isShowing()) {
                this.drT.aI(true);
            }
            this.gUs.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0126d.cp_cont_i));
            return;
        }
        if (this.drT != null) {
            this.drT.aI(false);
        }
        this.gUs.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0126d.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gUw != null) {
            this.gUw.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        aqR();
        if (this.gUw != null) {
            this.gUw.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqR() {
        if (this.gUs != null && this.gUs.isPlaying()) {
            this.gUx = this.gUs.getCurrentPosition();
            this.gUs.pause();
            this.gUy = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gUw != null) {
            this.gUw.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void uo(String str) {
        if (!an.isEmpty(str) && !this.gUs.isPlaying() && !this.gUB) {
            if (this.gUy) {
                this.gUs.seekTo(this.gUx);
                this.gUy = false;
            } else {
                this.gUs.setVideoURI(Uri.parse(str));
                e.fw().postDelayed(this.bdt, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
            this.gUs.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void up(String str) {
        this.gUt.setVisibility(8);
        this.gUy = true;
        this.gUx = 0;
        this.gUB = false;
        uo(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void cl(String str, String str2) {
        if (this.gUA == null) {
            this.gUA = cm(str, str2);
        }
        this.gUA.tD();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void showErrorView() {
        e.fw().removeCallbacks(this.bdt);
        this.gUs.pause();
        this.drT.aI(false);
        this.gUt.setVisibility(0);
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
            ak.h(this.gUu, d.C0126d.cp_cont_i);
            ak.h(this.gUv, d.C0126d.cp_cont_i);
            ak.i(this.gUv, d.f.continue_play_bg);
            ak.c(this.dFH, d.f.icon_frs_luhan_close);
            ak.c(this.gUr, d.f.icon_frs_luhan_share);
        }
    }

    private a cm(String str, String str2) {
        this.gUA = new a(this);
        this.gUA.um(str2);
        if (an.isEmpty(str)) {
            str = getResources().getString(d.k.easter_dialog_default_message);
        }
        this.gUA.dc(str);
        this.gUA.a(d.k.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.gUz = z;
            }
        });
        this.gUA.b(d.k.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.gUw != null) {
                    VideoEasterEggActivity.this.gUw.bzr();
                    TiebaStatic.log(new al("c13044"));
                }
                VideoEasterEggActivity.this.gUA.dismiss();
            }
        });
        this.gUA.a(d.k.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.gUw != null) {
                    VideoEasterEggActivity.this.gUw.bzq();
                    TiebaStatic.log(new al("c13045").r("obj_locate", 2));
                }
                VideoEasterEggActivity.this.gUA.dismiss();
            }
        });
        this.gUA.a(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.gUz) {
                    VideoEasterEggActivity.this.gUw.bzu();
                }
            }
        });
        this.gUA.b(getPageContext());
        return this.gUA;
    }
}
