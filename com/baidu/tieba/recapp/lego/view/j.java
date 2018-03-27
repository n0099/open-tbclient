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
    private boolean gFd;
    private boolean gFe;
    private long gFf;
    public boolean isPrepared;
    private int mDuration;

    public j(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.gFd = false;
        this.gFe = false;
        this.gFf = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.bTj = new a.InterfaceC0124a() { // from class: com.baidu.tieba.recapp.lego.view.j.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0124a
            public void onLoading() {
                j.this.gBo.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0124a
            public void onPlay() {
                j.this.gBo.play();
                j.this.mStatus = 1;
            }
        };
        this.bPJ = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.j.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && j.this.gBq != null) {
                    j.this.mDuration = j.this.gBq.getDuration();
                    j.this.gBo.setSeekBarTime(0, j.this.mDuration);
                    if (j.this.boA() > 0) {
                        mediaPlayer.seekTo((int) j.this.boA());
                        j.this.rl(0);
                    }
                    j.this.gBo.play();
                    j.this.isPrepared = true;
                }
            }
        };
        this.gBr = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.j.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                j.this.stopPlay();
                j.this.gBo.complete();
                j.this.gBo.setSeekBarTime(0, j.this.mDuration);
            }
        };
        this.gBs = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.j.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                j.this.gFe = true;
                j.this.gBo.play();
                j.this.playVideo();
                aVar.dismiss();
            }
        };
        this.bPN = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.j.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                j.this.stopPlay();
                j.this.gBo.error();
                return true;
            }
        };
        this.gBo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.j.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (j.this.gBq != null && !j.this.gBq.isPlaying()) {
                    j.this.gBo.play();
                    j.this.gBq.start();
                }
            }
        });
        this.gBo.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.j.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.error_tips) {
                    if (j.this.gBq != null) {
                        j.this.gBq.reset();
                    }
                    if (j.this.gBo != null) {
                        j.this.gBo.buffer();
                    }
                } else if ((view.getId() == d.g.play_icon || view.getId() == d.g.replay) && j.this.gBq != null && j.this.gBo != null) {
                    if (j.this.gBq.isPlaying()) {
                        j.this.gBq.pause();
                        j.this.gBo.pause();
                        j.this.gFd = true;
                        return;
                    }
                    if (j.this.isPrepared) {
                        j.this.gBo.play();
                        j.this.gBq.start();
                    } else if (j.this.gBo instanceof com.baidu.tieba.recapp.i) {
                        ((com.baidu.tieba.recapp.i) j.this.gBo).startPlay();
                    }
                    j.this.gFd = false;
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
            this.gFe = true;
            this.gBo.buffer();
            super.playVideo();
            return;
        }
        this.gFe = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.gBo.pause();
        if (this.gBq != null) {
            this.gBq.pause();
        }
        if (this.gBp != null) {
            this.gBp.onPause(this.aRI.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.gFd && this.gFe) {
            if (this.gBq != null && !this.gBq.isPlaying() && this.isPrepared) {
                this.gBo.play();
                this.gBq.start();
            } else if (this.gBo instanceof com.baidu.tieba.recapp.i) {
                ((com.baidu.tieba.recapp.i) this.gBo).startPlay();
            }
            if (this.gBp != null) {
                this.gBp.onResume(this.aRI.getPageActivity());
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
        return this.gFf;
    }

    public void boB() {
        this.gFf = getCurrentPos();
    }

    public void rl(int i) {
        this.gFf = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRI.getPageActivity());
        aVar.fa(d.j.confirm_title);
        aVar.dk(this.aRI.getPageActivity().getResources().getString(d.j.now_is_not_wifi));
        aVar.a(this.aRI.getPageActivity().getResources().getString(d.j.confirm), this.gBs);
        aVar.b(this.aRI.getPageActivity().getResources().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.j.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                j.this.aRI.getPageActivity().finish();
            }
        });
        aVar.aZ(false);
        aVar.ba(false);
        aVar.b(this.aRI);
        aVar.AV();
    }
}
