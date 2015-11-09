package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements c.b {
    final /* synthetic */ PersonChangeActivity cry;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PersonChangeActivity personChangeActivity) {
        this.cry = personChangeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        WriteImagesInfo writeImagesInfo;
        if (i == 0) {
            Activity pageActivity = this.cry.getPageContext().getPageActivity();
            writeImagesInfo = this.cry.mWriteImagesInfo;
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) pageActivity, writeImagesInfo.toJsonString(), true);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        } else if (i == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.cry.getPageContext().getPageActivity(), 12014)));
        }
        cVar.dismiss();
    }
}
