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
    private ImageView jGL;
    private com.baidu.tbadk.core.view.a jlx;
    private ImageView nwd;
    private ScaleVideoView nwe;
    private View nwf;
    private TextView nwg;
    private TextView nwh;
    private com.baidu.tieba.videoEasterEgg.b.a nwi;
    private a nwm;
    private boolean nwn;
    private int mSkinType = 3;
    private int nwj = 0;
    private boolean nwk = false;
    private boolean nwl = false;
    private Runnable nwo = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.nwi != null) {
                VideoEasterEggActivity.this.nwi.dwR();
            }
        }
    };
    private MediaPlayer.OnInfoListener nwp = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.yh(false);
                e.mY().removeCallbacks(VideoEasterEggActivity.this.nwo);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.nwi = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.jlx = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        bCV();
        dRG();
        dRH();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bCV() {
        this.jGL = (ImageView) findViewById(R.id.close);
        this.jGL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nwi != null) {
                    VideoEasterEggActivity.this.nwi.onClose();
                }
            }
        });
        this.nwd = (ImageView) findViewById(R.id.share);
        this.nwd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nwi != null) {
                    VideoEasterEggActivity.this.nwi.bxM();
                    VideoEasterEggActivity.this.pauseVideo();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).al("obj_locate", 1));
                }
            }
        });
    }

    private void dRG() {
        this.nwe = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.nwe.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.nwi != null) {
                    VideoEasterEggActivity.this.nwi.dwR();
                    return true;
                }
                return true;
            }
        });
        this.nwe.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.nwn = true;
                if (VideoEasterEggActivity.this.nwi != null) {
                    VideoEasterEggActivity.this.nwi.dRJ();
                }
            }
        });
        this.nwe.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.nwe.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.nwp);
            }
        });
        this.nwe.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.yh(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.nwn = false;
            }
        });
        yh(true);
    }

    private void dRH() {
        this.nwf = findViewById(R.id.error_container);
        this.nwg = (TextView) findViewById(R.id.load_error_text);
        this.nwg.setText(R.string.loading_error);
        this.nwh = (TextView) findViewById(R.id.play_text);
        this.nwh.setText(R.string.continues_play);
        this.nwh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nwi != null) {
                    VideoEasterEggActivity.this.nwi.dRI();
                }
            }
        });
        this.nwf.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yh(boolean z) {
        if (z) {
            if (this.jlx != null && !this.jlx.isShowing()) {
                this.jlx.setDialogVisiable(true);
            }
            this.nwe.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_a));
            return;
        }
        if (this.jlx != null) {
            this.jlx.setDialogVisiable(false);
        }
        this.nwe.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nwi != null) {
            this.nwi.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        pauseVideo();
        if (this.nwi != null) {
            this.nwi.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseVideo() {
        if (this.nwe != null && this.nwe.isPlaying()) {
            this.nwj = this.nwe.getCurrentPosition();
            this.nwe.pause();
            this.nwk = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nwi != null) {
            this.nwi.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Uk(String str) {
        if (!at.isEmpty(str) && !this.nwe.isPlaying() && !this.nwn) {
            if (this.nwk) {
                this.nwe.seekTo(this.nwj);
                this.nwk = false;
            } else {
                this.nwe.setVideoURI(Uri.parse(str));
                e.mY().postDelayed(this.nwo, 5000L);
            }
            this.nwe.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Ul(String str) {
        this.nwf.setVisibility(8);
        this.nwk = true;
        this.nwj = 0;
        this.nwn = false;
        Uk(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void gC(String str, String str2) {
        if (this.nwm == null) {
            this.nwm = gD(str, str2);
        }
        this.nwm.bpc();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void arD() {
        e.mY().removeCallbacks(this.nwo);
        this.nwe.pause();
        this.jlx.setDialogVisiable(false);
        this.nwf.setVisibility(0);
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
            ap.setViewTextColor(this.nwg, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.nwh, (int) R.color.cp_cont_a);
            ap.setBackgroundResource(this.nwh, R.drawable.continue_play_bg);
            ap.setImageResource(this.jGL, R.drawable.icon_frs_luhan_close);
            ap.setImageResource(this.nwd, R.drawable.icon_frs_luhan_share);
        }
    }

    private a gD(String str, String str2) {
        this.nwm = new a(this);
        this.nwm.Ui(str2);
        if (at.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.nwm.Bo(str);
        this.nwm.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.nwl = z;
            }
        });
        this.nwm.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.nwi != null) {
                    VideoEasterEggActivity.this.nwi.dRI();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.nwm.dismiss();
            }
        });
        this.nwm.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.nwi != null) {
                    VideoEasterEggActivity.this.nwi.bxM();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).al("obj_locate", 2));
                }
                VideoEasterEggActivity.this.nwm.dismiss();
            }
        });
        this.nwm.d(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.nwl) {
                    VideoEasterEggActivity.this.nwi.dRK();
                }
            }
        });
        this.nwm.b(getPageContext());
        return this.nwm;
    }
}
