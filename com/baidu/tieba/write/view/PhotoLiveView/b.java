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
public class b implements a.InterfaceC0084a {
    final /* synthetic */ a fPT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fPT = aVar;
    }

    @Override // com.baidu.tieba.write.view.PhotoLiveView.a.InterfaceC0084a
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
        linkedList = this.fPT.chosedFiles;
        if (linkedList != null) {
            linkedList2 = this.fPT.chosedFiles;
            if (linkedList2.size() - 1 >= i) {
                linkedList6 = this.fPT.chosedFiles;
                ImageFileInfo imageFileInfo = (ImageFileInfo) linkedList6.remove(i);
                if (imageFileInfo.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.dI().c(new DiskFileOperate(imageFileInfo.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
            }
            linkedList3 = this.fPT.chosedFiles;
            int size = linkedList3.size();
            jVar = this.fPT.ayJ;
            if (jVar != null) {
                jVar2 = this.fPT.ayJ;
                i2 = this.fPT.aAf;
                jVar2.b(new com.baidu.tbadk.editortools.a(i2, -1, null));
                if (size > 0) {
                    jVar5 = this.fPT.ayJ;
                    jVar5.b(new com.baidu.tbadk.editortools.a(2, 10, String.valueOf(size)));
                } else {
                    jVar3 = this.fPT.ayJ;
                    jVar3.b(new com.baidu.tbadk.editortools.a(2, 10, null));
                }
                linkedList5 = this.fPT.chosedFiles;
                if (linkedList5.size() == 1 && size == 0) {
                    jVar4 = this.fPT.ayJ;
                    jVar4.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                }
            }
            this.fPT.bnt();
            baseActivity = this.fPT.mBaseActivity;
            linkedList4 = this.fPT.chosedFiles;
            ((WriteActivity) baseActivity).o(linkedList4);
            this.fPT.bnq();
            this.fPT.notifyDataSetChanged();
            gridView = this.fPT.dDL;
            gridView.invalidateViews();
        }
    }
}
