package com.baidu.tieba.pb.chosen;

import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tbadk.editortools.d.a<PbChosenActivity> {
    final /* synthetic */ PbChosenActivity cyo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(PbChosenActivity pbChosenActivity, com.baidu.adp.base.h hVar) {
        super(hVar);
        this.cyo = pbChosenActivity;
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
    public boolean BT() {
        return false;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public WriteData fl(String str) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        com.baidu.tieba.pb.chosen.net.a aVar5;
        aVar = this.cyo.chosenData;
        if (aVar != null) {
            aVar2 = this.cyo.chosenData;
            if (aVar2.getThreadInfo() != null) {
                WriteData writeData = new WriteData();
                aVar3 = this.cyo.chosenData;
                writeData.setForumId(String.valueOf(aVar3.getThreadInfo().forum.forum_id));
                aVar4 = this.cyo.chosenData;
                writeData.setForumName(aVar4.getThreadInfo().forum.forum_name);
                aVar5 = this.cyo.chosenData;
                writeData.setThreadId(String.valueOf(aVar5.getThreadInfo().thread_id));
                writeData.setIsAd(false);
                writeData.setType(1);
                return writeData;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public String BU() {
        return null;
    }
}
