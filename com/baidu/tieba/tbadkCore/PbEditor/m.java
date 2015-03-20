package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ j cms;
    private final /* synthetic */ FrameLayout cmu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar, FrameLayout frameLayout) {
        this.cms = jVar;
        this.cmu = frameLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteImagesInfo writeImagesInfo;
        EditorToolComponetContainer editorToolComponetContainer;
        WriteImagesInfo writeImagesInfo2;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditorToolComponetContainer editorToolComponetContainer3;
        EditorToolComponetContainer editorToolComponetContainer4;
        EditorToolComponetContainer editorToolComponetContainer5;
        WriteImagesInfo writeImagesInfo3;
        EditorToolComponetContainer editorToolComponetContainer6;
        EditorToolComponetContainer editorToolComponetContainer7;
        WriteImagesInfo writeImagesInfo4;
        EditorToolComponetContainer editorToolComponetContainer8;
        EditorToolComponetContainer editorToolComponetContainer9;
        EditorToolComponetContainer editorToolComponetContainer10;
        EditorToolComponetContainer editorToolComponetContainer11;
        com.baidu.tbadk.editortool.v vVar;
        EditorToolComponetContainer editorToolComponetContainer12;
        EditorToolComponetContainer editorToolComponetContainer13;
        EditorToolComponetContainer editorToolComponetContainer14;
        EditorToolComponetContainer editorToolComponetContainer15;
        EditorToolComponetContainer editorToolComponetContainer16;
        EditorToolComponetContainer editorToolComponetContainer17;
        WriteImagesInfo writeImagesInfo5;
        EditorToolComponetContainer editorToolComponetContainer18;
        EditorToolComponetContainer editorToolComponetContainer19;
        EditorToolComponetContainer editorToolComponetContainer20;
        com.baidu.tbadk.editortool.v vVar2;
        EditorToolComponetContainer editorToolComponetContainer21;
        writeImagesInfo = this.cms.cmr;
        editorToolComponetContainer = this.cms.cmo;
        writeImagesInfo2 = editorToolComponetContainer.cmm;
        if (writeImagesInfo == writeImagesInfo2) {
            editorToolComponetContainer14 = this.cms.cmo;
            if (!editorToolComponetContainer14.cmb.amS()) {
                editorToolComponetContainer15 = this.cms.cmo;
                editorToolComponetContainer15.clZ.ab(this.cmu);
                editorToolComponetContainer16 = this.cms.cmo;
                int ac = editorToolComponetContainer16.cmb.ac(this.cmu);
                editorToolComponetContainer17 = this.cms.cmo;
                writeImagesInfo5 = editorToolComponetContainer17.cmm;
                ImageFileInfo remove = writeImagesInfo5.getChosedFiles().remove(ac);
                if (remove.isTempFile()) {
                    this.cms.iC(remove.getFilePath());
                }
                editorToolComponetContainer18 = this.cms.cmo;
                editorToolComponetContainer18.clQ.yW();
                editorToolComponetContainer19 = this.cms.cmo;
                editorToolComponetContainer19.cmc.setText("");
                editorToolComponetContainer20 = this.cms.cmo;
                vVar2 = editorToolComponetContainer20.aip;
                vVar2.handleAction(51, null);
                editorToolComponetContainer21 = this.cms.cmo;
                editorToolComponetContainer21.all();
                return;
            }
            return;
        }
        editorToolComponetContainer2 = this.cms.cmo;
        if (!editorToolComponetContainer2.clY.amS()) {
            editorToolComponetContainer3 = this.cms.cmo;
            editorToolComponetContainer3.clW.ab(this.cmu);
            editorToolComponetContainer4 = this.cms.cmo;
            int ac2 = editorToolComponetContainer4.clY.ac(this.cmu);
            editorToolComponetContainer5 = this.cms.cmo;
            writeImagesInfo3 = editorToolComponetContainer5.cml;
            ImageFileInfo remove2 = writeImagesInfo3.getChosedFiles().remove(ac2);
            if (remove2.isTempFile()) {
                this.cms.iC(remove2.getFilePath());
            }
            editorToolComponetContainer6 = this.cms.cmo;
            int maxItemNum = editorToolComponetContainer6.clY.getMaxItemNum();
            editorToolComponetContainer7 = this.cms.cmo;
            writeImagesInfo4 = editorToolComponetContainer7.cml;
            int size = writeImagesInfo4.size();
            editorToolComponetContainer8 = this.cms.cmo;
            String string = editorToolComponetContainer8.getResources().getString(com.baidu.tieba.y.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
            editorToolComponetContainer9 = this.cms.cmo;
            editorToolComponetContainer9.cme.setText(string);
            editorToolComponetContainer10 = this.cms.cmo;
            editorToolComponetContainer10.clQ.ei(new StringBuilder(String.valueOf(size)).toString());
            if (size == 0) {
                editorToolComponetContainer13 = this.cms.cmo;
                editorToolComponetContainer13.clQ.yP();
            }
            editorToolComponetContainer11 = this.cms.cmo;
            vVar = editorToolComponetContainer11.aip;
            vVar.handleAction(13, null);
            editorToolComponetContainer12 = this.cms.cmo;
            editorToolComponetContainer12.all();
        }
    }
}
