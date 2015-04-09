package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer cmE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(EditorToolComponetContainer editorToolComponetContainer) {
        this.cmE = editorToolComponetContainer;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortool.v vVar;
        com.baidu.tbadk.editortool.v vVar2;
        com.baidu.tbadk.editortool.v vVar3;
        com.baidu.tbadk.editortool.v vVar4;
        com.baidu.tbadk.editortool.v vVar5;
        com.baidu.tbadk.editortool.v vVar6;
        com.baidu.tbadk.editortool.v vVar7;
        if (view == this.cmE.cmh.getmFace()) {
            vVar7 = this.cmE.aix;
            vVar7.handleAction(2, null);
        } else if (view == this.cmE.cmh.getmImage() || view == this.cmE.cmh.getmIVImage()) {
            this.cmE.cmh.setmImagetype(2);
            vVar = this.cmE.aix;
            vVar.handleAction(23, null);
        } else if (view == this.cmE.cmh.getmAt()) {
            vVar6 = this.cmE.aix;
            vVar6.handleAction(0, null);
        } else if (view == this.cmE.cmh.getmPrivilege()) {
            vVar5 = this.cmE.aix;
            vVar5.handleAction(44, null);
        } else if (view == this.cmE.cmh.getBaobao()) {
            vVar4 = this.cmE.aix;
            vVar4.handleAction(48, null);
        } else if (view == this.cmE.cmh.getRecordButton()) {
            vVar3 = this.cmE.aix;
            vVar3.handleAction(4, null);
        } else if (view == this.cmE.cmh.getLocation()) {
            vVar2 = this.cmE.aix;
            vVar2.handleAction(52, null);
        }
    }
}
