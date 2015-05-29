package com.baidu.tieba.personInfo;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ PersonInfoActivity bVe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonInfoActivity personInfoActivity) {
        this.bVe = personInfoActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        WriteImagesInfo writeImagesInfo;
        if (i != 0) {
            if (i == 1) {
                Activity pageActivity = this.bVe.getPageContext().getPageActivity();
                writeImagesInfo = this.bVe.writeImagesInfo;
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo.toJsonString());
                albumActivityConfig.setRequestCode(12002);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            } else if (i == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.bVe.getPageContext().getPageActivity(), 12014)));
            }
        } else {
            this.bVe.aeX();
        }
        eVar.dismiss();
    }
}
