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
/* loaded from: classes16.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private ImageView gIr;
    private com.baidu.tbadk.core.view.a iwR;
    private ImageView mEp;
    private ScaleVideoView mEq;
    private View mEr;
    private TextView mEs;
    private TextView mEt;
    private com.baidu.tieba.videoEasterEgg.b.a mEu;
    private a mEy;
    private boolean mEz;
    private int mSkinType = 3;
    private int mEv = 0;
    private boolean mEw = false;
    private boolean mEx = false;
    private Runnable mEA = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.mEu != null) {
                VideoEasterEggActivity.this.mEu.djR();
            }
        }
    };
    private MediaPlayer.OnInfoListener mEB = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.wR(false);
                e.mS().removeCallbacks(VideoEasterEggActivity.this.mEA);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.mEu = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.iwR = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        buP();
        dEq();
        dEr();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void buP() {
        this.gIr = (ImageView) findViewById(R.id.close);
        this.gIr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.mEu != null) {
                    VideoEasterEggActivity.this.mEu.onClose();
                }
            }
        });
        this.mEp = (ImageView) findViewById(R.id.share);
        this.mEp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.mEu != null) {
                    VideoEasterEggActivity.this.mEu.bpQ();
                    VideoEasterEggActivity.this.coJ();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).ai("obj_locate", 1));
                }
            }
        });
    }

    private void dEq() {
        this.mEq = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.mEq.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.mEu != null) {
                    VideoEasterEggActivity.this.mEu.djR();
                    return true;
                }
                return true;
            }
        });
        this.mEq.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.mEz = true;
                if (VideoEasterEggActivity.this.mEu != null) {
                    VideoEasterEggActivity.this.mEu.dEt();
                }
            }
        });
        this.mEq.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.mEq.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.mEB);
            }
        });
        this.mEq.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.wR(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.mEz = false;
            }
        });
        wR(true);
    }

    private void dEr() {
        this.mEr = findViewById(R.id.error_container);
        this.mEs = (TextView) findViewById(R.id.load_error_text);
        this.mEs.setText(R.string.loading_error);
        this.mEt = (TextView) findViewById(R.id.play_text);
        this.mEt.setText(R.string.continues_play);
        this.mEt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.mEu != null) {
                    VideoEasterEggActivity.this.mEu.dEs();
                }
            }
        });
        this.mEr.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wR(boolean z) {
        if (z) {
            if (this.iwR != null && !this.iwR.isShowing()) {
                this.iwR.setDialogVisiable(true);
            }
            this.mEq.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_a));
            return;
        }
        if (this.iwR != null) {
            this.iwR.setDialogVisiable(false);
        }
        this.mEq.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mEu != null) {
            this.mEu.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        coJ();
        if (this.mEu != null) {
            this.mEu.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coJ() {
        if (this.mEq != null && this.mEq.isPlaying()) {
            this.mEv = this.mEq.getCurrentPosition();
            this.mEq.pause();
            this.mEw = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mEu != null) {
            this.mEu.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Sg(String str) {
        if (!at.isEmpty(str) && !this.mEq.isPlaying() && !this.mEz) {
            if (this.mEw) {
                this.mEq.seekTo(this.mEv);
                this.mEw = false;
            } else {
                this.mEq.setVideoURI(Uri.parse(str));
                e.mS().postDelayed(this.mEA, 5000L);
            }
            this.mEq.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Sh(String str) {
        this.mEr.setVisibility(8);
        this.mEw = true;
        this.mEv = 0;
        this.mEz = false;
        Sg(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void ge(String str, String str2) {
        if (this.mEy == null) {
            this.mEy = gf(str, str2);
        }
        this.mEy.bhg();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void ajN() {
        e.mS().removeCallbacks(this.mEA);
        this.mEq.pause();
        this.iwR.setDialogVisiable(false);
        this.mEr.setVisibility(0);
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
            ap.setViewTextColor(this.mEs, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.mEt, (int) R.color.cp_cont_a);
            ap.setBackgroundResource(this.mEt, R.drawable.continue_play_bg);
            ap.setImageResource(this.gIr, R.drawable.icon_frs_luhan_close);
            ap.setImageResource(this.mEp, R.drawable.icon_frs_luhan_share);
        }
    }

    private a gf(String str, String str2) {
        this.mEy = new a(this);
        this.mEy.Se(str2);
        if (at.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.mEy.zA(str);
        this.mEy.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.mEx = z;
            }
        });
        this.mEy.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.mEu != null) {
                    VideoEasterEggActivity.this.mEu.dEs();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.mEy.dismiss();
            }
        });
        this.mEy.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.mEu != null) {
                    VideoEasterEggActivity.this.mEu.bpQ();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).ai("obj_locate", 2));
                }
                VideoEasterEggActivity.this.mEy.dismiss();
            }
        });
        this.mEy.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.mEx) {
                    VideoEasterEggActivity.this.mEu.dEu();
                }
            }
        });
        this.mEy.b(getPageContext());
        return this.mEy;
    }
}
