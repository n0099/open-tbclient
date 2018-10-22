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
    private boolean gGi;
    private boolean gGj;
    private long gGk;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.gGi = false;
        this.gGj = false;
        this.gGk = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.bxz = new a.InterfaceC0151a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0151a
            public void onLoading() {
                a.this.gCv.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0151a
            public void onPlay() {
                a.this.gCv.play();
                a.this.mStatus = 1;
            }
        };
        this.btP = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.gCx != null) {
                    a.this.mDuration = a.this.gCx.getDuration();
                    a.this.gCv.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.btG() > 0) {
                        mediaPlayer.seekTo((int) a.this.btG());
                        a.this.qp(0);
                    }
                    a.this.gCv.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.gCy = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.gCv.complete();
                a.this.gCv.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.gCz = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.gGj = true;
                a.this.gCv.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.btT = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.gCv.error();
                return true;
            }
        };
        this.gCv.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.gCx != null && !a.this.gCx.isPlaying()) {
                    a.this.gCv.play();
                    a.this.gCx.start();
                }
            }
        });
        this.gCv.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.error_tips) {
                    if (a.this.gCx != null) {
                        a.this.gCx.reset();
                    }
                    if (a.this.gCv != null) {
                        a.this.gCv.buffer();
                    }
                } else if ((view.getId() == e.g.play_icon || view.getId() == e.g.replay) && a.this.gCx != null && a.this.gCv != null) {
                    if (a.this.gCx.isPlaying()) {
                        a.this.gCx.pause();
                        a.this.gCv.pause();
                        a.this.gGi = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.gCv.play();
                        a.this.gCx.start();
                    } else if (a.this.gCv instanceof i) {
                        ((i) a.this.gCv).startPlay();
                    }
                    a.this.gGi = false;
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
            this.gGj = true;
            this.gCv.buffer();
            super.playVideo();
            return;
        }
        this.gGj = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.gCv.pause();
        if (this.gCx != null) {
            this.gCx.pause();
        }
        if (this.gCw != null) {
            this.gCw.onPause(this.mContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.gGi && this.gGj) {
            if (this.gCx != null && !this.gCx.isPlaying() && this.isPrepared) {
                this.gCv.play();
                this.gCx.start();
            } else if (this.gCv instanceof i) {
                ((i) this.gCv).startPlay();
            }
            if (this.gCw != null) {
                this.gCw.onResume(this.mContext.getPageActivity());
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
        return this.gGk;
    }

    public void btH() {
        this.gGk = getCurrentPos();
    }

    public void qp(int i) {
        this.gGk = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.cy(e.j.confirm_title);
        aVar.ej(this.mContext.getPageActivity().getResources().getString(e.j.now_is_not_wifi));
        aVar.a(this.mContext.getPageActivity().getResources().getString(e.j.confirm), this.gCz);
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
