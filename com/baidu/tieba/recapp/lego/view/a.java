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
    private boolean fZN;
    private boolean fZO;
    private long fZP;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.fZN = false;
        this.fZO = false;
        this.fZP = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.bdm = new a.InterfaceC0112a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0112a
            public void onLoading() {
                a.this.fVY.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0112a
            public void onPlay() {
                a.this.fVY.play();
                a.this.mStatus = 1;
            }
        };
        this.aZF = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.fWa != null) {
                    a.this.mDuration = a.this.fWa.getDuration();
                    a.this.fVY.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.bjG() > 0) {
                        mediaPlayer.seekTo((int) a.this.bjG());
                        a.this.oG(0);
                    }
                    a.this.fVY.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.fWb = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.fVY.complete();
                a.this.fVY.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.fWc = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.fZO = true;
                a.this.fVY.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.aZJ = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.fVY.error();
                return true;
            }
        };
        this.fVY.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.fWa != null && !a.this.fWa.isPlaying()) {
                    a.this.fVY.play();
                    a.this.fWa.start();
                }
            }
        });
        this.fVY.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2.getId() == d.g.error_tips) {
                    if (a.this.fWa != null) {
                        a.this.fWa.reset();
                    }
                    if (a.this.fVY != null) {
                        a.this.fVY.buffer();
                    }
                } else if ((view2.getId() == d.g.play_icon || view2.getId() == d.g.replay) && a.this.fWa != null && a.this.fVY != null) {
                    if (a.this.fWa.isPlaying()) {
                        a.this.fWa.pause();
                        a.this.fVY.pause();
                        a.this.fZN = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.fVY.play();
                        a.this.fWa.start();
                    } else if (a.this.fVY instanceof i) {
                        ((i) a.this.fVY).startPlay();
                    }
                    a.this.fZN = false;
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
            this.fZO = true;
            this.fVY.buffer();
            super.playVideo();
            return;
        }
        this.fZO = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.fVY.pause();
        if (this.fWa != null) {
            this.fWa.pause();
        }
        if (this.fVZ != null) {
            this.fVZ.onPause(this.adf.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.fZN && this.fZO) {
            if (this.fWa != null && !this.fWa.isPlaying() && this.isPrepared) {
                this.fVY.play();
                this.fWa.start();
            } else if (this.fVY instanceof i) {
                ((i) this.fVY).startPlay();
            }
            if (this.fVZ != null) {
                this.fVZ.onResume(this.adf.getPageActivity());
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
        return this.fZP;
    }

    public void bjH() {
        this.fZP = getCurrentPos();
    }

    public void oG(int i) {
        this.fZP = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.adf.getPageActivity());
        aVar.bY(d.k.confirm_title);
        aVar.dc(this.adf.getPageActivity().getResources().getString(d.k.now_is_not_wifi));
        aVar.a(this.adf.getPageActivity().getResources().getString(d.k.confirm), this.fWc);
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
