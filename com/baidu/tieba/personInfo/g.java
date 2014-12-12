package com.baidu.tieba.personInfo;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.core.dialog.l {
    final /* synthetic */ PersonInfoActivity bIm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonInfoActivity personInfoActivity) {
        this.bIm = personInfoActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.l
    public void itemClick(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
        WriteImagesInfo writeImagesInfo;
        if (i != 0) {
            if (i == 1) {
                aw.a(this.bIm.getPageContext());
            } else if (i == 2) {
                Activity pageActivity = this.bIm.getPageContext().getPageActivity();
                writeImagesInfo = this.bIm.writeImagesInfo;
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo.toJsonString());
                albumActivityConfig.setRequestCode(12002);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        } else {
            this.bIm.aaQ();
        }
        iVar.dismiss();
    }
}
