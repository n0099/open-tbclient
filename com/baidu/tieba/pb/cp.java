package com.baidu.tieba.pb;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cp implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.editortool.h f2211a;
    final /* synthetic */ PbEditorToolView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(PbEditorToolView pbEditorToolView, com.baidu.tieba.editortool.h hVar) {
        this.b = pbEditorToolView;
        this.f2211a = hVar;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.f2211a.a(18, null);
    }
}
