package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    private final /* synthetic */ String drF;
    final /* synthetic */ EditHeadActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(EditHeadActivity editHeadActivity, String str, int i) {
        this.this$0 = editHeadActivity;
        this.drF = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.this$0.aQj.getVisibility() != 0) {
            this.this$0.drg.replaceImageBitmap(this.this$0.mBitmap);
            this.this$0.drA = false;
            this.this$0.mk(this.drF);
            this.this$0.drw = this.val$id;
        }
    }
}
