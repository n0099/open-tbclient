package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ j cmI;
    private final /* synthetic */ FrameLayout cmK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar, FrameLayout frameLayout) {
        this.cmI = jVar;
        this.cmK = frameLayout;
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
        writeImagesInfo = this.cmI.cmH;
        editorToolComponetContainer = this.cmI.cmE;
        writeImagesInfo2 = editorToolComponetContainer.cmC;
        if (writeImagesInfo == writeImagesInfo2) {
            editorToolComponetContainer14 = this.cmI.cmE;
            if (!editorToolComponetContainer14.cms.anh()) {
                editorToolComponetContainer15 = this.cmI.cmE;
                editorToolComponetContainer15.cmq.ab(this.cmK);
                editorToolComponetContainer16 = this.cmI.cmE;
                int ac = editorToolComponetContainer16.cms.ac(this.cmK);
                editorToolComponetContainer17 = this.cmI.cmE;
                writeImagesInfo5 = editorToolComponetContainer17.cmC;
                ImageFileInfo remove = writeImagesInfo5.getChosedFiles().remove(ac);
                if (remove.isTempFile()) {
                    this.cmI.iF(remove.getFilePath());
                }
                editorToolComponetContainer18 = this.cmI.cmE;
                editorToolComponetContainer18.cmh.zc();
                editorToolComponetContainer19 = this.cmI.cmE;
                editorToolComponetContainer19.cmt.setText("");
                editorToolComponetContainer20 = this.cmI.cmE;
                vVar2 = editorToolComponetContainer20.aix;
                vVar2.handleAction(51, null);
                editorToolComponetContainer21 = this.cmI.cmE;
                editorToolComponetContainer21.alA();
                return;
            }
            return;
        }
        editorToolComponetContainer2 = this.cmI.cmE;
        if (!editorToolComponetContainer2.cmp.anh()) {
            editorToolComponetContainer3 = this.cmI.cmE;
            editorToolComponetContainer3.cmn.ab(this.cmK);
            editorToolComponetContainer4 = this.cmI.cmE;
            int ac2 = editorToolComponetContainer4.cmp.ac(this.cmK);
            editorToolComponetContainer5 = this.cmI.cmE;
            writeImagesInfo3 = editorToolComponetContainer5.cmB;
            ImageFileInfo remove2 = writeImagesInfo3.getChosedFiles().remove(ac2);
            if (remove2.isTempFile()) {
                this.cmI.iF(remove2.getFilePath());
            }
            editorToolComponetContainer6 = this.cmI.cmE;
            int maxItemNum = editorToolComponetContainer6.cmp.getMaxItemNum();
            editorToolComponetContainer7 = this.cmI.cmE;
            writeImagesInfo4 = editorToolComponetContainer7.cmB;
            int size = writeImagesInfo4.size();
            editorToolComponetContainer8 = this.cmI.cmE;
            String string = editorToolComponetContainer8.getResources().getString(com.baidu.tieba.y.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
            editorToolComponetContainer9 = this.cmI.cmE;
            editorToolComponetContainer9.cmu.setText(string);
            editorToolComponetContainer10 = this.cmI.cmE;
            editorToolComponetContainer10.cmh.el(new StringBuilder(String.valueOf(size)).toString());
            if (size == 0) {
                editorToolComponetContainer13 = this.cmI.cmE;
                editorToolComponetContainer13.cmh.yV();
            }
            editorToolComponetContainer11 = this.cmI.cmE;
            vVar = editorToolComponetContainer11.aix;
            vVar.handleAction(13, null);
            editorToolComponetContainer12 = this.cmI.cmE;
            editorToolComponetContainer12.alA();
        }
    }
}
