package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.io.File;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    private final /* synthetic */ ViewGroup aqh;
    final /* synthetic */ u bWe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar, ViewGroup viewGroup) {
        this.bWe = uVar;
        this.aqh = viewGroup;
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
        writeImagesInfo = this.bWe.bWd;
        editorToolComponetContainer = this.bWe.bWa;
        writeImagesInfo2 = editorToolComponetContainer.bVX;
        if (writeImagesInfo == writeImagesInfo2 && (indexOfChild = this.aqh.indexOfChild(view)) >= 0) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.bWe.getItem(indexOfChild);
            if (imageFileInfo == null) {
                z = false;
            } else {
                File file = new File(imageFileInfo.getFilePath());
                z = file.exists() && file.length() != 0;
            }
            if (!z) {
                editorToolComponetContainer3 = this.bWe.bWa;
                com.baidu.adp.lib.util.l.c(editorToolComponetContainer3.getContext(), com.baidu.tieba.z.editor_mutiiamge_image_error);
                return;
            }
            editorToolComponetContainer2 = this.bWe.bWa;
            wVar = editorToolComponetContainer2.Yj;
            wVar.handleAction(42, Integer.valueOf(indexOfChild));
        }
    }
}
