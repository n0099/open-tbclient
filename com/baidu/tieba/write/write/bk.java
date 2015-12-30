package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class bk implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity dYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(WriteActivity writeActivity) {
        this.dYD = writeActivity;
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
        editText = this.dYD.dUM;
        if (view != editText) {
            view2 = this.dYD.mBack;
            if (view != view2) {
                textView2 = this.dYD.dUR;
            }
        }
        if (!z) {
            editText2 = this.dYD.dUM;
            if (view == editText2) {
                textView = this.dYD.dUS;
                textView.setVisibility(0);
            }
        } else {
            this.dYD.dYA = true;
            this.dYD.aLN();
            kVar = this.dYD.aso;
            kVar.zK();
            Activity activity = this.dYD.getActivity();
            editText3 = this.dYD.dUM;
            com.baidu.adp.lib.util.k.d(activity, editText3);
        }
        editText4 = this.dYD.dUQ;
        if (view == editText4) {
            if (!z) {
                writeData = this.dYD.dJy;
                if (writeData.getType() == 0) {
                    editText5 = this.dYD.dUQ;
                    editText5.setHint(n.j.content);
                    return;
                }
                return;
            }
            this.dYD.dYA = false;
            writeData2 = this.dYD.dJy;
            if (writeData2.getType() != 0) {
                writeData3 = this.dYD.dJy;
            }
            editText6 = this.dYD.dUQ;
            editText6.setHint((CharSequence) null);
            this.dYD.aLN();
            kVar2 = this.dYD.aso;
            kVar2.zK();
            Activity activity2 = this.dYD.getActivity();
            editText7 = this.dYD.dUQ;
            com.baidu.adp.lib.util.k.d(activity2, editText7);
        }
    }
}
