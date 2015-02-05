package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.io.File;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    private final /* synthetic */ ViewGroup aqe;
    final /* synthetic */ u bWd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar, ViewGroup viewGroup) {
        this.bWd = uVar;
        this.aqe = viewGroup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteImagesInfo writeImagesInfo;
        EditorToolComponetContainer editorToolComponetContainer;
        WriteImagesInfo writeImagesInfo2;
        int indexOfChild;
        boolean z;
        EditorToolComponetContainer editorToolComponetContainer2;
        com.baidu.tbadk.editortool.w wVar;
        EditorToolComponetContainer editorToolComponetContainer3;
        writeImagesInfo = this.bWd.bWc;
        editorToolComponetContainer = this.bWd.bVZ;
        writeImagesInfo2 = editorToolComponetContainer.bVW;
        if (writeImagesInfo == writeImagesInfo2 && (indexOfChild = this.aqe.indexOfChild(view)) >= 0) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.bWd.getItem(indexOfChild);
            if (imageFileInfo == null) {
                z = false;
            } else {
                File file = new File(imageFileInfo.getFilePath());
                z = file.exists() && file.length() != 0;
            }
            if (!z) {
                editorToolComponetContainer3 = this.bWd.bVZ;
                com.baidu.adp.lib.util.l.c(editorToolComponetContainer3.getContext(), com.baidu.tieba.z.editor_mutiiamge_image_error);
                return;
            }
            editorToolComponetContainer2 = this.bWd.bVZ;
            wVar = editorToolComponetContainer2.Yg;
            wVar.handleAction(42, Integer.valueOf(indexOfChild));
        }
    }
}
