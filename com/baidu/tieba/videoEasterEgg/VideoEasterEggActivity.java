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
import com.baidu.adp.lib.f.e;
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
/* loaded from: classes9.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private ImageView fkG;
    private com.baidu.tbadk.core.view.a gPM;
    private ImageView kGF;
    private ScaleVideoView kGG;
    private View kGH;
    private TextView kGI;
    private TextView kGJ;
    private com.baidu.tieba.videoEasterEgg.b.a kGK;
    private a kGO;
    private boolean kGP;
    private int mSkinType = 3;
    private int kGL = 0;
    private boolean kGM = false;
    private boolean kGN = false;
    private Runnable eat = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.kGK != null) {
                VideoEasterEggActivity.this.kGK.cyO();
            }
        }
    };
    private MediaPlayer.OnInfoListener kGQ = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.tE(false);
                e.gx().removeCallbacks(VideoEasterEggActivity.this.eat);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.kGK = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.gPM = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        bcO();
        initVideoView();
        cSK();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bcO() {
        this.fkG = (ImageView) findViewById(R.id.close);
        this.fkG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.kGK != null) {
                    VideoEasterEggActivity.this.kGK.onClose();
                }
            }
        });
        this.kGF = (ImageView) findViewById(R.id.share);
        this.kGF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.kGK != null) {
                    VideoEasterEggActivity.this.kGK.cSL();
                    VideoEasterEggActivity.this.bGw();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).X("obj_locate", 1));
                }
            }
        });
    }

    private void initVideoView() {
        this.kGG = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.kGG.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.kGK != null) {
                    VideoEasterEggActivity.this.kGK.cyO();
                    return true;
                }
                return true;
            }
        });
        this.kGG.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.kGP = true;
                if (VideoEasterEggActivity.this.kGK != null) {
                    VideoEasterEggActivity.this.kGK.cSN();
                }
            }
        });
        this.kGG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.kGG.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.kGQ);
            }
        });
        this.kGG.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.tE(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.kGP = false;
            }
        });
        tE(true);
    }

    private void cSK() {
        this.kGH = findViewById(R.id.error_container);
        this.kGI = (TextView) findViewById(R.id.load_error_text);
        this.kGI.setText(R.string.loading_error);
        this.kGJ = (TextView) findViewById(R.id.play_text);
        this.kGJ.setText(R.string.continues_play);
        this.kGJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.kGK != null) {
                    VideoEasterEggActivity.this.kGK.cSM();
                }
            }
        });
        this.kGH.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tE(boolean z) {
        if (z) {
            if (this.gPM != null && !this.gPM.isShowing()) {
                this.gPM.setDialogVisiable(true);
            }
            this.kGG.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_a));
            return;
        }
        if (this.gPM != null) {
            this.gPM.setDialogVisiable(false);
        }
        this.kGG.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kGK != null) {
            this.kGK.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        bGw();
        if (this.kGK != null) {
            this.kGK.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGw() {
        if (this.kGG != null && this.kGG.isPlaying()) {
            this.kGL = this.kGG.getCurrentPosition();
            this.kGG.pause();
            this.kGM = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kGK != null) {
            this.kGK.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Ku(String str) {
        if (!aq.isEmpty(str) && !this.kGG.isPlaying() && !this.kGP) {
            if (this.kGM) {
                this.kGG.seekTo(this.kGL);
                this.kGM = false;
            } else {
                this.kGG.setVideoURI(Uri.parse(str));
                e.gx().postDelayed(this.eat, 5000L);
            }
            this.kGG.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Kv(String str) {
        this.kGH.setVisibility(8);
        this.kGM = true;
        this.kGL = 0;
        this.kGP = false;
        Ku(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void eK(String str, String str2) {
        if (this.kGO == null) {
            this.kGO = eL(str, str2);
        }
        this.kGO.aEG();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Qx() {
        e.gx().removeCallbacks(this.eat);
        this.kGG.pause();
        this.gPM.setDialogVisiable(false);
        this.kGH.setVisibility(0);
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
            am.setViewTextColor(this.kGI, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.kGJ, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.kGJ, R.drawable.continue_play_bg);
            am.setImageResource(this.fkG, R.drawable.icon_frs_luhan_close);
            am.setImageResource(this.kGF, R.drawable.icon_frs_luhan_share);
        }
    }

    private a eL(String str, String str2) {
        this.kGO = new a(this);
        this.kGO.Ks(str2);
        if (aq.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.kGO.sR(str);
        this.kGO.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.kGN = z;
            }
        });
        this.kGO.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.kGK != null) {
                    VideoEasterEggActivity.this.kGK.cSM();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.kGO.dismiss();
            }
        });
        this.kGO.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.kGK != null) {
                    VideoEasterEggActivity.this.kGK.cSL();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).X("obj_locate", 2));
                }
                VideoEasterEggActivity.this.kGO.dismiss();
            }
        });
        this.kGO.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.kGN) {
                    VideoEasterEggActivity.this.kGK.cSO();
                }
            }
        });
        this.kGO.b(getPageContext());
        return this.kGO;
    }
}
