package com.baidu.tieba.write.view;

import android.view.View;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.write.view.NewFrameMultiImgToolView;
/* loaded from: classes.dex */
class e implements NewFrameMultiImgToolView.a {
    final /* synthetic */ NewFrameMultiImgToolView fXJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NewFrameMultiImgToolView newFrameMultiImgToolView) {
        this.fXJ = newFrameMultiImgToolView;
    }

    @Override // com.baidu.tieba.write.view.NewFrameMultiImgToolView.a
    public void F(View view) {
        DragHorizonScrollView dragHorizonScrollView;
        DragHorizonScrollView dragHorizonScrollView2;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        DragHorizonScrollView dragHorizonScrollView3;
        WriteImagesInfo writeImagesInfo3;
        com.baidu.tbadk.editortools.j jVar;
        WriteImagesInfo writeImagesInfo4;
        com.baidu.tbadk.editortools.j jVar2;
        int i;
        com.baidu.tbadk.editortools.j jVar3;
        int i2;
        boolean z;
        WriteImagesInfo writeImagesInfo5;
        com.baidu.tbadk.editortools.j jVar4;
        com.baidu.tbadk.editortools.j jVar5;
        com.baidu.tbadk.editortools.j jVar6;
        int i3;
        dragHorizonScrollView = this.fXJ.azK;
        if (!dragHorizonScrollView.biF()) {
            this.fXJ.bo(view);
            dragHorizonScrollView2 = this.fXJ.azK;
            int bp = dragHorizonScrollView2.bp(view);
            if (bp >= 0) {
                writeImagesInfo = this.fXJ.azN;
                if (bp < writeImagesInfo.getChosedFiles().size()) {
                    writeImagesInfo2 = this.fXJ.azN;
                    ImageFileInfo remove = writeImagesInfo2.getChosedFiles().remove(bp);
                    if (remove.isTempFile()) {
                        com.baidu.adp.lib.Disk.d.dI().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                    dragHorizonScrollView3 = this.fXJ.azK;
                    int maxItemNum = dragHorizonScrollView3.getMaxItemNum();
                    writeImagesInfo3 = this.fXJ.azN;
                    int size = writeImagesInfo3.getChosedFiles().size();
                    jVar = this.fXJ.JU;
                    if (jVar != null) {
                        jVar2 = this.fXJ.JU;
                        i = this.fXJ.azR;
                        jVar2.b(new com.baidu.tbadk.editortools.a(i, -1, null));
                        if (size > 0) {
                            jVar6 = this.fXJ.JU;
                            i3 = this.fXJ.azS;
                            jVar6.b(new com.baidu.tbadk.editortools.a(2, i3, String.valueOf(size)));
                        } else {
                            jVar3 = this.fXJ.JU;
                            i2 = this.fXJ.azS;
                            jVar3.b(new com.baidu.tbadk.editortools.a(2, i2, null));
                        }
                        if (maxItemNum == 1 && size == 0) {
                            z = this.fXJ.azT;
                            if (z) {
                                jVar5 = this.fXJ.JU;
                                jVar5.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                            } else {
                                NewFrameMultiImgToolView newFrameMultiImgToolView = this.fXJ;
                                writeImagesInfo5 = this.fXJ.azN;
                                newFrameMultiImgToolView.a(writeImagesInfo5, true);
                                jVar4 = this.fXJ.JU;
                                jVar4.invalidate();
                            }
                        }
                    }
                    if (size == 0) {
                        NewFrameMultiImgToolView newFrameMultiImgToolView2 = this.fXJ;
                        writeImagesInfo4 = this.fXJ.azN;
                        newFrameMultiImgToolView2.a(writeImagesInfo4, true);
                    }
                }
            }
        }
    }
}
