package com.baidu.tieba.write.view.PhotoLiveView;

import android.widget.GridView;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.PhotoLiveView.a;
import com.baidu.tieba.write.write.WriteActivity;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.InterfaceC0082a {
    final /* synthetic */ a fSz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fSz = aVar;
    }

    @Override // com.baidu.tieba.write.view.PhotoLiveView.a.InterfaceC0082a
    public void sD(int i) {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList linkedList3;
        l lVar;
        BaseActivity baseActivity;
        LinkedList<ImageFileInfo> linkedList4;
        GridView gridView;
        l lVar2;
        int i2;
        l lVar3;
        LinkedList linkedList5;
        l lVar4;
        l lVar5;
        LinkedList linkedList6;
        linkedList = this.fSz.chosedFiles;
        if (linkedList != null) {
            linkedList2 = this.fSz.chosedFiles;
            if (linkedList2.size() - 1 >= i) {
                linkedList6 = this.fSz.chosedFiles;
                ImageFileInfo imageFileInfo = (ImageFileInfo) linkedList6.remove(i);
                if (imageFileInfo.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.bG().c(new DiskFileOperate(imageFileInfo.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
            }
            linkedList3 = this.fSz.chosedFiles;
            int size = linkedList3.size();
            lVar = this.fSz.aqK;
            if (lVar != null) {
                lVar2 = this.fSz.aqK;
                i2 = this.fSz.aso;
                lVar2.b(new com.baidu.tbadk.editortools.a(i2, -1, null));
                if (size > 0) {
                    lVar5 = this.fSz.aqK;
                    lVar5.b(new com.baidu.tbadk.editortools.a(2, 10, String.valueOf(size)));
                } else {
                    lVar3 = this.fSz.aqK;
                    lVar3.b(new com.baidu.tbadk.editortools.a(2, 10, null));
                }
                linkedList5 = this.fSz.chosedFiles;
                if (linkedList5.size() == 1 && size == 0) {
                    lVar4 = this.fSz.aqK;
                    lVar4.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                }
            }
            this.fSz.boh();
            baseActivity = this.fSz.bsn;
            linkedList4 = this.fSz.chosedFiles;
            ((WriteActivity) baseActivity).o(linkedList4);
            this.fSz.boe();
            this.fSz.notifyDataSetChanged();
            gridView = this.fSz.dAR;
            gridView.invalidateViews();
        }
    }
}
