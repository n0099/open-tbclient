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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private com.baidu.tbadk.core.view.b fmn;
    private ImageView glR;
    private ImageView jFe;
    private ScaleVideoView jFf;
    private View jFg;
    private TextView jFh;
    private TextView jFi;
    private com.baidu.tieba.videoEasterEgg.b.a jFj;
    private a jFn;
    private boolean jFo;
    private int mSkinType = 3;
    private int jFk = 0;
    private boolean jFl = false;
    private boolean jFm = false;
    private Runnable cXC = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.jFj != null) {
                VideoEasterEggActivity.this.jFj.aGI();
            }
        }
    };
    private MediaPlayer.OnInfoListener jFp = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.rQ(false);
                e.iK().removeCallbacks(VideoEasterEggActivity.this.cXC);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.jFj = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new an("c13046"));
    }

    private void initUI() {
        this.fmn = new com.baidu.tbadk.core.view.b(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        aJt();
        cxw();
        cxx();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aJt() {
        this.glR = (ImageView) findViewById(R.id.close);
        this.glR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jFj != null) {
                    VideoEasterEggActivity.this.jFj.onClose();
                }
            }
        });
        this.jFe = (ImageView) findViewById(R.id.share);
        this.jFe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jFj != null) {
                    VideoEasterEggActivity.this.jFj.cxy();
                    VideoEasterEggActivity.this.bos();
                    TiebaStatic.log(new an("c13045").P("obj_locate", 1));
                }
            }
        });
    }

    private void cxw() {
        this.jFf = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.jFf.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.jFj != null) {
                    VideoEasterEggActivity.this.jFj.aGI();
                    return true;
                }
                return true;
            }
        });
        this.jFf.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.jFo = true;
                if (VideoEasterEggActivity.this.jFj != null) {
                    VideoEasterEggActivity.this.jFj.cxA();
                }
            }
        });
        this.jFf.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.jFf.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.jFp);
            }
        });
        this.jFf.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.rQ(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.jFo = false;
            }
        });
        rQ(true);
    }

    private void cxx() {
        this.jFg = findViewById(R.id.error_container);
        this.jFh = (TextView) findViewById(R.id.load_error_text);
        this.jFh.setText(R.string.loading_error);
        this.jFi = (TextView) findViewById(R.id.play_text);
        this.jFi.setText(R.string.continues_play);
        this.jFi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jFj != null) {
                    VideoEasterEggActivity.this.jFj.cxz();
                }
            }
        });
        this.jFg.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rQ(boolean z) {
        if (z) {
            if (this.fmn != null && !this.fmn.isShowing()) {
                this.fmn.ej(true);
            }
            this.jFf.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_btn_a));
            return;
        }
        if (this.fmn != null) {
            this.fmn.ej(false);
        }
        this.jFf.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jFj != null) {
            this.jFj.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        bos();
        if (this.jFj != null) {
            this.jFj.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bos() {
        if (this.jFf != null && this.jFf.isPlaying()) {
            this.jFk = this.jFf.getCurrentPosition();
            this.jFf.pause();
            this.jFl = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jFj != null) {
            this.jFj.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Gj(String str) {
        if (!aq.isEmpty(str) && !this.jFf.isPlaying() && !this.jFo) {
            if (this.jFl) {
                this.jFf.seekTo(this.jFk);
                this.jFl = false;
            } else {
                this.jFf.setVideoURI(Uri.parse(str));
                e.iK().postDelayed(this.cXC, 5000L);
            }
            this.jFf.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Gk(String str) {
        this.jFg.setVisibility(8);
        this.jFl = true;
        this.jFk = 0;
        this.jFo = false;
        Gj(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void ev(String str, String str2) {
        if (this.jFn == null) {
            this.jFn = ew(str, str2);
        }
        this.jFn.agK();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void BN() {
        e.iK().removeCallbacks(this.cXC);
        this.jFf.pause();
        this.fmn.ej(false);
        this.jFg.setVisibility(0);
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
            am.j(this.jFh, R.color.cp_btn_a);
            am.j(this.jFi, R.color.cp_btn_a);
            am.k(this.jFi, R.drawable.continue_play_bg);
            am.c(this.glR, (int) R.drawable.icon_frs_luhan_close);
            am.c(this.jFe, (int) R.drawable.icon_frs_luhan_share);
        }
    }

    private a ew(String str, String str2) {
        this.jFn = new a(this);
        this.jFn.Gh(str2);
        if (aq.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.jFn.mO(str);
        this.jFn.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.jFm = z;
            }
        });
        this.jFn.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.jFj != null) {
                    VideoEasterEggActivity.this.jFj.cxz();
                    TiebaStatic.log(new an("c13044"));
                }
                VideoEasterEggActivity.this.jFn.dismiss();
            }
        });
        this.jFn.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.jFj != null) {
                    VideoEasterEggActivity.this.jFj.cxy();
                    TiebaStatic.log(new an("c13045").P("obj_locate", 2));
                }
                VideoEasterEggActivity.this.jFn.dismiss();
            }
        });
        this.jFn.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.jFm) {
                    VideoEasterEggActivity.this.jFj.cxB();
                }
            }
        });
        this.jFn.b(getPageContext());
        return this.jFn;
    }
}
