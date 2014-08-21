package com.baidu.tieba.mention;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.az;
import com.baidu.tbadk.core.atomData.ce;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.pb.main.bp;
import com.baidu.tieba.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements com.baidu.tieba.model.as {
    final /* synthetic */ al a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar) {
        this.a = alVar;
    }

    @Override // com.baidu.tieba.model.as
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.e eVar, WriteData writeData, AntiData antiData) {
        WriteImagesInfo writeImagesInfo;
        Activity activity;
        Activity activity2;
        com.baidu.tieba.model.ar arVar;
        com.baidu.tieba.model.ar arVar2;
        com.baidu.tieba.model.ar arVar3;
        v vVar;
        this.a.d(z);
        al alVar = this.a;
        writeImagesInfo = this.a.q;
        alVar.a(writeImagesInfo, true);
        if (z) {
            this.a.i();
            bp.a().f();
            arVar = this.a.g;
            arVar.a();
            arVar2 = this.a.g;
            arVar2.a((WriteData) null);
            arVar3 = this.a.g;
            arVar3.a(false);
            this.a.a(antiData, str);
            this.a.c(true);
            vVar = this.a.b;
            vVar.i();
        } else if (eVar != null && writeData != null && eVar.b() != null) {
            if (!AntiHelper.c(antiData)) {
                writeData.setVcodeMD5(eVar.a());
                writeData.setVcodeUrl(eVar.b());
                if (eVar.c().equals("4")) {
                    MessageManager messageManager = MessageManager.getInstance();
                    activity2 = this.a.e;
                    messageManager.sendMessage(new CustomMessage(2002001, new az(activity2, 12006, writeData, false)));
                    return;
                }
                MessageManager messageManager2 = MessageManager.getInstance();
                activity = this.a.e;
                messageManager2.sendMessage(new CustomMessage(2002001, new ce(activity, writeData, 12006)));
                return;
            }
            this.a.a(antiData, str);
        } else {
            this.a.a(antiData, str);
        }
    }
}
