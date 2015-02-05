package com.baidu.tieba.im.validate;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.im.data.ValidateItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i bpV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.bpV = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ValidateActivity validateActivity;
        TextView textView;
        ValidateItemData validateItemData;
        validateActivity = this.bpV.bpQ;
        textView = this.bpV.bpT;
        validateItemData = this.bpV.bpU;
        validateActivity.a(textView, 100, 0, 0L, validateItemData);
    }
}
