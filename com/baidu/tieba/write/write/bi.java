package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class bi implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity gpp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(WriteActivity writeActivity) {
        this.gpp = writeActivity;
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
        com.baidu.tbadk.editortools.l lVar;
        EditText editText3;
        com.baidu.tbadk.editortools.l lVar2;
        EditText editText4;
        WriteData writeData;
        EditText editText5;
        WriteData writeData2;
        EditText editText6;
        com.baidu.tbadk.editortools.l lVar3;
        EditText editText7;
        WriteData writeData3;
        View view2;
        TextView textView2;
        editText = this.gpp.fsM;
        if (view != editText) {
            view2 = this.gpp.ajQ;
            if (view != view2) {
                textView2 = this.gpp.fsR;
            }
        }
        if (!z) {
            editText2 = this.gpp.fsM;
            if (view == editText2) {
                textView = this.gpp.fsS;
                textView.setVisibility(0);
            }
        } else {
            this.gpp.gpl = true;
            this.gpp.bwj();
            lVar = this.gpp.auI;
            if (lVar != null) {
                lVar2 = this.gpp.auI;
                lVar2.Bc();
            }
            Activity activity = this.gpp.getActivity();
            editText3 = this.gpp.fsM;
            com.baidu.adp.lib.util.k.c(activity, editText3);
        }
        editText4 = this.gpp.fsQ;
        if (view == editText4) {
            if (!z) {
                writeData = this.gpp.fst;
                if (writeData.getType() == 0) {
                    editText5 = this.gpp.fsQ;
                    editText5.setHint(r.j.write_input_content);
                    return;
                }
                return;
            }
            this.gpp.gpl = false;
            writeData2 = this.gpp.fst;
            if (writeData2.getType() != 0) {
                writeData3 = this.gpp.fst;
            }
            editText6 = this.gpp.fsQ;
            editText6.setHint((CharSequence) null);
            this.gpp.bwj();
            lVar3 = this.gpp.auI;
            lVar3.Bc();
            Activity activity2 = this.gpp.getActivity();
            editText7 = this.gpp.fsQ;
            com.baidu.adp.lib.util.k.c(activity2, editText7);
        }
    }
}
