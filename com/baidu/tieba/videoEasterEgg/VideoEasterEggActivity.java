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
    private ImageView gdN;
    private com.baidu.tbadk.core.view.a hOE;
    private ImageView lJQ;
    private ScaleVideoView lJR;
    private View lJS;
    private TextView lJT;
    private TextView lJU;
    private com.baidu.tieba.videoEasterEgg.b.a lJV;
    private a lJZ;
    private boolean lKa;
    private int mSkinType = 3;
    private int lJW = 0;
    private boolean lJX = false;
    private boolean lJY = false;
    private Runnable lKb = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.lJV != null) {
                VideoEasterEggActivity.this.lJV.cQq();
            }
        }
    };
    private MediaPlayer.OnInfoListener lKc = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.ve(false);
                e.ld().removeCallbacks(VideoEasterEggActivity.this.lKb);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.lJV = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.hOE = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        brb();
        dkX();
        dkY();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void brb() {
        this.gdN = (ImageView) findViewById(R.id.close);
        this.gdN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.lJV != null) {
                    VideoEasterEggActivity.this.lJV.onClose();
                }
            }
        });
        this.lJQ = (ImageView) findViewById(R.id.share);
        this.lJQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.lJV != null) {
                    VideoEasterEggActivity.this.lJV.dkZ();
                    VideoEasterEggActivity.this.bXs();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).ag("obj_locate", 1));
                }
            }
        });
    }

    private void dkX() {
        this.lJR = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.lJR.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.lJV != null) {
                    VideoEasterEggActivity.this.lJV.cQq();
                    return true;
                }
                return true;
            }
        });
        this.lJR.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.lKa = true;
                if (VideoEasterEggActivity.this.lJV != null) {
                    VideoEasterEggActivity.this.lJV.dlb();
                }
            }
        });
        this.lJR.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.lJR.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.lKc);
            }
        });
        this.lJR.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.ve(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.lKa = false;
            }
        });
        ve(true);
    }

    private void dkY() {
        this.lJS = findViewById(R.id.error_container);
        this.lJT = (TextView) findViewById(R.id.load_error_text);
        this.lJT.setText(R.string.loading_error);
        this.lJU = (TextView) findViewById(R.id.play_text);
        this.lJU.setText(R.string.continues_play);
        this.lJU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.lJV != null) {
                    VideoEasterEggActivity.this.lJV.dla();
                }
            }
        });
        this.lJS.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve(boolean z) {
        if (z) {
            if (this.hOE != null && !this.hOE.isShowing()) {
                this.hOE.setDialogVisiable(true);
            }
            this.lJR.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_a));
            return;
        }
        if (this.hOE != null) {
            this.hOE.setDialogVisiable(false);
        }
        this.lJR.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lJV != null) {
            this.lJV.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        bXs();
        if (this.lJV != null) {
            this.lJV.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXs() {
        if (this.lJR != null && this.lJR.isPlaying()) {
            this.lJW = this.lJR.getCurrentPosition();
            this.lJR.pause();
            this.lJX = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lJV != null) {
            this.lJV.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void NW(String str) {
        if (!aq.isEmpty(str) && !this.lJR.isPlaying() && !this.lKa) {
            if (this.lJX) {
                this.lJR.seekTo(this.lJW);
                this.lJX = false;
            } else {
                this.lJR.setVideoURI(Uri.parse(str));
                e.ld().postDelayed(this.lKb, 5000L);
            }
            this.lJR.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void NX(String str) {
        this.lJS.setVisibility(8);
        this.lJX = true;
        this.lJW = 0;
        this.lKa = false;
        NW(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void fA(String str, String str2) {
        if (this.lJZ == null) {
            this.lJZ = fB(str, str2);
        }
        this.lJZ.aST();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void abh() {
        e.ld().removeCallbacks(this.lKb);
        this.lJR.pause();
        this.hOE.setDialogVisiable(false);
        this.lJS.setVisibility(0);
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
            am.setViewTextColor(this.lJT, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.lJU, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.lJU, R.drawable.continue_play_bg);
            am.setImageResource(this.gdN, R.drawable.icon_frs_luhan_close);
            am.setImageResource(this.lJQ, R.drawable.icon_frs_luhan_share);
        }
    }

    private a fB(String str, String str2) {
        this.lJZ = new a(this);
        this.lJZ.NU(str2);
        if (aq.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.lJZ.vO(str);
        this.lJZ.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.lJY = z;
            }
        });
        this.lJZ.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.lJV != null) {
                    VideoEasterEggActivity.this.lJV.dla();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.lJZ.dismiss();
            }
        });
        this.lJZ.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.lJV != null) {
                    VideoEasterEggActivity.this.lJV.dkZ();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).ag("obj_locate", 2));
                }
                VideoEasterEggActivity.this.lJZ.dismiss();
            }
        });
        this.lJZ.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.lJY) {
                    VideoEasterEggActivity.this.lJV.dlc();
                }
            }
        });
        this.lJZ.b(getPageContext());
        return this.lJZ;
    }
}
