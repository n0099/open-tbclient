package com.baidu.tieba.write;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements DialogInterface.OnClickListener {
    final /* synthetic */ WriteActivity cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity) {
        this.cft = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        WriteImagesInfo writeImagesInfo5;
        String str;
        if (i == 0) {
            writeImagesInfo4 = this.cft.writeImagesInfo;
            int size = writeImagesInfo4.size();
            writeImagesInfo5 = this.cft.writeImagesInfo;
            if (size < writeImagesInfo5.getMaxImagesAllowed()) {
                this.cft.aAI = String.valueOf(System.currentTimeMillis());
                TbPageContext pageContext = this.cft.getPageContext();
                str = this.cft.aAI;
                com.baidu.tbadk.core.util.aw.a(pageContext, str);
                return;
            }
            this.cft.showToast(String.format(this.cft.getPageContext().getString(com.baidu.tieba.z.editor_mutiiamge_max), 10));
        } else if (i == 1) {
            writeImagesInfo = this.cft.writeImagesInfo;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.cft.writeImagesInfo;
                if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                    Activity pageActivity = this.cft.getPageContext().getPageActivity();
                    writeImagesInfo3 = this.cft.writeImagesInfo;
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo3.toJsonString());
                    albumActivityConfig.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                }
            }
        }
    }
}
