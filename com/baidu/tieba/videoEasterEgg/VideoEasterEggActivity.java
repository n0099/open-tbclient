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
    private ImageView nOI;
    private ScaleVideoView nOJ;
    private View nOK;
    private TextView nOL;
    private TextView nOM;
    private com.baidu.tieba.videoEasterEgg.b.a nON;
    private a nOR;
    private boolean nOS;
    private int mSkinType = 3;
    private int nOO = 0;
    private boolean nOP = false;
    private boolean nOQ = false;
    private Runnable nOT = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.nON != null) {
                VideoEasterEggActivity.this.nON.dBz();
            }
        }
    };
    private MediaPlayer.OnInfoListener nOU = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.yT(false);
                e.mB().removeCallbacks(VideoEasterEggActivity.this.nOT);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.nON = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.jMl = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        bIk();
        dWD();
        dWE();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bIk() {
        this.kiB = (ImageView) findViewById(R.id.close);
        this.kiB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nON != null) {
                    VideoEasterEggActivity.this.nON.onClose();
                }
            }
        });
        this.nOI = (ImageView) findViewById(R.id.share);
        this.nOI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nON != null) {
                    VideoEasterEggActivity.this.nON.dci();
                    VideoEasterEggActivity.this.pauseVideo();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).an("obj_locate", 1));
                }
            }
        });
    }

    private void dWD() {
        this.nOJ = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.nOJ.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.nON != null) {
                    VideoEasterEggActivity.this.nON.dBz();
                    return true;
                }
                return true;
            }
        });
        this.nOJ.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.nOS = true;
                if (VideoEasterEggActivity.this.nON != null) {
                    VideoEasterEggActivity.this.nON.dWG();
                }
            }
        });
        this.nOJ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.nOJ.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.nOU);
            }
        });
        this.nOJ.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.yT(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.nOS = false;
            }
        });
        yT(true);
    }

    private void dWE() {
        this.nOK = findViewById(R.id.error_container);
        this.nOL = (TextView) findViewById(R.id.load_error_text);
        this.nOL.setText(R.string.loading_error);
        this.nOM = (TextView) findViewById(R.id.play_text);
        this.nOM.setText(R.string.continues_play);
        this.nOM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nON != null) {
                    VideoEasterEggActivity.this.nON.dWF();
                }
            }
        });
        this.nOK.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yT(boolean z) {
        if (z) {
            if (this.jMl != null && !this.jMl.isShowing()) {
                this.jMl.setDialogVisiable(true);
            }
            this.nOJ.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
            return;
        }
        if (this.jMl != null) {
            this.jMl.setDialogVisiable(false);
        }
        this.nOJ.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nON != null) {
            this.nON.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        pauseVideo();
        if (this.nON != null) {
            this.nON.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseVideo() {
        if (this.nOJ != null && this.nOJ.isPlaying()) {
            this.nOO = this.nOJ.getCurrentPosition();
            this.nOJ.pause();
            this.nOP = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nON != null) {
            this.nON.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void UO(String str) {
        if (!at.isEmpty(str) && !this.nOJ.isPlaying() && !this.nOS) {
            if (this.nOP) {
                this.nOJ.seekTo(this.nOO);
                this.nOP = false;
            } else {
                this.nOJ.setVideoURI(Uri.parse(str));
                e.mB().postDelayed(this.nOT, 5000L);
            }
            this.nOJ.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void UP(String str) {
        this.nOK.setVisibility(8);
        this.nOP = true;
        this.nOO = 0;
        this.nOS = false;
        UO(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void gE(String str, String str2) {
        if (this.nOR == null) {
            this.nOR = gF(str, str2);
        }
        this.nOR.btX();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void avu() {
        e.mB().removeCallbacks(this.nOT);
        this.nOJ.pause();
        this.jMl.setDialogVisiable(false);
        this.nOK.setVisibility(0);
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
            ao.setViewTextColor(this.nOL, R.color.CAM_X0101);
            ao.setViewTextColor(this.nOM, R.color.CAM_X0101);
            ao.setBackgroundResource(this.nOM, R.drawable.continue_play_bg);
            ao.setImageResource(this.kiB, R.drawable.icon_frs_luhan_close);
            ao.setImageResource(this.nOI, R.drawable.icon_frs_luhan_share);
        }
    }

    private a gF(String str, String str2) {
        this.nOR = new a(this);
        this.nOR.UM(str2);
        if (at.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.nOR.Bp(str);
        this.nOR.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.nOQ = z;
            }
        });
        this.nOR.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.nON != null) {
                    VideoEasterEggActivity.this.nON.dWF();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.nOR.dismiss();
            }
        });
        this.nOR.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.nON != null) {
                    VideoEasterEggActivity.this.nON.dci();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).an("obj_locate", 2));
                }
                VideoEasterEggActivity.this.nOR.dismiss();
            }
        });
        this.nOR.d(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.nOQ) {
                    VideoEasterEggActivity.this.nON.dWH();
                }
            }
        });
        this.nOR.b(getPageContext());
        return this.nOR;
    }
}
