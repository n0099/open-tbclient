package com.baidu.tieba.play;

import android.os.Handler;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.tieba.play.j;
/* loaded from: classes.dex */
class m implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ j eDO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.eDO = jVar;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        Handler handler;
        Handler handler2;
        this.eDO.cDm = true;
        handler = this.eDO.mHandler;
        handler.removeMessages(1);
        handler2 = this.eDO.eDN;
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
        String kl;
        if (z) {
            mediaPlayerControl = this.eDO.cDj;
            long duration = (mediaPlayerControl.getDuration() * i) / 10000;
            mediaPlayerControl2 = this.eDO.cDj;
            mediaPlayerControl2.seekTo((int) duration);
            textView = this.eDO.cDk;
            if (textView != null) {
                textView2 = this.eDO.cDk;
                kl = this.eDO.kl((int) duration);
                textView2.setText(kl);
            }
            aVar = this.eDO.aKm;
            if (aVar != null) {
                aVar2 = this.eDO.aKm;
                aVar2.IJ();
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        Handler handler;
        Handler handler2;
        this.eDO.cDm = false;
        this.eDO.ajJ();
        handler = this.eDO.mHandler;
        handler.sendEmptyMessage(1);
        handler2 = this.eDO.eDN;
        handler2.sendEmptyMessage(2);
    }
}
