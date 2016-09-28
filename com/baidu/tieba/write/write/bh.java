package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class bh implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity ghD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(WriteActivity writeActivity) {
        this.ghD = writeActivity;
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
        editText = this.ghD.flD;
        if (view != editText) {
            view2 = this.ghD.aiY;
            if (view != view2) {
                textView2 = this.ghD.flI;
            }
        }
        if (!z) {
            editText2 = this.ghD.flD;
            if (view == editText2) {
                textView = this.ghD.flJ;
                textView.setVisibility(0);
            }
        } else {
            this.ghD.ghy = true;
            this.ghD.btO();
            lVar = this.ghD.atO;
            lVar.AV();
            Activity activity = this.ghD.getActivity();
            editText3 = this.ghD.flD;
            com.baidu.adp.lib.util.k.c(activity, editText3);
        }
        editText4 = this.ghD.flH;
        if (view == editText4) {
            if (!z) {
                writeData = this.ghD.flk;
                if (writeData.getType() == 0) {
                    editText5 = this.ghD.flH;
                    editText5.setHint(r.j.write_input_content);
                    return;
                }
                return;
            }
            this.ghD.ghy = false;
            writeData2 = this.ghD.flk;
            if (writeData2.getType() != 0) {
                writeData3 = this.ghD.flk;
            }
            editText6 = this.ghD.flH;
            editText6.setHint((CharSequence) null);
            this.ghD.btO();
            lVar2 = this.ghD.atO;
            lVar2.AV();
            Activity activity2 = this.ghD.getActivity();
            editText7 = this.ghD.flH;
            com.baidu.adp.lib.util.k.c(activity2, editText7);
        }
    }
}
