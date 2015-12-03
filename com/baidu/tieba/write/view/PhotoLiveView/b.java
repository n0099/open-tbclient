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
public class b implements a.InterfaceC0090a {
    final /* synthetic */ a dOa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dOa = aVar;
    }

    @Override // com.baidu.tieba.write.view.PhotoLiveView.a.InterfaceC0090a
    public void ny(int i) {
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
        linkedList = this.dOa.chosedFiles;
        if (linkedList != null) {
            linkedList2 = this.dOa.chosedFiles;
            if (linkedList2.size() - 1 >= i) {
                linkedList6 = this.dOa.chosedFiles;
                ImageFileInfo imageFileInfo = (ImageFileInfo) linkedList6.remove(i);
                if (imageFileInfo.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.fj().c(new DiskFileOperate(imageFileInfo.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
            }
            linkedList3 = this.dOa.chosedFiles;
            int size = linkedList3.size();
            kVar = this.dOa.aqt;
            if (kVar != null) {
                kVar2 = this.dOa.aqt;
                i2 = this.dOa.arO;
                kVar2.b(new com.baidu.tbadk.editortools.a(i2, -1, null));
                if (size > 0) {
                    kVar5 = this.dOa.aqt;
                    kVar5.b(new com.baidu.tbadk.editortools.a(2, 10, String.valueOf(size)));
                } else {
                    kVar3 = this.dOa.aqt;
                    kVar3.b(new com.baidu.tbadk.editortools.a(2, 10, null));
                }
                linkedList5 = this.dOa.chosedFiles;
                if (linkedList5.size() == 1 && size == 0) {
                    kVar4 = this.dOa.aqt;
                    kVar4.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                }
            }
            this.dOa.aIG();
            baseActivity = this.dOa.cTF;
            linkedList4 = this.dOa.chosedFiles;
            ((WriteActivity) baseActivity).o(linkedList4);
            this.dOa.aID();
            this.dOa.notifyDataSetChanged();
            gridView = this.dOa.mGridView;
            gridView.invalidateViews();
        }
    }
}
