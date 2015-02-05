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
    final /* synthetic */ af bua;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.bua = afVar;
    }

    @Override // com.baidu.tieba.tbadkCore.f.b
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.j jVar, WriteData writeData, AntiData antiData) {
        WriteImagesInfo writeImagesInfo;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        com.baidu.tieba.tbadkCore.f.a aVar3;
        com.baidu.tbadk.mvc.j.c cVar;
        this.bua.bG(z);
        af afVar = this.bua;
        writeImagesInfo = this.bua.aqi;
        afVar.a(writeImagesInfo, true);
        if (z) {
            this.bua.FB();
            TbadkCoreApplication.m255getInst().resetPbRecorder();
            aVar = this.bua.aBJ;
            aVar.Fn();
            aVar2 = this.bua.aBJ;
            aVar2.c((WriteData) null);
            aVar3 = this.bua.aBJ;
            aVar3.eF(false);
            this.bua.a(antiData, str);
            this.bua.ds(true);
            cVar = this.bua.atQ;
            cVar.notifyDataSetChanged();
        } else if (jVar != null && writeData != null && jVar.getVcode_pic_url() != null) {
            if (!AntiHelper.e(antiData)) {
                writeData.setVcodeMD5(jVar.getVcode_md5());
                writeData.setVcodeUrl(jVar.getVcode_pic_url());
                if (jVar.rK().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.bua.getActivity(), 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.bua.getActivity(), writeData, 12006)));
                    return;
                }
            }
            this.bua.a(antiData, str);
        } else {
            this.bua.a(antiData, str);
        }
    }
}
