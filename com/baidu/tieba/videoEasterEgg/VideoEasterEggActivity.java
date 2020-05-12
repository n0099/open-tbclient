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
    private ImageView fPd;
    private com.baidu.tbadk.core.view.a hzR;
    private ImageView lrl;
    private ScaleVideoView lrm;
    private View lrn;
    private TextView lro;
    private TextView lrp;
    private com.baidu.tieba.videoEasterEgg.b.a lrq;
    private a lru;
    private boolean lrv;
    private int mSkinType = 3;
    private int lrr = 0;
    private boolean lrs = false;
    private boolean lrt = false;
    private Runnable lrw = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.lrq != null) {
                VideoEasterEggActivity.this.lrq.cJr();
            }
        }
    };
    private MediaPlayer.OnInfoListener lrx = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.uG(false);
                e.lb().removeCallbacks(VideoEasterEggActivity.this.lrw);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.lrq = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.hzR = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        blD();
        ddJ();
        ddK();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void blD() {
        this.fPd = (ImageView) findViewById(R.id.close);
        this.fPd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.lrq != null) {
                    VideoEasterEggActivity.this.lrq.onClose();
                }
            }
        });
        this.lrl = (ImageView) findViewById(R.id.share);
        this.lrl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.lrq != null) {
                    VideoEasterEggActivity.this.lrq.ddL();
                    VideoEasterEggActivity.this.bQW();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).af("obj_locate", 1));
                }
            }
        });
    }

    private void ddJ() {
        this.lrm = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.lrm.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.lrq != null) {
                    VideoEasterEggActivity.this.lrq.cJr();
                    return true;
                }
                return true;
            }
        });
        this.lrm.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.lrv = true;
                if (VideoEasterEggActivity.this.lrq != null) {
                    VideoEasterEggActivity.this.lrq.ddN();
                }
            }
        });
        this.lrm.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.lrm.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.lrx);
            }
        });
        this.lrm.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.uG(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.lrv = false;
            }
        });
        uG(true);
    }

    private void ddK() {
        this.lrn = findViewById(R.id.error_container);
        this.lro = (TextView) findViewById(R.id.load_error_text);
        this.lro.setText(R.string.loading_error);
        this.lrp = (TextView) findViewById(R.id.play_text);
        this.lrp.setText(R.string.continues_play);
        this.lrp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.lrq != null) {
                    VideoEasterEggActivity.this.lrq.ddM();
                }
            }
        });
        this.lrn.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uG(boolean z) {
        if (z) {
            if (this.hzR != null && !this.hzR.isShowing()) {
                this.hzR.setDialogVisiable(true);
            }
            this.lrm.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_a));
            return;
        }
        if (this.hzR != null) {
            this.hzR.setDialogVisiable(false);
        }
        this.lrm.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lrq != null) {
            this.lrq.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        bQW();
        if (this.lrq != null) {
            this.lrq.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQW() {
        if (this.lrm != null && this.lrm.isPlaying()) {
            this.lrr = this.lrm.getCurrentPosition();
            this.lrm.pause();
            this.lrs = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lrq != null) {
            this.lrq.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Mj(String str) {
        if (!aq.isEmpty(str) && !this.lrm.isPlaying() && !this.lrv) {
            if (this.lrs) {
                this.lrm.seekTo(this.lrr);
                this.lrs = false;
            } else {
                this.lrm.setVideoURI(Uri.parse(str));
                e.lb().postDelayed(this.lrw, 5000L);
            }
            this.lrm.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Mk(String str) {
        this.lrn.setVisibility(8);
        this.lrs = true;
        this.lrr = 0;
        this.lrv = false;
        Mj(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void eZ(String str, String str2) {
        if (this.lru == null) {
            this.lru = fa(str, str2);
        }
        this.lru.aMS();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Yl() {
        e.lb().removeCallbacks(this.lrw);
        this.lrm.pause();
        this.hzR.setDialogVisiable(false);
        this.lrn.setVisibility(0);
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
            am.setViewTextColor(this.lro, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.lrp, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.lrp, R.drawable.continue_play_bg);
            am.setImageResource(this.fPd, R.drawable.icon_frs_luhan_close);
            am.setImageResource(this.lrl, R.drawable.icon_frs_luhan_share);
        }
    }

    private a fa(String str, String str2) {
        this.lru = new a(this);
        this.lru.Mh(str2);
        if (aq.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.lru.ui(str);
        this.lru.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.lrt = z;
            }
        });
        this.lru.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.lrq != null) {
                    VideoEasterEggActivity.this.lrq.ddM();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.lru.dismiss();
            }
        });
        this.lru.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.lrq != null) {
                    VideoEasterEggActivity.this.lrq.ddL();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).af("obj_locate", 2));
                }
                VideoEasterEggActivity.this.lru.dismiss();
            }
        });
        this.lru.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.lrt) {
                    VideoEasterEggActivity.this.lrq.ddO();
                }
            }
        });
        this.lru.b(getPageContext());
        return this.lru;
    }
}
