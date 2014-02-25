package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bc implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(WriteActivity writeActivity) {
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
        ImageView imageView;
        TextView textView;
        editText = this.a.g;
        if (view != editText) {
            imageView = this.a.o;
            if (view != imageView) {
                textView = this.a.p;
            }
        }
        if (z) {
            this.a.H = true;
            this.a.m();
            writeEditorToolButtonContainer = this.a.A;
            writeEditorToolButtonContainer.c();
            editorToolComponetContainer = this.a.B;
            editText2 = this.a.g;
            editorToolComponetContainer.c(editText2);
        }
        editText3 = this.a.j;
        if (view == editText3) {
            if (!z) {
                writeData = this.a.b;
                if (writeData.getType() == 0) {
                    editText4 = this.a.j;
                    editText4.setHint(R.string.content);
                    return;
                }
                return;
            }
            this.a.H = false;
            writeData2 = this.a.b;
            if (writeData2.getType() == 0) {
                editText6 = this.a.j;
                editText6.setHint((CharSequence) null);
            }
            this.a.m();
            writeEditorToolButtonContainer2 = this.a.A;
            writeEditorToolButtonContainer2.c();
            editorToolComponetContainer2 = this.a.B;
            editText5 = this.a.j;
            editorToolComponetContainer2.c(editText5);
        }
    }
}
