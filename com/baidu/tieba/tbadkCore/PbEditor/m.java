package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ j cqI;
    private final /* synthetic */ FrameLayout cqK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar, FrameLayout frameLayout) {
        this.cqI = jVar;
        this.cqK = frameLayout;
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
        writeImagesInfo = this.cqI.cqH;
        editorToolComponetContainer = this.cqI.cqE;
        writeImagesInfo2 = editorToolComponetContainer.cqC;
        if (writeImagesInfo == writeImagesInfo2) {
            editorToolComponetContainer14 = this.cqI.cqE;
            if (!editorToolComponetContainer14.cqr.aoZ()) {
                editorToolComponetContainer15 = this.cqI.cqE;
                editorToolComponetContainer15.cqp.ac(this.cqK);
                editorToolComponetContainer16 = this.cqI.cqE;
                int ad = editorToolComponetContainer16.cqr.ad(this.cqK);
                editorToolComponetContainer17 = this.cqI.cqE;
                writeImagesInfo5 = editorToolComponetContainer17.cqC;
                ImageFileInfo remove = writeImagesInfo5.getChosedFiles().remove(ad);
                if (remove.isTempFile()) {
                    this.cqI.jy(remove.getFilePath());
                }
                editorToolComponetContainer18 = this.cqI.cqE;
                editorToolComponetContainer18.cqg.zQ();
                editorToolComponetContainer19 = this.cqI.cqE;
                editorToolComponetContainer19.cqs.setText("");
                editorToolComponetContainer20 = this.cqI.cqE;
                vVar2 = editorToolComponetContainer20.ajx;
                vVar2.handleAction(51, null);
                editorToolComponetContainer21 = this.cqI.cqE;
                editorToolComponetContainer21.anm();
                return;
            }
            return;
        }
        editorToolComponetContainer2 = this.cqI.cqE;
        if (!editorToolComponetContainer2.cqo.aoZ()) {
            editorToolComponetContainer3 = this.cqI.cqE;
            editorToolComponetContainer3.cqm.ac(this.cqK);
            editorToolComponetContainer4 = this.cqI.cqE;
            int ad2 = editorToolComponetContainer4.cqo.ad(this.cqK);
            editorToolComponetContainer5 = this.cqI.cqE;
            writeImagesInfo3 = editorToolComponetContainer5.cqB;
            ImageFileInfo remove2 = writeImagesInfo3.getChosedFiles().remove(ad2);
            if (remove2.isTempFile()) {
                this.cqI.jy(remove2.getFilePath());
            }
            editorToolComponetContainer6 = this.cqI.cqE;
            int maxItemNum = editorToolComponetContainer6.cqo.getMaxItemNum();
            editorToolComponetContainer7 = this.cqI.cqE;
            writeImagesInfo4 = editorToolComponetContainer7.cqB;
            int size = writeImagesInfo4.size();
            editorToolComponetContainer8 = this.cqI.cqE;
            String string = editorToolComponetContainer8.getResources().getString(com.baidu.tieba.t.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
            editorToolComponetContainer9 = this.cqI.cqE;
            editorToolComponetContainer9.cqt.setText(string);
            editorToolComponetContainer10 = this.cqI.cqE;
            editorToolComponetContainer10.cqg.eC(new StringBuilder(String.valueOf(size)).toString());
            if (size == 0) {
                editorToolComponetContainer13 = this.cqI.cqE;
                editorToolComponetContainer13.cqg.zJ();
            }
            editorToolComponetContainer11 = this.cqI.cqE;
            vVar = editorToolComponetContainer11.ajx;
            vVar.handleAction(13, null);
            editorToolComponetContainer12 = this.cqI.cqE;
            editorToolComponetContainer12.anm();
        }
    }
}
