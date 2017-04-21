package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class bg implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity fUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(WriteActivity writeActivity) {
        this.fUM = writeActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006c, code lost:
        if (r0.getType() == 4) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4 == r0) goto L28;
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
        WriteData writeData2;
        EditText editText5;
        EditText editText6;
        WriteData writeData3;
        EditText editText7;
        com.baidu.tbadk.editortools.j jVar3;
        EditText editText8;
        WriteData writeData4;
        View view2;
        TextView textView2;
        editText = this.fUM.fow;
        if (view != editText) {
            view2 = this.fUM.aom;
            if (view != view2) {
                textView2 = this.fUM.mPost;
            }
        }
        if (!z) {
            editText2 = this.fUM.fow;
            if (view == editText2) {
                textView = this.fUM.foB;
                textView.setVisibility(0);
            }
        } else {
            this.fUM.fUI = true;
            this.fUM.bqc();
            jVar = this.fUM.azf;
            if (jVar != null) {
                jVar2 = this.fUM.azf;
                jVar2.BC();
            }
            Activity activity = this.fUM.getActivity();
            editText3 = this.fUM.fow;
            com.baidu.adp.lib.util.k.c(activity, editText3);
        }
        editText4 = this.fUM.foA;
        if (view == editText4) {
            if (!z) {
                writeData = this.fUM.mData;
                if (writeData.getType() != 0) {
                    writeData2 = this.fUM.mData;
                    if (writeData2.getType() == 7) {
                        editText5 = this.fUM.foA;
                        editText5.setHint(w.l.bottle_input_hint);
                        return;
                    }
                    return;
                }
                editText6 = this.fUM.foA;
                editText6.setHint(w.l.write_input_content);
                return;
            }
            this.fUM.fUI = false;
            writeData3 = this.fUM.mData;
            if (writeData3.getType() != 0) {
                writeData4 = this.fUM.mData;
            }
            editText7 = this.fUM.foA;
            editText7.setHint((CharSequence) null);
            this.fUM.bqc();
            jVar3 = this.fUM.azf;
            jVar3.BC();
            Activity activity2 = this.fUM.getActivity();
            editText8 = this.fUM.foA;
            com.baidu.adp.lib.util.k.c(activity2, editText8);
        }
    }
}
