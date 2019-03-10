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
    private boolean ijZ;
    private boolean ika;
    private long ikb;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.ijZ = false;
        this.ika = false;
        this.ikb = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.cNF = new a.InterfaceC0219a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0219a
            public void onLoading() {
                a.this.igo.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0219a
            public void onPlay() {
                a.this.igo.play();
                a.this.mStatus = 1;
            }
        };
        this.bah = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.igq != null) {
                    a.this.mDuration = a.this.igq.getDuration();
                    a.this.igo.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.bXd() > 0) {
                        mediaPlayer.seekTo((int) a.this.bXd());
                        a.this.va(0);
                    }
                    a.this.igo.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.igr = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.igo.complete();
                a.this.igo.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.igs = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.ika = true;
                a.this.igo.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.baw = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.igo.error();
                return true;
            }
        };
        this.igo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.igq != null && !a.this.igq.isPlaying()) {
                    a.this.igo.play();
                    a.this.igq.start();
                }
            }
        });
        this.igo.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.error_tips) {
                    if (a.this.igq != null) {
                        a.this.igq.reset();
                    }
                    if (a.this.igo != null) {
                        a.this.igo.buffer();
                    }
                } else if ((view.getId() == d.g.play_icon || view.getId() == d.g.replay) && a.this.igq != null && a.this.igo != null) {
                    if (a.this.igq.isPlaying()) {
                        a.this.igq.pause();
                        a.this.igo.pause();
                        a.this.ijZ = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.igo.play();
                        a.this.igq.start();
                    } else if (a.this.igo instanceof i) {
                        ((i) a.this.igo).startPlay();
                    }
                    a.this.ijZ = false;
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
            this.ika = true;
            this.igo.buffer();
            super.playVideo();
            return;
        }
        this.ika = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.igo.pause();
        if (this.igq != null) {
            this.igq.pause();
        }
        if (this.igp != null) {
            this.igp.onPause(this.mContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.ijZ && this.ika) {
            if (this.igq != null && !this.igq.isPlaying() && this.isPrepared) {
                this.igo.play();
                this.igq.start();
            } else if (this.igo instanceof i) {
                ((i) this.igo).startPlay();
            }
            if (this.igp != null) {
                this.igp.onResume(this.mContext.getPageActivity());
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

    public long bXd() {
        return this.ikb;
    }

    public void bXe() {
        this.ikb = getCurrentPos();
    }

    public void va(int i) {
        this.ikb = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.gC(d.j.confirm_title);
        aVar.ly(this.mContext.getPageActivity().getResources().getString(d.j.now_is_not_wifi));
        aVar.a(this.mContext.getPageActivity().getResources().getString(d.j.confirm), this.igs);
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
