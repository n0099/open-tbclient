package com.baidu.tieba.play;

import android.widget.SeekBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ c eUa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.eUa = cVar;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        boolean z2;
        if (z) {
            z2 = this.eUa.dur;
            if (z2) {
                this.eUa.ayF();
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        String str;
        if (!this.eUa.ayB() && this.eUa.ayr() != null) {
            this.eUa.setStartPosition(this.eUa.ayr().getSeekPosition());
            c cVar = this.eUa;
            str = this.eUa.mVideoUrl;
            cVar.startPlay(str);
        }
    }
}
