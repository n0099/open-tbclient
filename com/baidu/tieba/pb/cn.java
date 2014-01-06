package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.editortool.EditorToolButton;
/* loaded from: classes.dex */
class cn implements View.OnClickListener {
    final /* synthetic */ com.baidu.tieba.editortool.t a;
    final /* synthetic */ PbEditorToolButtonContainer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(PbEditorToolButtonContainer pbEditorToolButtonContainer, com.baidu.tieba.editortool.t tVar) {
        this.b = pbEditorToolButtonContainer;
        this.a = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof EditorToolButton) {
            this.b.a((EditorToolButton) view, this.a);
        }
    }
}
