package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ EditHeadActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(EditHeadActivity editHeadActivity) {
        this.this$0 = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.this$0.mProgress.getVisibility() != 0) {
            if ((this.this$0.mBitmap != null || this.this$0.cof != null) && view.getTag() != null) {
                this.this$0.f127com = false;
                this.this$0.D(view.getTag().toString(), false);
            }
        }
    }
}
