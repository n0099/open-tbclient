package com.baidu.tieba.pb.view;

import android.os.Handler;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
/* loaded from: classes.dex */
class j implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ PbVideoControllerView dqL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbVideoControllerView pbVideoControllerView) {
        this.dqL = pbVideoControllerView;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        Handler handler;
        this.dqL.dqF = true;
        handler = this.dqL.mHandler;
        handler.removeMessages(1);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        TextView textView;
        TextView textView2;
        String mt;
        if (z) {
            mediaPlayerControl = this.dqL.dqC;
            long duration = (mediaPlayerControl.getDuration() * i) / 10000;
            mediaPlayerControl2 = this.dqL.dqC;
            mediaPlayerControl2.seekTo((int) duration);
            textView = this.dqL.dqD;
            if (textView != null) {
                textView2 = this.dqL.dqD;
                mt = this.dqL.mt((int) duration);
                textView2.setText(mt);
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        Handler handler;
        this.dqL.dqF = false;
        this.dqL.aAE();
        handler = this.dqL.mHandler;
        handler.sendEmptyMessage(1);
    }
}
