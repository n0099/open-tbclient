package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer cmo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(EditorToolComponetContainer editorToolComponetContainer) {
        this.cmo = editorToolComponetContainer;
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
        if (view == this.cmo.clQ.getmFace()) {
            vVar7 = this.cmo.aip;
            vVar7.handleAction(2, null);
        } else if (view == this.cmo.clQ.getmImage() || view == this.cmo.clQ.getmIVImage()) {
            this.cmo.clQ.setmImagetype(2);
            vVar = this.cmo.aip;
            vVar.handleAction(23, null);
        } else if (view == this.cmo.clQ.getmAt()) {
            vVar6 = this.cmo.aip;
            vVar6.handleAction(0, null);
        } else if (view == this.cmo.clQ.getmPrivilege()) {
            vVar5 = this.cmo.aip;
            vVar5.handleAction(44, null);
        } else if (view == this.cmo.clQ.getBaobao()) {
            vVar4 = this.cmo.aip;
            vVar4.handleAction(48, null);
        } else if (view == this.cmo.clQ.getRecordButton()) {
            vVar3 = this.cmo.aip;
            vVar3.handleAction(4, null);
        } else if (view == this.cmo.clQ.getLocation()) {
            vVar2 = this.cmo.aip;
            vVar2.handleAction(52, null);
        }
    }
}
