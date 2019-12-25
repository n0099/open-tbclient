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
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.recapp.a {
    public boolean isPrepared;
    private boolean jEF;
    private boolean jEG;
    private long jEH;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.jEF = false;
        this.jEG = false;
        this.jEH = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.dVv = new a.InterfaceC0392a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0392a
            public void onLoading() {
                a.this.jAO.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0392a
            public void onPlay() {
                a.this.jAO.play();
                a.this.mStatus = 1;
            }
        };
        this.cgg = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.jAQ != null) {
                    a.this.mDuration = a.this.jAQ.getDuration();
                    a.this.jAO.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.cAl() > 0) {
                        mediaPlayer.seekTo((int) a.this.cAl());
                        a.this.xs(0);
                    }
                    a.this.jAO.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.jAR = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.jAO.complete();
                a.this.jAO.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.jAS = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.jEG = true;
                a.this.jAO.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.cgi = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.jAO.error();
                return true;
            }
        };
        this.jAO.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.jAQ != null && !a.this.jAQ.isPlaying()) {
                    a.this.jAO.play();
                    a.this.jAQ.start();
                }
            }
        });
        this.jAO.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.error_tips) {
                    if (a.this.jAQ != null) {
                        a.this.jAQ.reset();
                    }
                    if (a.this.jAO != null) {
                        a.this.jAO.buffer();
                    }
                } else if ((view.getId() == R.id.play_icon || view.getId() == R.id.replay) && a.this.jAQ != null && a.this.jAO != null) {
                    if (a.this.jAQ.isPlaying()) {
                        a.this.jAQ.pause();
                        a.this.jAO.pause();
                        a.this.jEF = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.jAO.play();
                        a.this.jAQ.start();
                    } else if (a.this.jAO instanceof i) {
                        ((i) a.this.jAO).startPlay();
                    }
                    a.this.jEF = false;
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
            this.jEG = true;
            this.jAO.buffer();
            super.playVideo();
            return;
        }
        this.jEG = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.jAO.pause();
        if (this.jAQ != null) {
            this.jAQ.pause();
        }
        if (this.jAP != null) {
            this.jAP.onPause(this.cQU.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.jEF && this.jEG) {
            if (this.jAQ != null && !this.jAQ.isPlaying() && this.isPrepared) {
                this.jAO.play();
                this.jAQ.start();
            } else if (this.jAO instanceof i) {
                ((i) this.jAO).startPlay();
            }
            if (this.jAP != null) {
                this.jAP.onResume(this.cQU.getPageActivity());
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

    public long cAl() {
        return this.jEH;
    }

    public void cAm() {
        this.jEH = getCurrentPos();
    }

    public void xs(int i) {
        this.jEH = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cQU.getPageActivity());
        aVar.jE(R.string.confirm_title);
        aVar.sz(this.cQU.getPageActivity().getResources().getString(R.string.now_is_not_wifi));
        aVar.a(this.cQU.getPageActivity().getResources().getString(R.string.confirm), this.jAS);
        aVar.b(this.cQU.getPageActivity().getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.cQU.getPageActivity().finish();
            }
        });
        aVar.fu(false);
        aVar.fv(false);
        aVar.b(this.cQU);
        aVar.aBW();
    }
}
