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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private ImageView ixO;
    private com.baidu.tbadk.core.view.a jNx;
    private ImageView nUk;
    private ScaleVideoView nUl;
    private View nUm;
    private TextView nUn;
    private TextView nUo;
    private com.baidu.tieba.videoEasterEgg.b.a nUp;
    private a nUt;
    private boolean nUu;
    private int mSkinType = 3;
    private int nUq = 0;
    private boolean nUr = false;
    private boolean nUs = false;
    private Runnable nUv = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.nUp != null) {
                VideoEasterEggActivity.this.nUp.cMO();
            }
        }
    };
    private MediaPlayer.OnInfoListener nUw = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.zi(false);
                e.mA().removeCallbacks(VideoEasterEggActivity.this.nUv);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.nUp = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new ar(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.jNx = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        bEL();
        dVf();
        dVg();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bEL() {
        this.ixO = (ImageView) findViewById(R.id.close);
        this.ixO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nUp != null) {
                    VideoEasterEggActivity.this.nUp.onClose();
                }
            }
        });
        this.nUk = (ImageView) findViewById(R.id.share);
        this.nUk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nUp != null) {
                    VideoEasterEggActivity.this.nUp.daw();
                    VideoEasterEggActivity.this.pauseVideo();
                    TiebaStatic.log(new ar(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).ap("obj_locate", 1));
                }
            }
        });
    }

    private void dVf() {
        this.nUl = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.nUl.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.nUp != null) {
                    VideoEasterEggActivity.this.nUp.cMO();
                    return true;
                }
                return true;
            }
        });
        this.nUl.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.nUu = true;
                if (VideoEasterEggActivity.this.nUp != null) {
                    VideoEasterEggActivity.this.nUp.dVi();
                }
            }
        });
        this.nUl.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.nUl.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.nUw);
            }
        });
        this.nUl.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.zi(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.nUu = false;
            }
        });
        zi(true);
    }

    private void dVg() {
        this.nUm = findViewById(R.id.error_container);
        this.nUn = (TextView) findViewById(R.id.load_error_text);
        this.nUn.setText(R.string.loading_error);
        this.nUo = (TextView) findViewById(R.id.play_text);
        this.nUo.setText(R.string.continues_play);
        this.nUo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nUp != null) {
                    VideoEasterEggActivity.this.nUp.dVh();
                }
            }
        });
        this.nUm.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zi(boolean z) {
        if (z) {
            if (this.jNx != null && !this.jNx.isShowing()) {
                this.jNx.setDialogVisiable(true);
            }
            this.nUl.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
            return;
        }
        if (this.jNx != null) {
            this.jNx.setDialogVisiable(false);
        }
        this.nUl.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nUp != null) {
            this.nUp.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        pauseVideo();
        if (this.nUp != null) {
            this.nUp.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseVideo() {
        if (this.nUl != null && this.nUl.isPlaying()) {
            this.nUq = this.nUl.getCurrentPosition();
            this.nUl.pause();
            this.nUr = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nUp != null) {
            this.nUp.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void UP(String str) {
        if (!au.isEmpty(str) && !this.nUl.isPlaying() && !this.nUu) {
            if (this.nUr) {
                this.nUl.seekTo(this.nUq);
                this.nUr = false;
            } else {
                this.nUl.setVideoURI(Uri.parse(str));
                e.mA().postDelayed(this.nUv, 5000L);
            }
            this.nUl.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void UQ(String str) {
        this.nUm.setVisibility(8);
        this.nUr = true;
        this.nUq = 0;
        this.nUu = false;
        UP(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void gL(String str, String str2) {
        if (this.nUt == null) {
            this.nUt = gM(str, str2);
        }
        this.nUt.bqx();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void arY() {
        e.mA().removeCallbacks(this.nUv);
        this.nUl.pause();
        this.jNx.setDialogVisiable(false);
        this.nUm.setVisibility(0);
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
            ap.setViewTextColor(this.nUn, R.color.CAM_X0101);
            ap.setViewTextColor(this.nUo, R.color.CAM_X0101);
            ap.setBackgroundResource(this.nUo, R.drawable.continue_play_bg);
            ap.setImageResource(this.ixO, R.drawable.icon_frs_luhan_close);
            ap.setImageResource(this.nUk, R.drawable.icon_frs_luhan_share);
        }
    }

    private a gM(String str, String str2) {
        this.nUt = new a(this);
        this.nUt.UN(str2);
        if (au.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.nUt.Au(str);
        this.nUt.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.nUs = z;
            }
        });
        this.nUt.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.nUp != null) {
                    VideoEasterEggActivity.this.nUp.dVh();
                    TiebaStatic.log(new ar(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.nUt.dismiss();
            }
        });
        this.nUt.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.nUp != null) {
                    VideoEasterEggActivity.this.nUp.daw();
                    TiebaStatic.log(new ar(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).ap("obj_locate", 2));
                }
                VideoEasterEggActivity.this.nUt.dismiss();
            }
        });
        this.nUt.d(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.nUs) {
                    VideoEasterEggActivity.this.nUp.dVj();
                }
            }
        });
        this.nUt.b(getPageContext());
        return this.nUt;
    }
}
