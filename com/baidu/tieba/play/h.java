package com.baidu.tieba.play;

import android.widget.SeekBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ c fbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.fbb = cVar;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        boolean z2;
        if (z) {
            z2 = this.fbb.dwj;
            if (z2) {
                this.fbb.axw();
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        String str;
        if (!this.fbb.axs() && this.fbb.axi() != null) {
            this.fbb.setStartPosition(this.fbb.axi().getSeekPosition());
            c cVar = this.fbb;
            str = this.fbb.mVideoUrl;
            cVar.startPlay(str);
        }
    }
}
