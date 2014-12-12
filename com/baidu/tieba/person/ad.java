package com.baidu.tieba.person;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity bGa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PersonChangeActivity personChangeActivity) {
        this.bGa = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteImagesInfo writeImagesInfo;
        if (i == 0) {
            com.baidu.tbadk.core.util.aw.a(this.bGa.getPageContext());
        } else if (i == 1) {
            Activity pageActivity = this.bGa.getPageContext().getPageActivity();
            writeImagesInfo = this.bGa.apq;
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }
}
