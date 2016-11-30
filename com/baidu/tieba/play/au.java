package com.baidu.tieba.play;

import android.os.Handler;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.tieba.play.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ as fgG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar) {
        this.fgG = asVar;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
        Handler handler;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2;
        this.fgG.cYg = true;
        onSeekBarChangeListener = this.fgG.aSV;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener2 = this.fgG.aSV;
            onSeekBarChangeListener2.onStartTrackingTouch(seekBar);
        }
        handler = this.fgG.mHandler;
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
        String li;
        if (z) {
            mediaPlayerControl = this.fgG.aRr;
            this.fgG.fgF = (int) ((mediaPlayerControl.getDuration() * i) / 10000);
            textView = this.fgG.cYe;
            if (textView != null) {
                textView2 = this.fgG.cYe;
                as asVar = this.fgG;
                i3 = this.fgG.fgF;
                li = asVar.li(i3);
                textView2.setText(li);
            }
            aVar = this.fgG.aSZ;
            if (aVar != null) {
                aVar2 = this.fgG.aSZ;
                aVar2.Ma();
            }
            onSeekBarChangeListener = this.fgG.aSV;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener2 = this.fgG.aSV;
                i2 = this.fgG.fgF;
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
        mediaPlayerControl = this.fgG.aRr;
        i = this.fgG.fgF;
        mediaPlayerControl.seekTo(i);
        this.fgG.cYg = false;
        handler = this.fgG.mHandler;
        handler.sendEmptyMessageDelayed(1, 500L);
        onSeekBarChangeListener = this.fgG.aSV;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener2 = this.fgG.aSV;
            onSeekBarChangeListener2.onStopTrackingTouch(seekBar);
        }
    }
}
