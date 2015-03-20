package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.io.File;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ j cms;
    private final /* synthetic */ ViewGroup cmt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, ViewGroup viewGroup) {
        this.cms = jVar;
        this.cmt = viewGroup;
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
        writeImagesInfo = this.cms.cmr;
        editorToolComponetContainer = this.cms.cmo;
        writeImagesInfo2 = editorToolComponetContainer.cml;
        if (writeImagesInfo == writeImagesInfo2 && (indexOfChild = this.cmt.indexOfChild(view)) >= 0) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.cms.getItem(indexOfChild);
            if (imageFileInfo == null) {
                z = false;
            } else {
                File file = new File(imageFileInfo.getFilePath());
                z = file.exists() && file.length() != 0;
            }
            if (!z) {
                editorToolComponetContainer3 = this.cms.cmo;
                com.baidu.adp.lib.util.n.c(editorToolComponetContainer3.getContext(), com.baidu.tieba.y.editor_mutiiamge_image_error);
                return;
            }
            editorToolComponetContainer2 = this.cms.cmo;
            vVar = editorToolComponetContainer2.aip;
            vVar.handleAction(42, Integer.valueOf(indexOfChild));
        }
    }
}
