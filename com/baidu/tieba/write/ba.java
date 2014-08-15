package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* loaded from: classes.dex */
class ba implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r3 == r0) goto L22;
     */
    @Override // android.view.View.OnFocusChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText2;
        EditText editText3;
        WriteData writeData;
        EditText editText4;
        WriteData writeData2;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer2;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText5;
        EditText editText6;
        View view2;
        TextView textView;
        editText = this.a.f;
        if (view != editText) {
            view2 = this.a.p;
            if (view != view2) {
                textView = this.a.r;
            }
        }
        if (z) {
            this.a.aa = true;
            this.a.o();
            writeEditorToolButtonContainer = this.a.B;
            writeEditorToolButtonContainer.c();
            editorToolComponetContainer = this.a.C;
            editText2 = this.a.f;
            editorToolComponetContainer.c(editText2);
        }
        editText3 = this.a.i;
        if (view == editText3) {
            if (!z) {
                writeData = this.a.a;
                if (writeData.getType() == 0) {
                    editText4 = this.a.i;
                    editText4.setHint(com.baidu.tieba.x.content);
                    return;
                }
                return;
            }
            this.a.aa = false;
            writeData2 = this.a.a;
            if (writeData2.getType() == 0) {
                editText6 = this.a.i;
                editText6.setHint((CharSequence) null);
            }
            this.a.o();
            writeEditorToolButtonContainer2 = this.a.B;
            writeEditorToolButtonContainer2.c();
            editorToolComponetContainer2 = this.a.C;
            editText5 = this.a.i;
            editorToolComponetContainer2.c(editText5);
        }
    }
}
