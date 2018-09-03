package com.baidu.tieba.recapp.lego.view;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.SeekBar;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.ad.play.a;
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.view.IVrPlayView;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.recapp.a {
    private boolean grp;
    private boolean grq;
    private long grr;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.grp = false;
        this.grq = false;
        this.grr = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.bnF = new a.InterfaceC0127a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0127a
            public void onLoading() {
                a.this.gnB.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0127a
            public void onPlay() {
                a.this.gnB.play();
                a.this.mStatus = 1;
            }
        };
        this.bkd = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.gnD != null) {
                    a.this.mDuration = a.this.gnD.getDuration();
                    a.this.gnB.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.bnK() > 0) {
                        mediaPlayer.seekTo((int) a.this.bnK());
                        a.this.pn(0);
                    }
                    a.this.gnB.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.gnE = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.gnB.complete();
                a.this.gnB.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.gnF = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.grq = true;
                a.this.gnB.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.bkh = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.gnB.error();
                return true;
            }
        };
        this.gnB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.gnD != null && !a.this.gnD.isPlaying()) {
                    a.this.gnB.play();
                    a.this.gnD.start();
                }
            }
        });
        this.gnB.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == f.g.error_tips) {
                    if (a.this.gnD != null) {
                        a.this.gnD.reset();
                    }
                    if (a.this.gnB != null) {
                        a.this.gnB.buffer();
                    }
                } else if ((view.getId() == f.g.play_icon || view.getId() == f.g.replay) && a.this.gnD != null && a.this.gnB != null) {
                    if (a.this.gnD.isPlaying()) {
                        a.this.gnD.pause();
                        a.this.gnB.pause();
                        a.this.grp = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.gnB.play();
                        a.this.gnD.start();
                    } else if (a.this.gnB instanceof i) {
                        ((i) a.this.gnB).startPlay();
                    }
                    a.this.grp = false;
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
        if (!j.jG()) {
            this.grq = true;
            this.gnB.buffer();
            super.playVideo();
            return;
        }
        this.grq = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.gnB.pause();
        if (this.gnD != null) {
            this.gnD.pause();
        }
        if (this.gnC != null) {
            this.gnC.onPause(this.mContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.grp && this.grq) {
            if (this.gnD != null && !this.gnD.isPlaying() && this.isPrepared) {
                this.gnB.play();
                this.gnD.start();
            } else if (this.gnB instanceof i) {
                ((i) this.gnB).startPlay();
            }
            if (this.gnC != null) {
                this.gnC.onResume(this.mContext.getPageActivity());
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

    public long bnK() {
        return this.grr;
    }

    public void bnL() {
        this.grr = getCurrentPos();
    }

    public void pn(int i) {
        this.grr = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.ce(f.j.confirm_title);
        aVar.dB(this.mContext.getPageActivity().getResources().getString(f.j.now_is_not_wifi));
        aVar.a(this.mContext.getPageActivity().getResources().getString(f.j.confirm), this.gnF);
        aVar.b(this.mContext.getPageActivity().getResources().getString(f.j.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.mContext.getPageActivity().finish();
            }
        });
        aVar.av(false);
        aVar.aw(false);
        aVar.b(this.mContext);
        aVar.xe();
    }
}
