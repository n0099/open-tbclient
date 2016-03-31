package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ WriteActivity eNd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.eNd = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        cg cgVar;
        com.baidu.tbadk.editortools.l lVar;
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        textView = this.eNd.eJt;
        textView.setVisibility(0);
        view2 = this.eNd.eJw;
        view2.setSelected(true);
        cgVar = this.eNd.eJu;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(cgVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.eNd.getPageContext().getPageActivity(), 1.0f));
        lVar = this.eNd.atG;
        lVar.BD();
        WriteActivity writeActivity = this.eNd;
        inputMethodManager = this.eNd.mInputManager;
        editText = this.eNd.eJn;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.eNd;
        inputMethodManager2 = this.eNd.mInputManager;
        editText2 = this.eNd.eJr;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
    }
}
