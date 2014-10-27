package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements DialogInterface.OnClickListener {
    final /* synthetic */ ae bnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ae aeVar) {
        this.bnS = aeVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        Activity activity;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        Activity activity2;
        String str;
        WriteImagesInfo writeImagesInfo5;
        WriteImagesInfo writeImagesInfo6;
        if (i == 0) {
            writeImagesInfo4 = this.bnS.ahS;
            if (writeImagesInfo4.getChosedFiles() != null) {
                writeImagesInfo5 = this.bnS.ahS;
                int size = writeImagesInfo5.getChosedFiles().size();
                writeImagesInfo6 = this.bnS.ahS;
                if (size >= writeImagesInfo6.getMaxImagesAllowed()) {
                    this.bnS.showToast(String.format(this.bnS.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.bnS.ayx = String.valueOf(System.currentTimeMillis());
            activity2 = this.bnS.mActivity;
            str = this.bnS.ayx;
            av.a(activity2, str);
        } else if (i == 1) {
            writeImagesInfo = this.bnS.ahS;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.bnS.ahS;
                if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                    activity = this.bnS.mActivity;
                    writeImagesInfo3 = this.bnS.ahS;
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(activity, writeImagesInfo3.toJsonString());
                    albumActivityConfig.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                }
            }
        }
    }
}
