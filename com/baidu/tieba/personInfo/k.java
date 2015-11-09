package com.baidu.tieba.personInfo;

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
public class k implements c.b {
    final /* synthetic */ PersonInfoActivity cue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PersonInfoActivity personInfoActivity) {
        this.cue = personInfoActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        WriteImagesInfo writeImagesInfo;
        if (i != 0) {
            if (i == 1) {
                Activity pageActivity = this.cue.getPageContext().getPageActivity();
                writeImagesInfo = this.cue.writeImagesInfo;
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) pageActivity, writeImagesInfo.toJsonString(), true);
                albumActivityConfig.setRequestCode(12002);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
            } else if (i == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.cue.getPageContext().getPageActivity(), 12014)));
            }
        } else {
            this.cue.ajO();
        }
        cVar.dismiss();
    }
}
