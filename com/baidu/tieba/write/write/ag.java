package com.baidu.tieba.write.write;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnTouchListener {
    final /* synthetic */ WriteActivity gaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WriteActivity writeActivity) {
        this.gaR = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        EditText editText;
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.j jVar2;
        EditText editText2;
        if (motionEvent.getAction() == 2) {
            editText = this.gaR.fst;
            if (editText != null) {
                Context context = this.gaR.getPageContext().getContext();
                editText2 = this.gaR.fst;
                com.baidu.adp.lib.util.k.b(context, editText2);
            }
            jVar = this.gaR.ayP;
            if (jVar != null) {
                jVar2 = this.gaR.ayP;
                jVar2.AG();
                return false;
            }
            return false;
        }
        return false;
    }
}
