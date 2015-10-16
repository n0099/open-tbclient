package com.baidu.tieba.pb.chosen;

import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.tbadk.editortools.c.a<PbChosenActivity> {
    final /* synthetic */ PbChosenActivity cfl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(PbChosenActivity pbChosenActivity, com.baidu.adp.base.h hVar) {
        super(hVar);
        this.cfl = pbChosenActivity;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public boolean Bk() {
        return false;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public WriteData eV(String str) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        com.baidu.tieba.pb.chosen.net.a aVar5;
        aVar = this.cfl.chosenData;
        if (aVar != null) {
            aVar2 = this.cfl.chosenData;
            if (aVar2.getForumInfo() != null) {
                WriteData writeData = new WriteData();
                aVar3 = this.cfl.chosenData;
                writeData.setForumId(String.valueOf(aVar3.getForumInfo().fromfid));
                aVar4 = this.cfl.chosenData;
                writeData.setForumName(aVar4.getForumInfo().fromfname);
                aVar5 = this.cfl.chosenData;
                writeData.setThreadId(String.valueOf(aVar5.getForumInfo().tid));
                writeData.setIsAd(false);
                writeData.setType(1);
                return writeData;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public String Bl() {
        return null;
    }
}
