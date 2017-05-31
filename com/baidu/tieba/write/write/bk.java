package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* loaded from: classes.dex */
class bk implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity gaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(WriteActivity writeActivity) {
        this.gaR = writeActivity;
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
        editText = this.gaR.fsp;
        if (view != editText) {
            view2 = this.gaR.aob;
            if (view != view2) {
                textView2 = this.gaR.mPost;
            }
        }
        if (!z) {
            editText2 = this.gaR.fsp;
            if (view == editText2) {
                textView = this.gaR.fsu;
                textView.setVisibility(0);
            }
        } else {
            this.gaR.gaM = true;
            this.gaR.bpD();
            jVar = this.gaR.ayP;
            if (jVar != null) {
                jVar2 = this.gaR.ayP;
                jVar2.AG();
            }
            Activity activity = this.gaR.getActivity();
            editText3 = this.gaR.fsp;
            com.baidu.adp.lib.util.k.c(activity, editText3);
        }
        editText4 = this.gaR.fst;
        if (view == editText4 && z) {
            this.gaR.gaM = false;
            this.gaR.bpD();
            jVar3 = this.gaR.ayP;
            jVar3.AG();
            Activity activity2 = this.gaR.getActivity();
            editText5 = this.gaR.fst;
            com.baidu.adp.lib.util.k.c(activity2, editText5);
        }
    }
}
