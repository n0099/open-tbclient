package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.write.editor.TbEditorToolButtonContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnClickListener {
    final /* synthetic */ WriteActivity cCQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WriteActivity writeActivity) {
        this.cCQ = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        cn cnVar;
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        textView = this.cCQ.cAB;
        textView.setVisibility(0);
        view2 = this.cCQ.cAE;
        view2.setSelected(true);
        cnVar = this.cCQ.cAC;
        com.baidu.adp.lib.g.k.showPopupWindowAsDropDown(cnVar, view, 0, com.baidu.adp.lib.util.n.dip2px(this.cCQ.getPageContext().getPageActivity(), 1.0f));
        tbEditorToolButtonContainer = this.cCQ.cCy;
        tbEditorToolButtonContainer.anf();
        editorToolComponetContainer = this.cCQ.cqP;
        editorToolComponetContainer.hideAll();
    }
}
