package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tieba.write.album.TransparentHeadGridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements TransparentHeadGridView.b {
    final /* synthetic */ ac fVw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ac acVar) {
        this.fVw = acVar;
    }

    @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
    public void tn(int i) {
        View view;
        View view2;
        View view3;
        View view4;
        view = this.fVw.bCG;
        view.setAlpha(1.0f - (i / 100.0f));
        view2 = this.fVw.fVd;
        view2.setAlpha(i / 100.0f);
        view3 = this.fVw.fVi;
        view3.setAlpha(1.0f - (i / 100.0f));
        view4 = this.fVw.fVl;
        view4.setAlpha(1.0f - (i / 100.0f));
    }

    @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
    public void bof() {
        View view;
        View view2;
        View view3;
        View view4;
        View view5;
        View view6;
        view = this.fVw.bCG;
        view.setVisibility(8);
        view2 = this.fVw.fVd;
        view2.setAlpha(1.0f);
        view3 = this.fVw.fVi;
        view3.setVisibility(8);
        view4 = this.fVw.fVi;
        view4.setAlpha(1.0f);
        view5 = this.fVw.fVl;
        view5.setVisibility(8);
        view6 = this.fVw.fVl;
        view6.setAlpha(1.0f);
    }
}
