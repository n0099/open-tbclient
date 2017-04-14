package com.baidu.tieba.play;

import android.os.Handler;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.tieba.play.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ au eUX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(au auVar) {
        this.eUX = auVar;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
        Handler handler;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2;
        this.eUX.aWT = true;
        onSeekBarChangeListener = this.eUX.aWY;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener2 = this.eUX.aWY;
            onSeekBarChangeListener2.onStartTrackingTouch(seekBar);
        }
        handler = this.eUX.mHandler;
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
            mediaPlayerControl = this.eUX.aWQ;
            this.eUX.aWZ = (int) ((mediaPlayerControl.getDuration() * i) / 10000);
            textView = this.eUX.aWR;
            if (textView != null) {
                textView2 = this.eUX.aWR;
                i3 = this.eUX.aWZ;
                textView2.setText(com.baidu.tbadk.core.util.au.cW(i3));
            }
            aVar = this.eUX.dxA;
            if (aVar != null) {
                aVar2 = this.eUX.dxA;
                aVar2.Mm();
            }
            onSeekBarChangeListener = this.eUX.aWY;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener2 = this.eUX.aWY;
                i2 = this.eUX.aWZ;
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
        mediaPlayerControl = this.eUX.aWQ;
        i = this.eUX.aWZ;
        mediaPlayerControl.seekTo(i);
        this.eUX.aWT = false;
        handler = this.eUX.mHandler;
        handler.sendEmptyMessageDelayed(1, 500L);
        onSeekBarChangeListener = this.eUX.aWY;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener2 = this.eUX.aWY;
            onSeekBarChangeListener2.onStopTrackingTouch(seekBar);
        }
    }
}
