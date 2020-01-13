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
/* loaded from: classes7.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private ImageView fgN;
    private com.baidu.tbadk.core.view.a gMs;
    private ImageView kDK;
    private ScaleVideoView kDL;
    private View kDM;
    private TextView kDN;
    private TextView kDO;
    private com.baidu.tieba.videoEasterEgg.b.a kDP;
    private a kDT;
    private boolean kDU;
    private int mSkinType = 3;
    private int kDQ = 0;
    private boolean kDR = false;
    private boolean kDS = false;
    private Runnable dVL = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.kDP != null) {
                VideoEasterEggActivity.this.kDP.cwX();
            }
        }
    };
    private MediaPlayer.OnInfoListener kDV = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.tu(false);
                e.gx().removeCallbacks(VideoEasterEggActivity.this.dVL);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.kDP = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.gMs = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        bas();
        initVideoView();
        cQS();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bas() {
        this.fgN = (ImageView) findViewById(R.id.close);
        this.fgN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.kDP != null) {
                    VideoEasterEggActivity.this.kDP.onClose();
                }
            }
        });
        this.kDK = (ImageView) findViewById(R.id.share);
        this.kDK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.kDP != null) {
                    VideoEasterEggActivity.this.kDP.cQT();
                    VideoEasterEggActivity.this.bEF();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).Z("obj_locate", 1));
                }
            }
        });
    }

    private void initVideoView() {
        this.kDL = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.kDL.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.kDP != null) {
                    VideoEasterEggActivity.this.kDP.cwX();
                    return true;
                }
                return true;
            }
        });
        this.kDL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.kDU = true;
                if (VideoEasterEggActivity.this.kDP != null) {
                    VideoEasterEggActivity.this.kDP.cQV();
                }
            }
        });
        this.kDL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.kDL.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.kDV);
            }
        });
        this.kDL.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.tu(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.kDU = false;
            }
        });
        tu(true);
    }

    private void cQS() {
        this.kDM = findViewById(R.id.error_container);
        this.kDN = (TextView) findViewById(R.id.load_error_text);
        this.kDN.setText(R.string.loading_error);
        this.kDO = (TextView) findViewById(R.id.play_text);
        this.kDO.setText(R.string.continues_play);
        this.kDO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.kDP != null) {
                    VideoEasterEggActivity.this.kDP.cQU();
                }
            }
        });
        this.kDM.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tu(boolean z) {
        if (z) {
            if (this.gMs != null && !this.gMs.isShowing()) {
                this.gMs.setDialogVisiable(true);
            }
            this.kDL.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_a));
            return;
        }
        if (this.gMs != null) {
            this.gMs.setDialogVisiable(false);
        }
        this.kDL.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kDP != null) {
            this.kDP.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        bEF();
        if (this.kDP != null) {
            this.kDP.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEF() {
        if (this.kDL != null && this.kDL.isPlaying()) {
            this.kDQ = this.kDL.getCurrentPosition();
            this.kDL.pause();
            this.kDR = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kDP != null) {
            this.kDP.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Kh(String str) {
        if (!aq.isEmpty(str) && !this.kDL.isPlaying() && !this.kDU) {
            if (this.kDR) {
                this.kDL.seekTo(this.kDQ);
                this.kDR = false;
            } else {
                this.kDL.setVideoURI(Uri.parse(str));
                e.gx().postDelayed(this.dVL, 5000L);
            }
            this.kDL.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Ki(String str) {
        this.kDM.setVisibility(8);
        this.kDR = true;
        this.kDQ = 0;
        this.kDU = false;
        Kh(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void eD(String str, String str2) {
        if (this.kDT == null) {
            this.kDT = eE(str, str2);
        }
        this.kDT.aCp();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Oe() {
        e.gx().removeCallbacks(this.dVL);
        this.kDL.pause();
        this.gMs.setDialogVisiable(false);
        this.kDM.setVisibility(0);
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
            am.setViewTextColor(this.kDN, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.kDO, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.kDO, R.drawable.continue_play_bg);
            am.setImageResource(this.fgN, R.drawable.icon_frs_luhan_close);
            am.setImageResource(this.kDK, R.drawable.icon_frs_luhan_share);
        }
    }

    private a eE(String str, String str2) {
        this.kDT = new a(this);
        this.kDT.Kf(str2);
        if (aq.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.kDT.sC(str);
        this.kDT.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.kDS = z;
            }
        });
        this.kDT.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.kDP != null) {
                    VideoEasterEggActivity.this.kDP.cQU();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.kDT.dismiss();
            }
        });
        this.kDT.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.kDP != null) {
                    VideoEasterEggActivity.this.kDP.cQT();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).Z("obj_locate", 2));
                }
                VideoEasterEggActivity.this.kDT.dismiss();
            }
        });
        this.kDT.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.kDS) {
                    VideoEasterEggActivity.this.kDP.cQW();
                }
            }
        });
        this.kDT.b(getPageContext());
        return this.kDT;
    }
}
