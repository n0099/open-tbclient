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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private ImageView gqS;
    private com.baidu.tbadk.core.view.a icD;
    private ImageView meP;
    private ScaleVideoView meQ;
    private View meR;
    private TextView meS;
    private TextView meT;
    private com.baidu.tieba.videoEasterEgg.b.a meU;
    private a meY;
    private boolean meZ;
    private int mSkinType = 3;
    private int meV = 0;
    private boolean meW = false;
    private boolean meX = false;
    private Runnable mfa = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.meU != null) {
                VideoEasterEggActivity.this.meU.cUX();
            }
        }
    };
    private MediaPlayer.OnInfoListener mfb = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.vw(false);
                e.lt().removeCallbacks(VideoEasterEggActivity.this.mfa);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.meU = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new ao(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.icD = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        biq();
        dpy();
        dpz();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void biq() {
        this.gqS = (ImageView) findViewById(R.id.close);
        this.gqS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.meU != null) {
                    VideoEasterEggActivity.this.meU.onClose();
                }
            }
        });
        this.meP = (ImageView) findViewById(R.id.share);
        this.meP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.meU != null) {
                    VideoEasterEggActivity.this.meU.dpA();
                    VideoEasterEggActivity.this.caF();
                    TiebaStatic.log(new ao(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).ag("obj_locate", 1));
                }
            }
        });
    }

    private void dpy() {
        this.meQ = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.meQ.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.meU != null) {
                    VideoEasterEggActivity.this.meU.cUX();
                    return true;
                }
                return true;
            }
        });
        this.meQ.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.meZ = true;
                if (VideoEasterEggActivity.this.meU != null) {
                    VideoEasterEggActivity.this.meU.dpC();
                }
            }
        });
        this.meQ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.meQ.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.mfb);
            }
        });
        this.meQ.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.vw(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.meZ = false;
            }
        });
        vw(true);
    }

    private void dpz() {
        this.meR = findViewById(R.id.error_container);
        this.meS = (TextView) findViewById(R.id.load_error_text);
        this.meS.setText(R.string.loading_error);
        this.meT = (TextView) findViewById(R.id.play_text);
        this.meT.setText(R.string.continues_play);
        this.meT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.meU != null) {
                    VideoEasterEggActivity.this.meU.dpB();
                }
            }
        });
        this.meR.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vw(boolean z) {
        if (z) {
            if (this.icD != null && !this.icD.isShowing()) {
                this.icD.setDialogVisiable(true);
            }
            this.meQ.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_a));
            return;
        }
        if (this.icD != null) {
            this.icD.setDialogVisiable(false);
        }
        this.meQ.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.meU != null) {
            this.meU.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        caF();
        if (this.meU != null) {
            this.meU.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caF() {
        if (this.meQ != null && this.meQ.isPlaying()) {
            this.meV = this.meQ.getCurrentPosition();
            this.meQ.pause();
            this.meW = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.meU != null) {
            this.meU.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Oz(String str) {
        if (!ar.isEmpty(str) && !this.meQ.isPlaying() && !this.meZ) {
            if (this.meW) {
                this.meQ.seekTo(this.meV);
                this.meW = false;
            } else {
                this.meQ.setVideoURI(Uri.parse(str));
                e.lt().postDelayed(this.mfa, 5000L);
            }
            this.meQ.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void OA(String str) {
        this.meR.setVisibility(8);
        this.meW = true;
        this.meV = 0;
        this.meZ = false;
        Oz(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void fK(String str, String str2) {
        if (this.meY == null) {
            this.meY = fL(str, str2);
        }
        this.meY.aUN();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void acn() {
        e.lt().removeCallbacks(this.mfa);
        this.meQ.pause();
        this.icD.setDialogVisiable(false);
        this.meR.setVisibility(0);
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
            an.setViewTextColor(this.meS, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.meT, (int) R.color.cp_cont_a);
            an.setBackgroundResource(this.meT, R.drawable.continue_play_bg);
            an.setImageResource(this.gqS, R.drawable.icon_frs_luhan_close);
            an.setImageResource(this.meP, R.drawable.icon_frs_luhan_share);
        }
    }

    private a fL(String str, String str2) {
        this.meY = new a(this);
        this.meY.Ox(str2);
        if (ar.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.meY.we(str);
        this.meY.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.meX = z;
            }
        });
        this.meY.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.meU != null) {
                    VideoEasterEggActivity.this.meU.dpB();
                    TiebaStatic.log(new ao(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.meY.dismiss();
            }
        });
        this.meY.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.meU != null) {
                    VideoEasterEggActivity.this.meU.dpA();
                    TiebaStatic.log(new ao(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).ag("obj_locate", 2));
                }
                VideoEasterEggActivity.this.meY.dismiss();
            }
        });
        this.meY.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.meX) {
                    VideoEasterEggActivity.this.meU.dpD();
                }
            }
        });
        this.meY.b(getPageContext());
        return this.meY;
    }
}
