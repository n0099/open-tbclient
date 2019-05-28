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
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private com.baidu.tbadk.core.view.b fgM;
    private ImageView geO;
    private ImageView jxL;
    private ScaleVideoView jxM;
    private View jxN;
    private TextView jxO;
    private TextView jxP;
    private com.baidu.tieba.videoEasterEgg.b.a jxQ;
    private a jxU;
    private boolean jxV;
    private int mSkinType = 3;
    private int jxR = 0;
    private boolean jxS = false;
    private boolean jxT = false;
    private Runnable cVY = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.jxQ != null) {
                VideoEasterEggActivity.this.jxQ.aFm();
            }
        }
    };
    private MediaPlayer.OnInfoListener jxW = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.rB(false);
                e.iB().removeCallbacks(VideoEasterEggActivity.this.cVY);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.jxQ = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new am("c13046"));
    }

    private void initUI() {
        this.fgM = new com.baidu.tbadk.core.view.b(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        aHR();
        cum();
        cun();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aHR() {
        this.geO = (ImageView) findViewById(R.id.close);
        this.geO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jxQ != null) {
                    VideoEasterEggActivity.this.jxQ.onClose();
                }
            }
        });
        this.jxL = (ImageView) findViewById(R.id.share);
        this.jxL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jxQ != null) {
                    VideoEasterEggActivity.this.jxQ.cuo();
                    VideoEasterEggActivity.this.bme();
                    TiebaStatic.log(new am("c13045").P("obj_locate", 1));
                }
            }
        });
    }

    private void cum() {
        this.jxM = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.jxM.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.jxQ != null) {
                    VideoEasterEggActivity.this.jxQ.aFm();
                    return true;
                }
                return true;
            }
        });
        this.jxM.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.jxV = true;
                if (VideoEasterEggActivity.this.jxQ != null) {
                    VideoEasterEggActivity.this.jxQ.cuq();
                }
            }
        });
        this.jxM.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.jxM.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.jxW);
            }
        });
        this.jxM.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.rB(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.jxV = false;
            }
        });
        rB(true);
    }

    private void cun() {
        this.jxN = findViewById(R.id.error_container);
        this.jxO = (TextView) findViewById(R.id.load_error_text);
        this.jxO.setText(R.string.loading_error);
        this.jxP = (TextView) findViewById(R.id.play_text);
        this.jxP.setText(R.string.continues_play);
        this.jxP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jxQ != null) {
                    VideoEasterEggActivity.this.jxQ.cup();
                }
            }
        });
        this.jxN.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rB(boolean z) {
        if (z) {
            if (this.fgM != null && !this.fgM.isShowing()) {
                this.fgM.ef(true);
            }
            this.jxM.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_btn_a));
            return;
        }
        if (this.fgM != null) {
            this.fgM.ef(false);
        }
        this.jxM.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jxQ != null) {
            this.jxQ.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        bme();
        if (this.jxQ != null) {
            this.jxQ.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bme() {
        if (this.jxM != null && this.jxM.isPlaying()) {
            this.jxR = this.jxM.getCurrentPosition();
            this.jxM.pause();
            this.jxS = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jxQ != null) {
            this.jxQ.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Fr(String str) {
        if (!ap.isEmpty(str) && !this.jxM.isPlaying() && !this.jxV) {
            if (this.jxS) {
                this.jxM.seekTo(this.jxR);
                this.jxS = false;
            } else {
                this.jxM.setVideoURI(Uri.parse(str));
                e.iB().postDelayed(this.cVY, 5000L);
            }
            this.jxM.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Fs(String str) {
        this.jxN.setVisibility(8);
        this.jxS = true;
        this.jxR = 0;
        this.jxV = false;
        Fr(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void eu(String str, String str2) {
        if (this.jxU == null) {
            this.jxU = ev(str, str2);
        }
        this.jxU.afG();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Bf() {
        e.iB().removeCallbacks(this.cVY);
        this.jxM.pause();
        this.fgM.ef(false);
        this.jxN.setVisibility(0);
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
            al.j(this.jxO, R.color.cp_btn_a);
            al.j(this.jxP, R.color.cp_btn_a);
            al.k(this.jxP, R.drawable.continue_play_bg);
            al.c(this.geO, (int) R.drawable.icon_frs_luhan_close);
            al.c(this.jxL, (int) R.drawable.icon_frs_luhan_share);
        }
    }

    private a ev(String str, String str2) {
        this.jxU = new a(this);
        this.jxU.Fp(str2);
        if (ap.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.jxU.mE(str);
        this.jxU.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.jxT = z;
            }
        });
        this.jxU.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.jxQ != null) {
                    VideoEasterEggActivity.this.jxQ.cup();
                    TiebaStatic.log(new am("c13044"));
                }
                VideoEasterEggActivity.this.jxU.dismiss();
            }
        });
        this.jxU.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.jxQ != null) {
                    VideoEasterEggActivity.this.jxQ.cuo();
                    TiebaStatic.log(new am("c13045").P("obj_locate", 2));
                }
                VideoEasterEggActivity.this.jxU.dismiss();
            }
        });
        this.jxU.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.jxT) {
                    VideoEasterEggActivity.this.jxQ.cur();
                }
            }
        });
        this.jxU.b(getPageContext());
        return this.jxU;
    }
}
