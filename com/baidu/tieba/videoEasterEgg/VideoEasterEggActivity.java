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
/* loaded from: classes21.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private com.baidu.tbadk.core.view.a iEn;
    private ImageView iZp;
    private ImageView mOa;
    private ScaleVideoView mOb;
    private View mOc;
    private TextView mOd;
    private TextView mOe;
    private com.baidu.tieba.videoEasterEgg.b.a mOf;
    private a mOj;
    private boolean mOk;
    private int mSkinType = 3;
    private int mOg = 0;
    private boolean mOh = false;
    private boolean mOi = false;
    private Runnable mOl = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.mOf != null) {
                VideoEasterEggActivity.this.mOf.dnx();
            }
        }
    };
    private MediaPlayer.OnInfoListener mOm = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.xa(false);
                e.mX().removeCallbacks(VideoEasterEggActivity.this.mOl);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.mOf = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.iEn = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        bvT();
        dIk();
        dIl();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bvT() {
        this.iZp = (ImageView) findViewById(R.id.close);
        this.iZp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.mOf != null) {
                    VideoEasterEggActivity.this.mOf.onClose();
                }
            }
        });
        this.mOa = (ImageView) findViewById(R.id.share);
        this.mOa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.mOf != null) {
                    VideoEasterEggActivity.this.mOf.bqK();
                    VideoEasterEggActivity.this.crW();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).ai("obj_locate", 1));
                }
            }
        });
    }

    private void dIk() {
        this.mOb = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.mOb.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.mOf != null) {
                    VideoEasterEggActivity.this.mOf.dnx();
                    return true;
                }
                return true;
            }
        });
        this.mOb.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.mOk = true;
                if (VideoEasterEggActivity.this.mOf != null) {
                    VideoEasterEggActivity.this.mOf.dIn();
                }
            }
        });
        this.mOb.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.mOb.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.mOm);
            }
        });
        this.mOb.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.xa(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.mOk = false;
            }
        });
        xa(true);
    }

    private void dIl() {
        this.mOc = findViewById(R.id.error_container);
        this.mOd = (TextView) findViewById(R.id.load_error_text);
        this.mOd.setText(R.string.loading_error);
        this.mOe = (TextView) findViewById(R.id.play_text);
        this.mOe.setText(R.string.continues_play);
        this.mOe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.mOf != null) {
                    VideoEasterEggActivity.this.mOf.dIm();
                }
            }
        });
        this.mOc.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xa(boolean z) {
        if (z) {
            if (this.iEn != null && !this.iEn.isShowing()) {
                this.iEn.setDialogVisiable(true);
            }
            this.mOb.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_a));
            return;
        }
        if (this.iEn != null) {
            this.iEn.setDialogVisiable(false);
        }
        this.mOb.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mOf != null) {
            this.mOf.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        crW();
        if (this.mOf != null) {
            this.mOf.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crW() {
        if (this.mOb != null && this.mOb.isPlaying()) {
            this.mOg = this.mOb.getCurrentPosition();
            this.mOb.pause();
            this.mOh = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mOf != null) {
            this.mOf.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void SG(String str) {
        if (!at.isEmpty(str) && !this.mOb.isPlaying() && !this.mOk) {
            if (this.mOh) {
                this.mOb.seekTo(this.mOg);
                this.mOh = false;
            } else {
                this.mOb.setVideoURI(Uri.parse(str));
                e.mX().postDelayed(this.mOl, 5000L);
            }
            this.mOb.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void SH(String str) {
        this.mOc.setVisibility(8);
        this.mOh = true;
        this.mOg = 0;
        this.mOk = false;
        SG(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void gq(String str, String str2) {
        if (this.mOj == null) {
            this.mOj = gr(str, str2);
        }
        this.mOj.bia();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void akx() {
        e.mX().removeCallbacks(this.mOl);
        this.mOb.pause();
        this.iEn.setDialogVisiable(false);
        this.mOc.setVisibility(0);
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
            ap.setViewTextColor(this.mOd, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.mOe, (int) R.color.cp_cont_a);
            ap.setBackgroundResource(this.mOe, R.drawable.continue_play_bg);
            ap.setImageResource(this.iZp, R.drawable.icon_frs_luhan_close);
            ap.setImageResource(this.mOa, R.drawable.icon_frs_luhan_share);
        }
    }

    private a gr(String str, String str2) {
        this.mOj = new a(this);
        this.mOj.SE(str2);
        if (at.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.mOj.zV(str);
        this.mOj.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.mOi = z;
            }
        });
        this.mOj.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.mOf != null) {
                    VideoEasterEggActivity.this.mOf.dIm();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.mOj.dismiss();
            }
        });
        this.mOj.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.mOf != null) {
                    VideoEasterEggActivity.this.mOf.bqK();
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).ai("obj_locate", 2));
                }
                VideoEasterEggActivity.this.mOj.dismiss();
            }
        });
        this.mOj.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.mOi) {
                    VideoEasterEggActivity.this.mOf.dIo();
                }
            }
        });
        this.mOj.b(getPageContext());
        return this.mOj;
    }
}
