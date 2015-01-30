package com.baidu.tieba.write;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.tbadkCore.PbEditor.TbEditorToolButtonContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ WriteActivity cgS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.cgS = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        ch chVar;
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        textView = this.cgS.bPM;
        textView.setSelected(true);
        chVar = this.cgS.bPN;
        com.baidu.adp.lib.g.k.showPopupWindowAsDropDown(chVar, view, 0, com.baidu.adp.lib.util.l.dip2px(this.cgS.getPageContext().getPageActivity(), 1.0f));
        tbEditorToolButtonContainer = this.cgS.cgA;
        tbEditorToolButtonContainer.afw();
        editorToolComponetContainer = this.cgS.bWk;
        editorToolComponetContainer.hideAll();
    }
}
