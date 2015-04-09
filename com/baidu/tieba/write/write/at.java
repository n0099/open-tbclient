package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.write.editor.TbEditorToolButtonContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnClickListener {
    final /* synthetic */ WriteActivity cyx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(WriteActivity writeActivity) {
        this.cyx = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        cm cmVar;
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        textView = this.cyx.cwk;
        textView.setVisibility(0);
        view2 = this.cyx.cwn;
        view2.setSelected(true);
        cmVar = this.cyx.cwl;
        com.baidu.adp.lib.g.k.showPopupWindowAsDropDown(cmVar, view, 0, com.baidu.adp.lib.util.n.dip2px(this.cyx.getPageContext().getPageActivity(), 1.0f));
        tbEditorToolButtonContainer = this.cyx.cyf;
        tbEditorToolButtonContainer.alt();
        editorToolComponetContainer = this.cyx.cmP;
        editorToolComponetContainer.hideAll();
    }
}
