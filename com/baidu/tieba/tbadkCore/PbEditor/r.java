package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer bUi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(EditorToolComponetContainer editorToolComponetContainer) {
        this.bUi = editorToolComponetContainer;
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
        com.baidu.tbadk.editortool.w wVar8;
        if (view == this.bUi.bTK.getmFace()) {
            wVar8 = this.bUi.XD;
            wVar8.handleAction(2, null);
        } else if (view == this.bUi.bTK.getmImage() || view == this.bUi.bTK.getmIVImage()) {
            this.bUi.bTK.setmImagetype(2);
            wVar = this.bUi.XD;
            wVar.handleAction(23, null);
        } else if (view == this.bUi.bTK.getmCamera() || view == this.bUi.bTK.getmIVCamera()) {
            this.bUi.bTK.setmImagetype(1);
            wVar2 = this.bUi.XD;
            wVar2.handleAction(22, null);
        } else if (view == this.bUi.bTK.getmAt()) {
            wVar7 = this.bUi.XD;
            wVar7.handleAction(0, null);
        } else if (view == this.bUi.bTK.getmPrivilege()) {
            wVar6 = this.bUi.XD;
            wVar6.handleAction(44, null);
        } else if (view == this.bUi.bTK.getBaobao()) {
            wVar5 = this.bUi.XD;
            wVar5.handleAction(48, null);
        } else if (view == this.bUi.bTK.getRecordButton()) {
            wVar4 = this.bUi.XD;
            wVar4.handleAction(4, null);
        } else if (view == this.bUi.bTK.getLocation()) {
            wVar3 = this.bUi.XD;
            wVar3.handleAction(52, null);
        }
    }
}
