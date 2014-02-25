package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.editortool.EditorToolButton;
/* loaded from: classes.dex */
class cn implements View.OnClickListener {
    final /* synthetic */ PbEditorToolButtonContainer a;
    private final /* synthetic */ com.baidu.tieba.editortool.z b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(PbEditorToolButtonContainer pbEditorToolButtonContainer, com.baidu.tieba.editortool.z zVar) {
        this.a = pbEditorToolButtonContainer;
        this.b = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof EditorToolButton) {
            this.a.a((EditorToolButton) view, this.b);
        }
    }
}
