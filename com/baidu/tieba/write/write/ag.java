package com.baidu.tieba.write.write;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnTouchListener {
    final /* synthetic */ WriteActivity fSV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WriteActivity writeActivity) {
        this.fSV = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        EditText editText;
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.j jVar2;
        EditText editText2;
        if (motionEvent.getAction() == 2) {
            editText = this.fSV.fkB;
            if (editText != null) {
                Context context = this.fSV.getPageContext().getContext();
                editText2 = this.fSV.fkB;
                com.baidu.adp.lib.util.k.b(context, editText2);
            }
            jVar = this.fSV.azd;
            if (jVar != null) {
                jVar2 = this.fSV.azd;
                jVar2.AN();
                return false;
            }
            return false;
        }
        return false;
    }
}
