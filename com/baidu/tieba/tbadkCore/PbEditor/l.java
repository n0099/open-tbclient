package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.io.File;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ j cmI;
    private final /* synthetic */ ViewGroup cmJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, ViewGroup viewGroup) {
        this.cmI = jVar;
        this.cmJ = viewGroup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteImagesInfo writeImagesInfo;
        EditorToolComponetContainer editorToolComponetContainer;
        WriteImagesInfo writeImagesInfo2;
        int indexOfChild;
        boolean z;
        EditorToolComponetContainer editorToolComponetContainer2;
        com.baidu.tbadk.editortool.v vVar;
        EditorToolComponetContainer editorToolComponetContainer3;
        writeImagesInfo = this.cmI.cmH;
        editorToolComponetContainer = this.cmI.cmE;
        writeImagesInfo2 = editorToolComponetContainer.cmB;
        if (writeImagesInfo == writeImagesInfo2 && (indexOfChild = this.cmJ.indexOfChild(view)) >= 0) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.cmI.getItem(indexOfChild);
            if (imageFileInfo == null) {
                z = false;
            } else {
                File file = new File(imageFileInfo.getFilePath());
                z = file.exists() && file.length() != 0;
            }
            if (!z) {
                editorToolComponetContainer3 = this.cmI.cmE;
                com.baidu.adp.lib.util.n.c(editorToolComponetContainer3.getContext(), com.baidu.tieba.y.editor_mutiiamge_image_error);
                return;
            }
            editorToolComponetContainer2 = this.cmI.cmE;
            vVar = editorToolComponetContainer2.aix;
            vVar.handleAction(42, Integer.valueOf(indexOfChild));
        }
    }
}
