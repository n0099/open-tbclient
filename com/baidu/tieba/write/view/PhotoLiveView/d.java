package com.baidu.tieba.write.view.PhotoLiveView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.r;
import com.baidu.tieba.write.write.WriteActivity;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    private final /* synthetic */ ViewGroup awd;
    final /* synthetic */ a gms;
    private final /* synthetic */ boolean gmt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, ViewGroup viewGroup, boolean z) {
        this.gms = aVar;
        this.awd = viewGroup;
        this.gmt = z;
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
        int indexOfChild = this.awd.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (this.gmt) {
                baseActivity2 = this.gms.bGF;
                if (baseActivity2 instanceof WriteActivity) {
                    linkedList2 = this.gms.chosedFiles;
                    if (linkedList2 != null) {
                        linkedList4 = this.gms.chosedFiles;
                        if (linkedList4.size() > 0) {
                            linkedList5 = this.gms.chosedFiles;
                            linkedList6 = this.gms.chosedFiles;
                            linkedList5.remove(linkedList6.size() - 1);
                        }
                    }
                    baseActivity3 = this.gms.bGF;
                    linkedList3 = this.gms.chosedFiles;
                    ((WriteActivity) baseActivity3).o(linkedList3);
                    baseActivity4 = this.gms.bGF;
                    ((WriteActivity) baseActivity4).d((com.baidu.tbadk.editortools.a) null);
                    return;
                }
            }
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.gms.getItem(indexOfChild);
            if (imageFileInfo == null) {
                z = false;
            } else {
                File file = new File(imageFileInfo.getFilePath());
                z = file.exists() && file.length() != 0;
            }
            if (!z) {
                context = this.gms.mContext;
                k.d(context, r.j.editor_mutiiamge_image_error);
                return;
            }
            lVar = this.gms.aup;
            if (lVar != null) {
                if (this.gms.bvw()) {
                    this.gms.bvx();
                }
                baseActivity = this.gms.bGF;
                linkedList = this.gms.chosedFiles;
                ((WriteActivity) baseActivity).o(linkedList);
                lVar2 = this.gms.aup;
                lVar2.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
            }
        }
    }
}
