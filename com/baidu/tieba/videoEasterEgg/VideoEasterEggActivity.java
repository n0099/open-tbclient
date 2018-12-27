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
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.d;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements b {
    private d dCS;
    private ImageView eAf;
    private View hNA;
    private TextView hNB;
    private TextView hNC;
    private com.baidu.tieba.videoEasterEgg.b.a hND;
    private a hNH;
    private boolean hNI;
    private ImageView hNy;
    private ScaleVideoView hNz;
    private int mSkinType = 3;
    private int hNE = 0;
    private boolean hNF = false;
    private boolean hNG = false;
    private Runnable bBR = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.hND != null) {
                VideoEasterEggActivity.this.hND.YU();
            }
        }
    };
    private MediaPlayer.OnInfoListener hNJ = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.ol(false);
                e.jG().removeCallbacks(VideoEasterEggActivity.this.bBR);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.hND = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new am("c13046"));
    }

    private void initUI() {
        this.dCS = new d(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(e.h.video_easter_egg_layout);
        azu();
        bLZ();
        bMa();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void azu() {
        this.eAf = (ImageView) findViewById(e.g.close);
        this.eAf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hND != null) {
                    VideoEasterEggActivity.this.hND.onClose();
                }
            }
        });
        this.hNy = (ImageView) findViewById(e.g.share);
        this.hNy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hND != null) {
                    VideoEasterEggActivity.this.hND.bMb();
                    VideoEasterEggActivity.this.aDF();
                    TiebaStatic.log(new am("c13045").x("obj_locate", 1));
                }
            }
        });
    }

    private void bLZ() {
        this.hNz = (ScaleVideoView) findViewById(e.g.scale_video_view);
        this.hNz.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.hND != null) {
                    VideoEasterEggActivity.this.hND.YU();
                    return true;
                }
                return true;
            }
        });
        this.hNz.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.hNI = true;
                if (VideoEasterEggActivity.this.hND != null) {
                    VideoEasterEggActivity.this.hND.bMd();
                }
            }
        });
        this.hNz.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.hNz.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.hNJ);
            }
        });
        this.hNz.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.ol(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.hNI = false;
            }
        });
        ol(true);
    }

    private void bMa() {
        this.hNA = findViewById(e.g.error_container);
        this.hNB = (TextView) findViewById(e.g.load_error_text);
        this.hNB.setText(e.j.loading_error);
        this.hNC = (TextView) findViewById(e.g.play_text);
        this.hNC.setText(e.j.continues_play);
        this.hNC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hND != null) {
                    VideoEasterEggActivity.this.hND.bMc();
                }
            }
        });
        this.hNA.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ol(boolean z) {
        if (z) {
            if (this.dCS != null && !this.dCS.isShowing()) {
                this.dCS.bA(true);
            }
            this.hNz.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.cp_cont_i));
            return;
        }
        if (this.dCS != null) {
            this.dCS.bA(false);
        }
        this.hNz.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hND != null) {
            this.hND.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        aDF();
        if (this.hND != null) {
            this.hND.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDF() {
        if (this.hNz != null && this.hNz.isPlaying()) {
            this.hNE = this.hNz.getCurrentPosition();
            this.hNz.pause();
            this.hNF = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hND != null) {
            this.hND.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void xf(String str) {
        if (!ao.isEmpty(str) && !this.hNz.isPlaying() && !this.hNI) {
            if (this.hNF) {
                this.hNz.seekTo(this.hNE);
                this.hNF = false;
            } else {
                this.hNz.setVideoURI(Uri.parse(str));
                com.baidu.adp.lib.g.e.jG().postDelayed(this.bBR, 5000L);
            }
            this.hNz.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void xg(String str) {
        this.hNA.setVisibility(8);
        this.hNF = true;
        this.hNE = 0;
        this.hNI = false;
        xf(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void cU(String str, String str2) {
        if (this.hNH == null) {
            this.hNH = cV(str, str2);
        }
        this.hNH.BF();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void showErrorView() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bBR);
        this.hNz.pause();
        this.dCS.bA(false);
        this.hNA.setVisibility(0);
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
            al.h(this.hNB, e.d.cp_cont_i);
            al.h(this.hNC, e.d.cp_cont_i);
            al.i(this.hNC, e.f.continue_play_bg);
            al.c(this.eAf, e.f.icon_frs_luhan_close);
            al.c(this.hNy, e.f.icon_frs_luhan_share);
        }
    }

    private a cV(String str, String str2) {
        this.hNH = new a(this);
        this.hNH.xd(str2);
        if (ao.isEmpty(str)) {
            str = getResources().getString(e.j.easter_dialog_default_message);
        }
        this.hNH.eB(str);
        this.hNH.a(e.j.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.hNG = z;
            }
        });
        this.hNH.b(e.j.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.hND != null) {
                    VideoEasterEggActivity.this.hND.bMc();
                    TiebaStatic.log(new am("c13044"));
                }
                VideoEasterEggActivity.this.hNH.dismiss();
            }
        });
        this.hNH.a(e.j.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.hND != null) {
                    VideoEasterEggActivity.this.hND.bMb();
                    TiebaStatic.log(new am("c13045").x("obj_locate", 2));
                }
                VideoEasterEggActivity.this.hNH.dismiss();
            }
        });
        this.hNH.a(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.hNG) {
                    VideoEasterEggActivity.this.hND.bMe();
                }
            }
        });
        this.hNH.b(getPageContext());
        return this.hNH;
    }
}
