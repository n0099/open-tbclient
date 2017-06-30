package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ ac ggh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.ggh = acVar;
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
        pVar = this.ggh.gei;
        int maxImagesAllowed = pVar.getMaxImagesAllowed();
        pVar2 = this.ggh.gei;
        if (pVar2.size() < maxImagesAllowed) {
            transparentHeadGridView = this.ggh.gfG;
            transparentHeadGridView.bsH();
            view2 = this.ggh.bDz;
            view2.setVisibility(8);
            view3 = this.ggh.gfO;
            view3.setAlpha(1.0f);
            view4 = this.ggh.gfT;
            view4.setVisibility(8);
            view5 = this.ggh.gfT;
            view5.setAlpha(1.0f);
            view6 = this.ggh.gfW;
            view6.setVisibility(8);
            view7 = this.ggh.gfW;
            view7.setAlpha(1.0f);
            return;
        }
        this.ggh.showToast(String.format(this.ggh.getPageContext().getString(w.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
    }
}
