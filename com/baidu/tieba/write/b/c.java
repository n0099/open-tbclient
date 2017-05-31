package com.baidu.tieba.write.b;

import android.view.View;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a fWl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.fWl = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditorInfoView editorInfoView;
        editorInfoView = this.fWl.fWk;
        editorInfoView.setVisibility(8);
        this.fWl.b(new com.baidu.tbadk.editortools.a(45, -1, null));
    }
}
