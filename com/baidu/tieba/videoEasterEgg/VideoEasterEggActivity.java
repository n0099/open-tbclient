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
    private com.baidu.tbadk.core.view.b fgL;
    private ImageView geN;
    private ImageView jxK;
    private ScaleVideoView jxL;
    private View jxM;
    private TextView jxN;
    private TextView jxO;
    private com.baidu.tieba.videoEasterEgg.b.a jxP;
    private a jxT;
    private boolean jxU;
    private int mSkinType = 3;
    private int jxQ = 0;
    private boolean jxR = false;
    private boolean jxS = false;
    private Runnable cVX = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.jxP != null) {
                VideoEasterEggActivity.this.jxP.aFj();
            }
        }
    };
    private MediaPlayer.OnInfoListener jxV = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.rB(false);
                e.iB().removeCallbacks(VideoEasterEggActivity.this.cVX);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.jxP = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new am("c13046"));
    }

    private void initUI() {
        this.fgL = new com.baidu.tbadk.core.view.b(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        aHO();
        cuk();
        cul();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aHO() {
        this.geN = (ImageView) findViewById(R.id.close);
        this.geN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jxP != null) {
                    VideoEasterEggActivity.this.jxP.onClose();
                }
            }
        });
        this.jxK = (ImageView) findViewById(R.id.share);
        this.jxK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jxP != null) {
                    VideoEasterEggActivity.this.jxP.cum();
                    VideoEasterEggActivity.this.bmb();
                    TiebaStatic.log(new am("c13045").P("obj_locate", 1));
                }
            }
        });
    }

    private void cuk() {
        this.jxL = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.jxL.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.jxP != null) {
                    VideoEasterEggActivity.this.jxP.aFj();
                    return true;
                }
                return true;
            }
        });
        this.jxL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.jxU = true;
                if (VideoEasterEggActivity.this.jxP != null) {
                    VideoEasterEggActivity.this.jxP.cuo();
                }
            }
        });
        this.jxL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.jxL.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.jxV);
            }
        });
        this.jxL.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.rB(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.jxU = false;
            }
        });
        rB(true);
    }

    private void cul() {
        this.jxM = findViewById(R.id.error_container);
        this.jxN = (TextView) findViewById(R.id.load_error_text);
        this.jxN.setText(R.string.loading_error);
        this.jxO = (TextView) findViewById(R.id.play_text);
        this.jxO.setText(R.string.continues_play);
        this.jxO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jxP != null) {
                    VideoEasterEggActivity.this.jxP.cun();
                }
            }
        });
        this.jxM.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rB(boolean z) {
        if (z) {
            if (this.fgL != null && !this.fgL.isShowing()) {
                this.fgL.ef(true);
            }
            this.jxL.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_btn_a));
            return;
        }
        if (this.fgL != null) {
            this.fgL.ef(false);
        }
        this.jxL.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jxP != null) {
            this.jxP.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        bmb();
        if (this.jxP != null) {
            this.jxP.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmb() {
        if (this.jxL != null && this.jxL.isPlaying()) {
            this.jxQ = this.jxL.getCurrentPosition();
            this.jxL.pause();
            this.jxR = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jxP != null) {
            this.jxP.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Fr(String str) {
        if (!ap.isEmpty(str) && !this.jxL.isPlaying() && !this.jxU) {
            if (this.jxR) {
                this.jxL.seekTo(this.jxQ);
                this.jxR = false;
            } else {
                this.jxL.setVideoURI(Uri.parse(str));
                e.iB().postDelayed(this.cVX, 5000L);
            }
            this.jxL.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Fs(String str) {
        this.jxM.setVisibility(8);
        this.jxR = true;
        this.jxQ = 0;
        this.jxU = false;
        Fr(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void eu(String str, String str2) {
        if (this.jxT == null) {
            this.jxT = ev(str, str2);
        }
        this.jxT.afG();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Bf() {
        e.iB().removeCallbacks(this.cVX);
        this.jxL.pause();
        this.fgL.ef(false);
        this.jxM.setVisibility(0);
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
            al.j(this.jxN, R.color.cp_btn_a);
            al.j(this.jxO, R.color.cp_btn_a);
            al.k(this.jxO, R.drawable.continue_play_bg);
            al.c(this.geN, (int) R.drawable.icon_frs_luhan_close);
            al.c(this.jxK, (int) R.drawable.icon_frs_luhan_share);
        }
    }

    private a ev(String str, String str2) {
        this.jxT = new a(this);
        this.jxT.Fp(str2);
        if (ap.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.jxT.mE(str);
        this.jxT.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.jxS = z;
            }
        });
        this.jxT.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.jxP != null) {
                    VideoEasterEggActivity.this.jxP.cun();
                    TiebaStatic.log(new am("c13044"));
                }
                VideoEasterEggActivity.this.jxT.dismiss();
            }
        });
        this.jxT.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.jxP != null) {
                    VideoEasterEggActivity.this.jxP.cum();
                    TiebaStatic.log(new am("c13045").P("obj_locate", 2));
                }
                VideoEasterEggActivity.this.jxT.dismiss();
            }
        });
        this.jxT.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.jxS) {
                    VideoEasterEggActivity.this.jxP.cup();
                }
            }
        });
        this.jxT.b(getPageContext());
        return this.jxT;
    }
}
