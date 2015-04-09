package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class df implements com.baidu.tbadk.editortool.v {
    final /* synthetic */ cj bMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(cj cjVar) {
        this.bMC = cjVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        com.baidu.tbadk.editortool.v vVar;
        com.baidu.tbadk.editortool.v vVar2;
        PbEditor pbEditor;
        PbEditor pbEditor2;
        PbActivity pbActivity;
        if (i == 35) {
            pbEditor = this.bMC.bMh;
            if (!pbEditor.alK()) {
                pbEditor2 = this.bMC.bMh;
                if (!pbEditor2.alY()) {
                    pbActivity = this.bMC.bIT;
                    TiebaStatic.eventStat(pbActivity.getPageContext().getPageActivity(), "pb_reply", "pbclick", 1, new Object[0]);
                }
            }
        }
        vVar = this.bMC.bMi;
        if (vVar != null) {
            vVar2 = this.bMC.bMi;
            vVar2.handleAction(i, obj);
        }
    }
}
