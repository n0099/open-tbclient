package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cy implements com.baidu.tbadk.editortool.v {
    final /* synthetic */ ch bOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(ch chVar) {
        this.bOG = chVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        com.baidu.tbadk.editortool.v vVar;
        com.baidu.tbadk.editortool.v vVar2;
        PbEditor pbEditor;
        PbEditor pbEditor2;
        PbActivity pbActivity;
        if (i == 35) {
            pbEditor = this.bOG.bOi;
            if (!pbEditor.anx()) {
                pbEditor2 = this.bOG.bOi;
                if (!pbEditor2.anL()) {
                    pbActivity = this.bOG.bLa;
                    TiebaStatic.eventStat(pbActivity.getPageContext().getPageActivity(), "pb_reply", "pbclick", 1, new Object[0]);
                }
            }
        }
        vVar = this.bOG.bOj;
        if (vVar != null) {
            vVar2 = this.bOG.bOj;
            vVar2.handleAction(i, obj);
        }
    }
}
