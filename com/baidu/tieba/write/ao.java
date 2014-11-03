package com.baidu.tieba.write;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
import com.baidu.tieba.editortool.TbEditorToolButtonContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ WriteActivity bUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(WriteActivity writeActivity) {
        this.bUm = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        ch chVar;
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        textView = this.bUm.bJM;
        textView.setSelected(true);
        chVar = this.bUm.bJN;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(chVar, view, 0, com.baidu.adp.lib.util.m.dip2px(this.bUm, 1.0f));
        tbEditorToolButtonContainer = this.bUm.bTU;
        tbEditorToolButtonContainer.Bi();
        editorToolComponetContainer = this.bUm.arn;
        editorToolComponetContainer.BE();
    }
}
