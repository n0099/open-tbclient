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
    private boolean gSv;
    private boolean gSw;
    private long gSx;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.gSv = false;
        this.gSw = false;
        this.gSx = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.bCy = new a.InterfaceC0185a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0185a
            public void onLoading() {
                a.this.gOI.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0185a
            public void onPlay() {
                a.this.gOI.play();
                a.this.mStatus = 1;
            }
        };
        this.byR = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.gOK != null) {
                    a.this.mDuration = a.this.gOK.getDuration();
                    a.this.gOI.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.bwp() > 0) {
                        mediaPlayer.seekTo((int) a.this.bwp());
                        a.this.rr(0);
                    }
                    a.this.gOI.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.gOL = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.gOI.complete();
                a.this.gOI.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.gOM = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.gSw = true;
                a.this.gOI.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.byV = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.gOI.error();
                return true;
            }
        };
        this.gOI.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.gOK != null && !a.this.gOK.isPlaying()) {
                    a.this.gOI.play();
                    a.this.gOK.start();
                }
            }
        });
        this.gOI.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.error_tips) {
                    if (a.this.gOK != null) {
                        a.this.gOK.reset();
                    }
                    if (a.this.gOI != null) {
                        a.this.gOI.buffer();
                    }
                } else if ((view.getId() == e.g.play_icon || view.getId() == e.g.replay) && a.this.gOK != null && a.this.gOI != null) {
                    if (a.this.gOK.isPlaying()) {
                        a.this.gOK.pause();
                        a.this.gOI.pause();
                        a.this.gSv = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.gOI.play();
                        a.this.gOK.start();
                    } else if (a.this.gOI instanceof i) {
                        ((i) a.this.gOI).startPlay();
                    }
                    a.this.gSv = false;
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
            this.gSw = true;
            this.gOI.buffer();
            super.playVideo();
            return;
        }
        this.gSw = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.gOI.pause();
        if (this.gOK != null) {
            this.gOK.pause();
        }
        if (this.gOJ != null) {
            this.gOJ.onPause(this.mContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.gSv && this.gSw) {
            if (this.gOK != null && !this.gOK.isPlaying() && this.isPrepared) {
                this.gOI.play();
                this.gOK.start();
            } else if (this.gOI instanceof i) {
                ((i) this.gOI).startPlay();
            }
            if (this.gOJ != null) {
                this.gOJ.onResume(this.mContext.getPageActivity());
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

    public long bwp() {
        return this.gSx;
    }

    public void bwq() {
        this.gSx = getCurrentPos();
    }

    public void rr(int i) {
        this.gSx = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.da(e.j.confirm_title);
        aVar.eK(this.mContext.getPageActivity().getResources().getString(e.j.now_is_not_wifi));
        aVar.a(this.mContext.getPageActivity().getResources().getString(e.j.confirm), this.gOM);
        aVar.b(this.mContext.getPageActivity().getResources().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.mContext.getPageActivity().finish();
            }
        });
        aVar.bg(false);
        aVar.bh(false);
        aVar.b(this.mContext);
        aVar.BS();
    }
}
