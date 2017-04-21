package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ WriteActivity fUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.fUM = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        com.baidu.tieba.write.b bVar;
        com.baidu.tbadk.editortools.j jVar;
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        textView = this.fUM.foB;
        textView.setVisibility(0);
        view2 = this.fUM.foE;
        view2.setSelected(true);
        bVar = this.fUM.foC;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(bVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.fUM.getPageContext().getPageActivity(), 1.0f));
        jVar = this.fUM.azf;
        jVar.BC();
        WriteActivity writeActivity = this.fUM;
        inputMethodManager = this.fUM.mInputManager;
        editText = this.fUM.fow;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.fUM;
        inputMethodManager2 = this.fUM.mInputManager;
        editText2 = this.fUM.foA;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
    }
}
