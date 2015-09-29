package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class bh implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity dpI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(WriteActivity writeActivity) {
        this.dpI = writeActivity;
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
        editText = this.dpI.dlZ;
        if (view != editText) {
            view2 = this.dpI.mBack;
            if (view != view2) {
                textView2 = this.dpI.dme;
            }
        }
        if (!z) {
            editText2 = this.dpI.dlZ;
            if (view == editText2) {
                textView = this.dpI.dmf;
                textView.setVisibility(0);
            }
        } else {
            this.dpI.dpF = true;
            this.dpI.aCX();
            jVar = this.dpI.dpc;
            jVar.za();
            Activity activity = this.dpI.getActivity();
            editText3 = this.dpI.dlZ;
            com.baidu.adp.lib.util.k.d(activity, editText3);
        }
        editText4 = this.dpI.dmd;
        if (view == editText4) {
            if (!z) {
                writeData = this.dpI.daX;
                if (writeData.getType() == 0) {
                    editText5 = this.dpI.dmd;
                    editText5.setHint(i.h.content);
                    return;
                }
                return;
            }
            this.dpI.dpF = false;
            writeData2 = this.dpI.daX;
            if (writeData2.getType() != 0) {
                writeData3 = this.dpI.daX;
            }
            editText6 = this.dpI.dmd;
            editText6.setHint((CharSequence) null);
            this.dpI.aCX();
            jVar2 = this.dpI.dpc;
            jVar2.za();
            Activity activity2 = this.dpI.getActivity();
            editText7 = this.dpI.dmd;
            com.baidu.adp.lib.util.k.d(activity2, editText7);
        }
    }
}
