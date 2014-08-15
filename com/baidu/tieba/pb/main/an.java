package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PbActivity pbActivity) {
        this.a = pbActivity;
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
            writeImagesInfo4 = this.a.l;
            if (writeImagesInfo4.getChosedFiles() != null) {
                writeImagesInfo5 = this.a.l;
                int size = writeImagesInfo5.getChosedFiles().size();
                writeImagesInfo6 = this.a.l;
                if (size >= writeImagesInfo6.getMaxImagesAllowed()) {
                    this.a.showToast(String.format(this.a.getString(com.baidu.tieba.x.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.a.o = String.valueOf(System.currentTimeMillis());
            PbActivity pbActivity = this.a;
            str = this.a.o;
            com.baidu.tbadk.core.util.ax.a(pbActivity, str);
        } else if (i == 1) {
            writeImagesInfo = this.a.l;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.a.l;
                if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                    PbActivity pbActivity2 = this.a;
                    writeImagesInfo3 = this.a.l;
                    com.baidu.tbadk.core.atomData.b bVar = new com.baidu.tbadk.core.atomData.b(pbActivity2, writeImagesInfo3.toJsonString());
                    bVar.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, bVar));
                }
            }
        }
    }
}
