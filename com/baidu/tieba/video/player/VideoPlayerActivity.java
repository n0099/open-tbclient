package com.baidu.tieba.video.player;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.XiaoyingPlayerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.d;
import com.baidu.tieba.video.player.a.a;
import com.baidu.tieba.video.player.a.b;
import com.baidu.tieba.video.player.a.c;
/* loaded from: classes3.dex */
public class VideoPlayerActivity extends BaseActivity<VideoPlayerActivity> {
    private String bQL;
    private View huA;
    private a huB;
    private b huC;
    private c huD;
    private String huE;
    private View huz;
    private View mRootView;
    private int mVideoWidth = 0;
    private int mVideoHeight = 0;
    private b.a huF = new b.a() { // from class: com.baidu.tieba.video.player.VideoPlayerActivity.1
        @Override // com.baidu.tieba.video.player.a.b.a
        public void bCO() {
            TbadkCoreApplication.getInst().handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.player.VideoPlayerActivity.1.1
                @Override // java.lang.Runnable
                public void run() {
                    VideoPlayerActivity.this.VV();
                }
            }, 200L);
        }

        @Override // com.baidu.tieba.video.player.a.b.a
        public void bCP() {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayerActivity.this.getPageContext().getPageActivity());
            aVar.dk(VideoPlayerActivity.this.getResources().getString(d.j.video_play_error));
            aVar.setAutoNight(false);
            aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.video.player.VideoPlayerActivity.1.2
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    VideoPlayerActivity.this.finish();
                }
            });
            aVar.b(d.j.confirm, new a.b() { // from class: com.baidu.tieba.video.player.VideoPlayerActivity.1.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    VideoPlayerActivity.this.finish();
                }
            });
            aVar.b(VideoPlayerActivity.this.getPageContext()).AV();
        }

        @Override // com.baidu.tieba.video.player.a.b.a
        public void bCQ() {
            VideoPlayerActivity.this.bCM();
        }
    };
    private c.a huG = new c.a() { // from class: com.baidu.tieba.video.player.VideoPlayerActivity.2
        @Override // com.baidu.tieba.video.player.a.c.a
        public void bCR() {
            VideoPlayerActivity.this.VU();
            VideoPlayerActivity.this.bCN();
            VideoPlayerActivity.this.huC.startPlay(VideoPlayerActivity.this.bQL);
        }

        @Override // com.baidu.tieba.video.player.a.c.a
        public void bCS() {
            VideoPlayerActivity.this.finish();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.video_player_layout);
        this.mRootView = findViewById(d.g.video_player_root);
        this.huz = findViewById(d.g.video_player_back_view);
        this.huz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.player.VideoPlayerActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayerActivity.this.finish();
            }
        });
        this.huC = new b(this.mRootView);
        this.huC.a(this.huF);
        this.bQL = getIntent().getStringExtra(XiaoyingPlayerConfig.EXTRA_URL);
        this.mVideoWidth = getIntent().getIntExtra(XiaoyingPlayerConfig.EXTRA_VIDEO_WIDTH, 0);
        this.mVideoHeight = getIntent().getIntExtra(XiaoyingPlayerConfig.EXTRA_VIDEO_HEIGHT, 0);
        this.huE = getIntent().getStringExtra(XiaoyingPlayerConfig.EXTRA_THUMBNAIL_URL);
        this.huC.startPlay(this.bQL);
        this.huA = findViewById(d.g.video_player_video_container);
        this.huB = new com.baidu.tieba.video.player.a.a(getPageContext().getPageActivity());
        this.huB.p(this.huE, this.mVideoWidth, this.mVideoHeight);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ay.e(this.mRootView, d.C0141d.common_color_10144, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        VU();
        this.huC.startPlay(this.bQL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bCN();
        VV();
        if (this.huC != null) {
            this.huC.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VU() {
        if (this.huB != null) {
            this.huB.attachView(this.mRootView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VV() {
        if (this.huB != null) {
            this.huB.bk(this.mRootView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCM() {
        if (this.huD == null) {
            this.huD = new c(getPageContext().getPageActivity());
            this.huD.a(this.huG);
        }
        this.huD.attachView(this.huA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCN() {
        if (this.huD != null) {
            this.huD.bk(this.huA);
        }
    }
}
