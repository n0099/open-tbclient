package com.baidu.tieba.mention;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ ai bGF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ai aiVar) {
        this.bGF = aiVar;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        String str;
        WriteImagesInfo writeImagesInfo5;
        WriteImagesInfo writeImagesInfo6;
        eVar.dismiss();
        if (i == 0) {
            writeImagesInfo4 = this.bGF.mWriteImagesInfo;
            if (writeImagesInfo4.getChosedFiles() != null) {
                writeImagesInfo5 = this.bGF.mWriteImagesInfo;
                int size = writeImagesInfo5.getChosedFiles().size();
                writeImagesInfo6 = this.bGF.mWriteImagesInfo;
                if (size >= writeImagesInfo6.getMaxImagesAllowed()) {
                    this.bGF.getPageContext().showToast(String.format(this.bGF.getString(com.baidu.tieba.t.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.bGF.aJS = String.valueOf(System.currentTimeMillis());
            TbPageContext pageContext = this.bGF.getPageContext();
            str = this.bGF.aJS;
            ax.a(pageContext, str);
        } else if (i == 1) {
            writeImagesInfo = this.bGF.mWriteImagesInfo;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.bGF.mWriteImagesInfo;
                if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                    Activity activity = this.bGF.getActivity();
                    writeImagesInfo3 = this.bGF.mWriteImagesInfo;
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(activity, writeImagesInfo3.toJsonString());
                    albumActivityConfig.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                }
            }
        }
    }
}
