package com.baidu.tieba.mention;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.model.ar;
import com.baidu.tieba.model.as;
import com.baidu.tieba.pb.main.bs;
import com.baidu.tieba.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements as {
    final /* synthetic */ ae bog;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.bog = aeVar;
    }

    @Override // com.baidu.tieba.model.as
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.g gVar, WriteData writeData, AntiData antiData) {
        WriteImagesInfo writeImagesInfo;
        Activity activity;
        Activity activity2;
        ar arVar;
        ar arVar2;
        ar arVar3;
        x xVar;
        this.bog.bQ(z);
        ae aeVar = this.bog;
        writeImagesInfo = this.bog.aib;
        aeVar.a(writeImagesInfo, true);
        if (z) {
            this.bog.ER();
            bs.Xc().reset();
            arVar = this.bog.ayI;
            arVar.EE();
            arVar2 = this.bog.ayI;
            arVar2.b((WriteData) null);
            arVar3 = this.bog.ayI;
            arVar3.dI(false);
            this.bog.a(antiData, str);
            this.bog.dC(true);
            xVar = this.bog.bnZ;
            xVar.SQ();
        } else if (gVar != null && writeData != null && gVar.getVcode_pic_url() != null) {
            if (!AntiHelper.e(antiData)) {
                writeData.setVcodeMD5(gVar.getVcode_md5());
                writeData.setVcodeUrl(gVar.getVcode_pic_url());
                if (gVar.oC().equals("4")) {
                    MessageManager messageManager = MessageManager.getInstance();
                    activity2 = this.bog.mActivity;
                    messageManager.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(activity2, 12006, writeData, false)));
                    return;
                }
                MessageManager messageManager2 = MessageManager.getInstance();
                activity = this.bog.mActivity;
                messageManager2.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(activity, writeData, 12006)));
                return;
            }
            this.bog.a(antiData, str);
        } else {
            this.bog.a(antiData, str);
        }
    }
}
