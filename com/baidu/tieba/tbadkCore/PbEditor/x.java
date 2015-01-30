package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ u bWe;
    private final /* synthetic */ FrameLayout bWf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar, FrameLayout frameLayout) {
        this.bWe = uVar;
        this.bWf = frameLayout;
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
        com.baidu.tbadk.editortool.w wVar;
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
        com.baidu.tbadk.editortool.w wVar2;
        EditorToolComponetContainer editorToolComponetContainer21;
        writeImagesInfo = this.bWe.bWd;
        editorToolComponetContainer = this.bWe.bWa;
        writeImagesInfo2 = editorToolComponetContainer.bVY;
        if (writeImagesInfo == writeImagesInfo2) {
            editorToolComponetContainer14 = this.bWe.bWa;
            if (!editorToolComponetContainer14.bVN.ahW()) {
                editorToolComponetContainer15 = this.bWe.bWa;
                editorToolComponetContainer15.bVL.Y(this.bWf);
                editorToolComponetContainer16 = this.bWe.bWa;
                int Z = editorToolComponetContainer16.bVN.Z(this.bWf);
                editorToolComponetContainer17 = this.bWe.bWa;
                writeImagesInfo5 = editorToolComponetContainer17.bVY;
                ImageFileInfo remove = writeImagesInfo5.getChosedFiles().remove(Z);
                if (remove.isTempFile()) {
                    this.bWe.ij(remove.getFilePath());
                }
                editorToolComponetContainer18 = this.bWe.bWa;
                editorToolComponetContainer18.bVC.vE();
                editorToolComponetContainer19 = this.bWe.bWa;
                editorToolComponetContainer19.bVO.setText("");
                editorToolComponetContainer20 = this.bWe.bWa;
                wVar2 = editorToolComponetContainer20.Yj;
                wVar2.handleAction(51, null);
                editorToolComponetContainer21 = this.bWe.bWa;
                editorToolComponetContainer21.afD();
                return;
            }
            return;
        }
        editorToolComponetContainer2 = this.bWe.bWa;
        if (!editorToolComponetContainer2.bVK.ahW()) {
            editorToolComponetContainer3 = this.bWe.bWa;
            editorToolComponetContainer3.bVI.Y(this.bWf);
            editorToolComponetContainer4 = this.bWe.bWa;
            int Z2 = editorToolComponetContainer4.bVK.Z(this.bWf);
            editorToolComponetContainer5 = this.bWe.bWa;
            writeImagesInfo3 = editorToolComponetContainer5.bVX;
            ImageFileInfo remove2 = writeImagesInfo3.getChosedFiles().remove(Z2);
            if (remove2.isTempFile()) {
                this.bWe.ij(remove2.getFilePath());
            }
            editorToolComponetContainer6 = this.bWe.bWa;
            int maxItemNum = editorToolComponetContainer6.bVK.getMaxItemNum();
            editorToolComponetContainer7 = this.bWe.bWa;
            writeImagesInfo4 = editorToolComponetContainer7.bVX;
            int size = writeImagesInfo4.size();
            editorToolComponetContainer8 = this.bWe.bWa;
            String string = editorToolComponetContainer8.getResources().getString(com.baidu.tieba.z.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
            editorToolComponetContainer9 = this.bWe.bWa;
            editorToolComponetContainer9.bVP.setText(string);
            editorToolComponetContainer10 = this.bWe.bWa;
            editorToolComponetContainer10.bVC.ee(new StringBuilder(String.valueOf(size)).toString());
            if (size == 0) {
                editorToolComponetContainer13 = this.bWe.bWa;
                editorToolComponetContainer13.bVC.vx();
            }
            editorToolComponetContainer11 = this.bWe.bWa;
            wVar = editorToolComponetContainer11.Yj;
            wVar.handleAction(13, null);
            editorToolComponetContainer12 = this.bWe.bWa;
            editorToolComponetContainer12.afD();
        }
    }
}
