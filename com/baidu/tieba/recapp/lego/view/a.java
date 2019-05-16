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
    private boolean iCr;
    private boolean iCs;
    private long iCt;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.iCr = false;
        this.iCs = false;
        this.iCt = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.cVQ = new a.InterfaceC0268a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0268a
            public void onLoading() {
                a.this.iyH.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0268a
            public void onPlay() {
                a.this.iyH.play();
                a.this.mStatus = 1;
            }
        };
        this.ber = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.iyJ != null) {
                    a.this.mDuration = a.this.iyJ.getDuration();
                    a.this.iyH.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.cff() > 0) {
                        mediaPlayer.seekTo((int) a.this.cff());
                        a.this.wd(0);
                    }
                    a.this.iyH.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.iyK = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.iyH.complete();
                a.this.iyH.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.iyL = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.iCs = true;
                a.this.iyH.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.cSm = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.iyH.error();
                return true;
            }
        };
        this.iyH.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.iyJ != null && !a.this.iyJ.isPlaying()) {
                    a.this.iyH.play();
                    a.this.iyJ.start();
                }
            }
        });
        this.iyH.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.error_tips) {
                    if (a.this.iyJ != null) {
                        a.this.iyJ.reset();
                    }
                    if (a.this.iyH != null) {
                        a.this.iyH.buffer();
                    }
                } else if ((view.getId() == R.id.play_icon || view.getId() == R.id.replay) && a.this.iyJ != null && a.this.iyH != null) {
                    if (a.this.iyJ.isPlaying()) {
                        a.this.iyJ.pause();
                        a.this.iyH.pause();
                        a.this.iCr = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.iyH.play();
                        a.this.iyJ.start();
                    } else if (a.this.iyH instanceof i) {
                        ((i) a.this.iyH).startPlay();
                    }
                    a.this.iCr = false;
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
        if (!j.jU()) {
            this.iCs = true;
            this.iyH.buffer();
            super.playVideo();
            return;
        }
        this.iCs = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.iyH.pause();
        if (this.iyJ != null) {
            this.iyJ.pause();
        }
        if (this.iyI != null) {
            this.iyI.onPause(this.mContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.iCr && this.iCs) {
            if (this.iyJ != null && !this.iyJ.isPlaying() && this.isPrepared) {
                this.iyH.play();
                this.iyJ.start();
            } else if (this.iyH instanceof i) {
                ((i) this.iyH).startPlay();
            }
            if (this.iyI != null) {
                this.iyI.onResume(this.mContext.getPageActivity());
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

    public long cff() {
        return this.iCt;
    }

    public void cfg() {
        this.iCt = getCurrentPos();
    }

    public void wd(int i) {
        this.iCt = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.hn(R.string.confirm_title);
        aVar.mE(this.mContext.getPageActivity().getResources().getString(R.string.now_is_not_wifi));
        aVar.a(this.mContext.getPageActivity().getResources().getString(R.string.confirm), this.iyL);
        aVar.b(this.mContext.getPageActivity().getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.mContext.getPageActivity().finish();
            }
        });
        aVar.dM(false);
        aVar.dN(false);
        aVar.b(this.mContext);
        aVar.afG();
    }
}
