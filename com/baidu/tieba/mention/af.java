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
    final /* synthetic */ ae bnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.bnS = aeVar;
    }

    @Override // com.baidu.tieba.model.as
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.f fVar, WriteData writeData, AntiData antiData) {
        WriteImagesInfo writeImagesInfo;
        Activity activity;
        Activity activity2;
        ar arVar;
        ar arVar2;
        ar arVar3;
        x xVar;
        this.bnS.bQ(z);
        ae aeVar = this.bnS;
        writeImagesInfo = this.bnS.ahS;
        aeVar.a(writeImagesInfo, true);
        if (z) {
            this.bnS.EP();
            bs.WZ().reset();
            arVar = this.bnS.ayz;
            arVar.EC();
            arVar2 = this.bnS.ayz;
            arVar2.b((WriteData) null);
            arVar3 = this.bnS.ayz;
            arVar3.dI(false);
            this.bnS.a(antiData, str);
            this.bnS.dC(true);
            xVar = this.bnS.bnL;
            xVar.SN();
        } else if (fVar != null && writeData != null && fVar.getVcode_pic_url() != null) {
            if (!AntiHelper.e(antiData)) {
                writeData.setVcodeMD5(fVar.getVcode_md5());
                writeData.setVcodeUrl(fVar.getVcode_pic_url());
                if (fVar.oA().equals("4")) {
                    MessageManager messageManager = MessageManager.getInstance();
                    activity2 = this.bnS.mActivity;
                    messageManager.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(activity2, 12006, writeData, false)));
                    return;
                }
                MessageManager messageManager2 = MessageManager.getInstance();
                activity = this.bnS.mActivity;
                messageManager2.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(activity, writeData, 12006)));
                return;
            }
            this.bnS.a(antiData, str);
        } else {
            this.bnS.a(antiData, str);
        }
    }
}
