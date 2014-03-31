package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* loaded from: classes.dex */
final class ax implements View.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer2;
        editorToolComponetContainer = this.a.A;
        if (editorToolComponetContainer.a()) {
            editorToolComponetContainer2 = this.a.A;
            editorToolComponetContainer2.b();
        }
        int f = WriteActivity.f(this.a);
        if (f >= 0) {
            editText = this.a.h;
            if (f < editText.getText().length()) {
                editText2 = this.a.h;
                editText2.setSelection(f);
            }
        }
    }
}
