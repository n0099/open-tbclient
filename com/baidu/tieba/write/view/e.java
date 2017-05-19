package com.baidu.tieba.write.view;

import android.view.View;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.write.view.NewFrameMultiImgToolView;
/* loaded from: classes.dex */
class e implements NewFrameMultiImgToolView.a {
    final /* synthetic */ NewFrameMultiImgToolView fPN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NewFrameMultiImgToolView newFrameMultiImgToolView) {
        this.fPN = newFrameMultiImgToolView;
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
        dragHorizonScrollView = this.fPN.azY;
        if (!dragHorizonScrollView.bhl()) {
            this.fPN.bj(view);
            dragHorizonScrollView2 = this.fPN.azY;
            int bk = dragHorizonScrollView2.bk(view);
            if (bk >= 0) {
                writeImagesInfo = this.fPN.aAb;
                if (bk < writeImagesInfo.getChosedFiles().size()) {
                    writeImagesInfo2 = this.fPN.aAb;
                    ImageFileInfo remove = writeImagesInfo2.getChosedFiles().remove(bk);
                    if (remove.isTempFile()) {
                        com.baidu.adp.lib.Disk.d.dI().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                    dragHorizonScrollView3 = this.fPN.azY;
                    int maxItemNum = dragHorizonScrollView3.getMaxItemNum();
                    writeImagesInfo3 = this.fPN.aAb;
                    int size = writeImagesInfo3.getChosedFiles().size();
                    jVar = this.fPN.Kg;
                    if (jVar != null) {
                        jVar2 = this.fPN.Kg;
                        i = this.fPN.aAf;
                        jVar2.b(new com.baidu.tbadk.editortools.a(i, -1, null));
                        if (size > 0) {
                            jVar6 = this.fPN.Kg;
                            i3 = this.fPN.aAg;
                            jVar6.b(new com.baidu.tbadk.editortools.a(2, i3, String.valueOf(size)));
                        } else {
                            jVar3 = this.fPN.Kg;
                            i2 = this.fPN.aAg;
                            jVar3.b(new com.baidu.tbadk.editortools.a(2, i2, null));
                        }
                        if (maxItemNum == 1 && size == 0) {
                            z = this.fPN.aAh;
                            if (z) {
                                jVar5 = this.fPN.Kg;
                                jVar5.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                            } else {
                                NewFrameMultiImgToolView newFrameMultiImgToolView = this.fPN;
                                writeImagesInfo5 = this.fPN.aAb;
                                newFrameMultiImgToolView.a(writeImagesInfo5, true);
                                jVar4 = this.fPN.Kg;
                                jVar4.invalidate();
                            }
                        }
                    }
                    if (size == 0) {
                        NewFrameMultiImgToolView newFrameMultiImgToolView2 = this.fPN;
                        writeImagesInfo4 = this.fPN.aAb;
                        newFrameMultiImgToolView2.a(writeImagesInfo4, true);
                    }
                }
            }
        }
    }
}
