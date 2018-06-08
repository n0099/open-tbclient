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
    private boolean gml;
    private boolean gmm;
    private long gmn;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.gml = false;
        this.gmm = false;
        this.gmn = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.blx = new a.InterfaceC0128a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0128a
            public void onLoading() {
                a.this.giw.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0128a
            public void onPlay() {
                a.this.giw.play();
                a.this.mStatus = 1;
            }
        };
        this.bhQ = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.giy != null) {
                    a.this.mDuration = a.this.giy.getDuration();
                    a.this.giw.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.boE() > 0) {
                        mediaPlayer.seekTo((int) a.this.boE());
                        a.this.oR(0);
                    }
                    a.this.giw.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.giz = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.giw.complete();
                a.this.giw.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.giA = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.gmm = true;
                a.this.giw.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.bhU = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.giw.error();
                return true;
            }
        };
        this.giw.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.giy != null && !a.this.giy.isPlaying()) {
                    a.this.giw.play();
                    a.this.giy.start();
                }
            }
        });
        this.giw.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.error_tips) {
                    if (a.this.giy != null) {
                        a.this.giy.reset();
                    }
                    if (a.this.giw != null) {
                        a.this.giw.buffer();
                    }
                } else if ((view.getId() == d.g.play_icon || view.getId() == d.g.replay) && a.this.giy != null && a.this.giw != null) {
                    if (a.this.giy.isPlaying()) {
                        a.this.giy.pause();
                        a.this.giw.pause();
                        a.this.gml = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.giw.play();
                        a.this.giy.start();
                    } else if (a.this.giw instanceof i) {
                        ((i) a.this.giw).startPlay();
                    }
                    a.this.gml = false;
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
        if (!j.jF()) {
            this.gmm = true;
            this.giw.buffer();
            super.playVideo();
            return;
        }
        this.gmm = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.giw.pause();
        if (this.giy != null) {
            this.giy.pause();
        }
        if (this.gix != null) {
            this.gix.onPause(this.mContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.gml && this.gmm) {
            if (this.giy != null && !this.giy.isPlaying() && this.isPrepared) {
                this.giw.play();
                this.giy.start();
            } else if (this.giw instanceof i) {
                ((i) this.giw).startPlay();
            }
            if (this.gix != null) {
                this.gix.onResume(this.mContext.getPageActivity());
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

    public long boE() {
        return this.gmn;
    }

    public void boF() {
        this.gmn = getCurrentPos();
    }

    public void oR(int i) {
        this.gmn = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.cb(d.k.confirm_title);
        aVar.dB(this.mContext.getPageActivity().getResources().getString(d.k.now_is_not_wifi));
        aVar.a(this.mContext.getPageActivity().getResources().getString(d.k.confirm), this.giA);
        aVar.b(this.mContext.getPageActivity().getResources().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.mContext.getPageActivity().finish();
            }
        });
        aVar.au(false);
        aVar.av(false);
        aVar.b(this.mContext);
        aVar.xa();
    }
}
