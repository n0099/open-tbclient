package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ae implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4 == r0) goto L22;
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
        editText = this.a.f;
        if (view != editText) {
            imageView = this.a.l;
            if (view != imageView) {
                textView = this.a.m;
            }
        }
        if (z) {
            this.a.F = true;
            this.a.n();
            writeEditorToolButtonContainer = this.a.y;
            writeEditorToolButtonContainer.c();
            editorToolComponetContainer = this.a.z;
            editText2 = this.a.f;
            editorToolComponetContainer.c(editText2);
        }
        editText3 = this.a.h;
        if (view == editText3) {
            if (z) {
                this.a.F = false;
                writeData2 = this.a.b;
                if (writeData2.getType() == 0) {
                    editText6 = this.a.h;
                    editText6.setHint((CharSequence) null);
                }
                this.a.n();
                writeEditorToolButtonContainer2 = this.a.y;
                writeEditorToolButtonContainer2.c();
                editorToolComponetContainer2 = this.a.z;
                editText5 = this.a.h;
                editorToolComponetContainer2.c(editText5);
                return;
            }
            writeData = this.a.b;
            if (writeData.getType() == 0) {
                editText4 = this.a.h;
                editText4.setHint(R.string.content);
            }
        }
    }
}
