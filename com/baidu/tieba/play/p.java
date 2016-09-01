package com.baidu.tieba.play;

import android.os.Handler;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.tieba.play.n;
/* loaded from: classes.dex */
class p implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ n eWH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.eWH = nVar;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
        Handler handler;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2;
        this.eWH.cRH = true;
        onSeekBarChangeListener = this.eWH.aPH;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener2 = this.eWH.aPH;
            onSeekBarChangeListener2.onStartTrackingTouch(seekBar);
        }
        handler = this.eWH.mHandler;
        handler.removeMessages(1);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        TextView textView;
        n.a aVar;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2;
        n.a aVar2;
        TextView textView2;
        String kU;
        if (z) {
            mediaPlayerControl = this.eWH.aOb;
            int duration = (int) ((mediaPlayerControl.getDuration() * i) / 10000);
            mediaPlayerControl2 = this.eWH.aOb;
            mediaPlayerControl2.seekTo(duration);
            textView = this.eWH.cRF;
            if (textView != null) {
                textView2 = this.eWH.cRF;
                kU = this.eWH.kU(duration);
                textView2.setText(kU);
            }
            aVar = this.eWH.aPP;
            if (aVar != null) {
                aVar2 = this.eWH.aPP;
                aVar2.KR();
            }
            onSeekBarChangeListener = this.eWH.aPH;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener2 = this.eWH.aPH;
                onSeekBarChangeListener2.onProgressChanged(seekBar, duration, z);
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
        Handler handler;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2;
        this.eWH.cRH = false;
        this.eWH.aph();
        onSeekBarChangeListener = this.eWH.aPH;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener2 = this.eWH.aPH;
            onSeekBarChangeListener2.onStopTrackingTouch(seekBar);
        }
        handler = this.eWH.mHandler;
        handler.sendEmptyMessage(1);
    }
}
