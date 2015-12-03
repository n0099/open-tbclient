package com.baidu.tieba.write.vote;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g dOE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.dOE = gVar;
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
        imageView = this.dOE.dOy;
        if (view != imageView) {
            imageView2 = this.dOE.dOA;
            if (view == imageView2) {
                bVar = this.dOE.dOD;
                i = this.dOE.mId;
                bVar.nA(i);
            }
        } else if (this.dOE.aIL()) {
            bVar3 = this.dOE.dOD;
            i3 = this.dOE.mId;
            imageFileInfo = this.dOE.dOB;
            bVar3.P(i3, imageFileInfo.getFilePath());
        } else {
            bVar2 = this.dOE.dOD;
            i2 = this.dOE.mId;
            bVar2.nz(i2);
        }
    }
}
