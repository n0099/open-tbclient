package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class bh implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity ddQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(WriteActivity writeActivity) {
        this.ddQ = writeActivity;
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
        editText = this.ddQ.daX;
        if (view != editText) {
            view2 = this.ddQ.mBack;
            if (view != view2) {
                textView2 = this.ddQ.dbc;
            }
        }
        if (!z) {
            editText2 = this.ddQ.daX;
            if (view == editText2) {
                textView = this.ddQ.dbd;
                textView.setVisibility(0);
            }
        } else {
            this.ddQ.ddN = true;
            this.ddQ.azv();
            jVar = this.ddQ.ddl;
            jVar.zr();
            Activity activity = this.ddQ.getActivity();
            editText3 = this.ddQ.daX;
            com.baidu.adp.lib.util.k.d(activity, editText3);
        }
        editText4 = this.ddQ.dbb;
        if (view == editText4) {
            if (!z) {
                writeData = this.ddQ.cTs;
                if (writeData.getType() == 0) {
                    editText5 = this.ddQ.dbb;
                    editText5.setHint(i.h.content);
                    return;
                }
                return;
            }
            this.ddQ.ddN = false;
            writeData2 = this.ddQ.cTs;
            if (writeData2.getType() != 0) {
                writeData3 = this.ddQ.cTs;
            }
            editText6 = this.ddQ.dbb;
            editText6.setHint((CharSequence) null);
            this.ddQ.azv();
            jVar2 = this.ddQ.ddl;
            jVar2.zr();
            Activity activity2 = this.ddQ.getActivity();
            editText7 = this.ddQ.dbb;
            com.baidu.adp.lib.util.k.d(activity2, editText7);
        }
    }
}
