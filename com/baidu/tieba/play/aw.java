package com.baidu.tieba.play;

import android.os.Handler;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.tieba.play.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ au eXn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(au auVar) {
        this.eXn = auVar;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
        Handler handler;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2;
        this.eXn.aWW = true;
        onSeekBarChangeListener = this.eXn.aXb;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener2 = this.eXn.aXb;
            onSeekBarChangeListener2.onStartTrackingTouch(seekBar);
        }
        handler = this.eXn.mHandler;
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
            mediaPlayerControl = this.eXn.aWT;
            this.eXn.aXc = (int) ((mediaPlayerControl.getDuration() * i) / 10000);
            textView = this.eXn.aWU;
            if (textView != null) {
                textView2 = this.eXn.aWU;
                i3 = this.eXn.aXc;
                textView2.setText(com.baidu.tbadk.core.util.au.cW(i3));
            }
            aVar = this.eXn.dzQ;
            if (aVar != null) {
                aVar2 = this.eXn.dzQ;
                aVar2.Mm();
            }
            onSeekBarChangeListener = this.eXn.aXb;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener2 = this.eXn.aXb;
                i2 = this.eXn.aXc;
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
        mediaPlayerControl = this.eXn.aWT;
        i = this.eXn.aXc;
        mediaPlayerControl.seekTo(i);
        this.eXn.aWW = false;
        handler = this.eXn.mHandler;
        handler.sendEmptyMessageDelayed(1, 500L);
        onSeekBarChangeListener = this.eXn.aXb;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener2 = this.eXn.aXb;
            onSeekBarChangeListener2.onStopTrackingTouch(seekBar);
        }
    }
}
