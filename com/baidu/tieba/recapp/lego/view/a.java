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
    private boolean iLf;
    private boolean iLg;
    private long iLh;
    public boolean isPrepared;
    private int mDuration;

    public a(IVrPlayView iVrPlayView) {
        super(iVrPlayView);
        this.iLf = false;
        this.iLg = false;
        this.iLh = 0L;
        this.isPrepared = false;
    }

    @Override // com.baidu.tieba.recapp.a
    public void initListener() {
        this.diA = new a.InterfaceC0311a() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // com.baidu.tieba.ad.play.a.InterfaceC0311a
            public void onLoading() {
                a.this.iHn.loading();
            }

            @Override // com.baidu.tieba.ad.play.a.InterfaceC0311a
            public void onPlay() {
                a.this.iHn.play();
                a.this.mStatus = 1;
            }
        };
        this.byw = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null && a.this.iHp != null) {
                    a.this.mDuration = a.this.iHp.getDuration();
                    a.this.iHn.setSeekBarTime(0, a.this.mDuration);
                    if (a.this.cgj() > 0) {
                        mediaPlayer.seekTo((int) a.this.cgj());
                        a.this.vr(0);
                    }
                    a.this.iHn.play();
                    a.this.isPrepared = true;
                }
            }
        };
        this.iHq = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.stopPlay();
                a.this.iHn.complete();
                a.this.iHn.setSeekBarTime(0, a.this.mDuration);
            }
        };
        this.iHr = new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.iLg = true;
                a.this.iHn.play();
                a.this.playVideo();
                aVar.dismiss();
            }
        };
        this.def = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.this.stopPlay();
                a.this.iHn.error();
                return true;
            }
        };
        this.iHn.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.a.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (a.this.iHp != null && !a.this.iHp.isPlaying()) {
                    a.this.iHn.play();
                    a.this.iHp.start();
                }
            }
        });
        this.iHn.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.error_tips) {
                    if (a.this.iHp != null) {
                        a.this.iHp.reset();
                    }
                    if (a.this.iHn != null) {
                        a.this.iHn.buffer();
                    }
                } else if ((view.getId() == R.id.play_icon || view.getId() == R.id.replay) && a.this.iHp != null && a.this.iHn != null) {
                    if (a.this.iHp.isPlaying()) {
                        a.this.iHp.pause();
                        a.this.iHn.pause();
                        a.this.iLf = true;
                        return;
                    }
                    if (a.this.isPrepared) {
                        a.this.iHn.play();
                        a.this.iHp.start();
                    } else if (a.this.iHn instanceof i) {
                        ((i) a.this.iHn).startPlay();
                    }
                    a.this.iLf = false;
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
            this.iLg = true;
            this.iHn.buffer();
            super.playVideo();
            return;
        }
        this.iLg = false;
        showDialog();
    }

    @Override // com.baidu.tieba.recapp.a
    public void pausePlay() {
        this.iHn.pause();
        if (this.iHp != null) {
            this.iHp.pause();
        }
        if (this.iHo != null) {
            this.iHo.onPause(this.cfl.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.recapp.a
    public void continuePlay() {
        if (!this.iLf && this.iLg) {
            if (this.iHp != null && !this.iHp.isPlaying() && this.isPrepared) {
                this.iHn.play();
                this.iHp.start();
            } else if (this.iHn instanceof i) {
                ((i) this.iHn).startPlay();
            }
            if (this.iHo != null) {
                this.iHo.onResume(this.cfl.getPageActivity());
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

    public long cgj() {
        return this.iLh;
    }

    public void cgk() {
        this.iLh = getCurrentPos();
    }

    public void vr(int i) {
        this.iLh = i;
    }

    private void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cfl.getPageActivity());
        aVar.hT(R.string.confirm_title);
        aVar.nn(this.cfl.getPageActivity().getResources().getString(R.string.now_is_not_wifi));
        aVar.a(this.cfl.getPageActivity().getResources().getString(R.string.confirm), this.iHr);
        aVar.b(this.cfl.getPageActivity().getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.cfl.getPageActivity().finish();
            }
        });
        aVar.eg(false);
        aVar.eh(false);
        aVar.b(this.cfl);
        aVar.akO();
    }
}
