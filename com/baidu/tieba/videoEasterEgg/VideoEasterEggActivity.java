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
/* loaded from: classes7.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private ImageView fgN;
    private com.baidu.tbadk.core.view.a gMs;
    private ImageView kDP;
    private ScaleVideoView kDQ;
    private View kDR;
    private TextView kDS;
    private TextView kDT;
    private com.baidu.tieba.videoEasterEgg.b.a kDU;
    private a kDY;
    private boolean kDZ;
    private int mSkinType = 3;
    private int kDV = 0;
    private boolean kDW = false;
    private boolean kDX = false;
    private Runnable dVL = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.kDU != null) {
                VideoEasterEggActivity.this.kDU.cwZ();
            }
        }
    };
    private MediaPlayer.OnInfoListener kEa = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.tu(false);
                e.gx().removeCallbacks(VideoEasterEggActivity.this.dVL);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.kDU = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.gMs = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        bas();
        initVideoView();
        cQU();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bas() {
        this.fgN = (ImageView) findViewById(R.id.close);
        this.fgN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.kDU != null) {
                    VideoEasterEggActivity.this.kDU.onClose();
                }
            }
        });
        this.kDP = (ImageView) findViewById(R.id.share);
        this.kDP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.kDU != null) {
                    VideoEasterEggActivity.this.kDU.cQV();
                    VideoEasterEggActivity.this.bEF();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).Z("obj_locate", 1));
                }
            }
        });
    }

    private void initVideoView() {
        this.kDQ = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.kDQ.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.kDU != null) {
                    VideoEasterEggActivity.this.kDU.cwZ();
                    return true;
                }
                return true;
            }
        });
        this.kDQ.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.kDZ = true;
                if (VideoEasterEggActivity.this.kDU != null) {
                    VideoEasterEggActivity.this.kDU.cQX();
                }
            }
        });
        this.kDQ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.kDQ.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.kEa);
            }
        });
        this.kDQ.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.tu(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.kDZ = false;
            }
        });
        tu(true);
    }

    private void cQU() {
        this.kDR = findViewById(R.id.error_container);
        this.kDS = (TextView) findViewById(R.id.load_error_text);
        this.kDS.setText(R.string.loading_error);
        this.kDT = (TextView) findViewById(R.id.play_text);
        this.kDT.setText(R.string.continues_play);
        this.kDT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.kDU != null) {
                    VideoEasterEggActivity.this.kDU.cQW();
                }
            }
        });
        this.kDR.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tu(boolean z) {
        if (z) {
            if (this.gMs != null && !this.gMs.isShowing()) {
                this.gMs.setDialogVisiable(true);
            }
            this.kDQ.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_a));
            return;
        }
        if (this.gMs != null) {
            this.gMs.setDialogVisiable(false);
        }
        this.kDQ.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kDU != null) {
            this.kDU.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        bEF();
        if (this.kDU != null) {
            this.kDU.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEF() {
        if (this.kDQ != null && this.kDQ.isPlaying()) {
            this.kDV = this.kDQ.getCurrentPosition();
            this.kDQ.pause();
            this.kDW = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kDU != null) {
            this.kDU.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Kh(String str) {
        if (!aq.isEmpty(str) && !this.kDQ.isPlaying() && !this.kDZ) {
            if (this.kDW) {
                this.kDQ.seekTo(this.kDV);
                this.kDW = false;
            } else {
                this.kDQ.setVideoURI(Uri.parse(str));
                e.gx().postDelayed(this.dVL, 5000L);
            }
            this.kDQ.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Ki(String str) {
        this.kDR.setVisibility(8);
        this.kDW = true;
        this.kDV = 0;
        this.kDZ = false;
        Kh(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void eD(String str, String str2) {
        if (this.kDY == null) {
            this.kDY = eE(str, str2);
        }
        this.kDY.aCp();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Oe() {
        e.gx().removeCallbacks(this.dVL);
        this.kDQ.pause();
        this.gMs.setDialogVisiable(false);
        this.kDR.setVisibility(0);
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
            am.setViewTextColor(this.kDS, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.kDT, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.kDT, R.drawable.continue_play_bg);
            am.setImageResource(this.fgN, R.drawable.icon_frs_luhan_close);
            am.setImageResource(this.kDP, R.drawable.icon_frs_luhan_share);
        }
    }

    private a eE(String str, String str2) {
        this.kDY = new a(this);
        this.kDY.Kf(str2);
        if (aq.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.kDY.sC(str);
        this.kDY.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.kDX = z;
            }
        });
        this.kDY.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.kDU != null) {
                    VideoEasterEggActivity.this.kDU.cQW();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.kDY.dismiss();
            }
        });
        this.kDY.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.kDU != null) {
                    VideoEasterEggActivity.this.kDU.cQV();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).Z("obj_locate", 2));
                }
                VideoEasterEggActivity.this.kDY.dismiss();
            }
        });
        this.kDY.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.kDX) {
                    VideoEasterEggActivity.this.kDU.cQY();
                }
            }
        });
        this.kDY.b(getPageContext());
        return this.kDY;
    }
}
