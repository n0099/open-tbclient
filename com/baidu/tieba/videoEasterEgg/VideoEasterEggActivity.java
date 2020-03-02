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
    private ImageView fjU;
    private com.baidu.tbadk.core.view.a gOt;
    private ImageView kEM;
    private ScaleVideoView kEN;
    private View kEO;
    private TextView kEP;
    private TextView kEQ;
    private com.baidu.tieba.videoEasterEgg.b.a kER;
    private a kEV;
    private boolean kEW;
    private int mSkinType = 3;
    private int kES = 0;
    private boolean kET = false;
    private boolean kEU = false;
    private Runnable dZQ = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.kER != null) {
                VideoEasterEggActivity.this.kER.cyu();
            }
        }
    };
    private MediaPlayer.OnInfoListener kEX = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.ty(false);
                e.gx().removeCallbacks(VideoEasterEggActivity.this.dZQ);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.kER = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.gOt = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        bcJ();
        initVideoView();
        cSp();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bcJ() {
        this.fjU = (ImageView) findViewById(R.id.close);
        this.fjU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.kER != null) {
                    VideoEasterEggActivity.this.kER.onClose();
                }
            }
        });
        this.kEM = (ImageView) findViewById(R.id.share);
        this.kEM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.kER != null) {
                    VideoEasterEggActivity.this.kER.cSq();
                    VideoEasterEggActivity.this.bGj();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).X("obj_locate", 1));
                }
            }
        });
    }

    private void initVideoView() {
        this.kEN = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.kEN.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.kER != null) {
                    VideoEasterEggActivity.this.kER.cyu();
                    return true;
                }
                return true;
            }
        });
        this.kEN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.kEW = true;
                if (VideoEasterEggActivity.this.kER != null) {
                    VideoEasterEggActivity.this.kER.cSs();
                }
            }
        });
        this.kEN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.kEN.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.kEX);
            }
        });
        this.kEN.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.ty(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.kEW = false;
            }
        });
        ty(true);
    }

    private void cSp() {
        this.kEO = findViewById(R.id.error_container);
        this.kEP = (TextView) findViewById(R.id.load_error_text);
        this.kEP.setText(R.string.loading_error);
        this.kEQ = (TextView) findViewById(R.id.play_text);
        this.kEQ.setText(R.string.continues_play);
        this.kEQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.kER != null) {
                    VideoEasterEggActivity.this.kER.cSr();
                }
            }
        });
        this.kEO.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ty(boolean z) {
        if (z) {
            if (this.gOt != null && !this.gOt.isShowing()) {
                this.gOt.setDialogVisiable(true);
            }
            this.kEN.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_a));
            return;
        }
        if (this.gOt != null) {
            this.gOt.setDialogVisiable(false);
        }
        this.kEN.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kER != null) {
            this.kER.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        bGj();
        if (this.kER != null) {
            this.kER.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGj() {
        if (this.kEN != null && this.kEN.isPlaying()) {
            this.kES = this.kEN.getCurrentPosition();
            this.kEN.pause();
            this.kET = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kER != null) {
            this.kER.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Ku(String str) {
        if (!aq.isEmpty(str) && !this.kEN.isPlaying() && !this.kEW) {
            if (this.kET) {
                this.kEN.seekTo(this.kES);
                this.kET = false;
            } else {
                this.kEN.setVideoURI(Uri.parse(str));
                e.gx().postDelayed(this.dZQ, 5000L);
            }
            this.kEN.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Kv(String str) {
        this.kEO.setVisibility(8);
        this.kET = true;
        this.kES = 0;
        this.kEW = false;
        Ku(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void eM(String str, String str2) {
        if (this.kEV == null) {
            this.kEV = eN(str, str2);
        }
        this.kEV.aEC();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Qu() {
        e.gx().removeCallbacks(this.dZQ);
        this.kEN.pause();
        this.gOt.setDialogVisiable(false);
        this.kEO.setVisibility(0);
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
            am.setViewTextColor(this.kEP, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.kEQ, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.kEQ, R.drawable.continue_play_bg);
            am.setImageResource(this.fjU, R.drawable.icon_frs_luhan_close);
            am.setImageResource(this.kEM, R.drawable.icon_frs_luhan_share);
        }
    }

    private a eN(String str, String str2) {
        this.kEV = new a(this);
        this.kEV.Ks(str2);
        if (aq.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.kEV.sS(str);
        this.kEV.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.kEU = z;
            }
        });
        this.kEV.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.kER != null) {
                    VideoEasterEggActivity.this.kER.cSr();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.kEV.dismiss();
            }
        });
        this.kEV.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.kER != null) {
                    VideoEasterEggActivity.this.kER.cSq();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).X("obj_locate", 2));
                }
                VideoEasterEggActivity.this.kEV.dismiss();
            }
        });
        this.kEV.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.kEU) {
                    VideoEasterEggActivity.this.kER.cSt();
                }
            }
        });
        this.kEV.b(getPageContext());
        return this.kEV;
    }
}
