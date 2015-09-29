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
    final /* synthetic */ a dmN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dmN = aVar;
    }

    @Override // com.baidu.tieba.write.view.PhotoLiveView.a.InterfaceC0081a
    public void lW(int i) {
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
        linkedList = this.dmN.chosedFiles;
        if (linkedList != null) {
            linkedList2 = this.dmN.chosedFiles;
            if (linkedList2.size() - 1 >= i) {
                linkedList6 = this.dmN.chosedFiles;
                ImageFileInfo imageFileInfo = (ImageFileInfo) linkedList6.remove(i);
                if (imageFileInfo.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.fj().c(new DiskFileOperate(imageFileInfo.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
            }
            linkedList3 = this.dmN.chosedFiles;
            int size = linkedList3.size();
            jVar = this.dmN.aow;
            if (jVar != null) {
                jVar2 = this.dmN.aow;
                i2 = this.dmN.arn;
                jVar2.b(new com.baidu.tbadk.editortools.a(i2, -1, null));
                if (size > 0) {
                    jVar5 = this.dmN.aow;
                    jVar5.b(new com.baidu.tbadk.editortools.a(2, 10, String.valueOf(size)));
                } else {
                    jVar3 = this.dmN.aow;
                    jVar3.b(new com.baidu.tbadk.editortools.a(2, 10, null));
                }
                linkedList5 = this.dmN.chosedFiles;
                if (linkedList5.size() == 1 && size == 0) {
                    jVar4 = this.dmN.aow;
                    jVar4.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                }
            }
            this.dmN.aCn();
            baseActivity = this.dmN.dmK;
            linkedList4 = this.dmN.chosedFiles;
            ((WriteActivity) baseActivity).n(linkedList4);
            this.dmN.aCk();
            this.dmN.notifyDataSetChanged();
            gridView = this.dmN.mGridView;
            gridView.invalidateViews();
        }
    }
}
