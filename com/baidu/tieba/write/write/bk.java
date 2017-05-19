package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* loaded from: classes.dex */
class bk implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity fSV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(WriteActivity writeActivity) {
        this.fSV = writeActivity;
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
        editText = this.fSV.fkx;
        if (view != editText) {
            view2 = this.fSV.aor;
            if (view != view2) {
                textView2 = this.fSV.mPost;
            }
        }
        if (!z) {
            editText2 = this.fSV.fkx;
            if (view == editText2) {
                textView = this.fSV.fkC;
                textView.setVisibility(0);
            }
        } else {
            this.fSV.fSQ = true;
            this.fSV.boe();
            jVar = this.fSV.azd;
            if (jVar != null) {
                jVar2 = this.fSV.azd;
                jVar2.AN();
            }
            Activity activity = this.fSV.getActivity();
            editText3 = this.fSV.fkx;
            com.baidu.adp.lib.util.k.c(activity, editText3);
        }
        editText4 = this.fSV.fkB;
        if (view == editText4 && z) {
            this.fSV.fSQ = false;
            this.fSV.boe();
            jVar3 = this.fSV.azd;
            jVar3.AN();
            Activity activity2 = this.fSV.getActivity();
            editText5 = this.fSV.fkB;
            com.baidu.adp.lib.util.k.c(activity2, editText5);
        }
    }
}
