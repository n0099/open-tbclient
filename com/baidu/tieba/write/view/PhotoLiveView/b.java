package com.baidu.tieba.write.view.PhotoLiveView;

import android.widget.GridView;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.PhotoLiveView.a;
import com.baidu.tieba.write.write.WriteActivity;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.InterfaceC0086a {
    final /* synthetic */ a dVz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dVz = aVar;
    }

    @Override // com.baidu.tieba.write.view.PhotoLiveView.a.InterfaceC0086a
    public void oq(int i) {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList linkedList3;
        k kVar;
        BaseActivity baseActivity;
        LinkedList<ImageFileInfo> linkedList4;
        GridView gridView;
        k kVar2;
        int i2;
        k kVar3;
        LinkedList linkedList5;
        k kVar4;
        k kVar5;
        LinkedList linkedList6;
        linkedList = this.dVz.chosedFiles;
        if (linkedList != null) {
            linkedList2 = this.dVz.chosedFiles;
            if (linkedList2.size() - 1 >= i) {
                linkedList6 = this.dVz.chosedFiles;
                ImageFileInfo imageFileInfo = (ImageFileInfo) linkedList6.remove(i);
                if (imageFileInfo.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.fj().c(new DiskFileOperate(imageFileInfo.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
            }
            linkedList3 = this.dVz.chosedFiles;
            int size = linkedList3.size();
            kVar = this.dVz.arX;
            if (kVar != null) {
                kVar2 = this.dVz.arX;
                i2 = this.dVz.ats;
                kVar2.b(new com.baidu.tbadk.editortools.a(i2, -1, null));
                if (size > 0) {
                    kVar5 = this.dVz.arX;
                    kVar5.b(new com.baidu.tbadk.editortools.a(2, 10, String.valueOf(size)));
                } else {
                    kVar3 = this.dVz.arX;
                    kVar3.b(new com.baidu.tbadk.editortools.a(2, 10, null));
                }
                linkedList5 = this.dVz.chosedFiles;
                if (linkedList5.size() == 1 && size == 0) {
                    kVar4 = this.dVz.arX;
                    kVar4.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                }
            }
            this.dVz.aLb();
            baseActivity = this.dVz.cYr;
            linkedList4 = this.dVz.chosedFiles;
            ((WriteActivity) baseActivity).o(linkedList4);
            this.dVz.aKY();
            this.dVz.notifyDataSetChanged();
            gridView = this.dVz.mGridView;
            gridView.invalidateViews();
        }
    }
}
