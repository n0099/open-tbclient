package com.baidu.tieba.play;

import android.widget.SeekBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ c eSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.eSq = cVar;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        boolean z2;
        if (z) {
            z2 = this.eSq.dqR;
            if (z2) {
                this.eSq.awD();
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        String str;
        if (!this.eSq.awz() && this.eSq.awp() != null) {
            this.eSq.setStartPosition(this.eSq.awp().getSeekPosition());
            c cVar = this.eSq;
            str = this.eSq.mVideoUrl;
            cVar.startPlay(str);
        }
    }
}
