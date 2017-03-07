package com.baidu.tieba.play;

import android.widget.SeekBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ c eWb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.eWb = cVar;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        boolean z2;
        if (z) {
            z2 = this.eWb.dxU;
            if (z2) {
                this.eWb.azb();
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        String str;
        if (!this.eWb.ayX() && this.eWb.ayN() != null) {
            this.eWb.setStartPosition(this.eWb.ayN().getSeekPosition());
            c cVar = this.eWb;
            str = this.eWb.aTZ;
            cVar.startPlay(str);
        }
    }
}
