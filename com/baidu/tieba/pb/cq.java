package com.baidu.tieba.pb;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cq implements TextWatcher {
    final /* synthetic */ PbEditorToolView a;
    private final /* synthetic */ com.baidu.tieba.editortool.aa b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(PbEditorToolView pbEditorToolView, com.baidu.tieba.editortool.aa aaVar) {
        this.a = pbEditorToolView;
        this.b = aaVar;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.b.a(18, null);
    }
}
