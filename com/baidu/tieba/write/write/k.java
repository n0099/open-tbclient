package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ AtListActivity cBt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AtListActivity atListActivity) {
        this.cBt = atListActivity;
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
        view2 = this.cBt.bvS;
        if (view2 != null) {
            view3 = this.cBt.bvS;
            if (view3.getVisibility() == 0) {
                Activity pageActivity = this.cBt.getPageContext().getPageActivity();
                editText2 = this.cBt.mEditText;
                com.baidu.adp.lib.util.n.c(pageActivity, editText2);
                view4 = this.cBt.bvS;
                view4.setVisibility(8);
                textView = this.cBt.cBo;
                textView.setVisibility(0);
                view5 = this.cBt.bvT;
                view5.setVisibility(0);
                editText3 = this.cBt.mEditText;
                editText3.getText().clear();
                return;
            }
        }
        Activity pageActivity2 = this.cBt.getPageContext().getPageActivity();
        editText = this.cBt.mEditText;
        com.baidu.adp.lib.util.n.c(pageActivity2, editText);
        this.cBt.finish();
    }
}
