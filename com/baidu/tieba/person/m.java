package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    private final /* synthetic */ String dvb;
    final /* synthetic */ EditHeadActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(EditHeadActivity editHeadActivity, String str, int i) {
        this.this$0 = editHeadActivity;
        this.dvb = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.this$0.bDI.getVisibility() != 0) {
            this.this$0.duB.f(this.this$0.mBitmap);
            this.this$0.duV = false;
            this.this$0.mo(this.dvb);
            this.this$0.duR = this.val$id;
        }
    }
}
