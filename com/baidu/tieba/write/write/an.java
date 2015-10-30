package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ WriteActivity dqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.dqi = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        cd cdVar;
        com.baidu.tbadk.editortools.j jVar;
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        textView = this.dqi.dmF;
        textView.setVisibility(0);
        view2 = this.dqi.dmI;
        view2.setSelected(true);
        cdVar = this.dqi.dmG;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(cdVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.dqi.getPageContext().getPageActivity(), 1.0f));
        jVar = this.dqi.dpD;
        jVar.yX();
        WriteActivity writeActivity = this.dqi;
        inputMethodManager = this.dqi.mInputManager;
        editText = this.dqi.dmz;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.dqi;
        inputMethodManager2 = this.dqi.mInputManager;
        editText2 = this.dqi.dmD;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
    }
}
