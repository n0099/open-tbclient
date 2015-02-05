package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ bz bEB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(bz bzVar) {
        this.bEB = bzVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        com.baidu.tbadk.editortool.w wVar;
        com.baidu.tbadk.editortool.w wVar2;
        PbEditor pbEditor;
        PbEditor pbEditor2;
        PbActivity pbActivity;
        if (i == 35) {
            pbEditor = this.bEB.bEe;
            if (!pbEditor.afI()) {
                pbEditor2 = this.bEB.bEe;
                if (!pbEditor2.afW()) {
                    pbActivity = this.bEB.bCF;
                    TiebaStatic.eventStat(pbActivity.getPageContext().getPageActivity(), "pb_reply", "pbclick", 1, new Object[0]);
                }
            }
        }
        wVar = this.bEB.bEf;
        if (wVar != null) {
            wVar2 = this.bEB.bEf;
            wVar2.handleAction(i, obj);
        }
    }
}
