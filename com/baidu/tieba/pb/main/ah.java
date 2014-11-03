package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PbActivity pbActivity) {
        this.bvu = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        String str;
        WriteImagesInfo writeImagesInfo5;
        WriteImagesInfo writeImagesInfo6;
        if (i == 0) {
            writeImagesInfo4 = this.bvu.writeImagesInfo;
            if (writeImagesInfo4.getChosedFiles() != null) {
                writeImagesInfo5 = this.bvu.writeImagesInfo;
                int size = writeImagesInfo5.getChosedFiles().size();
                writeImagesInfo6 = this.bvu.writeImagesInfo;
                if (size >= writeImagesInfo6.getMaxImagesAllowed()) {
                    this.bvu.showToast(String.format(this.bvu.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.bvu.ayG = String.valueOf(System.currentTimeMillis());
            PbActivity pbActivity = this.bvu;
            str = this.bvu.ayG;
            com.baidu.tbadk.core.util.av.a(pbActivity, str);
        } else if (i == 1) {
            writeImagesInfo = this.bvu.writeImagesInfo;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.bvu.writeImagesInfo;
                if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                    PbActivity pbActivity2 = this.bvu;
                    writeImagesInfo3 = this.bvu.writeImagesInfo;
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pbActivity2, writeImagesInfo3.toJsonString());
                    albumActivityConfig.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                }
            }
        }
    }
}
