package com.baidu.tieba.play;

import android.os.Handler;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.tieba.play.z;
/* loaded from: classes.dex */
class ab implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ z eZj;
    int eZk = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar) {
        this.eZj = zVar;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
        Handler handler;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2;
        this.eZj.cSy = true;
        onSeekBarChangeListener = this.eZj.aQT;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener2 = this.eZj.aQT;
            onSeekBarChangeListener2.onStartTrackingTouch(seekBar);
        }
        handler = this.eZj.mHandler;
        handler.removeMessages(1);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        MediaController.MediaPlayerControl mediaPlayerControl;
        TextView textView;
        z.a aVar;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2;
        z.a aVar2;
        TextView textView2;
        String la;
        if (z) {
            mediaPlayerControl = this.eZj.aPl;
            this.eZk = (int) ((mediaPlayerControl.getDuration() * i) / 10000);
            textView = this.eZj.cSw;
            if (textView != null) {
                textView2 = this.eZj.cSw;
                la = this.eZj.la(this.eZk);
                textView2.setText(la);
            }
            aVar = this.eZj.aRb;
            if (aVar != null) {
                aVar2 = this.eZj.aRb;
                aVar2.Lz();
            }
            onSeekBarChangeListener = this.eZj.aQT;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener2 = this.eZj.aQT;
                onSeekBarChangeListener2.onProgressChanged(seekBar, this.eZk, z);
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        MediaController.MediaPlayerControl mediaPlayerControl;
        Handler handler;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2;
        mediaPlayerControl = this.eZj.aPl;
        mediaPlayerControl.seekTo(this.eZk);
        this.eZj.cSy = false;
        handler = this.eZj.mHandler;
        handler.sendEmptyMessageDelayed(1, 500L);
        onSeekBarChangeListener = this.eZj.aQT;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener2 = this.eZj.aQT;
            onSeekBarChangeListener2.onStopTrackingTouch(seekBar);
        }
    }
}
