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
/* loaded from: classes2.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private ImageView ixA;
    private com.baidu.tbadk.core.view.a jNj;
    private ImageView nTK;
    private ScaleVideoView nTL;
    private View nTM;
    private TextView nTN;
    private TextView nTO;
    private com.baidu.tieba.videoEasterEgg.b.a nTP;
    private a nTT;
    private boolean nTU;
    private int mSkinType = 3;
    private int nTQ = 0;
    private boolean nTR = false;
    private boolean nTS = false;
    private Runnable nTV = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.nTP != null) {
                VideoEasterEggActivity.this.nTP.cMH();
            }
        }
    };
    private MediaPlayer.OnInfoListener nTW = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.zi(false);
                e.mA().removeCallbacks(VideoEasterEggActivity.this.nTV);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.nTP = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new ar(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.jNj = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        bEL();
        dUX();
        dUY();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bEL() {
        this.ixA = (ImageView) findViewById(R.id.close);
        this.ixA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nTP != null) {
                    VideoEasterEggActivity.this.nTP.onClose();
                }
            }
        });
        this.nTK = (ImageView) findViewById(R.id.share);
        this.nTK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nTP != null) {
                    VideoEasterEggActivity.this.nTP.dap();
                    VideoEasterEggActivity.this.pauseVideo();
                    TiebaStatic.log(new ar(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).ap("obj_locate", 1));
                }
            }
        });
    }

    private void dUX() {
        this.nTL = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.nTL.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.nTP != null) {
                    VideoEasterEggActivity.this.nTP.cMH();
                    return true;
                }
                return true;
            }
        });
        this.nTL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.nTU = true;
                if (VideoEasterEggActivity.this.nTP != null) {
                    VideoEasterEggActivity.this.nTP.dVa();
                }
            }
        });
        this.nTL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.nTL.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.nTW);
            }
        });
        this.nTL.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.zi(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.nTU = false;
            }
        });
        zi(true);
    }

    private void dUY() {
        this.nTM = findViewById(R.id.error_container);
        this.nTN = (TextView) findViewById(R.id.load_error_text);
        this.nTN.setText(R.string.loading_error);
        this.nTO = (TextView) findViewById(R.id.play_text);
        this.nTO.setText(R.string.continues_play);
        this.nTO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nTP != null) {
                    VideoEasterEggActivity.this.nTP.dUZ();
                }
            }
        });
        this.nTM.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zi(boolean z) {
        if (z) {
            if (this.jNj != null && !this.jNj.isShowing()) {
                this.jNj.setDialogVisiable(true);
            }
            this.nTL.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
            return;
        }
        if (this.jNj != null) {
            this.jNj.setDialogVisiable(false);
        }
        this.nTL.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nTP != null) {
            this.nTP.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        pauseVideo();
        if (this.nTP != null) {
            this.nTP.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseVideo() {
        if (this.nTL != null && this.nTL.isPlaying()) {
            this.nTQ = this.nTL.getCurrentPosition();
            this.nTL.pause();
            this.nTR = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nTP != null) {
            this.nTP.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void UD(String str) {
        if (!au.isEmpty(str) && !this.nTL.isPlaying() && !this.nTU) {
            if (this.nTR) {
                this.nTL.seekTo(this.nTQ);
                this.nTR = false;
            } else {
                this.nTL.setVideoURI(Uri.parse(str));
                e.mA().postDelayed(this.nTV, 5000L);
            }
            this.nTL.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void UE(String str) {
        this.nTM.setVisibility(8);
        this.nTR = true;
        this.nTQ = 0;
        this.nTU = false;
        UD(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void gJ(String str, String str2) {
        if (this.nTT == null) {
            this.nTT = gK(str, str2);
        }
        this.nTT.bqx();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void arY() {
        e.mA().removeCallbacks(this.nTV);
        this.nTL.pause();
        this.jNj.setDialogVisiable(false);
        this.nTM.setVisibility(0);
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
            ap.setViewTextColor(this.nTN, R.color.CAM_X0101);
            ap.setViewTextColor(this.nTO, R.color.CAM_X0101);
            ap.setBackgroundResource(this.nTO, R.drawable.continue_play_bg);
            ap.setImageResource(this.ixA, R.drawable.icon_frs_luhan_close);
            ap.setImageResource(this.nTK, R.drawable.icon_frs_luhan_share);
        }
    }

    private a gK(String str, String str2) {
        this.nTT = new a(this);
        this.nTT.UB(str2);
        if (au.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.nTT.Au(str);
        this.nTT.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.nTS = z;
            }
        });
        this.nTT.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.nTP != null) {
                    VideoEasterEggActivity.this.nTP.dUZ();
                    TiebaStatic.log(new ar(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.nTT.dismiss();
            }
        });
        this.nTT.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.nTP != null) {
                    VideoEasterEggActivity.this.nTP.dap();
                    TiebaStatic.log(new ar(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).ap("obj_locate", 2));
                }
                VideoEasterEggActivity.this.nTT.dismiss();
            }
        });
        this.nTT.d(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.nTS) {
                    VideoEasterEggActivity.this.nTP.dVb();
                }
            }
        });
        this.nTT.b(getPageContext());
        return this.nTT;
    }
}
