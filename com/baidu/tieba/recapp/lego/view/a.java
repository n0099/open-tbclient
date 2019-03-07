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
    private boolean ijY;
    private boolean ijZ;
    private long ika;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.ijY = false;
        this.ijZ = false;
        this.ika = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.cNF = new a.InterfaceC0219a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0219a
            public void onLoading() {
                a.this.ign.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0219a
            public void onPlay() {
                a.this.ign.play();
                a.this.mStatus = 1;
            }
        };
        this.bah = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.igp != null) {
                    a.this.mDuration = a.this.igp.getDuration();
                    a.this.ign.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.bXc() > 0) {
                        mediaPlayer.seekTo((int) a.this.bXc());
                        a.this.va(0);
                    }
                    a.this.ign.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.igq = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.ign.complete();
                a.this.ign.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.igr = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.ijZ = true;
                a.this.ign.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.baw = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.ign.error();
                return true;
            }
        };
        this.ign.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.igp != null && !a.this.igp.isPlaying()) {
                    a.this.ign.play();
                    a.this.igp.start();
                }
            }
        });
        this.ign.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.error_tips) {
                    if (a.this.igp != null) {
                        a.this.igp.reset();
                    }
                    if (a.this.ign != null) {
                        a.this.ign.buffer();
                    }
                } else if ((view.getId() == d.g.play_icon || view.getId() == d.g.replay) && a.this.igp != null && a.this.ign != null) {
                    if (a.this.igp.isPlaying()) {
                        a.this.igp.pause();
                        a.this.ign.pause();
                        a.this.ijY = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.ign.play();
                        a.this.igp.start();
                    } else if (a.this.ign instanceof i) {
                        ((i) a.this.ign).startPlay();
                    }
                    a.this.ijY = false;
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
            this.ijZ = true;
            this.ign.buffer();
            super.playVideo();
            return;
        }
        this.ijZ = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.ign.pause();
        if (this.igp != null) {
            this.igp.pause();
        }
        if (this.igo != null) {
            this.igo.onPause(this.mContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.ijY && this.ijZ) {
            if (this.igp != null && !this.igp.isPlaying() && this.isPrepared) {
                this.ign.play();
                this.igp.start();
            } else if (this.ign instanceof i) {
                ((i) this.ign).startPlay();
            }
            if (this.igo != null) {
                this.igo.onResume(this.mContext.getPageActivity());
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

    public long bXc() {
        return this.ika;
    }

    public void bXd() {
        this.ika = getCurrentPos();
    }

    public void va(int i) {
        this.ika = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.gC(d.j.confirm_title);
        aVar.ly(this.mContext.getPageActivity().getResources().getString(d.j.now_is_not_wifi));
        aVar.a(this.mContext.getPageActivity().getResources().getString(d.j.confirm), this.igr);
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
