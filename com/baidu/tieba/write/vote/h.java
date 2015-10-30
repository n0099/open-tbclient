package com.baidu.tieba.write.vote;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g dnM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.dnM = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        ImageView imageView2;
        b bVar;
        int i;
        b bVar2;
        int i2;
        b bVar3;
        int i3;
        ImageFileInfo imageFileInfo;
        imageView = this.dnM.dnG;
        if (view != imageView) {
            imageView2 = this.dnM.dnI;
            if (view == imageView2) {
                bVar = this.dnM.dnL;
                i = this.dnM.mId;
                bVar.ma(i);
            }
        } else if (this.dnM.aCw()) {
            bVar3 = this.dnM.dnL;
            i3 = this.dnM.mId;
            imageFileInfo = this.dnM.dnJ;
            bVar3.N(i3, imageFileInfo.getFilePath());
        } else {
            bVar2 = this.dnM.dnL;
            i2 = this.dnM.mId;
            bVar2.lZ(i2);
        }
    }
}
