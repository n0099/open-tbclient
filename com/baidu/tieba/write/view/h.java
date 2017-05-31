package com.baidu.tieba.write.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.y;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
import com.baidu.tieba.write.view.NewFrameMultiImgToolView;
import java.io.File;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    private final /* synthetic */ ViewGroup aAc;
    final /* synthetic */ NewFrameMultiImgToolView.b fXL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(NewFrameMultiImgToolView.b bVar, ViewGroup viewGroup) {
        this.fXL = bVar;
        this.aAc = viewGroup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        y yVar;
        y yVar2;
        Context context;
        int indexOfChild = this.aAc.indexOfChild(view);
        if (indexOfChild >= 0) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.fXL.getItem(indexOfChild);
            if (imageFileInfo == null) {
                z = false;
            } else {
                z = new File(imageFileInfo.getFilePath()).exists();
            }
            if (!z) {
                context = this.fXL.mContext;
                com.baidu.adp.lib.util.k.f(context, w.l.editor_mutiiamge_image_error);
                return;
            }
            yVar = this.fXL.azY;
            if (yVar != null) {
                yVar2 = this.fXL.azY;
                yVar2.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
            }
        }
    }
}
