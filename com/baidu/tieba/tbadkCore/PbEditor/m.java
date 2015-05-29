package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ j cqH;
    private final /* synthetic */ FrameLayout cqJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar, FrameLayout frameLayout) {
        this.cqH = jVar;
        this.cqJ = frameLayout;
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
        writeImagesInfo = this.cqH.cqG;
        editorToolComponetContainer = this.cqH.cqD;
        writeImagesInfo2 = editorToolComponetContainer.cqB;
        if (writeImagesInfo == writeImagesInfo2) {
            editorToolComponetContainer14 = this.cqH.cqD;
            if (!editorToolComponetContainer14.cqq.aoY()) {
                editorToolComponetContainer15 = this.cqH.cqD;
                editorToolComponetContainer15.cqo.ac(this.cqJ);
                editorToolComponetContainer16 = this.cqH.cqD;
                int ad = editorToolComponetContainer16.cqq.ad(this.cqJ);
                editorToolComponetContainer17 = this.cqH.cqD;
                writeImagesInfo5 = editorToolComponetContainer17.cqB;
                ImageFileInfo remove = writeImagesInfo5.getChosedFiles().remove(ad);
                if (remove.isTempFile()) {
                    this.cqH.jy(remove.getFilePath());
                }
                editorToolComponetContainer18 = this.cqH.cqD;
                editorToolComponetContainer18.cqf.zP();
                editorToolComponetContainer19 = this.cqH.cqD;
                editorToolComponetContainer19.cqr.setText("");
                editorToolComponetContainer20 = this.cqH.cqD;
                vVar2 = editorToolComponetContainer20.ajx;
                vVar2.handleAction(51, null);
                editorToolComponetContainer21 = this.cqH.cqD;
                editorToolComponetContainer21.anl();
                return;
            }
            return;
        }
        editorToolComponetContainer2 = this.cqH.cqD;
        if (!editorToolComponetContainer2.cqn.aoY()) {
            editorToolComponetContainer3 = this.cqH.cqD;
            editorToolComponetContainer3.cql.ac(this.cqJ);
            editorToolComponetContainer4 = this.cqH.cqD;
            int ad2 = editorToolComponetContainer4.cqn.ad(this.cqJ);
            editorToolComponetContainer5 = this.cqH.cqD;
            writeImagesInfo3 = editorToolComponetContainer5.cqA;
            ImageFileInfo remove2 = writeImagesInfo3.getChosedFiles().remove(ad2);
            if (remove2.isTempFile()) {
                this.cqH.jy(remove2.getFilePath());
            }
            editorToolComponetContainer6 = this.cqH.cqD;
            int maxItemNum = editorToolComponetContainer6.cqn.getMaxItemNum();
            editorToolComponetContainer7 = this.cqH.cqD;
            writeImagesInfo4 = editorToolComponetContainer7.cqA;
            int size = writeImagesInfo4.size();
            editorToolComponetContainer8 = this.cqH.cqD;
            String string = editorToolComponetContainer8.getResources().getString(com.baidu.tieba.t.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
            editorToolComponetContainer9 = this.cqH.cqD;
            editorToolComponetContainer9.cqs.setText(string);
            editorToolComponetContainer10 = this.cqH.cqD;
            editorToolComponetContainer10.cqf.eC(new StringBuilder(String.valueOf(size)).toString());
            if (size == 0) {
                editorToolComponetContainer13 = this.cqH.cqD;
                editorToolComponetContainer13.cqf.zI();
            }
            editorToolComponetContainer11 = this.cqH.cqD;
            vVar = editorToolComponetContainer11.ajx;
            vVar.handleAction(13, null);
            editorToolComponetContainer12 = this.cqH.cqD;
            editorToolComponetContainer12.anl();
        }
    }
}
