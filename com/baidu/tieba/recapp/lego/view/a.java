package com.baidu.tieba.recapp.lego.view;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.SeekBar;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.play.a;
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.view.IVrPlayView;
/* loaded from: classes13.dex */
public class a extends com.baidu.tieba.recapp.a {
    public boolean isPrepared;
    private boolean jJw;
    private boolean jJx;
    private long jJy;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.jJw = false;
        this.jJx = false;
        this.jJy = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.dZW = new a.InterfaceC0405a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0405a
            public void onLoading() {
                a.this.jFA.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0405a
            public void onPlay() {
                a.this.jFA.play();
                a.this.mStatus = 1;
            }
        };
        this.ckz = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.jFC != null) {
                    a.this.mDuration = a.this.jFC.getDuration();
                    a.this.jFA.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.cCT() > 0) {
                        mediaPlayer.seekTo((int) a.this.cCT());
                        a.this.xD(0);
                    }
                    a.this.jFA.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.jFD = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.jFA.complete();
                a.this.jFA.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.jFE = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.jJx = true;
                a.this.jFA.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.ckB = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.jFA.error();
                return true;
            }
        };
        this.jFA.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.jFC != null && !a.this.jFC.isPlaying()) {
                    a.this.jFA.play();
                    a.this.jFC.start();
                }
            }
        });
        this.jFA.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.error_tips) {
                    if (a.this.jFC != null) {
                        a.this.jFC.reset();
                    }
                    if (a.this.jFA != null) {
                        a.this.jFA.buffer();
                    }
                } else if ((view.getId() == R.id.play_icon || view.getId() == R.id.replay) && a.this.jFC != null && a.this.jFA != null) {
                    if (a.this.jFC.isPlaying()) {
                        a.this.jFC.pause();
                        a.this.jFA.pause();
                        a.this.jJw = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.jFA.play();
                        a.this.jFC.start();
                    } else if (a.this.jFA instanceof i) {
                        ((i) a.this.jFA).startPlay();
                    }
                    a.this.jJw = false;
                }
            }
        });
    }

    @Override // com.baidu.tieba.recapp.a
    public void startPlay(String str) {
        super.startPlay(str);
    }

    @Override // com.baidu.tieba.recapp.a
    public void playVideo() {
        if (!j.isMobileNet()) {
            this.jJx = true;
            this.jFA.buffer();
            super.playVideo();
            return;
        }
        this.jJx = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.jFA.pause();
        if (this.jFC != null) {
            this.jFC.pause();
        }
        if (this.jFB != null) {
            this.jFB.onPause(this.cVi.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.jJw && this.jJx) {
            if (this.jFC != null && !this.jFC.isPlaying() && this.isPrepared) {
                this.jFA.play();
                this.jFC.start();
            } else if (this.jFA instanceof i) {
                ((i) this.jFA).startPlay();
            }
            if (this.jFB != null) {
                this.jFB.onResume(this.cVi.getPageActivity());
            }
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void stopPlay() {
        super.stopPlay();
    }

    @Override // com.baidu.tieba.recapp.a
    public void finishStopPlay() {
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void destroy() {
        super.destroy();
    }

    public long cCT() {
        return this.jJy;
    }

    public void cCU() {
        this.jJy = getCurrentPos();
    }

    public void xD(int i) {
        this.jJy = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVi.getPageActivity());
        aVar.jV(R.string.confirm_title);
        aVar.sS(this.cVi.getPageActivity().getResources().getString(R.string.now_is_not_wifi));
        aVar.a(this.cVi.getPageActivity().getResources().getString(R.string.confirm), this.jFE);
        aVar.b(this.cVi.getPageActivity().getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.cVi.getPageActivity().finish();
            }
        });
        aVar.fG(false);
        aVar.fH(false);
        aVar.b(this.cVi);
        aVar.aEC();
    }
}
