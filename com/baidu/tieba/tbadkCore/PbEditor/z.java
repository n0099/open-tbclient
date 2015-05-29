package com.baidu.tieba.tbadkCore.PbEditor;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class z implements TextWatcher {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aKR;
    final /* synthetic */ PbEditorToolView cre;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.v vVar) {
        this.cre = pbEditorToolView;
        this.aKR = vVar;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.aKR.handleAction(18, null);
    }
}
