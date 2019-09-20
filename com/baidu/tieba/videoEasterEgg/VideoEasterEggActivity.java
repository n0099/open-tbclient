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
    private com.baidu.tbadk.core.view.b foa;
    private ImageView gnI;
    private ImageView jHA;
    private ScaleVideoView jHB;
    private View jHC;
    private TextView jHD;
    private TextView jHE;
    private com.baidu.tieba.videoEasterEgg.b.a jHF;
    private a jHJ;
    private boolean jHK;
    private int mSkinType = 3;
    private int jHG = 0;
    private boolean jHH = false;
    private boolean jHI = false;
    private Runnable cZi = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.jHF != null) {
                VideoEasterEggActivity.this.jHF.aHm();
            }
        }
    };
    private MediaPlayer.OnInfoListener jHL = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.rT(false);
                e.iK().removeCallbacks(VideoEasterEggActivity.this.cZi);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.jHF = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new an("c13046"));
    }

    private void initUI() {
        this.foa = new com.baidu.tbadk.core.view.b(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        aJX();
        cyk();
        cyl();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aJX() {
        this.gnI = (ImageView) findViewById(R.id.close);
        this.gnI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jHF != null) {
                    VideoEasterEggActivity.this.jHF.onClose();
                }
            }
        });
        this.jHA = (ImageView) findViewById(R.id.share);
        this.jHA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jHF != null) {
                    VideoEasterEggActivity.this.jHF.cym();
                    VideoEasterEggActivity.this.bpd();
                    TiebaStatic.log(new an("c13045").P("obj_locate", 1));
                }
            }
        });
    }

    private void cyk() {
        this.jHB = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.jHB.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.jHF != null) {
                    VideoEasterEggActivity.this.jHF.aHm();
                    return true;
                }
                return true;
            }
        });
        this.jHB.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.jHK = true;
                if (VideoEasterEggActivity.this.jHF != null) {
                    VideoEasterEggActivity.this.jHF.cyo();
                }
            }
        });
        this.jHB.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.jHB.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.jHL);
            }
        });
        this.jHB.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.rT(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.jHK = false;
            }
        });
        rT(true);
    }

    private void cyl() {
        this.jHC = findViewById(R.id.error_container);
        this.jHD = (TextView) findViewById(R.id.load_error_text);
        this.jHD.setText(R.string.loading_error);
        this.jHE = (TextView) findViewById(R.id.play_text);
        this.jHE.setText(R.string.continues_play);
        this.jHE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jHF != null) {
                    VideoEasterEggActivity.this.jHF.cyn();
                }
            }
        });
        this.jHC.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rT(boolean z) {
        if (z) {
            if (this.foa != null && !this.foa.isShowing()) {
                this.foa.em(true);
            }
            this.jHB.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_a));
            return;
        }
        if (this.foa != null) {
            this.foa.em(false);
        }
        this.jHB.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jHF != null) {
            this.jHF.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        bpd();
        if (this.jHF != null) {
            this.jHF.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpd() {
        if (this.jHB != null && this.jHB.isPlaying()) {
            this.jHG = this.jHB.getCurrentPosition();
            this.jHB.pause();
            this.jHH = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jHF != null) {
            this.jHF.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void GJ(String str) {
        if (!aq.isEmpty(str) && !this.jHB.isPlaying() && !this.jHK) {
            if (this.jHH) {
                this.jHB.seekTo(this.jHG);
                this.jHH = false;
            } else {
                this.jHB.setVideoURI(Uri.parse(str));
                e.iK().postDelayed(this.cZi, 5000L);
            }
            this.jHB.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void GK(String str) {
        this.jHC.setVisibility(8);
        this.jHH = true;
        this.jHG = 0;
        this.jHK = false;
        GJ(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void ew(String str, String str2) {
        if (this.jHJ == null) {
            this.jHJ = ex(str, str2);
        }
        this.jHJ.agO();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void BR() {
        e.iK().removeCallbacks(this.cZi);
        this.jHB.pause();
        this.foa.em(false);
        this.jHC.setVisibility(0);
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
            am.j(this.jHD, R.color.cp_cont_a);
            am.j(this.jHE, R.color.cp_cont_a);
            am.k(this.jHE, R.drawable.continue_play_bg);
            am.c(this.gnI, (int) R.drawable.icon_frs_luhan_close);
            am.c(this.jHA, (int) R.drawable.icon_frs_luhan_share);
        }
    }

    private a ex(String str, String str2) {
        this.jHJ = new a(this);
        this.jHJ.GH(str2);
        if (aq.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.jHJ.mQ(str);
        this.jHJ.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.jHI = z;
            }
        });
        this.jHJ.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.jHF != null) {
                    VideoEasterEggActivity.this.jHF.cyn();
                    TiebaStatic.log(new an("c13044"));
                }
                VideoEasterEggActivity.this.jHJ.dismiss();
            }
        });
        this.jHJ.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.jHF != null) {
                    VideoEasterEggActivity.this.jHF.cym();
                    TiebaStatic.log(new an("c13045").P("obj_locate", 2));
                }
                VideoEasterEggActivity.this.jHJ.dismiss();
            }
        });
        this.jHJ.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.jHI) {
                    VideoEasterEggActivity.this.jHF.cyp();
                }
            }
        });
        this.jHJ.b(getPageContext());
        return this.jHJ;
    }
}
