package com.baidu.tieba.write;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.tbadkCore.PbEditor.TbEditorToolButtonContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ WriteActivity cgR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(WriteActivity writeActivity) {
        this.cgR = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        ch chVar;
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        textView = this.cgR.bPL;
        textView.setVisibility(0);
        view2 = this.cgR.bPO;
        view2.setSelected(true);
        chVar = this.cgR.bPM;
        com.baidu.adp.lib.g.k.showPopupWindowAsDropDown(chVar, view, 0, com.baidu.adp.lib.util.l.dip2px(this.cgR.getPageContext().getPageActivity(), 1.0f));
        tbEditorToolButtonContainer = this.cgR.cgz;
        tbEditorToolButtonContainer.afr();
        editorToolComponetContainer = this.cgR.bWj;
        editorToolComponetContainer.hideAll();
    }
}
