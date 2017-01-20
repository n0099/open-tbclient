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
public class b implements a.InterfaceC0079a {
    final /* synthetic */ a fJq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fJq = aVar;
    }

    @Override // com.baidu.tieba.write.view.PhotoLiveView.a.InterfaceC0079a
    public void sY(int i) {
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
        linkedList = this.fJq.chosedFiles;
        if (linkedList != null) {
            linkedList2 = this.fJq.chosedFiles;
            if (linkedList2.size() - 1 >= i) {
                linkedList6 = this.fJq.chosedFiles;
                ImageFileInfo imageFileInfo = (ImageFileInfo) linkedList6.remove(i);
                if (imageFileInfo.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.cz().c(new DiskFileOperate(imageFileInfo.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
            }
            linkedList3 = this.fJq.chosedFiles;
            int size = linkedList3.size();
            jVar = this.fJq.asZ;
            if (jVar != null) {
                jVar2 = this.fJq.asZ;
                i2 = this.fJq.auu;
                jVar2.b(new com.baidu.tbadk.editortools.a(i2, -1, null));
                if (size > 0) {
                    jVar5 = this.fJq.asZ;
                    jVar5.b(new com.baidu.tbadk.editortools.a(2, 10, String.valueOf(size)));
                } else {
                    jVar3 = this.fJq.asZ;
                    jVar3.b(new com.baidu.tbadk.editortools.a(2, 10, null));
                }
                linkedList5 = this.fJq.chosedFiles;
                if (linkedList5.size() == 1 && size == 0) {
                    jVar4 = this.fJq.asZ;
                    jVar4.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                }
            }
            this.fJq.bnT();
            baseActivity = this.fJq.mBaseActivity;
            linkedList4 = this.fJq.chosedFiles;
            ((WriteActivity) baseActivity).o(linkedList4);
            this.fJq.bnQ();
            this.fJq.notifyDataSetChanged();
            gridView = this.fJq.dHR;
            gridView.invalidateViews();
        }
    }
}
