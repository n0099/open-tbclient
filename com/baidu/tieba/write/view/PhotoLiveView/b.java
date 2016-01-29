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
public class b implements a.InterfaceC0091a {
    final /* synthetic */ a eqs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.eqs = aVar;
    }

    @Override // com.baidu.tieba.write.view.PhotoLiveView.a.InterfaceC0091a
    public void pL(int i) {
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
        linkedList = this.eqs.chosedFiles;
        if (linkedList != null) {
            linkedList2 = this.eqs.chosedFiles;
            if (linkedList2.size() - 1 >= i) {
                linkedList6 = this.eqs.chosedFiles;
                ImageFileInfo imageFileInfo = (ImageFileInfo) linkedList6.remove(i);
                if (imageFileInfo.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.fr().c(new DiskFileOperate(imageFileInfo.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
            }
            linkedList3 = this.eqs.chosedFiles;
            int size = linkedList3.size();
            kVar = this.eqs.asQ;
            if (kVar != null) {
                kVar2 = this.eqs.asQ;
                i2 = this.eqs.auk;
                kVar2.b(new com.baidu.tbadk.editortools.a(i2, -1, null));
                if (size > 0) {
                    kVar5 = this.eqs.asQ;
                    kVar5.b(new com.baidu.tbadk.editortools.a(2, 10, String.valueOf(size)));
                } else {
                    kVar3 = this.eqs.asQ;
                    kVar3.b(new com.baidu.tbadk.editortools.a(2, 10, null));
                }
                linkedList5 = this.eqs.chosedFiles;
                if (linkedList5.size() == 1 && size == 0) {
                    kVar4 = this.eqs.asQ;
                    kVar4.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                }
            }
            this.eqs.aTW();
            baseActivity = this.eqs.dke;
            linkedList4 = this.eqs.chosedFiles;
            ((WriteActivity) baseActivity).p(linkedList4);
            this.eqs.aTT();
            this.eqs.notifyDataSetChanged();
            gridView = this.eqs.cxr;
            gridView.invalidateViews();
        }
    }
}
