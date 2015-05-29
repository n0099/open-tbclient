package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.write.editor.TbEditorToolButtonContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnClickListener {
    final /* synthetic */ WriteActivity cCP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WriteActivity writeActivity) {
        this.cCP = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        cn cnVar;
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        textView = this.cCP.cAA;
        textView.setVisibility(0);
        view2 = this.cCP.cAD;
        view2.setSelected(true);
        cnVar = this.cCP.cAB;
        com.baidu.adp.lib.g.k.showPopupWindowAsDropDown(cnVar, view, 0, com.baidu.adp.lib.util.n.dip2px(this.cCP.getPageContext().getPageActivity(), 1.0f));
        tbEditorToolButtonContainer = this.cCP.cCx;
        tbEditorToolButtonContainer.ane();
        editorToolComponetContainer = this.cCP.cqO;
        editorToolComponetContainer.hideAll();
    }
}
