package com.baidu.tieba.recapp.lego.view;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.SeekBar;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.ad.play.a;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.view.IVrPlayView;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.recapp.a {
    private boolean gaT;
    private boolean gaU;
    private long gaV;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.gaT = false;
        this.gaU = false;
        this.gaV = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.bdn = new a.InterfaceC0112a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0112a
            public void onLoading() {
                a.this.fXe.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0112a
            public void onPlay() {
                a.this.fXe.play();
                a.this.mStatus = 1;
            }
        };
        this.aZG = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.fXg != null) {
                    a.this.mDuration = a.this.fXg.getDuration();
                    a.this.fXe.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.bjF() > 0) {
                        mediaPlayer.seekTo((int) a.this.bjF());
                        a.this.oF(0);
                    }
                    a.this.fXe.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.fXh = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.fXe.complete();
                a.this.fXe.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.fXi = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.gaU = true;
                a.this.fXe.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.aZK = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.fXe.error();
                return true;
            }
        };
        this.fXe.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.fXg != null && !a.this.fXg.isPlaying()) {
                    a.this.fXe.play();
                    a.this.fXg.start();
                }
            }
        });
        this.fXe.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2.getId() == d.g.error_tips) {
                    if (a.this.fXg != null) {
                        a.this.fXg.reset();
                    }
                    if (a.this.fXe != null) {
                        a.this.fXe.buffer();
                    }
                } else if ((view2.getId() == d.g.play_icon || view2.getId() == d.g.replay) && a.this.fXg != null && a.this.fXe != null) {
                    if (a.this.fXg.isPlaying()) {
                        a.this.fXg.pause();
                        a.this.fXe.pause();
                        a.this.gaT = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.fXe.play();
                        a.this.fXg.start();
                    } else if (a.this.fXe instanceof i) {
                        ((i) a.this.fXe).startPlay();
                    }
                    a.this.gaT = false;
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
        if (!j.gR()) {
            this.gaU = true;
            this.fXe.buffer();
            super.playVideo();
            return;
        }
        this.gaU = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.fXe.pause();
        if (this.fXg != null) {
            this.fXg.pause();
        }
        if (this.fXf != null) {
            this.fXf.onPause(this.mContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.gaT && this.gaU) {
            if (this.fXg != null && !this.fXg.isPlaying() && this.isPrepared) {
                this.fXe.play();
                this.fXg.start();
            } else if (this.fXe instanceof i) {
                ((i) this.fXe).startPlay();
            }
            if (this.fXf != null) {
                this.fXf.onResume(this.mContext.getPageActivity());
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

    public long bjF() {
        return this.gaV;
    }

    public void bjG() {
        this.gaV = getCurrentPos();
    }

    public void oF(int i) {
        this.gaV = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.bZ(d.k.confirm_title);
        aVar.dc(this.mContext.getPageActivity().getResources().getString(d.k.now_is_not_wifi));
        aVar.a(this.mContext.getPageActivity().getResources().getString(d.k.confirm), this.fXi);
        aVar.b(this.mContext.getPageActivity().getResources().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.mContext.getPageActivity().finish();
            }
        });
        aVar.ar(false);
        aVar.as(false);
        aVar.b(this.mContext);
        aVar.tC();
    }
}
