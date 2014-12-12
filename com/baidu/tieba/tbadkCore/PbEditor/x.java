package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ u bUm;
    private final /* synthetic */ FrameLayout bUn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar, FrameLayout frameLayout) {
        this.bUm = uVar;
        this.bUn = frameLayout;
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
        writeImagesInfo = this.bUm.bUl;
        editorToolComponetContainer = this.bUm.bUi;
        writeImagesInfo2 = editorToolComponetContainer.bUg;
        if (writeImagesInfo == writeImagesInfo2) {
            editorToolComponetContainer14 = this.bUm.bUi;
            if (!editorToolComponetContainer14.bTV.ahs()) {
                editorToolComponetContainer15 = this.bUm.bUi;
                editorToolComponetContainer15.bTT.W(this.bUn);
                editorToolComponetContainer16 = this.bUm.bUi;
                int X = editorToolComponetContainer16.bTV.X(this.bUn);
                editorToolComponetContainer17 = this.bUm.bUi;
                writeImagesInfo5 = editorToolComponetContainer17.bUg;
                ImageFileInfo remove = writeImagesInfo5.getChosedFiles().remove(X);
                if (remove.isTempFile()) {
                    this.bUm.ib(remove.getFilePath());
                }
                editorToolComponetContainer18 = this.bUm.bUi;
                editorToolComponetContainer18.bTK.vn();
                editorToolComponetContainer19 = this.bUm.bUi;
                editorToolComponetContainer19.bTW.setText("");
                editorToolComponetContainer20 = this.bUm.bUi;
                wVar2 = editorToolComponetContainer20.XD;
                wVar2.handleAction(51, null);
                editorToolComponetContainer21 = this.bUm.bUi;
                editorToolComponetContainer21.aeZ();
                return;
            }
            return;
        }
        editorToolComponetContainer2 = this.bUm.bUi;
        if (!editorToolComponetContainer2.bTS.ahs()) {
            editorToolComponetContainer3 = this.bUm.bUi;
            editorToolComponetContainer3.bTQ.W(this.bUn);
            editorToolComponetContainer4 = this.bUm.bUi;
            int X2 = editorToolComponetContainer4.bTS.X(this.bUn);
            editorToolComponetContainer5 = this.bUm.bUi;
            writeImagesInfo3 = editorToolComponetContainer5.bUf;
            ImageFileInfo remove2 = writeImagesInfo3.getChosedFiles().remove(X2);
            if (remove2.isTempFile()) {
                this.bUm.ib(remove2.getFilePath());
            }
            editorToolComponetContainer6 = this.bUm.bUi;
            int maxItemNum = editorToolComponetContainer6.bTS.getMaxItemNum();
            editorToolComponetContainer7 = this.bUm.bUi;
            writeImagesInfo4 = editorToolComponetContainer7.bUf;
            int size = writeImagesInfo4.size();
            editorToolComponetContainer8 = this.bUm.bUi;
            String string = editorToolComponetContainer8.getResources().getString(com.baidu.tieba.z.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
            editorToolComponetContainer9 = this.bUm.bUi;
            editorToolComponetContainer9.bTX.setText(string);
            editorToolComponetContainer10 = this.bUm.bUi;
            editorToolComponetContainer10.bTK.ee(new StringBuilder(String.valueOf(size)).toString());
            if (size == 0) {
                editorToolComponetContainer13 = this.bUm.bUi;
                editorToolComponetContainer13.bTK.vg();
            }
            editorToolComponetContainer11 = this.bUm.bUi;
            wVar = editorToolComponetContainer11.XD;
            wVar.handleAction(13, null);
            editorToolComponetContainer12 = this.bUm.bUi;
            editorToolComponetContainer12.aeZ();
        }
    }
}
