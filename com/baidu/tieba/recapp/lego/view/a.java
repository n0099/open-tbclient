package com.baidu.tieba.recapp.lego.view;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.SeekBar;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.play.a;
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.view.IVrPlayView;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.recapp.a {
    private boolean iJQ;
    private boolean iJR;
    private long iJS;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.iJQ = false;
        this.iJR = false;
        this.iJS = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.cXv = new a.InterfaceC0270a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0270a
            public void onLoading() {
                a.this.iGg.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0270a
            public void onPlay() {
                a.this.iGg.play();
                a.this.mStatus = 1;
            }
        };
        this.bff = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.iGi != null) {
                    a.this.mDuration = a.this.iGi.getDuration();
                    a.this.iGg.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.cir() > 0) {
                        mediaPlayer.seekTo((int) a.this.cir());
                        a.this.wI(0);
                    }
                    a.this.iGg.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.iGj = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.iGg.complete();
                a.this.iGg.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.iGk = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.iJR = true;
                a.this.iGg.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.cTR = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.iGg.error();
                return true;
            }
        };
        this.iGg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.iGi != null && !a.this.iGi.isPlaying()) {
                    a.this.iGg.play();
                    a.this.iGi.start();
                }
            }
        });
        this.iGg.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.error_tips) {
                    if (a.this.iGi != null) {
                        a.this.iGi.reset();
                    }
                    if (a.this.iGg != null) {
                        a.this.iGg.buffer();
                    }
                } else if ((view.getId() == R.id.play_icon || view.getId() == R.id.replay) && a.this.iGi != null && a.this.iGg != null) {
                    if (a.this.iGi.isPlaying()) {
                        a.this.iGi.pause();
                        a.this.iGg.pause();
                        a.this.iJQ = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.iGg.play();
                        a.this.iGi.start();
                    } else if (a.this.iGg instanceof i) {
                        ((i) a.this.iGg).startPlay();
                    }
                    a.this.iJQ = false;
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
        if (!j.ke()) {
            this.iJR = true;
            this.iGg.buffer();
            super.playVideo();
            return;
        }
        this.iJR = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.iGg.pause();
        if (this.iGi != null) {
            this.iGi.pause();
        }
        if (this.iGh != null) {
            this.iGh.onPause(this.mContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.iJQ && this.iJR) {
            if (this.iGi != null && !this.iGi.isPlaying() && this.isPrepared) {
                this.iGg.play();
                this.iGi.start();
            } else if (this.iGg instanceof i) {
                ((i) this.iGg).startPlay();
            }
            if (this.iGh != null) {
                this.iGh.onResume(this.mContext.getPageActivity());
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

    public long cir() {
        return this.iJS;
    }

    public void cis() {
        this.iJS = getCurrentPos();
    }

    public void wI(int i) {
        this.iJS = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.ht(R.string.confirm_title);
        aVar.mO(this.mContext.getPageActivity().getResources().getString(R.string.now_is_not_wifi));
        aVar.a(this.mContext.getPageActivity().getResources().getString(R.string.confirm), this.iGk);
        aVar.b(this.mContext.getPageActivity().getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.mContext.getPageActivity().finish();
            }
        });
        aVar.dQ(false);
        aVar.dR(false);
        aVar.b(this.mContext);
        aVar.agK();
    }
}
