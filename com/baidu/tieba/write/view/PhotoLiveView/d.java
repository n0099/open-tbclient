package com.baidu.tieba.write.view.PhotoLiveView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.n;
import com.baidu.tieba.write.write.WriteActivity;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    private final /* synthetic */ ViewGroup atD;
    private final /* synthetic */ boolean dVA;
    final /* synthetic */ a dVz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, ViewGroup viewGroup, boolean z) {
        this.dVz = aVar;
        this.atD = viewGroup;
        this.dVA = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        k kVar;
        BaseActivity baseActivity;
        LinkedList<ImageFileInfo> linkedList;
        k kVar2;
        Context context;
        BaseActivity baseActivity2;
        LinkedList linkedList2;
        BaseActivity baseActivity3;
        LinkedList<ImageFileInfo> linkedList3;
        BaseActivity baseActivity4;
        LinkedList linkedList4;
        LinkedList linkedList5;
        LinkedList linkedList6;
        int indexOfChild = this.atD.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (this.dVA) {
                baseActivity2 = this.dVz.cYr;
                if (baseActivity2 instanceof WriteActivity) {
                    linkedList2 = this.dVz.chosedFiles;
                    if (linkedList2 != null) {
                        linkedList4 = this.dVz.chosedFiles;
                        if (linkedList4.size() > 0) {
                            linkedList5 = this.dVz.chosedFiles;
                            linkedList6 = this.dVz.chosedFiles;
                            linkedList5.remove(linkedList6.size() - 1);
                        }
                    }
                    baseActivity3 = this.dVz.cYr;
                    linkedList3 = this.dVz.chosedFiles;
                    ((WriteActivity) baseActivity3).o(linkedList3);
                    baseActivity4 = this.dVz.cYr;
                    ((WriteActivity) baseActivity4).d((com.baidu.tbadk.editortools.a) null);
                    return;
                }
            }
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.dVz.getItem(indexOfChild);
            if (imageFileInfo == null) {
                z = false;
            } else {
                File file = new File(imageFileInfo.getFilePath());
                z = file.exists() && file.length() != 0;
            }
            if (!z) {
                context = this.dVz.mContext;
                com.baidu.adp.lib.util.k.c(context, n.j.editor_mutiiamge_image_error);
                return;
            }
            kVar = this.dVz.arX;
            if (kVar != null) {
                if (this.dVz.aLa()) {
                    this.dVz.aLb();
                }
                baseActivity = this.dVz.cYr;
                linkedList = this.dVz.chosedFiles;
                ((WriteActivity) baseActivity).o(linkedList);
                kVar2 = this.dVz.arX;
                kVar2.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
            }
        }
    }
}
