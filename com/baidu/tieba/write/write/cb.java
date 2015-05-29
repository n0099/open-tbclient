package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb implements View.OnClickListener {
    private final /* synthetic */ String bRw;
    final /* synthetic */ WriteImageActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(WriteImageActivity writeImageActivity, String str, int i) {
        this.this$0 = writeImageActivity;
        this.bRw = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        String str;
        progressBar = this.this$0.mProgress;
        if (progressBar.getVisibility() != 0) {
            String str2 = this.bRw;
            str = this.this$0.bRp;
            if (!str2.equals(str)) {
                this.this$0.iA(this.bRw);
                this.this$0.iB(this.bRw);
                this.this$0.bRn = this.val$id;
            }
        }
    }
}
