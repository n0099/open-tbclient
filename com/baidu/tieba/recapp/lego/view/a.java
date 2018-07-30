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
    private boolean grm;
    private boolean grn;
    private long gro;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.grm = false;
        this.grn = false;
        this.gro = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.bnC = new a.InterfaceC0127a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0127a
            public void onLoading() {
                a.this.gny.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0127a
            public void onPlay() {
                a.this.gny.play();
                a.this.mStatus = 1;
            }
        };
        this.bjX = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.gnA != null) {
                    a.this.mDuration = a.this.gnA.getDuration();
                    a.this.gny.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.bnJ() > 0) {
                        mediaPlayer.seekTo((int) a.this.bnJ());
                        a.this.pn(0);
                    }
                    a.this.gny.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.gnB = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.gny.complete();
                a.this.gny.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.gnC = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.grn = true;
                a.this.gny.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.bkb = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.gny.error();
                return true;
            }
        };
        this.gny.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.gnA != null && !a.this.gnA.isPlaying()) {
                    a.this.gny.play();
                    a.this.gnA.start();
                }
            }
        });
        this.gny.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.error_tips) {
                    if (a.this.gnA != null) {
                        a.this.gnA.reset();
                    }
                    if (a.this.gny != null) {
                        a.this.gny.buffer();
                    }
                } else if ((view.getId() == d.g.play_icon || view.getId() == d.g.replay) && a.this.gnA != null && a.this.gny != null) {
                    if (a.this.gnA.isPlaying()) {
                        a.this.gnA.pause();
                        a.this.gny.pause();
                        a.this.grm = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.gny.play();
                        a.this.gnA.start();
                    } else if (a.this.gny instanceof i) {
                        ((i) a.this.gny).startPlay();
                    }
                    a.this.grm = false;
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
        if (!j.jG()) {
            this.grn = true;
            this.gny.buffer();
            super.playVideo();
            return;
        }
        this.grn = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.gny.pause();
        if (this.gnA != null) {
            this.gnA.pause();
        }
        if (this.gnz != null) {
            this.gnz.onPause(this.mContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.grm && this.grn) {
            if (this.gnA != null && !this.gnA.isPlaying() && this.isPrepared) {
                this.gny.play();
                this.gnA.start();
            } else if (this.gny instanceof i) {
                ((i) this.gny).startPlay();
            }
            if (this.gnz != null) {
                this.gnz.onResume(this.mContext.getPageActivity());
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

    public long bnJ() {
        return this.gro;
    }

    public void bnK() {
        this.gro = getCurrentPos();
    }

    public void pn(int i) {
        this.gro = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.ce(d.j.confirm_title);
        aVar.dB(this.mContext.getPageActivity().getResources().getString(d.j.now_is_not_wifi));
        aVar.a(this.mContext.getPageActivity().getResources().getString(d.j.confirm), this.gnC);
        aVar.b(this.mContext.getPageActivity().getResources().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.mContext.getPageActivity().finish();
            }
        });
        aVar.au(false);
        aVar.av(false);
        aVar.b(this.mContext);
        aVar.xf();
    }
}
