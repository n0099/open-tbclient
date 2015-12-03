package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class bk implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity dRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(WriteActivity writeActivity) {
        this.dRf = writeActivity;
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
        com.baidu.tbadk.editortools.k kVar;
        EditText editText3;
        EditText editText4;
        WriteData writeData;
        EditText editText5;
        WriteData writeData2;
        EditText editText6;
        com.baidu.tbadk.editortools.k kVar2;
        EditText editText7;
        WriteData writeData3;
        View view2;
        TextView textView2;
        editText = this.dRf.dNn;
        if (view != editText) {
            view2 = this.dRf.mBack;
            if (view != view2) {
                textView2 = this.dRf.dNs;
            }
        }
        if (!z) {
            editText2 = this.dRf.dNn;
            if (view == editText2) {
                textView = this.dRf.dNt;
                textView.setVisibility(0);
            }
        } else {
            this.dRf.dRc = true;
            this.dRf.aJs();
            kVar = this.dRf.aqK;
            kVar.zY();
            Activity activity = this.dRf.getActivity();
            editText3 = this.dRf.dNn;
            com.baidu.adp.lib.util.k.d(activity, editText3);
        }
        editText4 = this.dRf.dNr;
        if (view == editText4) {
            if (!z) {
                writeData = this.dRf.dBW;
                if (writeData.getType() == 0) {
                    editText5 = this.dRf.dNr;
                    editText5.setHint(n.i.content);
                    return;
                }
                return;
            }
            this.dRf.dRc = false;
            writeData2 = this.dRf.dBW;
            if (writeData2.getType() != 0) {
                writeData3 = this.dRf.dBW;
            }
            editText6 = this.dRf.dNr;
            editText6.setHint((CharSequence) null);
            this.dRf.aJs();
            kVar2 = this.dRf.aqK;
            kVar2.zY();
            Activity activity2 = this.dRf.getActivity();
            editText7 = this.dRf.dNr;
            com.baidu.adp.lib.util.k.d(activity2, editText7);
        }
    }
}
