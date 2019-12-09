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
    private boolean iKo;
    private boolean iKp;
    private long iKq;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.iKo = false;
        this.iKp = false;
        this.iKq = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.dhI = new a.InterfaceC0306a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0306a
            public void onLoading() {
                a.this.iGw.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0306a
            public void onPlay() {
                a.this.iGw.play();
                a.this.mStatus = 1;
            }
        };
        this.bxF = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.iGy != null) {
                    a.this.mDuration = a.this.iGy.getDuration();
                    a.this.iGw.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.cgh() > 0) {
                        mediaPlayer.seekTo((int) a.this.cgh());
                        a.this.vq(0);
                    }
                    a.this.iGw.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.iGz = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.iGw.complete();
                a.this.iGw.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.iGA = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.iKp = true;
                a.this.iGw.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.ddn = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.iGw.error();
                return true;
            }
        };
        this.iGw.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.iGy != null && !a.this.iGy.isPlaying()) {
                    a.this.iGw.play();
                    a.this.iGy.start();
                }
            }
        });
        this.iGw.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.error_tips) {
                    if (a.this.iGy != null) {
                        a.this.iGy.reset();
                    }
                    if (a.this.iGw != null) {
                        a.this.iGw.buffer();
                    }
                } else if ((view.getId() == R.id.play_icon || view.getId() == R.id.replay) && a.this.iGy != null && a.this.iGw != null) {
                    if (a.this.iGy.isPlaying()) {
                        a.this.iGy.pause();
                        a.this.iGw.pause();
                        a.this.iKo = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.iGw.play();
                        a.this.iGy.start();
                    } else if (a.this.iGw instanceof i) {
                        ((i) a.this.iGw).startPlay();
                    }
                    a.this.iKo = false;
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
        if (!j.isMobileNet()) {
            this.iKp = true;
            this.iGw.buffer();
            super.playVideo();
            return;
        }
        this.iKp = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.iGw.pause();
        if (this.iGy != null) {
            this.iGy.pause();
        }
        if (this.iGx != null) {
            this.iGx.onPause(this.ceu.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.iKo && this.iKp) {
            if (this.iGy != null && !this.iGy.isPlaying() && this.isPrepared) {
                this.iGw.play();
                this.iGy.start();
            } else if (this.iGw instanceof i) {
                ((i) this.iGw).startPlay();
            }
            if (this.iGx != null) {
                this.iGx.onResume(this.ceu.getPageActivity());
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

    public long cgh() {
        return this.iKq;
    }

    public void cgi() {
        this.iKq = getCurrentPos();
    }

    public void vq(int i) {
        this.iKq = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ceu.getPageActivity());
        aVar.hS(R.string.confirm_title);
        aVar.nn(this.ceu.getPageActivity().getResources().getString(R.string.now_is_not_wifi));
        aVar.a(this.ceu.getPageActivity().getResources().getString(R.string.confirm), this.iGA);
        aVar.b(this.ceu.getPageActivity().getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.ceu.getPageActivity().finish();
            }
        });
        aVar.eg(false);
        aVar.eh(false);
        aVar.b(this.ceu);
        aVar.akM();
    }
}
