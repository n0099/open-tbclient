package com.baidu.tieba.write;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.tbadkCore.PbEditor.TbEditorToolButtonContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ WriteActivity cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity) {
        this.cft = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        ch chVar;
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        textView = this.cft.bOc;
        textView.setVisibility(0);
        view2 = this.cft.bOf;
        view2.setSelected(true);
        chVar = this.cft.bOd;
        com.baidu.adp.lib.g.k.showPopupWindowAsDropDown(chVar, view, 0, com.baidu.adp.lib.util.l.dip2px(this.cft.getPageContext().getPageActivity(), 1.0f));
        tbEditorToolButtonContainer = this.cft.cfb;
        tbEditorToolButtonContainer.aeS();
        editorToolComponetContainer = this.cft.bUs;
        editorToolComponetContainer.hideAll();
    }
}
