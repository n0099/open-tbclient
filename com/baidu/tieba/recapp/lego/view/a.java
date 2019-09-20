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
    private boolean iMm;
    private boolean iMn;
    private long iMo;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.iMm = false;
        this.iMn = false;
        this.iMo = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.cZb = new a.InterfaceC0279a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0279a
            public void onLoading() {
                a.this.iIx.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0279a
            public void onPlay() {
                a.this.iIx.play();
                a.this.mStatus = 1;
            }
        };
        this.bfD = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.iIz != null) {
                    a.this.mDuration = a.this.iIz.getDuration();
                    a.this.iIx.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.cjf() > 0) {
                        mediaPlayer.seekTo((int) a.this.cjf());
                        a.this.wL(0);
                    }
                    a.this.iIx.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.iIA = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.iIx.complete();
                a.this.iIx.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.iIB = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.iMn = true;
                a.this.iIx.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.cUK = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.iIx.error();
                return true;
            }
        };
        this.iIx.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.iIz != null && !a.this.iIz.isPlaying()) {
                    a.this.iIx.play();
                    a.this.iIz.start();
                }
            }
        });
        this.iIx.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.error_tips) {
                    if (a.this.iIz != null) {
                        a.this.iIz.reset();
                    }
                    if (a.this.iIx != null) {
                        a.this.iIx.buffer();
                    }
                } else if ((view.getId() == R.id.play_icon || view.getId() == R.id.replay) && a.this.iIz != null && a.this.iIx != null) {
                    if (a.this.iIz.isPlaying()) {
                        a.this.iIz.pause();
                        a.this.iIx.pause();
                        a.this.iMm = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.iIx.play();
                        a.this.iIz.start();
                    } else if (a.this.iIx instanceof i) {
                        ((i) a.this.iIx).startPlay();
                    }
                    a.this.iMm = false;
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
            this.iMn = true;
            this.iIx.buffer();
            super.playVideo();
            return;
        }
        this.iMn = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.iIx.pause();
        if (this.iIz != null) {
            this.iIz.pause();
        }
        if (this.iIy != null) {
            this.iIy.onPause(this.mContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.iMm && this.iMn) {
            if (this.iIz != null && !this.iIz.isPlaying() && this.isPrepared) {
                this.iIx.play();
                this.iIz.start();
            } else if (this.iIx instanceof i) {
                ((i) this.iIx).startPlay();
            }
            if (this.iIy != null) {
                this.iIy.onResume(this.mContext.getPageActivity());
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

    public long cjf() {
        return this.iMo;
    }

    public void cjg() {
        this.iMo = getCurrentPos();
    }

    public void wL(int i) {
        this.iMo = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.hu(R.string.confirm_title);
        aVar.mQ(this.mContext.getPageActivity().getResources().getString(R.string.now_is_not_wifi));
        aVar.a(this.mContext.getPageActivity().getResources().getString(R.string.confirm), this.iIB);
        aVar.b(this.mContext.getPageActivity().getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.mContext.getPageActivity().finish();
            }
        });
        aVar.dQ(false);
        aVar.dR(false);
        aVar.b(this.mContext);
        aVar.agO();
    }
}
