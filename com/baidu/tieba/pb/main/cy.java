package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cy implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ bz bCR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(bz bzVar) {
        this.bCR = bzVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        com.baidu.tbadk.editortool.w wVar;
        com.baidu.tbadk.editortool.w wVar2;
        PbEditor pbEditor;
        PbEditor pbEditor2;
        PbActivity pbActivity;
        if (i == 35) {
            pbEditor = this.bCR.bCu;
            if (!pbEditor.afj()) {
                pbEditor2 = this.bCR.bCu;
                if (!pbEditor2.afx()) {
                    pbActivity = this.bCR.bAW;
                    TiebaStatic.eventStat(pbActivity.getPageContext().getPageActivity(), "pb_reply", "pbclick", 1, new Object[0]);
                }
            }
        }
        wVar = this.bCR.bCv;
        if (wVar != null) {
            wVar2 = this.bCR.bCv;
            wVar2.handleAction(i, obj);
        }
    }
}
