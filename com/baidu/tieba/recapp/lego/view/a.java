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
    private boolean jIh;
    private boolean jIi;
    private long jIj;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.jIh = false;
        this.jIi = false;
        this.jIj = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.dVE = new a.InterfaceC0394a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0394a
            public void onLoading() {
                a.this.jEq.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0394a
            public void onPlay() {
                a.this.jEq.play();
                a.this.mStatus = 1;
            }
        };
        this.cgt = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.jEs != null) {
                    a.this.mDuration = a.this.jEs.getDuration();
                    a.this.jEq.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.cBs() > 0) {
                        mediaPlayer.seekTo((int) a.this.cBs());
                        a.this.xx(0);
                    }
                    a.this.jEq.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.jEt = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.jEq.complete();
                a.this.jEq.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.jEu = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.jIi = true;
                a.this.jEq.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.cgv = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.jEq.error();
                return true;
            }
        };
        this.jEq.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.jEs != null && !a.this.jEs.isPlaying()) {
                    a.this.jEq.play();
                    a.this.jEs.start();
                }
            }
        });
        this.jEq.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.error_tips) {
                    if (a.this.jEs != null) {
                        a.this.jEs.reset();
                    }
                    if (a.this.jEq != null) {
                        a.this.jEq.buffer();
                    }
                } else if ((view.getId() == R.id.play_icon || view.getId() == R.id.replay) && a.this.jEs != null && a.this.jEq != null) {
                    if (a.this.jEs.isPlaying()) {
                        a.this.jEs.pause();
                        a.this.jEq.pause();
                        a.this.jIh = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.jEq.play();
                        a.this.jEs.start();
                    } else if (a.this.jEq instanceof i) {
                        ((i) a.this.jEq).startPlay();
                    }
                    a.this.jIh = false;
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
            this.jIi = true;
            this.jEq.buffer();
            super.playVideo();
            return;
        }
        this.jIi = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.jEq.pause();
        if (this.jEs != null) {
            this.jEs.pause();
        }
        if (this.jEr != null) {
            this.jEr.onPause(this.cRe.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.jIh && this.jIi) {
            if (this.jEs != null && !this.jEs.isPlaying() && this.isPrepared) {
                this.jEq.play();
                this.jEs.start();
            } else if (this.jEq instanceof i) {
                ((i) this.jEq).startPlay();
            }
            if (this.jEr != null) {
                this.jEr.onResume(this.cRe.getPageActivity());
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

    public long cBs() {
        return this.jIj;
    }

    public void cBt() {
        this.jIj = getCurrentPos();
    }

    public void xx(int i) {
        this.jIj = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cRe.getPageActivity());
        aVar.jE(R.string.confirm_title);
        aVar.sC(this.cRe.getPageActivity().getResources().getString(R.string.now_is_not_wifi));
        aVar.a(this.cRe.getPageActivity().getResources().getString(R.string.confirm), this.jEu);
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
