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
public class b implements a.InterfaceC0089a {
    final /* synthetic */ a giP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.giP = aVar;
    }

    @Override // com.baidu.tieba.write.view.PhotoLiveView.a.InterfaceC0089a
    public void tP(int i) {
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
        linkedList = this.giP.chosedFiles;
        if (linkedList != null) {
            linkedList2 = this.giP.chosedFiles;
            if (linkedList2.size() - 1 >= i) {
                linkedList6 = this.giP.chosedFiles;
                ImageFileInfo imageFileInfo = (ImageFileInfo) linkedList6.remove(i);
                if (imageFileInfo.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.dI().c(new DiskFileOperate(imageFileInfo.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
            }
            linkedList3 = this.giP.chosedFiles;
            int size = linkedList3.size();
            jVar = this.giP.azx;
            if (jVar != null) {
                jVar2 = this.giP.azx;
                i2 = this.giP.aAU;
                jVar2.b(new com.baidu.tbadk.editortools.a(i2, -1, null));
                if (size > 0) {
                    jVar5 = this.giP.azx;
                    jVar5.b(new com.baidu.tbadk.editortools.a(2, 10, String.valueOf(size)));
                } else {
                    jVar3 = this.giP.azx;
                    jVar3.b(new com.baidu.tbadk.editortools.a(2, 10, null));
                }
                linkedList5 = this.giP.chosedFiles;
                if (linkedList5.size() == 1 && size == 0) {
                    jVar4 = this.giP.azx;
                    jVar4.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                }
            }
            this.giP.btq();
            baseActivity = this.giP.mBaseActivity;
            linkedList4 = this.giP.chosedFiles;
            ((WriteActivity) baseActivity).s(linkedList4);
            this.giP.btn();
            this.giP.notifyDataSetChanged();
            gridView = this.giP.bYc;
            gridView.invalidateViews();
        }
    }
}
