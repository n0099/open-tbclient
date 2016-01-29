package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ EditHeadActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EditHeadActivity editHeadActivity) {
        this.this$0 = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.this$0.aNo.getVisibility() != 0) {
            if ((this.this$0.mBitmap != null || this.this$0.cWR != null) && view.getTag() != null) {
                this.this$0.cWY = false;
                this.this$0.E(view.getTag().toString(), false);
            }
        }
    }
}
