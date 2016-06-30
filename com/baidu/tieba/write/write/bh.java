package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class bh implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity fJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(WriteActivity writeActivity) {
        this.fJw = writeActivity;
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
        editText = this.fJw.fFh;
        if (view != editText) {
            view2 = this.fJw.afN;
            if (view != view2) {
                textView2 = this.fJw.fFm;
            }
        }
        if (!z) {
            editText2 = this.fJw.fFh;
            if (view == editText2) {
                textView = this.fJw.fFn;
                textView.setVisibility(0);
            }
        } else {
            this.fJw.fJs = true;
            this.fJw.blY();
            lVar = this.fJw.aqo;
            lVar.zD();
            Activity activity = this.fJw.getActivity();
            editText3 = this.fJw.fFh;
            com.baidu.adp.lib.util.k.b(activity, editText3);
        }
        editText4 = this.fJw.fFl;
        if (view == editText4) {
            if (!z) {
                writeData = this.fJw.fau;
                if (writeData.getType() == 0) {
                    editText5 = this.fJw.fFl;
                    editText5.setHint(u.j.write_input_content);
                    return;
                }
                return;
            }
            this.fJw.fJs = false;
            writeData2 = this.fJw.fau;
            if (writeData2.getType() != 0) {
                writeData3 = this.fJw.fau;
            }
            editText6 = this.fJw.fFl;
            editText6.setHint((CharSequence) null);
            this.fJw.blY();
            lVar2 = this.fJw.aqo;
            lVar2.zD();
            Activity activity2 = this.fJw.getActivity();
            editText7 = this.fJw.fFl;
            com.baidu.adp.lib.util.k.b(activity2, editText7);
        }
    }
}
