package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.write.editor.TbEditorToolButtonContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnClickListener {
    final /* synthetic */ WriteActivity cyx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WriteActivity writeActivity) {
        this.cyx = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        cm cmVar;
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        textView = this.cyx.cwk;
        textView.setSelected(true);
        cmVar = this.cyx.cwl;
        com.baidu.adp.lib.g.k.showPopupWindowAsDropDown(cmVar, view, 0, com.baidu.adp.lib.util.n.dip2px(this.cyx.getPageContext().getPageActivity(), 1.0f));
        tbEditorToolButtonContainer = this.cyx.cyf;
        tbEditorToolButtonContainer.alt();
        editorToolComponetContainer = this.cyx.cmP;
        editorToolComponetContainer.hideAll();
    }
}
