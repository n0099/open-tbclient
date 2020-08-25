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
    private ImageView gIn;
    private com.baidu.tbadk.core.view.a iwL;
    private ImageView mDX;
    private ScaleVideoView mDY;
    private View mDZ;
    private TextView mEa;
    private TextView mEb;
    private com.baidu.tieba.videoEasterEgg.b.a mEc;
    private a mEg;
    private boolean mEh;
    private int mSkinType = 3;
    private int mEd = 0;
    private boolean mEe = false;
    private boolean mEf = false;
    private Runnable mEi = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.mEc != null) {
                VideoEasterEggActivity.this.mEc.djO();
            }
        }
    };
    private MediaPlayer.OnInfoListener mEj = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.wP(false);
                e.mS().removeCallbacks(VideoEasterEggActivity.this.mEi);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.mEc = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.iwL = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        buO();
        dEh();
        dEi();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void buO() {
        this.gIn = (ImageView) findViewById(R.id.close);
        this.gIn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.mEc != null) {
                    VideoEasterEggActivity.this.mEc.onClose();
                }
            }
        });
        this.mDX = (ImageView) findViewById(R.id.share);
        this.mDX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.mEc != null) {
                    VideoEasterEggActivity.this.mEc.bpP();
                    VideoEasterEggActivity.this.coI();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).ai("obj_locate", 1));
                }
            }
        });
    }

    private void dEh() {
        this.mDY = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.mDY.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.mEc != null) {
                    VideoEasterEggActivity.this.mEc.djO();
                    return true;
                }
                return true;
            }
        });
        this.mDY.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.mEh = true;
                if (VideoEasterEggActivity.this.mEc != null) {
                    VideoEasterEggActivity.this.mEc.dEk();
                }
            }
        });
        this.mDY.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.mDY.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.mEj);
            }
        });
        this.mDY.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.wP(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.mEh = false;
            }
        });
        wP(true);
    }

    private void dEi() {
        this.mDZ = findViewById(R.id.error_container);
        this.mEa = (TextView) findViewById(R.id.load_error_text);
        this.mEa.setText(R.string.loading_error);
        this.mEb = (TextView) findViewById(R.id.play_text);
        this.mEb.setText(R.string.continues_play);
        this.mEb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.mEc != null) {
                    VideoEasterEggActivity.this.mEc.dEj();
                }
            }
        });
        this.mDZ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wP(boolean z) {
        if (z) {
            if (this.iwL != null && !this.iwL.isShowing()) {
                this.iwL.setDialogVisiable(true);
            }
            this.mDY.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_a));
            return;
        }
        if (this.iwL != null) {
            this.iwL.setDialogVisiable(false);
        }
        this.mDY.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mEc != null) {
            this.mEc.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        coI();
        if (this.mEc != null) {
            this.mEc.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coI() {
        if (this.mDY != null && this.mDY.isPlaying()) {
            this.mEd = this.mDY.getCurrentPosition();
            this.mDY.pause();
            this.mEe = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mEc != null) {
            this.mEc.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Sg(String str) {
        if (!at.isEmpty(str) && !this.mDY.isPlaying() && !this.mEh) {
            if (this.mEe) {
                this.mDY.seekTo(this.mEd);
                this.mEe = false;
            } else {
                this.mDY.setVideoURI(Uri.parse(str));
                e.mS().postDelayed(this.mEi, 5000L);
            }
            this.mDY.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Sh(String str) {
        this.mDZ.setVisibility(8);
        this.mEe = true;
        this.mEd = 0;
        this.mEh = false;
        Sg(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void gd(String str, String str2) {
        if (this.mEg == null) {
            this.mEg = ge(str, str2);
        }
        this.mEg.bhg();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void ajN() {
        e.mS().removeCallbacks(this.mEi);
        this.mDY.pause();
        this.iwL.setDialogVisiable(false);
        this.mDZ.setVisibility(0);
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
            ap.setViewTextColor(this.mEa, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.mEb, (int) R.color.cp_cont_a);
            ap.setBackgroundResource(this.mEb, R.drawable.continue_play_bg);
            ap.setImageResource(this.gIn, R.drawable.icon_frs_luhan_close);
            ap.setImageResource(this.mDX, R.drawable.icon_frs_luhan_share);
        }
    }

    private a ge(String str, String str2) {
        this.mEg = new a(this);
        this.mEg.Se(str2);
        if (at.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.mEg.zz(str);
        this.mEg.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.mEf = z;
            }
        });
        this.mEg.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.mEc != null) {
                    VideoEasterEggActivity.this.mEc.dEj();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.mEg.dismiss();
            }
        });
        this.mEg.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.mEc != null) {
                    VideoEasterEggActivity.this.mEc.bpP();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).ai("obj_locate", 2));
                }
                VideoEasterEggActivity.this.mEg.dismiss();
            }
        });
        this.mEg.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.mEf) {
                    VideoEasterEggActivity.this.mEc.dEl();
                }
            }
        });
        this.mEg.b(getPageContext());
        return this.mEg;
    }
}
