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
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.recapp.a {
    public boolean isPrepared;
    private boolean jIm;
    private boolean jIn;
    private long jIo;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.jIm = false;
        this.jIn = false;
        this.jIo = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.dVE = new a.InterfaceC0394a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0394a
            public void onLoading() {
                a.this.jEv.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0394a
            public void onPlay() {
                a.this.jEv.play();
                a.this.mStatus = 1;
            }
        };
        this.cgt = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.jEx != null) {
                    a.this.mDuration = a.this.jEx.getDuration();
                    a.this.jEv.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.cBu() > 0) {
                        mediaPlayer.seekTo((int) a.this.cBu());
                        a.this.xx(0);
                    }
                    a.this.jEv.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.jEy = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.jEv.complete();
                a.this.jEv.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.jEz = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.jIn = true;
                a.this.jEv.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.cgv = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.jEv.error();
                return true;
            }
        };
        this.jEv.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.jEx != null && !a.this.jEx.isPlaying()) {
                    a.this.jEv.play();
                    a.this.jEx.start();
                }
            }
        });
        this.jEv.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.error_tips) {
                    if (a.this.jEx != null) {
                        a.this.jEx.reset();
                    }
                    if (a.this.jEv != null) {
                        a.this.jEv.buffer();
                    }
                } else if ((view.getId() == R.id.play_icon || view.getId() == R.id.replay) && a.this.jEx != null && a.this.jEv != null) {
                    if (a.this.jEx.isPlaying()) {
                        a.this.jEx.pause();
                        a.this.jEv.pause();
                        a.this.jIm = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.jEv.play();
                        a.this.jEx.start();
                    } else if (a.this.jEv instanceof i) {
                        ((i) a.this.jEv).startPlay();
                    }
                    a.this.jIm = false;
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
            this.jIn = true;
            this.jEv.buffer();
            super.playVideo();
            return;
        }
        this.jIn = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.jEv.pause();
        if (this.jEx != null) {
            this.jEx.pause();
        }
        if (this.jEw != null) {
            this.jEw.onPause(this.cRe.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.jIm && this.jIn) {
            if (this.jEx != null && !this.jEx.isPlaying() && this.isPrepared) {
                this.jEv.play();
                this.jEx.start();
            } else if (this.jEv instanceof i) {
                ((i) this.jEv).startPlay();
            }
            if (this.jEw != null) {
                this.jEw.onResume(this.cRe.getPageActivity());
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

    public long cBu() {
        return this.jIo;
    }

    public void cBv() {
        this.jIo = getCurrentPos();
    }

    public void xx(int i) {
        this.jIo = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cRe.getPageActivity());
        aVar.jE(R.string.confirm_title);
        aVar.sC(this.cRe.getPageActivity().getResources().getString(R.string.now_is_not_wifi));
        aVar.a(this.cRe.getPageActivity().getResources().getString(R.string.confirm), this.jEz);
        aVar.b(this.cRe.getPageActivity().getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.cRe.getPageActivity().finish();
            }
        });
        aVar.fz(false);
        aVar.fA(false);
        aVar.b(this.cRe);
        aVar.aCp();
    }
}
