package com.baidu.tieba.im.validate;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.im.data.ValidateItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i bpW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.bpW = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ValidateActivity validateActivity;
        TextView textView;
        ValidateItemData validateItemData;
        validateActivity = this.bpW.bpR;
        textView = this.bpW.bpU;
        validateItemData = this.bpW.bpV;
        validateActivity.a(textView, 100, 0, 0L, validateItemData);
    }
}
