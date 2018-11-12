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
    private boolean gHJ;
    private boolean gHK;
    private long gHL;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.gHJ = false;
        this.gHK = false;
        this.gHL = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.byk = new a.InterfaceC0175a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0175a
            public void onLoading() {
                a.this.gDW.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0175a
            public void onPlay() {
                a.this.gDW.play();
                a.this.mStatus = 1;
            }
        };
        this.buC = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.gDY != null) {
                    a.this.mDuration = a.this.gDY.getDuration();
                    a.this.gDW.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.btc() > 0) {
                        mediaPlayer.seekTo((int) a.this.btc());
                        a.this.qI(0);
                    }
                    a.this.gDW.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.gDZ = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.gDW.complete();
                a.this.gDW.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.gEa = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.gHK = true;
                a.this.gDW.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.buG = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.gDW.error();
                return true;
            }
        };
        this.gDW.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.gDY != null && !a.this.gDY.isPlaying()) {
                    a.this.gDW.play();
                    a.this.gDY.start();
                }
            }
        });
        this.gDW.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.error_tips) {
                    if (a.this.gDY != null) {
                        a.this.gDY.reset();
                    }
                    if (a.this.gDW != null) {
                        a.this.gDW.buffer();
                    }
                } else if ((view.getId() == e.g.play_icon || view.getId() == e.g.replay) && a.this.gDY != null && a.this.gDW != null) {
                    if (a.this.gDY.isPlaying()) {
                        a.this.gDY.pause();
                        a.this.gDW.pause();
                        a.this.gHJ = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.gDW.play();
                        a.this.gDY.start();
                    } else if (a.this.gDW instanceof i) {
                        ((i) a.this.gDW).startPlay();
                    }
                    a.this.gHJ = false;
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
            this.gHK = true;
            this.gDW.buffer();
            super.playVideo();
            return;
        }
        this.gHK = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.gDW.pause();
        if (this.gDY != null) {
            this.gDY.pause();
        }
        if (this.gDX != null) {
            this.gDX.onPause(this.mContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.gHJ && this.gHK) {
            if (this.gDY != null && !this.gDY.isPlaying() && this.isPrepared) {
                this.gDW.play();
                this.gDY.start();
            } else if (this.gDW instanceof i) {
                ((i) this.gDW).startPlay();
            }
            if (this.gDX != null) {
                this.gDX.onResume(this.mContext.getPageActivity());
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

    public long btc() {
        return this.gHL;
    }

    public void btd() {
        this.gHL = getCurrentPos();
    }

    public void qI(int i) {
        this.gHL = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.cM(e.j.confirm_title);
        aVar.ej(this.mContext.getPageActivity().getResources().getString(e.j.now_is_not_wifi));
        aVar.a(this.mContext.getPageActivity().getResources().getString(e.j.confirm), this.gEa);
        aVar.b(this.mContext.getPageActivity().getResources().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.mContext.getPageActivity().finish();
            }
        });
        aVar.be(false);
        aVar.bf(false);
        aVar.b(this.mContext);
        aVar.AB();
    }
}
