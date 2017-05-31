package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ ac fVw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.fVw = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        p pVar2;
        TransparentHeadGridView transparentHeadGridView;
        View view2;
        View view3;
        View view4;
        View view5;
        View view6;
        View view7;
        pVar = this.fVw.fTx;
        int maxImagesAllowed = pVar.getMaxImagesAllowed();
        pVar2 = this.fVw.fTx;
        if (pVar2.size() < maxImagesAllowed) {
            transparentHeadGridView = this.fVw.fUV;
            transparentHeadGridView.bok();
            view2 = this.fVw.bCG;
            view2.setVisibility(8);
            view3 = this.fVw.fVd;
            view3.setAlpha(1.0f);
            view4 = this.fVw.fVi;
            view4.setVisibility(8);
            view5 = this.fVw.fVi;
            view5.setAlpha(1.0f);
            view6 = this.fVw.fVl;
            view6.setVisibility(8);
            view7 = this.fVw.fVl;
            view7.setAlpha(1.0f);
            return;
        }
        this.fVw.showToast(String.format(this.fVw.getPageContext().getString(w.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
    }
}
