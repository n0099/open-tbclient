package com.baidu.tieba.write.vote;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g dnm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.dnm = gVar;
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
        imageView = this.dnm.dng;
        if (view != imageView) {
            imageView2 = this.dnm.dni;
            if (view == imageView2) {
                bVar = this.dnm.dnl;
                i = this.dnm.mId;
                bVar.lY(i);
            }
        } else if (this.dnm.aCq()) {
            bVar3 = this.dnm.dnl;
            i3 = this.dnm.mId;
            imageFileInfo = this.dnm.dnj;
            bVar3.N(i3, imageFileInfo.getFilePath());
        } else {
            bVar2 = this.dnm.dnl;
            i2 = this.dnm.mId;
            bVar2.lX(i2);
        }
    }
}
