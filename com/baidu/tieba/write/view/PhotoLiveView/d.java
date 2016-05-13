package com.baidu.tieba.write.view.PhotoLiveView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
import com.baidu.tieba.write.write.WriteActivity;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    private final /* synthetic */ ViewGroup aqU;
    final /* synthetic */ a fbd;
    private final /* synthetic */ boolean fbe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, ViewGroup viewGroup, boolean z) {
        this.fbd = aVar;
        this.aqU = viewGroup;
        this.fbe = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        l lVar;
        BaseActivity baseActivity;
        LinkedList<ImageFileInfo> linkedList;
        l lVar2;
        Context context;
        BaseActivity baseActivity2;
        LinkedList linkedList2;
        BaseActivity baseActivity3;
        LinkedList<ImageFileInfo> linkedList3;
        BaseActivity baseActivity4;
        LinkedList linkedList4;
        LinkedList linkedList5;
        LinkedList linkedList6;
        int indexOfChild = this.aqU.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (this.fbe) {
                baseActivity2 = this.fbd.boS;
                if (baseActivity2 instanceof WriteActivity) {
                    linkedList2 = this.fbd.chosedFiles;
                    if (linkedList2 != null) {
                        linkedList4 = this.fbd.chosedFiles;
                        if (linkedList4.size() > 0) {
                            linkedList5 = this.fbd.chosedFiles;
                            linkedList6 = this.fbd.chosedFiles;
                            linkedList5.remove(linkedList6.size() - 1);
                        }
                    }
                    baseActivity3 = this.fbd.boS;
                    linkedList3 = this.fbd.chosedFiles;
                    ((WriteActivity) baseActivity3).o(linkedList3);
                    baseActivity4 = this.fbd.boS;
                    ((WriteActivity) baseActivity4).d((com.baidu.tbadk.editortools.a) null);
                    return;
                }
            }
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.fbd.getItem(indexOfChild);
            if (imageFileInfo == null) {
                z = false;
            } else {
                File file = new File(imageFileInfo.getFilePath());
                z = file.exists() && file.length() != 0;
            }
            if (!z) {
                context = this.fbd.mContext;
                k.b(context, t.j.editor_mutiiamge_image_error);
                return;
            }
            lVar = this.fbd.apf;
            if (lVar != null) {
                if (this.fbd.bcP()) {
                    this.fbd.bcQ();
                }
                baseActivity = this.fbd.boS;
                linkedList = this.fbd.chosedFiles;
                ((WriteActivity) baseActivity).o(linkedList);
                lVar2 = this.fbd.apf;
                lVar2.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
            }
        }
    }
}
