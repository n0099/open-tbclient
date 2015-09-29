package com.baidu.tieba.write.view.PhotoLiveView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
import com.baidu.tieba.write.write.WriteActivity;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    private final /* synthetic */ ViewGroup arw;
    final /* synthetic */ a dmN;
    private final /* synthetic */ boolean dmP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, ViewGroup viewGroup, boolean z) {
        this.dmN = aVar;
        this.arw = viewGroup;
        this.dmP = z;
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
        int indexOfChild = this.arw.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (this.dmP) {
                baseActivity2 = this.dmN.dmK;
                if (baseActivity2 instanceof WriteActivity) {
                    linkedList2 = this.dmN.chosedFiles;
                    if (linkedList2 != null) {
                        linkedList4 = this.dmN.chosedFiles;
                        if (linkedList4.size() > 0) {
                            linkedList5 = this.dmN.chosedFiles;
                            linkedList6 = this.dmN.chosedFiles;
                            linkedList5.remove(linkedList6.size() - 1);
                        }
                    }
                    baseActivity3 = this.dmN.dmK;
                    linkedList3 = this.dmN.chosedFiles;
                    ((WriteActivity) baseActivity3).n(linkedList3);
                    baseActivity4 = this.dmN.dmK;
                    ((WriteActivity) baseActivity4).d((com.baidu.tbadk.editortools.a) null);
                    return;
                }
            }
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.dmN.getItem(indexOfChild);
            if (imageFileInfo == null) {
                z = false;
            } else {
                File file = new File(imageFileInfo.getFilePath());
                z = file.exists() && file.length() != 0;
            }
            if (!z) {
                context = this.dmN.mContext;
                k.c(context, i.h.editor_mutiiamge_image_error);
                return;
            }
            jVar = this.dmN.aow;
            if (jVar != null) {
                if (this.dmN.aCm()) {
                    this.dmN.aCn();
                }
                baseActivity = this.dmN.dmK;
                linkedList = this.dmN.chosedFiles;
                ((WriteActivity) baseActivity).n(linkedList);
                jVar2 = this.dmN.aow;
                jVar2.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
            }
        }
    }
}
