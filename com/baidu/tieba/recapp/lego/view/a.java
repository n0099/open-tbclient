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
    private boolean gRr;
    private boolean gRs;
    private long gRt;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.gRr = false;
        this.gRs = false;
        this.gRt = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.bBK = new a.InterfaceC0185a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0185a
            public void onLoading() {
                a.this.gND.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0185a
            public void onPlay() {
                a.this.gND.play();
                a.this.mStatus = 1;
            }
        };
        this.byc = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.gNF != null) {
                    a.this.mDuration = a.this.gNF.getDuration();
                    a.this.gND.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.bvG() > 0) {
                        mediaPlayer.seekTo((int) a.this.bvG());
                        a.this.rp(0);
                    }
                    a.this.gND.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.gNG = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.gND.complete();
                a.this.gND.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.gNH = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.gRs = true;
                a.this.gND.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.byg = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.gND.error();
                return true;
            }
        };
        this.gND.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.gNF != null && !a.this.gNF.isPlaying()) {
                    a.this.gND.play();
                    a.this.gNF.start();
                }
            }
        });
        this.gND.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.error_tips) {
                    if (a.this.gNF != null) {
                        a.this.gNF.reset();
                    }
                    if (a.this.gND != null) {
                        a.this.gND.buffer();
                    }
                } else if ((view.getId() == e.g.play_icon || view.getId() == e.g.replay) && a.this.gNF != null && a.this.gND != null) {
                    if (a.this.gNF.isPlaying()) {
                        a.this.gNF.pause();
                        a.this.gND.pause();
                        a.this.gRr = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.gND.play();
                        a.this.gNF.start();
                    } else if (a.this.gND instanceof i) {
                        ((i) a.this.gND).startPlay();
                    }
                    a.this.gRr = false;
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
            this.gRs = true;
            this.gND.buffer();
            super.playVideo();
            return;
        }
        this.gRs = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.gND.pause();
        if (this.gNF != null) {
            this.gNF.pause();
        }
        if (this.gNE != null) {
            this.gNE.onPause(this.mContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.gRr && this.gRs) {
            if (this.gNF != null && !this.gNF.isPlaying() && this.isPrepared) {
                this.gND.play();
                this.gNF.start();
            } else if (this.gND instanceof i) {
                ((i) this.gND).startPlay();
            }
            if (this.gNE != null) {
                this.gNE.onResume(this.mContext.getPageActivity());
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

    public long bvG() {
        return this.gRt;
    }

    public void bvH() {
        this.gRt = getCurrentPos();
    }

    public void rp(int i) {
        this.gRt = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.da(e.j.confirm_title);
        aVar.eB(this.mContext.getPageActivity().getResources().getString(e.j.now_is_not_wifi));
        aVar.a(this.mContext.getPageActivity().getResources().getString(e.j.confirm), this.gNH);
        aVar.b(this.mContext.getPageActivity().getResources().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.mContext.getPageActivity().finish();
            }
        });
        aVar.bf(false);
        aVar.bg(false);
        aVar.b(this.mContext);
        aVar.BF();
    }
}
