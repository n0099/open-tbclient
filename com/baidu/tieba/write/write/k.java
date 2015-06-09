package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ AtListActivity cBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AtListActivity atListActivity) {
        this.cBu = atListActivity;
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
        view2 = this.cBu.bvT;
        if (view2 != null) {
            view3 = this.cBu.bvT;
            if (view3.getVisibility() == 0) {
                Activity pageActivity = this.cBu.getPageContext().getPageActivity();
                editText2 = this.cBu.mEditText;
                com.baidu.adp.lib.util.n.c(pageActivity, editText2);
                view4 = this.cBu.bvT;
                view4.setVisibility(8);
                textView = this.cBu.cBp;
                textView.setVisibility(0);
                view5 = this.cBu.bvU;
                view5.setVisibility(0);
                editText3 = this.cBu.mEditText;
                editText3.getText().clear();
                return;
            }
        }
        Activity pageActivity2 = this.cBu.getPageContext().getPageActivity();
        editText = this.cBu.mEditText;
        com.baidu.adp.lib.util.n.c(pageActivity2, editText);
        this.cBu.finish();
    }
}
