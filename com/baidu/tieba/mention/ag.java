package com.baidu.tieba.mention;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tieba.tbadkCore.f.b {
    final /* synthetic */ af bub;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.bub = afVar;
    }

    @Override // com.baidu.tieba.tbadkCore.f.b
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.j jVar, WriteData writeData, AntiData antiData) {
        WriteImagesInfo writeImagesInfo;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        com.baidu.tieba.tbadkCore.f.a aVar3;
        com.baidu.tbadk.mvc.j.c cVar;
        this.bub.bG(z);
        af afVar = this.bub;
        writeImagesInfo = this.bub.aql;
        afVar.a(writeImagesInfo, true);
        if (z) {
            this.bub.FH();
            TbadkCoreApplication.m255getInst().resetPbRecorder();
            aVar = this.bub.aBM;
            aVar.Ft();
            aVar2 = this.bub.aBM;
            aVar2.c((WriteData) null);
            aVar3 = this.bub.aBM;
            aVar3.eF(false);
            this.bub.a(antiData, str);
            this.bub.ds(true);
            cVar = this.bub.atT;
            cVar.notifyDataSetChanged();
        } else if (jVar != null && writeData != null && jVar.getVcode_pic_url() != null) {
            if (!AntiHelper.e(antiData)) {
                writeData.setVcodeMD5(jVar.getVcode_md5());
                writeData.setVcodeUrl(jVar.getVcode_pic_url());
                if (jVar.rQ().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.bub.getActivity(), 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.bub.getActivity(), writeData, 12006)));
                    return;
                }
            }
            this.bub.a(antiData, str);
        } else {
            this.bub.a(antiData, str);
        }
    }
}
