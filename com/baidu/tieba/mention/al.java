package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements DialogInterface.OnClickListener {
    final /* synthetic */ af bsE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(af afVar) {
        this.bsE = afVar;
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
            writeImagesInfo4 = this.bsE.apq;
            if (writeImagesInfo4.getChosedFiles() != null) {
                writeImagesInfo5 = this.bsE.apq;
                int size = writeImagesInfo5.getChosedFiles().size();
                writeImagesInfo6 = this.bsE.apq;
                if (size >= writeImagesInfo6.getMaxImagesAllowed()) {
                    this.bsE.getPageContext().showToast(String.format(this.bsE.getString(com.baidu.tieba.z.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.bsE.aAI = String.valueOf(System.currentTimeMillis());
            TbPageContext pageContext = this.bsE.getPageContext();
            str = this.bsE.aAI;
            aw.a(pageContext, str);
        } else if (i == 1) {
            writeImagesInfo = this.bsE.apq;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.bsE.apq;
                if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                    Activity activity = this.bsE.getActivity();
                    writeImagesInfo3 = this.bsE.apq;
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(activity, writeImagesInfo3.toJsonString());
                    albumActivityConfig.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                }
            }
        }
    }
}
