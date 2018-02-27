package com.baidu.tieba.recapp.lego.view;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.SeekBar;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.ad.play.a;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.view.IVrPlayView;
/* loaded from: classes3.dex */
public class j extends com.baidu.tieba.recapp.a {
    private boolean gEN;
    private boolean gEO;
    private long gEP;
    public boolean isPrepared;
    private int mDuration;

    public j(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.gEN = false;
        this.gEO = false;
        this.gEP = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.bTg = new a.InterfaceC0124a() { // from class: com.baidu.tieba.recapp.lego.view.j.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0124a
            public void onLoading() {
                j.this.gAY.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0124a
            public void onPlay() {
                j.this.gAY.play();
                j.this.mStatus = 1;
            }
        };
        this.bPG = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.j.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && j.this.gBa != null) {
                    j.this.mDuration = j.this.gBa.getDuration();
                    j.this.gAY.setSeekBarTime(0, j.this.mDuration);
                    if (j.this.boz() > 0) {
                        mediaPlayer.seekTo((int) j.this.boz());
                        j.this.rl(0);
                    }
                    j.this.gAY.play();
                    j.this.isPrepared = true;
                }
            }
        };
        this.gBb = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.j.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                j.this.stopPlay();
                j.this.gAY.complete();
                j.this.gAY.setSeekBarTime(0, j.this.mDuration);
            }
        };
        this.gBc = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.j.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                j.this.gEO = true;
                j.this.gAY.play();
                j.this.playVideo();
                aVar.dismiss();
            }
        };
        this.bPK = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.j.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                j.this.stopPlay();
                j.this.gAY.error();
                return true;
            }
        };
        this.gAY.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.j.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (j.this.gBa != null && !j.this.gBa.isPlaying()) {
                    j.this.gAY.play();
                    j.this.gBa.start();
                }
            }
        });
        this.gAY.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.j.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.error_tips) {
                    if (j.this.gBa != null) {
                        j.this.gBa.reset();
                    }
                    if (j.this.gAY != null) {
                        j.this.gAY.buffer();
                    }
                } else if ((view.getId() == d.g.play_icon || view.getId() == d.g.replay) && j.this.gBa != null && j.this.gAY != null) {
                    if (j.this.gBa.isPlaying()) {
                        j.this.gBa.pause();
                        j.this.gAY.pause();
                        j.this.gEN = true;
                        return;
                    }
                    if (j.this.isPrepared) {
                        j.this.gAY.play();
                        j.this.gBa.start();
                    } else if (j.this.gAY instanceof com.baidu.tieba.recapp.i) {
                        ((com.baidu.tieba.recapp.i) j.this.gAY).startPlay();
                    }
                    j.this.gEN = false;
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
        if (!com.baidu.adp.lib.util.j.oL()) {
            this.gEO = true;
            this.gAY.buffer();
            super.playVideo();
            return;
        }
        this.gEO = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.gAY.pause();
        if (this.gBa != null) {
            this.gBa.pause();
        }
        if (this.gAZ != null) {
            this.gAZ.onPause(this.aRG.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.gEN && this.gEO) {
            if (this.gBa != null && !this.gBa.isPlaying() && this.isPrepared) {
                this.gAY.play();
                this.gBa.start();
            } else if (this.gAY instanceof com.baidu.tieba.recapp.i) {
                ((com.baidu.tieba.recapp.i) this.gAY).startPlay();
            }
            if (this.gAZ != null) {
                this.gAZ.onResume(this.aRG.getPageActivity());
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

    public long boz() {
        return this.gEP;
    }

    public void boA() {
        this.gEP = getCurrentPos();
    }

    public void rl(int i) {
        this.gEP = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRG.getPageActivity());
        aVar.fa(d.j.confirm_title);
        aVar.dk(this.aRG.getPageActivity().getResources().getString(d.j.now_is_not_wifi));
        aVar.a(this.aRG.getPageActivity().getResources().getString(d.j.confirm), this.gBc);
        aVar.b(this.aRG.getPageActivity().getResources().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.j.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                j.this.aRG.getPageActivity().finish();
            }
        });
        aVar.aZ(false);
        aVar.ba(false);
        aVar.b(this.aRG);
        aVar.AU();
    }
}
