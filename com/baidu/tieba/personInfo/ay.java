package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements View.OnClickListener {
    final /* synthetic */ h this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(h hVar) {
        this.this$0 = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrameLayout frameLayout;
        bn bnVar;
        h hVar = this.this$0;
        frameLayout = this.this$0.eAB;
        hVar.a((View) frameLayout, false, -1);
        this.this$0.IL();
        bnVar = this.this$0.ers;
        bnVar.aPI();
    }
}
