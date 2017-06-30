package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tieba.write.album.TransparentHeadGridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements TransparentHeadGridView.b {
    final /* synthetic */ ac ggh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ac acVar) {
        this.ggh = acVar;
    }

    @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
    public void tI(int i) {
        View view;
        View view2;
        View view3;
        View view4;
        view = this.ggh.bDz;
        view.setAlpha(1.0f - (i / 100.0f));
        view2 = this.ggh.gfO;
        view2.setAlpha(i / 100.0f);
        view3 = this.ggh.gfT;
        view3.setAlpha(1.0f - (i / 100.0f));
        view4 = this.ggh.gfW;
        view4.setAlpha(1.0f - (i / 100.0f));
    }

    @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
    public void bsC() {
        View view;
        View view2;
        View view3;
        View view4;
        View view5;
        View view6;
        view = this.ggh.bDz;
        view.setVisibility(8);
        view2 = this.ggh.gfO;
        view2.setAlpha(1.0f);
        view3 = this.ggh.gfT;
        view3.setVisibility(8);
        view4 = this.ggh.gfT;
        view4.setAlpha(1.0f);
        view5 = this.ggh.gfW;
        view5.setVisibility(8);
        view6 = this.ggh.gfW;
        view6.setAlpha(1.0f);
    }
}
