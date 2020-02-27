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
    private ImageView fjT;
    private com.baidu.tbadk.core.view.a gOr;
    private ImageView kEK;
    private ScaleVideoView kEL;
    private View kEM;
    private TextView kEN;
    private TextView kEO;
    private com.baidu.tieba.videoEasterEgg.b.a kEP;
    private a kET;
    private boolean kEU;
    private int mSkinType = 3;
    private int kEQ = 0;
    private boolean kER = false;
    private boolean kES = false;
    private Runnable dZP = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.kEP != null) {
                VideoEasterEggActivity.this.kEP.cys();
            }
        }
    };
    private MediaPlayer.OnInfoListener kEV = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.ty(false);
                e.gx().removeCallbacks(VideoEasterEggActivity.this.dZP);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.kEP = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.gOr = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        bcH();
        initVideoView();
        cSn();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bcH() {
        this.fjT = (ImageView) findViewById(R.id.close);
        this.fjT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.kEP != null) {
                    VideoEasterEggActivity.this.kEP.onClose();
                }
            }
        });
        this.kEK = (ImageView) findViewById(R.id.share);
        this.kEK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.kEP != null) {
                    VideoEasterEggActivity.this.kEP.cSo();
                    VideoEasterEggActivity.this.bGh();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).X("obj_locate", 1));
                }
            }
        });
    }

    private void initVideoView() {
        this.kEL = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.kEL.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.kEP != null) {
                    VideoEasterEggActivity.this.kEP.cys();
                    return true;
                }
                return true;
            }
        });
        this.kEL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.kEU = true;
                if (VideoEasterEggActivity.this.kEP != null) {
                    VideoEasterEggActivity.this.kEP.cSq();
                }
            }
        });
        this.kEL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.kEL.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.kEV);
            }
        });
        this.kEL.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.ty(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.kEU = false;
            }
        });
        ty(true);
    }

    private void cSn() {
        this.kEM = findViewById(R.id.error_container);
        this.kEN = (TextView) findViewById(R.id.load_error_text);
        this.kEN.setText(R.string.loading_error);
        this.kEO = (TextView) findViewById(R.id.play_text);
        this.kEO.setText(R.string.continues_play);
        this.kEO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.kEP != null) {
                    VideoEasterEggActivity.this.kEP.cSp();
                }
            }
        });
        this.kEM.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ty(boolean z) {
        if (z) {
            if (this.gOr != null && !this.gOr.isShowing()) {
                this.gOr.setDialogVisiable(true);
            }
            this.kEL.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_a));
            return;
        }
        if (this.gOr != null) {
            this.gOr.setDialogVisiable(false);
        }
        this.kEL.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kEP != null) {
            this.kEP.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        bGh();
        if (this.kEP != null) {
            this.kEP.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGh() {
        if (this.kEL != null && this.kEL.isPlaying()) {
            this.kEQ = this.kEL.getCurrentPosition();
            this.kEL.pause();
            this.kER = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kEP != null) {
            this.kEP.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Ku(String str) {
        if (!aq.isEmpty(str) && !this.kEL.isPlaying() && !this.kEU) {
            if (this.kER) {
                this.kEL.seekTo(this.kEQ);
                this.kER = false;
            } else {
                this.kEL.setVideoURI(Uri.parse(str));
                e.gx().postDelayed(this.dZP, 5000L);
            }
            this.kEL.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Kv(String str) {
        this.kEM.setVisibility(8);
        this.kER = true;
        this.kEQ = 0;
        this.kEU = false;
        Ku(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void eM(String str, String str2) {
        if (this.kET == null) {
            this.kET = eN(str, str2);
        }
        this.kET.aEA();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Qs() {
        e.gx().removeCallbacks(this.dZP);
        this.kEL.pause();
        this.gOr.setDialogVisiable(false);
        this.kEM.setVisibility(0);
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
            am.setViewTextColor(this.kEN, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.kEO, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.kEO, R.drawable.continue_play_bg);
            am.setImageResource(this.fjT, R.drawable.icon_frs_luhan_close);
            am.setImageResource(this.kEK, R.drawable.icon_frs_luhan_share);
        }
    }

    private a eN(String str, String str2) {
        this.kET = new a(this);
        this.kET.Ks(str2);
        if (aq.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.kET.sS(str);
        this.kET.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.kES = z;
            }
        });
        this.kET.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.kEP != null) {
                    VideoEasterEggActivity.this.kEP.cSp();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.kET.dismiss();
            }
        });
        this.kET.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.kEP != null) {
                    VideoEasterEggActivity.this.kEP.cSo();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).X("obj_locate", 2));
                }
                VideoEasterEggActivity.this.kET.dismiss();
            }
        });
        this.kET.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.kES) {
                    VideoEasterEggActivity.this.kEP.cSr();
                }
            }
        });
        this.kET.b(getPageContext());
        return this.kET;
    }
}
