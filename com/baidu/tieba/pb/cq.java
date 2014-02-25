package com.baidu.tieba.pb;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements TextWatcher {
    final /* synthetic */ PbEditorToolView a;
    private final /* synthetic */ com.baidu.tieba.editortool.z b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(PbEditorToolView pbEditorToolView, com.baidu.tieba.editortool.z zVar) {
        this.a = pbEditorToolView;
        this.b = zVar;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.b.a(18, null);
    }
}
