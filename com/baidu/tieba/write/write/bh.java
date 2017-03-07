package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class bh implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity fQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(WriteActivity writeActivity) {
        this.fQG = writeActivity;
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
        com.baidu.tbadk.editortools.j jVar;
        EditText editText3;
        com.baidu.tbadk.editortools.j jVar2;
        EditText editText4;
        WriteData writeData;
        EditText editText5;
        WriteData writeData2;
        EditText editText6;
        com.baidu.tbadk.editortools.j jVar3;
        EditText editText7;
        WriteData writeData3;
        View view2;
        TextView textView2;
        editText = this.fQG.fkw;
        if (view != editText) {
            view2 = this.fQG.anY;
            if (view != view2) {
                textView2 = this.fQG.mPost;
            }
        }
        if (!z) {
            editText2 = this.fQG.fkw;
            if (view == editText2) {
                textView = this.fQG.fkB;
                textView.setVisibility(0);
            }
        } else {
            this.fQG.fQC = true;
            this.fQG.bos();
            jVar = this.fQG.ayN;
            if (jVar != null) {
                jVar2 = this.fQG.ayN;
                jVar2.Bd();
            }
            Activity activity = this.fQG.getActivity();
            editText3 = this.fQG.fkw;
            com.baidu.adp.lib.util.k.c(activity, editText3);
        }
        editText4 = this.fQG.fkA;
        if (view == editText4) {
            if (!z) {
                writeData = this.fQG.mData;
                if (writeData.getType() == 0) {
                    editText5 = this.fQG.fkA;
                    editText5.setHint(w.l.write_input_content);
                    return;
                }
                return;
            }
            this.fQG.fQC = false;
            writeData2 = this.fQG.mData;
            if (writeData2.getType() != 0) {
                writeData3 = this.fQG.mData;
            }
            editText6 = this.fQG.fkA;
            editText6.setHint((CharSequence) null);
            this.fQG.bos();
            jVar3 = this.fQG.ayN;
            jVar3.Bd();
            Activity activity2 = this.fQG.getActivity();
            editText7 = this.fQG.fkA;
            com.baidu.adp.lib.util.k.c(activity2, editText7);
        }
    }
}
