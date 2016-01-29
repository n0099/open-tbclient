package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class bf implements View.OnClickListener {
    final /* synthetic */ WriteActivity ets;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(WriteActivity writeActivity) {
        this.ets = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.k kVar;
        int aUH;
        EditText editText;
        EditText editText2;
        kVar = this.ets.ath;
        kVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
        aUH = this.ets.aUH();
        if (aUH >= 0) {
            editText = this.ets.epv;
            if (aUH < editText.getText().length()) {
                editText2 = this.ets.epv;
                editText2.setSelection(aUH);
            }
        }
    }
}
