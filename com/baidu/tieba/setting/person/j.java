package com.baidu.tieba.setting.person;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity ccU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PersonChangeActivity personChangeActivity) {
        this.ccU = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteImagesInfo writeImagesInfo;
        Activity pageActivity = this.ccU.getPageContext().getPageActivity();
        writeImagesInfo = this.ccU.aHL;
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo.toJsonString());
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
    }
}
