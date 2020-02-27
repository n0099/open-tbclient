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
/* loaded from: classes13.dex */
public class a extends com.baidu.tieba.recapp.a {
    public boolean isPrepared;
    private boolean jJi;
    private boolean jJj;
    private long jJk;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.jJi = false;
        this.jJj = false;
        this.jJk = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.dZI = new a.InterfaceC0405a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0405a
            public void onLoading() {
                a.this.jFm.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0405a
            public void onPlay() {
                a.this.jFm.play();
                a.this.mStatus = 1;
            }
        };
        this.ckx = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.jFo != null) {
                    a.this.mDuration = a.this.jFo.getDuration();
                    a.this.jFm.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.cCQ() > 0) {
                        mediaPlayer.seekTo((int) a.this.cCQ());
                        a.this.xD(0);
                    }
                    a.this.jFm.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.jFp = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.jFm.complete();
                a.this.jFm.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.jFq = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.jJj = true;
                a.this.jFm.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.ckz = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.jFm.error();
                return true;
            }
        };
        this.jFm.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.jFo != null && !a.this.jFo.isPlaying()) {
                    a.this.jFm.play();
                    a.this.jFo.start();
                }
            }
        });
        this.jFm.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.error_tips) {
                    if (a.this.jFo != null) {
                        a.this.jFo.reset();
                    }
                    if (a.this.jFm != null) {
                        a.this.jFm.buffer();
                    }
                } else if ((view.getId() == R.id.play_icon || view.getId() == R.id.replay) && a.this.jFo != null && a.this.jFm != null) {
                    if (a.this.jFo.isPlaying()) {
                        a.this.jFo.pause();
                        a.this.jFm.pause();
                        a.this.jJi = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.jFm.play();
                        a.this.jFo.start();
                    } else if (a.this.jFm instanceof i) {
                        ((i) a.this.jFm).startPlay();
                    }
                    a.this.jJi = false;
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
            this.jJj = true;
            this.jFm.buffer();
            super.playVideo();
            return;
        }
        this.jJj = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.jFm.pause();
        if (this.jFo != null) {
            this.jFo.pause();
        }
        if (this.jFn != null) {
            this.jFn.onPause(this.cVg.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.jJi && this.jJj) {
            if (this.jFo != null && !this.jFo.isPlaying() && this.isPrepared) {
                this.jFm.play();
                this.jFo.start();
            } else if (this.jFm instanceof i) {
                ((i) this.jFm).startPlay();
            }
            if (this.jFn != null) {
                this.jFn.onResume(this.cVg.getPageActivity());
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

    public long cCQ() {
        return this.jJk;
    }

    public void cCR() {
        this.jJk = getCurrentPos();
    }

    public void xD(int i) {
        this.jJk = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVg.getPageActivity());
        aVar.jV(R.string.confirm_title);
        aVar.sS(this.cVg.getPageActivity().getResources().getString(R.string.now_is_not_wifi));
        aVar.a(this.cVg.getPageActivity().getResources().getString(R.string.confirm), this.jFq);
        aVar.b(this.cVg.getPageActivity().getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.cVg.getPageActivity().finish();
            }
        });
        aVar.fG(false);
        aVar.fH(false);
        aVar.b(this.cVg);
        aVar.aEA();
    }
}
