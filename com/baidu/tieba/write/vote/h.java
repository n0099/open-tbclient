package com.baidu.tieba.write.vote;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g dWd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.dWd = gVar;
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
        imageView = this.dWd.dVX;
        if (view != imageView) {
            imageView2 = this.dWd.dVZ;
            if (view == imageView2) {
                bVar = this.dWd.dWc;
                i = this.dWd.mId;
                bVar.os(i);
            }
        } else if (this.dWd.aLg()) {
            bVar3 = this.dWd.dWc;
            i3 = this.dWd.mId;
            imageFileInfo = this.dWd.dWa;
            bVar3.Q(i3, imageFileInfo.getFilePath());
        } else {
            bVar2 = this.dWd.dWc;
            i2 = this.dWd.mId;
            bVar2.or(i2);
        }
    }
}
