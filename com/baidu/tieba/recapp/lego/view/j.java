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
    private boolean gFc;
    private boolean gFd;
    private long gFe;
    public boolean isPrepared;
    private int mDuration;

    public j(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.gFc = false;
        this.gFd = false;
        this.gFe = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.bTs = new a.InterfaceC0123a() { // from class: com.baidu.tieba.recapp.lego.view.j.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0123a
            public void onLoading() {
                j.this.gBn.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0123a
            public void onPlay() {
                j.this.gBn.play();
                j.this.mStatus = 1;
            }
        };
        this.bPT = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.j.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && j.this.gBp != null) {
                    j.this.mDuration = j.this.gBp.getDuration();
                    j.this.gBn.setSeekBarTime(0, j.this.mDuration);
                    if (j.this.boA() > 0) {
                        mediaPlayer.seekTo((int) j.this.boA());
                        j.this.rk(0);
                    }
                    j.this.gBn.play();
                    j.this.isPrepared = true;
                }
            }
        };
        this.gBq = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.j.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                j.this.stopPlay();
                j.this.gBn.complete();
                j.this.gBn.setSeekBarTime(0, j.this.mDuration);
            }
        };
        this.gBr = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.j.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                j.this.gFd = true;
                j.this.gBn.play();
                j.this.playVideo();
                aVar.dismiss();
            }
        };
        this.bPX = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.j.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                j.this.stopPlay();
                j.this.gBn.error();
                return true;
            }
        };
        this.gBn.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.j.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (j.this.gBp != null && !j.this.gBp.isPlaying()) {
                    j.this.gBn.play();
                    j.this.gBp.start();
                }
            }
        });
        this.gBn.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.j.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.error_tips) {
                    if (j.this.gBp != null) {
                        j.this.gBp.reset();
                    }
                    if (j.this.gBn != null) {
                        j.this.gBn.buffer();
                    }
                } else if ((view.getId() == d.g.play_icon || view.getId() == d.g.replay) && j.this.gBp != null && j.this.gBn != null) {
                    if (j.this.gBp.isPlaying()) {
                        j.this.gBp.pause();
                        j.this.gBn.pause();
                        j.this.gFc = true;
                        return;
                    }
                    if (j.this.isPrepared) {
                        j.this.gBn.play();
                        j.this.gBp.start();
                    } else if (j.this.gBn instanceof com.baidu.tieba.recapp.i) {
                        ((com.baidu.tieba.recapp.i) j.this.gBn).startPlay();
                    }
                    j.this.gFc = false;
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
            this.gFd = true;
            this.gBn.buffer();
            super.playVideo();
            return;
        }
        this.gFd = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.gBn.pause();
        if (this.gBp != null) {
            this.gBp.pause();
        }
        if (this.gBo != null) {
            this.gBo.onPause(this.aRR.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.gFc && this.gFd) {
            if (this.gBp != null && !this.gBp.isPlaying() && this.isPrepared) {
                this.gBn.play();
                this.gBp.start();
            } else if (this.gBn instanceof com.baidu.tieba.recapp.i) {
                ((com.baidu.tieba.recapp.i) this.gBn).startPlay();
            }
            if (this.gBo != null) {
                this.gBo.onResume(this.aRR.getPageActivity());
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

    public long boA() {
        return this.gFe;
    }

    public void boB() {
        this.gFe = getCurrentPos();
    }

    public void rk(int i) {
        this.gFe = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRR.getPageActivity());
        aVar.fa(d.j.confirm_title);
        aVar.dk(this.aRR.getPageActivity().getResources().getString(d.j.now_is_not_wifi));
        aVar.a(this.aRR.getPageActivity().getResources().getString(d.j.confirm), this.gBr);
        aVar.b(this.aRR.getPageActivity().getResources().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.j.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                j.this.aRR.getPageActivity().finish();
            }
        });
        aVar.aZ(false);
        aVar.ba(false);
        aVar.b(this.aRR);
        aVar.AU();
    }
}
