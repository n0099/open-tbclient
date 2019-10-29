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
import com.baidu.adp.lib.g.e;
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
/* loaded from: classes4.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private com.baidu.tbadk.core.view.b fVw;
    private ImageView gnh;
    private boolean jHA;
    private ImageView jHq;
    private ScaleVideoView jHr;
    private View jHs;
    private TextView jHt;
    private TextView jHu;
    private com.baidu.tieba.videoEasterEgg.b.a jHv;
    private a jHz;
    private int mSkinType = 3;
    private int jHw = 0;
    private boolean jHx = false;
    private boolean jHy = false;
    private Runnable diH = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.jHv != null) {
                VideoEasterEggActivity.this.jHv.aHz();
            }
        }
    };
    private MediaPlayer.OnInfoListener jHB = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.rC(false);
                e.fZ().removeCallbacks(VideoEasterEggActivity.this.diH);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.jHv = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.fVw = new com.baidu.tbadk.core.view.b(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        aJx();
        cwa();
        cwb();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aJx() {
        this.gnh = (ImageView) findViewById(R.id.close);
        this.gnh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jHv != null) {
                    VideoEasterEggActivity.this.jHv.onClose();
                }
            }
        });
        this.jHq = (ImageView) findViewById(R.id.share);
        this.jHq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jHv != null) {
                    VideoEasterEggActivity.this.jHv.cwc();
                    VideoEasterEggActivity.this.bmi();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).O("obj_locate", 1));
                }
            }
        });
    }

    private void cwa() {
        this.jHr = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.jHr.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.jHv != null) {
                    VideoEasterEggActivity.this.jHv.aHz();
                    return true;
                }
                return true;
            }
        });
        this.jHr.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.jHA = true;
                if (VideoEasterEggActivity.this.jHv != null) {
                    VideoEasterEggActivity.this.jHv.cwe();
                }
            }
        });
        this.jHr.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.jHr.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.jHB);
            }
        });
        this.jHr.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.rC(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.jHA = false;
            }
        });
        rC(true);
    }

    private void cwb() {
        this.jHs = findViewById(R.id.error_container);
        this.jHt = (TextView) findViewById(R.id.load_error_text);
        this.jHt.setText(R.string.loading_error);
        this.jHu = (TextView) findViewById(R.id.play_text);
        this.jHu.setText(R.string.continues_play);
        this.jHu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.jHv != null) {
                    VideoEasterEggActivity.this.jHv.cwd();
                }
            }
        });
        this.jHs.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rC(boolean z) {
        if (z) {
            if (this.fVw != null && !this.fVw.isShowing()) {
                this.fVw.setDialogVisiable(true);
            }
            this.jHr.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_a));
            return;
        }
        if (this.fVw != null) {
            this.fVw.setDialogVisiable(false);
        }
        this.jHr.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jHv != null) {
            this.jHv.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        bmi();
        if (this.jHv != null) {
            this.jHv.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmi() {
        if (this.jHr != null && this.jHr.isPlaying()) {
            this.jHw = this.jHr.getCurrentPosition();
            this.jHr.pause();
            this.jHx = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jHv != null) {
            this.jHv.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Fl(String str) {
        if (!aq.isEmpty(str) && !this.jHr.isPlaying() && !this.jHA) {
            if (this.jHx) {
                this.jHr.seekTo(this.jHw);
                this.jHx = false;
            } else {
                this.jHr.setVideoURI(Uri.parse(str));
                e.fZ().postDelayed(this.diH, 5000L);
            }
            this.jHr.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void Fm(String str) {
        this.jHs.setVisibility(8);
        this.jHx = true;
        this.jHw = 0;
        this.jHA = false;
        Fl(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void ei(String str, String str2) {
        if (this.jHz == null) {
            this.jHz = ej(str, str2);
        }
        this.jHz.akO();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void GL() {
        e.fZ().removeCallbacks(this.diH);
        this.jHr.pause();
        this.fVw.setDialogVisiable(false);
        this.jHs.setVisibility(0);
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
            am.setViewTextColor(this.jHt, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.jHu, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.jHu, R.drawable.continue_play_bg);
            am.setImageResource(this.gnh, R.drawable.icon_frs_luhan_close);
            am.setImageResource(this.jHq, R.drawable.icon_frs_luhan_share);
        }
    }

    private a ej(String str, String str2) {
        this.jHz = new a(this);
        this.jHz.Fj(str2);
        if (aq.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.jHz.nn(str);
        this.jHz.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.jHy = z;
            }
        });
        this.jHz.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.jHv != null) {
                    VideoEasterEggActivity.this.jHv.cwd();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.jHz.dismiss();
            }
        });
        this.jHz.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.jHv != null) {
                    VideoEasterEggActivity.this.jHv.cwc();
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).O("obj_locate", 2));
                }
                VideoEasterEggActivity.this.jHz.dismiss();
            }
        });
        this.jHz.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.jHy) {
                    VideoEasterEggActivity.this.jHv.cwf();
                }
            }
        });
        this.jHz.b(getPageContext());
        return this.jHz;
    }
}
