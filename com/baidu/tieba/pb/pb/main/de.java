package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class de implements com.baidu.tbadk.editortool.v {
    final /* synthetic */ ci bMm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(ci ciVar) {
        this.bMm = ciVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        com.baidu.tbadk.editortool.v vVar;
        com.baidu.tbadk.editortool.v vVar2;
        PbEditor pbEditor;
        PbEditor pbEditor2;
        PbActivity pbActivity;
        if (i == 35) {
            pbEditor = this.bMm.bLR;
            if (!pbEditor.alv()) {
                pbEditor2 = this.bMm.bLR;
                if (!pbEditor2.alJ()) {
                    pbActivity = this.bMm.bIF;
                    TiebaStatic.eventStat(pbActivity.getPageContext().getPageActivity(), "pb_reply", "pbclick", 1, new Object[0]);
                }
            }
        }
        vVar = this.bMm.bLS;
        if (vVar != null) {
            vVar2 = this.bMm.bLS;
            vVar2.handleAction(i, obj);
        }
    }
}
