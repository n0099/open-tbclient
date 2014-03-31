package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* loaded from: classes.dex */
final class ay implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r3 == r0) goto L22;
     */
    @Override // android.view.View.OnFocusChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onFocusChange(View view, boolean z) {
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
        editText = this.a.e;
        if (view != editText) {
            view2 = this.a.o;
            if (view != view2) {
                textView = this.a.p;
            }
        }
        if (z) {
            this.a.T = true;
            this.a.e();
            writeEditorToolButtonContainer = this.a.z;
            writeEditorToolButtonContainer.c();
            editorToolComponetContainer = this.a.A;
            editText2 = this.a.e;
            editorToolComponetContainer.c(editText2);
        }
        editText3 = this.a.h;
        if (view == editText3) {
            if (!z) {
                writeData = this.a.a;
                if (writeData.getType() == 0) {
                    editText4 = this.a.h;
                    editText4.setHint(com.baidu.tieba.a.k.content);
                    return;
                }
                return;
            }
            this.a.T = false;
            writeData2 = this.a.a;
            if (writeData2.getType() == 0) {
                editText6 = this.a.h;
                editText6.setHint((CharSequence) null);
            }
            this.a.e();
            writeEditorToolButtonContainer2 = this.a.z;
            writeEditorToolButtonContainer2.c();
            editorToolComponetContainer2 = this.a.A;
            editText5 = this.a.h;
            editorToolComponetContainer2.c(editText5);
        }
    }
}
