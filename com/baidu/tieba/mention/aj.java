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
    final /* synthetic */ ai bDw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar) {
        this.bDw = aiVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.d
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.k kVar, WriteData writeData, AntiData antiData) {
        WriteImagesInfo writeImagesInfo;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar2;
        com.baidu.tieba.tbadkCore.writeModel.a aVar3;
        com.baidu.tbadk.mvc.j.d dVar;
        this.bDw.bK(z);
        ai aiVar = this.bDw;
        writeImagesInfo = this.bDw.aHD;
        aiVar.a(writeImagesInfo, true);
        if (z) {
            this.bDw.Ja();
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
            aVar = this.bDw.aHC;
            aVar.IM();
            aVar2 = this.bDw.aHC;
            aVar2.c((WriteData) null);
            aVar3 = this.bDw.aHC;
            aVar3.eS(false);
            this.bDw.a(antiData, str);
            this.bDw.dw(true);
            dVar = this.bDw.aBB;
            dVar.notifyDataSetChanged();
        } else if (kVar != null && writeData != null && kVar.getVcode_pic_url() != null) {
            if (!AntiHelper.e(antiData)) {
                writeData.setVcodeMD5(kVar.getVcode_md5());
                writeData.setVcodeUrl(kVar.getVcode_pic_url());
                if (kVar.uI().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.bDw.getActivity(), 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.bDw.getActivity(), writeData, 12006)));
                    return;
                }
            }
            this.bDw.a(antiData, str);
        } else {
            this.bDw.a(antiData, str);
        }
    }
}
