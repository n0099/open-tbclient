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
    private boolean ijF;
    private boolean ijG;
    private long ijH;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.ijF = false;
        this.ijG = false;
        this.ijH = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.cNF = new a.InterfaceC0253a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0253a
            public void onLoading() {
                a.this.ifV.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0253a
            public void onPlay() {
                a.this.ifV.play();
                a.this.mStatus = 1;
            }
        };
        this.bam = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.ifX != null) {
                    a.this.mDuration = a.this.ifX.getDuration();
                    a.this.ifV.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.bXb() > 0) {
                        mediaPlayer.seekTo((int) a.this.bXb());
                        a.this.uW(0);
                    }
                    a.this.ifV.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.ifY = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.ifV.complete();
                a.this.ifV.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.ifZ = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.ijG = true;
                a.this.ifV.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.baB = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.ifV.error();
                return true;
            }
        };
        this.ifV.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.ifX != null && !a.this.ifX.isPlaying()) {
                    a.this.ifV.play();
                    a.this.ifX.start();
                }
            }
        });
        this.ifV.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.error_tips) {
                    if (a.this.ifX != null) {
                        a.this.ifX.reset();
                    }
                    if (a.this.ifV != null) {
                        a.this.ifV.buffer();
                    }
                } else if ((view.getId() == d.g.play_icon || view.getId() == d.g.replay) && a.this.ifX != null && a.this.ifV != null) {
                    if (a.this.ifX.isPlaying()) {
                        a.this.ifX.pause();
                        a.this.ifV.pause();
                        a.this.ijF = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.ifV.play();
                        a.this.ifX.start();
                    } else if (a.this.ifV instanceof i) {
                        ((i) a.this.ifV).startPlay();
                    }
                    a.this.ijF = false;
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
            this.ijG = true;
            this.ifV.buffer();
            super.playVideo();
            return;
        }
        this.ijG = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.ifV.pause();
        if (this.ifX != null) {
            this.ifX.pause();
        }
        if (this.ifW != null) {
            this.ifW.onPause(this.mContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.ijF && this.ijG) {
            if (this.ifX != null && !this.ifX.isPlaying() && this.isPrepared) {
                this.ifV.play();
                this.ifX.start();
            } else if (this.ifV instanceof i) {
                ((i) this.ifV).startPlay();
            }
            if (this.ifW != null) {
                this.ifW.onResume(this.mContext.getPageActivity());
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
        return this.ijH;
    }

    public void bXc() {
        this.ijH = getCurrentPos();
    }

    public void uW(int i) {
        this.ijH = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.gB(d.j.confirm_title);
        aVar.lz(this.mContext.getPageActivity().getResources().getString(d.j.now_is_not_wifi));
        aVar.a(this.mContext.getPageActivity().getResources().getString(d.j.confirm), this.ifZ);
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
