package com.baidu.tieba.recapp.lego.view;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.SeekBar;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.ad.play.a;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.view.IVrPlayView;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.recapp.a {
    private boolean gOA;
    private long gOB;
    private boolean gOz;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.gOz = false;
        this.gOA = false;
        this.gOB = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.bBH = new a.InterfaceC0185a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0185a
            public void onLoading() {
                a.this.gKM.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0185a
            public void onPlay() {
                a.this.gKM.play();
                a.this.mStatus = 1;
            }
        };
        this.bxZ = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.gKO != null) {
                    a.this.mDuration = a.this.gKO.getDuration();
                    a.this.gKM.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.buU() > 0) {
                        mediaPlayer.seekTo((int) a.this.buU());
                        a.this.rc(0);
                    }
                    a.this.gKM.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.gKP = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.gKM.complete();
                a.this.gKM.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.gKQ = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.gOA = true;
                a.this.gKM.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.byd = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.gKM.error();
                return true;
            }
        };
        this.gKM.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.gKO != null && !a.this.gKO.isPlaying()) {
                    a.this.gKM.play();
                    a.this.gKO.start();
                }
            }
        });
        this.gKM.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.error_tips) {
                    if (a.this.gKO != null) {
                        a.this.gKO.reset();
                    }
                    if (a.this.gKM != null) {
                        a.this.gKM.buffer();
                    }
                } else if ((view.getId() == e.g.play_icon || view.getId() == e.g.replay) && a.this.gKO != null && a.this.gKM != null) {
                    if (a.this.gKO.isPlaying()) {
                        a.this.gKO.pause();
                        a.this.gKM.pause();
                        a.this.gOz = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.gKM.play();
                        a.this.gKO.start();
                    } else if (a.this.gKM instanceof i) {
                        ((i) a.this.gKM).startPlay();
                    }
                    a.this.gOz = false;
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
        if (!j.kX()) {
            this.gOA = true;
            this.gKM.buffer();
            super.playVideo();
            return;
        }
        this.gOA = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.gKM.pause();
        if (this.gKO != null) {
            this.gKO.pause();
        }
        if (this.gKN != null) {
            this.gKN.onPause(this.mContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.gOz && this.gOA) {
            if (this.gKO != null && !this.gKO.isPlaying() && this.isPrepared) {
                this.gKM.play();
                this.gKO.start();
            } else if (this.gKM instanceof i) {
                ((i) this.gKM).startPlay();
            }
            if (this.gKN != null) {
                this.gKN.onResume(this.mContext.getPageActivity());
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

    public long buU() {
        return this.gOB;
    }

    public void buV() {
        this.gOB = getCurrentPos();
    }

    public void rc(int i) {
        this.gOB = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.da(e.j.confirm_title);
        aVar.eB(this.mContext.getPageActivity().getResources().getString(e.j.now_is_not_wifi));
        aVar.a(this.mContext.getPageActivity().getResources().getString(e.j.confirm), this.gKQ);
        aVar.b(this.mContext.getPageActivity().getResources().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.mContext.getPageActivity().finish();
            }
        });
        aVar.bf(false);
        aVar.bg(false);
        aVar.b(this.mContext);
        aVar.BF();
    }
}
