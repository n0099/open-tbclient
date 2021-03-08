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
    private ImageView izx;
    private com.baidu.tbadk.core.view.a jPg;
    private ImageView nWo;
    private ScaleVideoView nWp;
    private View nWq;
    private TextView nWr;
    private TextView nWs;
    private com.baidu.tieba.videoEasterEgg.b.a nWt;
    private a nWx;
    private boolean nWy;
    private int mSkinType = 3;
    private int nWu = 0;
    private boolean nWv = false;
    private boolean nWw = false;
    private Runnable nWz = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.nWt != null) {
                VideoEasterEggActivity.this.nWt.cMU();
            }
        }
    };
    private MediaPlayer.OnInfoListener nWA = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.zh(false);
                e.mA().removeCallbacks(VideoEasterEggActivity.this.nWz);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.nWt = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new ar(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.jPg = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        bEP();
        dVn();
        dVo();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bEP() {
        this.izx = (ImageView) findViewById(R.id.close);
        this.izx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nWt != null) {
                    VideoEasterEggActivity.this.nWt.onClose();
                }
            }
        });
        this.nWo = (ImageView) findViewById(R.id.share);
        this.nWo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nWt != null) {
                    VideoEasterEggActivity.this.nWt.daF();
                    VideoEasterEggActivity.this.pauseVideo();
                    TiebaStatic.log(new ar(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).aq("obj_locate", 1));
                }
            }
        });
    }

    private void dVn() {
        this.nWp = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.nWp.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.nWt != null) {
                    VideoEasterEggActivity.this.nWt.cMU();
                    return true;
                }
                return true;
            }
        });
        this.nWp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.nWy = true;
                if (VideoEasterEggActivity.this.nWt != null) {
                    VideoEasterEggActivity.this.nWt.dVq();
                }
            }
        });
        this.nWp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.nWp.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.nWA);
            }
        });
        this.nWp.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.zh(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.nWy = false;
            }
        });
        zh(true);
    }

    private void dVo() {
        this.nWq = findViewById(R.id.error_container);
        this.nWr = (TextView) findViewById(R.id.load_error_text);
        this.nWr.setText(R.string.loading_error);
        this.nWs = (TextView) findViewById(R.id.play_text);
        this.nWs.setText(R.string.continues_play);
        this.nWs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nWt != null) {
                    VideoEasterEggActivity.this.nWt.dVp();
                }
            }
        });
        this.nWq.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh(boolean z) {
        if (z) {
            if (this.jPg != null && !this.jPg.isShowing()) {
                this.jPg.setDialogVisiable(true);
            }
            this.nWp.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
            return;
        }
        if (this.jPg != null) {
            this.jPg.setDialogVisiable(false);
        }
        this.nWp.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nWt != null) {
            this.nWt.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        pauseVideo();
        if (this.nWt != null) {
            this.nWt.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseVideo() {
        if (this.nWp != null && this.nWp.isPlaying()) {
            this.nWu = this.nWp.getCurrentPosition();
            this.nWp.pause();
            this.nWv = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nWt != null) {
            this.nWt.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void UW(String str) {
        if (!au.isEmpty(str) && !this.nWp.isPlaying() && !this.nWy) {
            if (this.nWv) {
                this.nWp.seekTo(this.nWu);
                this.nWv = false;
            } else {
                this.nWp.setVideoURI(Uri.parse(str));
                e.mA().postDelayed(this.nWz, 5000L);
            }
            this.nWp.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void UX(String str) {
        this.nWq.setVisibility(8);
        this.nWv = true;
        this.nWu = 0;
        this.nWy = false;
        UW(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void gL(String str, String str2) {
        if (this.nWx == null) {
            this.nWx = gM(str, str2);
        }
        this.nWx.bqz();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void asb() {
        e.mA().removeCallbacks(this.nWz);
        this.nWp.pause();
        this.jPg.setDialogVisiable(false);
        this.nWq.setVisibility(0);
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
            ap.setViewTextColor(this.nWr, R.color.CAM_X0101);
            ap.setViewTextColor(this.nWs, R.color.CAM_X0101);
            ap.setBackgroundResource(this.nWs, R.drawable.continue_play_bg);
            ap.setImageResource(this.izx, R.drawable.icon_frs_luhan_close);
            ap.setImageResource(this.nWo, R.drawable.icon_frs_luhan_share);
        }
    }

    private a gM(String str, String str2) {
        this.nWx = new a(this);
        this.nWx.UU(str2);
        if (au.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.nWx.AB(str);
        this.nWx.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.nWw = z;
            }
        });
        this.nWx.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.nWt != null) {
                    VideoEasterEggActivity.this.nWt.dVp();
                    TiebaStatic.log(new ar(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.nWx.dismiss();
            }
        });
        this.nWx.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.nWt != null) {
                    VideoEasterEggActivity.this.nWt.daF();
                    TiebaStatic.log(new ar(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).aq("obj_locate", 2));
                }
                VideoEasterEggActivity.this.nWx.dismiss();
            }
        });
        this.nWx.d(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.nWw) {
                    VideoEasterEggActivity.this.nWt.dVr();
                }
            }
        });
        this.nWx.b(getPageContext());
        return this.nWx;
    }
}
