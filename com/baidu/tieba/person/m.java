package com.baidu.tieba.person;

import android.view.View;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    private final /* synthetic */ String bPd;
    final /* synthetic */ EditHeadActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(EditHeadActivity editHeadActivity, String str, int i) {
        this.this$0 = editHeadActivity;
        this.bPd = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        String str;
        progressBar = this.this$0.mProgress;
        if (progressBar.getVisibility() != 0) {
            String str2 = this.bPd;
            str = this.this$0.bOW;
            if (!str2.equals(str)) {
                this.this$0.hT(this.bPd);
                this.this$0.hU(this.bPd);
                this.this$0.bOU = this.val$id;
            }
        }
    }
}
