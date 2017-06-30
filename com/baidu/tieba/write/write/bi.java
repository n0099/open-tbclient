package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* loaded from: classes.dex */
class bi implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity glP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(WriteActivity writeActivity) {
        this.glP = writeActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4 == r0) goto L15;
     */
    @Override // android.view.View.OnFocusChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        TextView textView;
        com.baidu.tbadk.editortools.j jVar;
        EditText editText3;
        com.baidu.tbadk.editortools.j jVar2;
        EditText editText4;
        com.baidu.tbadk.editortools.j jVar3;
        EditText editText5;
        View view2;
        TextView textView2;
        editText = this.glP.fCz;
        if (view != editText) {
            view2 = this.glP.apb;
            if (view != view2) {
                textView2 = this.glP.mPost;
            }
        }
        if (!z) {
            editText2 = this.glP.fCz;
            if (view == editText2) {
                textView = this.glP.fCE;
                textView.setVisibility(0);
            }
        } else {
            this.glP.glL = true;
            this.glP.bub();
            jVar = this.glP.azR;
            if (jVar != null) {
                jVar2 = this.glP.azR;
                jVar2.Bb();
            }
            Activity activity = this.glP.getActivity();
            editText3 = this.glP.fCz;
            com.baidu.adp.lib.util.k.c(activity, editText3);
        }
        editText4 = this.glP.fCD;
        if (view == editText4 && z) {
            this.glP.glL = false;
            this.glP.bub();
            jVar3 = this.glP.azR;
            jVar3.Bb();
            Activity activity2 = this.glP.getActivity();
            editText5 = this.glP.fCD;
            com.baidu.adp.lib.util.k.c(activity2, editText5);
        }
    }
}
