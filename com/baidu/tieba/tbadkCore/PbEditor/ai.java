package com.baidu.tieba.tbadkCore.PbEditor;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class ai implements TextWatcher {
    private final /* synthetic */ com.baidu.tbadk.editortool.w aCF;
    final /* synthetic */ PbEditorToolView bWz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.w wVar) {
        this.bWz = pbEditorToolView;
        this.aCF = wVar;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.aCF.handleAction(18, null);
    }
}
