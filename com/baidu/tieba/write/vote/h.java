package com.baidu.tieba.write.vote;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g dpB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.dpB = gVar;
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
        imageView = this.dpB.dpv;
        if (view != imageView) {
            imageView2 = this.dpB.dpx;
            if (view == imageView2) {
                bVar = this.dpB.dpA;
                i = this.dpB.mId;
                bVar.mo(i);
            }
        } else if (this.dpB.aDo()) {
            bVar3 = this.dpB.dpA;
            i3 = this.dpB.mId;
            imageFileInfo = this.dpB.dpy;
            bVar3.O(i3, imageFileInfo.getFilePath());
        } else {
            bVar2 = this.dpB.dpA;
            i2 = this.dpB.mId;
            bVar2.mn(i2);
        }
    }
}
