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
    private ImageView meS;
    private ScaleVideoView meT;
    private View meU;
    private TextView meV;
    private TextView meW;
    private com.baidu.tieba.videoEasterEgg.b.a meX;
    private a mfb;
    private boolean mfc;
    private int mSkinType = 3;
    private int meY = 0;
    private boolean meZ = false;
    private boolean mfa = false;
    private Runnable mfd = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.meX != null) {
                VideoEasterEggActivity.this.meX.cUY();
            }
        }
    };
    private MediaPlayer.OnInfoListener mfe = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.vw(false);
                e.lt().removeCallbacks(VideoEasterEggActivity.this.mfd);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.meX = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new ao(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.icD = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        biq();
        dpC();
        dpD();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void biq() {
        this.gqS = (ImageView) findViewById(R.id.close);
        this.gqS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.meX != null) {
                    VideoEasterEggActivity.this.meX.onClose();
                }
            }
        });
        this.meS = (ImageView) findViewById(R.id.share);
        this.meS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.meX != null) {
                    VideoEasterEggActivity.this.meX.dpE();
                    VideoEasterEggActivity.this.caG();
                    TiebaStatic.log(new ao(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).ag("obj_locate", 1));
                }
            }
        });
    }

    private void dpC() {
        this.meT = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.meT.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.meX != null) {
                    VideoEasterEggActivity.this.meX.cUY();
                    return true;
                }
                return true;
            }
        });
        this.meT.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.mfc = true;
                if (VideoEasterEggActivity.this.meX != null) {
                    VideoEasterEggActivity.this.meX.dpG();
                }
            }
        });
        this.meT.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.meT.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.mfe);
            }
        });
        this.meT.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.vw(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.mfc = false;
            }
        });
        vw(true);
    }

    private void dpD() {
        this.meU = findViewById(R.id.error_container);
        this.meV = (TextView) findViewById(R.id.load_error_text);
        this.meV.setText(R.string.loading_error);
        this.meW = (TextView) findViewById(R.id.play_text);
        this.meW.setText(R.string.continues_play);
        this.meW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.meX != null) {
                    VideoEasterEggActivity.this.meX.dpF();
                }
            }
        });
        this.meU.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vw(boolean z) {
        if (z) {
            if (this.icD != null && !this.icD.isShowing()) {
                this.icD.setDialogVisiable(true);
            }
            this.meT.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_a));
            return;
        }
        if (this.icD != null) {
            this.icD.setDialogVisiable(false);
        }
        this.meT.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.meX != null) {
            this.meX.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        caG();
        if (this.meX != null) {
            this.meX.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caG() {
        if (this.meT != null && this.meT.isPlaying()) {
            this.meY = this.meT.getCurrentPosition();
            this.meT.pause();
            this.meZ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.meX != null) {
            this.meX.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void OA(String str) {
        if (!ar.isEmpty(str) && !this.meT.isPlaying() && !this.mfc) {
            if (this.meZ) {
                this.meT.seekTo(this.meY);
                this.meZ = false;
            } else {
                this.meT.setVideoURI(Uri.parse(str));
                e.lt().postDelayed(this.mfd, 5000L);
            }
            this.meT.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void OB(String str) {
        this.meU.setVisibility(8);
        this.meZ = true;
        this.meY = 0;
        this.mfc = false;
        OA(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void fK(String str, String str2) {
        if (this.mfb == null) {
            this.mfb = fL(str, str2);
        }
        this.mfb.aUN();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void acn() {
        e.lt().removeCallbacks(this.mfd);
        this.meT.pause();
        this.icD.setDialogVisiable(false);
        this.meU.setVisibility(0);
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
            an.setViewTextColor(this.meV, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.meW, (int) R.color.cp_cont_a);
            an.setBackgroundResource(this.meW, R.drawable.continue_play_bg);
            an.setImageResource(this.gqS, R.drawable.icon_frs_luhan_close);
            an.setImageResource(this.meS, R.drawable.icon_frs_luhan_share);
        }
    }

    private a fL(String str, String str2) {
        this.mfb = new a(this);
        this.mfb.Oy(str2);
        if (ar.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.mfb.we(str);
        this.mfb.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.mfa = z;
            }
        });
        this.mfb.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.meX != null) {
                    VideoEasterEggActivity.this.meX.dpF();
                    TiebaStatic.log(new ao(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.mfb.dismiss();
            }
        });
        this.mfb.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.meX != null) {
                    VideoEasterEggActivity.this.meX.dpE();
                    TiebaStatic.log(new ao(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).ag("obj_locate", 2));
                }
                VideoEasterEggActivity.this.mfb.dismiss();
            }
        });
        this.mfb.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.mfa) {
                    VideoEasterEggActivity.this.meX.dpH();
                }
            }
        });
        this.mfb.b(getPageContext());
        return this.mfb;
    }
}
