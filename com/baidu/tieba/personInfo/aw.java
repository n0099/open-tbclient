package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnClickListener {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(f fVar) {
        this.this$0 = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bf bfVar;
        FrameLayout frameLayout;
        bfVar = this.this$0.dvN;
        bfVar.aDk();
        f fVar = this.this$0;
        frameLayout = this.this$0.dCA;
        fVar.a((View) frameLayout, false, -1);
        this.this$0.XY();
    }
}
