package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class bh implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity fVn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(WriteActivity writeActivity) {
        this.fVn = writeActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0064, code lost:
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
        com.baidu.tbadk.editortools.l lVar;
        EditText editText3;
        EditText editText4;
        WriteData writeData;
        EditText editText5;
        WriteData writeData2;
        EditText editText6;
        com.baidu.tbadk.editortools.l lVar2;
        EditText editText7;
        WriteData writeData3;
        View view2;
        TextView textView2;
        editText = this.fVn.faJ;
        if (view != editText) {
            view2 = this.fVn.agC;
            if (view != view2) {
                textView2 = this.fVn.faO;
            }
        }
        if (!z) {
            editText2 = this.fVn.faJ;
            if (view == editText2) {
                textView = this.fVn.faP;
                textView.setVisibility(0);
            }
        } else {
            this.fVn.fVj = true;
            this.fVn.boT();
            lVar = this.fVn.ard;
            lVar.zD();
            Activity activity = this.fVn.getActivity();
            editText3 = this.fVn.faJ;
            com.baidu.adp.lib.util.k.c(activity, editText3);
        }
        editText4 = this.fVn.faN;
        if (view == editText4) {
            if (!z) {
                writeData = this.fVn.faq;
                if (writeData.getType() == 0) {
                    editText5 = this.fVn.faN;
                    editText5.setHint(u.j.write_input_content);
                    return;
                }
                return;
            }
            this.fVn.fVj = false;
            writeData2 = this.fVn.faq;
            if (writeData2.getType() != 0) {
                writeData3 = this.fVn.faq;
            }
            editText6 = this.fVn.faN;
            editText6.setHint((CharSequence) null);
            this.fVn.boT();
            lVar2 = this.fVn.ard;
            lVar2.zD();
            Activity activity2 = this.fVn.getActivity();
            editText7 = this.fVn.faN;
            com.baidu.adp.lib.util.k.c(activity2, editText7);
        }
    }
}
