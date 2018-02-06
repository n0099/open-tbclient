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
    private String bQV;
    private View huo;
    private View hup;
    private a huq;
    private b hur;
    private c hus;
    private String hut;
    private View mRootView;
    private int mVideoWidth = 0;
    private int mVideoHeight = 0;
    private b.a huu = new b.a() { // from class: com.baidu.tieba.video.player.VideoPlayerActivity.1
        @Override // com.baidu.tieba.video.player.a.b.a
        public void bCK() {
            TbadkCoreApplication.getInst().handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.player.VideoPlayerActivity.1.1
                @Override // java.lang.Runnable
                public void run() {
                    VideoPlayerActivity.this.VV();
                }
            }, 200L);
        }

        @Override // com.baidu.tieba.video.player.a.b.a
        public void bCL() {
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
            aVar.b(VideoPlayerActivity.this.getPageContext()).AU();
        }

        @Override // com.baidu.tieba.video.player.a.b.a
        public void bCM() {
            VideoPlayerActivity.this.bCI();
        }
    };
    private c.a huv = new c.a() { // from class: com.baidu.tieba.video.player.VideoPlayerActivity.2
        @Override // com.baidu.tieba.video.player.a.c.a
        public void bCN() {
            VideoPlayerActivity.this.VU();
            VideoPlayerActivity.this.bCJ();
            VideoPlayerActivity.this.hur.startPlay(VideoPlayerActivity.this.bQV);
        }

        @Override // com.baidu.tieba.video.player.a.c.a
        public void bCO() {
            VideoPlayerActivity.this.finish();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.video_player_layout);
        this.mRootView = findViewById(d.g.video_player_root);
        this.huo = findViewById(d.g.video_player_back_view);
        this.huo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.player.VideoPlayerActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayerActivity.this.finish();
            }
        });
        this.hur = new b(this.mRootView);
        this.hur.a(this.huu);
        this.bQV = getIntent().getStringExtra(XiaoyingPlayerConfig.EXTRA_URL);
        this.mVideoWidth = getIntent().getIntExtra(XiaoyingPlayerConfig.EXTRA_VIDEO_WIDTH, 0);
        this.mVideoHeight = getIntent().getIntExtra(XiaoyingPlayerConfig.EXTRA_VIDEO_HEIGHT, 0);
        this.hut = getIntent().getStringExtra(XiaoyingPlayerConfig.EXTRA_THUMBNAIL_URL);
        this.hur.startPlay(this.bQV);
        this.hup = findViewById(d.g.video_player_video_container);
        this.huq = new com.baidu.tieba.video.player.a.a(getPageContext().getPageActivity());
        this.huq.p(this.hut, this.mVideoWidth, this.mVideoHeight);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ay.e(this.mRootView, d.C0140d.common_color_10144, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        VU();
        this.hur.startPlay(this.bQV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bCJ();
        VV();
        if (this.hur != null) {
            this.hur.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VU() {
        if (this.huq != null) {
            this.huq.attachView(this.mRootView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VV() {
        if (this.huq != null) {
            this.huq.bk(this.mRootView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCI() {
        if (this.hus == null) {
            this.hus = new c(getPageContext().getPageActivity());
            this.hus.a(this.huv);
        }
        this.hus.attachView(this.hup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCJ() {
        if (this.hus != null) {
            this.hus.bk(this.hup);
        }
    }
}
