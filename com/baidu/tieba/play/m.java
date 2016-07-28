package com.baidu.tieba.play;

import android.os.Handler;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.tieba.play.j;
/* loaded from: classes.dex */
class m implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ j ePx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.ePx = jVar;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        Handler handler;
        Handler handler2;
        this.ePx.cGb = true;
        handler = this.ePx.mHandler;
        handler.removeMessages(1);
        handler2 = this.ePx.ePw;
        handler2.removeMessages(2);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        TextView textView;
        j.a aVar;
        j.a aVar2;
        TextView textView2;
        String kr;
        if (z) {
            mediaPlayerControl = this.ePx.cFY;
            long duration = (mediaPlayerControl.getDuration() * i) / 10000;
            mediaPlayerControl2 = this.ePx.cFY;
            mediaPlayerControl2.seekTo((int) duration);
            textView = this.ePx.cFZ;
            if (textView != null) {
                textView2 = this.ePx.cFZ;
                kr = this.ePx.kr((int) duration);
                textView2.setText(kr);
            }
            aVar = this.ePx.aLf;
            if (aVar != null) {
                aVar2 = this.ePx.aLf;
                aVar2.II();
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        Handler handler;
        Handler handler2;
        this.ePx.cGb = false;
        this.ePx.akt();
        handler = this.ePx.mHandler;
        handler.sendEmptyMessage(1);
        handler2 = this.ePx.ePw;
        handler2.sendEmptyMessage(2);
    }
}
