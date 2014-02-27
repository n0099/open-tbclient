package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* loaded from: classes.dex */
final class az implements View.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer2;
        editorToolComponetContainer = this.a.B;
        if (editorToolComponetContainer.a()) {
            editorToolComponetContainer2 = this.a.B;
            editorToolComponetContainer2.b();
        }
        int d = WriteActivity.d(this.a);
        if (d >= 0) {
            editText = this.a.j;
            if (d < editText.getText().length()) {
                editText2 = this.a.j;
                editText2.setSelection(d);
            }
        }
    }
}
