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
    private boolean ijS;
    private boolean ijT;
    private long ijU;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.ijS = false;
        this.ijT = false;
        this.ijU = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.cNC = new a.InterfaceC0253a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0253a
            public void onLoading() {
                a.this.igi.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0253a
            public void onPlay() {
                a.this.igi.play();
                a.this.mStatus = 1;
            }
        };
        this.bai = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.igk != null) {
                    a.this.mDuration = a.this.igk.getDuration();
                    a.this.igi.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.bXf() > 0) {
                        mediaPlayer.seekTo((int) a.this.bXf());
                        a.this.va(0);
                    }
                    a.this.igi.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.igl = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.igi.complete();
                a.this.igi.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.igm = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.ijT = true;
                a.this.igi.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.bax = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.igi.error();
                return true;
            }
        };
        this.igi.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.igk != null && !a.this.igk.isPlaying()) {
                    a.this.igi.play();
                    a.this.igk.start();
                }
            }
        });
        this.igi.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.error_tips) {
                    if (a.this.igk != null) {
                        a.this.igk.reset();
                    }
                    if (a.this.igi != null) {
                        a.this.igi.buffer();
                    }
                } else if ((view.getId() == d.g.play_icon || view.getId() == d.g.replay) && a.this.igk != null && a.this.igi != null) {
                    if (a.this.igk.isPlaying()) {
                        a.this.igk.pause();
                        a.this.igi.pause();
                        a.this.ijS = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.igi.play();
                        a.this.igk.start();
                    } else if (a.this.igi instanceof i) {
                        ((i) a.this.igi).startPlay();
                    }
                    a.this.ijS = false;
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
            this.ijT = true;
            this.igi.buffer();
            super.playVideo();
            return;
        }
        this.ijT = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.igi.pause();
        if (this.igk != null) {
            this.igk.pause();
        }
        if (this.igj != null) {
            this.igj.onPause(this.mContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.ijS && this.ijT) {
            if (this.igk != null && !this.igk.isPlaying() && this.isPrepared) {
                this.igi.play();
                this.igk.start();
            } else if (this.igi instanceof i) {
                ((i) this.igi).startPlay();
            }
            if (this.igj != null) {
                this.igj.onResume(this.mContext.getPageActivity());
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

    public long bXf() {
        return this.ijU;
    }

    public void bXg() {
        this.ijU = getCurrentPos();
    }

    public void va(int i) {
        this.ijU = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.gC(d.j.confirm_title);
        aVar.ly(this.mContext.getPageActivity().getResources().getString(d.j.now_is_not_wifi));
        aVar.a(this.mContext.getPageActivity().getResources().getString(d.j.confirm), this.igm);
        aVar.b(this.mContext.getPageActivity().getResources().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.mContext.getPageActivity().finish();
            }
        });
        aVar.dq(false);
        aVar.dr(false);
        aVar.b(this.mContext);
        aVar.aaZ();
    }
}
