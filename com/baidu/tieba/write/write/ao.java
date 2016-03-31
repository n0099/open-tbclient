package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ WriteActivity eNd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(WriteActivity writeActivity) {
        this.eNd = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        cg cgVar;
        com.baidu.tbadk.editortools.l lVar;
        InputMethodManager inputMethodManager;
        EditText bbz;
        InputMethodManager inputMethodManager2;
        EditText bby;
        textView = this.eNd.eJt;
        textView.setSelected(true);
        cgVar = this.eNd.eJu;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(cgVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.eNd.getPageContext().getPageActivity(), 1.0f));
        lVar = this.eNd.atG;
        lVar.BD();
        WriteActivity writeActivity = this.eNd;
        inputMethodManager = this.eNd.mInputManager;
        bbz = this.eNd.bbz();
        writeActivity.HidenSoftKeyPad(inputMethodManager, bbz);
        WriteActivity writeActivity2 = this.eNd;
        inputMethodManager2 = this.eNd.mInputManager;
        bby = this.eNd.bby();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, bby);
    }
}
