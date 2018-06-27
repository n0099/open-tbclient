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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private ImageView dVU;
    private com.baidu.tbadk.core.view.a dbO;
    private ImageView hla;
    private ScaleVideoView hlb;
    private View hlc;
    private TextView hld;
    private TextView hle;
    private com.baidu.tieba.videoEasterEgg.b.a hlf;
    private a hlj;
    private boolean hlk;
    private int mSkinType = 3;
    private int hlg = 0;
    private boolean hlh = false;
    private boolean hli = false;
    private Runnable bnd = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.hlf != null) {
                VideoEasterEggActivity.this.hlf.bEW();
            }
        }
    };
    private MediaPlayer.OnInfoListener hll = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.ns(false);
                e.im().removeCallbacks(VideoEasterEggActivity.this.bnd);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.hlf = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new an("c13046"));
    }

    private void initUI() {
        this.dbO = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(d.i.video_easter_egg_layout);
        arI();
        bES();
        bET();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void arI() {
        this.dVU = (ImageView) findViewById(d.g.close);
        this.dVU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hlf != null) {
                    VideoEasterEggActivity.this.hlf.onClose();
                }
            }
        });
        this.hla = (ImageView) findViewById(d.g.share);
        this.hla.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hlf != null) {
                    VideoEasterEggActivity.this.hlf.bEU();
                    VideoEasterEggActivity.this.avz();
                    TiebaStatic.log(new an("c13045").r("obj_locate", 1));
                }
            }
        });
    }

    private void bES() {
        this.hlb = (ScaleVideoView) findViewById(d.g.scale_video_view);
        this.hlb.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.hlf != null) {
                    VideoEasterEggActivity.this.hlf.bEW();
                    return true;
                }
                return true;
            }
        });
        this.hlb.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.hlk = true;
                if (VideoEasterEggActivity.this.hlf != null) {
                    VideoEasterEggActivity.this.hlf.bEX();
                }
            }
        });
        this.hlb.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.hlb.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.hll);
            }
        });
        this.hlb.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.ns(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.hlk = false;
            }
        });
        ns(true);
    }

    private void bET() {
        this.hlc = findViewById(d.g.error_container);
        this.hld = (TextView) findViewById(d.g.load_error_text);
        this.hld.setText(d.k.loading_error);
        this.hle = (TextView) findViewById(d.g.play_text);
        this.hle.setText(d.k.continues_play);
        this.hle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hlf != null) {
                    VideoEasterEggActivity.this.hlf.bEV();
                }
            }
        });
        this.hlc.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ns(boolean z) {
        if (z) {
            if (this.dbO != null && !this.dbO.isShowing()) {
                this.dbO.aO(true);
            }
            this.hlb.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0142d.cp_cont_i));
            return;
        }
        if (this.dbO != null) {
            this.dbO.aO(false);
        }
        this.hlb.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0142d.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hlf != null) {
            this.hlf.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        avz();
        if (this.hlf != null) {
            this.hlf.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avz() {
        if (this.hlb != null && this.hlb.isPlaying()) {
            this.hlg = this.hlb.getCurrentPosition();
            this.hlb.pause();
            this.hlh = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hlf != null) {
            this.hlf.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void vh(String str) {
        if (!ap.isEmpty(str) && !this.hlb.isPlaying() && !this.hlk) {
            if (this.hlh) {
                this.hlb.seekTo(this.hlg);
                this.hlh = false;
            } else {
                this.hlb.setVideoURI(Uri.parse(str));
                e.im().postDelayed(this.bnd, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
            this.hlb.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void vi(String str) {
        this.hlc.setVisibility(8);
        this.hlh = true;
        this.hlg = 0;
        this.hlk = false;
        vh(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void cx(String str, String str2) {
        if (this.hlj == null) {
            this.hlj = cy(str, str2);
        }
        this.hlj.xn();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void showErrorView() {
        e.im().removeCallbacks(this.bnd);
        this.hlb.pause();
        this.dbO.aO(false);
        this.hlc.setVisibility(0);
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
            am.h(this.hld, d.C0142d.cp_cont_i);
            am.h(this.hle, d.C0142d.cp_cont_i);
            am.i(this.hle, d.f.continue_play_bg);
            am.c(this.dVU, d.f.icon_frs_luhan_close);
            am.c(this.hla, d.f.icon_frs_luhan_share);
        }
    }

    private a cy(String str, String str2) {
        this.hlj = new a(this);
        this.hlj.vf(str2);
        if (ap.isEmpty(str)) {
            str = getResources().getString(d.k.easter_dialog_default_message);
        }
        this.hlj.dE(str);
        this.hlj.a(d.k.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.hli = z;
            }
        });
        this.hlj.b(d.k.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.hlf != null) {
                    VideoEasterEggActivity.this.hlf.bEV();
                    TiebaStatic.log(new an("c13044"));
                }
                VideoEasterEggActivity.this.hlj.dismiss();
            }
        });
        this.hlj.a(d.k.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.hlf != null) {
                    VideoEasterEggActivity.this.hlf.bEU();
                    TiebaStatic.log(new an("c13045").r("obj_locate", 2));
                }
                VideoEasterEggActivity.this.hlj.dismiss();
            }
        });
        this.hlj.a(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.hli) {
                    VideoEasterEggActivity.this.hlf.bEY();
                }
            }
        });
        this.hlj.b(getPageContext());
        return this.hlj;
    }
}
