package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    private final /* synthetic */ String cpY;
    final /* synthetic */ EditHeadActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(EditHeadActivity editHeadActivity, String str, int i) {
        this.this$0 = editHeadActivity;
        this.cpY = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (this.this$0.mProgress.getVisibility() != 0) {
            String str2 = this.cpY;
            str = this.this$0.cpR;
            if (!str2.equals(str)) {
                this.this$0.D(this.cpY, true);
                this.this$0.kb(this.cpY);
                this.this$0.cpP = this.val$id;
            }
        }
    }
}
