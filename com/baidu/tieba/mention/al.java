package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements DialogInterface.OnClickListener {
    final /* synthetic */ af bua;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(af afVar) {
        this.bua = afVar;
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
            writeImagesInfo4 = this.bua.aqi;
            if (writeImagesInfo4.getChosedFiles() != null) {
                writeImagesInfo5 = this.bua.aqi;
                int size = writeImagesInfo5.getChosedFiles().size();
                writeImagesInfo6 = this.bua.aqi;
                if (size >= writeImagesInfo6.getMaxImagesAllowed()) {
                    this.bua.getPageContext().showToast(String.format(this.bua.getString(com.baidu.tieba.z.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.bua.aBH = String.valueOf(System.currentTimeMillis());
            TbPageContext pageContext = this.bua.getPageContext();
            str = this.bua.aBH;
            bb.a(pageContext, str);
        } else if (i == 1) {
            writeImagesInfo = this.bua.aqi;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.bua.aqi;
                if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                    Activity activity = this.bua.getActivity();
                    writeImagesInfo3 = this.bua.aqi;
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(activity, writeImagesInfo3.toJsonString());
                    albumActivityConfig.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                }
            }
        }
    }
}
