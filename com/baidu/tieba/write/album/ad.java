package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ ac fNP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.fNP = acVar;
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
        pVar = this.fNP.fLQ;
        int maxImagesAllowed = pVar.getMaxImagesAllowed();
        pVar2 = this.fNP.fLQ;
        if (pVar2.size() < maxImagesAllowed) {
            transparentHeadGridView = this.fNP.fNo;
            transparentHeadGridView.bmN();
            view2 = this.fNP.aTA;
            view2.setVisibility(8);
            view3 = this.fNP.fNw;
            view3.setAlpha(1.0f);
            view4 = this.fNP.fNB;
            view4.setVisibility(8);
            view5 = this.fNP.fNB;
            view5.setAlpha(1.0f);
            view6 = this.fNP.fNE;
            view6.setVisibility(8);
            view7 = this.fNP.fNE;
            view7.setAlpha(1.0f);
            return;
        }
        this.fNP.showToast(String.format(this.fNP.getPageContext().getString(w.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
    }
}
