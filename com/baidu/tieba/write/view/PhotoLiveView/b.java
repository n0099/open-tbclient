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
    final /* synthetic */ a gcE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.gcE = aVar;
    }

    @Override // com.baidu.tieba.write.view.PhotoLiveView.a.InterfaceC0082a
    public void te(int i) {
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
        linkedList = this.gcE.chosedFiles;
        if (linkedList != null) {
            linkedList2 = this.gcE.chosedFiles;
            if (linkedList2.size() - 1 >= i) {
                linkedList6 = this.gcE.chosedFiles;
                ImageFileInfo imageFileInfo = (ImageFileInfo) linkedList6.remove(i);
                if (imageFileInfo.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.cB().c(new DiskFileOperate(imageFileInfo.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
            }
            linkedList3 = this.gcE.chosedFiles;
            int size = linkedList3.size();
            lVar = this.gcE.atR;
            if (lVar != null) {
                lVar2 = this.gcE.atR;
                i2 = this.gcE.avv;
                lVar2.b(new com.baidu.tbadk.editortools.a(i2, -1, null));
                if (size > 0) {
                    lVar5 = this.gcE.atR;
                    lVar5.b(new com.baidu.tbadk.editortools.a(2, 10, String.valueOf(size)));
                } else {
                    lVar3 = this.gcE.atR;
                    lVar3.b(new com.baidu.tbadk.editortools.a(2, 10, null));
                }
                linkedList5 = this.gcE.chosedFiles;
                if (linkedList5.size() == 1 && size == 0) {
                    lVar4 = this.gcE.atR;
                    lVar4.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                }
            }
            this.gcE.bsw();
            baseActivity = this.gcE.bDA;
            linkedList4 = this.gcE.chosedFiles;
            ((WriteActivity) baseActivity).o(linkedList4);
            this.gcE.bst();
            this.gcE.notifyDataSetChanged();
            gridView = this.gcE.dMG;
            gridView.invalidateViews();
        }
    }
}
