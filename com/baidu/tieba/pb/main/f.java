package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.tbadkCore.f.c {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.f.c
    public void a(boolean z, com.baidu.tieba.tbadkCore.f.f fVar, com.baidu.tbadk.coreExtra.data.j jVar, WriteData writeData, AntiData antiData) {
        bz bzVar;
        bz bzVar2;
        WriteImagesInfo writeImagesInfo;
        bz bzVar3;
        bz bzVar4;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        com.baidu.tieba.tbadkCore.f.a aVar3;
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bz bzVar5;
        com.baidu.tieba.pb.sub.e eVar;
        bq bqVar4;
        bz bzVar6;
        bq bqVar5;
        WriteImagesInfo writeImagesInfo2;
        WriteData writeData2;
        this.bzj.stopVoice();
        bzVar = this.bzj.byO;
        bzVar.bD(z);
        bzVar2 = this.bzj.byO;
        writeImagesInfo = this.bzj.writeImagesInfo;
        bzVar2.a(writeImagesInfo, true);
        String str = "";
        if (fVar != null) {
            str = fVar.getErrorString();
        }
        if (z) {
            bzVar3 = this.bzj.byO;
            bzVar3.YE();
            bzVar4 = this.bzj.byO;
            bzVar4.XH();
            aVar = this.bzj.aAK;
            WriteData EV = aVar.EV();
            aVar2 = this.bzj.aAK;
            aVar2.c((WriteData) null);
            aVar3 = this.bzj.aAK;
            aVar3.ey(false);
            bqVar = this.bzj.byJ;
            bqVar.Xs();
            this.bzj.a(antiData, fVar);
            bqVar2 = this.bzj.byJ;
            if (!bqVar2.Xj()) {
                bqVar5 = this.bzj.byJ;
                com.baidu.tieba.tbadkCore.al.b(bqVar5.Xf(), (WriteData) null);
                writeImagesInfo2 = this.bzj.baobaoImagesInfo;
                writeImagesInfo2.clear();
                writeData2 = this.bzj.aCr;
                writeData2.setIsBaobao(false);
            }
            if (EV != null) {
                String floor = EV.getFloor();
                if (EV == null || EV.getType() != 2) {
                    bqVar3 = this.bzj.byJ;
                    if (bqVar3.Xm()) {
                        bzVar5 = this.bzj.byO;
                        bzVar5.Ya();
                        return;
                    }
                    return;
                }
                eVar = this.bzj.byM;
                eVar.Zk();
                if (floor != null) {
                    bqVar4 = this.bzj.byJ;
                    com.baidu.tieba.tbadkCore.b.i pbData = bqVar4.getPbData();
                    bzVar6 = this.bzj.byO;
                    bzVar6.e(pbData);
                }
                com.baidu.tieba.tbadkCore.al.a(EV.getThreadId(), (com.baidu.tieba.tbadkCore.am) this.bzj.getPageContext().getOrignalPage());
            }
        } else if (jVar == null || writeData == null || jVar.getVcode_pic_url() == null) {
            this.bzj.a(antiData, str);
        } else if (AntiHelper.e(antiData)) {
            this.bzj.a(antiData, str);
        } else {
            writeData.setVcodeMD5(jVar.getVcode_md5());
            writeData.setVcodeUrl(jVar.getVcode_pic_url());
            if (jVar.rD().equals("4")) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.bzj.getPageContext().getPageActivity(), 12006, writeData, false)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.bzj.getPageContext().getPageActivity(), writeData, 12006)));
            }
        }
    }
}
