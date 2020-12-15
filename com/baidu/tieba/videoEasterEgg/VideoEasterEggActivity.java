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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private ImageView jVp;
    private com.baidu.tbadk.core.view.a jzM;
    private ImageView nLn;
    private ScaleVideoView nLo;
    private View nLp;
    private TextView nLq;
    private TextView nLr;
    private com.baidu.tieba.videoEasterEgg.b.a nLs;
    private a nLw;
    private boolean nLx;
    private int mSkinType = 3;
    private int nLt = 0;
    private boolean nLu = false;
    private boolean nLv = false;
    private Runnable nLy = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.nLs != null) {
                VideoEasterEggActivity.this.nLs.dBK();
            }
        }
    };
    private MediaPlayer.OnInfoListener nLz = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.yT(false);
                e.mY().removeCallbacks(VideoEasterEggActivity.this.nLy);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.nLs = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new ar(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.jzM = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        bFP();
        dXa();
        dXb();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bFP() {
        this.jVp = (ImageView) findViewById(R.id.close);
        this.jVp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nLs != null) {
                    VideoEasterEggActivity.this.nLs.onClose();
                }
            }
        });
        this.nLn = (ImageView) findViewById(R.id.share);
        this.nLn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nLs != null) {
                    VideoEasterEggActivity.this.nLs.bAC();
                    VideoEasterEggActivity.this.pauseVideo();
                    TiebaStatic.log(new ar(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).al("obj_locate", 1));
                }
            }
        });
    }

    private void dXa() {
        this.nLo = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.nLo.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.nLs != null) {
                    VideoEasterEggActivity.this.nLs.dBK();
                    return true;
                }
                return true;
            }
        });
        this.nLo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.nLx = true;
                if (VideoEasterEggActivity.this.nLs != null) {
                    VideoEasterEggActivity.this.nLs.dXd();
                }
            }
        });
        this.nLo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.nLo.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.nLz);
            }
        });
        this.nLo.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.yT(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.nLx = false;
            }
        });
        yT(true);
    }

    private void dXb() {
        this.nLp = findViewById(R.id.error_container);
        this.nLq = (TextView) findViewById(R.id.load_error_text);
        this.nLq.setText(R.string.loading_error);
        this.nLr = (TextView) findViewById(R.id.play_text);
        this.nLr.setText(R.string.continues_play);
        this.nLr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nLs != null) {
                    VideoEasterEggActivity.this.nLs.dXc();
                }
            }
        });
        this.nLp.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yT(boolean z) {
        if (z) {
            if (this.jzM != null && !this.jzM.isShowing()) {
                this.jzM.setDialogVisiable(true);
            }
            this.nLo.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
            return;
        }
        if (this.jzM != null) {
            this.jzM.setDialogVisiable(false);
        }
        this.nLo.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nLs != null) {
            this.nLs.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        pauseVideo();
        if (this.nLs != null) {
            this.nLs.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseVideo() {
        if (this.nLo != null && this.nLo.isPlaying()) {
            this.nLt = this.nLo.getCurrentPosition();
            this.nLo.pause();
            this.nLu = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nLs != null) {
            this.nLs.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Vk(String str) {
        if (!au.isEmpty(str) && !this.nLo.isPlaying() && !this.nLx) {
            if (this.nLu) {
                this.nLo.seekTo(this.nLt);
                this.nLu = false;
            } else {
                this.nLo.setVideoURI(Uri.parse(str));
                e.mY().postDelayed(this.nLy, 5000L);
            }
            this.nLo.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Vl(String str) {
        this.nLp.setVisibility(8);
        this.nLu = true;
        this.nLt = 0;
        this.nLx = false;
        Vk(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void gH(String str, String str2) {
        if (this.nLw == null) {
            this.nLw = gI(str, str2);
        }
        this.nLw.brv();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void aud() {
        e.mY().removeCallbacks(this.nLy);
        this.nLo.pause();
        this.jzM.setDialogVisiable(false);
        this.nLp.setVisibility(0);
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
            ap.setViewTextColor(this.nLq, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.nLr, (int) R.color.CAM_X0101);
            ap.setBackgroundResource(this.nLr, R.drawable.continue_play_bg);
            ap.setImageResource(this.jVp, R.drawable.icon_frs_luhan_close);
            ap.setImageResource(this.nLn, R.drawable.icon_frs_luhan_share);
        }
    }

    private a gI(String str, String str2) {
        this.nLw = new a(this);
        this.nLw.Vi(str2);
        if (au.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.nLw.Bq(str);
        this.nLw.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.nLv = z;
            }
        });
        this.nLw.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.nLs != null) {
                    VideoEasterEggActivity.this.nLs.dXc();
                    TiebaStatic.log(new ar(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.nLw.dismiss();
            }
        });
        this.nLw.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.nLs != null) {
                    VideoEasterEggActivity.this.nLs.bAC();
                    TiebaStatic.log(new ar(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).al("obj_locate", 2));
                }
                VideoEasterEggActivity.this.nLw.dismiss();
            }
        });
        this.nLw.d(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.nLv) {
                    VideoEasterEggActivity.this.nLs.dXe();
                }
            }
        });
        this.nLw.b(getPageContext());
        return this.nLw;
    }
}
