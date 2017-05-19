package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tieba.write.album.TransparentHeadGridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements TransparentHeadGridView.b {
    final /* synthetic */ ac fNP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ac acVar) {
        this.fNP = acVar;
    }

    @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
    public void sS(int i) {
        View view;
        View view2;
        View view3;
        View view4;
        view = this.fNP.aTA;
        view.setAlpha(1.0f - (i / 100.0f));
        view2 = this.fNP.fNw;
        view2.setAlpha(i / 100.0f);
        view3 = this.fNP.fNB;
        view3.setAlpha(1.0f - (i / 100.0f));
        view4 = this.fNP.fNE;
        view4.setAlpha(1.0f - (i / 100.0f));
    }

    @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
    public void bmI() {
        View view;
        View view2;
        View view3;
        View view4;
        View view5;
        View view6;
        view = this.fNP.aTA;
        view.setVisibility(8);
        view2 = this.fNP.fNw;
        view2.setAlpha(1.0f);
        view3 = this.fNP.fNB;
        view3.setVisibility(8);
        view4 = this.fNP.fNB;
        view4.setAlpha(1.0f);
        view5 = this.fNP.fNE;
        view5.setVisibility(8);
        view6 = this.fNP.fNE;
        view6.setAlpha(1.0f);
    }
}
