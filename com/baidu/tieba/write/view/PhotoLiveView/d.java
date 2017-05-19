package com.baidu.tieba.write.view.PhotoLiveView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
import com.baidu.tieba.write.write.WriteActivity;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    private final /* synthetic */ ViewGroup aAq;
    final /* synthetic */ a fPT;
    private final /* synthetic */ boolean fPU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, ViewGroup viewGroup, boolean z) {
        this.fPT = aVar;
        this.aAq = viewGroup;
        this.fPU = z;
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
        int indexOfChild = this.aAq.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (this.fPU) {
                baseActivity2 = this.fPT.mBaseActivity;
                if (baseActivity2 instanceof WriteActivity) {
                    linkedList2 = this.fPT.chosedFiles;
                    if (linkedList2 != null) {
                        linkedList4 = this.fPT.chosedFiles;
                        if (linkedList4.size() > 0) {
                            linkedList5 = this.fPT.chosedFiles;
                            linkedList6 = this.fPT.chosedFiles;
                            linkedList5.remove(linkedList6.size() - 1);
                        }
                    }
                    baseActivity3 = this.fPT.mBaseActivity;
                    linkedList3 = this.fPT.chosedFiles;
                    ((WriteActivity) baseActivity3).o(linkedList3);
                    baseActivity4 = this.fPT.mBaseActivity;
                    ((WriteActivity) baseActivity4).d((com.baidu.tbadk.editortools.a) null);
                    return;
                }
            }
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.fPT.getItem(indexOfChild);
            if (imageFileInfo == null) {
                z = false;
            } else {
                File file = new File(imageFileInfo.getFilePath());
                z = file.exists() && file.length() != 0;
            }
            if (!z) {
                context = this.fPT.mContext;
                k.f(context, w.l.editor_mutiiamge_image_error);
                return;
            }
            jVar = this.fPT.ayJ;
            if (jVar != null) {
                if (this.fPT.bns()) {
                    this.fPT.bnt();
                }
                baseActivity = this.fPT.mBaseActivity;
                linkedList = this.fPT.chosedFiles;
                ((WriteActivity) baseActivity).o(linkedList);
                jVar2 = this.fPT.ayJ;
                jVar2.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
            }
        }
    }
}
