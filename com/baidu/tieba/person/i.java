package com.baidu.tieba.person;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ EditHeadActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(EditHeadActivity editHeadActivity) {
        this.this$0 = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        Button button;
        linearLayout = this.this$0.ede;
        linearLayout.setVisibility(8);
        button = this.this$0.ecX;
        button.setVisibility(0);
    }
}
