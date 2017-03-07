package com.baidu.tieba.play;

import android.os.Handler;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.tieba.play.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ au eWY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(au auVar) {
        this.eWY = auVar;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
        Handler handler;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2;
        this.eWY.aWG = true;
        onSeekBarChangeListener = this.eWY.aWL;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener2 = this.eWY.aWL;
            onSeekBarChangeListener2.onStartTrackingTouch(seekBar);
        }
        handler = this.eWY.mHandler;
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
            mediaPlayerControl = this.eWY.aWD;
            this.eWY.aWM = (int) ((mediaPlayerControl.getDuration() * i) / 10000);
            textView = this.eWY.aWE;
            if (textView != null) {
                textView2 = this.eWY.aWE;
                i3 = this.eWY.aWM;
                textView2.setText(com.baidu.tbadk.core.util.au.cT(i3));
            }
            aVar = this.eWY.dAS;
            if (aVar != null) {
                aVar2 = this.eWY.dAS;
                aVar2.LL();
            }
            onSeekBarChangeListener = this.eWY.aWL;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener2 = this.eWY.aWL;
                i2 = this.eWY.aWM;
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
        mediaPlayerControl = this.eWY.aWD;
        i = this.eWY.aWM;
        mediaPlayerControl.seekTo(i);
        this.eWY.aWG = false;
        handler = this.eWY.mHandler;
        handler.sendEmptyMessageDelayed(1, 500L);
        onSeekBarChangeListener = this.eWY.aWL;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener2 = this.eWY.aWL;
            onSeekBarChangeListener2.onStopTrackingTouch(seekBar);
        }
    }
}
