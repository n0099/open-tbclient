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
    private ImageView gdY;
    private com.baidu.tbadk.core.view.a hPr;
    private ImageView lKY;
    private ScaleVideoView lKZ;
    private View lLa;
    private TextView lLb;
    private TextView lLc;
    private com.baidu.tieba.videoEasterEgg.b.a lLd;
    private a lLh;
    private boolean lLi;
    private int mSkinType = 3;
    private int lLe = 0;
    private boolean lLf = false;
    private boolean lLg = false;
    private Runnable lLj = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.lLd != null) {
                VideoEasterEggActivity.this.lLd.cQG();
            }
        }
    };
    private MediaPlayer.OnInfoListener lLk = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.ve(false);
                e.ld().removeCallbacks(VideoEasterEggActivity.this.lLj);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.lLd = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.hPr = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        brd();
        dlm();
        dln();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void brd() {
        this.gdY = (ImageView) findViewById(R.id.close);
        this.gdY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.lLd != null) {
                    VideoEasterEggActivity.this.lLd.onClose();
                }
            }
        });
        this.lKY = (ImageView) findViewById(R.id.share);
        this.lKY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.lLd != null) {
                    VideoEasterEggActivity.this.lLd.dlo();
                    VideoEasterEggActivity.this.bXu();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).ag("obj_locate", 1));
                }
            }
        });
    }

    private void dlm() {
        this.lKZ = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.lKZ.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.lLd != null) {
                    VideoEasterEggActivity.this.lLd.cQG();
                    return true;
                }
                return true;
            }
        });
        this.lKZ.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.lLi = true;
                if (VideoEasterEggActivity.this.lLd != null) {
                    VideoEasterEggActivity.this.lLd.dlq();
                }
            }
        });
        this.lKZ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.lKZ.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.lLk);
            }
        });
        this.lKZ.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.ve(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.lLi = false;
            }
        });
        ve(true);
    }

    private void dln() {
        this.lLa = findViewById(R.id.error_container);
        this.lLb = (TextView) findViewById(R.id.load_error_text);
        this.lLb.setText(R.string.loading_error);
        this.lLc = (TextView) findViewById(R.id.play_text);
        this.lLc.setText(R.string.continues_play);
        this.lLc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.lLd != null) {
                    VideoEasterEggActivity.this.lLd.dlp();
                }
            }
        });
        this.lLa.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve(boolean z) {
        if (z) {
            if (this.hPr != null && !this.hPr.isShowing()) {
                this.hPr.setDialogVisiable(true);
            }
            this.lKZ.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_a));
            return;
        }
        if (this.hPr != null) {
            this.hPr.setDialogVisiable(false);
        }
        this.lKZ.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lLd != null) {
            this.lLd.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        bXu();
        if (this.lLd != null) {
            this.lLd.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXu() {
        if (this.lKZ != null && this.lKZ.isPlaying()) {
            this.lLe = this.lKZ.getCurrentPosition();
            this.lKZ.pause();
            this.lLf = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lLd != null) {
            this.lLd.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void NX(String str) {
        if (!aq.isEmpty(str) && !this.lKZ.isPlaying() && !this.lLi) {
            if (this.lLf) {
                this.lKZ.seekTo(this.lLe);
                this.lLf = false;
            } else {
                this.lKZ.setVideoURI(Uri.parse(str));
                e.ld().postDelayed(this.lLj, 5000L);
            }
            this.lKZ.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void NY(String str) {
        this.lLa.setVisibility(8);
        this.lLf = true;
        this.lLe = 0;
        this.lLi = false;
        NX(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void fA(String str, String str2) {
        if (this.lLh == null) {
            this.lLh = fB(str, str2);
        }
        this.lLh.aST();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void abh() {
        e.ld().removeCallbacks(this.lLj);
        this.lKZ.pause();
        this.hPr.setDialogVisiable(false);
        this.lLa.setVisibility(0);
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
            am.setViewTextColor(this.lLb, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.lLc, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.lLc, R.drawable.continue_play_bg);
            am.setImageResource(this.gdY, R.drawable.icon_frs_luhan_close);
            am.setImageResource(this.lKY, R.drawable.icon_frs_luhan_share);
        }
    }

    private a fB(String str, String str2) {
        this.lLh = new a(this);
        this.lLh.NV(str2);
        if (aq.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.lLh.vO(str);
        this.lLh.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.lLg = z;
            }
        });
        this.lLh.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.lLd != null) {
                    VideoEasterEggActivity.this.lLd.dlp();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.lLh.dismiss();
            }
        });
        this.lLh.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.lLd != null) {
                    VideoEasterEggActivity.this.lLd.dlo();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).ag("obj_locate", 2));
                }
                VideoEasterEggActivity.this.lLh.dismiss();
            }
        });
        this.lLh.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.lLg) {
                    VideoEasterEggActivity.this.lLd.dlr();
                }
            }
        });
        this.lLh.b(getPageContext());
        return this.lLh;
    }
}
