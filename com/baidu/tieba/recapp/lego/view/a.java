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
    private boolean fZQ;
    private boolean fZR;
    private long fZS;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.fZQ = false;
        this.fZR = false;
        this.fZS = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.bdm = new a.InterfaceC0112a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0112a
            public void onLoading() {
                a.this.fWb.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0112a
            public void onPlay() {
                a.this.fWb.play();
                a.this.mStatus = 1;
            }
        };
        this.aZF = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.fWd != null) {
                    a.this.mDuration = a.this.fWd.getDuration();
                    a.this.fWb.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.bjG() > 0) {
                        mediaPlayer.seekTo((int) a.this.bjG());
                        a.this.oG(0);
                    }
                    a.this.fWb.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.fWe = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.fWb.complete();
                a.this.fWb.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.fWf = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.fZR = true;
                a.this.fWb.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.aZJ = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.fWb.error();
                return true;
            }
        };
        this.fWb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.fWd != null && !a.this.fWd.isPlaying()) {
                    a.this.fWb.play();
                    a.this.fWd.start();
                }
            }
        });
        this.fWb.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2.getId() == d.g.error_tips) {
                    if (a.this.fWd != null) {
                        a.this.fWd.reset();
                    }
                    if (a.this.fWb != null) {
                        a.this.fWb.buffer();
                    }
                } else if ((view2.getId() == d.g.play_icon || view2.getId() == d.g.replay) && a.this.fWd != null && a.this.fWb != null) {
                    if (a.this.fWd.isPlaying()) {
                        a.this.fWd.pause();
                        a.this.fWb.pause();
                        a.this.fZQ = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.fWb.play();
                        a.this.fWd.start();
                    } else if (a.this.fWb instanceof i) {
                        ((i) a.this.fWb).startPlay();
                    }
                    a.this.fZQ = false;
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
            this.fZR = true;
            this.fWb.buffer();
            super.playVideo();
            return;
        }
        this.fZR = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.fWb.pause();
        if (this.fWd != null) {
            this.fWd.pause();
        }
        if (this.fWc != null) {
            this.fWc.onPause(this.adf.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.fZQ && this.fZR) {
            if (this.fWd != null && !this.fWd.isPlaying() && this.isPrepared) {
                this.fWb.play();
                this.fWd.start();
            } else if (this.fWb instanceof i) {
                ((i) this.fWb).startPlay();
            }
            if (this.fWc != null) {
                this.fWc.onResume(this.adf.getPageActivity());
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

    public long bjG() {
        return this.fZS;
    }

    public void bjH() {
        this.fZS = getCurrentPos();
    }

    public void oG(int i) {
        this.fZS = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.adf.getPageActivity());
        aVar.bY(d.k.confirm_title);
        aVar.dc(this.adf.getPageActivity().getResources().getString(d.k.now_is_not_wifi));
        aVar.a(this.adf.getPageActivity().getResources().getString(d.k.confirm), this.fWf);
        aVar.b(this.adf.getPageActivity().getResources().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.adf.getPageActivity().finish();
            }
        });
        aVar.ar(false);
        aVar.as(false);
        aVar.b(this.adf);
        aVar.tD();
    }
}
