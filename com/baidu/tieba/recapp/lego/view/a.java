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
    private boolean gSu;
    private boolean gSv;
    private long gSw;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.gSu = false;
        this.gSv = false;
        this.gSw = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.bCx = new a.InterfaceC0185a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0185a
            public void onLoading() {
                a.this.gOH.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0185a
            public void onPlay() {
                a.this.gOH.play();
                a.this.mStatus = 1;
            }
        };
        this.byQ = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.gOJ != null) {
                    a.this.mDuration = a.this.gOJ.getDuration();
                    a.this.gOH.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.bwp() > 0) {
                        mediaPlayer.seekTo((int) a.this.bwp());
                        a.this.rr(0);
                    }
                    a.this.gOH.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.gOK = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.gOH.complete();
                a.this.gOH.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.gOL = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.gSv = true;
                a.this.gOH.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.byU = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.gOH.error();
                return true;
            }
        };
        this.gOH.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.gOJ != null && !a.this.gOJ.isPlaying()) {
                    a.this.gOH.play();
                    a.this.gOJ.start();
                }
            }
        });
        this.gOH.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.error_tips) {
                    if (a.this.gOJ != null) {
                        a.this.gOJ.reset();
                    }
                    if (a.this.gOH != null) {
                        a.this.gOH.buffer();
                    }
                } else if ((view.getId() == e.g.play_icon || view.getId() == e.g.replay) && a.this.gOJ != null && a.this.gOH != null) {
                    if (a.this.gOJ.isPlaying()) {
                        a.this.gOJ.pause();
                        a.this.gOH.pause();
                        a.this.gSu = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.gOH.play();
                        a.this.gOJ.start();
                    } else if (a.this.gOH instanceof i) {
                        ((i) a.this.gOH).startPlay();
                    }
                    a.this.gSu = false;
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
            this.gSv = true;
            this.gOH.buffer();
            super.playVideo();
            return;
        }
        this.gSv = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.gOH.pause();
        if (this.gOJ != null) {
            this.gOJ.pause();
        }
        if (this.gOI != null) {
            this.gOI.onPause(this.mContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.gSu && this.gSv) {
            if (this.gOJ != null && !this.gOJ.isPlaying() && this.isPrepared) {
                this.gOH.play();
                this.gOJ.start();
            } else if (this.gOH instanceof i) {
                ((i) this.gOH).startPlay();
            }
            if (this.gOI != null) {
                this.gOI.onResume(this.mContext.getPageActivity());
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
        return this.gSw;
    }

    public void bwq() {
        this.gSw = getCurrentPos();
    }

    public void rr(int i) {
        this.gSw = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.da(e.j.confirm_title);
        aVar.eK(this.mContext.getPageActivity().getResources().getString(e.j.now_is_not_wifi));
        aVar.a(this.mContext.getPageActivity().getResources().getString(e.j.confirm), this.gOL);
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
