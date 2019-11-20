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
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
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
    private com.baidu.tbadk.core.view.b fUF;
    private ImageView gmq;
    private ScaleVideoView jGA;
    private View jGB;
    private TextView jGC;
    private TextView jGD;
    private com.baidu.tieba.videoEasterEgg.b.a jGE;
    private a jGI;
    private boolean jGJ;
    private ImageView jGz;
    private int mSkinType = 3;
    private int jGF = 0;
    private boolean jGG = false;
    private boolean jGH = false;
    private Runnable dhP = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.jGE != null) {
                VideoEasterEggActivity.this.jGE.aHx();
            }
        }
    };
    private MediaPlayer.OnInfoListener jGK = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.rC(false);
                e.fZ().removeCallbacks(VideoEasterEggActivity.this.dhP);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.jGE = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.fUF = new com.baidu.tbadk.core.view.b(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        aJv();
        cvY();
        cvZ();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aJv() {
        this.gmq = (ImageView) findViewById(R.id.close);
        this.gmq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jGE != null) {
                    VideoEasterEggActivity.this.jGE.onClose();
                }
            }
        });
        this.jGz = (ImageView) findViewById(R.id.share);
        this.jGz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jGE != null) {
                    VideoEasterEggActivity.this.jGE.cwa();
                    VideoEasterEggActivity.this.bmg();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).O("obj_locate", 1));
                }
            }
        });
    }

    private void cvY() {
        this.jGA = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.jGA.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.jGE != null) {
                    VideoEasterEggActivity.this.jGE.aHx();
                    return true;
                }
                return true;
            }
        });
        this.jGA.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.jGJ = true;
                if (VideoEasterEggActivity.this.jGE != null) {
                    VideoEasterEggActivity.this.jGE.cwc();
                }
            }
        });
        this.jGA.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.jGA.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.jGK);
            }
        });
        this.jGA.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.rC(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.jGJ = false;
            }
        });
        rC(true);
    }

    private void cvZ() {
        this.jGB = findViewById(R.id.error_container);
        this.jGC = (TextView) findViewById(R.id.load_error_text);
        this.jGC.setText(R.string.loading_error);
        this.jGD = (TextView) findViewById(R.id.play_text);
        this.jGD.setText(R.string.continues_play);
        this.jGD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jGE != null) {
                    VideoEasterEggActivity.this.jGE.cwb();
                }
            }
        });
        this.jGB.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rC(boolean z) {
        if (z) {
            if (this.fUF != null && !this.fUF.isShowing()) {
                this.fUF.setDialogVisiable(true);
            }
            this.jGA.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_a));
            return;
        }
        if (this.fUF != null) {
            this.fUF.setDialogVisiable(false);
        }
        this.jGA.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jGE != null) {
            this.jGE.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        bmg();
        if (this.jGE != null) {
            this.jGE.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmg() {
        if (this.jGA != null && this.jGA.isPlaying()) {
            this.jGF = this.jGA.getCurrentPosition();
            this.jGA.pause();
            this.jGG = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jGE != null) {
            this.jGE.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Fl(String str) {
        if (!aq.isEmpty(str) && !this.jGA.isPlaying() && !this.jGJ) {
            if (this.jGG) {
                this.jGA.seekTo(this.jGF);
                this.jGG = false;
            } else {
                this.jGA.setVideoURI(Uri.parse(str));
                e.fZ().postDelayed(this.dhP, 5000L);
            }
            this.jGA.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Fm(String str) {
        this.jGB.setVisibility(8);
        this.jGG = true;
        this.jGF = 0;
        this.jGJ = false;
        Fl(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void ei(String str, String str2) {
        if (this.jGI == null) {
            this.jGI = ej(str, str2);
        }
        this.jGI.akM();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void GM() {
        e.fZ().removeCallbacks(this.dhP);
        this.jGA.pause();
        this.fUF.setDialogVisiable(false);
        this.jGB.setVisibility(0);
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
            am.setViewTextColor(this.jGC, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.jGD, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.jGD, R.drawable.continue_play_bg);
            am.setImageResource(this.gmq, R.drawable.icon_frs_luhan_close);
            am.setImageResource(this.jGz, R.drawable.icon_frs_luhan_share);
        }
    }

    private a ej(String str, String str2) {
        this.jGI = new a(this);
        this.jGI.Fj(str2);
        if (aq.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.jGI.nn(str);
        this.jGI.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.jGH = z;
            }
        });
        this.jGI.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.jGE != null) {
                    VideoEasterEggActivity.this.jGE.cwb();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.jGI.dismiss();
            }
        });
        this.jGI.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.jGE != null) {
                    VideoEasterEggActivity.this.jGE.cwa();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).O("obj_locate", 2));
                }
                VideoEasterEggActivity.this.jGI.dismiss();
            }
        });
        this.jGI.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.jGH) {
                    VideoEasterEggActivity.this.jGE.cwd();
                }
            }
        });
        this.jGI.b(getPageContext());
        return this.jGI;
    }
}
