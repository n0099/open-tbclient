package com.baidu.tieba.play;

import android.os.Handler;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.tieba.play.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ as eJY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar) {
        this.eJY = asVar;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
        Handler handler;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2;
        this.eJY.cDp = true;
        onSeekBarChangeListener = this.eJY.aSm;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener2 = this.eJY.aSm;
            onSeekBarChangeListener2.onStartTrackingTouch(seekBar);
        }
        handler = this.eJY.mHandler;
        handler.removeMessages(1);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        MediaController.MediaPlayerControl mediaPlayerControl;
        TextView textView;
        as.a aVar;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2;
        int i2;
        as.a aVar2;
        TextView textView2;
        int i3;
        String ks;
        if (z) {
            mediaPlayerControl = this.eJY.aQI;
            this.eJY.eJX = (int) ((mediaPlayerControl.getDuration() * i) / 10000);
            textView = this.eJY.cDn;
            if (textView != null) {
                textView2 = this.eJY.cDn;
                as asVar = this.eJY;
                i3 = this.eJY.eJX;
                ks = asVar.ks(i3);
                textView2.setText(ks);
            }
            aVar = this.eJY.aSq;
            if (aVar != null) {
                aVar2 = this.eJY.aSq;
                aVar2.Lt();
            }
            onSeekBarChangeListener = this.eJY.aSm;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener2 = this.eJY.aSm;
                i2 = this.eJY.eJX;
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
        mediaPlayerControl = this.eJY.aQI;
        i = this.eJY.eJX;
        mediaPlayerControl.seekTo(i);
        this.eJY.cDp = false;
        handler = this.eJY.mHandler;
        handler.sendEmptyMessageDelayed(1, 500L);
        onSeekBarChangeListener = this.eJY.aSm;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener2 = this.eJY.aSm;
            onSeekBarChangeListener2.onStopTrackingTouch(seekBar);
        }
    }
}
