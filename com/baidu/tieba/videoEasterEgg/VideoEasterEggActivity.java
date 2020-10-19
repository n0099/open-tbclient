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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private com.baidu.tbadk.core.view.a iTd;
    private ImageView joo;
    private ImageView ndG;
    private ScaleVideoView ndH;
    private View ndI;
    private TextView ndJ;
    private TextView ndK;
    private com.baidu.tieba.videoEasterEgg.b.a ndL;
    private a ndP;
    private boolean ndQ;
    private int mSkinType = 3;
    private int ndM = 0;
    private boolean ndN = false;
    private boolean ndO = false;
    private Runnable ndR = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.ndL != null) {
                VideoEasterEggActivity.this.ndL.dri();
            }
        }
    };
    private MediaPlayer.OnInfoListener ndS = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.xH(false);
                e.mY().removeCallbacks(VideoEasterEggActivity.this.ndR);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.ndL = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.iTd = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        byD();
        dLW();
        dLX();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void byD() {
        this.joo = (ImageView) findViewById(R.id.close);
        this.joo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.ndL != null) {
                    VideoEasterEggActivity.this.ndL.onClose();
                }
            }
        });
        this.ndG = (ImageView) findViewById(R.id.share);
        this.ndG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.ndL != null) {
                    VideoEasterEggActivity.this.ndL.btu();
                    VideoEasterEggActivity.this.pauseVideo();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).aj("obj_locate", 1));
                }
            }
        });
    }

    private void dLW() {
        this.ndH = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.ndH.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.ndL != null) {
                    VideoEasterEggActivity.this.ndL.dri();
                    return true;
                }
                return true;
            }
        });
        this.ndH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.ndQ = true;
                if (VideoEasterEggActivity.this.ndL != null) {
                    VideoEasterEggActivity.this.ndL.dLZ();
                }
            }
        });
        this.ndH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.ndH.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.ndS);
            }
        });
        this.ndH.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.xH(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.ndQ = false;
            }
        });
        xH(true);
    }

    private void dLX() {
        this.ndI = findViewById(R.id.error_container);
        this.ndJ = (TextView) findViewById(R.id.load_error_text);
        this.ndJ.setText(R.string.loading_error);
        this.ndK = (TextView) findViewById(R.id.play_text);
        this.ndK.setText(R.string.continues_play);
        this.ndK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.ndL != null) {
                    VideoEasterEggActivity.this.ndL.dLY();
                }
            }
        });
        this.ndI.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xH(boolean z) {
        if (z) {
            if (this.iTd != null && !this.iTd.isShowing()) {
                this.iTd.setDialogVisiable(true);
            }
            this.ndH.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_a));
            return;
        }
        if (this.iTd != null) {
            this.iTd.setDialogVisiable(false);
        }
        this.ndH.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.ndL != null) {
            this.ndL.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        pauseVideo();
        if (this.ndL != null) {
            this.ndL.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseVideo() {
        if (this.ndH != null && this.ndH.isPlaying()) {
            this.ndM = this.ndH.getCurrentPosition();
            this.ndH.pause();
            this.ndN = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ndL != null) {
            this.ndL.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Tu(String str) {
        if (!at.isEmpty(str) && !this.ndH.isPlaying() && !this.ndQ) {
            if (this.ndN) {
                this.ndH.seekTo(this.ndM);
                this.ndN = false;
            } else {
                this.ndH.setVideoURI(Uri.parse(str));
                e.mY().postDelayed(this.ndR, 5000L);
            }
            this.ndH.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Tv(String str) {
        this.ndI.setVisibility(8);
        this.ndN = true;
        this.ndM = 0;
        this.ndQ = false;
        Tu(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void gx(String str, String str2) {
        if (this.ndP == null) {
            this.ndP = gy(str, str2);
        }
        this.ndP.bkJ();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void ani() {
        e.mY().removeCallbacks(this.ndR);
        this.ndH.pause();
        this.iTd.setDialogVisiable(false);
        this.ndI.setVisibility(0);
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
            ap.setViewTextColor(this.ndJ, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.ndK, (int) R.color.cp_cont_a);
            ap.setBackgroundResource(this.ndK, R.drawable.continue_play_bg);
            ap.setImageResource(this.joo, R.drawable.icon_frs_luhan_close);
            ap.setImageResource(this.ndG, R.drawable.icon_frs_luhan_share);
        }
    }

    private a gy(String str, String str2) {
        this.ndP = new a(this);
        this.ndP.Ts(str2);
        if (at.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.ndP.AH(str);
        this.ndP.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.ndO = z;
            }
        });
        this.ndP.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.ndL != null) {
                    VideoEasterEggActivity.this.ndL.dLY();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.ndP.dismiss();
            }
        });
        this.ndP.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.ndL != null) {
                    VideoEasterEggActivity.this.ndL.btu();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).aj("obj_locate", 2));
                }
                VideoEasterEggActivity.this.ndP.dismiss();
            }
        });
        this.ndP.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.ndO) {
                    VideoEasterEggActivity.this.ndL.dMa();
                }
            }
        });
        this.ndP.b(getPageContext());
        return this.ndP;
    }
}
