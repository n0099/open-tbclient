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
    private boolean gGh;
    private boolean gGi;
    private long gGj;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.gGh = false;
        this.gGi = false;
        this.gGj = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.bxz = new a.InterfaceC0151a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0151a
            public void onLoading() {
                a.this.gCu.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0151a
            public void onPlay() {
                a.this.gCu.play();
                a.this.mStatus = 1;
            }
        };
        this.btP = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.gCw != null) {
                    a.this.mDuration = a.this.gCw.getDuration();
                    a.this.gCu.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.btG() > 0) {
                        mediaPlayer.seekTo((int) a.this.btG());
                        a.this.qp(0);
                    }
                    a.this.gCu.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.gCx = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.gCu.complete();
                a.this.gCu.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.gCy = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.gGi = true;
                a.this.gCu.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.btT = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.gCu.error();
                return true;
            }
        };
        this.gCu.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.gCw != null && !a.this.gCw.isPlaying()) {
                    a.this.gCu.play();
                    a.this.gCw.start();
                }
            }
        });
        this.gCu.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.error_tips) {
                    if (a.this.gCw != null) {
                        a.this.gCw.reset();
                    }
                    if (a.this.gCu != null) {
                        a.this.gCu.buffer();
                    }
                } else if ((view.getId() == e.g.play_icon || view.getId() == e.g.replay) && a.this.gCw != null && a.this.gCu != null) {
                    if (a.this.gCw.isPlaying()) {
                        a.this.gCw.pause();
                        a.this.gCu.pause();
                        a.this.gGh = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.gCu.play();
                        a.this.gCw.start();
                    } else if (a.this.gCu instanceof i) {
                        ((i) a.this.gCu).startPlay();
                    }
                    a.this.gGh = false;
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
        if (!j.kZ()) {
            this.gGi = true;
            this.gCu.buffer();
            super.playVideo();
            return;
        }
        this.gGi = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.gCu.pause();
        if (this.gCw != null) {
            this.gCw.pause();
        }
        if (this.gCv != null) {
            this.gCv.onPause(this.mContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.gGh && this.gGi) {
            if (this.gCw != null && !this.gCw.isPlaying() && this.isPrepared) {
                this.gCu.play();
                this.gCw.start();
            } else if (this.gCu instanceof i) {
                ((i) this.gCu).startPlay();
            }
            if (this.gCv != null) {
                this.gCv.onResume(this.mContext.getPageActivity());
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

    public long btG() {
        return this.gGj;
    }

    public void btH() {
        this.gGj = getCurrentPos();
    }

    public void qp(int i) {
        this.gGj = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.cy(e.j.confirm_title);
        aVar.ej(this.mContext.getPageActivity().getResources().getString(e.j.now_is_not_wifi));
        aVar.a(this.mContext.getPageActivity().getResources().getString(e.j.confirm), this.gCy);
        aVar.b(this.mContext.getPageActivity().getResources().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.mContext.getPageActivity().finish();
            }
        });
        aVar.aO(false);
        aVar.aP(false);
        aVar.b(this.mContext);
        aVar.Au();
    }
}
