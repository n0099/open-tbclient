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
    private boolean iCu;
    private boolean iCv;
    private long iCw;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.iCu = false;
        this.iCv = false;
        this.iCw = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.cVS = new a.InterfaceC0268a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0268a
            public void onLoading() {
                a.this.iyK.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0268a
            public void onPlay() {
                a.this.iyK.play();
                a.this.mStatus = 1;
            }
        };
        this.ber = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.iyM != null) {
                    a.this.mDuration = a.this.iyM.getDuration();
                    a.this.iyK.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.cfi() > 0) {
                        mediaPlayer.seekTo((int) a.this.cfi());
                        a.this.wd(0);
                    }
                    a.this.iyK.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.iyN = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.iyK.complete();
                a.this.iyK.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.iyO = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.iCv = true;
                a.this.iyK.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.cSo = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.iyK.error();
                return true;
            }
        };
        this.iyK.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.iyM != null && !a.this.iyM.isPlaying()) {
                    a.this.iyK.play();
                    a.this.iyM.start();
                }
            }
        });
        this.iyK.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.error_tips) {
                    if (a.this.iyM != null) {
                        a.this.iyM.reset();
                    }
                    if (a.this.iyK != null) {
                        a.this.iyK.buffer();
                    }
                } else if ((view.getId() == R.id.play_icon || view.getId() == R.id.replay) && a.this.iyM != null && a.this.iyK != null) {
                    if (a.this.iyM.isPlaying()) {
                        a.this.iyM.pause();
                        a.this.iyK.pause();
                        a.this.iCu = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.iyK.play();
                        a.this.iyM.start();
                    } else if (a.this.iyK instanceof i) {
                        ((i) a.this.iyK).startPlay();
                    }
                    a.this.iCu = false;
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
            this.iCv = true;
            this.iyK.buffer();
            super.playVideo();
            return;
        }
        this.iCv = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.iyK.pause();
        if (this.iyM != null) {
            this.iyM.pause();
        }
        if (this.iyL != null) {
            this.iyL.onPause(this.mContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.iCu && this.iCv) {
            if (this.iyM != null && !this.iyM.isPlaying() && this.isPrepared) {
                this.iyK.play();
                this.iyM.start();
            } else if (this.iyK instanceof i) {
                ((i) this.iyK).startPlay();
            }
            if (this.iyL != null) {
                this.iyL.onResume(this.mContext.getPageActivity());
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

    public long cfi() {
        return this.iCw;
    }

    public void cfj() {
        this.iCw = getCurrentPos();
    }

    public void wd(int i) {
        this.iCw = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.hn(R.string.confirm_title);
        aVar.mD(this.mContext.getPageActivity().getResources().getString(R.string.now_is_not_wifi));
        aVar.a(this.mContext.getPageActivity().getResources().getString(R.string.confirm), this.iyO);
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
