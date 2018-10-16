package com.baidu.tieba.recapp.view;

import android.media.MediaPlayer;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.ad.play.a;
import com.baidu.tieba.recapp.a;
/* loaded from: classes3.dex */
public class DistributeVrPlayController extends a {
    private boolean gKs;

    public DistributeVrPlayController(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.gKs = true;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.bxz = new a.InterfaceC0151a() { // from class: com.baidu.tieba.recapp.view.DistributeVrPlayController.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0151a
            public void onLoading() {
                DistributeVrPlayController.this.gCu.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0151a
            public void onPlay() {
                if (DistributeVrPlayController.this.gKs) {
                    DistributeVrPlayController.this.gKs = false;
                    DistributeVrPlayController.this.gCu.showPanoramaPrompt();
                }
                DistributeVrPlayController.this.gCu.play();
                DistributeVrPlayController.this.mStatus = 1;
            }
        };
        this.btP = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVrPlayController.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null) {
                    mediaPlayer.setVolume(0.0f, 0.0f);
                }
            }
        };
        this.gCx = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVrPlayController.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                DistributeVrPlayController.this.stopPlay();
                DistributeVrPlayController.this.gCu.complete();
            }
        };
        this.gCy = new a.b() { // from class: com.baidu.tieba.recapp.view.DistributeVrPlayController.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                DistributeVrPlayController.this.gCu.loading();
                DistributeVrPlayController.this.playVideo();
                aVar.dismiss();
            }
        };
        this.btT = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVrPlayController.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                DistributeVrPlayController.this.stopPlay();
                DistributeVrPlayController.this.gCu.error();
                return true;
            }
        };
    }

    @Override // com.baidu.tieba.recapp.a
    public void startPlay(String str) {
        super.startPlay(str);
    }

    @Override // com.baidu.tieba.recapp.a
    public void playVideo() {
        super.playVideo();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
    }

    @Override // com.baidu.tieba.recapp.a
    public void stopPlay() {
        super.stopPlay();
    }

    @Override // com.baidu.tieba.recapp.a
    public void finishStopPlay() {
    }

    @Override // com.baidu.tieba.recapp.a
    public void destroy() {
        super.destroy();
    }
}
