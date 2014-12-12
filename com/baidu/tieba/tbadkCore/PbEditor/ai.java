package com.baidu.tieba.tbadkCore.PbEditor;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class ai implements TextWatcher {
    private final /* synthetic */ com.baidu.tbadk.editortool.w aBH;
    final /* synthetic */ PbEditorToolView bUI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.w wVar) {
        this.bUI = pbEditorToolView;
        this.aBH = wVar;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.aBH.handleAction(18, null);
    }
}
