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
public class b implements a.InterfaceC0078a {
    final /* synthetic */ a fNJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fNJ = aVar;
    }

    @Override // com.baidu.tieba.write.view.PhotoLiveView.a.InterfaceC0078a
    public void sX(int i) {
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
        linkedList = this.fNJ.chosedFiles;
        if (linkedList != null) {
            linkedList2 = this.fNJ.chosedFiles;
            if (linkedList2.size() - 1 >= i) {
                linkedList6 = this.fNJ.chosedFiles;
                ImageFileInfo imageFileInfo = (ImageFileInfo) linkedList6.remove(i);
                if (imageFileInfo.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.dI().c(new DiskFileOperate(imageFileInfo.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
            }
            linkedList3 = this.fNJ.chosedFiles;
            int size = linkedList3.size();
            jVar = this.fNJ.ayu;
            if (jVar != null) {
                jVar2 = this.fNJ.ayu;
                i2 = this.fNJ.azP;
                jVar2.b(new com.baidu.tbadk.editortools.a(i2, -1, null));
                if (size > 0) {
                    jVar5 = this.fNJ.ayu;
                    jVar5.b(new com.baidu.tbadk.editortools.a(2, 10, String.valueOf(size)));
                } else {
                    jVar3 = this.fNJ.ayu;
                    jVar3.b(new com.baidu.tbadk.editortools.a(2, 10, null));
                }
                linkedList5 = this.fNJ.chosedFiles;
                if (linkedList5.size() == 1 && size == 0) {
                    jVar4 = this.fNJ.ayu;
                    jVar4.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                }
            }
            this.fNJ.bnG();
            baseActivity = this.fNJ.mBaseActivity;
            linkedList4 = this.fNJ.chosedFiles;
            ((WriteActivity) baseActivity).o(linkedList4);
            this.fNJ.bnD();
            this.fNJ.notifyDataSetChanged();
            gridView = this.fNJ.dKz;
            gridView.invalidateViews();
        }
    }
}
