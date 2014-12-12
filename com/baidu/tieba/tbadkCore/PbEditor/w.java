package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.io.File;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    private final /* synthetic */ ViewGroup aph;
    final /* synthetic */ u bUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar, ViewGroup viewGroup) {
        this.bUm = uVar;
        this.aph = viewGroup;
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
        writeImagesInfo = this.bUm.bUl;
        editorToolComponetContainer = this.bUm.bUi;
        writeImagesInfo2 = editorToolComponetContainer.bUf;
        if (writeImagesInfo == writeImagesInfo2 && (indexOfChild = this.aph.indexOfChild(view)) >= 0) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.bUm.getItem(indexOfChild);
            if (imageFileInfo == null) {
                z = false;
            } else {
                File file = new File(imageFileInfo.getFilePath());
                z = file.exists() && file.length() != 0;
            }
            if (!z) {
                editorToolComponetContainer3 = this.bUm.bUi;
                com.baidu.adp.lib.util.l.c(editorToolComponetContainer3.getContext(), com.baidu.tieba.z.editor_mutiiamge_image_error);
                return;
            }
            editorToolComponetContainer2 = this.bUm.bUi;
            wVar = editorToolComponetContainer2.XD;
            wVar.handleAction(42, Integer.valueOf(indexOfChild));
        }
    }
}
