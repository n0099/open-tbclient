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
    private d dkx;
    private ImageView ehf;
    private ImageView hue;
    private ScaleVideoView huf;
    private View hug;
    private TextView huh;
    private TextView hui;
    private com.baidu.tieba.videoEasterEgg.b.a huj;
    private a hun;
    private boolean huo;
    private int mSkinType = 3;
    private int huk = 0;
    private boolean hul = false;
    private boolean hum = false;
    private Runnable btB = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.huj != null) {
                VideoEasterEggActivity.this.huj.bGx();
            }
        }
    };
    private MediaPlayer.OnInfoListener hup = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.nC(false);
                e.jt().removeCallbacks(VideoEasterEggActivity.this.btB);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.huj = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new am("c13046"));
    }

    private void initUI() {
        this.dkx = new d(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(e.h.video_easter_egg_layout);
        atZ();
        bGt();
        bGu();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void atZ() {
        this.ehf = (ImageView) findViewById(e.g.close);
        this.ehf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.huj != null) {
                    VideoEasterEggActivity.this.huj.onClose();
                }
            }
        });
        this.hue = (ImageView) findViewById(e.g.share);
        this.hue.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.huj != null) {
                    VideoEasterEggActivity.this.huj.bGv();
                    VideoEasterEggActivity.this.ayn();
                    TiebaStatic.log(new am("c13045").w("obj_locate", 1));
                }
            }
        });
    }

    private void bGt() {
        this.huf = (ScaleVideoView) findViewById(e.g.scale_video_view);
        this.huf.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.huj != null) {
                    VideoEasterEggActivity.this.huj.bGx();
                    return true;
                }
                return true;
            }
        });
        this.huf.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.huo = true;
                if (VideoEasterEggActivity.this.huj != null) {
                    VideoEasterEggActivity.this.huj.bGy();
                }
            }
        });
        this.huf.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.huf.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.hup);
            }
        });
        this.huf.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.nC(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.huo = false;
            }
        });
        nC(true);
    }

    private void bGu() {
        this.hug = findViewById(e.g.error_container);
        this.huh = (TextView) findViewById(e.g.load_error_text);
        this.huh.setText(e.j.loading_error);
        this.hui = (TextView) findViewById(e.g.play_text);
        this.hui.setText(e.j.continues_play);
        this.hui.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.huj != null) {
                    VideoEasterEggActivity.this.huj.bGw();
                }
            }
        });
        this.hug.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nC(boolean z) {
        if (z) {
            if (this.dkx != null && !this.dkx.isShowing()) {
                this.dkx.aZ(true);
            }
            this.huf.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.cp_cont_i));
            return;
        }
        if (this.dkx != null) {
            this.dkx.aZ(false);
        }
        this.huf.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.huj != null) {
            this.huj.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ayn();
        if (this.huj != null) {
            this.huj.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayn() {
        if (this.huf != null && this.huf.isPlaying()) {
            this.huk = this.huf.getCurrentPosition();
            this.huf.pause();
            this.hul = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.huj != null) {
            this.huj.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void vT(String str) {
        if (!ao.isEmpty(str) && !this.huf.isPlaying() && !this.huo) {
            if (this.hul) {
                this.huf.seekTo(this.huk);
                this.hul = false;
            } else {
                this.huf.setVideoURI(Uri.parse(str));
                com.baidu.adp.lib.g.e.jt().postDelayed(this.btB, 5000L);
            }
            this.huf.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void vU(String str) {
        this.hug.setVisibility(8);
        this.hul = true;
        this.huk = 0;
        this.huo = false;
        vT(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void cE(String str, String str2) {
        if (this.hun == null) {
            this.hun = cF(str, str2);
        }
        this.hun.yl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void alS() {
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.btB);
        this.huf.pause();
        this.dkx.aZ(false);
        this.hug.setVisibility(0);
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
            al.h(this.huh, e.d.cp_cont_i);
            al.h(this.hui, e.d.cp_cont_i);
            al.i(this.hui, e.f.continue_play_bg);
            al.c(this.ehf, e.f.icon_frs_luhan_close);
            al.c(this.hue, e.f.icon_frs_luhan_share);
        }
    }

    private a cF(String str, String str2) {
        this.hun = new a(this);
        this.hun.vR(str2);
        if (ao.isEmpty(str)) {
            str = getResources().getString(e.j.easter_dialog_default_message);
        }
        this.hun.dT(str);
        this.hun.a(e.j.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.hum = z;
            }
        });
        this.hun.b(e.j.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.huj != null) {
                    VideoEasterEggActivity.this.huj.bGw();
                    TiebaStatic.log(new am("c13044"));
                }
                VideoEasterEggActivity.this.hun.dismiss();
            }
        });
        this.hun.a(e.j.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.huj != null) {
                    VideoEasterEggActivity.this.huj.bGv();
                    TiebaStatic.log(new am("c13045").w("obj_locate", 2));
                }
                VideoEasterEggActivity.this.hun.dismiss();
            }
        });
        this.hun.a(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.hum) {
                    VideoEasterEggActivity.this.huj.bGz();
                }
            }
        });
        this.hun.b(getPageContext());
        return this.hun;
    }
}
