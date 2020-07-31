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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private ImageView gwo;
    private com.baidu.tbadk.core.view.a iiF;
    private ImageView mmi;
    private ScaleVideoView mmj;
    private View mmk;
    private TextView mml;
    private TextView mmm;
    private com.baidu.tieba.videoEasterEgg.b.a mmn;
    private a mmr;
    private boolean mms;
    private int mSkinType = 3;
    private int mmo = 0;
    private boolean mmp = false;
    private boolean mmq = false;
    private Runnable mmt = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.mmn != null) {
                VideoEasterEggActivity.this.mmn.cYL();
            }
        }
    };
    private MediaPlayer.OnInfoListener mmu = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.wa(false);
                e.lt().removeCallbacks(VideoEasterEggActivity.this.mmt);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.mmn = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new ap(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.iiF = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        bmb();
        dsL();
        dsM();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bmb() {
        this.gwo = (ImageView) findViewById(R.id.close);
        this.gwo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.mmn != null) {
                    VideoEasterEggActivity.this.mmn.onClose();
                }
            }
        });
        this.mmi = (ImageView) findViewById(R.id.share);
        this.mmi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.mmn != null) {
                    VideoEasterEggActivity.this.mmn.bhd();
                    VideoEasterEggActivity.this.cee();
                    TiebaStatic.log(new ap(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).ah("obj_locate", 1));
                }
            }
        });
    }

    private void dsL() {
        this.mmj = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.mmj.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.mmn != null) {
                    VideoEasterEggActivity.this.mmn.cYL();
                    return true;
                }
                return true;
            }
        });
        this.mmj.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.mms = true;
                if (VideoEasterEggActivity.this.mmn != null) {
                    VideoEasterEggActivity.this.mmn.dsO();
                }
            }
        });
        this.mmj.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.mmj.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.mmu);
            }
        });
        this.mmj.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.wa(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.mms = false;
            }
        });
        wa(true);
    }

    private void dsM() {
        this.mmk = findViewById(R.id.error_container);
        this.mml = (TextView) findViewById(R.id.load_error_text);
        this.mml.setText(R.string.loading_error);
        this.mmm = (TextView) findViewById(R.id.play_text);
        this.mmm.setText(R.string.continues_play);
        this.mmm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.mmn != null) {
                    VideoEasterEggActivity.this.mmn.dsN();
                }
            }
        });
        this.mmk.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa(boolean z) {
        if (z) {
            if (this.iiF != null && !this.iiF.isShowing()) {
                this.iiF.setDialogVisiable(true);
            }
            this.mmj.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_a));
            return;
        }
        if (this.iiF != null) {
            this.iiF.setDialogVisiable(false);
        }
        this.mmj.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mmn != null) {
            this.mmn.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        cee();
        if (this.mmn != null) {
            this.mmn.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cee() {
        if (this.mmj != null && this.mmj.isPlaying()) {
            this.mmo = this.mmj.getCurrentPosition();
            this.mmj.pause();
            this.mmp = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mmn != null) {
            this.mmn.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Pi(String str) {
        if (!as.isEmpty(str) && !this.mmj.isPlaying() && !this.mms) {
            if (this.mmp) {
                this.mmj.seekTo(this.mmo);
                this.mmp = false;
            } else {
                this.mmj.setVideoURI(Uri.parse(str));
                e.lt().postDelayed(this.mmt, 5000L);
            }
            this.mmj.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Pj(String str) {
        this.mmk.setVisibility(8);
        this.mmp = true;
        this.mmo = 0;
        this.mms = false;
        Pi(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void fM(String str, String str2) {
        if (this.mmr == null) {
            this.mmr = fN(str, str2);
        }
        this.mmr.aYL();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void ads() {
        e.lt().removeCallbacks(this.mmt);
        this.mmj.pause();
        this.iiF.setDialogVisiable(false);
        this.mmk.setVisibility(0);
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
            ao.setViewTextColor(this.mml, R.color.cp_cont_a);
            ao.setViewTextColor(this.mmm, R.color.cp_cont_a);
            ao.setBackgroundResource(this.mmm, R.drawable.continue_play_bg);
            ao.setImageResource(this.gwo, R.drawable.icon_frs_luhan_close);
            ao.setImageResource(this.mmi, R.drawable.icon_frs_luhan_share);
        }
    }

    private a fN(String str, String str2) {
        this.mmr = new a(this);
        this.mmr.Pg(str2);
        if (as.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.mmr.xl(str);
        this.mmr.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.mmq = z;
            }
        });
        this.mmr.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.mmn != null) {
                    VideoEasterEggActivity.this.mmn.dsN();
                    TiebaStatic.log(new ap(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.mmr.dismiss();
            }
        });
        this.mmr.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.mmn != null) {
                    VideoEasterEggActivity.this.mmn.bhd();
                    TiebaStatic.log(new ap(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).ah("obj_locate", 2));
                }
                VideoEasterEggActivity.this.mmr.dismiss();
            }
        });
        this.mmr.b(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.mmq) {
                    VideoEasterEggActivity.this.mmn.dsP();
                }
            }
        });
        this.mmr.b(getPageContext());
        return this.mmr;
    }
}
