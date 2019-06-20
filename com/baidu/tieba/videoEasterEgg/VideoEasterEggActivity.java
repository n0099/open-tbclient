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
    private ImageView geQ;
    private ImageView jxO;
    private ScaleVideoView jxP;
    private View jxQ;
    private TextView jxR;
    private TextView jxS;
    private com.baidu.tieba.videoEasterEgg.b.a jxT;
    private a jxX;
    private boolean jxY;
    private int mSkinType = 3;
    private int jxU = 0;
    private boolean jxV = false;
    private boolean jxW = false;
    private Runnable cVZ = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.jxT != null) {
                VideoEasterEggActivity.this.jxT.aFm();
            }
        }
    };
    private MediaPlayer.OnInfoListener jxZ = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.rC(false);
                e.iB().removeCallbacks(VideoEasterEggActivity.this.cVZ);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.jxT = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new am("c13046"));
    }

    private void initUI() {
        this.fgM = new com.baidu.tbadk.core.view.b(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        aHR();
        cul();
        cum();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aHR() {
        this.geQ = (ImageView) findViewById(R.id.close);
        this.geQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jxT != null) {
                    VideoEasterEggActivity.this.jxT.onClose();
                }
            }
        });
        this.jxO = (ImageView) findViewById(R.id.share);
        this.jxO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jxT != null) {
                    VideoEasterEggActivity.this.jxT.cun();
                    VideoEasterEggActivity.this.bme();
                    TiebaStatic.log(new am("c13045").P("obj_locate", 1));
                }
            }
        });
    }

    private void cul() {
        this.jxP = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.jxP.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.jxT != null) {
                    VideoEasterEggActivity.this.jxT.aFm();
                    return true;
                }
                return true;
            }
        });
        this.jxP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.jxY = true;
                if (VideoEasterEggActivity.this.jxT != null) {
                    VideoEasterEggActivity.this.jxT.cup();
                }
            }
        });
        this.jxP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.jxP.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.jxZ);
            }
        });
        this.jxP.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.rC(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.jxY = false;
            }
        });
        rC(true);
    }

    private void cum() {
        this.jxQ = findViewById(R.id.error_container);
        this.jxR = (TextView) findViewById(R.id.load_error_text);
        this.jxR.setText(R.string.loading_error);
        this.jxS = (TextView) findViewById(R.id.play_text);
        this.jxS.setText(R.string.continues_play);
        this.jxS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jxT != null) {
                    VideoEasterEggActivity.this.jxT.cuo();
                }
            }
        });
        this.jxQ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rC(boolean z) {
        if (z) {
            if (this.fgM != null && !this.fgM.isShowing()) {
                this.fgM.ef(true);
            }
            this.jxP.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_btn_a));
            return;
        }
        if (this.fgM != null) {
            this.fgM.ef(false);
        }
        this.jxP.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jxT != null) {
            this.jxT.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        bme();
        if (this.jxT != null) {
            this.jxT.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bme() {
        if (this.jxP != null && this.jxP.isPlaying()) {
            this.jxU = this.jxP.getCurrentPosition();
            this.jxP.pause();
            this.jxV = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jxT != null) {
            this.jxT.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Ft(String str) {
        if (!ap.isEmpty(str) && !this.jxP.isPlaying() && !this.jxY) {
            if (this.jxV) {
                this.jxP.seekTo(this.jxU);
                this.jxV = false;
            } else {
                this.jxP.setVideoURI(Uri.parse(str));
                e.iB().postDelayed(this.cVZ, 5000L);
            }
            this.jxP.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Fu(String str) {
        this.jxQ.setVisibility(8);
        this.jxV = true;
        this.jxU = 0;
        this.jxY = false;
        Ft(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void eu(String str, String str2) {
        if (this.jxX == null) {
            this.jxX = ev(str, str2);
        }
        this.jxX.afG();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Bf() {
        e.iB().removeCallbacks(this.cVZ);
        this.jxP.pause();
        this.fgM.ef(false);
        this.jxQ.setVisibility(0);
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
            al.j(this.jxR, R.color.cp_btn_a);
            al.j(this.jxS, R.color.cp_btn_a);
            al.k(this.jxS, R.drawable.continue_play_bg);
            al.c(this.geQ, (int) R.drawable.icon_frs_luhan_close);
            al.c(this.jxO, (int) R.drawable.icon_frs_luhan_share);
        }
    }

    private a ev(String str, String str2) {
        this.jxX = new a(this);
        this.jxX.Fr(str2);
        if (ap.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.jxX.mD(str);
        this.jxX.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.jxW = z;
            }
        });
        this.jxX.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.jxT != null) {
                    VideoEasterEggActivity.this.jxT.cuo();
                    TiebaStatic.log(new am("c13044"));
                }
                VideoEasterEggActivity.this.jxX.dismiss();
            }
        });
        this.jxX.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.jxT != null) {
                    VideoEasterEggActivity.this.jxT.cun();
                    TiebaStatic.log(new am("c13045").P("obj_locate", 2));
                }
                VideoEasterEggActivity.this.jxX.dismiss();
            }
        });
        this.jxX.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.jxW) {
                    VideoEasterEggActivity.this.jxT.cuq();
                }
            }
        });
        this.jxX.b(getPageContext());
        return this.jxX;
    }
}
