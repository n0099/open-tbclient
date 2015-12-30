package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ d cWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(d dVar) {
        this.cWV = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bb bbVar;
        FrameLayout frameLayout;
        bbVar = this.cWV.cRx;
        bbVar.aqu();
        d dVar = this.cWV;
        frameLayout = this.cWV.cWp;
        dVar.a((View) frameLayout, false, -1);
        this.cWV.aqe();
    }
}
