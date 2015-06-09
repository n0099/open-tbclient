package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer cqE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(EditorToolComponetContainer editorToolComponetContainer) {
        this.cqE = editorToolComponetContainer;
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
        if (view == this.cqE.cqg.getmFace()) {
            vVar7 = this.cqE.ajx;
            vVar7.handleAction(2, null);
        } else if (view == this.cqE.cqg.getmImage() || view == this.cqE.cqg.getmIVImage()) {
            this.cqE.cqg.setmImagetype(2);
            vVar = this.cqE.ajx;
            vVar.handleAction(23, null);
        } else if (view == this.cqE.cqg.getmAt()) {
            vVar6 = this.cqE.ajx;
            vVar6.handleAction(0, null);
        } else if (view == this.cqE.cqg.getmPrivilege()) {
            TiebaStatic.eventStat(this.cqE.getContext(), "consume_18", "click", 1, new Object[0]);
            vVar5 = this.cqE.ajx;
            vVar5.handleAction(44, null);
        } else if (view == this.cqE.cqg.getBaobao()) {
            vVar4 = this.cqE.ajx;
            vVar4.handleAction(48, null);
        } else if (view == this.cqE.cqg.getRecordButton()) {
            vVar3 = this.cqE.ajx;
            vVar3.handleAction(4, null);
        } else if (view == this.cqE.cqg.getLocation()) {
            vVar2 = this.cqE.ajx;
            vVar2.handleAction(52, null);
        }
    }
}
