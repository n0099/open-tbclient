package com.baidu.tieba.play;

import android.os.Handler;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.tieba.play.av;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ av fca;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(av avVar) {
        this.fca = avVar;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
        Handler handler;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2;
        this.fca.aUU = true;
        onSeekBarChangeListener = this.fca.aUZ;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener2 = this.fca.aUZ;
            onSeekBarChangeListener2.onStartTrackingTouch(seekBar);
        }
        handler = this.fca.mHandler;
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
            mediaPlayerControl = this.fca.aUR;
            this.fca.aVa = (int) ((mediaPlayerControl.getDuration() * i) / 10000);
            textView = this.fca.aUS;
            if (textView != null) {
                textView2 = this.fca.aUS;
                i3 = this.fca.aVa;
                textView2.setText(com.baidu.tbadk.core.util.au.cT(i3));
            }
            aVar = this.fca.dzx;
            if (aVar != null) {
                aVar2 = this.fca.dzx;
                aVar2.Kv();
            }
            onSeekBarChangeListener = this.fca.aUZ;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener2 = this.fca.aUZ;
                i2 = this.fca.aVa;
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
        mediaPlayerControl = this.fca.aUR;
        i = this.fca.aVa;
        mediaPlayerControl.seekTo(i);
        this.fca.aUU = false;
        handler = this.fca.mHandler;
        handler.sendEmptyMessageDelayed(1, 500L);
        onSeekBarChangeListener = this.fca.aUZ;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener2 = this.fca.aUZ;
            onSeekBarChangeListener2.onStopTrackingTouch(seekBar);
        }
    }
}
