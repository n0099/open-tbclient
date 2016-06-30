package com.baidu.tieba.write.view.PhotoLiveView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.u;
import com.baidu.tieba.write.write.WriteActivity;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    private final /* synthetic */ ViewGroup arK;
    final /* synthetic */ a fGI;
    private final /* synthetic */ boolean fGJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, ViewGroup viewGroup, boolean z) {
        this.fGI = aVar;
        this.arK = viewGroup;
        this.fGJ = z;
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
        int indexOfChild = this.arK.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (this.fGJ) {
                baseActivity2 = this.fGI.bJz;
                if (baseActivity2 instanceof WriteActivity) {
                    linkedList2 = this.fGI.chosedFiles;
                    if (linkedList2 != null) {
                        linkedList4 = this.fGI.chosedFiles;
                        if (linkedList4.size() > 0) {
                            linkedList5 = this.fGI.chosedFiles;
                            linkedList6 = this.fGI.chosedFiles;
                            linkedList5.remove(linkedList6.size() - 1);
                        }
                    }
                    baseActivity3 = this.fGI.bJz;
                    linkedList3 = this.fGI.chosedFiles;
                    ((WriteActivity) baseActivity3).o(linkedList3);
                    baseActivity4 = this.fGI.bJz;
                    ((WriteActivity) baseActivity4).d((com.baidu.tbadk.editortools.a) null);
                    return;
                }
            }
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.fGI.getItem(indexOfChild);
            if (imageFileInfo == null) {
                z = false;
            } else {
                File file = new File(imageFileInfo.getFilePath());
                z = file.exists() && file.length() != 0;
            }
            if (!z) {
                context = this.fGI.mContext;
                k.b(context, u.j.editor_mutiiamge_image_error);
                return;
            }
            lVar = this.fGI.apV;
            if (lVar != null) {
                if (this.fGI.bll()) {
                    this.fGI.blm();
                }
                baseActivity = this.fGI.bJz;
                linkedList = this.fGI.chosedFiles;
                ((WriteActivity) baseActivity).o(linkedList);
                lVar2 = this.fGI.apV;
                lVar2.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
            }
        }
    }
}
