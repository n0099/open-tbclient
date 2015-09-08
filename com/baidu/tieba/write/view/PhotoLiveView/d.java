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
    private final /* synthetic */ ViewGroup asZ;
    final /* synthetic */ a dbM;
    private final /* synthetic */ boolean dbO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, ViewGroup viewGroup, boolean z) {
        this.dbM = aVar;
        this.asZ = viewGroup;
        this.dbO = z;
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
        int indexOfChild = this.asZ.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (this.dbO) {
                baseActivity2 = this.dbM.dbJ;
                if (baseActivity2 instanceof WriteActivity) {
                    linkedList2 = this.dbM.chosedFiles;
                    if (linkedList2 != null) {
                        linkedList4 = this.dbM.chosedFiles;
                        if (linkedList4.size() > 0) {
                            linkedList5 = this.dbM.chosedFiles;
                            linkedList6 = this.dbM.chosedFiles;
                            linkedList5.remove(linkedList6.size() - 1);
                        }
                    }
                    baseActivity3 = this.dbM.dbJ;
                    linkedList3 = this.dbM.chosedFiles;
                    ((WriteActivity) baseActivity3).n(linkedList3);
                    baseActivity4 = this.dbM.dbJ;
                    ((WriteActivity) baseActivity4).d((com.baidu.tbadk.editortools.a) null);
                    return;
                }
            }
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.dbM.getItem(indexOfChild);
            if (imageFileInfo == null) {
                z = false;
            } else {
                File file = new File(imageFileInfo.getFilePath());
                z = file.exists() && file.length() != 0;
            }
            if (!z) {
                context = this.dbM.mContext;
                k.c(context, i.h.editor_mutiiamge_image_error);
                return;
            }
            jVar = this.dbM.apW;
            if (jVar != null) {
                if (this.dbM.azd()) {
                    this.dbM.aze();
                }
                baseActivity = this.dbM.dbJ;
                linkedList = this.dbM.chosedFiles;
                ((WriteActivity) baseActivity).n(linkedList);
                jVar2 = this.dbM.apW;
                jVar2.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
            }
        }
    }
}
