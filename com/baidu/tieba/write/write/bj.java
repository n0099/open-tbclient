package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class bj implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity dsa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(WriteActivity writeActivity) {
        this.dsa = writeActivity;
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
        com.baidu.tbadk.editortools.j jVar;
        EditText editText3;
        EditText editText4;
        WriteData writeData;
        EditText editText5;
        WriteData writeData2;
        EditText editText6;
        com.baidu.tbadk.editortools.j jVar2;
        EditText editText7;
        WriteData writeData3;
        View view2;
        TextView textView2;
        editText = this.dsa.doh;
        if (view != editText) {
            view2 = this.dsa.mBack;
            if (view != view2) {
                textView2 = this.dsa.dom;
            }
        }
        if (!z) {
            editText2 = this.dsa.doh;
            if (view == editText2) {
                textView = this.dsa.don;
                textView.setVisibility(0);
            }
        } else {
            this.dsa.drX = true;
            this.dsa.aDV();
            jVar = this.dsa.drr;
            jVar.zc();
            Activity activity = this.dsa.getActivity();
            editText3 = this.dsa.doh;
            com.baidu.adp.lib.util.k.d(activity, editText3);
        }
        editText4 = this.dsa.dol;
        if (view == editText4) {
            if (!z) {
                writeData = this.dsa.ddI;
                if (writeData.getType() == 0) {
                    editText5 = this.dsa.dol;
                    editText5.setHint(i.h.content);
                    return;
                }
                return;
            }
            this.dsa.drX = false;
            writeData2 = this.dsa.ddI;
            if (writeData2.getType() != 0) {
                writeData3 = this.dsa.ddI;
            }
            editText6 = this.dsa.dol;
            editText6.setHint((CharSequence) null);
            this.dsa.aDV();
            jVar2 = this.dsa.drr;
            jVar2.zc();
            Activity activity2 = this.dsa.getActivity();
            editText7 = this.dsa.dol;
            com.baidu.adp.lib.util.k.d(activity2, editText7);
        }
    }
}
