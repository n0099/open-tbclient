package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.editortool.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ bv byW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(bv bvVar) {
        this.byW = bvVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        com.baidu.tbadk.editortool.w wVar;
        com.baidu.tbadk.editortool.w wVar2;
        PbEditor pbEditor;
        PbEditor pbEditor2;
        PbActivity pbActivity;
        if (i == 35) {
            pbEditor = this.byW.byB;
            if (!pbEditor.BD()) {
                pbEditor2 = this.byW.byB;
                if (!pbEditor2.BU()) {
                    pbActivity = this.byW.bxe;
                    TiebaStatic.eventStat(pbActivity, "pb_reply", "pbclick", 1, new Object[0]);
                }
            }
        }
        wVar = this.byW.byC;
        if (wVar != null) {
            wVar2 = this.byW.byC;
            wVar2.handleAction(i, obj);
        }
    }
}
