package com.baidu.tieba.write.view.PhotoLiveView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
import com.baidu.tieba.write.write.WriteActivity;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    private final /* synthetic */ ViewGroup auv;
    final /* synthetic */ a eqs;
    private final /* synthetic */ boolean eqt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, ViewGroup viewGroup, boolean z) {
        this.eqs = aVar;
        this.auv = viewGroup;
        this.eqt = z;
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
        int indexOfChild = this.auv.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (this.eqt) {
                baseActivity2 = this.eqs.dke;
                if (baseActivity2 instanceof WriteActivity) {
                    linkedList2 = this.eqs.chosedFiles;
                    if (linkedList2 != null) {
                        linkedList4 = this.eqs.chosedFiles;
                        if (linkedList4.size() > 0) {
                            linkedList5 = this.eqs.chosedFiles;
                            linkedList6 = this.eqs.chosedFiles;
                            linkedList5.remove(linkedList6.size() - 1);
                        }
                    }
                    baseActivity3 = this.eqs.dke;
                    linkedList3 = this.eqs.chosedFiles;
                    ((WriteActivity) baseActivity3).p(linkedList3);
                    baseActivity4 = this.eqs.dke;
                    ((WriteActivity) baseActivity4).d((com.baidu.tbadk.editortools.a) null);
                    return;
                }
            }
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.eqs.getItem(indexOfChild);
            if (imageFileInfo == null) {
                z = false;
            } else {
                File file = new File(imageFileInfo.getFilePath());
                z = file.exists() && file.length() != 0;
            }
            if (!z) {
                context = this.eqs.mContext;
                com.baidu.adp.lib.util.k.b(context, t.j.editor_mutiiamge_image_error);
                return;
            }
            kVar = this.eqs.asQ;
            if (kVar != null) {
                if (this.eqs.aTV()) {
                    this.eqs.aTW();
                }
                baseActivity = this.eqs.dke;
                linkedList = this.eqs.chosedFiles;
                ((WriteActivity) baseActivity).p(linkedList);
                kVar2 = this.eqs.asQ;
                kVar2.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
            }
        }
    }
}
