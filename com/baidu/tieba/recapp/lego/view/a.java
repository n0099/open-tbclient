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
    private boolean jKY;
    private boolean jKZ;
    private long jLa;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.jKY = false;
        this.jKZ = false;
        this.jLa = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.eam = new a.InterfaceC0405a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0405a
            public void onLoading() {
                a.this.jGZ.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0405a
            public void onPlay() {
                a.this.jGZ.play();
                a.this.mStatus = 1;
            }
        };
        this.ckK = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.jHb != null) {
                    a.this.mDuration = a.this.jHb.getDuration();
                    a.this.jGZ.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.cDn() > 0) {
                        mediaPlayer.seekTo((int) a.this.cDn());
                        a.this.xL(0);
                    }
                    a.this.jGZ.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.jHc = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.jGZ.complete();
                a.this.jGZ.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.jHd = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.jKZ = true;
                a.this.jGZ.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.ckM = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.jGZ.error();
                return true;
            }
        };
        this.jGZ.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.jHb != null && !a.this.jHb.isPlaying()) {
                    a.this.jGZ.play();
                    a.this.jHb.start();
                }
            }
        });
        this.jGZ.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.error_tips) {
                    if (a.this.jHb != null) {
                        a.this.jHb.reset();
                    }
                    if (a.this.jGZ != null) {
                        a.this.jGZ.buffer();
                    }
                } else if ((view.getId() == R.id.play_icon || view.getId() == R.id.replay) && a.this.jHb != null && a.this.jGZ != null) {
                    if (a.this.jHb.isPlaying()) {
                        a.this.jHb.pause();
                        a.this.jGZ.pause();
                        a.this.jKY = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.jGZ.play();
                        a.this.jHb.start();
                    } else if (a.this.jGZ instanceof i) {
                        ((i) a.this.jGZ).startPlay();
                    }
                    a.this.jKY = false;
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
            this.jKZ = true;
            this.jGZ.buffer();
            super.playVideo();
            return;
        }
        this.jKZ = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.jGZ.pause();
        if (this.jHb != null) {
            this.jHb.pause();
        }
        if (this.jHa != null) {
            this.jHa.onPause(this.cVv.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.jKY && this.jKZ) {
            if (this.jHb != null && !this.jHb.isPlaying() && this.isPrepared) {
                this.jGZ.play();
                this.jHb.start();
            } else if (this.jGZ instanceof i) {
                ((i) this.jGZ).startPlay();
            }
            if (this.jHa != null) {
                this.jHa.onResume(this.cVv.getPageActivity());
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

    public long cDn() {
        return this.jLa;
    }

    public void cDo() {
        this.jLa = getCurrentPos();
    }

    public void xL(int i) {
        this.jLa = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVv.getPageActivity());
        aVar.jV(R.string.confirm_title);
        aVar.sR(this.cVv.getPageActivity().getResources().getString(R.string.now_is_not_wifi));
        aVar.a(this.cVv.getPageActivity().getResources().getString(R.string.confirm), this.jHd);
        aVar.b(this.cVv.getPageActivity().getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.cVv.getPageActivity().finish();
            }
        });
        aVar.fH(false);
        aVar.fI(false);
        aVar.b(this.cVv);
        aVar.aEG();
    }
}
