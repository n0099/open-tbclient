package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cy implements com.baidu.tbadk.editortool.v {
    final /* synthetic */ ch bOF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(ch chVar) {
        this.bOF = chVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        com.baidu.tbadk.editortool.v vVar;
        com.baidu.tbadk.editortool.v vVar2;
        PbEditor pbEditor;
        PbEditor pbEditor2;
        PbActivity pbActivity;
        if (i == 35) {
            pbEditor = this.bOF.bOh;
            if (!pbEditor.anw()) {
                pbEditor2 = this.bOF.bOh;
                if (!pbEditor2.anK()) {
                    pbActivity = this.bOF.bKZ;
                    TiebaStatic.eventStat(pbActivity.getPageContext().getPageActivity(), "pb_reply", "pbclick", 1, new Object[0]);
                }
            }
        }
        vVar = this.bOF.bOi;
        if (vVar != null) {
            vVar2 = this.bOF.bOi;
            vVar2.handleAction(i, obj);
        }
    }
}
