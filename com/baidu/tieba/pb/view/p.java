package com.baidu.tieba.pb.view;

import android.os.Handler;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
/* loaded from: classes.dex */
class p implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ PbVideoControllerView dsP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbVideoControllerView pbVideoControllerView) {
        this.dsP = pbVideoControllerView;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        Handler handler;
        this.dsP.dsJ = true;
        handler = this.dsP.mHandler;
        handler.removeMessages(1);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        TextView textView;
        TextView textView2;
        String mf;
        if (z) {
            mediaPlayerControl = this.dsP.dsG;
            long duration = (mediaPlayerControl.getDuration() * i) / 10000;
            mediaPlayerControl2 = this.dsP.dsG;
            mediaPlayerControl2.seekTo((int) duration);
            textView = this.dsP.dsH;
            if (textView != null) {
                textView2 = this.dsP.dsH;
                mf = this.dsP.mf((int) duration);
                textView2.setText(mf);
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        Handler handler;
        this.dsP.dsJ = false;
        this.dsP.aAP();
        handler = this.dsP.mHandler;
        handler.sendEmptyMessage(1);
    }
}
