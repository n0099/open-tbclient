package com.baidu.tieba.write.vote;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g eqW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.eqW = gVar;
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
        imageView = this.eqW.eqQ;
        if (view != imageView) {
            imageView2 = this.eqW.eqS;
            if (view == imageView2) {
                bVar = this.eqW.eqV;
                i = this.eqW.mId;
                bVar.pN(i);
            }
        } else if (this.eqW.aUb()) {
            bVar3 = this.eqW.eqV;
            i3 = this.eqW.mId;
            imageFileInfo = this.eqW.eqT;
            bVar3.T(i3, imageFileInfo.getFilePath());
        } else {
            bVar2 = this.eqW.eqV;
            i2 = this.eqW.mId;
            bVar2.pM(i2);
        }
    }
}
