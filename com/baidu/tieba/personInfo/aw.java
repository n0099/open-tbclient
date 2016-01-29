package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnClickListener {
    final /* synthetic */ f diG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(f fVar) {
        this.diG = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bf bfVar;
        FrameLayout frameLayout;
        bfVar = this.diG.dbl;
        bfVar.avF();
        f fVar = this.diG;
        frameLayout = this.diG.dhY;
        fVar.a((View) frameLayout, false, -1);
        this.diG.avv();
    }
}
