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
    private boolean gyH;
    private boolean gyI;
    private long gyJ;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.gyH = false;
        this.gyI = false;
        this.gyJ = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.btu = new a.InterfaceC0127a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0127a
            public void onLoading() {
                a.this.guT.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0127a
            public void onPlay() {
                a.this.guT.play();
                a.this.mStatus = 1;
            }
        };
        this.bpO = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.guV != null) {
                    a.this.mDuration = a.this.guV.getDuration();
                    a.this.guT.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.bqr() > 0) {
                        mediaPlayer.seekTo((int) a.this.bqr());
                        a.this.pR(0);
                    }
                    a.this.guT.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.guW = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.guT.complete();
                a.this.guT.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.guX = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.gyI = true;
                a.this.guT.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.bpS = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.guT.error();
                return true;
            }
        };
        this.guT.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.guV != null && !a.this.guV.isPlaying()) {
                    a.this.guT.play();
                    a.this.guV.start();
                }
            }
        });
        this.guT.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.error_tips) {
                    if (a.this.guV != null) {
                        a.this.guV.reset();
                    }
                    if (a.this.guT != null) {
                        a.this.guT.buffer();
                    }
                } else if ((view.getId() == e.g.play_icon || view.getId() == e.g.replay) && a.this.guV != null && a.this.guT != null) {
                    if (a.this.guV.isPlaying()) {
                        a.this.guV.pause();
                        a.this.guT.pause();
                        a.this.gyH = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.guT.play();
                        a.this.guV.start();
                    } else if (a.this.guT instanceof i) {
                        ((i) a.this.guT).startPlay();
                    }
                    a.this.gyH = false;
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
        if (!j.kM()) {
            this.gyI = true;
            this.guT.buffer();
            super.playVideo();
            return;
        }
        this.gyI = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.guT.pause();
        if (this.guV != null) {
            this.guV.pause();
        }
        if (this.guU != null) {
            this.guU.onPause(this.mContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.gyH && this.gyI) {
            if (this.guV != null && !this.guV.isPlaying() && this.isPrepared) {
                this.guT.play();
                this.guV.start();
            } else if (this.guT instanceof i) {
                ((i) this.guT).startPlay();
            }
            if (this.guU != null) {
                this.guU.onResume(this.mContext.getPageActivity());
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

    public long bqr() {
        return this.gyJ;
    }

    public void bqs() {
        this.gyJ = getCurrentPos();
    }

    public void pR(int i) {
        this.gyJ = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.co(e.j.confirm_title);
        aVar.dT(this.mContext.getPageActivity().getResources().getString(e.j.now_is_not_wifi));
        aVar.a(this.mContext.getPageActivity().getResources().getString(e.j.confirm), this.guX);
        aVar.b(this.mContext.getPageActivity().getResources().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.mContext.getPageActivity().finish();
            }
        });
        aVar.aE(false);
        aVar.aF(false);
        aVar.b(this.mContext);
        aVar.yl();
    }
}
