package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ AtListActivity cxb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AtListActivity atListActivity) {
        this.cxb = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        EditText editText;
        View view3;
        EditText editText2;
        View view4;
        TextView textView;
        View view5;
        EditText editText3;
        view2 = this.cxb.bti;
        if (view2 != null) {
            view3 = this.cxb.bti;
            if (view3.getVisibility() == 0) {
                Activity pageActivity = this.cxb.getPageContext().getPageActivity();
                editText2 = this.cxb.mEditText;
                com.baidu.adp.lib.util.n.c(pageActivity, editText2);
                view4 = this.cxb.bti;
                view4.setVisibility(8);
                textView = this.cxb.cwX;
                textView.setVisibility(0);
                view5 = this.cxb.btj;
                view5.setVisibility(0);
                editText3 = this.cxb.mEditText;
                editText3.getText().clear();
                return;
            }
        }
        Activity pageActivity2 = this.cxb.getPageContext().getPageActivity();
        editText = this.cxb.mEditText;
        com.baidu.adp.lib.util.n.c(pageActivity2, editText);
        this.cxb.finish();
    }
}
