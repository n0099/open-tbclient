package com.baidu.tieba.play;

import android.os.Handler;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.tieba.play.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ au eTn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(au auVar) {
        this.eTn = auVar;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
        Handler handler;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2;
        this.eTn.aXs = true;
        onSeekBarChangeListener = this.eTn.aXx;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener2 = this.eTn.aXx;
            onSeekBarChangeListener2.onStartTrackingTouch(seekBar);
        }
        handler = this.eTn.mHandler;
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
            mediaPlayerControl = this.eTn.aXp;
            this.eTn.aXy = (int) ((mediaPlayerControl.getDuration() * i) / 10000);
            textView = this.eTn.aXq;
            if (textView != null) {
                textView2 = this.eTn.aXq;
                i3 = this.eTn.aXy;
                textView2.setText(com.baidu.tbadk.core.util.au.cS(i3));
            }
            aVar = this.eTn.duf;
            if (aVar != null) {
                aVar2 = this.eTn.duf;
                aVar2.LA();
            }
            onSeekBarChangeListener = this.eTn.aXx;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener2 = this.eTn.aXx;
                i2 = this.eTn.aXy;
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
        mediaPlayerControl = this.eTn.aXp;
        i = this.eTn.aXy;
        mediaPlayerControl.seekTo(i);
        this.eTn.aXs = false;
        handler = this.eTn.mHandler;
        handler.sendEmptyMessageDelayed(1, 500L);
        onSeekBarChangeListener = this.eTn.aXx;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener2 = this.eTn.aXx;
            onSeekBarChangeListener2.onStopTrackingTouch(seekBar);
        }
    }
}
