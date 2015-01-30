package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer bWa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(EditorToolComponetContainer editorToolComponetContainer) {
        this.bWa = editorToolComponetContainer;
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
        if (view == this.bWa.bVC.getmFace()) {
            wVar7 = this.bWa.Yj;
            wVar7.handleAction(2, null);
        } else if (view == this.bWa.bVC.getmImage() || view == this.bWa.bVC.getmIVImage()) {
            this.bWa.bVC.setmImagetype(2);
            wVar = this.bWa.Yj;
            wVar.handleAction(23, null);
        } else if (view == this.bWa.bVC.getmAt()) {
            wVar6 = this.bWa.Yj;
            wVar6.handleAction(0, null);
        } else if (view == this.bWa.bVC.getmPrivilege()) {
            wVar5 = this.bWa.Yj;
            wVar5.handleAction(44, null);
        } else if (view == this.bWa.bVC.getBaobao()) {
            wVar4 = this.bWa.Yj;
            wVar4.handleAction(48, null);
        } else if (view == this.bWa.bVC.getRecordButton()) {
            wVar3 = this.bWa.Yj;
            wVar3.handleAction(4, null);
        } else if (view == this.bWa.bVC.getLocation()) {
            wVar2 = this.bWa.Yj;
            wVar2.handleAction(52, null);
        }
    }
}
