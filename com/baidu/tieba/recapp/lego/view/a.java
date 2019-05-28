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
    private boolean iCt;
    private boolean iCu;
    private long iCv;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.iCt = false;
        this.iCu = false;
        this.iCv = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.cVR = new a.InterfaceC0268a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0268a
            public void onLoading() {
                a.this.iyJ.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0268a
            public void onPlay() {
                a.this.iyJ.play();
                a.this.mStatus = 1;
            }
        };
        this.ber = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.iyL != null) {
                    a.this.mDuration = a.this.iyL.getDuration();
                    a.this.iyJ.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.cfh() > 0) {
                        mediaPlayer.seekTo((int) a.this.cfh());
                        a.this.wd(0);
                    }
                    a.this.iyJ.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.iyM = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.iyJ.complete();
                a.this.iyJ.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.iyN = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.iCu = true;
                a.this.iyJ.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.cSn = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.iyJ.error();
                return true;
            }
        };
        this.iyJ.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.iyL != null && !a.this.iyL.isPlaying()) {
                    a.this.iyJ.play();
                    a.this.iyL.start();
                }
            }
        });
        this.iyJ.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.error_tips) {
                    if (a.this.iyL != null) {
                        a.this.iyL.reset();
                    }
                    if (a.this.iyJ != null) {
                        a.this.iyJ.buffer();
                    }
                } else if ((view.getId() == R.id.play_icon || view.getId() == R.id.replay) && a.this.iyL != null && a.this.iyJ != null) {
                    if (a.this.iyL.isPlaying()) {
                        a.this.iyL.pause();
                        a.this.iyJ.pause();
                        a.this.iCt = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.iyJ.play();
                        a.this.iyL.start();
                    } else if (a.this.iyJ instanceof i) {
                        ((i) a.this.iyJ).startPlay();
                    }
                    a.this.iCt = false;
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
            this.iCu = true;
            this.iyJ.buffer();
            super.playVideo();
            return;
        }
        this.iCu = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.iyJ.pause();
        if (this.iyL != null) {
            this.iyL.pause();
        }
        if (this.iyK != null) {
            this.iyK.onPause(this.mContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.iCt && this.iCu) {
            if (this.iyL != null && !this.iyL.isPlaying() && this.isPrepared) {
                this.iyJ.play();
                this.iyL.start();
            } else if (this.iyJ instanceof i) {
                ((i) this.iyJ).startPlay();
            }
            if (this.iyK != null) {
                this.iyK.onResume(this.mContext.getPageActivity());
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

    public long cfh() {
        return this.iCv;
    }

    public void cfi() {
        this.iCv = getCurrentPos();
    }

    public void wd(int i) {
        this.iCv = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.hn(R.string.confirm_title);
        aVar.mE(this.mContext.getPageActivity().getResources().getString(R.string.now_is_not_wifi));
        aVar.a(this.mContext.getPageActivity().getResources().getString(R.string.confirm), this.iyN);
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
