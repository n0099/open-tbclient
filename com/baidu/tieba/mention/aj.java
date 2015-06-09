package com.baidu.tieba.mention;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements com.baidu.tieba.tbadkCore.writeModel.d {
    final /* synthetic */ ai bGF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar) {
        this.bGF = aiVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.d
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        WriteImagesInfo writeImagesInfo;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar2;
        com.baidu.tieba.tbadkCore.writeModel.a aVar3;
        com.baidu.tbadk.mvc.j.d dVar;
        this.bGF.bT(z);
        ai aiVar = this.bGF;
        writeImagesInfo = this.bGF.mWriteImagesInfo;
        aiVar.a(writeImagesInfo, true);
        if (z) {
            this.bGF.Kl();
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
            aVar = this.bGF.aJU;
            aVar.JT();
            aVar2 = this.bGF.aJU;
            aVar2.c((WriteData) null);
            aVar3 = this.bGF.aJU;
            aVar3.fj(false);
            this.bGF.a(antiData, str);
            this.bGF.dF(true);
            dVar = this.bGF.aDG;
            dVar.notifyDataSetChanged();
        } else if (lVar != null && writeData != null && lVar.getVcode_pic_url() != null) {
            if (!AntiHelper.e(antiData)) {
                writeData.setVcodeMD5(lVar.getVcode_md5());
                writeData.setVcodeUrl(lVar.getVcode_pic_url());
                if (lVar.vv().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.bGF.getActivity(), 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.bGF.getActivity(), writeData, 12006)));
                    return;
                }
            }
            this.bGF.a(antiData, str);
        } else {
            this.bGF.a(antiData, str);
        }
    }
}
