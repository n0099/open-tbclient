package com.baidu.tieba.write;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
import com.baidu.tieba.editortool.TbEditorToolButtonContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ WriteActivity bTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(WriteActivity writeActivity) {
        this.bTX = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        ch chVar;
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        textView = this.bTX.bJx;
        textView.setSelected(true);
        chVar = this.bTX.bJy;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(chVar, view, 0, com.baidu.adp.lib.util.m.dip2px(this.bTX, 1.0f));
        tbEditorToolButtonContainer = this.bTX.bTF;
        tbEditorToolButtonContainer.Bg();
        editorToolComponetContainer = this.bTX.are;
        editorToolComponetContainer.BC();
    }
}
