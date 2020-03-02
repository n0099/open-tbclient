package com.baidu.tieba.recapp.view;

import android.media.MediaPlayer;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.ad.play.a;
import com.baidu.tieba.recapp.a;
/* loaded from: classes13.dex */
public class DistributeVrPlayController extends a {
    private boolean jNE;

    public DistributeVrPlayController(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.jNE = true;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.dZJ = new a.InterfaceC0405a() { // from class: com.baidu.tieba.recapp.view.DistributeVrPlayController.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0405a
            public void onLoading() {
                DistributeVrPlayController.this.jFo.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0405a
            public void onPlay() {
                if (DistributeVrPlayController.this.jNE) {
                    DistributeVrPlayController.this.jNE = false;
                    DistributeVrPlayController.this.jFo.showPanoramaPrompt();
                }
                DistributeVrPlayController.this.jFo.play();
                DistributeVrPlayController.this.mStatus = 1;
            }
        };
        this.cky = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVrPlayController.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null) {
                    mediaPlayer.setVolume(0.0f, 0.0f);
                }
            }
        };
        this.jFr = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVrPlayController.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                DistributeVrPlayController.this.stopPlay();
                DistributeVrPlayController.this.jFo.complete();
            }
        };
        this.jFs = new a.b() { // from class: com.baidu.tieba.recapp.view.DistributeVrPlayController.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                DistributeVrPlayController.this.jFo.loading();
                DistributeVrPlayController.this.playVideo();
                aVar.dismiss();
            }
        };
        this.ckA = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVrPlayController.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                DistributeVrPlayController.this.stopPlay();
                DistributeVrPlayController.this.jFo.error();
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
