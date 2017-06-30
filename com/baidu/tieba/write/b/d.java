package com.baidu.tieba.write.b;

import android.view.View;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a gha;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.gha = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditorInfoView editorInfoView;
        editorInfoView = this.gha.ggW;
        editorInfoView.setVisibility(8);
        this.gha.b(new com.baidu.tbadk.editortools.a(45, -1, null));
    }
}
