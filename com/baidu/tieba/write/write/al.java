package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ WriteActivity fQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.fQG = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        com.baidu.tieba.write.b bVar;
        com.baidu.tbadk.editortools.j jVar;
        InputMethodManager inputMethodManager;
        EditText boJ;
        InputMethodManager inputMethodManager2;
        EditText boI;
        textView = this.fQG.fkB;
        textView.setSelected(true);
        bVar = this.fQG.fkC;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(bVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.fQG.getPageContext().getPageActivity(), 1.0f));
        jVar = this.fQG.ayN;
        jVar.Bd();
        WriteActivity writeActivity = this.fQG;
        inputMethodManager = this.fQG.mInputManager;
        boJ = this.fQG.boJ();
        writeActivity.HidenSoftKeyPad(inputMethodManager, boJ);
        WriteActivity writeActivity2 = this.fQG;
        inputMethodManager2 = this.fQG.mInputManager;
        boI = this.fQG.boI();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, boI);
    }
}
