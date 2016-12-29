package com.baidu.tieba.write.view.PhotoLiveView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.r;
import com.baidu.tieba.write.write.WriteActivity;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    private final /* synthetic */ ViewGroup avA;
    final /* synthetic */ a fAV;
    private final /* synthetic */ boolean fAW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, ViewGroup viewGroup, boolean z) {
        this.fAV = aVar;
        this.avA = viewGroup;
        this.fAW = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        j jVar;
        BaseActivity baseActivity;
        LinkedList<ImageFileInfo> linkedList;
        j jVar2;
        Context context;
        BaseActivity baseActivity2;
        LinkedList linkedList2;
        BaseActivity baseActivity3;
        LinkedList<ImageFileInfo> linkedList3;
        BaseActivity baseActivity4;
        LinkedList linkedList4;
        LinkedList linkedList5;
        LinkedList linkedList6;
        int indexOfChild = this.avA.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (this.fAW) {
                baseActivity2 = this.fAV.bFA;
                if (baseActivity2 instanceof WriteActivity) {
                    linkedList2 = this.fAV.chosedFiles;
                    if (linkedList2 != null) {
                        linkedList4 = this.fAV.chosedFiles;
                        if (linkedList4.size() > 0) {
                            linkedList5 = this.fAV.chosedFiles;
                            linkedList6 = this.fAV.chosedFiles;
                            linkedList5.remove(linkedList6.size() - 1);
                        }
                    }
                    baseActivity3 = this.fAV.bFA;
                    linkedList3 = this.fAV.chosedFiles;
                    ((WriteActivity) baseActivity3).o(linkedList3);
                    baseActivity4 = this.fAV.bFA;
                    ((WriteActivity) baseActivity4).d((com.baidu.tbadk.editortools.a) null);
                    return;
                }
            }
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.fAV.getItem(indexOfChild);
            if (imageFileInfo == null) {
                z = false;
            } else {
                File file = new File(imageFileInfo.getFilePath());
                z = file.exists() && file.length() != 0;
            }
            if (!z) {
                context = this.fAV.mContext;
                k.d(context, r.j.editor_mutiiamge_image_error);
                return;
            }
            jVar = this.fAV.atU;
            if (jVar != null) {
                if (this.fAV.bmu()) {
                    this.fAV.bmv();
                }
                baseActivity = this.fAV.bFA;
                linkedList = this.fAV.chosedFiles;
                ((WriteActivity) baseActivity).o(linkedList);
                jVar2 = this.fAV.atU;
                jVar2.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
            }
        }
    }
}
