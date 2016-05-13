package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnClickListener {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(f fVar) {
        this.this$0 = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrameLayout frameLayout;
        bg bgVar;
        f fVar = this.this$0;
        frameLayout = this.this$0.dFH;
        fVar.a((View) frameLayout, false, -1);
        this.this$0.Pg();
        bgVar = this.this$0.dyP;
        bgVar.aDI();
    }
}
