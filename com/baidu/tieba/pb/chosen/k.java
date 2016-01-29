package com.baidu.tieba.pb.chosen;

import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tbadk.editortools.d.a<PbChosenActivity> {
    final /* synthetic */ PbChosenActivity cIA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(PbChosenActivity pbChosenActivity, com.baidu.adp.base.h hVar) {
        super(hVar);
        this.cIA = pbChosenActivity;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public boolean CY() {
        return false;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public WriteData fn(String str) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        com.baidu.tieba.pb.chosen.net.a aVar5;
        aVar = this.cIA.chosenData;
        if (aVar != null) {
            aVar2 = this.cIA.chosenData;
            if (aVar2.getThreadInfo() != null) {
                WriteData writeData = new WriteData();
                aVar3 = this.cIA.chosenData;
                writeData.setForumId(String.valueOf(aVar3.getThreadInfo().forum.forum_id));
                aVar4 = this.cIA.chosenData;
                writeData.setForumName(aVar4.getThreadInfo().forum.forum_name);
                aVar5 = this.cIA.chosenData;
                writeData.setThreadId(String.valueOf(aVar5.getThreadInfo().thread_id));
                writeData.setIsAd(false);
                writeData.setType(1);
                return writeData;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public String CZ() {
        return null;
    }
}
