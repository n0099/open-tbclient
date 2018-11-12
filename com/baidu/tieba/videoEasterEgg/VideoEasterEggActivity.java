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
    private d dtG;
    private ImageView eqs;
    private ImageView hDb;
    private ScaleVideoView hDc;
    private View hDd;
    private TextView hDe;
    private TextView hDf;
    private com.baidu.tieba.videoEasterEgg.b.a hDg;
    private a hDk;
    private boolean hDl;
    private int mSkinType = 3;
    private int hDh = 0;
    private boolean hDi = false;
    private boolean hDj = false;
    private Runnable byr = new Runnable() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoEasterEggActivity.this.hDg != null) {
                VideoEasterEggActivity.this.hDg.XP();
            }
        }
    };
    private MediaPlayer.OnInfoListener hDm = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                VideoEasterEggActivity.this.og(false);
                e.jG().removeCallbacks(VideoEasterEggActivity.this.byr);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
        this.hDg = new com.baidu.tieba.videoEasterEgg.b.b(getPageContext(), this, getIntent());
        initUI();
        TiebaStatic.log(new am("c13046"));
    }

    private void initUI() {
        this.dtG = new d(getPageContext());
        setSwipeBackEnabled(false);
        setContentView(e.h.video_easter_egg_layout);
        awU();
        bJf();
        bJg();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void awU() {
        this.eqs = (ImageView) findViewById(e.g.close);
        this.eqs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hDg != null) {
                    VideoEasterEggActivity.this.hDg.onClose();
                }
            }
        });
        this.hDb = (ImageView) findViewById(e.g.share);
        this.hDb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hDg != null) {
                    VideoEasterEggActivity.this.hDg.bJh();
                    VideoEasterEggActivity.this.aBg();
                    TiebaStatic.log(new am("c13045").x("obj_locate", 1));
                }
            }
        });
    }

    private void bJf() {
        this.hDc = (ScaleVideoView) findViewById(e.g.scale_video_view);
        this.hDc.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.9
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoEasterEggActivity.this.hDg != null) {
                    VideoEasterEggActivity.this.hDg.XP();
                    return true;
                }
                return true;
            }
        });
        this.hDc.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.hDl = true;
                if (VideoEasterEggActivity.this.hDg != null) {
                    VideoEasterEggActivity.this.hDg.bJj();
                }
            }
        });
        this.hDc.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoEasterEggActivity.this.hDc.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(VideoEasterEggActivity.this.hDm);
            }
        });
        this.hDc.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.12
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.og(true);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoEasterEggActivity.this.hDl = false;
            }
        });
        og(true);
    }

    private void bJg() {
        this.hDd = findViewById(e.g.error_container);
        this.hDe = (TextView) findViewById(e.g.load_error_text);
        this.hDe.setText(e.j.loading_error);
        this.hDf = (TextView) findViewById(e.g.play_text);
        this.hDf.setText(e.j.continues_play);
        this.hDf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoEasterEggActivity.this.hDg != null) {
                    VideoEasterEggActivity.this.hDg.bJi();
                }
            }
        });
        this.hDd.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void og(boolean z) {
        if (z) {
            if (this.dtG != null && !this.dtG.isShowing()) {
                this.dtG.bz(true);
            }
            this.hDc.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.cp_cont_i));
            return;
        }
        if (this.dtG != null) {
            this.dtG.bz(false);
        }
        this.hDc.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.transparent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hDg != null) {
            this.hDg.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        aBg();
        if (this.hDg != null) {
            this.hDg.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBg() {
        if (this.hDc != null && this.hDc.isPlaying()) {
            this.hDh = this.hDc.getCurrentPosition();
            this.hDc.pause();
            this.hDi = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hDg != null) {
            this.hDg.onDestroy();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void wz(String str) {
        if (!ao.isEmpty(str) && !this.hDc.isPlaying() && !this.hDl) {
            if (this.hDi) {
                this.hDc.seekTo(this.hDh);
                this.hDi = false;
            } else {
                this.hDc.setVideoURI(Uri.parse(str));
                com.baidu.adp.lib.g.e.jG().postDelayed(this.byr, 5000L);
            }
            this.hDc.start();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void wA(String str) {
        this.hDd.setVisibility(8);
        this.hDi = true;
        this.hDh = 0;
        this.hDl = false;
        wz(str);
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void cP(String str, String str2) {
        if (this.hDk == null) {
            this.hDk = cQ(str, str2);
        }
        this.hDk.AB();
    }

    @Override // com.baidu.tieba.videoEasterEgg.b
    public void showErrorView() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.byr);
        this.hDc.pause();
        this.dtG.bz(false);
        this.hDd.setVisibility(0);
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
            al.h(this.hDe, e.d.cp_cont_i);
            al.h(this.hDf, e.d.cp_cont_i);
            al.i(this.hDf, e.f.continue_play_bg);
            al.c(this.eqs, e.f.icon_frs_luhan_close);
            al.c(this.hDb, e.f.icon_frs_luhan_share);
        }
    }

    private a cQ(String str, String str2) {
        this.hDk = new a(this);
        this.hDk.wx(str2);
        if (ao.isEmpty(str)) {
            str = getResources().getString(e.j.easter_dialog_default_message);
        }
        this.hDk.ej(str);
        this.hDk.a(e.j.easter_dialog_checkbox_text_not_again, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VideoEasterEggActivity.this.hDj = z;
            }
        });
        this.hDk.b(e.j.easter_dialog_btn_text_replay, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.hDg != null) {
                    VideoEasterEggActivity.this.hDg.bJi();
                    TiebaStatic.log(new am("c13044"));
                }
                VideoEasterEggActivity.this.hDk.dismiss();
            }
        });
        this.hDk.a(e.j.easter_dialog_btn_text_share, new a.b() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (VideoEasterEggActivity.this.hDg != null) {
                    VideoEasterEggActivity.this.hDg.bJh();
                    TiebaStatic.log(new am("c13045").x("obj_locate", 2));
                }
                VideoEasterEggActivity.this.hDk.dismiss();
            }
        });
        this.hDk.a(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (VideoEasterEggActivity.this.hDj) {
                    VideoEasterEggActivity.this.hDg.bJk();
                }
            }
        });
        this.hDk.b(getPageContext());
        return this.hDk;
    }
}
