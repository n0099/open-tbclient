package com.baidu.tieba.play;

import android.widget.SeekBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ c flr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.flr = cVar;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        boolean z2;
        if (z) {
            z2 = this.flr.dEW;
            if (z2) {
                this.flr.aBv();
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        String str;
        if (!this.flr.aBr() && this.flr.aBh() != null) {
            this.flr.setStartPosition(this.flr.aBh().getSeekPosition());
            c cVar = this.flr;
            str = this.flr.mVideoUrl;
            cVar.startPlay(str);
        }
    }
}
