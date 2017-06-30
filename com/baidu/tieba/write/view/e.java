package com.baidu.tieba.write.view;

import android.view.View;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.write.view.NewFrameMultiImgToolView;
/* loaded from: classes.dex */
class e implements NewFrameMultiImgToolView.a {
    final /* synthetic */ NewFrameMultiImgToolView giJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NewFrameMultiImgToolView newFrameMultiImgToolView) {
        this.giJ = newFrameMultiImgToolView;
    }

    @Override // com.baidu.tieba.write.view.NewFrameMultiImgToolView.a
    public void G(View view) {
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
        dragHorizonScrollView = this.giJ.aAN;
        if (!dragHorizonScrollView.bmT()) {
            this.giJ.bq(view);
            dragHorizonScrollView2 = this.giJ.aAN;
            int br = dragHorizonScrollView2.br(view);
            if (br >= 0) {
                writeImagesInfo = this.giJ.aAQ;
                if (br < writeImagesInfo.getChosedFiles().size()) {
                    writeImagesInfo2 = this.giJ.aAQ;
                    ImageFileInfo remove = writeImagesInfo2.getChosedFiles().remove(br);
                    if (remove.isTempFile()) {
                        com.baidu.adp.lib.Disk.d.dI().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                    dragHorizonScrollView3 = this.giJ.aAN;
                    int maxItemNum = dragHorizonScrollView3.getMaxItemNum();
                    writeImagesInfo3 = this.giJ.aAQ;
                    int size = writeImagesInfo3.getChosedFiles().size();
                    jVar = this.giJ.JT;
                    if (jVar != null) {
                        jVar2 = this.giJ.JT;
                        i = this.giJ.aAU;
                        jVar2.b(new com.baidu.tbadk.editortools.a(i, -1, null));
                        if (size > 0) {
                            jVar6 = this.giJ.JT;
                            i3 = this.giJ.aAV;
                            jVar6.b(new com.baidu.tbadk.editortools.a(2, i3, String.valueOf(size)));
                        } else {
                            jVar3 = this.giJ.JT;
                            i2 = this.giJ.aAV;
                            jVar3.b(new com.baidu.tbadk.editortools.a(2, i2, null));
                        }
                        if (maxItemNum == 1 && size == 0) {
                            z = this.giJ.aAW;
                            if (z) {
                                jVar5 = this.giJ.JT;
                                jVar5.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                            } else {
                                NewFrameMultiImgToolView newFrameMultiImgToolView = this.giJ;
                                writeImagesInfo5 = this.giJ.aAQ;
                                newFrameMultiImgToolView.a(writeImagesInfo5, true);
                                jVar4 = this.giJ.JT;
                                jVar4.invalidate();
                            }
                        }
                    }
                    if (size == 0) {
                        NewFrameMultiImgToolView newFrameMultiImgToolView2 = this.giJ;
                        writeImagesInfo4 = this.giJ.aAQ;
                        newFrameMultiImgToolView2.a(writeImagesInfo4, true);
                    }
                }
            }
        }
    }
}
