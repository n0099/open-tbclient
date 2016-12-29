package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class bi implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity fDQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(WriteActivity writeActivity) {
        this.fDQ = writeActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006c, code lost:
        if (r0.getType() == 4) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4 == r0) goto L24;
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
        WriteData writeData;
        EditText editText5;
        WriteData writeData2;
        EditText editText6;
        com.baidu.tbadk.editortools.j jVar3;
        EditText editText7;
        WriteData writeData3;
        View view2;
        TextView textView2;
        editText = this.fDQ.eWF;
        if (view != editText) {
            view2 = this.fDQ.ajr;
            if (view != view2) {
                textView2 = this.fDQ.eWK;
            }
        }
        if (!z) {
            editText2 = this.fDQ.eWF;
            if (view == editText2) {
                textView = this.fDQ.eWL;
                textView.setVisibility(0);
            }
        } else {
            this.fDQ.fDM = true;
            this.fDQ.bnh();
            jVar = this.fDQ.aun;
            if (jVar != null) {
                jVar2 = this.fDQ.aun;
                jVar2.AP();
            }
            Activity activity = this.fDQ.getActivity();
            editText3 = this.fDQ.eWF;
            com.baidu.adp.lib.util.k.c(activity, editText3);
        }
        editText4 = this.fDQ.eWJ;
        if (view == editText4) {
            if (!z) {
                writeData = this.fDQ.eWm;
                if (writeData.getType() == 0) {
                    editText5 = this.fDQ.eWJ;
                    editText5.setHint(r.j.write_input_content);
                    return;
                }
                return;
            }
            this.fDQ.fDM = false;
            writeData2 = this.fDQ.eWm;
            if (writeData2.getType() != 0) {
                writeData3 = this.fDQ.eWm;
            }
            editText6 = this.fDQ.eWJ;
            editText6.setHint((CharSequence) null);
            this.fDQ.bnh();
            jVar3 = this.fDQ.aun;
            jVar3.AP();
            Activity activity2 = this.fDQ.getActivity();
            editText7 = this.fDQ.eWJ;
            com.baidu.adp.lib.util.k.c(activity2, editText7);
        }
    }
}
