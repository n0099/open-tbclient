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
/* loaded from: classes21.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private ImageView jHK;
    private com.baidu.tbadk.core.view.a jmh;
    private ImageView nxk;
    private ScaleVideoView nxl;
    private View nxm;
    private TextView nxn;
    private TextView nxo;
    private com.baidu.tieba.videoEasterEgg.b.a nxp;
    private a nxt;
    private boolean nxu;
    private int mSkinType = 3;
    private int nxq = 0;
    private boolean nxr = false;
    private boolean nxs = false;
    private Runnable nxv = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.nxp != null) {
                VideoEasterEggActivity.this.nxp.dwr();
            }
        }
    };
    private MediaPlayer.OnInfoListener nxw = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.yo(false);
                e.mY().removeCallbacks(VideoEasterEggActivity.this.nxv);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.nxp = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new ar(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
    }

    private void initUI() {
        this.jmh = new com.baidu.tbadk.core.view.a(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(R.layout.video_easter_egg_layout);
        bCo();
        dRF();
        dRG();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bCo() {
        this.jHK = (ImageView) findViewById(R.id.close);
        this.jHK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nxp != null) {
                    VideoEasterEggActivity.this.nxp.onClose();
                }
            }
        });
        this.nxk = (ImageView) findViewById(R.id.share);
        this.nxk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nxp != null) {
                    VideoEasterEggActivity.this.nxp.bxc();
                    VideoEasterEggActivity.this.pauseVideo();
                    TiebaStatic.log(new ar(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).ak("obj_locate", 1));
                }
            }
        });
    }

    private void dRF() {
        this.nxl = (ScaleVideoView) findViewById(R.id.scale_video_view);
        this.nxl.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.nxp != null) {
                    VideoEasterEggActivity.this.nxp.dwr();
                    return true;
                }
                return true;
            }
        });
        this.nxl.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.nxu = true;
                if (VideoEasterEggActivity.this.nxp != null) {
                    VideoEasterEggActivity.this.nxp.dRI();
                }
            }
        });
        this.nxl.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.nxl.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.nxw);
            }
        });
        this.nxl.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.yo(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.nxu = false;
            }
        });
        yo(true);
    }

    private void dRG() {
        this.nxm = findViewById(R.id.error_container);
        this.nxn = (TextView) findViewById(R.id.load_error_text);
        this.nxn.setText(R.string.loading_error);
        this.nxo = (TextView) findViewById(R.id.play_text);
        this.nxo.setText(R.string.continues_play);
        this.nxo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.nxp != null) {
                    VideoEasterEggActivity.this.nxp.dRH();
                }
            }
        });
        this.nxm.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yo(boolean z) {
        if (z) {
            if (this.jmh != null && !this.jmh.isShowing()) {
                this.jmh.setDialogVisiable(true);
            }
            this.nxl.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
            return;
        }
        if (this.jmh != null) {
            this.jmh.setDialogVisiable(false);
        }
        this.nxl.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nxp != null) {
            this.nxp.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        pauseVideo();
        if (this.nxp != null) {
            this.nxp.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseVideo() {
        if (this.nxl != null && this.nxl.isPlaying()) {
            this.nxq = this.nxl.getCurrentPosition();
            this.nxl.pause();
            this.nxr = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nxp != null) {
            this.nxp.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void TV(String str) {
        if (!au.isEmpty(str) && !this.nxl.isPlaying() && !this.nxu) {
            if (this.nxr) {
                this.nxl.seekTo(this.nxq);
                this.nxr = false;
            } else {
                this.nxl.setVideoURI(Uri.parse(str));
                e.mY().postDelayed(this.nxv, 5000L);
            }
            this.nxl.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void TW(String str) {
        this.nxm.setVisibility(8);
        this.nxr = true;
        this.nxq = 0;
        this.nxu = false;
        TV(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void gC(String str, String str2) {
        if (this.nxt == null) {
            this.nxt = gD(str, str2);
        }
        this.nxt.bog();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void aqV() {
        e.mY().removeCallbacks(this.nxv);
        this.nxl.pause();
        this.jmh.setDialogVisiable(false);
        this.nxm.setVisibility(0);
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
            ap.setViewTextColor(this.nxn, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.nxo, (int) R.color.CAM_X0101);
            ap.setBackgroundResource(this.nxo, R.drawable.continue_play_bg);
            ap.setImageResource(this.jHK, R.drawable.icon_frs_luhan_close);
            ap.setImageResource(this.nxk, R.drawable.icon_frs_luhan_share);
        }
    }

    private a gD(String str, String str2) {
        this.nxt = new a(this);
        this.nxt.TT(str2);
        if (au.isEmpty(str)) {
            str = getResources().getString(R.string.easter_dialog_default_message);
        }
        this.nxt.AJ(str);
        this.nxt.a(R.string.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.nxs = z;
            }
        });
        this.nxt.b(R.string.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.nxp != null) {
                    VideoEasterEggActivity.this.nxp.dRH();
                    TiebaStatic.log(new ar(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                VideoEasterEggActivity.this.nxt.dismiss();
            }
        });
        this.nxt.a(R.string.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.nxp != null) {
                    VideoEasterEggActivity.this.nxp.bxc();
                    TiebaStatic.log(new ar(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).ak("obj_locate", 2));
                }
                VideoEasterEggActivity.this.nxt.dismiss();
            }
        });
        this.nxt.d(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.nxs) {
                    VideoEasterEggActivity.this.nxp.dRJ();
                }
            }
        });
        this.nxt.b(getPageContext());
        return this.nxt;
    }
}
