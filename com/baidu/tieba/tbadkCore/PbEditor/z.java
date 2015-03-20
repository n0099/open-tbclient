package com.baidu.tieba.tbadkCore.PbEditor;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements TextWatcher {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aIB;
    final /* synthetic */ PbEditorToolView cmQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.v vVar) {
        this.cmQ = pbEditorToolView;
        this.aIB = vVar;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.aIB.handleAction(18, null);
    }
}
