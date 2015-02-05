package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer bVZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(EditorToolComponetContainer editorToolComponetContainer) {
        this.bVZ = editorToolComponetContainer;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortool.w wVar;
        com.baidu.tbadk.editortool.w wVar2;
        com.baidu.tbadk.editortool.w wVar3;
        com.baidu.tbadk.editortool.w wVar4;
        com.baidu.tbadk.editortool.w wVar5;
        com.baidu.tbadk.editortool.w wVar6;
        com.baidu.tbadk.editortool.w wVar7;
        if (view == this.bVZ.bVB.getmFace()) {
            wVar7 = this.bVZ.Yg;
            wVar7.handleAction(2, null);
        } else if (view == this.bVZ.bVB.getmImage() || view == this.bVZ.bVB.getmIVImage()) {
            this.bVZ.bVB.setmImagetype(2);
            wVar = this.bVZ.Yg;
            wVar.handleAction(23, null);
        } else if (view == this.bVZ.bVB.getmAt()) {
            wVar6 = this.bVZ.Yg;
            wVar6.handleAction(0, null);
        } else if (view == this.bVZ.bVB.getmPrivilege()) {
            wVar5 = this.bVZ.Yg;
            wVar5.handleAction(44, null);
        } else if (view == this.bVZ.bVB.getBaobao()) {
            wVar4 = this.bVZ.Yg;
            wVar4.handleAction(48, null);
        } else if (view == this.bVZ.bVB.getRecordButton()) {
            wVar3 = this.bVZ.Yg;
            wVar3.handleAction(4, null);
        } else if (view == this.bVZ.bVB.getLocation()) {
            wVar2 = this.bVZ.Yg;
            wVar2.handleAction(52, null);
        }
    }
}
