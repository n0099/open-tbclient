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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private com.baidu.tbadk.core.view.a jMl;
    private ImageView kiB;
    private ImageView nOH;
    private ScaleVideoView nOI;
    private View nOJ;
    private TextView nOK;
    private TextView nOL;
    private com.baidu.tieba.videoEasterEgg.b.a nOM;
    private a nOQ;
    private boolean nOR;
    private int mSkinType = 3;
    private int nON = 0;
    private boolean nOO = false;
    private boolean nOP = false;
    private Runnable nOS = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.nOM != null) {
                VideoEasterEggActivity.this.nOM.dBA();
            }
        }
    };
    private MediaPlayer.OnInfoListener nOT = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.yT(false);
                e.mB().removeCallbacks(VideoEasterEggActivity.this.nOS);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.nOM = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.jMl = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        bIl();
        dWE();
        dWF();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bIl() {
        this.kiB = (ImageView) findViewById(R.id.close);
        this.kiB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nOM != null) {
                    VideoEasterEggActivity.this.nOM.onClose();
                }
            }
        });
        this.nOH = (ImageView) findViewById(R.id.share);
        this.nOH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nOM != null) {
                    VideoEasterEggActivity.this.nOM.dcj();
                    VideoEasterEggActivity.this.pauseVideo();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).an("obj_locate", 1));
                }
            }
        });
    }

    private void dWE() {
        this.nOI = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.nOI.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.nOM != null) {
                    VideoEasterEggActivity.this.nOM.dBA();
                    return true;
                }
                return true;
            }
        });
        this.nOI.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.nOR = true;
                if (VideoEasterEggActivity.this.nOM != null) {
                    VideoEasterEggActivity.this.nOM.dWH();
                }
            }
        });
        this.nOI.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.nOI.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.nOT);
            }
        });
        this.nOI.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.yT(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.nOR = false;
            }
        });
        yT(true);
    }

    private void dWF() {
        this.nOJ = findViewById(R.id.error_container);
        this.nOK = (TextView) findViewById(R.id.load_error_text);
        this.nOK.setText(R.string.loading_error);
        this.nOL = (TextView) findViewById(R.id.play_text);
        this.nOL.setText(R.string.continues_play);
        this.nOL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nOM != null) {
                    VideoEasterEggActivity.this.nOM.dWG();
                }
            }
        });
        this.nOJ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yT(boolean z) {
        if (z) {
            if (this.jMl != null && !this.jMl.isShowing()) {
                this.jMl.setDialogVisiable(true);
            }
            this.nOI.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
            return;
        }
        if (this.jMl != null) {
            this.jMl.setDialogVisiable(false);
        }
        this.nOI.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nOM != null) {
            this.nOM.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        pauseVideo();
        if (this.nOM != null) {
            this.nOM.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseVideo() {
        if (this.nOI != null && this.nOI.isPlaying()) {
            this.nON = this.nOI.getCurrentPosition();
            this.nOI.pause();
            this.nOO = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nOM != null) {
            this.nOM.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void UN(String str) {
        if (!at.isEmpty(str) && !this.nOI.isPlaying() && !this.nOR) {
            if (this.nOO) {
                this.nOI.seekTo(this.nON);
                this.nOO = false;
            } else {
                this.nOI.setVideoURI(Uri.parse(str));
                e.mB().postDelayed(this.nOS, 5000L);
            }
            this.nOI.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void UO(String str) {
        this.nOJ.setVisibility(8);
        this.nOO = true;
        this.nON = 0;
        this.nOR = false;
        UN(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void gE(String str, String str2) {
        if (this.nOQ == null) {
            this.nOQ = gF(str, str2);
        }
        this.nOQ.btY();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void avv() {
        e.mB().removeCallbacks(this.nOS);
        this.nOI.pause();
        this.jMl.setDialogVisiable(false);
        this.nOJ.setVisibility(0);
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
            ao.setViewTextColor(this.nOK, R.color.CAM_X0101);
            ao.setViewTextColor(this.nOL, R.color.CAM_X0101);
            ao.setBackgroundResource(this.nOL, R.drawable.continue_play_bg);
            ao.setImageResource(this.kiB, R.drawable.icon_frs_luhan_close);
            ao.setImageResource(this.nOH, R.drawable.icon_frs_luhan_share);
        }
    }

    private a gF(String str, String str2) {
        this.nOQ = new a(this);
        this.nOQ.UL(str2);
        if (at.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.nOQ.Bo(str);
        this.nOQ.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.nOP = z;
            }
        });
        this.nOQ.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.nOM != null) {
                    VideoEasterEggActivity.this.nOM.dWG();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.nOQ.dismiss();
            }
        });
        this.nOQ.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.nOM != null) {
                    VideoEasterEggActivity.this.nOM.dcj();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).an("obj_locate", 2));
                }
                VideoEasterEggActivity.this.nOQ.dismiss();
            }
        });
        this.nOQ.d(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.nOP) {
                    VideoEasterEggActivity.this.nOM.dWI();
                }
            }
        });
        this.nOQ.b(getPageContext());
        return this.nOQ;
    }
}
