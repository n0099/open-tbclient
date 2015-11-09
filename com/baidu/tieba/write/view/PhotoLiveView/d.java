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
    private final /* synthetic */ ViewGroup aqc;
    final /* synthetic */ a doV;
    private final /* synthetic */ boolean doX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, ViewGroup viewGroup, boolean z) {
        this.doV = aVar;
        this.aqc = viewGroup;
        this.doX = z;
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
        int indexOfChild = this.aqc.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (this.doX) {
                baseActivity2 = this.doV.doS;
                if (baseActivity2 instanceof WriteActivity) {
                    linkedList2 = this.doV.chosedFiles;
                    if (linkedList2 != null) {
                        linkedList4 = this.doV.chosedFiles;
                        if (linkedList4.size() > 0) {
                            linkedList5 = this.doV.chosedFiles;
                            linkedList6 = this.doV.chosedFiles;
                            linkedList5.remove(linkedList6.size() - 1);
                        }
                    }
                    baseActivity3 = this.doV.doS;
                    linkedList3 = this.doV.chosedFiles;
                    ((WriteActivity) baseActivity3).n(linkedList3);
                    baseActivity4 = this.doV.doS;
                    ((WriteActivity) baseActivity4).d((com.baidu.tbadk.editortools.a) null);
                    return;
                }
            }
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.doV.getItem(indexOfChild);
            if (imageFileInfo == null) {
                z = false;
            } else {
                File file = new File(imageFileInfo.getFilePath());
                z = file.exists() && file.length() != 0;
            }
            if (!z) {
                context = this.doV.mContext;
                k.c(context, i.h.editor_mutiiamge_image_error);
                return;
            }
            jVar = this.doV.aoD;
            if (jVar != null) {
                if (this.doV.aDi()) {
                    this.doV.aDj();
                }
                baseActivity = this.doV.doS;
                linkedList = this.doV.chosedFiles;
                ((WriteActivity) baseActivity).n(linkedList);
                jVar2 = this.doV.aoD;
                jVar2.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
            }
        }
    }
}
