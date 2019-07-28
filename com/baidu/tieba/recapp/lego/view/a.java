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
    private boolean iIM;
    private boolean iIN;
    private long iIO;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.iIM = false;
        this.iIN = false;
        this.iIO = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.cXo = new a.InterfaceC0270a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0270a
            public void onLoading() {
                a.this.iFc.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0270a
            public void onPlay() {
                a.this.iFc.play();
                a.this.mStatus = 1;
            }
        };
        this.bff = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.iFe != null) {
                    a.this.mDuration = a.this.iFe.getDuration();
                    a.this.iFc.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.chZ() > 0) {
                        mediaPlayer.seekTo((int) a.this.chZ());
                        a.this.wG(0);
                    }
                    a.this.iFc.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.iFf = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.iFc.complete();
                a.this.iFc.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.iFg = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.iIN = true;
                a.this.iFc.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.cTK = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.iFc.error();
                return true;
            }
        };
        this.iFc.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.iFe != null && !a.this.iFe.isPlaying()) {
                    a.this.iFc.play();
                    a.this.iFe.start();
                }
            }
        });
        this.iFc.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.error_tips) {
                    if (a.this.iFe != null) {
                        a.this.iFe.reset();
                    }
                    if (a.this.iFc != null) {
                        a.this.iFc.buffer();
                    }
                } else if ((view.getId() == R.id.play_icon || view.getId() == R.id.replay) && a.this.iFe != null && a.this.iFc != null) {
                    if (a.this.iFe.isPlaying()) {
                        a.this.iFe.pause();
                        a.this.iFc.pause();
                        a.this.iIM = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.iFc.play();
                        a.this.iFe.start();
                    } else if (a.this.iFc instanceof i) {
                        ((i) a.this.iFc).startPlay();
                    }
                    a.this.iIM = false;
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
            this.iIN = true;
            this.iFc.buffer();
            super.playVideo();
            return;
        }
        this.iIN = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.iFc.pause();
        if (this.iFe != null) {
            this.iFe.pause();
        }
        if (this.iFd != null) {
            this.iFd.onPause(this.mContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.iIM && this.iIN) {
            if (this.iFe != null && !this.iFe.isPlaying() && this.isPrepared) {
                this.iFc.play();
                this.iFe.start();
            } else if (this.iFc instanceof i) {
                ((i) this.iFc).startPlay();
            }
            if (this.iFd != null) {
                this.iFd.onResume(this.mContext.getPageActivity());
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

    public long chZ() {
        return this.iIO;
    }

    public void cia() {
        this.iIO = getCurrentPos();
    }

    public void wG(int i) {
        this.iIO = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.ht(R.string.confirm_title);
        aVar.mO(this.mContext.getPageActivity().getResources().getString(R.string.now_is_not_wifi));
        aVar.a(this.mContext.getPageActivity().getResources().getString(R.string.confirm), this.iFg);
        aVar.b(this.mContext.getPageActivity().getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.mContext.getPageActivity().finish();
            }
        });
        aVar.dQ(false);
        aVar.dR(false);
        aVar.b(this.mContext);
        aVar.agI();
    }
}
