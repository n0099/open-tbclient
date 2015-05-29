package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer cqD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(EditorToolComponetContainer editorToolComponetContainer) {
        this.cqD = editorToolComponetContainer;
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
        if (view == this.cqD.cqf.getmFace()) {
            vVar7 = this.cqD.ajx;
            vVar7.handleAction(2, null);
        } else if (view == this.cqD.cqf.getmImage() || view == this.cqD.cqf.getmIVImage()) {
            this.cqD.cqf.setmImagetype(2);
            vVar = this.cqD.ajx;
            vVar.handleAction(23, null);
        } else if (view == this.cqD.cqf.getmAt()) {
            vVar6 = this.cqD.ajx;
            vVar6.handleAction(0, null);
        } else if (view == this.cqD.cqf.getmPrivilege()) {
            TiebaStatic.eventStat(this.cqD.getContext(), "consume_18", "click", 1, new Object[0]);
            vVar5 = this.cqD.ajx;
            vVar5.handleAction(44, null);
        } else if (view == this.cqD.cqf.getBaobao()) {
            vVar4 = this.cqD.ajx;
            vVar4.handleAction(48, null);
        } else if (view == this.cqD.cqf.getRecordButton()) {
            vVar3 = this.cqD.ajx;
            vVar3.handleAction(4, null);
        } else if (view == this.cqD.cqf.getLocation()) {
            vVar2 = this.cqD.ajx;
            vVar2.handleAction(52, null);
        }
    }
}
