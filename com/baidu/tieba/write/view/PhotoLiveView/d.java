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
    private final /* synthetic */ ViewGroup avj;
    final /* synthetic */ a geO;
    private final /* synthetic */ boolean geP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, ViewGroup viewGroup, boolean z) {
        this.geO = aVar;
        this.avj = viewGroup;
        this.geP = z;
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
        int indexOfChild = this.avj.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (this.geP) {
                baseActivity2 = this.geO.bDL;
                if (baseActivity2 instanceof WriteActivity) {
                    linkedList2 = this.geO.chosedFiles;
                    if (linkedList2 != null) {
                        linkedList4 = this.geO.chosedFiles;
                        if (linkedList4.size() > 0) {
                            linkedList5 = this.geO.chosedFiles;
                            linkedList6 = this.geO.chosedFiles;
                            linkedList5.remove(linkedList6.size() - 1);
                        }
                    }
                    baseActivity3 = this.geO.bDL;
                    linkedList3 = this.geO.chosedFiles;
                    ((WriteActivity) baseActivity3).o(linkedList3);
                    baseActivity4 = this.geO.bDL;
                    ((WriteActivity) baseActivity4).d((com.baidu.tbadk.editortools.a) null);
                    return;
                }
            }
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.geO.getItem(indexOfChild);
            if (imageFileInfo == null) {
                z = false;
            } else {
                File file = new File(imageFileInfo.getFilePath());
                z = file.exists() && file.length() != 0;
            }
            if (!z) {
                context = this.geO.mContext;
                k.d(context, r.j.editor_mutiiamge_image_error);
                return;
            }
            lVar = this.geO.atv;
            if (lVar != null) {
                if (this.geO.btb()) {
                    this.geO.btc();
                }
                baseActivity = this.geO.bDL;
                linkedList = this.geO.chosedFiles;
                ((WriteActivity) baseActivity).o(linkedList);
                lVar2 = this.geO.atv;
                lVar2.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
            }
        }
    }
}
