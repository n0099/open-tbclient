package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* loaded from: classes.dex */
class bb implements View.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditorToolComponetContainer editorToolComponetContainer;
        int m;
        EditText editText;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer2;
        editorToolComponetContainer = this.a.A;
        if (editorToolComponetContainer.l()) {
            editorToolComponetContainer2 = this.a.A;
            editorToolComponetContainer2.m();
        }
        m = this.a.m();
        if (m >= 0) {
            editText = this.a.h;
            if (m < editText.getText().length()) {
                editText2 = this.a.h;
                editText2.setSelection(m);
            }
        }
    }
}
