package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ AtListActivity cwI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AtListActivity atListActivity) {
        this.cwI = atListActivity;
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
        view2 = this.cwI.bsS;
        if (view2 != null) {
            view3 = this.cwI.bsS;
            if (view3.getVisibility() == 0) {
                Activity pageActivity = this.cwI.getPageContext().getPageActivity();
                editText2 = this.cwI.mEditText;
                com.baidu.adp.lib.util.n.c(pageActivity, editText2);
                view4 = this.cwI.bsS;
                view4.setVisibility(8);
                textView = this.cwI.cwE;
                textView.setVisibility(0);
                view5 = this.cwI.bsT;
                view5.setVisibility(0);
                editText3 = this.cwI.mEditText;
                editText3.getText().clear();
                return;
            }
        }
        Activity pageActivity2 = this.cwI.getPageContext().getPageActivity();
        editText = this.cwI.mEditText;
        com.baidu.adp.lib.util.n.c(pageActivity2, editText);
        this.cwI.finish();
    }
}
