package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class bh implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity fMl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(WriteActivity writeActivity) {
        this.fMl = writeActivity;
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
        editText = this.fMl.ffZ;
        if (view != editText) {
            view2 = this.fMl.aiC;
            if (view != view2) {
                textView2 = this.fMl.mPost;
            }
        }
        if (!z) {
            editText2 = this.fMl.ffZ;
            if (view == editText2) {
                textView = this.fMl.fge;
                textView.setVisibility(0);
            }
        } else {
            this.fMl.fMh = true;
            this.fMl.boF();
            jVar = this.fMl.ats;
            if (jVar != null) {
                jVar2 = this.fMl.ats;
                jVar2.AK();
            }
            Activity activity = this.fMl.getActivity();
            editText3 = this.fMl.ffZ;
            com.baidu.adp.lib.util.k.c(activity, editText3);
        }
        editText4 = this.fMl.fgd;
        if (view == editText4) {
            if (!z) {
                writeData = this.fMl.mData;
                if (writeData.getType() == 0) {
                    editText5 = this.fMl.fgd;
                    editText5.setHint(r.l.write_input_content);
                    return;
                }
                return;
            }
            this.fMl.fMh = false;
            writeData2 = this.fMl.mData;
            if (writeData2.getType() != 0) {
                writeData3 = this.fMl.mData;
            }
            editText6 = this.fMl.fgd;
            editText6.setHint((CharSequence) null);
            this.fMl.boF();
            jVar3 = this.fMl.ats;
            jVar3.AK();
            Activity activity2 = this.fMl.getActivity();
            editText7 = this.fMl.fgd;
            com.baidu.adp.lib.util.k.c(activity2, editText7);
        }
    }
}
