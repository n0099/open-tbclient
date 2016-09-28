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
public class b implements a.InterfaceC0085a {
    final /* synthetic */ a geO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.geO = aVar;
    }

    @Override // com.baidu.tieba.write.view.PhotoLiveView.a.InterfaceC0085a
    public void ts(int i) {
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
        linkedList = this.geO.chosedFiles;
        if (linkedList != null) {
            linkedList2 = this.geO.chosedFiles;
            if (linkedList2.size() - 1 >= i) {
                linkedList6 = this.geO.chosedFiles;
                ImageFileInfo imageFileInfo = (ImageFileInfo) linkedList6.remove(i);
                if (imageFileInfo.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.cB().c(new DiskFileOperate(imageFileInfo.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
            }
            linkedList3 = this.geO.chosedFiles;
            int size = linkedList3.size();
            lVar = this.geO.atv;
            if (lVar != null) {
                lVar2 = this.geO.atv;
                i2 = this.geO.auY;
                lVar2.b(new com.baidu.tbadk.editortools.a(i2, -1, null));
                if (size > 0) {
                    lVar5 = this.geO.atv;
                    lVar5.b(new com.baidu.tbadk.editortools.a(2, 10, String.valueOf(size)));
                } else {
                    lVar3 = this.geO.atv;
                    lVar3.b(new com.baidu.tbadk.editortools.a(2, 10, null));
                }
                linkedList5 = this.geO.chosedFiles;
                if (linkedList5.size() == 1 && size == 0) {
                    lVar4 = this.geO.atv;
                    lVar4.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                }
            }
            this.geO.btc();
            baseActivity = this.geO.bDL;
            linkedList4 = this.geO.chosedFiles;
            ((WriteActivity) baseActivity).o(linkedList4);
            this.geO.bsZ();
            this.geO.notifyDataSetChanged();
            gridView = this.geO.dOC;
            gridView.invalidateViews();
        }
    }
}
