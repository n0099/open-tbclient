package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class bk implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity fea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(WriteActivity writeActivity) {
        this.fea = writeActivity;
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
        editText = this.fea.fad;
        if (view != editText) {
            view2 = this.fea.afm;
            if (view != view2) {
                textView2 = this.fea.fai;
            }
        }
        if (!z) {
            editText2 = this.fea.fad;
            if (view == editText2) {
                textView = this.fea.faj;
                textView.setVisibility(0);
            }
        } else {
            this.fea.fdX = true;
            this.fea.bdD();
            lVar = this.fea.apy;
            lVar.zy();
            Activity activity = this.fea.getActivity();
            editText3 = this.fea.fad;
            com.baidu.adp.lib.util.k.b(activity, editText3);
        }
        editText4 = this.fea.fah;
        if (view == editText4) {
            if (!z) {
                writeData = this.fea.evE;
                if (writeData.getType() == 0) {
                    editText5 = this.fea.fah;
                    editText5.setHint(t.j.content);
                    return;
                }
                return;
            }
            this.fea.fdX = false;
            writeData2 = this.fea.evE;
            if (writeData2.getType() != 0) {
                writeData3 = this.fea.evE;
            }
            editText6 = this.fea.fah;
            editText6.setHint((CharSequence) null);
            this.fea.bdD();
            lVar2 = this.fea.apy;
            lVar2.zy();
            Activity activity2 = this.fea.getActivity();
            editText7 = this.fea.fah;
            com.baidu.adp.lib.util.k.b(activity2, editText7);
        }
    }
}
