package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ d cSn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(d dVar) {
        this.cSn = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aw awVar;
        FrameLayout frameLayout;
        awVar = this.cSn.cMT;
        awVar.aph();
        d dVar = this.cSn;
        frameLayout = this.cSn.cRM;
        dVar.a((View) frameLayout, false, -1);
        this.cSn.TI();
    }
}
