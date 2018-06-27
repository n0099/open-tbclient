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
    private boolean gqc;
    private boolean gqd;
    private long gqe;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.gqc = false;
        this.gqd = false;
        this.gqe = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.bmW = new a.InterfaceC0129a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0129a
            public void onLoading() {
                a.this.gmo.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0129a
            public void onPlay() {
                a.this.gmo.play();
                a.this.mStatus = 1;
            }
        };
        this.bjs = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.gmq != null) {
                    a.this.mDuration = a.this.gmq.getDuration();
                    a.this.gmo.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.bpf() > 0) {
                        mediaPlayer.seekTo((int) a.this.bpf());
                        a.this.oY(0);
                    }
                    a.this.gmo.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.gmr = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.gmo.complete();
                a.this.gmo.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.gms = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.gqd = true;
                a.this.gmo.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.bjw = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.gmo.error();
                return true;
            }
        };
        this.gmo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.gmq != null && !a.this.gmq.isPlaying()) {
                    a.this.gmo.play();
                    a.this.gmq.start();
                }
            }
        });
        this.gmo.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.error_tips) {
                    if (a.this.gmq != null) {
                        a.this.gmq.reset();
                    }
                    if (a.this.gmo != null) {
                        a.this.gmo.buffer();
                    }
                } else if ((view.getId() == d.g.play_icon || view.getId() == d.g.replay) && a.this.gmq != null && a.this.gmo != null) {
                    if (a.this.gmq.isPlaying()) {
                        a.this.gmq.pause();
                        a.this.gmo.pause();
                        a.this.gqc = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.gmo.play();
                        a.this.gmq.start();
                    } else if (a.this.gmo instanceof i) {
                        ((i) a.this.gmo).startPlay();
                    }
                    a.this.gqc = false;
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
        if (!j.jF()) {
            this.gqd = true;
            this.gmo.buffer();
            super.playVideo();
            return;
        }
        this.gqd = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.gmo.pause();
        if (this.gmq != null) {
            this.gmq.pause();
        }
        if (this.gmp != null) {
            this.gmp.onPause(this.mContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.gqc && this.gqd) {
            if (this.gmq != null && !this.gmq.isPlaying() && this.isPrepared) {
                this.gmo.play();
                this.gmq.start();
            } else if (this.gmo instanceof i) {
                ((i) this.gmo).startPlay();
            }
            if (this.gmp != null) {
                this.gmp.onResume(this.mContext.getPageActivity());
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

    public long bpf() {
        return this.gqe;
    }

    public void bpg() {
        this.gqe = getCurrentPos();
    }

    public void oY(int i) {
        this.gqe = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.cc(d.k.confirm_title);
        aVar.dE(this.mContext.getPageActivity().getResources().getString(d.k.now_is_not_wifi));
        aVar.a(this.mContext.getPageActivity().getResources().getString(d.k.confirm), this.gms);
        aVar.b(this.mContext.getPageActivity().getResources().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.mContext.getPageActivity().finish();
            }
        });
        aVar.aw(false);
        aVar.ax(false);
        aVar.b(this.mContext);
        aVar.xn();
    }
}
