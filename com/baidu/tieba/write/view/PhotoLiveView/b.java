package com.baidu.tieba.write.view.PhotoLiveView;

import android.widget.GridView;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.PhotoLiveView.a;
import com.baidu.tieba.write.write.WriteActivity;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.InterfaceC0081a {
    final /* synthetic */ a doV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.doV = aVar;
    }

    @Override // com.baidu.tieba.write.view.PhotoLiveView.a.InterfaceC0081a
    public void mm(int i) {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList linkedList3;
        j jVar;
        BaseActivity baseActivity;
        LinkedList<ImageFileInfo> linkedList4;
        GridView gridView;
        j jVar2;
        int i2;
        j jVar3;
        LinkedList linkedList5;
        j jVar4;
        j jVar5;
        LinkedList linkedList6;
        linkedList = this.doV.chosedFiles;
        if (linkedList != null) {
            linkedList2 = this.doV.chosedFiles;
            if (linkedList2.size() - 1 >= i) {
                linkedList6 = this.doV.chosedFiles;
                ImageFileInfo imageFileInfo = (ImageFileInfo) linkedList6.remove(i);
                if (imageFileInfo.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.fj().c(new DiskFileOperate(imageFileInfo.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
            }
            linkedList3 = this.doV.chosedFiles;
            int size = linkedList3.size();
            jVar = this.doV.aoD;
            if (jVar != null) {
                jVar2 = this.doV.aoD;
                i2 = this.doV.apR;
                jVar2.b(new com.baidu.tbadk.editortools.a(i2, -1, null));
                if (size > 0) {
                    jVar5 = this.doV.aoD;
                    jVar5.b(new com.baidu.tbadk.editortools.a(2, 10, String.valueOf(size)));
                } else {
                    jVar3 = this.doV.aoD;
                    jVar3.b(new com.baidu.tbadk.editortools.a(2, 10, null));
                }
                linkedList5 = this.doV.chosedFiles;
                if (linkedList5.size() == 1 && size == 0) {
                    jVar4 = this.doV.aoD;
                    jVar4.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                }
            }
            this.doV.aDj();
            baseActivity = this.doV.doS;
            linkedList4 = this.doV.chosedFiles;
            ((WriteActivity) baseActivity).n(linkedList4);
            this.doV.aDg();
            this.doV.notifyDataSetChanged();
            gridView = this.doV.mGridView;
            gridView.invalidateViews();
        }
    }
}
