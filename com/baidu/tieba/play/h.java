package com.baidu.tieba.play;

import android.widget.SeekBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ c eWq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.eWq = cVar;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        boolean z2;
        if (z) {
            z2 = this.eWq.dwI;
            if (z2) {
                this.eWq.azG();
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        String str;
        if (!this.eWq.azC() && this.eWq.azs() != null) {
            this.eWq.setStartPosition(this.eWq.azs().getSeekPosition());
            c cVar = this.eWq;
            str = this.eWq.mVideoUrl;
            cVar.startPlay(str);
        }
    }
}
