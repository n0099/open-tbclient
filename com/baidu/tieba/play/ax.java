package com.baidu.tieba.play;

import android.os.Handler;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.tieba.play.av;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ av fmq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(av avVar) {
        this.fmq = avVar;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
        Handler handler;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2;
        this.fmq.aWn = true;
        onSeekBarChangeListener = this.fmq.aWs;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener2 = this.fmq.aWs;
            onSeekBarChangeListener2.onStartTrackingTouch(seekBar);
        }
        handler = this.fmq.mHandler;
        handler.removeMessages(1);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        MediaController.MediaPlayerControl mediaPlayerControl;
        TextView textView;
        av.a aVar;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2;
        int i2;
        av.a aVar2;
        TextView textView2;
        int i3;
        if (z) {
            mediaPlayerControl = this.fmq.aWk;
            this.fmq.aWt = (int) ((mediaPlayerControl.getDuration() * i) / 10000);
            textView = this.fmq.aWl;
            if (textView != null) {
                textView2 = this.fmq.aWl;
                i3 = this.fmq.aWt;
                textView2.setText(com.baidu.tbadk.core.util.aw.cV(i3));
            }
            aVar = this.fmq.dIj;
            if (aVar != null) {
                aVar2 = this.fmq.dIj;
                aVar2.KT();
            }
            onSeekBarChangeListener = this.fmq.aWs;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener2 = this.fmq.aWs;
                i2 = this.fmq.aWt;
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
        mediaPlayerControl = this.fmq.aWk;
        i = this.fmq.aWt;
        mediaPlayerControl.seekTo(i);
        this.fmq.aWn = false;
        handler = this.fmq.mHandler;
        handler.sendEmptyMessageDelayed(1, 500L);
        onSeekBarChangeListener = this.fmq.aWs;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener2 = this.fmq.aWs;
            onSeekBarChangeListener2.onStopTrackingTouch(seekBar);
        }
    }
}
