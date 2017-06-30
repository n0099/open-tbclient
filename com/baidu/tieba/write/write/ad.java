package com.baidu.tieba.write.write;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnTouchListener {
    final /* synthetic */ WriteActivity glP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(WriteActivity writeActivity) {
        this.glP = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        EditText editText;
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.j jVar2;
        EditText editText2;
        if (motionEvent.getAction() == 2) {
            editText = this.glP.fCD;
            if (editText != null) {
                Context context = this.glP.getPageContext().getContext();
                editText2 = this.glP.fCD;
                com.baidu.adp.lib.util.k.b(context, editText2);
            }
            jVar = this.glP.azR;
            if (jVar != null) {
                jVar2 = this.glP.azR;
                jVar2.Bb();
                return false;
            }
            return false;
        }
        return false;
    }
}
