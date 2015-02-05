package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ u bWd;
    private final /* synthetic */ FrameLayout bWe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar, FrameLayout frameLayout) {
        this.bWd = uVar;
        this.bWe = frameLayout;
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
        writeImagesInfo = this.bWd.bWc;
        editorToolComponetContainer = this.bWd.bVZ;
        writeImagesInfo2 = editorToolComponetContainer.bVX;
        if (writeImagesInfo == writeImagesInfo2) {
            editorToolComponetContainer14 = this.bWd.bVZ;
            if (!editorToolComponetContainer14.bVM.ahR()) {
                editorToolComponetContainer15 = this.bWd.bVZ;
                editorToolComponetContainer15.bVK.Y(this.bWe);
                editorToolComponetContainer16 = this.bWd.bVZ;
                int Z = editorToolComponetContainer16.bVM.Z(this.bWe);
                editorToolComponetContainer17 = this.bWd.bVZ;
                writeImagesInfo5 = editorToolComponetContainer17.bVX;
                ImageFileInfo remove = writeImagesInfo5.getChosedFiles().remove(Z);
                if (remove.isTempFile()) {
                    this.bWd.ih(remove.getFilePath());
                }
                editorToolComponetContainer18 = this.bWd.bVZ;
                editorToolComponetContainer18.bVB.vy();
                editorToolComponetContainer19 = this.bWd.bVZ;
                editorToolComponetContainer19.bVN.setText("");
                editorToolComponetContainer20 = this.bWd.bVZ;
                wVar2 = editorToolComponetContainer20.Yg;
                wVar2.handleAction(51, null);
                editorToolComponetContainer21 = this.bWd.bVZ;
                editorToolComponetContainer21.afy();
                return;
            }
            return;
        }
        editorToolComponetContainer2 = this.bWd.bVZ;
        if (!editorToolComponetContainer2.bVJ.ahR()) {
            editorToolComponetContainer3 = this.bWd.bVZ;
            editorToolComponetContainer3.bVH.Y(this.bWe);
            editorToolComponetContainer4 = this.bWd.bVZ;
            int Z2 = editorToolComponetContainer4.bVJ.Z(this.bWe);
            editorToolComponetContainer5 = this.bWd.bVZ;
            writeImagesInfo3 = editorToolComponetContainer5.bVW;
            ImageFileInfo remove2 = writeImagesInfo3.getChosedFiles().remove(Z2);
            if (remove2.isTempFile()) {
                this.bWd.ih(remove2.getFilePath());
            }
            editorToolComponetContainer6 = this.bWd.bVZ;
            int maxItemNum = editorToolComponetContainer6.bVJ.getMaxItemNum();
            editorToolComponetContainer7 = this.bWd.bVZ;
            writeImagesInfo4 = editorToolComponetContainer7.bVW;
            int size = writeImagesInfo4.size();
            editorToolComponetContainer8 = this.bWd.bVZ;
            String string = editorToolComponetContainer8.getResources().getString(com.baidu.tieba.z.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
            editorToolComponetContainer9 = this.bWd.bVZ;
            editorToolComponetContainer9.bVO.setText(string);
            editorToolComponetContainer10 = this.bWd.bVZ;
            editorToolComponetContainer10.bVB.eb(new StringBuilder(String.valueOf(size)).toString());
            if (size == 0) {
                editorToolComponetContainer13 = this.bWd.bVZ;
                editorToolComponetContainer13.bVB.vr();
            }
            editorToolComponetContainer11 = this.bWd.bVZ;
            wVar = editorToolComponetContainer11.Yg;
            wVar.handleAction(13, null);
            editorToolComponetContainer12 = this.bWd.bVZ;
            editorToolComponetContainer12.afy();
        }
    }
}
