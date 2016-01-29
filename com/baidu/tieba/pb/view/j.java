package com.baidu.tieba.pb.view;

import android.os.Handler;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
/* loaded from: classes.dex */
class j implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ PbVideoControllerView cVQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbVideoControllerView pbVideoControllerView) {
        this.cVQ = pbVideoControllerView;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        Handler handler;
        this.cVQ.cVK = true;
        handler = this.cVQ.mHandler;
        handler.removeMessages(1);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        TextView textView;
        TextView textView2;
        String lk;
        if (z) {
            mediaPlayerControl = this.cVQ.cVH;
            long duration = (mediaPlayerControl.getDuration() * i) / 10000;
            mediaPlayerControl2 = this.cVQ.cVH;
            mediaPlayerControl2.seekTo((int) duration);
            textView = this.cVQ.cVI;
            if (textView != null) {
                textView2 = this.cVQ.cVI;
                lk = this.cVQ.lk((int) duration);
                textView2.setText(lk);
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        Handler handler;
        this.cVQ.cVK = false;
        this.cVQ.asU();
        handler = this.cVQ.mHandler;
        handler.sendEmptyMessage(1);
    }
}
