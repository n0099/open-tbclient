package com.baidu.tieba.play;

import android.os.Handler;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.tieba.play.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ au eTs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(au auVar) {
        this.eTs = auVar;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
        Handler handler;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2;
        this.eTs.cKy = true;
        onSeekBarChangeListener = this.eTs.duN;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener2 = this.eTs.duN;
            onSeekBarChangeListener2.onStartTrackingTouch(seekBar);
        }
        handler = this.eTs.mHandler;
        handler.removeMessages(1);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        MediaController.MediaPlayerControl mediaPlayerControl;
        TextView textView;
        au.a aVar;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2;
        int i2;
        au.a aVar2;
        TextView textView2;
        int i3;
        if (z) {
            mediaPlayerControl = this.eTs.cKv;
            this.eTs.eTr = (int) ((mediaPlayerControl.getDuration() * i) / 10000);
            textView = this.eTs.cKw;
            if (textView != null) {
                textView2 = this.eTs.cKw;
                i3 = this.eTs.eTr;
                textView2.setText(com.baidu.tbadk.core.util.at.cX(i3));
            }
            aVar = this.eTs.dyu;
            if (aVar != null) {
                aVar2 = this.eTs.dyu;
                aVar2.azO();
            }
            onSeekBarChangeListener = this.eTs.duN;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener2 = this.eTs.duN;
                i2 = this.eTs.eTr;
                onSeekBarChangeListener2.onProgressChanged(seekBar, i2, z);
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        MediaController.MediaPlayerControl mediaPlayerControl;
        int i;
        Handler handler;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2;
        mediaPlayerControl = this.eTs.cKv;
        i = this.eTs.eTr;
        mediaPlayerControl.seekTo(i);
        this.eTs.cKy = false;
        handler = this.eTs.mHandler;
        handler.sendEmptyMessageDelayed(1, 500L);
        onSeekBarChangeListener = this.eTs.duN;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener2 = this.eTs.duN;
            onSeekBarChangeListener2.onStopTrackingTouch(seekBar);
        }
    }
}
