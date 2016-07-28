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
    private final /* synthetic */ ViewGroup asz;
    private final /* synthetic */ boolean fSA;
    final /* synthetic */ a fSz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, ViewGroup viewGroup, boolean z) {
        this.fSz = aVar;
        this.asz = viewGroup;
        this.fSA = z;
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
        int indexOfChild = this.asz.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (this.fSA) {
                baseActivity2 = this.fSz.bsn;
                if (baseActivity2 instanceof WriteActivity) {
                    linkedList2 = this.fSz.chosedFiles;
                    if (linkedList2 != null) {
                        linkedList4 = this.fSz.chosedFiles;
                        if (linkedList4.size() > 0) {
                            linkedList5 = this.fSz.chosedFiles;
                            linkedList6 = this.fSz.chosedFiles;
                            linkedList5.remove(linkedList6.size() - 1);
                        }
                    }
                    baseActivity3 = this.fSz.bsn;
                    linkedList3 = this.fSz.chosedFiles;
                    ((WriteActivity) baseActivity3).o(linkedList3);
                    baseActivity4 = this.fSz.bsn;
                    ((WriteActivity) baseActivity4).d((com.baidu.tbadk.editortools.a) null);
                    return;
                }
            }
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.fSz.getItem(indexOfChild);
            if (imageFileInfo == null) {
                z = false;
            } else {
                File file = new File(imageFileInfo.getFilePath());
                z = file.exists() && file.length() != 0;
            }
            if (!z) {
                context = this.fSz.mContext;
                k.b(context, u.j.editor_mutiiamge_image_error);
                return;
            }
            lVar = this.fSz.aqK;
            if (lVar != null) {
                if (this.fSz.bog()) {
                    this.fSz.boh();
                }
                baseActivity = this.fSz.bsn;
                linkedList = this.fSz.chosedFiles;
                ((WriteActivity) baseActivity).o(linkedList);
                lVar2 = this.fSz.aqK;
                lVar2.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
            }
        }
    }
}
