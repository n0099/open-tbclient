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
    final /* synthetic */ ae bog;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ae aeVar) {
        this.bog = aeVar;
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
            writeImagesInfo4 = this.bog.aib;
            if (writeImagesInfo4.getChosedFiles() != null) {
                writeImagesInfo5 = this.bog.aib;
                int size = writeImagesInfo5.getChosedFiles().size();
                writeImagesInfo6 = this.bog.aib;
                if (size >= writeImagesInfo6.getMaxImagesAllowed()) {
                    this.bog.showToast(String.format(this.bog.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.bog.ayG = String.valueOf(System.currentTimeMillis());
            activity2 = this.bog.mActivity;
            str = this.bog.ayG;
            av.a(activity2, str);
        } else if (i == 1) {
            writeImagesInfo = this.bog.aib;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.bog.aib;
                if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                    activity = this.bog.mActivity;
                    writeImagesInfo3 = this.bog.aib;
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(activity, writeImagesInfo3.toJsonString());
                    albumActivityConfig.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                }
            }
        }
    }
}
