package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
class k implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteImagesInfo writeImagesInfo;
        String str;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        this.bvg.FG();
        if (i == 0) {
            writeImagesInfo = this.bvg.writeImagesInfo;
            if (writeImagesInfo.getChosedFiles() != null) {
                writeImagesInfo2 = this.bvg.writeImagesInfo;
                int size = writeImagesInfo2.getChosedFiles().size();
                writeImagesInfo3 = this.bvg.writeImagesInfo;
                if (size >= writeImagesInfo3.getMaxImagesAllowed()) {
                    this.bvg.showToast(String.format(this.bvg.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.bvg.ayx = String.valueOf(System.currentTimeMillis());
            PbActivity pbActivity = this.bvg;
            str = this.bvg.ayx;
            com.baidu.tbadk.core.util.av.a(pbActivity, str);
        } else if (i == 1) {
            com.baidu.tbadk.core.util.av.i(this.bvg);
        }
    }
}
