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
    private boolean jJk;
    private boolean jJl;
    private long jJm;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.jJk = false;
        this.jJl = false;
        this.jJm = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.dZJ = new a.InterfaceC0405a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0405a
            public void onLoading() {
                a.this.jFo.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0405a
            public void onPlay() {
                a.this.jFo.play();
                a.this.mStatus = 1;
            }
        };
        this.cky = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.jFq != null) {
                    a.this.mDuration = a.this.jFq.getDuration();
                    a.this.jFo.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.cCS() > 0) {
                        mediaPlayer.seekTo((int) a.this.cCS());
                        a.this.xD(0);
                    }
                    a.this.jFo.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.jFr = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.jFo.complete();
                a.this.jFo.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.jFs = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.jJl = true;
                a.this.jFo.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.ckA = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.jFo.error();
                return true;
            }
        };
        this.jFo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.jFq != null && !a.this.jFq.isPlaying()) {
                    a.this.jFo.play();
                    a.this.jFq.start();
                }
            }
        });
        this.jFo.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.error_tips) {
                    if (a.this.jFq != null) {
                        a.this.jFq.reset();
                    }
                    if (a.this.jFo != null) {
                        a.this.jFo.buffer();
                    }
                } else if ((view.getId() == R.id.play_icon || view.getId() == R.id.replay) && a.this.jFq != null && a.this.jFo != null) {
                    if (a.this.jFq.isPlaying()) {
                        a.this.jFq.pause();
                        a.this.jFo.pause();
                        a.this.jJk = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.jFo.play();
                        a.this.jFq.start();
                    } else if (a.this.jFo instanceof i) {
                        ((i) a.this.jFo).startPlay();
                    }
                    a.this.jJk = false;
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
            this.jJl = true;
            this.jFo.buffer();
            super.playVideo();
            return;
        }
        this.jJl = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.jFo.pause();
        if (this.jFq != null) {
            this.jFq.pause();
        }
        if (this.jFp != null) {
            this.jFp.onPause(this.cVh.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.jJk && this.jJl) {
            if (this.jFq != null && !this.jFq.isPlaying() && this.isPrepared) {
                this.jFo.play();
                this.jFq.start();
            } else if (this.jFo instanceof i) {
                ((i) this.jFo).startPlay();
            }
            if (this.jFp != null) {
                this.jFp.onResume(this.cVh.getPageActivity());
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

    public long cCS() {
        return this.jJm;
    }

    public void cCT() {
        this.jJm = getCurrentPos();
    }

    public void xD(int i) {
        this.jJm = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVh.getPageActivity());
        aVar.jV(R.string.confirm_title);
        aVar.sS(this.cVh.getPageActivity().getResources().getString(R.string.now_is_not_wifi));
        aVar.a(this.cVh.getPageActivity().getResources().getString(R.string.confirm), this.jFs);
        aVar.b(this.cVh.getPageActivity().getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.cVh.getPageActivity().finish();
            }
        });
        aVar.fG(false);
        aVar.fH(false);
        aVar.b(this.cVh);
        aVar.aEC();
    }
}
