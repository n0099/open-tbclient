package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ WriteActivity dqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(WriteActivity writeActivity) {
        this.dqi = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        cd cdVar;
        com.baidu.tbadk.editortools.j jVar;
        InputMethodManager inputMethodManager;
        EditText aDt;
        InputMethodManager inputMethodManager2;
        EditText aDs;
        textView = this.dqi.dmF;
        textView.setSelected(true);
        cdVar = this.dqi.dmG;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(cdVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.dqi.getPageContext().getPageActivity(), 1.0f));
        jVar = this.dqi.dpD;
        jVar.yX();
        WriteActivity writeActivity = this.dqi;
        inputMethodManager = this.dqi.mInputManager;
        aDt = this.dqi.aDt();
        writeActivity.HidenSoftKeyPad(inputMethodManager, aDt);
        WriteActivity writeActivity2 = this.dqi;
        inputMethodManager2 = this.dqi.mInputManager;
        aDs = this.dqi.aDs();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, aDs);
    }
}
