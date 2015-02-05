package com.baidu.tieba.person;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity bHK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PersonChangeActivity personChangeActivity) {
        this.bHK = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteImagesInfo writeImagesInfo;
        Activity pageActivity = this.bHK.getPageContext().getPageActivity();
        writeImagesInfo = this.bHK.aqi;
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo.toJsonString());
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
    }
}
