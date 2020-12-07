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
    private ImageView jVn;
    private com.baidu.tbadk.core.view.a jzK;
    private ImageView nLl;
    private ScaleVideoView nLm;
    private View nLn;
    private TextView nLo;
    private TextView nLp;
    private com.baidu.tieba.videoEasterEgg.b.a nLq;
    private a nLu;
    private boolean nLv;
    private int mSkinType = 3;
    private int nLr = 0;
    private boolean nLs = false;
    private boolean nLt = false;
    private Runnable nLw = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.nLq != null) {
                VideoEasterEggActivity.this.nLq.dBJ();
            }
        }
    };
    private MediaPlayer.OnInfoListener nLx = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.yT(false);
                e.mY().removeCallbacks(VideoEasterEggActivity.this.nLw);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.nLq = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new ar(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.jzK = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        bFP();
        dWZ();
        dXa();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bFP() {
        this.jVn = (ImageView) findViewById(R.id.close);
        this.jVn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nLq != null) {
                    VideoEasterEggActivity.this.nLq.onClose();
                }
            }
        });
        this.nLl = (ImageView) findViewById(R.id.share);
        this.nLl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nLq != null) {
                    VideoEasterEggActivity.this.nLq.bAC();
                    VideoEasterEggActivity.this.pauseVideo();
                    TiebaStatic.log(new ar(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).al("obj_locate", 1));
                }
            }
        });
    }

    private void dWZ() {
        this.nLm = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.nLm.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.nLq != null) {
                    VideoEasterEggActivity.this.nLq.dBJ();
                    return true;
                }
                return true;
            }
        });
        this.nLm.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.nLv = true;
                if (VideoEasterEggActivity.this.nLq != null) {
                    VideoEasterEggActivity.this.nLq.dXc();
                }
            }
        });
        this.nLm.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.nLm.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.nLx);
            }
        });
        this.nLm.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.yT(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.nLv = false;
            }
        });
        yT(true);
    }

    private void dXa() {
        this.nLn = findViewById(R.id.error_container);
        this.nLo = (TextView) findViewById(R.id.load_error_text);
        this.nLo.setText(R.string.loading_error);
        this.nLp = (TextView) findViewById(R.id.play_text);
        this.nLp.setText(R.string.continues_play);
        this.nLp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nLq != null) {
                    VideoEasterEggActivity.this.nLq.dXb();
                }
            }
        });
        this.nLn.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yT(boolean z) {
        if (z) {
            if (this.jzK != null && !this.jzK.isShowing()) {
                this.jzK.setDialogVisiable(true);
            }
            this.nLm.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
            return;
        }
        if (this.jzK != null) {
            this.jzK.setDialogVisiable(false);
        }
        this.nLm.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nLq != null) {
            this.nLq.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        pauseVideo();
        if (this.nLq != null) {
            this.nLq.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseVideo() {
        if (this.nLm != null && this.nLm.isPlaying()) {
            this.nLr = this.nLm.getCurrentPosition();
            this.nLm.pause();
            this.nLs = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nLq != null) {
            this.nLq.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Vk(String str) {
        if (!au.isEmpty(str) && !this.nLm.isPlaying() && !this.nLv) {
            if (this.nLs) {
                this.nLm.seekTo(this.nLr);
                this.nLs = false;
            } else {
                this.nLm.setVideoURI(Uri.parse(str));
                e.mY().postDelayed(this.nLw, 5000L);
            }
            this.nLm.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Vl(String str) {
        this.nLn.setVisibility(8);
        this.nLs = true;
        this.nLr = 0;
        this.nLv = false;
        Vk(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void gH(String str, String str2) {
        if (this.nLu == null) {
            this.nLu = gI(str, str2);
        }
        this.nLu.brv();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void aud() {
        e.mY().removeCallbacks(this.nLw);
        this.nLm.pause();
        this.jzK.setDialogVisiable(false);
        this.nLn.setVisibility(0);
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
            ap.setViewTextColor(this.nLo, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.nLp, (int) R.color.CAM_X0101);
            ap.setBackgroundResource(this.nLp, R.drawable.continue_play_bg);
            ap.setImageResource(this.jVn, R.drawable.icon_frs_luhan_close);
            ap.setImageResource(this.nLl, R.drawable.icon_frs_luhan_share);
        }
    }

    private a gI(String str, String str2) {
        this.nLu = new a(this);
        this.nLu.Vi(str2);
        if (au.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.nLu.Bq(str);
        this.nLu.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.nLt = z;
            }
        });
        this.nLu.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.nLq != null) {
                    VideoEasterEggActivity.this.nLq.dXb();
                    TiebaStatic.log(new ar(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.nLu.dismiss();
            }
        });
        this.nLu.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.nLq != null) {
                    VideoEasterEggActivity.this.nLq.bAC();
                    TiebaStatic.log(new ar(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).al("obj_locate", 2));
                }
                VideoEasterEggActivity.this.nLu.dismiss();
            }
        });
        this.nLu.d(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.nLt) {
                    VideoEasterEggActivity.this.nLq.dXd();
                }
            }
        });
        this.nLu.b(getPageContext());
        return this.nLu;
    }
}
