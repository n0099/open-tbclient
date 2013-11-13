package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.editortool.h f2120a;
    final /* synthetic */ PbEditorToolView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(PbEditorToolView pbEditorToolView, com.baidu.tieba.editortool.h hVar) {
        this.b = pbEditorToolView;
        this.f2120a = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2120a.a(10, null);
    }
}
