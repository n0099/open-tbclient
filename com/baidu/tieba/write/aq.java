package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements DialogInterface.OnClickListener {
    final /* synthetic */ WriteActivity bTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity) {
        this.bTX = writeActivity;
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
            writeImagesInfo4 = this.bTX.writeImagesInfo;
            int size = writeImagesInfo4.size();
            writeImagesInfo5 = this.bTX.writeImagesInfo;
            if (size < writeImagesInfo5.getMaxImagesAllowed()) {
                this.bTX.ayx = String.valueOf(System.currentTimeMillis());
                WriteActivity writeActivity = this.bTX;
                str = this.bTX.ayx;
                com.baidu.tbadk.core.util.av.a(writeActivity, str);
                return;
            }
            this.bTX.showToast(String.format(this.bTX.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
        } else if (i == 1) {
            writeImagesInfo = this.bTX.writeImagesInfo;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.bTX.writeImagesInfo;
                if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                    WriteActivity writeActivity2 = this.bTX;
                    writeImagesInfo3 = this.bTX.writeImagesInfo;
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(writeActivity2, writeImagesInfo3.toJsonString());
                    albumActivityConfig.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                }
            }
        }
    }
}
