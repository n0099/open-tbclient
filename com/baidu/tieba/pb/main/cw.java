package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ bz bEC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(bz bzVar) {
        this.bEC = bzVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        com.baidu.tbadk.editortool.w wVar;
        com.baidu.tbadk.editortool.w wVar2;
        PbEditor pbEditor;
        PbEditor pbEditor2;
        PbActivity pbActivity;
        if (i == 35) {
            pbEditor = this.bEC.bEf;
            if (!pbEditor.afN()) {
                pbEditor2 = this.bEC.bEf;
                if (!pbEditor2.agb()) {
                    pbActivity = this.bEC.bCG;
                    TiebaStatic.eventStat(pbActivity.getPageContext().getPageActivity(), "pb_reply", "pbclick", 1, new Object[0]);
                }
            }
        }
        wVar = this.bEC.bEg;
        if (wVar != null) {
            wVar2 = this.bEC.bEg;
            wVar2.handleAction(i, obj);
        }
    }
}
