package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ EditHeadActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(EditHeadActivity editHeadActivity) {
        this.this$0 = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.this$0.setResult(0);
        this.this$0.finish();
    }
}
