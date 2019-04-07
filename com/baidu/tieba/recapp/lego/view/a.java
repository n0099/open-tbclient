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
    private boolean ijE;
    private boolean ijF;
    private long ijG;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.ijE = false;
        this.ijF = false;
        this.ijG = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.cNE = new a.InterfaceC0253a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0253a
            public void onLoading() {
                a.this.ifU.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0253a
            public void onPlay() {
                a.this.ifU.play();
                a.this.mStatus = 1;
            }
        };
        this.bal = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.ifW != null) {
                    a.this.mDuration = a.this.ifW.getDuration();
                    a.this.ifU.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.bXb() > 0) {
                        mediaPlayer.seekTo((int) a.this.bXb());
                        a.this.uW(0);
                    }
                    a.this.ifU.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.ifX = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.ifU.complete();
                a.this.ifU.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.ifY = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.ijF = true;
                a.this.ifU.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.baA = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.ifU.error();
                return true;
            }
        };
        this.ifU.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.ifW != null && !a.this.ifW.isPlaying()) {
                    a.this.ifU.play();
                    a.this.ifW.start();
                }
            }
        });
        this.ifU.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.error_tips) {
                    if (a.this.ifW != null) {
                        a.this.ifW.reset();
                    }
                    if (a.this.ifU != null) {
                        a.this.ifU.buffer();
                    }
                } else if ((view.getId() == d.g.play_icon || view.getId() == d.g.replay) && a.this.ifW != null && a.this.ifU != null) {
                    if (a.this.ifW.isPlaying()) {
                        a.this.ifW.pause();
                        a.this.ifU.pause();
                        a.this.ijE = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.ifU.play();
                        a.this.ifW.start();
                    } else if (a.this.ifU instanceof i) {
                        ((i) a.this.ifU).startPlay();
                    }
                    a.this.ijE = false;
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
        if (!j.la()) {
            this.ijF = true;
            this.ifU.buffer();
            super.playVideo();
            return;
        }
        this.ijF = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.ifU.pause();
        if (this.ifW != null) {
            this.ifW.pause();
        }
        if (this.ifV != null) {
            this.ifV.onPause(this.mContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.ijE && this.ijF) {
            if (this.ifW != null && !this.ifW.isPlaying() && this.isPrepared) {
                this.ifU.play();
                this.ifW.start();
            } else if (this.ifU instanceof i) {
                ((i) this.ifU).startPlay();
            }
            if (this.ifV != null) {
                this.ifV.onResume(this.mContext.getPageActivity());
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

    public long bXb() {
        return this.ijG;
    }

    public void bXc() {
        this.ijG = getCurrentPos();
    }

    public void uW(int i) {
        this.ijG = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.gB(d.j.confirm_title);
        aVar.lz(this.mContext.getPageActivity().getResources().getString(d.j.now_is_not_wifi));
        aVar.a(this.mContext.getPageActivity().getResources().getString(d.j.confirm), this.ifY);
        aVar.b(this.mContext.getPageActivity().getResources().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.mContext.getPageActivity().finish();
            }
        });
        aVar.dq(false);
        aVar.dr(false);
        aVar.b(this.mContext);
        aVar.aaW();
    }
}
