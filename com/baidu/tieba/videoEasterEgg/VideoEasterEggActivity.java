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
/* loaded from: classes6.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private ImageView fdH;
    private com.baidu.tbadk.core.view.a gJf;
    private ImageView kAi;
    private ScaleVideoView kAj;
    private View kAk;
    private TextView kAl;
    private TextView kAm;
    private com.baidu.tieba.videoEasterEgg.b.a kAn;
    private a kAr;
    private boolean kAs;
    private int mSkinType = 3;
    private int kAo = 0;
    private boolean kAp = false;
    private boolean kAq = false;
    private Runnable dVC = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.kAn != null) {
                VideoEasterEggActivity.this.kAn.cvQ();
            }
        }
    };
    private MediaPlayer.OnInfoListener kAt = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.ti(false);
                e.gy().removeCallbacks(VideoEasterEggActivity.this.dVC);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.kAn = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.gJf = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        aZT();
        initVideoView();
        cPP();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aZT() {
        this.fdH = (ImageView) findViewById(R.id.close);
        this.fdH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.kAn != null) {
                    VideoEasterEggActivity.this.kAn.onClose();
                }
            }
        });
        this.kAi = (ImageView) findViewById(R.id.share);
        this.kAi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.kAn != null) {
                    VideoEasterEggActivity.this.kAn.cPQ();
                    VideoEasterEggActivity.this.bDD();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).Z("obj_locate", 1));
                }
            }
        });
    }

    private void initVideoView() {
        this.kAj = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.kAj.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.kAn != null) {
                    VideoEasterEggActivity.this.kAn.cvQ();
                    return true;
                }
                return true;
            }
        });
        this.kAj.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.kAs = true;
                if (VideoEasterEggActivity.this.kAn != null) {
                    VideoEasterEggActivity.this.kAn.cPS();
                }
            }
        });
        this.kAj.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.kAj.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.kAt);
            }
        });
        this.kAj.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.ti(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.kAs = false;
            }
        });
        ti(true);
    }

    private void cPP() {
        this.kAk = findViewById(R.id.error_container);
        this.kAl = (TextView) findViewById(R.id.load_error_text);
        this.kAl.setText(R.string.loading_error);
        this.kAm = (TextView) findViewById(R.id.play_text);
        this.kAm.setText(R.string.continues_play);
        this.kAm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.kAn != null) {
                    VideoEasterEggActivity.this.kAn.cPR();
                }
            }
        });
        this.kAk.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ti(boolean z) {
        if (z) {
            if (this.gJf != null && !this.gJf.isShowing()) {
                this.gJf.setDialogVisiable(true);
            }
            this.kAj.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_a));
            return;
        }
        if (this.gJf != null) {
            this.gJf.setDialogVisiable(false);
        }
        this.kAj.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kAn != null) {
            this.kAn.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        bDD();
        if (this.kAn != null) {
            this.kAn.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDD() {
        if (this.kAj != null && this.kAj.isPlaying()) {
            this.kAo = this.kAj.getCurrentPosition();
            this.kAj.pause();
            this.kAp = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kAn != null) {
            this.kAn.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void JX(String str) {
        if (!aq.isEmpty(str) && !this.kAj.isPlaying() && !this.kAs) {
            if (this.kAp) {
                this.kAj.seekTo(this.kAo);
                this.kAp = false;
            } else {
                this.kAj.setVideoURI(Uri.parse(str));
                e.gy().postDelayed(this.dVC, 5000L);
            }
            this.kAj.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void JY(String str) {
        this.kAk.setVisibility(8);
        this.kAp = true;
        this.kAo = 0;
        this.kAs = false;
        JX(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void eB(String str, String str2) {
        if (this.kAr == null) {
            this.kAr = eC(str, str2);
        }
        this.kAr.aBW();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void NI() {
        e.gy().removeCallbacks(this.dVC);
        this.kAj.pause();
        this.gJf.setDialogVisiable(false);
        this.kAk.setVisibility(0);
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
            am.setViewTextColor(this.kAl, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.kAm, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.kAm, R.drawable.continue_play_bg);
            am.setImageResource(this.fdH, R.drawable.icon_frs_luhan_close);
            am.setImageResource(this.kAi, R.drawable.icon_frs_luhan_share);
        }
    }

    private a eC(String str, String str2) {
        this.kAr = new a(this);
        this.kAr.JV(str2);
        if (aq.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.kAr.sz(str);
        this.kAr.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.kAq = z;
            }
        });
        this.kAr.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.kAn != null) {
                    VideoEasterEggActivity.this.kAn.cPR();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.kAr.dismiss();
            }
        });
        this.kAr.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.kAn != null) {
                    VideoEasterEggActivity.this.kAn.cPQ();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).Z("obj_locate", 2));
                }
                VideoEasterEggActivity.this.kAr.dismiss();
            }
        });
        this.kAr.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.kAq) {
                    VideoEasterEggActivity.this.kAn.cPT();
                }
            }
        });
        this.kAr.b(getPageContext());
        return this.kAr;
    }
}
